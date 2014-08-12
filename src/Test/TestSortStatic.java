package Test;


import java.util.Arrays;

import Exceptions.EmptyArrayException;
import Exceptions.EmptyHeapException;
import Exceptions.OutOfBoundException;

import Sort.Sort;
import Sort.SortStatic;

import Test.ParallelRandInt;


public class TestSortStatic {


	public static void main(String[] args) throws EmptyArrayException, EmptyHeapException, OutOfBoundException {
		
		boolean TEST_ALL_SORT = true;
		
		boolean JAVA_SORT = true;
		
		boolean TEST_INSERTION_SORT = false; 
		boolean TEST_SELECTION_SORT = false; 
		boolean TEST_BUBBLE_SORT = false; 
		boolean TEST_SHELL_SORT = true; 		
		boolean TEST_MERGE_SORT = true;
		boolean TEST_MERGE_SORT_HYBRID = true;
		boolean TEST_HEAP_SORT = false;
		
		int SEED = 1111;
		int LENGHT = 100000;
		int RANGE = 100;	
		
		long timeStart = 0;
		long timeEnd = 0;
		
		
		
		
		
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
		
		System.out.println (" Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
		
		
		
		// Java Sort
		if (JAVA_SORT || TEST_ALL_SORT) {
							
			System.out.println("\n*** Java Sort ");
						
			Integer[] ArrJava = Arr.clone();
						
			timeStart = System.nanoTime();
						
			Arrays.sort(ArrJava);
						
			timeEnd = System.nanoTime();				
						
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");	
			
			System.out.println ("Sorted: " + Sort.isSorted(ArrJava));
										
		}
				
			
		// Insertion Sort
		if (TEST_INSERTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** InsertionSort ");
			
			timeStart = System.nanoTime();
					
			SortStatic.insertionSort(Arr);

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.insertionSort(Arr)));
				
		}
			
			
			
		// Selection Sort			
		if (TEST_SELECTION_SORT || TEST_ALL_SORT) {
		
			System.out.println("\n*** SelectionSort ");
			
			timeStart = System.nanoTime();		
			
			SortStatic.selectionSort(Arr);
			
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.selectionSort(Arr)));
				
		}			
			
						
		// Bubble Sort				
		if (TEST_BUBBLE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** BubbleSort ");
			
			timeStart = System.nanoTime();

			SortStatic.bubbleSort(Arr);

			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.bubbleSort(Arr)));
				
		}
			
			
		// Shell Sort
		if (TEST_SHELL_SORT || TEST_ALL_SORT) {
								
			System.out.println("\n*** ShellSort ");
				
			timeStart = System.nanoTime();
			
			SortStatic.shellSort(Arr);	
		
			timeEnd = System.nanoTime();				
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.shellSort(Arr)));
					
		}
				
		
		// Merge Sort	
		if (TEST_MERGE_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** MergeSort ");
				
			timeStart = System.nanoTime();
			
			SortStatic.mergeSort(Arr);
				
			timeEnd = System.nanoTime();
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.mergeSort(Arr)));
					
		}
			
			
		// Merge Sort Hybrid
		if (TEST_MERGE_SORT_HYBRID || TEST_ALL_SORT) {
					
			System.out.println("\n*** MergeSort Hybrid ");
				
			timeStart = System.nanoTime();
			
			SortStatic.mergeHybridSort(Arr);
				
			timeEnd = System.nanoTime();				
				
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.mergeHybridSort(Arr)));
			
		}
		
		
		
			
		// Heap Sort	
		if (TEST_HEAP_SORT || TEST_ALL_SORT) {
			
			System.out.println("\n*** HeapSort ");			
			
			timeStart = System.nanoTime();
			
			SortStatic.heapSort(Arr);
			
			timeEnd = System.nanoTime();	
			
			System.out.println ("Time: " + (timeEnd-timeStart) + " ns = " + ((timeEnd-timeStart)*(Math.pow(10,-9))) + " s");
			
			System.out.println ("Sorted: " + Sort.isSorted(SortStatic.heapSort(Arr)));
		
		}				
		
	}

}
