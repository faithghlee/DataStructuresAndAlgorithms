//**************************************************************
// testCircularArray.java
// Faith Lee 
// COMP 2231 Assignment 2 Question 3
// 
// This code tests the functions toString, isEmpty and size() of the circular Array along with the double-ended queue functionalities. 
//**************************************************************

import jsjf.CircularArrayQueue;
import jsjf.exceptions.*;

public class testCircularArray {
	
	public static void main(String args[]) {
		
		//Test Double Ended Dequeue Implementation 
		System.out.println("Tests for Double Ended Circular Array ");
		CircularArrayQueue<Integer> testQueue3 = new CircularArrayQueue<>(5); 
		//
		System.out.println(testQueue3);
		testQueue3.enqueueFront(1);
		System.out.println(testQueue3);
		testQueue3.enqueueBack(3);
		testQueue3.enqueueFront(5);
		testQueue3.enqueueBack(7);
		testQueue3.enqueueFront(9);
		System.out.println(testQueue3);
		
		// Checking first(), last(), size(), dequeueFront(), dequeueBack() and isEmpty() 
		System.out.println("Dequeuing the array"); 
		System.out.println("DequeueBack : " + testQueue3.dequeueBack());
		System.out.println("DequeueFront : " + testQueue3.dequeueFront());
		System.out.println("Current Size :" + testQueue3.size());
		System.out.println(testQueue3.dequeueBack());
		
		System.out.println("Dequeue Front : " + testQueue3.dequeueFront());
		System.out.println("Dequeue Front : " + testQueue3.dequeueFront());
		System.out.println(testQueue3);	
		System.out.println("Queue should be empty"); 
		System.out.println("Current size : " + testQueue3.size());
		System.out.println("Test if Empty : " + testQueue3.isEmpty());
		System.out.println("Queue is empty and we start from index 0 again"); 
		testQueue3.enqueueBack(3);
		System.out.println("Inserted one element and inserted element is at index 0 \n"+ testQueue3);
	}
	

}
