package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Queue<T> {
	
	
	private ArrayList<T> Queue;
	
	
	
	
	
	
	/**
	 * Constructor With The Array List As Parameters
	 * @param Q ArrayList To Be Used As Queue
	 */
	public Queue (ArrayList<T> Q) {
		
		this.Queue = new ArrayList<T>();
		
		for (int i = 0; i < Q.size(); i++) {
			
			this.enQueue(Q.get(i));
			
		}
		
	}
	
	
	/**
	 * Constructor With An Array As Parameter
	 * @param Q Array To Be Used As Queue
	 */
	public Queue (T[] Q) {
		
		this.Queue = new ArrayList<T>();
		
		for (int i = 0; i < Q.length; i++) {
			
			this.enQueue(Q[i]);
			
		}
		
	}
	
	
	
	/**
	 * Constructor That Create A New ArrayList To Be Used As Queue
	 */
	public Queue () {
		
		this(new ArrayList<T>());
		
	}
	
	
	
	/**
	 * Add The Element At The End Of The Queue
	 * @param element Element To Add
	 */
	public void enQueue (T element) {
		
		if (this.Queue != null) {
			
			this.Queue.add(element);
		
		}
		
	}
	
	
	
	/**
	 * Remove The First Element Of The Queue
	 * @return The First Element
	 */
	public T deQueue() {
		
		if (!this.emptyQueue()) { 
			
			return this.Queue.remove(0);
		
		} else {
			
			return null;
			
		}
		
	}
	
	
	
	/**
	 * Return A Copy Of THe First ELement Of The Queue
	 * (Without Removing It)
	 * @return First Element Of The Queue 
	 */
	public T topQueue() {
		
		if (!this.emptyQueue()) { 
			
			return this.Queue.get(0);
		
		} else {
			
			return null;
			
		}
		
	}
	
	
	
	/**
	 * Verifies If The Queue Is Empty
	 * @return True If The Queue Is Empty, False Otherwise
	 */
	public boolean emptyQueue() {
		
		if (this.Queue.size() == 0) {
			
			return true;
		
		} else {
			
			return false;
			
		}
		
	}
	
	
	
	/**
	 * Create An Array With The Elements Of The Queue
	 * @return The Array
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray () {
		
		
		T[] arr = ((T[]) this.Queue.toArray((T[])Array.newInstance(this.Queue.get(0).getClass(), this.Queue.size())));
		
		return arr;
		
	}
	
	
	
	/**
	 *  Clone The Current Queue Returning A Copy
	 *  @return A New Queue 
	 */
	public ArrayList<T> clone () {
		
		return (this.Queue);
		
	}

	
	
	/**
	 * Empty The Queue
	 */
	public void clear () {
		
		this.Queue.clear();
		
	}


	
	/**
	 *  Implements The hashCode Method For A Stack
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Queue == null) ? 0 : Queue.hashCode());
		return result;
	}


	
	/**
	 *  Implements The equals Method For A Stack
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof Queue))
			return false;		
		@SuppressWarnings("unchecked")
		Queue<T> other = (Queue<T>) obj;
		if (Queue == null) {
			if (other.Queue != null)
				return false;
		} else if (!Queue.equals(other.Queue))
			return false;
		return true;
	}


	
	
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Queue [Queue=" + Queue + "]";
	}
	

	
	
	
}
