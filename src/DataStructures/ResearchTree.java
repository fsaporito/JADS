package DataStructures;

import Exceptions.NotResearchTreeException;


public class ResearchTree <T extends Comparable<T>> extends Tree<T> {

	
	/** 
	 * Constructor, Verifies If The Tree Is A Research Tree And Instantiate It
	 * @param value Root Value
	 * @param a Left SubTree
	 * @param b Right SubTree
	 * @throws NotResearchTreeException Not A Research Tree
	 */
	public ResearchTree(T value, ResearchTree<T> a, ResearchTree<T> b) throws NotResearchTreeException {
		
		super(value, a, b);
		
		if (this.isResearchTree()) {
			
			throw new NotResearchTreeException("Not A Research Tree");
		
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
				
				ResearchTree<T> RNewLeaf = (ResearchTree<T>) new Tree<T>(value,null,null);
			
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

