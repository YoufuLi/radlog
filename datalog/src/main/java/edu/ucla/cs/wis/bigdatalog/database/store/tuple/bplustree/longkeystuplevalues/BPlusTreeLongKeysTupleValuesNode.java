package edu.ucla.cs.wis.bigdatalog.database.store.tuple.bplustree.longkeystuplevalues;

import java.io.Serializable;
import edu.ucla.cs.wis.bigdatalog.common.Pair;
import edu.ucla.cs.wis.bigdatalog.database.Tuple;
import edu.ucla.cs.wis.bigdatalog.database.store.bplustree.BPlusTreeNode;
import edu.ucla.cs.wis.bigdatalog.database.store.tuple.bplustree.BPlusTreeTupleValuesGetResult;
import edu.ucla.cs.wis.bigdatalog.measurement.MemoryMeasurement;

public class BPlusTreeLongKeysTupleValuesNode
	extends BPlusTreeNode<BPlusTreeLongKeysTupleValuesPage, BPlusTreeLongKeysTupleValuesLeaf> 
	implements BPlusTreeLongKeysTupleValuesPage, Serializable {
	private static final long serialVersionUID = 1L;

	protected long[] keys;

	public BPlusTreeLongKeysTupleValuesNode() { super(); }
	
	public BPlusTreeLongKeysTupleValuesNode(int nodeSize) {
		super(nodeSize, 8);
				
		this.keys = new long[this.numberOfKeys]; // M-1 keys
		this.children = new BPlusTreeLongKeysTupleValuesPage[this.getBranchingFactor()]; // M children
		this.numberOfEntries = 0;
	}

	@Override
	public long getLeftMostLeafKey() {
		return this.children[0].getLeftMostLeafKey();
	}

	@Override
	public Pair<BPlusTreeLongKeysTupleValuesPage, Boolean> insert(long key, Tuple tuple) {
		int insertAt = 0;

		for (insertAt = 0; insertAt < (this.highWaterMark - 1); insertAt++) {
			if (key < this.keys[insertAt]) 
				break;
		}

		Pair<BPlusTreeLongKeysTupleValuesPage, Boolean> retvalPair = this.children[insertAt].insert(key, tuple);
		if (retvalPair.getSecond())
			this.numberOfEntries++;
		
		if (retvalPair.getFirst() == null)
			return retvalPair;

		// shift right for insertion to the left
		if ((insertAt + 1) < this.highWaterMark)
			System.arraycopy(this.children, insertAt + 1, this.children, insertAt + 2, this.highWaterMark - (insertAt + 1));				
		// shift right for insertion to the left
		
		if (insertAt < (this.highWaterMark - 1)) 
			System.arraycopy(this.keys, insertAt, this.keys, (insertAt + 1), (this.highWaterMark - 1 - insertAt));
		
		// we are inserting the page with the right 1/2 of the values from the previous full page (that was split)
		// therefore, it goes to the right of where we inserted
		insertAt++;
		this.children[insertAt] = retvalPair.getFirst(); 
		
		this.keys[insertAt - 1] = this.children[insertAt].getLeftMostLeafKey();		
		
		this.highWaterMark++;

		if (this.hasOverflow())
			return new Pair<>(this.split(), retvalPair.getSecond());
			
		return new Pair<>(null, retvalPair.getSecond());		
	}

	private BPlusTreeLongKeysTupleValuesPage split() {
		BPlusTreeLongKeysTupleValuesNode rightNode = new BPlusTreeLongKeysTupleValuesNode(this.nodeSize);
		// give the right 1/2 of the children to the new node
		int i;
		int splitPoint = (int) Math.ceil(((double)this.children.length) / 2);
		int numberToMove = this.children.length - splitPoint;
		
		System.arraycopy(this.children, splitPoint, rightNode.children, 0, numberToMove);
		
		for (i = 0; i < numberToMove; i++) {
			this.children[splitPoint + i] = null;
			this.keys[(splitPoint + i - 1)] = 0;
			
			if (i > 0)
				rightNode.keys[i - 1] = rightNode.children[i].getLeftMostLeafKey();
			
			this.highWaterMark--;
		}
		
		rightNode.highWaterMark = i;
		return rightNode;
	}
	
	@Override
	public void get(long key, BPlusTreeTupleValuesGetResult result) {
		for (int i = 0; i < (this.highWaterMark - 1); i++) {
			if (key < this.keys[i]) {
				this.children[i].get(key, result);
				return;
			}
		}

		this.children[this.highWaterMark - 1].get(key, result);
	}

	@Override
	public boolean delete(long key) {
		int deleteAt = 0;
		for (deleteAt = 0; deleteAt < (this.highWaterMark - 1); deleteAt++) {
			if (key < this.keys[deleteAt])
				break;
		}
		
		boolean status = this.children[deleteAt].delete(key);
		if (status) {
			this.numberOfEntries--;
			if (this.children[deleteAt].isEmpty()) {
				// remove child and key and shift remaining children 
				for (int j = deleteAt; j < this.highWaterMark; j++)
					this.children[j] = this.children[j + 1];
	
				if (deleteAt < (this.highWaterMark - 1))
					System.arraycopy(this.keys, (deleteAt + 1), this.keys, deleteAt, (this.highWaterMark - (deleteAt+1)));
	
				this.highWaterMark--;
			}			
		}
		return status;
	}
	
	@Override
	public void deleteAll() {
		for (int i = 0; i < this.highWaterMark; i++)
			this.children[i].deleteAll();
		
		this.keys = null;
		this.children = null;
		this.numberOfEntries = 0;
		this.highWaterMark = 0;			
	}
		
	@Override
	public String toString(int indent) {
		StringBuilder output = new StringBuilder();
		String buffer = "";
		for (int i = 0; i < indent; i++) 
			buffer += " ";
		
		output.append(buffer + "# of entries | Max # of entries: " + this.highWaterMark + " | " + this.children.length + "\n");
		output.append(buffer + "IsEmpty: " + this.isEmpty() + ", IsOverflow: " + this.hasOverflow() + "\n");
		output.append(buffer + "Keys: [");
		for (int i = 0; i < this.keys.length; i++) {
			if (i > 0) output.append(", ");
			output.append(this.keys[i]);
		}
		output.append("]\n");
		output.append(buffer + "Entries:\n");
		for (int i = 0; i < this.highWaterMark; i++)
			output.append(buffer + this.children[i].toString(indent + 2) + "\n");
				
		return output.toString();
	}
	
	public MemoryMeasurement getSizeOf() {
		int used = 0;
		int allocated = 0;
		if (this.keys != null) {
			used += this.highWaterMark * 8;
			allocated += this.keys.length * 8;
		}
		
		if (this.children != null) {
			MemoryMeasurement sizes;
			for (int i = 0; i < this.highWaterMark; i++) {
				sizes = this.children[i].getSizeOf();
				used += sizes.getUsed();
				allocated += sizes.getAllocated();
			}
		}
		return new MemoryMeasurement(used, allocated);
	}
}