import java.util.ArrayList;

import DataStructures.Queue;
import DataStructures.Stack;
import Exceptions.EmptyArrayException;
import Exceptions.OutOfBoundException;
import parallelRandomGenerator.ParallelRandInt;


public class Test {

	public static void main(String[] args) throws EmptyArrayException {
		
		
		boolean TEST_QUEUE = false;
		boolean TEST_STACK = false;
		boolean TEST_INSERTION_SORT = false;
		boolean TEST_SELECTION_SORT = false;
		boolean TEST_MERGE_SORT = true;
		
		
		
		
// ################################################################
//		Random Array Creation
// ################################################################
		
		ParallelRandInt rand = new ParallelRandInt(1111, 200, 1000000);	
		
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
//		Sort Test
// ################################################################		
		
		if (TEST_INSERTION_SORT || TEST_SELECTION_SORT || TEST_MERGE_SORT) {
			
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
		
		}
		
	}

}
