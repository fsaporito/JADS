package Sort;

import java.util.ArrayList;

import DataStructures.MinHeap;
import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;

public class HeapSort <T extends Comparable<T>> extends Sort<T> {

	
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * Sorts The Whole Array
	 * 
	 * @param Array Array To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * @throws EmptyHeapException 
	 * 
	 */
	public HeapSort(T[] Array) throws EmptyArrayException, OutOfBoundException, EmptyHeapException {
		
		this(Array, 0, Array.length-1);
		
	}
	
	
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * @throws EmptyHeapException 
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * 
	 */
	public HeapSort(T[] Array, int leftBound, int rightBound) throws EmptyHeapException, EmptyArrayException, OutOfBoundException {
		
		super(Array);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
			
			this.heapSort(leftBound, rightBound);	
			
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
	 * @throws EmptyHeapException 
	 * 
	 */
	public HeapSort(ArrayList<T> ArrayList) throws EmptyArrayException, OutOfBoundException, EmptyHeapException {
		
		this(ArrayList, 0, ArrayList.size());
		
	}
	
	
	
	/**
	 * 
	 * Constructor With Generic ArrayList Parameter
	 * 
	 * @param ArrayList ArrayList To Sort
	 * @throws EmptyArrayException 
	 * @throws OutOfBoundException 
	 * @throws EmptyHeapException 
	 * 
	 */
	public HeapSort(ArrayList<T> ArrayList, int leftBound, int rightBound) throws EmptyArrayException, OutOfBoundException, EmptyHeapException {
		
		super(ArrayList);
		
		this.exceptionOutOfBoundThrower (leftBound, rightBound);
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
		
			this.heapSort(leftBound, rightBound);	
			
		}
		
	}

	

	/** 
	 * HeapSort Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(nlogn)
	 * Average Case: O(nlogn)
	 * Best Case: O(nlogn)
	 * </pre><p>
	 * 
	 * The Algorithms Works By Creating A MinHeap With The Array And By Extracting
	 * Minimum Value From THe Heap, Until The Heap Is Empty
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 *
	 * @throws EmptyHeapException 
	 * 
	 */
	private void heapSort(int leftBound, int rightBound) throws EmptyHeapException {
						
		@SuppressWarnings("unchecked")
		T[] arrTMP = (T[]) new Comparable[rightBound-leftBound+1];
		
		for (int i = leftBound; i <= rightBound; i++) {
			
			arrTMP[i-leftBound] = this.arraySort[i];
			
		}
		
		MinHeap<T> heap = new MinHeap<T>(arrTMP);
		
		for (int j = leftBound; j <= rightBound; j++) {
				
			this.arraySort[j] = heap.extractMinValue();
				
		}
			
	}
	

}
