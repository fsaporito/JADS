package Sort;

import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.OutOfBoundException;

public class SelectionSort <T extends Comparable<T>> extends Sort<T> {
	
	
	
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
	public SelectionSort(T[] Array) throws EmptyArrayException, OutOfBoundException {
		
		this(Array, 0, Array.length);
		
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
	public SelectionSort(T[] Array, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(Array);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
			
			this.selectionSort(leftBound, rightBound);	
			
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
	public SelectionSort(ArrayList<T> ArrayList) throws EmptyArrayException, OutOfBoundException {
		
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
	public SelectionSort(ArrayList<T> ArrayList, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(ArrayList);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.selectionSort(leftBound, rightBound);	
			
		}
		
	}
	
	
	
	/** 
	 * 
	 * Selection Sort Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(n^2)
	 * Average Case: O(n^2)
	 * Best Case: O(n^2) 
	 * </pre><p>
	 * 
	 * Selection Sort Works By Dividing The Array In Two Sublist, 
	 * The Ordered One And The Non Ordered One. At The Beginning,
	 * The Ordered List Is Empty, And The Not Ordered One Corresponds 
	 * To The Array To Sort. The Algorithm At Every Step Selects From
	 * The Not Ordered List The Minimum Value And Places It At The End 
	 * Of The Ordered One.
	 * At The End Of The Algorithm The Ordered List Is The Sorted Array, 
	 * While The Other List Is Empty.
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	private void selectionSort (int leftBound, int rightBound) {
		
		int min = leftBound;
		
		for (int i = leftBound; i < rightBound ; i++) {
			
			min = i;
			
			for (int j = i + 1; j < rightBound; j++) {
				
				if (this.arraySort[j].compareTo(this.arraySort[min]) < 0) {
					
					min = j;
					
				}
				
			}
			
			this.swap (i, min);
			
		}
		
	}


}
