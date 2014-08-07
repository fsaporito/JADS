package Sort;


import java.lang.reflect.Array;
import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;



public class SortArray <T extends Comparable<T>> {
		
	
	/** Array To Be Sorted (Holds The Final Result) */
	private T[] arraySort;
	

	
	/**
	 * 
	 * Constructor With Generic Array Parameter
	 * 
	 * @param Array Array To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	public SortArray (T[] Array) throws EmptyArrayException {
		
		System.out.println ("Array");
		
		if (Array.length == 0) {
			
			throw new EmptyArrayException ("Empty Array");
			
		}
		
		this.arraySort = Array;	
		
	}
	
		
	/**
	 * 
	 * Constructor With Generic ArrayList Parameter
	 * 
	 * @param Arr ArrayList To Sort, Mustn't Be Empty
	 * 
	 * @throws EmptyArrayException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public SortArray (ArrayList<T> Arr) throws EmptyArrayException {
		
		//(T[]) this.Array.toArray((T[])Array.newInstance(this.Arr.get(0).getClass(), this.Arr.size()));
		
		System.out.println ("ArrayList");
		
		if (Arr.size() == 0) {
			
			throw new EmptyArrayException ("Empty ArrayList");
			
		}

		this.arraySort =(T[]) Arr.toArray((T[])Array.newInstance(Arr.get(0).getClass(), Arr.size()));
		
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
	 * Check If The Array Is Sorted Correctly
	 */
	public boolean isSorted () {
		
		boolean sorted = true;
		
		for (int i = 1; (i < this.arraySort.length && sorted); i++) {
			
			if (this.arraySort[i-1].compareTo(this.arraySort[i]) > 0) {
				
				sorted = false;
				
			}
			
		}
		
		return sorted;
		
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
		
		InsertionSort<T> sorting = new InsertionSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
		
	}
	
	
	/**
	 * 
	 * Calls Insertion Sort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void insertionSort () throws OutOfBoundException {
			
		this.insertionSort(0, this.arraySort.length-1);
			
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
			
		this.insertionSort(indexFrom, this.arraySort.length-1);
			
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
		
		SelectionSort<T> sorting = new SelectionSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
		
		
		
		
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
		
		BubbleSort<T> sorting = new BubbleSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
			
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
		
		ShellSort<T> sorting = new ShellSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();		
		
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
//	Merge Sort
//#################################################################

	
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
		
		MergeSort<T> sorting = new MergeSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
			
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
//	Merge Sort Hybrid
//#################################################################
	
	
	/** 
	 * MergeSort Hybrid Implementation:
	 * 
	 * <p><pre>
	 * Worst Case: O(nlogn)
	 * Average Case: O(nlogn)
	 * Best Case: O(nlogn)
	 * </pre><p>
	 * 
	 * Works As MergeSort, Except That Calls The InsertionSort Algorithm
	 * If The Current Array's Lenght Is Less Than 10, Since InsertionSort
	 * Is The Fastest Algorithm On Small Input
	 * 
	 * @param leftBound Left Limit For The Range Of Array's Values To Sort
	 * @param rightBound Right Limit For The Range Of Array's Values To Sort
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeHybridSort (int leftBound, int rightBound) throws OutOfBoundException {
		
		this.exceptionOutOfBoundThrower(leftBound, rightBound);		
		
		MergeHybridSort<T> sorting = new MergeHybridSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
			
	}
		
	
	/**
	 * 
	 * Calls MergeSort On The Whole Array
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeHybridSort () throws OutOfBoundException {
				
		this.mergeHybridSort(0, this.arraySort.length-1);
				
	}
		
	
	/**
	 * Calls MergeSort From Index To Array's End
	 * 
	 * @param indexFrom Array's First Index To Be Sorted
	 * 
	 * @throws OutOfBoundException 
	 * 
	 */
	public void mergeHybridSortFrom (int indexFrom) throws OutOfBoundException {
			
		this.mergeHybridSort(indexFrom, this.arraySort.length-1);
			
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
	public void mergeHybridSortTo (int indexTo) throws OutOfBoundException {
				
		this.mergeHybridSort(0, indexTo);
				
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
	 * The Algorithms Works By Creating A MinHeap With The Array And By Extracting
	 * Minimum Value From THe Heap, Until The Heap Is Empty
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
		
		HeapSort<T> sorting = new HeapSort<T> (this.arraySort, leftBound, rightBound);
		
		this.arraySort = (T[]) sorting.getArraySort();
		
		
			
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
 * mergeSortInPlace
 * quickSort
 * quickSortHybrid
 * quickSortParallel
 * quickSortParallelHybrid
 * treeSort
 * countingSort
 * introSort
 * smoothSort 
 * 
 */	
	
	
	
}
