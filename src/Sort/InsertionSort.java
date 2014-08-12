package Sort;

import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.OutOfBoundException;


public class InsertionSort <T extends Comparable<T>> extends Sort<T> {
	
	
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
	public InsertionSort(T[] Array) throws EmptyArrayException, OutOfBoundException {
		
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
	public InsertionSort(T[] Array, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(Array);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.insertionSort(leftBound, rightBound);		
		
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
	public InsertionSort(ArrayList<T> ArrayList) throws EmptyArrayException, OutOfBoundException {
		
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
	public InsertionSort(ArrayList<T> ArrayList, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException {
		
		super(ArrayList);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.insertionSort(leftBound, rightBound);	
			
		}
		
	}
	
	
	
	/**
	 * 
	 * Insertion Sort Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(n^2)
	 * Average Case: O(n^2)
	 * Best Case: O(n) 
	 * </pre><p>
	 * 
	 * Insertion Sort Works By Dividing The Array In Two Sublist, 
	 * The Ordered One And The Non Ordered One. At The Beginning,
	 * The Ordered List Is Formed By The First Element Of The Array, 
	 * And The Not Ordered One Corresponds To The Array To Sort Minus
	 * The First Element. The Algorithm At Every Step Takes The First
	 * Element From The Not Ordered List Value And Places It In The End 
	 * Of The Ordered One, By Comparing The Values Of The Added Element
	 * With Every Other One Element Of The Ordered List
	 * At The End Of The Algorithm The Ordered List Is The Sorted Array, 
	 * While The Other List Is Empty.
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 */ 
	private void insertionSort (int leftBound, int rightBound) {
		
		T val;
		
		int j;
		
		for (int i = leftBound+1; i <= rightBound; i++) {
			
			val = this.arraySort[i];
			
			j = i - 1;
			
			while (j >= leftBound && this.arraySort[j].compareTo(val) >= 0) {
				
				
				this.arraySort[j+1] = this.arraySort[j];
				
				j--;
				
			}
			
			this.arraySort[j+1] = val;
			
		}
		
	}

	

	
}
