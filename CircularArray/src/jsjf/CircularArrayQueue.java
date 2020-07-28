//**************************************************************
// CircularArray.java 
// Faith Lee
//
// COMP 2231 Assignment 2 Question 3
//
// Assignment Question:Implement a Deque using arrays. 
// Functions added isEmpty(), size() and toString(). 
// Functions added EnqueueFront, EnqueueBack, DequeueFront, DequeueBack.
// Basically, EnqueueBack and DequeueFront is the same as the enqueue and dequeue functions. 
// Added last() which checks the last element of the queue. 
//**************************************************************
package jsjf;

import jsjf.exceptions.*;

/**
 * CircularArrayQueue represents an array implementation of a queue in 
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class CircularArrayQueue<T> implements QueueADT<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue; 

	/**
	 * Creates an empty queue using the specified capacity.
	 * @param initialCapacity the initial size of the circular array queue
	 */
	public CircularArrayQueue(int initialCapacity)
	{
		front = rear =0;
		//front = rear = -1; 
		count = 0; 
		queue = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Creates an empty queue using the default capacity.
	 */
	public CircularArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	}    

	/**
	 * Adds the specified element to the rear of this queue, expanding
	 * the capacity of the queue array if necessary.
	 * @param element the element to add to the rear of the queue
	 */
	public void enqueue(T element)
	{
		if (size() == queue.length) 
			expandCapacity();

		queue[rear] = element;
		rear = (rear + 1) % queue.length;

		count++;
	}
	
	/**
	 * Adds the specified element to the rear of this queue, expanding
	 * the capacity of the queue array if necessary.
	 * @param element the element to add to the rear of the queue
	 */
	public void enqueueBack(T element)
	{
		if (size() == queue.length) 
			expandCapacity();
		//reset index if emptied.
		if (front == rear) {
			front = rear = 0; 
		}
		
		queue[rear] = element;
		//update pointer to point to next available spot to insert element 
		rear = (rear + 1) % queue.length;

		

		count++;
	}
	
	/** 
	 * Adds elements to the start of this queue
	 * @param element to be added to the start of this queue 
	 */
	public void enqueueFront(T element)
	{
		if (size() == queue.length) 
			expandCapacity();
		//Front is pointing to the current element that can be emptied, so to point to an available space we decrement front before inserting the element
		
		
		if (front == 0 ) {
			front = queue.length-1; 
		} else if (front == rear) {
			front = rear = 0; 
		} else {
			front = (front-1); 
		}
		
		queue[front] = element; 

		count++;
	}
	
	/**
	 * Creates a new array to store the contents of this queue with
	 * twice the capacity of the old one.
	 */
	private void expandCapacity()
	{
		T[] larger = (T[]) (new Object[queue.length * 2]);

		for (int scan = 0; scan < count; scan++)
		{
			larger[scan] = queue[front];
			front = (front + 1) % queue.length;
		}

		front = 0;
		rear = count;
		queue = larger;
	}

	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. 
	 * @return the element removed from the front of the queue
	 * @throws EmptyCollectionException  if the queue is empty
	 */
	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;

		count--;

		return result;
	}
	
	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. 
	 * @return the element removed from the front of the queue
	 * @throws EmptyCollectionException  if the queue is empty
	 */
	public T dequeueFront() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		T result = queue[front];
		queue[front] = null;

		front = (front + 1) % queue.length;

		count--;

		return result;
	}

	/**
	 * Removes element from the back of this queue and returns a reference to it 
	 * @return the element removed from the rear of the queue 
	 * @throws EmptyCollectionException  if the queue is empty
	 */
	public T dequeueBack() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		if (rear == 0 ) {
			rear = queue.length-1; 

		}else {
			rear = (rear-1); // because rear points to the next available element so we need to decrement here to point to the actual rear element to remove
		}
		
		T result = queue[rear]; //shifted to this line. 
		queue[rear] = null;
		count--;

		return result;
	}
	
	
	/** 
	 * Returns a reference to the element at the front of this queue.
	 * The element is not removed from the queue.  
	 * @return the first element in the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T first() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		 if (isEmpty())
	            throw new EmptyCollectionException("queue");
		 
		return queue[front];  // temp
	}
	
	/**Returns a reference to the element at the back of the queue. 
	 * Element is not removed from the queue 
	 * @return last element of the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T last() throws EmptyCollectionException
	{
		 if (isEmpty())
	            throw new EmptyCollectionException("queue");
		 
		return queue[rear]; 
	}
	

	/**
	 * Returns true if this queue is empty and false otherwise.
	 * @return true if this queue is empty 
	 */
	public boolean isEmpty()
	{
		// To be completed as a Programming Project
		
		return (count==0);  // temp
	}

	/**
	 * Returns the number of elements currently in this queue.
	 * @return the size of the queue
	 */
	public int size()
	{
		// To be completed as a Programming Project
		
		return count;  // temp
	}

	/**
	 * Returns a string representation of this queue. 
	 * @return the string representation of the queue
	 */
	public String toString()
	{
		// To be completed as a Programming Project
		if (isEmpty()) {
			System.out.println("Circular Queue is Empty"); 
		}
		int index = front; 
		System.out.println("Front index : " + front);
		System.out.println("Rear index : " + rear);
		String temp = "Front: \n"; 
		for (int i = 0; i <queue.length; i++) {
			temp += "Circular Array [" + index + "] : " + queue[index] + "\n"; 
			index = (index+1)% queue.length; 
		}
		return temp + ": end";  // temp
	}
}
