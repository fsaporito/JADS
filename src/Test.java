import java.util.ArrayList;
import java.util.Arrays;

import DataStructures.MaxHeap;
import DataStructures.MinHeap;
import DataStructures.Queue;
import DataStructures.Stack;
import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;
import parallelRandomGenerator.ParallelRandInt;


public class Test {

	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException {
		
		
		boolean TEST_QUEUE = false;
		boolean TEST_STACK = false;
		boolean TEST_HEAP_MAX = false;
		boolean TEST_HEAP_MIN = false;
		
		boolean TEST_SORT = true;
		boolean TEST_ALL_SORT = true;
		
		boolean TEST_INSERTION_SORT = false;
		boolean TEST_SELECTION_SORT = false;
		boolean TEST_SHELL_SORT = false;
		boolean TEST_BUBBLE_SORT = false;
		boolean TEST_MERGE_SORT = false;
		boolean TEST_HEAP_SORT = true;
		
		
		
		
// ################################################################
//		Random Array Creation
// ################################################################
		
		ParallelRandInt rand = new ParallelRandInt(1111, 20, 100);	
		
		Integer[] Arr = rand.getRandIntArr();
		
		ArrayList<Integer> ArrList = rand.getRandIntArrList();
		

		
// ################################################################
//		Queue Test
// ################################################################		
		
		if (TEST_QUEUE) {
			
			System.out.println("################################################################\n");
		
			System.out.println("Queue Test: \n");
		
			System.out.println("With Array");
		
			Queue<Integer> q = new Queue<Integer>(Arr);
			
			System.out.println(q.toString());
		
			System.out.println("Empty: " + q.emptyQueue());
		
			q.enQueue(10);
		
			System.out.println(q.toString());
		
			q.deQueue();
		
			System.out.println(q.toString());
		
			q.clear();
		
			System.out.println("Empty: " + q.emptyQueue());
		
			System.out.println("\n\nWith ArrayList");
		
			q = new Queue<Integer>(ArrList);
		
			System.out.println(q.toString());
		
			System.out.println("Empty: " + q.emptyQueue());
		
			q.enQueue(10);
		
			System.out.println(q.toString());
		
			q.deQueue();
		
			System.out.println(q.toString());
		
			q.clear();
		
			System.out.println("Empty: " + q.emptyQueue());
		
			
		}
		
		
// ################################################################
//		Stack Test
// ################################################################		
		
		
		if (TEST_STACK) {
			
			System.out.println("################################################################\n");
		
			System.out.println("Stack Test: \n");
		
			System.out.println("With Array");
		
			Stack<Integer> s = new Stack<Integer>(Arr);
		
			System.out.println(s.toString());
		
			System.out.println("Empty: " + s.emptyStack());
		
			s.pushStack(10);
		
			System.out.println(s.toString());
		
			s.popStack();
		
			System.out.println(s.toString());
		
			s.clear();
		
			System.out.println("Empty: " + s.emptyStack());
		
			System.out.println("\n\nWith ArrayList");
		
			s = new Stack<Integer>(ArrList);
		
			System.out.println(s.toString());
		
			System.out.println("Empty: " + s.emptyStack());
		
			s.pushStack(10);
		
			System.out.println(s.toString());
		
			s.popStack();
		
			System.out.println(s.toString());
		
			s.clear();
		
			System.out.println("Empty: " + s.emptyStack());
		
		}
		
		
// ################################################################
//		Min Heap Test
// ################################################################		
		
		
		if (TEST_HEAP_MIN) {
			
			System.out.println("################################################################\n");
		
			System.out.println("Min Heap Test: \n");
		
			System.out.println("With Array");
		
			MinHeap<Integer> minH = new MinHeap<Integer>(ArrList);
		
			System.out.println(minH.toString());
			
			minH.insert(35);
			
			System.out.println(minH.toString());
			
			try {
				
				minH.extractMinValue();
			
			} catch (EmptyHeapException e) {
			
				e.printStackTrace();
			
			}
			
			System.out.println(minH.toString());		
			
			
					
			System.out.println("\nWith ArrayList");
		
			MinHeap<Integer> minlH = new MinHeap<Integer>(Arr);
		
			System.out.println(minlH.toString());
			
			minlH.insert(35);
			
			System.out.println(minlH.toString());
			
			try {
				
				minlH.extractMinValue();
			
			} catch (EmptyHeapException e) {
			
				e.printStackTrace();
			
			}
			
			System.out.println(minlH.toString());		
			
		}
		
		
		
// ################################################################
//		Max Heap Test
// ################################################################		
		
		
		if (TEST_HEAP_MAX) {
			
			System.out.println("################################################################\n");
		
			System.out.println("Max Heap Test: \n");
		
			System.out.println("With Array");
		
			MaxHeap<Integer> maxH = new MaxHeap<Integer>(ArrList);
		
			System.out.println(maxH.toString());
			
			maxH.insert(35);
			
			System.out.println(maxH.toString());
			
			try {
				
				maxH.extractMaxValue();
			
			} catch (EmptyHeapException e) {
			
				e.printStackTrace();
			
			}
			
			System.out.println(maxH.toString());		
			
			
					
			System.out.println("\nWith ArrayList");
		
			MaxHeap<Integer> maxlH = new MaxHeap<Integer>(Arr);
		
			System.out.println(maxlH.toString());
			
			maxlH.insert(35);
			
			System.out.println(maxlH.toString());
			
			try {
				
				maxlH.extractMaxValue();
			
			} catch (EmptyHeapException e) {
			
				e.printStackTrace();
			
			}
			
			System.out.println(maxlH.toString());		
			
		}
		
		
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		if (TEST_SORT) {
			
			System.out.println("\n\n################################################################\n");
		
			System.out.println("Sort Test: \n");				
				
			
			SortArray<Integer> sort = new SortArray<Integer>(Arr.clone()); 
			System.out.print("Array To Sort: ");
			sort.printArray();
		
			
			Integer[] ArrSorted = Arr.clone();
			Arrays.sort(ArrSorted);
			
			
			// Insertion Sort
			if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
				try {
			
					System.out.print("\n");
					System.out.print("InsertionSort: ");
					sort.insertionSort();			
					sort.printArray();
		
				} catch (OutOfBoundException e) {
					
					e.printStackTrace();
		
				}
		
			}
			
			
			
			// Selection Sort			
			if (TEST_SELECTION_SORT || TEST_ALL_SORT) {
		
				try {
			
					System.out.print("\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("SelectionSort: ");
					sort.selectionSort();
					sort.printArray();
			
				} catch (OutOfBoundException e) {
			
					e.printStackTrace();
		
				}
		
			}
			
			
			// Shell Sort
			if (TEST_SHELL_SORT || TEST_ALL_SORT) {
					
				try {
						
					System.out.print("\n");
					System.out.print("ShellSort: ");
					sort.shellSort();			
					sort.printArray();
					
				} catch (OutOfBoundException e) {
						
					e.printStackTrace();
					
				}
					
			}
			
			
						
			// Bubble Sort				
			if (TEST_BUBBLE_SORT || TEST_ALL_SORT) {
			
				try {
				
					System.out.print("\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("BubbleSort: ");
					sort.bubbleSort();
					sort.printArray();
				
				} catch (OutOfBoundException e) {
				
					e.printStackTrace();
			
				}
			
			}
		
		
		
			// Merge Sort	
			if (TEST_MERGE_SORT || TEST_ALL_SORT) {
			
				try {
		
					System.out.print("\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("MergeSort: ");
					sort.mergeSort();
					sort.printArray();
					
				} catch (OutOfBoundException e) {
					
					e.printStackTrace();
			
				}
		
			}
			
			
			// Heap Sort	
			if (TEST_HEAP_SORT || TEST_ALL_SORT) {
			
				try {
		
					System.out.print("\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("HeapSort: ");
					sort.heapSort();
					sort.printArray();
					
				} catch (OutOfBoundException e) {
					
					e.printStackTrace();
			
				}
		
			}			
		
		}
		
	}

}
