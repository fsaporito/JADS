package Sort;

import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;

public class SortStatic {

	
	
//#################################################################
//	Insertion Sort
//################################################################	
	
	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] insertionSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		InsertionSort<T> sorting = new InsertionSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] insertionSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return insertionSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] insertionSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return insertionSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] insertionSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return insertionSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		InsertionSort<T> sorting = new InsertionSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> insertionSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return insertionSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> insertionSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return insertionSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> insertionSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return insertionSort(arrayList, 0, indexTo);
			
	}
	
	
	
	

//#################################################################
//	Selection Sort
//################################################################	
	
	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] selectionSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		SelectionSort<T> sorting = new SelectionSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] selectionSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return selectionSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] selectionSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return selectionSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] selectionSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return selectionSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		SelectionSort<T> sorting = new SelectionSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> selectionSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return selectionSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> selectionSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return selectionSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> selectionSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return selectionSort(arrayList, 0, indexTo);
			
	}
	
	
	

	
//#################################################################
//	Bubble Sort
//################################################################	

	 
	/* Array */	
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		BubbleSort<T> sorting = new BubbleSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] bubbleSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return bubbleSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] bubbleSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return bubbleSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] bubbleSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return bubbleSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		BubbleSort<T> sorting = new BubbleSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T>bubbleSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return bubbleSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> bubbleSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return bubbleSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> bubbleSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return bubbleSort(arrayList, 0, indexTo);
			
	}
	
	
	
	
	
//#################################################################
//	Shell Sort
//################################################################	
	
	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] shellSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		ShellSort<T> sorting = new ShellSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] shellSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return shellSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] shellSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return shellSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] shellSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return shellSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> shellSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		ShellSort<T> sorting = new ShellSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> shellSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return shellSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> shellSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return shellSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> shellSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return shellSort(arrayList, 0, indexTo);
			
	}
	
	
	
	
//#################################################################
//	Merge Sort
//#################################################################

	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] mergeSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		MergeSort<T> sorting = new MergeSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] mergeSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return mergeSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] mergeSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return mergeSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] mergeSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return mergeSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		MergeSort<T> sorting = new MergeSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return mergeSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return mergeSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return mergeSort(arrayList, 0, indexTo);
			
	}
	
	
	
	
	
//#################################################################
//	Merge Sort Hybrid
//#################################################################
	
	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] mergeHybridSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		MergeHybridSort<T> sorting = new MergeHybridSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] mergeHybridSort (T[] array) throws OutOfBoundException, EmptyArrayException {
			
		return mergeHybridSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] mergeHybridSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException {
			
		return mergeHybridSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] mergeHybridSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException {
			
		return mergeHybridSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> mergeHybridSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException {
		
		MergeHybridSort<T> sorting = new MergeHybridSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeHybridSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException {
		
		return mergeHybridSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeHybridSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException {
		
		return mergeHybridSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> mergeHybridSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException {
		
		return mergeHybridSort(arrayList, 0, indexTo);
			
	}
	
	

	
	
//#################################################################
//	Heap Sort
//#################################################################
	
	
	/* Array */	
	
	public static <T extends Comparable<T>> T[] heapSort(T[] array, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
		
		HeapSort<T> sorting = new HeapSort<T> (array, leftBound, rightBound);
		
		return sorting.getArray();
		
	}
			
	public static <T extends Comparable<T>> T[] heapSort (T[] array) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
			
		return heapSort(array, 0, array.length-1);
			
	}
		 
	public static <T extends Comparable<T>> T[] heapSortFrom (T[] array, int indexFrom) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
			
		return heapSort(array, indexFrom, array.length-1);
			
	}
		
	public static <T extends Comparable<T>> T[] heapSortTo (T[] array, int indexTo) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
			
		return heapSort(array, 0, indexTo);
			
	}
	
	
	/* ArrayList */	
	
	public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> arrayList, int leftBound, int rightBound) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
		
		HeapSort<T> sorting = new HeapSort<T> (arrayList, leftBound, rightBound);
		
		return sorting.getArrayList();
		
	}
	
	public static <T extends Comparable<T>> ArrayList<T> heapSort (ArrayList<T> arrayList) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
		
		return heapSort(arrayList, 0, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> heapSortFrom (ArrayList<T> arrayList, int indexFrom) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
		
		return heapSort(arrayList, indexFrom, arrayList.size());
			
	}
	
	public static <T extends Comparable<T>> ArrayList<T> heapSortTo (ArrayList<T> arrayList, int indexTo) throws OutOfBoundException, EmptyArrayException, EmptyHeapException {
		
		return heapSort(arrayList, 0, indexTo);
			
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
