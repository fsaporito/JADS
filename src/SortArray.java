import java.util.ArrayList;


public class SortArray <T extends Comparable<T>> {
		
	
	private T[] arraySort;
	

	
	/**
	 * Constructor With Array Parameter
	 * @param Array Array To Sort, Mustn't Be Empty
	 * @throws EmptyArrayException 
	 */
	public SortArray (T[] Array) throws EmptyArrayException {
		
		if (Array.length == 0) {
			
			throw new EmptyArrayException ("Empty Array");
			
		}
		
		this.arraySort = Array;	
		
	}
	
	
	
	/**
	 * Constructor With ArrayList Parameter
	 * @param arraySort ArrayList To Sort, Mustn't Be Empty
	 * @throws EmptyArrayException 
	 */
	public SortArray (ArrayList<T> Arr) throws EmptyArrayException {
		
		//(T[]) this.Array.toArray((T[])Array.newInstance(this.Arr.get(0).getClass(), this.Arr.size()));
		
		if (Arr.size() == 0) {
			
			throw new EmptyArrayException ("Empty ArrayList");
			
		}

		Arr.toArray(this.arraySort);
		
	}



	/**
	 * Throws Exception OutOfBound
	 * @throws OutOfBoundException 
	 * 
	 */
	private void exceptionOutOfBoundThrower (int leftBound, int rightBound) throws OutOfBoundException {
		
		if (leftBound > rightBound) { // LeftBound > Right Bound
		
			throw new OutOfBoundException("Left Bound " + leftBound + "Is Less Than The Right Bound " + rightBound);
		
		}
		
		if (leftBound < 0) { // Left Bound Negative
		
			throw new OutOfBoundException("Left Bound Is Negative!!! ");
		
		}
	
		if (rightBound < 0) { // Right Bound Negative
		
			throw new OutOfBoundException("Right Bound Is Negative!!! ");
		
		}
	
		if (leftBound > this.arraySort.length) { // Left Bound Too Big
		
			throw new OutOfBoundException("Left Bound Is Too Big!!! ");
		
		}
	
		if (rightBound > this.arraySort.length) { // Right Bound Too Big
		
			throw new OutOfBoundException("Right Bound Is Too Big!!! ");
		
		}
	
	}
	
	/** 
	 * Swaps Element i With Element J
	 * @throws OutOfBoundException 
	 */
	private void swap (int i, int j) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(i, j);
		
		if (i != j) {
			
			if (this.arraySort[i] != null && this.arraySort[j] != null) {
					
				T tmp = this.arraySort[i];
					
				this.arraySort[i] = this.arraySort[j];
					
				this.arraySort[j] = tmp;
											
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
	
	

	
//#################################################################
//	Selection Sort: O(n^2)
//################################################################	
	
	
	/**
	 * O(n^2) - Insertion Sort Implementation
	 * @throws OutOfBoundException 
	 */
	public void insertionSort(int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);		
		
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
	 * @throws OutOfBoundException 
	 */
	public void insertionSort () throws OutOfBoundException {
			
		this.insertionSort(0, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Insertion Sort From Index To Array's End
	 * @throws OutOfBoundException 
	 */
	public void insertionSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.insertionSort(indexFrom, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Insertion Sort From Zero To Index
	 * @throws OutOfBoundException 
	 */
	public void insertionSortTo (int indexTo) throws OutOfBoundException {
			
		this.insertionSort(0, indexTo);
			
	}
	
	
	

//#################################################################
//	Insertion Sort: O(n^2)
//################################################################	
	
	
	/** 
	 * O(n^2) - Selection Sort Implementation
	 * @throws OutOfBoundException 
	 * 
	 */
	public void selectionSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);		
		
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
	 * @throws OutOfBoundException 
	 */
	public void selectionSort () throws OutOfBoundException {
			
		this.selectionSort(0, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Selection Sort From Index To Array's End
	 * @throws OutOfBoundException 
	 */
	public void selectionSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.selectionSort(indexFrom, this.arraySort.length);
			
	}
	
	 /**
	  * Calls Selection Sort From Zero To Index
	 * @throws OutOfBoundException 
	 */
	public void selectionSortTo (int indexTo) throws OutOfBoundException {
			
		this.selectionSort(0, indexTo);
			
	}
	
	

	
//#################################################################
//	Merge Sort: O(nlogn)
//################################################################	
		
		
	/** 
	 * O(nlogn) - MergeSort Implementation
	 * @throws OutOfBoundException 
	 * 
	*/
	public void mergeSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);
		
		if ((rightBound - leftBound) <= 1) { // Zero Or One Element, Already Sorted
			
			return;
			
		} else {
			
			
			
		}
			
	}
		
	/**
	 * Calls MergeSort On The Whole Array
	 * @throws OutOfBoundException 
	 */
	public void mergeSort () throws OutOfBoundException {
				
		this.mergeSort(0, this.arraySort.length);
				
	}
		
	/**
	 * Calls MergeSort From Index To Array's End
	 * @throws OutOfBoundException 
	*/
	public void mergeSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.mergeSort(indexFrom, this.arraySort.length);
			
	}
		
	/**
	* Calls MergeSort From Zero To Index
	 * @throws OutOfBoundException 
	*/
	public void mergeSortTo (int indexTo) throws OutOfBoundException {
				
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
