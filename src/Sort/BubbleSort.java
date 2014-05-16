package Sort;

public class BubbleSort <T extends Comparable<T>> {
	
	private T[] arraySort;
		
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * 
	 */
	public BubbleSort(T[] Array, int leftBound, int rightBound) {
		
		this.arraySort = Array;
		
		this.bubbleSort(leftBound, rightBound);		
		
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
	private void bubbleSort (int leftBound, int rightBound) {
		
		if ((rightBound - leftBound) == 0) { // One Element, Already Sorted
			
			return;
			
		} else {
			
			for (int i = rightBound; i >= leftBound; i--) {
				
				for (int j = leftBound; j < i; j++) {
					
					if (this.arraySort[j].compareTo(this.arraySort[j+1]) > 0) {
						
						this.swap(j, j+1);
						
					}
					
				}
				
			}
			
		}
		
	}

	
	
	/**
	 * Swaps Element i With Element J
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	private void swap (int i, int j) {
		
		if (i != j) {
			
			if (this.arraySort[i] != null && this.arraySort[j] != null) {
					
				T tmp = this.arraySort[i];
					
				this.arraySort[i] = this.arraySort[j];
					
				this.arraySort[j] = tmp;
											
			}
		
		}
		
		
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

