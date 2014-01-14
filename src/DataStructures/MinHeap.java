package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;


public class MinHeap <T extends Comparable<T>> {


	private ArrayList<T> heapArrList;
	
	private T[] heapArr;
	
	private ArrayList<T> arrListSorted;
	
	private T[] arrSorted;
	
	private int heapSize;
	
	
	@SuppressWarnings("unchecked")
	public MinHeap(ArrayList<T> arrayList) {
		
		this.heapSize = arrayList.size();
		
		this.heapArrList = arrayList;
		
		for (int i =(int) (heapSize/2); i > 0; i--) { 
			
			this.MinHeapify(i);		
		
		}
		
		this.heapArr = (T[]) this.heapArrList.toArray();
		
		this.arrListSorted = new ArrayList<T>();
		
		this.HeapSort();
	
	}
	
	
	@SuppressWarnings("unchecked")
	public MinHeap(T[] array) {
		
		this.heapArrList = new ArrayList<T>();
		
		for (int i = 0; i < array.length; i++) {
			
			this.heapArrList.add(array[i]);
			
		}
		
		for (int i =(int) (heapSize/2); i > 0; i--) { 
			
			this.MinHeapify(i);		
		
		}
		
		this.heapArr = (T[]) this.heapArrList.toArray();
		
		this.arrListSorted = new ArrayList<T>();
								
		this.HeapSort();
		
	}
	
	
	private void MinHeapify(int i) {
		
		int l = 2*i; // i left son
		int r = 2*i + 1; // i right son
		
		int min = i;
		
		if (l <= this.heapSize) {
			
			if ((this.heapArrList.get(l)).compareTo(this.heapArrList.get(i)) < 0) {
				
				min = l;
				
			}
			
		}
		
		if (r <= this.heapSize) {
			
			if (this.heapArrList.get(r).compareTo(this.heapArrList.get(i)) < 0) {
				
				min = r;
				
			}
			
		}
		
		if (min != i) {
			
			T swap = this.heapArrList.get(i); 
			
			this.heapArrList.set(i, this.heapArrList.get(min));
			
			this.heapArrList.set(min, swap);
			
			this.MinHeapify(min);
			
		}
				
	}
	
	
	@SuppressWarnings("unchecked")
	private void HeapSort () {
		
		ArrayList<T> ArrTmp = (ArrayList<T>) this.heapArrList;
		
		int heapSize_tmp = this.heapSize;
		
		for (int i = this.heapArrList.size(); i >= 1; i--) {
			
			T swap = this.heapArrList.get(i); 
			
			this.heapArrList.set(i, this.heapArrList.get(0));
			
			this.heapArrList.set(0, swap);
			
			this.heapSize--;
			
			this.MinHeapify(0);
			
		}
		
		this.heapSize = heapSize_tmp;
		
		this.arrListSorted = this.heapArrList;
		
		this.heapArrList = ArrTmp;	
		
		this.arrSorted = (T[]) this.heapArrList.toArray();
		
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
	public String toString() {
		return "MinHeap [heapArrList=" + heapArrList + ", heapArr="
				+ Arrays.toString(heapArr) + ", arrListSorted=" + arrListSorted
				+ ", arrSorted=" + Arrays.toString(arrSorted) + ", heapSize="
				+ heapSize + "]";
	}	

	
	
	
	
}
