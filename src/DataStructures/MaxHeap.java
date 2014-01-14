package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MaxHeap <T extends Comparable<T>> {

	private ArrayList<T> heapArrList;
	
	private T[] heapArr;
	
	private ArrayList<T> arrListSorted;
	
	private T[] arrSorted;
	
	private int heapSize;

	
	
	@SuppressWarnings("unchecked")
	public MaxHeap(ArrayList<T> arrayList) {
		
		System.out.println ("Inside");
		
		this.heapSize = arrayList.size();
		
		this.heapArrList = arrayList;
		
		for (int i =(int) (heapSize/2); i > 0; i--) { 
			
			this.MaxHeapify(i);		
		
		}
		
		this.heapArr = (T[]) this.heapArrList.toArray((T[])Array.newInstance(this.heapArrList.get(0).getClass(), this.heapArrList.size()));
		
		this.arrListSorted = new ArrayList<T>();
		
		this.HeapSort();
	
	}
	
	
	
	@SuppressWarnings("unchecked")
	public MaxHeap(T[] array) {
		
		this.heapArrList = new ArrayList<T>();
		
		for (int i = 0; i < array.length; i++) {
			
			this.heapArrList.add(array[i]);
			
		}
		
		this.heapSize = this.heapArrList.size();
		
		System.out.println (heapSize);
		
		for (int i =(int) (heapSize/2); i > 0; i--) { 
			
			this.MaxHeapify(i);		
		
		}
		
		this.heapArr = (T[]) this.heapArrList.toArray((T[])Array.newInstance(this.heapArrList.get(0).getClass(), this.heapArrList.size()));
		
		this.arrListSorted = new ArrayList<T>();
								
		this.HeapSort();
		
	}		
	
	
	private void MaxHeapify(int i) {
		
		System.out.println ("Inside MAxHeapify [i] = " + i);
		
		int l = 2*i; // i left son
		
		System.out.println ("Left = " + l);
		
		int r = 2*i + 1; // i right son
		
		System.out.println ("Right = " + r);
		
		int max = i;
		
		System.out.println ("Max = " + max);
		
		if (l <= this.heapSize) {
			
			if ((this.heapArrList.get(l)).compareTo(this.heapArrList.get(i)) > 0) {
				
				max = l;
				
				System.out.println ("Max = " + max);
				
			}
			
		}
		
		if (r < this.heapSize) {
			
			if (this.heapArrList.get(r).compareTo(this.heapArrList.get(i)) > 0) {
				
				max = r;
				
				System.out.println ("Max = " + max);
				
			}
			
		}
		
		System.out.println ("Max = " + max);
		
		if (max != i) {
			
			System.out.println ("Max = " + max);
			
			T swap = this.heapArrList.get(i); 
			
			this.heapArrList.set(i, this.heapArrList.get(max));
			
			this.heapArrList.set(max, swap);
			
			System.out.println ("Max = " + max);
			
			this.MaxHeapify(max);
			
		}
				
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void HeapSort () {
		
		ArrayList<T> ArrTmp = (ArrayList<T>) this.heapArrList;
		
		int heapSize_tmp = this.heapSize;
		
		for (int i = this.heapArrList.size() - 1; i >= 1; i--) {
			
			T swap = this.heapArrList.get(i); 
			
			this.heapArrList.set(i, this.heapArrList.get(0));
			
			this.heapArrList.set(0, swap);
			
			this.heapSize--;
			
			this.MaxHeapify(0);
			
		}
		
		this.heapSize = heapSize_tmp;
		
		this.arrListSorted = this.heapArrList;
		
		this.heapArrList = ArrTmp;	
		
		this.arrSorted = (T[]) this.heapArrList.toArray((T[])Array.newInstance(this.heapArrList.get(0).getClass(), this.heapArrList.size()));
		
		
	}


	public T[] getHeapArr() {
		
		return this.heapArr;
	
	}
	
	
	public ArrayList<T> getHeapArrList() {
		
		return this.heapArrList;
	
	}

	
	public ArrayList<T> getArrListSorted() {
	
		return this.arrListSorted;
	
	}


	public T[] getArrSorted() {
	
		return this.arrSorted;
	
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arrListSorted == null) ? 0 : arrListSorted.hashCode());
		result = prime * result + Arrays.hashCode(arrSorted);
		result = prime * result + Arrays.hashCode(heapArr);
		result = prime * result
				+ ((heapArrList == null) ? 0 : heapArrList.hashCode());
		result = prime * result + heapSize;
		return result;
	}


	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		MaxHeap other = (MaxHeap) obj;
		if (arrListSorted == null) {
			if (other.arrListSorted != null)
				return false;
		} else if (!arrListSorted.equals(other.arrListSorted))
			return false;
		if (!Arrays.equals(arrSorted, other.arrSorted))
			return false;
		if (!Arrays.equals(heapArr, other.heapArr))
			return false;
		if (heapArrList == null) {
			if (other.heapArrList != null)
				return false;
		} else if (!heapArrList.equals(other.heapArrList))
			return false;
		if (heapSize != other.heapSize)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MaxHeap [heapArrList=" + heapArrList + ", heapArr="
				+ Arrays.toString(heapArr) + ", arrListSorted=" + arrListSorted
				+ ", arrSorted=" + Arrays.toString(arrSorted) + ", heapSize="
				+ heapSize + "]";
	}
	
	
	

}
