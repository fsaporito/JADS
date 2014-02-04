import java.util.ArrayList;

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
		boolean TEST_HEAP_MIN = true;
		
		boolean TEST_INSERTION_SORT = false;
		boolean TEST_SELECTION_SORT = false;
		boolean TEST_SHELL_SORT = false;
		boolean TEST_BUBBLE_SORT = false;
		boolean TEST_MERGE_SORT = true;
		boolean TEST_HEAP_SORT = true;
		
		
		
		
// ################################################################
//		Random Array Creation
// ################################################################
		
		ParallelRandInt rand = new ParallelRandInt(1111, 3, 100);	
		
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
			
			System.out.println ((int) 1/2);
		
			MinHeap<Integer> minH = new MinHeap<Integer>(Arr);
		
			System.out.println(minH.toString());
			
			minH.insert(35);
			
			System.out.println(minH.toString());
			
			try {
				
				minH.extractMinValue();
			
			} catch (EmptyHeapException e) {
			
				e.printStackTrace();
			
			}
			
			System.out.println(minH.toString());
		
		
			
		}
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		if (TEST_INSERTION_SORT || TEST_SELECTION_SORT || TEST_SHELL_SORT || TEST_BUBBLE_SORT || TEST_MERGE_SORT || TEST_HEAP_SORT) {
			
			System.out.println("\n\n################################################################\n");
		
			System.out.println("Sort Test: \n");		
		
				
		
			SortArray<Integer> sort = new SortArray<Integer>(Arr.clone()); 
			System.out.print("Array To Sort: ");
			sort.printArray();
		
				
			
			// Insertion Sort
			if (TEST_INSERTION_SORT) {
		
				try {
			
					System.out.print("\n\n");
					System.out.print("InsertionSort: ");
					sort.printArray();
					sort.insertionSort();			
					sort.printArray();
		
				} catch (OutOfBoundException e) {
			
					e.printStackTrace();
		
				}
		
			}
			
			
			
			// Selection Sort			
			if (TEST_SELECTION_SORT) {
		
				try {
			
					System.out.print("\n\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("SelectionSort: ");
					sort.printArray();
					sort.selectionSort();
					sort.printArray();
			
				} catch (OutOfBoundException e) {
			
					e.printStackTrace();
		
				}
		
			}
			
			
			// Shell Sort
			if (TEST_SHELL_SORT) {
					
				try {
						
					System.out.print("\n\n");
					System.out.print("ShellSort: ");
					sort.printArray();
					sort.shellSort();			
					sort.printArray();
					
				} catch (OutOfBoundException e) {
						
					e.printStackTrace();
					
				}
					
			}
			
			
						
			// Bubble Sort				
			if (TEST_BUBBLE_SORT) {
			
				try {
				
					System.out.print("\n\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("BubbleSort: ");
					sort.printArray();
					sort.bubbleSort();
					sort.printArray();
				
				} catch (OutOfBoundException e) {
				
					e.printStackTrace();
			
				}
			
			}
		
		
		
			// Merge Sort	
			if (TEST_MERGE_SORT) {
			
				try {
		
					System.out.print("\n\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("MergeSort: ");
					sort.printArray();
					sort.mergeSort();
					sort.printArray();
					
				} catch (OutOfBoundException e) {
					
					e.printStackTrace();
			
				}
		
			}
			
			
			// Heap Sort	
			if (TEST_HEAP_SORT) {
			
				try {
		
					System.out.print("\n\n");
					sort = new SortArray<Integer>(Arr.clone()); 
					System.out.print("HeapSort: ");
					sort.printArray();
					sort.heapSort();
					sort.printArray();
					
				} catch (OutOfBoundException e) {
					
					e.printStackTrace();
			
				}
		
			}
		
		}
		
	}

}
