import java.lang.reflect.Array;
import java.util.ArrayList;


public class Stack<T> {
	
	
	private ArrayList<T> Stack;
	
	
	
	/**
	 * Constructor With An ArrayList As Parameter
	 * @param S ArrayList To Use As Stack
	 */
	public Stack (ArrayList<T> S) {
		
		this.Stack = new ArrayList<T>();
		
		for (int i = 0; i < S.size(); i++) {
			
			this.pushStack(S.get(i));
			
		}
		
	}
	
	
	/**
	 * Constructor With An Array As Parameter
	 * @param S Array To Use As Stack
	 */
	public Stack (T[] S) {
		
		this.Stack = new ArrayList<T>();
		
		for (int i = 0; i < S.length; i++) {
			
			this.pushStack(S[i]);
			
		}
		
	}
	
	
	
	/**
	 * Constructor That Create A New ArrayList To Be Used As Stack
	 */
	public Stack () {
		
		this(new ArrayList<T>());
		
	}
	
	
	
	/**
	 * Add An Item To The Stack (Inserted At Top Level)
	 * @param element Element To Add To The Stack
	 */
	public void pushStack (T element) {
		
		if (this.Stack != null) {
			
			this.Stack.add(this.Stack.size(), element);
		
		}
		
	}
	
	
	
	/**
	 * Remove The First Element Of The Stack
	 * @return The Removed Item, Null If Empty
	 */
	public T popStack() {
		
		if (!this.emptyStack()) { 
			
			return this.Stack.remove(this.Stack.size()-1);
		
		} else {
			
			return null;
			
		}
		
	}
	
	
	
	/**
	 * Return A Copy Of The First Item Of The Stack
	 * @return First Item, Null If Empty
	 */
	public T topStack() {
		
		if (!this.emptyStack()) { 
			
			return this.Stack.get(this.Stack.size());
		
		} else {
			
			return null;
			
		}
		
	}
	
	
	
	/**
	 * Verify If The Stack Is Empty
	 * @return True If The Stack Is Empty, False Otherwise
	 */
	public boolean emptyStack() {
		
		if (this.Stack.size() == 0) {
			
			return true;
		
		} else {
			
			return false;
			
		}
		
	}
	
	
	
	/**
	 * Create An Array With The Elements Of The Stack
	 * @return The Array
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray () {
		
		//T[] arr = (T[]) this.Stack.toArray();
		
		//(T[]) list.toArray( (T[])Array.newInstance (one.getClass(), list.size()) );
		
		T[] arr = (T[]) this.Stack.toArray( (T[])Array.newInstance(this.Stack.get(0).getClass(), this.Stack.size()));
		
		return arr;
		
	}
	
	
	
	/**
	 *  Clone The Current Stack Returning A Copy
	 *  @return A New Stack 
	 */
	public ArrayList<T> clone () {
		
		return (this.Stack);
		
	}

	
	
	/**
	 *  Empty The Stack
	 */
	public void clear () {
		
		this.Stack.clear();
		
	}

	

	/**
	 *  Implements The hashCode Method For A Stack
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Stack == null) ? 0 : Stack.hashCode());
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
		if (!(obj instanceof Stack))
			return false;		
		@SuppressWarnings("unchecked")
		Stack<T> other = (Stack<T>) obj;
		if (Stack == null) {
			if (other.Stack != null)
				return false;
		} else if (!Stack.equals(other.Stack))
			return false;
		return true;
	}


	
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Stack [Stack=" + Stack + "]";
	
	}
	
	
	
	
	
}
