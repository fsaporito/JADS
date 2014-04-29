package Test;


import java.util.Arrays;



import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;
import Sort.SortArray;
import Test.ParallelRandInt;


public class TestSort {


	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException {
		
		boolean TEST_ALL_SORT = false;
		
		boolean TEST_INSERTION_SORT = false;
		boolean TEST_SELECTION_SORT = false;
		boolean TEST_SHELL_SORT = false;
		boolean TEST_BUBBLE_SORT = false;
		boolean TEST_MERGE_SORT = true;
		boolean TEST_MERGE_SORT_HYBRID = true;
		boolean TEST_HEAP_SORT = false;
		
		int SEED = 1111;
		int LENGHT = 50000000;
		int RANGE = 100;		
		
		
		
		
// ################################################################
//		Random Array Creation
// ################################################################
		
		
		
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		System.out.println("\n\n################################################################\n");
		
		System.out.println("Sort Test \n");			
		
		System.out.println ("Random Array Creation");
		
		ParallelRandInt rand = new ParallelRandInt(SEED, LENGHT, RANGE);		
		Integer[] Arr = rand.getRandIntArr();	
		
		System.out.println ("DONE!!! ");
		System.out.println ("Lenght = " + LENGHT);
		
		
				
		
		SortArray<Integer> sort = new SortArray<Integer>(Arr.clone()); 
		//System.out.print("Array To Sort: ");
		//sort.printArray();
		
			
		Integer[] ArrSorted = Arr.clone();
		Arrays.sort(ArrSorted);
			
			
		// Insertion Sort
		if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
			try {
			
				System.out.print("\n");
				System.out.println("*** InsertionSort ");
				sort.insertionSort();			
				System.out.println ("Sorted: " + sort.isSorted());
		
			} catch (OutOfBoundException e) {
				
				e.printStackTrace();
		
			}
		
		}
			
			
			
		// Selection Sort			
		if (TEST_SELECTION_SORT || TEST_ALL_SORT) {
		
			try {
			
				System.out.print("\n");
				sort = new SortArray<Integer>(Arr.clone()); 
				System.out.println("*** SelectionSort ");
				sort.selectionSort();
				System.out.println ("Sorted: " + sort.isSorted());
		
			} catch (OutOfBoundException e) {
		
				e.printStackTrace();
		
			}
		
		}			
			
						
		// Bubble Sort				
		if (TEST_BUBBLE_SORT || TEST_ALL_SORT) {
			
			try {
				
				System.out.print("\n");
				sort = new SortArray<Integer>(Arr.clone()); 
				System.out.println("*** BubbleSort ");
				sort.bubbleSort();
				System.out.print ("Sorted: "); 
				System.out.println(sort.isSorted());
			
			} catch (OutOfBoundException e) {
				
				e.printStackTrace();
		
			}
			
		}
			
			
		// Shell Sort
		if (TEST_SHELL_SORT || TEST_ALL_SORT) {
								
			try {
									
				System.out.print("\n");
				System.out.println("*** ShellSort ");
				sort.shellSort();			
				System.out.print ("Sorted: "); 
				System.out.println(sort.isSorted());
							
			} catch (OutOfBoundException e) {
									
				e.printStackTrace();
								
			}
								
		}
				
		
		// Merge Sort	
		if (TEST_MERGE_SORT || TEST_ALL_SORT) {
			
			try {
		
				System.out.print("\n");
				sort = new SortArray<Integer>(Arr.clone()); 
				System.out.println("*** MergeSort ");
				sort.mergeSort();
				System.out.print ("Sorted: "); 
				System.out.println(sort.isSorted());
					
			} catch (OutOfBoundException e) {
					
				e.printStackTrace();
			
			}
		
		}
			
			
		// Merge Sort Hybrid
		if (TEST_MERGE_SORT_HYBRID || TEST_ALL_SORT) {
					
			try {
					
				System.out.print("\n");
				sort = new SortArray<Integer>(Arr.clone()); 
				System.out.println("*** MergeSort Hybrid ");
				sort.mergeSortHybrid();
				System.out.print ("Sorted: "); 
				System.out.println(sort.isSorted());
								
			} catch (OutOfBoundException e) {
								
				e.printStackTrace();
						
			}
					
		}
		
			
		// Heap Sort	
		if (TEST_HEAP_SORT || TEST_ALL_SORT) {
			
			try {
		
				System.out.print("\n");
				sort = new SortArray<Integer>(Arr.clone()); 
				System.out.println("*** HeapSort ");
				sort.heapSort();
				System.out.print ("Sorted: "); 
				System.out.println(sort.isSorted());
				
			} catch (OutOfBoundException e) {
					
				e.printStackTrace();
		
			}
		
		}		
			
		
	}

}
