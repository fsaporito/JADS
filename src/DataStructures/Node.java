package DataStructures;

public class Node<T> {
	
	/** Node's Value */
	private T value; 
	
	/** Flag For Editing The Value */
	private boolean fixedValue; 
	
	/** Node Color */
	private String color;
	
	
	
	/**
	 * Constructor That Creates The Node
	 * (fixedValue = true)
	 * (color = WHITE)
	 * 
	 * @param value Node's Value
	 */
	public Node (T value) {
		
		this(value, true);
		
	}
	
	
	
	/**
	 * Constructor That Creates The Node
	 * (color = WHITE)
	 * 
	 * @param value Node's Value
	 * @param fixedValue Tells If The Value Is Fixed Or Not
	 */
	public Node (T value, boolean fixedValue) {
		
		this.value = value;
		
		this.fixedValue = fixedValue;
		
		this.color = "WHITE";
		
	}
	

	
	/**
	 * Returns The Node's Value
	 * 
	 * @return the value
	 */
	public T getValue() {
	
		return value;
	
	}

	
	
	/**
	 * Changes The Current Label To label
	 * If Not Fixed (use getFixed)
	 * 
	 * @param value the value to set
	 */
	public void setValue (T value) {
		
		if (this.fixedValue) {
			
			this.value = value;
	
		}
			
	}	
	
	
	
	/**
	 * Returns The Node's Value
	 * 
	 * @return the color
	 */
	public String getColor () {
		
		return this.color;
		
	}
	
	
	/**
	 * Changes The Current Color To Color
	 * 
	 * @return the color
	 */
	public void setColor (String color) {
		
		if (color != null) {
			
			this.color = color;
			
		}
		
	}
	
	
	/**
	 * Changes The Current Color To WHITE
	 * 
	 * @return the color
	 */
	public void setColorWhite () {
		
		this.color = "WHITE";
		
	}
	
	
	
	/**
	 * Check If The Label Is Fixed
	 * 
	 * @return fixedLabel boolean flag
	 */
	public boolean getFixed () {
		
		return this.fixedValue;
		
	}

	
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (fixedValue ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		@SuppressWarnings("rawtypes")
		Node other = (Node) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (fixedValue != other.fixedValue)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	

	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String toString = "Node " + this.value;
		
		if (this.fixedValue) {
			
			toString += " (Fixed Value)";
			
		} else {
			
			toString += " (Non Fixed Value)";
			
		}
		
		toString += " - color=" + this.color;
		
		toString += " - hashCode()=" + hashCode();
		
		return toString;
	
	}



}
