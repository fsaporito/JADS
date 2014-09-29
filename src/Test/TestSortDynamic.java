package Test;


import java.util.Arrays;

import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;
import Sort.BubbleSort;
import Sort.HeapSort;
import Sort.InsertionSort;
import Sort.MergeHybridSort;
import Sort.MergeSort;
import Sort.SelectionSort;
import Sort.ShellSort;
import Sort.Sort;
import Test.ParallelRandInt;


public class TestSortDynamic {


	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException, OutOfBoundException {
		
		boolean TEST_ALL_SORT = true;
		
		boolean JAVA_SORT = true;
		
		boolean TEST_INSERTION_SORT = false; 
		boolean TEST_SELECTION_SORT = false; 
		boolean TEST_BUBBLE_SORT = false; 
		boolean TEST_SHELL_SORT = true; 		
		boolean TEST_MERGE_SORT = true;
		boolean TEST_MERGE_SORT_HYBRID = true;
		boolean TEST_HEAP_SORT = true;
		
		int SEED = 1111;
		int LENGHT = 1000000;
		int RANGE = 1000;	
		
		long timeStart = 0;
		long timeEnd = 0;
		
		Sort<Integer> sort;		
		
		
		
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		System.out.println("\n\n################################################################\n");
		
		System.out.println("Sort Test \n");
		
		System.out.print ("Processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println ("    Threads: " + 2*Runtime.getRuntime().availableProcessors());
		
		System.out.println ("Random Array Creation [Lenght = " + LENGHT + "]");
		
		ParallelRandInt rand = new ParallelRandInt(SEED, LENGHT, RANGE);		

		timeStart = System.nanoTime();
		
		Integer[] Arr = rand.getRandIntArr();	
		
		timeEnd = System.nanoTime();
		
		System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
		
		
		
		
		// Java Sort Hybrid
		if (JAVA_SORT || TEST_ALL_SORT) {
							
			System.out.println("\n*** Java Sort ");
						
			Integer[] ArrJava = Arr.clone();
						
			timeStart = System.nanoTime();
						
			Arrays.sort(ArrJava);
						
			timeEnd = System.nanoTime();				
						
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");			
					
			sort = null;
										
		}
				
			
		// Insertion Sort
		if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** InsertionSort ");
			
			timeStart = System.nanoTime();
					
			sort = new InsertionSort<Integer>(Arr.clone()); 

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}
			
			
			
		// Selection Sort			
		if (TEST_SELECTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** SelectionSort ");
			
			timeStart = System.nanoTime();		
			
			sort = new SelectionSort<Integer>(Arr.clone());
			
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}			
			
						
		// Bubble Sort				
		if (TEST_BUBBLE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** BubbleSort ");
			
			timeStart = System.nanoTime();
			
			sort = new BubbleSort<Integer>(Arr.clone());

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
				
		}
			
			
		// Shell Sort
		if (TEST_SHELL_SORT || TEST_ALL_SORT) {
								
			System.out.println("\n*** ShellSort ");
				
			timeStart = System.nanoTime();
			
			sort = new ShellSort<Integer>(Arr.clone());		
		
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
		
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
					
		}
				
		
		// Merge Sort	
		if (TEST_MERGE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** MergeSort ");
				
			timeStart = System.nanoTime();
			
			sort = new MergeSort<Integer>(Arr.clone());
				
			timeEnd = System.nanoTime();
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
				
			System.out.println ("Sorted: " + sort.isSorted());
					
			sort = null;
					
		}
			
			
		// Merge Sort Hybrid
		if (TEST_MERGE_SORT_HYBRID || TEST_ALL_SORT) {
					
			System.out.println("\n*** MergeSort Hybrid ");
				
			timeStart = System.nanoTime();
			
			sort = new MergeHybridSort<Integer>(Arr.clone());
				
			timeEnd = System.nanoTime();				
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
				
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
								
		}
		
		
		
			
		// Heap Sort	
		if (TEST_HEAP_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** HeapSort ");

			timeStart = System.nanoTime();

			sort = new HeapSort<Integer>(Arr.clone());
			
			timeEnd = System.nanoTime();
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + sort.isSorted());
			
			sort = null;
		
		}				
		
	}

}
