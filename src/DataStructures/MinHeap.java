package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Exceptions.EmptyHeapException;


public class MinHeap <T extends Comparable<T>> {


	/** ArrayList Used To Contain The Heap's Elements */
	private ArrayList<T> heapArrList;
	
	/** Heap'Elements Numner */
	private int heapSize;
	
	
	public MinHeap () {
		
		this.heapSize = -1;
		
		this.heapArrList = new ArrayList<T>();
		
	}
	
	
	
	public MinHeap(ArrayList<T> arrayList) {
		
		this.heapSize = arrayList.size() -1;
		
		this.heapArrList = arrayList;
		
		this.buildHeap();
		
	}
	
	

	public MinHeap(T[] array) {
		
		this.heapArrList = new ArrayList<T>();
				
		for (int i = 0; i < array.length; i++) {
			
			this.heapArrList.add(array[i]);
			
		}		
	
		this.heapSize = this.heapArrList.size() -1;
		
		this.buildHeap();
		
	}
	
	
	
	private void buildHeap () {
		
		if (this.heapSize > 0) {		
			
			for (int i =(int) (heapSize/2); i >= 0; i--) { 
			
				this.minHeapify(i);
					
			}
			
		}
		
	}
	
	
	
	private void minHeapify(int i) {
		
		if (this.heapSize > 0) { // More Than One Element
			
			int l = 2*i; // i Left Son
			int r = 2*i + 1; // i Right Son
		
			int min = i;
		
			if (l <= this.heapSize) {
				
				if ((this.heapArrList.get(l)).compareTo(this.heapArrList.get(min)) < 0) {
				
					min = l;
				
				}
			
			}
		
			if (r <= this.heapSize) {
			
				if (this.heapArrList.get(r).compareTo(this.heapArrList.get(min)) < 0) {
				
					min = r;
				
				}
			
			}
		
			if (min != i) {
			
				T swap = this.heapArrList.get(i); 
				
				this.heapArrList.set(i, this.heapArrList.get(min));
			
				this.heapArrList.set(min, swap);
			
				this.minHeapify(min);
			
			}
				
		}
		
	}
	
	
	public T extractMinValue () throws EmptyHeapException {
		
		if (this.heapArrList.size() == 0) {
			
			throw new EmptyHeapException ("Heap Is Empty");
			
		}
		
		T minValue = this.heapArrList.get(0);
		
		T lastValue = this.heapArrList.get(this.heapSize);
		
		this.heapArrList.set(0, lastValue);
		
		this.heapArrList.remove(this.heapSize);
		
		this.heapSize = this.heapSize - 1;
		
		this.minHeapify(0);
		
		return minValue;
		
	}
	
	
	public void insert (T value) {
		
		this.heapArrList.add(value);
				
		this.heapSize++;
						
		this.buildHeap();
		
		
	}



	/**
	 * @return the heapArrList
	 */
	public ArrayList<T> clone() {
		
		return this.heapArrList;
	
	}
	
	
	
	/**
	 * Create An Array With The Elements Of The Min Heap
	 * @return The Array
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray () {
		
		T[] arr = (T[]) this.heapArrList.toArray( (T[])Array.newInstance(this.heapArrList.get(0).getClass(), this.heapSize));
		
		return arr;
		
	}



	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((heapArrList == null) ? 0 : heapArrList.hashCode());
		result = prime * result + heapSize;
		return result;
	}



	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MinHeap<?> other = (MinHeap<?>) obj;
		if (heapArrList == null) {
			if (other.heapArrList != null)
				return false;
		} else if (!heapArrList.equals(other.heapArrList))
			return false;
		if (heapSize != other.heapSize)
			return false;
		return true;
	}



	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MinHeap [heapArrList=" + heapArrList + ", heapSize=" + heapSize
				+ "]";
	}
	
	
	
	
	
	
	
	
	


	
	
	
	
}
