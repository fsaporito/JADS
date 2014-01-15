package DataStructures;

public class Tree <T extends Comparable<T>> {

	private Tree<T> left;
	private Tree<T> right;
	private T value;
		
	
	/**
	 * Constructor That Initialize The Tree
	 * @param i Root Value
	 * @param a Left SubTree
	 * @param b Right SubTree
	 */
	public Tree (T i, Tree<T> a, Tree<T> b) {
		
		this.left = a;
		this.right = b;
		this.value = i;
		
	}

	
	
	/**
	 * Method Which Return The Left SubTree
	 * @return Left SubTree Or Null
	 */
	public Tree<T> getLeft() {
	
		if (this.left != null) {
			
			return this.left;
		
		} else {
			
			return null;
			
		}
	
	}

	
	
	/**
	 * Set The Left SubTree To left
	 * @param left Tree To Use As Left SubTree
	 */
	public void setLeft(Tree<T> left) {
	
		this.left = left;
	
	}

	
	
	/**
	 * Method Which Return The Right SubTree
	 * @return Right SubTree Or Null
	 */
	public Tree<T> getRight() {

		if (this.right != null) {
			
			return this.right;
		
		} else {
			
			return null;
			
		}
	
	}

	
	
	/**
	 * Set The Right SubTree To right
	 * @param right Tree To Use As Right SubTree
	 */
	public void setRight(Tree<T> right) {

		this.right = right;
	
	}

	
	
	/**
	 * Method Which Return The Root Value
	 * @return The Root Value
	 */
	public T getValue() {
	
		return this.value;
	
	}

	
	
	/**
	 *
	 * Set The Root Value To value
	 *
	 */
	public void setValue(T value) {
	
		this.value = value;
	
	}
	
	
	
	/**
	 * Count The Number Of The Tree's Nodes
	 * @return Nodes Number
	 */
	public int countNodes(){
		
		if (this == null) {
		
			return 0;
		
		} else {
		
			return ((this.getLeft().countNodes()) + this.getRight().countNodes() + 1);
		
		}
		
	}
	
	
	
	/**
	 *  Verify If The Root Of This Tree Has Any Sons (Is A Leaf)
	 * @return True If The Root Is A Leaf, False Otherwise
	 */
	public boolean isLeaf () {
		
		if ((this.left == null) && (this.right == null)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	
	
	/**
	 * Count The Number Of The Tree's Leafs
	 * @return Leafs Number
	 */
	public int countLeafs () {
		
		if (this == null) {
			
			return 0;
			
		}
		
		if (this.isLeaf()) {
			
			return 1;
			
		} else {
			
			int res_left = this.left.countLeafs();
			
			int res_right = this.right.countLeafs();
			
			return (res_left+res_right);
			
		}
		
	}
	
	
	
	/**
	 *  Calculates The Height Of The Tree (Number Of Nodes In The Maximum Walk)
	 * @return Tree's Height
	 */
	public int heightTree () {
				
		if (this == null) {
					
			return 0;
					
		}
				
		if (this.isLeaf()) {
					
			return 1;
					
		} else {
				
			int res_left = this.left.heightTree();
				
			int res_right = this.right.heightTree();
				
			if (res_left >= res_right) {
					
				return (1+res_left);
					
			} else {
					
				return (1+res_right);
					
			}
				
		}
				
	}


	
	/**
	 *  Calculates The Depth Of The Tree (Number Of Arcs In The Maximum Walk)
	 * @return Tree's Depth
	 */
	public int depthTree () {
				
		if (this == null) {
					
			return 0;
					
		}
				
		if (this.isLeaf()) {
					
			return 1;
					
		} else {
				
			return (this.heightTree() - 1 );
					
		}
				
	}

	
	
	/**
	 * Verifies If The Key Belongs To The Tree
	 * @param key Key To Match Against The Tree
	 * @return True If The Key Belongs, False Otherwise
	 */
	public boolean findInTree (T key) {
				
		if (this == null) {
					
			return false;
					
		}
				
		if (this.isLeaf()) {
			
			if (this.getValue().equals(key)) {
				
				return true;
			
			} else {
				
				return false;
				
			}
			
		} 
		
		if (this.getValue().equals(key)) {
			
			return true;
			
		} else {
			
			boolean res_left = this.left.findInTree(key);
			
			boolean res_right = this.right.findInTree(key);
			
			return (res_left || res_right);
			
		}
				
	}
	
	
	
	/**
	 * Finds The Max Value Of The Tree
	 * @return Max Value
	 */
	public T maxTree () {
		
		if (this.isLeaf()) {
			
			return this.getValue();
			
		} else {
			
			T max = this.getValue();
		
			if ( this.getLeft() != null ) {
				
				if (max.compareTo(this.getLeft().getValue()) < 0) {
			
					max = this.getLeft().getValue();
			
				}
			
				if (max.compareTo(this.getLeft().maxTree()) < 0) {
				
					max = this.getLeft().maxTree();
				
				}
			
			}
			
			if ( this.getRight() != null ) {
				
				if (max.compareTo(this.getRight().getValue()) < 0) {
				
					max = this.getRight().getValue();
				
				}
			
				if (max.compareTo(this.getRight().maxTree()) < 0) {
					
					max = this.getRight().maxTree();
				
				}
				
			}	
			
			return max;
		
		}
			
	}

	
	
	/**
	 * Finds The Minimum Value Of The Tree
	 * @return Minimum Values
	 */
	public T minTree () {
		
		if (this.isLeaf()) {
			
			return this.getValue();
			
		} else {
			
			T min = this.getValue();
		
			if ( this.getLeft() != null ) {
				
				if (min.compareTo(this.getLeft().getValue()) > 0) {
			
					min = this.getLeft().getValue();
			
				}
			
				if (min.compareTo(this.getLeft().minTree()) > 0) {
				
					min = this.getLeft().minTree();
				
				}
			
			}
			
			if ( this.getRight() != null ) {
				
				if (min.compareTo(this.getRight().getValue()) < 0) {
				
					min = this.getRight().getValue();
				
				}
			
				if (min.compareTo(this.getRight().minTree()) < 0) {
					
					min = this.getRight().minTree();
				
				}
				
			}	
			
			return min;
		
		}
			
	}

	

	/**
	 * Method That Verifies If The Tree Is A Research Tree
	 * @return True If Research Tree, False Otherwise
	 */
	public boolean isResearchTree () {
		
		if (this == null || this.isLeaf()) {
			
			return true;
			
		}
		
		if (this.getLeft().getValue().compareTo(this.getValue()) <= 0) {
			
			if (this.getLeft().maxTree().compareTo(this.getValue()) <= 0) {
					
				if (this.getLeft().isResearchTree()) {
						
					if (this.getRight() != null) {
							
						if (this.getRight().getValue().compareTo(this.getValue()) <= 0) {
			
							if (this.getRight().minTree().compareTo(this.getValue()) >= 0) {
							
								return this.getRight().isResearchTree();
						
							} else {
								
								return false;
								
							}
						
						} else {
							
							return false;
							
						}
					
					} else {
					
						return false;
					
					}
						
				} else {
					
					return false;
					
				}
			
			} else {
				
				return false;
				
			}
		
		} else {
			
			return false;
			
		}
	
	}



	
	
	
	/**
	 *  Implements The hashCode Method For A Stack
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}





	
	/**
	 *  Implements The equals Method For A Tree
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof Tree))
			return false;			
		@SuppressWarnings("unchecked")
		Tree<T> other = (Tree<T>) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	};
	
	
	
}
