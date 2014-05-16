package Sort;


public class ShellSort <T extends Comparable<T>> {
	
	private T[] arraySort;
		
	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort
	 * 
	 */
	public ShellSort(T[] Array, int leftBound, int rightBound) {
		
		this.arraySort = Array;
		
		this.shellSort(leftBound, rightBound);		
		
	}
	
	
	
	/** 
	 * 
	 * Shell Sort Implementation With Fibonacci'sNumbers: 
	 * 
	 * <p><pre>
	 * Worst Case: Depends On Input
	 * Average Case: Depends On Input
	 * Best Case: O(n)
	 * </pre><p>
	 * 
	 * The Algorithm Works By Dividing The Array In h List, And Calling 
	 * Insertion Sort On Them. It Then Proceeds To Lower The h Value And
	 * Recalling Insertion Sort On The New Created Lists, Until h Reaches
	 * 1. In This Implementation, The h Values Are Calculated By Using 
	 * Fibonacci's Numbers, With The First h Value As The Bigger Fibonacci's
	 * Number Less Than The Array's Length.
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 */
	private void shellSort (int leftBound, int rightBound) {
		
		int fib = 1; // Second Fibonacci Number
		int fibFib = 1; // First Fibonacci Number
		
		while (fibFib < (rightBound - leftBound)) {
			
			fibFib += fib;
			
			fib = fibFib - fib;
			
		}
		
		T value;
		
		int j;
		
		while (fibFib > 1) {
			
			for (int i = fib; i <= rightBound; i++) {
		
				value = this.arraySort[i];
				
				j = i;
				
				while ( (j >= fib) && (this.arraySort[j-fib].compareTo(value) > 0) ) {
					
					this.arraySort[j] =this.arraySort[j-fib];
					
					j -= fib;
					
				}
				
				this.arraySort[j] = value;				
			
			}
			
			fib = fibFib - fib;
			
			fibFib -= fib;
			
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

