package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.security.SecureRandom;


/**
 * From ParallerRandomGenerator
 * https://github.com/sapo93/ParallelRandomGenerator
 * @author sapo93
 *
 */
public class ParallelRandInt extends SecureRandom implements Runnable {

	
private static final long serialVersionUID = 1L;
	
	/** ArrayList Containing The Random Numbers */
	private ArrayList<Integer> randIntArrList;
		
	/** Number Of Core Available */
	private int cores;
	
	/** Number Of Threads To Use */
	private int threadNum;
	
	/** // Random Sequence's Length */
	private int seqLength; 
	
	/** Random Number's Length For Every Thread */
	private int seqPerThread;
		
	/** Range For The Random Numbers */
	private int range; // 
		
	/** Threads' Array */
	private Thread[] t; // 

	
	
	/** 
	 * Constructor Without Seed
	 * @param seqLength Random Number's Length
	 * @param range Range For The Random Numbers
	 */
	public ParallelRandInt(int seqLength, int range) {
		
		byte[] seed = this.generateSeed(seqLength);
		
		this.setSeed(seed);
		
		this.ParallelRandIntInitialise (seqLength, range);
		
	}
	
	
	
	/** 
	 * Constructor With Seed
	 * @param seed Seed Used To Generate The Random Values
	 * @param seqLength Random Number's Length
	 * @param range Range For The Random Numbers
	 */
	public ParallelRandInt(long seed, int seqLength, int range) {
			
		this.setSeed(seed);
	
		this.ParallelRandIntInitialise (seqLength, range);		
		
	}
		
	
	
	/** 
	 * Method that initialise the object
	 * @param seqLength Random Number's Length
	 * @param range Range For The Random Numbers
	 */
	private void ParallelRandIntInitialise (int seqLength, int range) {
		
		this.randIntArrList = new ArrayList<Integer>();
		
		this.seqLength = seqLength;
		
		this.range = range;
		
		this.cores = Runtime.getRuntime().availableProcessors();
		
		this.threadNum = 2*this.cores;
		
		// If more core than required random number, decrease thread number
		while (this.threadNum > this.seqLength) { 
			
			this.threadNum--;
			
		}			
		
		// Random Number Per Core
		this.seqPerThread = (int)(this.seqLength / this.threadNum);
		
		// Initialize Threads Array
		this.t = new Thread[this.threadNum];
		
		// Create And Start The Threads
		for (int i = 0; i < this.threadNum; i++) {
		
			t[i] = new Thread (this, "Rand Int Thread " + i);
			
			t[i].start();
		
		}		
		
		
		for (int i = 0; i < this.threadNum; i++) {
			
			while (t[i].isAlive()) {
				
				try {
					
					Thread.sleep(50);
				
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				
				}					
				
			}
		
		}	
		
		
		// Number Of The Remaining Random Values To Calculate
		int remainingNumbers = this.seqLength - (this.seqPerThread*this.threadNum); 
		
		// If There Are Other Numbers To Calculate
		if (remainingNumbers > 0) {
			
			this.IntegerRandGen(remainingNumbers, this.range);
			
			
		}			
			
	}
		
	
	
	/** 
	 * Runnable Method For Thread Execution
	 */
	@Override
	public void run() {
			
		this.IntegerRandGen(this.seqPerThread, this.range);
				
	}

	
	
	/** 
	 * Calculate Random Integers With Inputed Arguments
	 * @param seqLength Array's Length
	 * @param range Range For The Random Numbers
	 * @throws InterruptedException 
	 */
	public synchronized void IntegerRandGen (int seqLength, int range) {
		
		for (int i = 0; i < seqLength; i++) {
			
			this.randIntArrList.add(this.nextInt(range));		
			
		}
		
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
	 * Return The ArrayList Size
	 * @return Int Contatining The ArrayList Size
	 */
	public int getRandIntArrSize() {
		
		return this.randIntArrList.size();
		
	}
	
	
	 /**
     * Outputs A String Containing Used Algorithm
     */
	public String getAlgo () {
		
		return this.getAlgorithm();
		
	}
	
	
	
    /**
     * Outputs A String Containing The Random Integers
     */
	@Override
	public String toString() {
		
		return randIntArrList.toString();
		
	}
	
		

}
