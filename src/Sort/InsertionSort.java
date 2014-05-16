package Sort;


public class InsertionSort <T extends Comparable<T>> {
	
	private T[] arraySort;
	
		
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * 
	 */
	public InsertionSort(T[] Array, int leftBound, int rightBound) {
		
		this.arraySort = Array;
		
		this.insertionSort(leftBound, rightBound);		
		
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
		
		for (int i = leftBound+1; i < rightBound; i++) {
			
			val = this.arraySort[i];
			
			j = i - 1;
			
			while (j >= leftBound && this.arraySort[j].compareTo(val) >= 0) {
				
				
				this.arraySort[j+1] = this.arraySort[j];
				
				j--;
				
			}
			
			this.arraySort[j+1] = val;
			
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
