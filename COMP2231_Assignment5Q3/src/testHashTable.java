//**************************************************************
// testHashTable.java 
// Faith Lee T00673968
//
// COMP 2231 Assignment 5 Question 3
//
// In this code, we aim to test the functions of the hashtable implemented in the HashTable.java. 
//**************************************************************
import hashT.*; 
import java.util.*; 
public class testHashTable{
	
	public static KeyValueEntry generateKV() {
		Random rnd = new Random(); 
		int ssn = 100000000 + rnd.nextInt(900000000);
		String name = generateRandomChars(); 
		
		KeyValueEntry kv = new KeyValueEntry(Integer.toString(ssn), name); 
		return kv;
		
	}
	public static String generateRandomChars() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 3; i++) { //for simplicity all names will be 3 char long 
	    	
	        sb.append(chars.charAt(random.nextInt(chars
	                .length())));
	    }

	    return sb.toString();
	}

	
	
	public static void main(String args[]) {
		
		HashTable testTable = new HashTable(); 
		System.out.println("Check the size function : " + testTable.size()); 
	
		// create fake entries 
		KeyValueEntry test1 = new KeyValueEntry("123456789", "ABC"); 
		// 6789 mod 31 = 0 --> this entry should be at position 0 
		
		//Check 
		testTable.put(test1);
		
		System.out.println("this SSN should be at position 0 : " + testTable.findPosition("123456789")); 
		//test for secondary hashing handling 
		
		KeyValueEntry test2 = new KeyValueEntry("321456789", "ACC"); 
		//this entry should be position at (6789 mod 31 + 321 mod 31) % 31 = 11
		
		testTable.put(test2); 
		System.out.println("test2 SSN should be at position 11 : " + testTable.findPosition("321456789")); 
		
		//test removing an element 
		System.out.println("test if table cnontains SSN 123456789 "+ testTable.contains("123456789"));
		
		testTable.delete("123456789");
		System.out.println("test if table cnontains SSN 123456789 after removing  should be false : "+ testTable.contains("123456789"));
		
		testTable.delete("321456789");
		System.out.println("test if table cnontains SSN 321456789 after removing should be false : "+ testTable.contains("321456789"));
		//generate 23 elements to test dynamic resizing function 
		for (int i = 0; i < 24; i ++ ) {
			KeyValueEntry kv = generateKV(); 
			System.out.println("Random Entry " + "SSN " + kv.getSSN() + " name " + kv.getName());
			testTable.put(kv);
			
		}
		//see if capacity is updated; 
		System.out.println("After having 24 elements in the table which is over the threshold new capacity is 31 x 2 : " + testTable.returnCapacity());
		System.out.println("Current size of the hashtable : " + testTable.size());
		
		
		
		
	}

}
