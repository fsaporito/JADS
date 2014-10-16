package DataStructures;

import Exceptions.NotResearchTreeException;


public class ResearchTree <T extends Comparable<T>> extends BinaryTree<T> {

	
	/** 
	 * Constructor, Verifies If The Tree Is A Research Tree And Instantiate It
	 * @param value Root Value
	 * @param a Left SubTree
	 * @param b Right SubTree
	 * @throws NotResearchTreeException Not A Research Tree
	 */
	public ResearchTree(T value, ResearchTree<T> a, ResearchTree<T> b) throws NotResearchTreeException {
		
		super(value, a, b);
		
		if (! this.isResearchTree()) {
			
			throw new NotResearchTreeException("Not A Research Tree");
		
		}
		
	}
	
	
	/**
	 * Set The Left SubTree To left Maintaining The Research Tree Structure
	 * @param left Tree To Use As Left SubTree
	 */
	@Override
	public void setLeft(BinaryTree<T> left) {
	
		this.left = left;
		
		if (!this.isResearchTree()) {
			
			try {
				
				throw new NotResearchTreeException("Not A Research Tree");
			
			} catch (NotResearchTreeException e) {
				
				e.printStackTrace();
				
			}
			
		}
	
	}
	
	
	/**
	 * Set The Right SubTree To right Maintaining The Research Tree Structure
	 * @param right Tree To Use As Right SubTree
	 */
	@Override
	public void setRight(BinaryTree<T> right) {

		this.right = right;
		
		if (!this.isResearchTree()) {
			
			try {
				
				throw new NotResearchTreeException("Not A Research Tree");
			
			} catch (NotResearchTreeException e) {
				
				e.printStackTrace();
				
			}
			
		}
	
	}

	
	/**
	 *
	 * Set The Root Value To value Maintaining The Research Tree Structure
	 *
	 */
	@Override
	public void setValue(T value) {
	
		this.value = value;
		
		if (!this.isResearchTree()) {
			
			try {
				
				throw new NotResearchTreeException("Not A Research Tree");
			
			} catch (NotResearchTreeException e) {
				
				e.printStackTrace();
				
			}
			
		}
	
	}

	
	/**
	 * Method That Verifies If The Tree Is A Research Tree
	 * @return True If Research Tree, False Otherwise
	 */
	@Override
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
	 * Add An Element To The Tree, Maintaining The Structure
	 * @param value Value To Add
	 */
	public void addElement (T value) throws NotResearchTreeException {
		
		if (this != null) {
			
			if (!this.isResearchTree()) {
				
				throw new NotResearchTreeException("Not A Research Tree");
			
			} else {
				
				ResearchTree<T> RNewLeaf = (ResearchTree<T>) new BinaryTree<T>(value,null,null);
			
				if (this.getValue().compareTo(value) <= 0) {
					
					if (this.getLeft() != null && this.getLeft().isResearchTree()) {
						
						((ResearchTree<T>) this.getLeft()).addElement(value);
						
						
					} else {
						
						this.setLeft(RNewLeaf);
			
						return;
					
					}
					
				} else {
					
					if (this.getRight() != null && this.getRight().isResearchTree()) {
						
						((ResearchTree<T>) this.getRight()).addElement(value);
						
					} else {
						
						this.setRight(RNewLeaf);
							
						return;	
						
					}
					
				}
				
			}
			
		} else {
			
			return;
			
		}
		
	}
	
	
}

