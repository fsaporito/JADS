

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class ParallelRandInt extends Random implements Runnable {

	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Integer> randIntArrList; // ArrayList Containing The Random Numbers
		
	private int cores; // Number Of Core Available
	
	private int threadNum; // Number Of Threads To Use
	
	private int seqLength; // Random Number's Length
	
	private int seqPerThread; // Random Number's Length For Every Thread
		
	private int range; // Range For The Random Numbers
		
	private Thread[] t; // Threads' Array

	
	
	
	/** 
	 * Constructor
	 * @param seed Seed Used To Generate The Random Values
	 * @param seqLength Random Number's Length
	 * @param range Range For The Random Numbers
	 */
	public ParallelRandInt(long seed, int seqLength, int range) {
			
		super(seed);
		
		this.randIntArrList = new ArrayList<Integer>();
		
		this.seqLength = seqLength;
		
		this.range = range;
		
		this.cores = Runtime.getRuntime().availableProcessors();
		
		this.threadNum = this.cores;
		
		// If more core than required random number, decrease thread number
		if (this.threadNum > this.seqLength) { 
			
			this.threadNum = this.seqLength;
			
		}		
		
		// Random Number Per Core
		this.seqPerThread = (int)(this.seqLength / this.threadNum);
	
		
		// Initialize Threads Array
		this.t = new Thread[this.threadNum];
		
		// Create And Start The Threads
		for (int i = 0; i < this.threadNum; i++) {
		
			t[i] = new Thread (this, "Rand Int THread " + i);
						
			t[i].run();
		
		}
		
		// Number Of The Remaining Random Values To Calculate
		int remainingNumbers = this.seqLength - (this.seqPerThread*this.threadNum); 
		
		// If There Are Other Numbers To Calculate
		if (remainingNumbers > 0) {
			
			Integer[] rem = new Integer[remainingNumbers];
			
			rem = this.IntegerRandGen(remainingNumbers, this.range);
			
			// Add The Remaining Random Numbers To The ArrayList
			for (int i = 0; i < rem.length; i++) {
				
				this.randIntArrList.add(rem[i]);
				
			}
			
		}
		
		
			
	}
		
	
	
	/** 
	 * Runnable Method For Thread Execution
	 */
	@Override
	public void run() {
			
		Integer[] integ = this.IntegerRandGen();
		
		for (int i=0; i<integ.length; i++) {
				
			this.randIntArrList.add(integ[i]);
				
		}
			
	}

	
	
	/** 
	 * Calculate Random Integers With Private Arguments
	 * @return Integer Array Of Random Numbers
	 */
	private Integer[] IntegerRandGen () {
			
		return this.IntegerRandGen(this.seqPerThread, this.range);
			
	}
	
	
	
	/** 
	 * Calculate Random Integers With Inputed Arguments
	 * @param seqLength Array's Length
	 * @param range Range For The Random Numbers
	 * @return Integer Array Of Random Numbers
	 */
	public Integer[] IntegerRandGen (int seqLength, int range) {
		
		Integer[] Arr = new Integer[seqLength];
		
		for (int i = 0; i < seqLength; i++) {
			
			Arr[i] = this.nextInt(range);
			
		}
		
		return Arr;
		
	}


		
	
	/** 
	 * Return The Integer ArrayList
	 * @return Integer ArrayList Containing The Random Numbers
	 */
	public ArrayList<Integer> getRandIntArrList() {
		
		return this.randIntArrList;
	
	}
	
	
	
	/** 
	 * Return The Integer Array
	 * @return Integer Array Containing The Random Numbers
	 */
	public Integer[] getRandIntArr() {
		
		Integer[] randIntArr = new Integer[this.randIntArrList.size()];
		
		randIntArr = this.randIntArrList.toArray(((Integer[])Array.newInstance(this.randIntArrList.get(0).getClass(), this.randIntArrList.size())));
				
		return randIntArr;
	
	}

	
	
    /**
     * Outputs A String Containing The Random Integers
     */
	@Override
	public String toString() {
		
		return "randInt [randIntArrList=" + randIntArrList + "]";
		
	}
	
		

}
