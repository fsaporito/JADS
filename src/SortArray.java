import java.lang.reflect.Array;
import java.util.ArrayList;

import DataStructures.MinHeap;
import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;



public class SortArray <T extends Comparable<T>> {
		
	
	private T[] arraySort;
	

	
	/**
	 * 
	 * Constructor With Array Parameter
	 * 
	 * @param Array Array To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	public SortArray (T[] Array) throws EmptyArrayException {
		
		if (Array.length == 0) {
			
			throw new EmptyArrayException ("Empty Array");
			
		}
		
		this.arraySort = Array;	
		
	}
	
		
	/**
	 * 
	 * Constructor With ArrayList Parameter
	 * 
	 * @param Arr ArrayList To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	public SortArray (ArrayList<T> Arr) throws EmptyArrayException {
		
		//(T[]) this.Array.toArray((T[])Array.newInstance(this.Arr.get(0).getClass(), this.Arr.size()));
		
		if (Arr.size() == 0) {
			
			throw new EmptyArrayException ("Empty ArrayList");
			
		}

		Arr.toArray(this.arraySort);
		
	}



	/**
	 * 
	 * Throws Exception OutOfBound
	 * 
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
	 * 
	 * Swaps Element i With Element J
	 * 
	 * @throws OutOfBoundException 
	 * 
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
	 * 
	 * Print The Sorted Array To The Screen
	 * 
	 */
	public void printArray () {
		
		System.out.println();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			System.out.print(arraySort[i] + " ");
		
		}	
		
		System.out.println();
		
	}
	
	
	
		
	/**
	 * 
	 * Return The Sorted Array
	 * 
	 * @return The Array
	 * 
	 */
	public T[] getArray() {
		
		return this.arraySort;
	
	}
	
	
	
	/**
	 * 
	 * Return The Sorted ArrayList
	 * 
	 * @return The ArrayList
	 * 
	 */
	public ArrayList<T> getArrayList() {
		
		ArrayList<T> arrayListTmp = new ArrayList<T>();
		
		for (int i = 0; i < this.arraySort.length; i++) {
			
			arrayListTmp.add(this.arraySort[i]);
			
		}
		
		return arrayListTmp;
	
	}
	
	

	
//#################################################################
//	Insertion Sort
//################################################################	
	
	
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
	 * @throws OutOfBoundException
	 * 
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
	 * 
	 * Calls Insertion Sort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void insertionSort () throws OutOfBoundException {
			
		this.insertionSort(0, this.arraySort.length);
			
	}
	
	
	 /**
	  * 
	  * Calls Insertion Sort From Index To Array's End
	  * 
	  * @param indexFrom Array's First Index To Be Sorted
	  * 
	  * @throws OutOfBoundException
	  *  
	  */
	public void insertionSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.insertionSort(indexFrom, this.arraySort.length);
			
	}
	
	
	 /**
	  * 
	  * Calls Insertion Sort From Zero To Index
	  * 
	  * @param indexTo Array's Last Index To Be Sorted
	  * 
	  * @throws OutOfBoundException 
	  * 
	  */
	public void insertionSortTo (int indexTo) throws OutOfBoundException {
			
		this.insertionSort(0, indexTo);
			
	}
	
	
	

//#################################################################
//	Selection Sort
//################################################################	
	
	
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
	 * 
	 * Calls Selection Sort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void selectionSort () throws OutOfBoundException {
			
		this.selectionSort(0, this.arraySort.length);
			
	}
	
	
	 /**
	  * 
	  * Calls Selection Sort From Index To Array's End
	  * 
	  * @param indexFrom Array's First Index To Be Sorted
	  * 
	  * @throws OutOfBoundException 
	  * 
	  */
	public void selectionSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.selectionSort(indexFrom, this.arraySort.length);
			
	}
	
	
	 /**
	  * 
	  * Calls Selection Sort From Zero To Index
	  * 
	  * @param indexTo Array's Last Index To Be Sorted
	  * 
	  * @throws OutOfBoundException 
	  * 
	  */
	public void selectionSortTo (int indexTo) throws OutOfBoundException {
			
		this.selectionSort(0, indexTo);
			
	}
	
	
	

//#################################################################
//	Shell Sort
//################################################################	
	
	
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
	 * @throws OutOfBoundException 
	 * 
	 */
	public void shellSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);		
		
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
	 * Calls Shell Sort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void shellSort () throws OutOfBoundException {
			
		this.shellSort(0, this.arraySort.length-1);
			
	}
	
	
	 /**
	  * Calls Shell Sort From Index To Array's End
	  * 
	  * @param indexFrom Array's First Index To Be Sorted
	  * 
	  * @throws OutOfBoundException 
	  * 
	  */
	public void shellSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.shellSort(indexFrom, this.arraySort.length-1);
			
	}
	
	
	 /**
	  * 
	  * Calls Shell Sort From Zero To Index
	  * 
	  * @param indexTo Array's Last Index To Be Sorted
	  * 
	  * @throws OutOfBoundException 
	  * 
	  */
	public void shellSortTo (int indexTo) throws OutOfBoundException {
			
		this.shellSort(0, indexTo);
			
	}
	
	
	

//#################################################################
//	Bubble Sort
//################################################################	

	 
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
	 * @throws OutOfBoundException 
	 * 
	 */
	public void bubbleSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);
		
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
	 * 
	 * Calls Bubble Sort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void bubbleSort () throws OutOfBoundException {
				
		this.bubbleSort(0, this.arraySort.length-1);
				
	}
		
	/**
	 * 
	 * Calls Bubble Sort From Index To Array's End
	 * 
	 * @param indexFrom Array's First Index To Be Sorted
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void bubbleSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.bubbleSort(indexFrom, this.arraySort.length-1);
			
	}
	
	
	/**
	 * 
	 * Calls Bubble Sort From Zero To Index
	 * 
	 * @param indexTo Array's Last Index To Be Sorted
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void bubbleSortTo (int indexTo) throws OutOfBoundException {
				
		this.bubbleSort(0, indexTo);
				
	}
		
	
	
	
//#################################################################
//	Merge Sort
//#################################################################

	
	/**
	 * 
	 * Merge function To Fuse Two Lists Generated By MergeSort
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param center center that separate the two lists
	 * @param rightBound right limit
	 * 
	 */
	private void merge (int leftBound, int center, int rightBound) {
		
		// Create Left Array
		@SuppressWarnings("unchecked")
		T[] L = (T[]) Array.newInstance(this.arraySort[0].getClass(), (center - leftBound + 1));
		
		// Create Right Array
		@SuppressWarnings("unchecked")
		T[] R = (T[]) Array.newInstance(this.arraySort[0].getClass(), (rightBound - center));
		
		// Fill Left Array
		for (int i = 0; i <= (center-leftBound); i++) {
			
			L[i] = this.arraySort[leftBound+i];
			
		}
		
		// Fill Right Array
		for (int i = 0; i < (rightBound-center); i++) {
			
			R[i] = this.arraySort[center+1+i];			
			
		}
		
		int rValue = 0;
		int lValue = 0;
		int arrSortedValue = leftBound;
		
		while (rValue < (rightBound-center) && lValue <= (center-leftBound)) {
		
			if (L[lValue].compareTo(R[rValue]) <= 0) { // Min Is In L
				
				this.arraySort[arrSortedValue] = L[lValue];
				
				lValue++;
				
				arrSortedValue++;
				
			} else { // Min Is In R
				
				this.arraySort[arrSortedValue] = R[rValue];
				
				rValue++;
				
				arrSortedValue++;
				
			}			
			
		}
		
		// Filling The Sorted Array With The R Remaining Items
		while (lValue <= (center-leftBound)) {
					
			this.arraySort[arrSortedValue] = L[lValue];
					
			lValue++;
					
			arrSortedValue++;
					
		}
				
		// Filling The Sorted Array With The R Remaining Items
		while (rValue < rightBound-center) {
			
			this.arraySort[arrSortedValue] = R[rValue];
						
			rValue++;
			
			arrSortedValue++;
			
		}
		
	}
	
	
	/** 
	 * MergeSort Implementation:
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
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);
		
		if ((rightBound - leftBound) == 0) { // One Element, Already Sorted
			
			return;
			
		} else {
			
			int center =(int) ((leftBound + rightBound)/2);
			
			this.mergeSort(leftBound, center);
			
			this.mergeSort(center+1, rightBound);
			
			this.merge(leftBound, center, rightBound);
			
		}
			
	}
		
	
	/**
	 * 
	 * Calls MergeSort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeSort () throws OutOfBoundException {
				
		this.mergeSort(0, this.arraySort.length-1);
				
	}
		
	
	/**
	 * Calls MergeSort From Index To Array's End
	 * 
	 * @param indexFrom Array's First Index To Be Sorted
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.mergeSort(indexFrom, this.arraySort.length-1);
			
	}
		
	
	/**
	 * 
	 * Calls MergeSort From Zero To Index
	 * 
	 * @param indexTo Array's Last Index To Be Sorted
	 * 
	 * @throws OutOfBoundException
	 *  
	 */
	public void mergeSortTo (int indexTo) throws OutOfBoundException {
				
		this.mergeSort(0, indexTo);
				
	}
		
	

	
//#################################################################
//	Heap Sort
//#################################################################

	
	
	
	/** 
	 * HeapSort Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(nlogn)
	 * Average Case: O(nlogn)
	 * Best Case: O(nlogn)
	 * </pre><p>
	 * 
	 * The Algorithms Works 
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 * @throws OutOfBoundException 
	 * @throws EmptyHeapException 
	 * 
	 */
	public void heapSort (int leftBound, int rightBound) throws OutOfBoundException, EmptyHeapException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);
		
		if ((rightBound - leftBound) == 0) { // One Element, Already Sorted
			
			return;
			
		} else {
			
			MinHeap<T> heap = new MinHeap<T>();
			
			for (int i = leftBound; i <= rightBound; i++) {
				
				heap.insert(this.arraySort[i]);
				
			}
			
			for (int j = leftBound; j <= rightBound; j++) {
				
				this.arraySort[j] = heap.extractMinValue();
				
			}
			
		}
			
	}
		
	
	/**
	 * 
	 * Calls HeapSort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * @throws EmptyHeapException 
	 * 
	 */
	public void heapSort () throws OutOfBoundException, EmptyHeapException {
				
		this.heapSort(0, this.arraySort.length-1);
				
	}
		
	
	/**
	 * Calls HeapSort From Index To Array's End
	 * 
	 * @param indexFrom Array's First Index To Be Sorted
	 * 
	 * @throws OutOfBoundException 
	 * @throws EmptyHeapException 
	 * 
	 */
	public void heapSortFrom (int indexFrom) throws OutOfBoundException, EmptyHeapException {
			
		this.heapSort(indexFrom, this.arraySort.length-1);
			
	}
		
	
	/**
	 * 
	 * Calls HeapSort From Zero To Index
	 * 
	 * @param indexTo Array's Last Index To Be Sorted
	 * 
	 * @throws OutOfBoundException
	 * @throws EmptyHeapException 
	 *  
	 */
	public void heapSortTo (int indexTo) throws OutOfBoundException, EmptyHeapException {
				
		this.heapSort(0, indexTo);
				
	}
		
	
	
	
// TODO
/*
 * 
 * mergeSortParallel
 * mergeSortParallelHybrid
 * quickSort
 * quickSortParallel
 * quickSortParallelHybrid
 * countingSort
 * introSort
 * smoothSort 
 * 
 */	
	
	
	
}
