package Sort;

import DataStructures.MinHeap;
import Exceptions.EmptyHeapException;

public class HeapSort <T extends Comparable<T>> {

	
	/** Array To Be Sorted (Holds The Final Result) */
	private T[] arraySort;
	
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * @throws EmptyHeapException 
	 * 
	 */
	public HeapSort(T[] Array, int leftBound, int rightBound) throws EmptyHeapException {
		
		this.arraySort = Array;
		
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

	
		/*MinHeap<T> heap = new MinHeap<T>();
			
		for (int i = leftBound; i <= rightBound; i++) {
				
			heap.insert(this.arraySort[i]);
				
		}
			
		for (int j = leftBound; j <= rightBound; j++) {
				
			this.arraySort[j] = heap.extractMinValue();
				
		}
		*/
			
	}

	
	
	/**
	 * 
	 * Return The Sorted Array
	 * 
	 * @return The Array
	 * 
	 */
	public T[] getArraySort() {
		
		return arraySort;
	
	}

	

}
