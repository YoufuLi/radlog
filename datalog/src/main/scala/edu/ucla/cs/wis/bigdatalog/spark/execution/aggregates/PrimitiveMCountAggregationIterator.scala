/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.ucla.cs.wis.bigdatalog.spark.execution.aggregates

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap

import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.codegen.{BufferHolder, UnsafeRowWriter}
import org.apache.spark.sql.datalog.{Convert, PartitionDataKeeper}

// scalastyle:off line.size.limit
/**
 * AggregationIterator specifically designed for MCount.
 *
 * We support number of input columns 3 or 4. The column layout will be in one of the two cases:
 * Case 1 - 0:   Grouping  1: Sub  2: Aggr   (Grouping & Sub value is limited to 0 - 2147483647)
 * Case 2 - 0,1: Grouping  2: Sub  3: Aggr   (Grouping & Sub value is limited to 0 - 32767)
 *
 * The Grouping & Sub datatype should be Integer, and aggregation value is also Integer type.
 *
 * TODO: use Byte2LongOpenHashMap
 */
class PrimitiveMCountAggregationIterator(
    name: String,
    mAggr: MonotonicAggregate,
    inputIter: Iterator[InternalRow],
    // numOutputRows: SQLMetric,
    partitionIndex: Int,
    create: Boolean)
  extends Iterator[UnsafeRow] with AggrIter with Logging {

  private val resultExpressions = mAggr.resultExpressions
  private val aggrFunc = mAggr.aggregateExpressions.head.aggregateFunction

  if (!aggrFunc.isInstanceOf[MCount]) throw new RuntimeException(s"aggrFunc: $aggrFunc is not MCount.")

  // victor: HACK - we store and fetch the aggregation map from dataKeeper (shared by all tasks)
  private val dataKeeper = PartitionDataKeeper.get(name)
  private var storedMaps = dataKeeper.getAggregationMap(partitionIndex)

  if (create) {
    logInfo(s"Partition: $partitionIndex - create AggregationMap")
    if (storedMaps != null) {
      throw new RuntimeException("Partition: " + partitionIndex + " sharedAggregationMap already set!")
    }
  } else {
    logInfo(s"Partition: $partitionIndex - reuse existing AggregationMap")
    if (storedMaps == null) {
      throw new RuntimeException("Partition: " + partitionIndex + " sharedAggregationMap is null!")
    }
  }

  if (storedMaps == null) {
    storedMaps = (new Long2IntOpenHashMap(), new Long2IntOpenHashMap())
    dataKeeper.setAggregationMap(partitionIndex, storedMaps)
  }

  val hashMap = storedMaps.asInstanceOf[(Long2IntOpenHashMap, _)]._1
  val subKeyMap = storedMaps.asInstanceOf[(_, Long2IntOpenHashMap)]._2

  override val before: Int = hashMap.size()

  // input has one more column (occurrence variable) than output
  val inputLen = mAggr.output.length + 1
  if (inputLen < 3) throw new RuntimeException("inputLen is less than 3.")

  // The function used to read and process input rows.
  def processInputs(): Long2IntOpenHashMap = {
    val deltaMap = new Long2IntOpenHashMap()

    var i = 0

    while (inputIter.hasNext) {
      val row = inputIter.next()

      val groupingKey: Long = inputLen match {
        case 3 => row.getInt(0) // 0: Grouping 1: Sub 2: Aggr
        case 4 => Convert.intsToLong(row.getInt(0), row.getInt(1)) // 0,1: Grouping 2: Sub 3: Aggr
        case _ => throw new RuntimeException(s"inputLen $inputLen is not supported.")
      }

      val groupingKeyWithSub: Long = inputLen match {
        case 3 => Convert.intsToLong(row.getInt(0), row.getInt(1))
        // must use the same accessor (getInt) as groupingKey
        case 4 => Convert.shortsToLong(Array(row.getInt(0), row.getInt(1), row.getInt(2), 0))
        case _ => throw new RuntimeException(s"inputLen $inputLen is not supported.")
      }

      val v: Int = row.getInt(inputLen - 1)

      val prevAggr = if (hashMap.containsKey(groupingKey)) {
        hashMap.get(groupingKey)
      } else {
        hashMap.put(groupingKey, 0)
        0
      }

      val prevSubAggr = if (subKeyMap.containsKey(groupingKeyWithSub)) {
        subKeyMap.get(groupingKeyWithSub)
      } else {
        subKeyMap.put(groupingKeyWithSub, 0)
        0
      }

      val deltaV = if (v > prevSubAggr) v - prevSubAggr else 0
      if (deltaV > 0) {
        subKeyMap.put(groupingKeyWithSub, v)

        val newAggr = prevAggr + deltaV
        hashMap.put(groupingKey, newAggr)
        deltaMap.put(groupingKey, newAggr)
      }

      i += 1
    }

    logInfo(s"inputIter size: $i")
    deltaMap
  }

  /**
   * Start processing input rows.
   */
  private val deltaMap = processInputs()

  override val after: Int = hashMap.size()

  override val deltaSize: Int = deltaMap.size()

  ///////////////////////////////////////////////////////////////////////////
  // Part 7: Iterator's public methods.
  ///////////////////////////////////////////////////////////////////////////

  val rawIter = deltaMap.long2IntEntrySet().fastIterator()
  val numFields = inputLen - 1 // victor: as we don't need occurrence variable in output row

  val unsafeRow = new UnsafeRow(numFields)
  val bufferHolder = new BufferHolder(unsafeRow)
  val unsafeRowWriter = new UnsafeRowWriter(bufferHolder, numFields)

  override final def hasNext(): Boolean = {
    rawIter.hasNext
  }

  override final def next(): UnsafeRow = {
    bufferHolder.reset()
    val next = rawIter.next()
    val ints = new Array[Int](2)

    numFields match {
      case 2 => // One Grouping Column
        unsafeRowWriter.write(0, next.getLongKey.asInstanceOf[Int])
        unsafeRowWriter.write(1, next.getIntValue)
      case 3 => // Two Grouping Columns
        Convert.longToInts(next.getLongKey, ints)
        unsafeRowWriter.write(0, ints(0))
        unsafeRowWriter.write(1, ints(1))
        unsafeRowWriter.write(2, next.getIntValue)
      case _ =>
        throw new RuntimeException(s"Output row length: $numFields is not supported.")
    }

    unsafeRow.setTotalSize(bufferHolder.totalSize())
    unsafeRow
  }
}

class Long2IntAggregationMapIterator(name: String, splitIdx: Int, rowLen: Int) extends Iterator[UnsafeRow] with Logging {
  val map = PartitionDataKeeper.get(name).getAggregationMap(splitIdx).asInstanceOf[(Long2IntOpenHashMap, _)]._1
  val rawIter = map.long2IntEntrySet().fastIterator()
  val numFields = rowLen

  val unsafeRow = new UnsafeRow(numFields)
  val bufferHolder = new BufferHolder(unsafeRow)
  val unsafeRowWriter = new UnsafeRowWriter(bufferHolder, numFields)

  override final def hasNext(): Boolean = {
    rawIter.hasNext
  }

  override final def next(): UnsafeRow = {
    bufferHolder.reset()
    val next = rawIter.next()
    val ints = new Array[Int](2)

    numFields match {
      case 2 => // One Grouping Column
        unsafeRowWriter.write(0, next.getLongKey.asInstanceOf[Int])
        unsafeRowWriter.write(1, next.getIntValue)
      case 3 => // Two Grouping Columns
        Convert.longToInts(next.getLongKey, ints)
        unsafeRowWriter.write(0, ints(0))
        unsafeRowWriter.write(1, ints(1))
        unsafeRowWriter.write(2, next.getIntValue)
      case _ =>
        throw new RuntimeException(s"Output row length: $numFields is not supported.")
    }

    unsafeRow.setTotalSize(bufferHolder.totalSize())

    // println("$$ " + unsafeRow)
    unsafeRow
  }
}
