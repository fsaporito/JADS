package Sort;



public class MergeHybridSort <T extends Comparable<T>> extends MergeSort<T> {
	
	private T[] arraySort;
	
		
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * 
	 */
	public MergeHybridSort(T[] Array, int leftBound, int rightBound) {
		
		super(Array,leftBound, rightBound);
		
		this.arraySort = Array;
		
		if ((rightBound - leftBound) != 0) { // One Element => Already Sorted
			
			this.mergeHybridSort (leftBound, rightBound);	
			
		}	
		
	}
	
	
	
	/** 
	 * MergeSort Hybrid Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(nlogn)
	 * Average Case: O(nlogn)
	 * Best Case: O(nlogn)
	 * </pre><p>
	 * 
	 * The Algorithms Works By Splicing The Input In Two And Calling Recursively
	 * MergeSort On The Two Lists. If The List Has Only One Elements Stops The
	 * Recursion, Otherwise Calls The Merge Function On The Two Sublists,
	 * That Fuses The Two Ordered Lists Into A Single Ordered One.
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 * 
	 */
	private void mergeHybridSort (int leftBound, int rightBound) {
		
		if ((rightBound - leftBound) == 0) { // One Element, Already Sorted
			
			return;
			
		} else {
			
			if ((rightBound - leftBound) <= 10) {
				
				this.insertionSort(leftBound, rightBound);
				
			} else {
			
				int center =(int) ((leftBound + rightBound)/2);
			
				this.mergeHybridSort(leftBound, center);
			
				this.mergeHybridSort(center+1, rightBound);
			
				this.merge(leftBound, center, rightBound);
				
			}
			
		}
		
	}

	
	
	
	
	
	/**
	 *  Insertion Sort Implementation
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


