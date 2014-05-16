package Sort;

public class SelectionSort <T extends Comparable<T>> {
		
	private T[] arraySort;
		
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * 
	 */
	public SelectionSort(T[] Array, int leftBound, int rightBound) {
		
		this.arraySort = Array;
		
		this.selectionSort(leftBound, rightBound);		
		
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
