package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Exceptions.EmptyHeapException;


public class MaxHeap <T extends Comparable<T>> {


	private ArrayList<T> heapArrList;
	
	private int heapSize;
	
	
	public MaxHeap () {
		
		this.heapSize = -1;
		
		this.heapArrList = new ArrayList<T>();
		
	}
	
	
	
	public MaxHeap(ArrayList<T> arrayList) {
		
		this.heapSize = arrayList.size() -1;
		
		this.heapArrList = arrayList;
		
		this.buildHeap();
		
	}
	
	

	public MaxHeap(T[] array) {
		
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
			
				this.MaxHeapify(i);
					
			}
			
		}
		
	}
	
	
	
	private void MaxHeapify(int i) {
		
		if (this.heapSize > 0) { // More Than One Element
			
			int l = 2*i; // i Left Son
			int r = 2*i + 1; // i Right Son
		
			int Max = i;
		
			if (l <= this.heapSize) {
				
				if ((this.heapArrList.get(l)).compareTo(this.heapArrList.get(Max)) > 0) {
				
					Max = l;
				
				}
			
			}
		
			if (r <= this.heapSize) {
			
				if (this.heapArrList.get(r).compareTo(this.heapArrList.get(Max)) > 0) {
				
					Max = r;
				
				}
			
			}
		
			if (Max != i) {
			
				T swap = this.heapArrList.get(i); 
				
				this.heapArrList.set(i, this.heapArrList.get(Max));
			
				this.heapArrList.set(Max, swap);
			
				this.MaxHeapify(Max);
			
			}
				
		}
		
	}
	
	
	public T extractMaxValue () throws EmptyHeapException {
		
		if (this.heapArrList.size() == 0) {
			
			throw new EmptyHeapException ("Heap Is Empty");
			
		}
		
		T MaxValue = this.heapArrList.get(0);
		
		T lastValue = this.heapArrList.get(this.heapSize);
		
		this.heapArrList.set(0, lastValue);
		
		this.heapArrList.remove(this.heapSize);
		
		this.heapSize = this.heapSize - 1;
		
		this.MaxHeapify(0);
		
		return MaxValue;
		
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
	 * Create An Array With The Elements Of The Max Heap
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
		MaxHeap<?> other = (MaxHeap<?>) obj;
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
		return "MaxHeap [heapArrList=" + heapArrList + ", heapSize=" + heapSize
				+ "]";
	}
	
	
	
}
