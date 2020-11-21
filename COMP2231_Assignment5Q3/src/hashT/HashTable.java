//**************************************************************
// HashTable.java 
// Faith Lee T00673968
//
// COMP 2231 Assignment 5 Question 3
//
// In this code, the HashTable structure is implemented with default capacity of 31 and load factor of 0.80
//**************************************************************
package hashT;
import java.util.*; 

/**
 * Implement a dynamically resizable hash table 
 * @author faithlee
 *
 */


public class HashTable {
	
	private int DEFAULT_CAPACITY = 31; 
	private double LOAD_FACTOR = 0.80; 
	private KeyValueEntry[] entries; 
	private int elementCount =0;  //take notice when we resize... 
	//constructors 
	
	public HashTable() {
		
		//entries = new ArrayList<KeyValueEntry>(DEFAULT_CAPACITY); 
		entries = new KeyValueEntry[DEFAULT_CAPACITY]; 
		
		
	}
	
	public HashTable(double loadFactor) {
		
		//entries = new ArrayList<KeyValueEntry>(DEFAULT_CAPACITY); 
		entries = new KeyValueEntry[DEFAULT_CAPACITY]; 
		this.LOAD_FACTOR = loadFactor; 
		
	}
	
	public HashTable(int capacity, double loadFactor) {
		this.DEFAULT_CAPACITY = capacity; 
		
		entries = new KeyValueEntry[capacity]; 
		this.LOAD_FACTOR = loadFactor; 
	}
	
	
	/*
	 * Returns the number of elements in the hashTable 
	 */
	public int size() {
		return elementCount; 
		
	}
	/**
	 * 
	 * @return number of elements the hashTable can hold 
	 */
	public int returnCapacity() {
		return DEFAULT_CAPACITY; 
	}
	/** @param KeyValueEntry object 
	 * 
	 * Inserts the KeyValueEntry into our hashTable 
	 */
	public void put(KeyValueEntry kv) {
		//if position is available then 
		int position = findOpenPosition(kv.getSSN(), entries); // position to insert into hashtable 
		
		if (position!=-1) {
			
			entries[position] = kv;
			elementCount++; 
			resize(); 
			
		} else {
			System.out.println("Element not added"); 
		}
		
	}
	/*
	 * Returns the value based on the key inserted ie. returns the name based on the SSN number 
	 */
	public String getElementByKey(String ssn) {
		
		int position = findPosition(ssn); 
		if (position!=-1) {
			return entries[position].getName();
			//return entries.get(position).getName();
		}
		System.out.println("This SSN does not exist in the table");
		return ""; 
	}
	/** @Param String key we are looking for
	 * @returns true if table contains this key 
	 */
	
	public boolean contains(String key) {
		

		
		return (findPosition(key)!=-1); 
	}
	/** @param String social security number 
	 * Deletes a keyvalue pair from the table based on the hashCode 
	 */
	public void delete(String ssn) {
		
		int position = findPosition(ssn); 
		if (position!=-1) {
			entries[position] = null; 
			System.out.println("deleted!");
			elementCount--;
		}
		
	}
	/*
	 * Deletes the entire hashtable 
	 */
	public void deleteTable() {
		entries = null; 
		elementCount = 0; 
	}
	/*
	 * Returns the threshold allowed before resizing the array 
	 */
	public int threshold() {
		
		return (int) (LOAD_FACTOR*DEFAULT_CAPACITY); 
	}
	/* This method is private as it should not be accessible to users 
	 * resize the table once the threshold of elements has reached. 
	 */
	private void resize() {

		if (size()>=threshold()) {
			
			//create an array two times larger than the current one 
			int newCapacity = 2*entries.length;
			KeyValueEntry[] updatedEntries = new KeyValueEntry[2*entries.length]; 
			
			//Rehash and find new position opy the elements over to their new positions in the new table 
			DEFAULT_CAPACITY = newCapacity; 
			 
			for (int i = 0; i < entries.length; i++) {
				//check if position in the new hashtable is occupied 
				if (entries[i]!=null) {
					int newPosition = findOpenPosition(entries[i].getSSN(), updatedEntries); 
					
					updatedEntries[newPosition] = entries[i];
					
				}
				

			}
			
			//Return original table 
			entries = updatedEntries; 
			
			
			
			
			
		}
		
	}
	/**
	 * find the position of the element in the table based on the key (ssn) supplied 
	 * @param String ssn
	 * @return position if found matching the key, or -1 otherwise 
	 */
	public int findPosition(String ssn) {
		int primaryHash = primaryHashFunction(ssn); 
		int secondaryHash = secondaryHashFunction(ssn);
		
		if (entries[primaryHash]!=null && entries[primaryHash].getSSN().equals(ssn)) {
			return primaryHash; 
			
		} 
		// if primaryhash position is null or !=ssn; we search the primary+secondaryhash positions 
		
		int i = 1; //counter for secondary hash function 
		
		while (i <= DEFAULT_CAPACITY) {
			int nextPosition = (primaryHash + i*secondaryHash) % DEFAULT_CAPACITY;
			if (entries[nextPosition]!= null && entries[nextPosition].getSSN().equals(ssn)) {
				return nextPosition; 
				
			} else {
				i += 1; 
			}
			
		}
		return -1; 
		
	}
	/**
	 * find open position in the table based on the SSN supplied 
	 * @param String ssn
	 * @return int open position for this ssn 
	 */
	public int findOpenPosition(String ssn, KeyValueEntry[] entries) {
		int primaryHash = primaryHashFunction(ssn); 
		
		int secondaryHash = secondaryHashFunction(ssn);
		
		if (entries[primaryHash]== null) {
			return primaryHash; 
			
		} 
		// if primaryhash position is null or !=ssn; we search the primary+secondaryhash positions 
		 
		int i = 1; //counter for secondary hash function 
		
		while (i <= DEFAULT_CAPACITY) {
			int nextPosition = (primaryHash + i*secondaryHash) % DEFAULT_CAPACITY;
			if (entries[nextPosition]== null) {
				return nextPosition; 
				
			} else {
				i += 1; 
			}
			
		}
		return -1; 
		
	}

	/**
	 * Primary hash function extraction method with last four digits 
	 * @param ssn
	 * @return primary hashCode  
	 */
	public int primaryHashFunction(String ssn) {
		
		return Integer.parseInt(ssn.substring(5)) % DEFAULT_CAPACITY; 
		
	}
	/**
	 * 
	 * @param ssn
	 * @return secondary hashCode 
	 */
	public int secondaryHashFunction(String ssn) {
		return Integer.parseInt(ssn.substring(0,3)) % DEFAULT_CAPACITY; 
	}
	//we need to double the size of the array if the number of elements is greater than the threshold. 
	
	
}
