package Sort;

import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.OutOfBoundException;

public class BubbleSort <T extends Comparable<T>> extends Sort<T> {
	
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * Sorts The Whole Array
	 * 
	 * @param Array Array To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * 
	 */
	public BubbleSort(T[] Array) throws EmptyArrayException, OutOfBoundException {
		
		this(Array, 0, Array.length-1);
		
	}
	
	
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * 
	 */
	public BubbleSort(T[] Array, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(Array);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.bubbleSort(leftBound, rightBound);	
			
		}
		
	}
	
	
	
	/**
	 * 
	 * Constructor With Generic ArrayList Parameter
	 * Sorts The Whole ArrayList
	 * 
	 * @param ArrayList ArrayList To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * 
	 */
	public BubbleSort(ArrayList<T> ArrayList) throws EmptyArrayException, OutOfBoundException {
		
		this(ArrayList, 0, ArrayList.size());
		
	}
	
	
	
	/**
	 * 
	 * Constructor With Generic ArrayList Parameter
	 * 
	 * @param ArrayList ArrayList To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * 
	 */
	public BubbleSort(ArrayList<T> ArrayList, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(ArrayList);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.bubbleSort(leftBound, rightBound);	
			
		}
		
	}
	
	
	/** 
	 * 
	 * BubbleSort Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(n^2)
	 * Average Case: O(n^2)
	 * Best Case: O(n)
	 * </pre><p>
	 * 
	 * The Bubble Sort Works By Comparing Every Adjacent Couple Of Elements
	 * And Swapping Them If They Are At The Wrong Positions, For Every Adjacent
	 * Couple In The List. When The Array Ends, The Algorithm Restart Again, Repeating
	 * Itself Until No Swaps Are Done.
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 * 
	 */
	public void bubbleSort (int leftBound, int rightBound) {
		
		for (int i = rightBound; i >= leftBound; i--) {
				
			for (int j = leftBound; j < i; j++) {
					
				if (this.arraySort[j].compareTo(this.arraySort[j+1]) > 0) {
						
					this.swap(j, j+1);
						
				}
					
			}
				
		}
			
	}

	
	
	

	
}

