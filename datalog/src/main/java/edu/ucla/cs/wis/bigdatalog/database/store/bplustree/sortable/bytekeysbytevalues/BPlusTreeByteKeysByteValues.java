package edu.ucla.cs.wis.bigdatalog.database.store.bplustree.sortable.bytekeysbytevalues;

import java.io.Serializable;

import edu.ucla.cs.wis.bigdatalog.database.Tuple;
import edu.ucla.cs.wis.bigdatalog.database.store.bplustree.BPlusTreeOperationStatus;
import edu.ucla.cs.wis.bigdatalog.database.store.bplustree.BPlusTreeStoreValueStructure;
import edu.ucla.cs.wis.bigdatalog.database.store.bplustree.rangesearch.RangeSearchResult;
import edu.ucla.cs.wis.bigdatalog.database.store.bplustree.rangesearch.RangeSearchableStorageStructure;
import edu.ucla.cs.wis.bigdatalog.database.store.changetracking.ChangeTrackingStore;
import edu.ucla.cs.wis.bigdatalog.database.store.tuple.bplustree.TupleBPlusTreeStoreStructure;
import edu.ucla.cs.wis.bigdatalog.database.type.DbTypeBase;
import edu.ucla.cs.wis.bigdatalog.database.type.TypeManager;
import edu.ucla.cs.wis.bigdatalog.exception.DatabaseException;
import edu.ucla.cs.wis.bigdatalog.type.DataType;

// this version of the b+tree could be used with:
// 1) unordered heap stores as an index
// 2) as storage - the first column is the key and the remaining n-1 columns are the data

// THIS CLASS SHOULD ONLY BE USED WHEN KEYS ARE UNIQUE
public class BPlusTreeByteKeysByteValues 
	extends BPlusTreeStoreValueStructure<BPlusTreeByteKeysByteValuesPage, BPlusTreeByteKeysByteValuesLeaf, BPlusTreeByteKeysByteValuesNode> 
	implements TupleBPlusTreeStoreStructure<byte[]>, ChangeTrackingStore<byte[]>, 
		RangeSearchableStorageStructure<byte[]>, Serializable {
	private static final long serialVersionUID = 1L;
	
	protected BPlusTreeByteKeysByteValuesInsertResult insertResult;
	protected BPlusTreeByteKeysByteValuesGetResultRange getResultRange;
	protected int[] keySortOrder;
	protected int[] bytesPerKeyColumn;
	
	public BPlusTreeByteKeysByteValues() { super(); }
	
	public BPlusTreeByteKeysByteValues(int nodeSize, int bytesPerKey, int bytesPerValue, int[] keyColumns, 
			int[] keySortOrder, DataType[] keyColumnTypes, int[] valueColumns, DataType[] valueColumnTypes, 
			TypeManager typeManager) {
		super(nodeSize, bytesPerKey, bytesPerValue, keyColumns, keyColumnTypes, valueColumns, valueColumnTypes, typeManager);
		this.insertResult = new BPlusTreeByteKeysByteValuesInsertResult(this.bytesPerValue);
		this.getResultRange = new BPlusTreeByteKeysByteValuesGetResultRange();
		
		if (keySortOrder == null || keySortOrder.length == 0)
			throw new DatabaseException("Sort keys and order must be provided to sort!");
		
		this.keySortOrder = keySortOrder;
		this.bytesPerKeyColumn = new int[this.keyColumns.length];
		for (int i = 0; i < this.keyColumns.length; i++)
			this.bytesPerKeyColumn[i] = this.keyColumnTypes[i].getNumberOfBytes();
		
		this.initialize();
	}

	@Override
	protected BPlusTreeByteKeysByteValuesPage allocatePage() {
		if (this.rootNode == null)
			return new BPlusTreeByteKeysByteValuesLeaf(this);
		
		return new BPlusTreeByteKeysByteValuesNode(this);
	}

	@Override
	public void insert(Tuple tuple) {
		byte[] key = this.getKey(tuple.columns);
		byte[] data = this.getBytes(tuple.columns);
		this.insert(key, data);
	}
	
	@Override
	public void insert(DbTypeBase[] keyColumns, byte[] data) {
		byte[] key = this.getKey(keyColumns);
		this.insert(key, data);
	}
	
	public byte[] insert(byte[] key, byte[] data) {
		// case 1 - room to insert in root node
		this.rootNode.insert(key, data, this.insertResult, this.typeManager);
		if (this.insertResult.status == BPlusTreeOperationStatus.NEW)			
			this.numberOfEntries++;
		
		if (this.insertResult.newPage != null) {
			// case 2 we have grow the tree as the root node was split 
			BPlusTreeByteKeysByteValuesNode newRoot = (BPlusTreeByteKeysByteValuesNode)this.allocatePage();
			newRoot.children[0] = this.rootNode;
			newRoot.children[1] = this.insertResult.newPage;
			byte[] newLeftKey = newRoot.children[1].getLeftMostLeafKey();
			System.arraycopy(newLeftKey, 0, newRoot.keys, 0, this.bytesPerKey);
			
			newRoot.highWaterMark += 2;
			this.rootNode = newRoot;
		}
		
		if (this.trackModifiedTuples)
			if (this.insertResult.status == BPlusTreeOperationStatus.NEW 
				|| this.insertResult.status == BPlusTreeOperationStatus.UPDATE)
				this.changeTracker.add(key);
			
		return this.insertResult.oldValue;
	}

	@Override
	public byte[] get(DbTypeBase[] keyColumns) {
		return this.get(this.getKey(keyColumns));
	}
		
	public byte[] get(byte[] key) {
		if (this.rootNode.isEmpty())
			return null;
		
		return this.rootNode.get(key);
	}
	
	@Override
	public boolean delete(Tuple tuple) {
		return this.delete(this.getKey(tuple.columns));
	}
	
	public boolean delete(byte[] key) {
		if (this.rootNode.isEmpty())
			return false;
		
		boolean status = this.rootNode.delete(key);
		if (status) {
			this.numberOfEntries--;
			if (this.numberOfEntries == 0) {
				this.rootNode = null;
				this.rootNode = this.allocatePage();
			}
		}
		return status;
	}

	@Override	
	public int getTuple(byte[] key, Tuple tuple) {
		byte[] value = this.rootNode.get(key);
		if (value != null) {
			int offset = 0;
			for (int i = 0; i < this.keyColumns.length; i++) {
				tuple.columns[this.keyColumns[i]] = DbTypeBase.loadFrom(this.keyColumnTypes[i], key, offset, this.typeManager);
				offset += this.keyColumnTypes[i].getNumberOfBytes();
			}

			for (int i = 0; i < this.valueColumns.length; i++) {
				tuple.columns[this.valueColumns[i]] = DbTypeBase.loadFrom(this.valueColumnTypes[i], value, offset, this.typeManager); 
				offset += this.valueColumnTypes[i].getNumberOfBytes();
			}
			
			return 1;
		}
		return 0;
	}

	@Override
	public void getTuple(byte[] startKey, byte[] endKey, RangeSearchResult result) {
		//System.out.println(Arrays.toString(startKey));
		//System.out.println(Arrays.toString(endKey));
		this.rootNode.get(startKey, endKey, this.getResultRange);
		
		result.success = this.getResultRange.success;
		if (this.getResultRange.success) {
			result.index = this.getResultRange.index;
			result.leaf = this.getResultRange.leaf;
			result.success = true;
			//System.out.println("found");
			return;
		}
		//System.out.println("not found");
		result.success = false;
	}
}
