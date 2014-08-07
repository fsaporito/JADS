package Test;


import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;
import Sort.SortArray;
import Test.ParallelRandInt;


public class TestSort {


	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException, OutOfBoundException {
		
		boolean TEST_ALL_SORT = false;
		
		boolean TEST_INSERTION_SORT = false; 
		boolean TEST_SELECTION_SORT = false; 
		boolean TEST_BUBBLE_SORT = false; 
		boolean TEST_SHELL_SORT = true; 		
		boolean TEST_MERGE_SORT = true;
		boolean TEST_MERGE_SORT_HYBRID = true; 
		boolean TEST_HEAP_SORT = false;
		
		int SEED = 1111;
		int LENGHT = 10000000;
		int RANGE = 100;	
		
		long timeStart = 0;
		long timeEnd = 0;
		
		SortArray<Integer> sort;		
		
		
		
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		System.out.println("\n\n################################################################\n");
		
		System.out.println("Sort Test \n");
		
		System.out.print ("Processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println ("    Threads: " + 2*Runtime.getRuntime().availableProcessors());
		
		System.out.print ("Random Array Creation [Lenght = " + LENGHT + "]");
		
		ParallelRandInt rand = new ParallelRandInt(SEED, LENGHT, RANGE);		

		timeStart = System.nanoTime();
		
		Integer[] Arr = rand.getRandIntArr();	
		
		timeEnd = System.nanoTime();
		
		System.out.println (" Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
		
				
			
		// Insertion Sort
		if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** InsertionSort ");
			
			sort = new SortArray<Integer>(Arr.clone()); 
				
			timeStart = System.nanoTime();
			
			sort.insertionSort();	

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}
			
			
			
		// Selection Sort			
		if (TEST_SELECTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** SelectionSort ");
			
			sort = new SortArray<Integer>(Arr.clone()); 
				
			timeStart = System.nanoTime();
				
			sort.selectionSort();
			
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}			
			
						
		// Bubble Sort				
		if (TEST_BUBBLE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** BubbleSort ");
			
			sort = new SortArray<Integer>(Arr.clone()); 
			
			timeStart = System.nanoTime();
			
			sort.bubbleSort();

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}
			
			
		// Shell Sort
		if (TEST_SHELL_SORT || TEST_ALL_SORT) {
								
			System.out.println("\n*** ShellSort ");
				
			sort = new SortArray<Integer>(Arr.clone());	
		
			timeStart = System.nanoTime();
		
			sort.shellSort();			
		
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
		
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
					
		}
				
		
		// Merge Sort	
		if (TEST_MERGE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** MergeSort ");
				
			sort = new SortArray<Integer>(Arr.clone());				
				
			timeStart = System.nanoTime();
				
			sort.mergeSort();
				
			timeEnd = System.nanoTime();
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
				
			System.out.println ("Sorted: " + sort.isSorted());
					
			sort = null;
					
		}
			
			
		// Merge Sort Hybrid
		if (TEST_MERGE_SORT_HYBRID || TEST_ALL_SORT) {
					
			System.out.println("\n*** MergeSort Hybrid ");
				
			sort = new SortArray<Integer>(Arr.clone()); 				
				
			timeStart = System.nanoTime();
				
			sort.mergeHybridSort();
				
			timeEnd = System.nanoTime();				
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
				
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
								
		}
		
			
		// Heap Sort	
		if (TEST_HEAP_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** HeapSort ");
			
			sort = new SortArray<Integer>(Arr.clone()); 
				
			timeStart = System.nanoTime();
			
			sort.heapSort();
			
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
		
		}				
		
	}

}
