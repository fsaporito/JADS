package Sort;


import java.lang.reflect.Array;
import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.OutOfBoundException;



public abstract class Sort <T extends Comparable<T>> {
		
	
	/** Array To Be Sorted (Holds The Final Result) */
	protected T[] arraySort;
	

	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param array Array To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	public Sort (T[] array) throws EmptyArrayException {
		
		if (array ==  null) {
			
			throw new NullPointerException ("Null Array");
			
		}
		
		if (array.length == 0) {
			
			throw new EmptyArrayException ("Empty Array");
			
		}
		
		this.arraySort = array;
		
	}
	
		
	/**
	 * 
	 * Constructor With Generic ArrayList Parameter
	 * 
	 * @param arrayList ArrayList To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Sort (ArrayList<T> arrayList) throws EmptyArrayException {
		
		//(T[]) this.Array.toArray((T[])Array.newInstance(this.Arr.get(0).getClass(), this.Arr.size()));
		
		if (arrayList ==  null) {
			
			throw new NullPointerException ("Null ArrayList");
			
		}
		
		if (arrayList.size() == 0) {
			
			throw new EmptyArrayException ("Empty ArrayList");
			
		}

		this.arraySort =(T[]) arrayList.toArray((T[])Array.newInstance(arrayList.get(0).getClass(), arrayList.size()));
		
	}



	/**
	 * 
	 * Throws Exception OutOfBound
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	protected void exceptionOutOfBoundThrower (int leftBound, int rightBound) throws OutOfBoundException {
		
		if (leftBound > rightBound) { // LeftBound > Right Bound
		
			throw new OutOfBoundException("Left Bound " + leftBound + "Is Less Than The Right Bound " + rightBound);
		
		}
		
		if (leftBound < 0) { // Left Bound Negative
		
			throw new OutOfBoundException("Left Bound Is Negative!!! ");
		
		}
	
		if (rightBound < 0) { // Right Bound Negative
		
			throw new OutOfBoundException("Right Bound Is Negative!!! ");
		
		}
	
		if (leftBound > this.arraySort.length) { // Left Bound Too Big
		
			throw new OutOfBoundException("Left Bound Is Too Big!!! ");
		
		}
	
		if (rightBound > this.arraySort.length) { // Right Bound Too Big
		
			throw new OutOfBoundException("Right Bound Is Too Big!!! ");
		
		}
	
	}
	
	
	
	/**
	 * Swaps Element i With Element J
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	protected void swap (int i, int j) {
		
		if (i != j) {
			
			if (this.arraySort[i] != null && this.arraySort[j] != null) {
					
				T tmp = this.arraySort[i];
					
				this.arraySort[i] = this.arraySort[j];
					
				this.arraySort[j] = tmp;
											
			}
		
		}
		
		
	}
	
	
	
	/**
	 * Check If The Array Is Sorted Correctly
	 * 
	 * @return True if the array Is Sorted
	 */
	public boolean isSorted () {
		
		boolean sorted = true;
		
		for (int i = 1; (i < this.arraySort.length && sorted); i++) {
			
			if (this.arraySort[i-1].compareTo(this.arraySort[i]) > 0) {
				
				sorted = false;
				
			}
			
		}
		
		return sorted;
		
	}
	
	
	
	/**
	 * Check If The Array Is Sorted Correctly
	 * STATIC METHOD
	 * 
	 * @return True if the array Is Sorted
	 */
	public static <E extends Comparable<E>> boolean isSorted (E[] array) {
		
		boolean sorted = true;
		
		for (int i = 1; (i < array.length && sorted); i++) {
			
			if (array[i-1].compareTo(array[i]) > 0) {
				
				sorted = false;
				
			}
			
		}
		
		return sorted;
		
	}
	
	
	
	/**
	 * 
	 * Print The Sorted Array To The Screen
	 * 
	 */
	public void printArray () {
		
		System.out.println();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			System.out.print(arraySort[i] + " ");
		
		}	
		
		System.out.println();
		
	}
	
	
	
	/**
	 * 
	 * Print The Sorted Array To The Screen
	 * STATIC METHOD
	 * 
	 */
	public static <E extends Comparable<E>> void printArray (E[] array) {
		
		System.out.println();
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
		
		}	
		
		System.out.println();
		
	}
	
	
	
		
	/**
	 * 
	 * Return The Sorted Array
	 * 
	 * @return The Array
	 * 
	 */
	public T[] getArray() {
		
		return this.arraySort;
	
	}
	
	
	
	/**
	 * 
	 * Return The Sorted ArrayList
	 * 
	 * @return The ArrayList
	 * 
	 */
	public ArrayList<T> getArrayList() {
		
		ArrayList<T> arrayListTmp = new ArrayList<T>();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			arrayListTmp.add(this.arraySort[i]);
			
		}
		
		return arrayListTmp;
	
	}
	
	

	

	
	
	
}
