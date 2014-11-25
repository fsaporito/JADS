package DataStructures;

import Exceptions.WrongArchException;

public class Arch<T extends Comparable<T>> {

	/** First Node */
	private Node<T> A; 
	
	/** Second Node */
	private Node<T> B; 
	
	/** Arch Label */
	private String label; 
	
	/** Flag For Editing The Label */
	private boolean fixedLabel; 
	
	/** Arch Weight */
	private double weight;
	
	/** Arch Type */
	private String type;
	
	
	/**
	 * Constructor That Creates The Arch
	 * (fixedLabel = True)
	 * (weight = 1)
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @throws WrongArchException 
	 */
	public Arch (Node<T> A, Node<T> B, String label) throws WrongArchException {
		
		this(A, B, label, true, 1.0);
		
	}
	
	
	
	/**
	 * Constructor That Creates The Arch
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @param fixedLabel Tells If The Label Is Fixed Or Not
	 * @param weight Arch Weight (Default = 1)
	 * @throws WrongArchException Wrong Parameter (Null)
	 */
	public Arch (Node<T> A, Node<T> B, String label, boolean fixedLabel, double weight) throws WrongArchException {
		
		this.archChecker(A, B, label, weight);
		
		this.A = A;
		
		this.B = B;
		
		this.label = label;
		
		this.fixedLabel = fixedLabel;
		
		this.weight = weight;
		
		this.type = null;
		
	}

	
	/**
	 * Check If Every Construcor's Parameter Is
	 * Not Null
	 * 
	 * @param A First Node
	 * @param B Second Node
	 * @param label Arch's Label
	 * @param weight Arch Weight
	 * @throws WrongArchException Wrong Parameter (Null)
	 */
	private void archChecker (Node<T> A, Node<T> B, String label, double weight) throws WrongArchException {
		
		if (A == null) {
			
			throw new WrongArchException ("First Node Is NULL!!!");
			
		}
		
		if (B == null) {
			
			throw new WrongArchException ("Second Node Is NULL!!!");
			
		}

		if (label == null) {
	
			throw new WrongArchException ("Label Is NULL!!!");
	
		}
		
		if (weight < 0) {
			
			throw new WrongArchException ("Weight Is Negative!!!");
	
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
		
		return this.B;
		
	}
	
	
	
	/**
	 * Returns The Arch Weight
	 * 
	 * @return the Weight
	 */
	public double getWeight() {
		
		return this.weight;
	
	}


	/**
	 * Changes The Weight To weight
	 * 
	 * @param weight the new weight
	 */
	public void setWeight (double weight) {
		
		this.weight = weight;
	
	}


	
	/**
	 * Returns The Arch Type
	 * (Null If Not Set)
	 * 
	 * @return the arch type
	 */
	public String getType() {
		
		return this.type;
	}

	
	/**
	 * Check The Current Type Is TreeEdge
	 * 
	 */
	public boolean IsTypeTreeEdge () {
		
		boolean returnValue = false;
		
		if (this.type != null) {
		
			if (this.type.equals("TreeEdge")) {
			
				returnValue = true;
			
			}
			
		}
		
		return returnValue;
	
	}
	
	
	/**
	 * Check The Current Type Is BackEdge
	 * 
	 */
	public boolean IsTypeBackEdge () {
		
		boolean returnValue = false;
		
		if (this.type != null) {
		
			if (this.type.equals("BackEdge")) {
			
				returnValue = true;
			
			}
			
		}
		
		return returnValue;
	
	}
	
	
	/**
	 * Check The Current Type Is ForwardEdge
	 * 
	 */
	public boolean IsTypeForwardEdge () {
		
		boolean returnValue = false;
		
		if (this.type != null) {
		
			if (this.type.equals("ForwardEdge")) {
			
				returnValue = true;
			
			}
			
		}
		
		return returnValue;
	
	}
	
	
	/**
	 * Check The Current Type Is CrossEdge
	 * 
	 */
	public boolean IsTypeCrossEdge () {
		
		boolean returnValue = false;
		
		if (this.type != null) {
		
			if (this.type.equals("CrossEdge")) {
			
				returnValue = true;
			
			}
			
		}
		
		return returnValue;
	
	}
	
	

	/**
	 * Changes The Current Type To type
	 * 
	 * @param type the new arch type
	 */
	public void setType (String type) {
		
		this.type = type;
	
	}
	
	
	
	/**
	 * Changes The Current Type To TreeEdge
	 * 
	 */
	public void setTypeTreeEdge () {
		
		this.type = "TreeEdge";
	
	}
	
	
	/**
	 * Changes The Current Type To BackEdge
	 * 
	 */
	public void setTypeBackEdge () {
		
		this.type = "BackEdge";
	
	}
	
	
	/**
	 * Changes The Current Type To ForwardEdge
	 * 
	 */
	public void setTypeForwardEdge () {
		
		this.type = "ForwardEdge";
	
	}
	

	/**
	 * Changes The Current Type To CrossEdge
	 * 
	 */
	public void setTypeCrossEdge () {
		
		this.type = "CrossEdge";
	
	}	
	
	

	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((A == null) ? 0 : A.hashCode());
		result = prime * result + ((B == null) ? 0 : B.hashCode());
		result = prime * result + (fixedLabel ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	
	/**
	 * @see java.lang.Object#hashCode()
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}


	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String archString =  "Arch:";
		
		archString += "  (" + this.A.getValue().toString();
		
		archString += "  , " + this.B.getValue().toString();
		
		archString += " , " + this.label + ")";
		
		archString += "  -> Weight = " + this.weight;
		
		if (this.type != null && this.type != "") {
			
			archString += "  - Type = " + this.type;
			
		}	
		
		archString += "  - FixedLabel = " + this.fixedLabel;
		
		return archString;
	
	}
	
	
}
