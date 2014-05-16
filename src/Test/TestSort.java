package Test;


import java.util.Arrays;



import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;
import Sort.SortArray;
import Test.ParallelRandInt;


public class TestSort {


	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException {
		
		boolean TEST_ALL_SORT = true;
		
		boolean TEST_INSERTION_SORT = true; 
		boolean TEST_SELECTION_SORT = false; 
		boolean TEST_SHELL_SORT = false; 
		boolean TEST_BUBBLE_SORT = false; 
		boolean TEST_MERGE_SORT = true;
		boolean TEST_MERGE_SORT_HYBRID = false; 
		boolean TEST_HEAP_SORT = true;
		
		int SEED = 1111;
		int LENGHT = 100000;
		int RANGE = 100;	
		
		
		
		
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		System.out.println("\n\n################################################################\n");
		
		System.out.println("Sort Test \n");
		
		System.out.print ("Processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println ("    Threads: " + 2*Runtime.getRuntime().availableProcessors());
		
		System.out.println ("Random Array Creation [Lenght = " + LENGHT + "]");
		
		ParallelRandInt rand = new ParallelRandInt(SEED, LENGHT, RANGE);		

		Integer[] Arr = rand.getRandIntArr();		
		
		SortArray<Integer> sort = new SortArray<Integer>(Arr.clone()); 
		
		//System.out.print("\nArray To Sort: ");
		//sort.printArray();
		
			
		Integer[] ArrSorted = Arr.clone();
		Arrays.sort(ArrSorted);
			
			
		// Insertion Sort
		if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
			try {
			
				System.out.print("\n");
				System.out.println("*** InsertionSort ");
				//sort.printArray();
				sort.insertionSort();	
				//sort.printArray();
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
				//sort.printArray();
				sort.selectionSort();
				//sort.printArray();
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
				//sort.printArray();
				sort.bubbleSort();
				//sort.printArray();
				System.out.println ("Sorted: " + sort.isSorted());
			
			} catch (OutOfBoundException e) {
				
				e.printStackTrace();
		
			}
			
		}
			
			
		// Shell Sort
		if (TEST_SHELL_SORT || TEST_ALL_SORT) {
								
			try {
									
				System.out.print("\n");
				System.out.println("*** ShellSort ");
				//sort.printArray();
				sort.shellSort();			
				//sort.printArray();
				System.out.println ("Sorted: " + sort.isSorted());
							
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
				//sort.printArray();
				sort.mergeSort();
				//sort.printArray();
				System.out.println ("Sorted: " + sort.isSorted());
					
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
				//sort.printArray();
				sort.mergeHybridSort();
				//sort.printArray();
				System.out.println ("Sorted: " + sort.isSorted());
								
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
				//sort.printArray();
				sort.heapSort();
				//sort.printArray();
				System.out.println ("Sorted: " + sort.isSorted());
				
			} catch (OutOfBoundException e) {
					
				e.printStackTrace();
		
			}
		
		}		
			
		
	}

}
