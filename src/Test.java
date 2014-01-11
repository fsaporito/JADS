import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		

// ################################################################
//		Random Array Creation
// ################################################################
		
		ParallelRandInt rand = new ParallelRandInt(100, 30, 100);	
		
		Integer[] Arr = rand.getRandIntArr();
		ArrayList<Integer> ArrList = rand.getRandIntArrList();
		


		
		

		
// ################################################################
//		Queue Test
// ################################################################		
		
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
		
		
		
		
		
// ################################################################
//		Stack Test
// ################################################################		
		
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
		
	
		
		
// ################################################################
//		Sort Test
// ################################################################		
		
		System.out.println("\n\n################################################################\n");
		System.out.println("Sort Test: \n");		
		
				
		
		SortArray<Integer> sort = new SortArray<Integer>(Arr.clone()); 
		System.out.print("Array To Sort: ");
		sort.printArray();
		
		
		// Insertion Sort
		System.out.print("\n\n");
		sort.insertionSort();
		System.out.print("InsertionSort: ");
		sort.printArray();

		
		// Selection Sort
		System.out.print("\n\n");
		sort = new SortArray<Integer>(Arr.clone()); 
		System.out.print("SelectionSort: ");
		sort.selectionSort();
		sort.printArray();
		
		
		
		//return (T[]) heapArrList.toArray((T[])Array.newInstance(heapArrList.get(0).getClass(), heapArrList.size()));

	}

}
