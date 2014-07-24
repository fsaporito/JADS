package DataStructures;

import Exceptions.WrongArchException;

public class Arch<T> {

	/** First Node */
	private Node<T> A; 
	
	/** Second Node */
	private Node<T> B; 
	
	/** Arch Label */
	private String label; 
	
	/** Flag For Editing The Label */
	private boolean fixedLabel; 
	
	
	
	/**
	 * Constructor That Creates The Arch
	 * (fixedLabel = True)
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @throws WrongArchException 
	 */
	public Arch (Node<T> A, Node<T> B, String label) throws WrongArchException {
		
		this(A, B, label, true);
		
	}
	
	
	
	/**
	 * Constructor That Creates The Arch
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @param fixedLabel Tells If The Label Is Fixed Or Not
	 * @throws WrongArchException Wrong Parameter (Null)
	 */
	public Arch (Node<T> A, Node<T> B, String label, boolean fixedLabel) throws WrongArchException {
		
		this.archChecker(A, B, label);
		
		this.A = A;
		
		this.B = B;
		
		this.label = label;
		
		this.fixedLabel = fixedLabel;
		
	}

	
	/**
	 * Check If Every Construcor's Parameter Is
	 * Not Null
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @throws WrongArchException Wrong Parameter (Null)
	 */
	private void archChecker (Node<T> A, Node<T> B, String label) throws WrongArchException {
		
		if (A == null) {
			
			throw new WrongArchException ("First Node Is NULL!!!");
			
		}
		
		if (B == null) {
			
			throw new WrongArchException ("Second Node Is NULL!!!");
			
		}

		if (label == null) {
	
			throw new WrongArchException ("Label Is NULL!!!");
	
		}
		
	}

	/**
	 * Returns The Arch's Label
	 * 
	 * @return the label
	 */
	public String getLabel() {
		
		return this.label;
		
	}

	

	/**
	 * Changes The Current Label To label
	 * If Not Fixed (use getFixed)
	 * 
	 * @param label the label to set (If Editable)
	 */
	public void setLabel(String label) {
		
		if (this.fixedLabel) {
			
			if (label != null) {
			
				this.label = label;
		
			}	
				
		}	
			
	}
	
	
	
	/**
	 * Check If The Label Is Fixed
	 * 
	 * @return fixedLabel boolean flag
	 */
	public boolean getFixed () {
		
		return this.fixedLabel;
		
	}

	

	/**
	 * Returns The Starting Node
	 * 
	 * @return the A Node
	 */
	public Node<T> getA() {
		
		return this.A;
		
	}

	

	/**
	 * Returns The Final Node
	 * 
	 * @return the B Node
	 */
	public Node<T> getB() {
		
		return B;
		
	}

	
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((A == null) ? 0 : A.hashCode());
		result = prime * result + ((B == null) ? 0 : B.hashCode());
		result = prime * result + (fixedLabel ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Arch other = (Arch) obj;
		if (A == null) {
			if (other.A != null)
				return false;
		} else if (!A.equals(other.A))
			return false;
		if (B == null) {
			if (other.B != null)
				return false;
		} else if (!B.equals(other.B))
			return false;
		if (fixedLabel != other.fixedLabel)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}



	
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Arch:" + "  (" + this.A.getValue().toString() 
				+ "  , " + this.B.getValue().toString() + " , " + this.label + ")"
				+ "  -> FixedLabel = " + this.fixedLabel;
	
	}
	
	
}
