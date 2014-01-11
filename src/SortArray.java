import java.util.ArrayList;


public class SortArray <T extends Comparable<T>> {
		
	
	private T[] arraySort;
	

	
	/**
	 * Constructor With Array Parameter
	 * @param Array Array To Sort
	 */
	public SortArray (T[] Array) {
		
		this.arraySort = Array;	
		
	}
	
	
	
	/**
	 * Constructor With ArrayList Parameter
	 * @param arraySort ArrayList To Sort
	 */
	public SortArray (ArrayList<T> Arr) {
		
		//(T[]) this.Array.toArray((T[])Array.newInstance(this.Arr.get(0).getClass(), this.Arr.size()));

		Arr.toArray(this.arraySort);
		
	}



	
	/** 
	 * Swaps Element i With Element J
	 */
	private void swap (int i, int j) {
		
		if (i != j) {
			
			if (i >= 0 && j >= 0) {
				
				if (i < this.arraySort.length && j < this.arraySort.length) {
					
					if (this.arraySort[i] != null && this.arraySort[j] != null) {
					
						T tmp = this.arraySort[i];
					
						this.arraySort[i] = this.arraySort[j];
					
						this.arraySort[j] = tmp;
					
					}
				
				}
				
			}
		
		}
		
		
	}

	
	
	/**
	 * Print The Sorted Array To The Screen
	 */
	public void printArray () {
		
		System.out.println();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			System.out.print(arraySort[i] + " ");
		
		}	
		
		System.out.println();
		
	}
	
	
	
		
	/**
	 * Return The Sorted Array
	 * @return The Array
	 */
	public T[] getArray() {
		
		return this.arraySort;
	
	}
	
	
	
	/**
	 * Return The Sorted ArrayList
	 * @return The ArrayList
	 */
	public ArrayList<T> getArrayList() {
		
		ArrayList<T> arrayListTmp = new ArrayList<T>();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			arrayListTmp.add(this.arraySort[i]);
			
		}
		
		return arrayListTmp;
	
	}
	
	

	
// ################################################################
//	Selection Sort: O(n^2)
//################################################################	
	
	
	/**
	 * O(n^2) - Insertion Sort Implementation
	 */
	public void insertionSort(int leftBound, int rightBound) {
		
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
	 * Calls Insertion Sort On The Whole Array
	 */
	public void insertionSort () {
			
		this.insertionSort(0, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Insertion Sort From Index To Array's End
	 */
	public void insertionSortFrom (int indexFrom) {
			
		this.insertionSort(indexFrom, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Insertion Sort From Zero To Index
	 */
	public void insertionSortTo (int indexTo) {
			
		this.insertionSort(0, indexTo);
			
	}
	
	
	

// ################################################################
//	Insertion Sort: O(n^2)
//################################################################	
	
	
	/** 
	 * O(n^2) - Selection Sort Implementation
	 * 
	 */
	public void selectionSort (int leftBound, int rightBound) {
		
		int min = leftBound;
		
		for (int i = leftBound; i < rightBound ; i++) {
			
			min = i;
			
			for (int j = i + 1; j < rightBound; j++) {
				
				if (this.arraySort[j].compareTo(this.arraySort[min]) < 0) {
					
					min = j;
					
				}
				
			}
			
			swap (i, min);
			
		}
		
		
	}
	
	/**
	 * Calls Selection Sort On The Whole Array
	 */
	public void selectionSort () {
			
		this.selectionSort(0, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Selection Sort From Index To Array's End
	 */
	public void selectionSortFrom (int indexFrom) {
			
		this.selectionSort(indexFrom, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Selection Sort From Zero To Index
	 */
	public void selectionSortTo (int indexTo) {
			
		this.selectionSort(0, indexTo);
			
	}
	
	

	
// ################################################################
//	Merge Sort: O(nlogn)
//################################################################	
		
		
	/** 
	 * O(nlogn) - MergeSort Implementation
	 * 
	*/
	public void mergeSort (int leftBound, int rightBound) {
			
	}
		
	/**
	 * Calls MergeSort On The Whole Array
	 */
	public void mergeSort () {
				
		this.mergeSort(0, this.arraySort.length);
				
	}
		
	/**
	 * Calls MergeSort From Index To Array's End
	*/
	public void mergeSortFrom (int indexFrom) {
			
		this.mergeSort(indexFrom, this.arraySort.length);
			
	}
		
	/**
	* Calls MergeSort From Zero To Index
	*/
	public void mergeSortTo (int indexTo) {
				
		this.mergeSort(0, indexTo);
				
	}
		
	
	
	
	
// TODO
/*
 * mergeSortParallel
 * mergeSortParallelHybrid
 * quickSortParallel
 * quickSortParallelHybrid
 * heapSort
 * bubbleSort
 * countingSort
 * introSort
 * smoothSort * 
 * 
 */	
	
	
	
}
