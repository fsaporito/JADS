package DataStructures;

import java.util.ArrayList;


import Exceptions.GraphNotReadyException;
import Exceptions.TreeNotReadyException;

public class Tree<T> extends GraphOriented<T> {
	
	
	private Node<T> root;
	
	
	/**
	 * Constructor That Creates An Empty Tree
	 * 
	 * @param name Tree Name
	 */
	public Tree (String name) {
		
		super(name);
		
	}

	
	/**
	 * Constructor That Creates The Tree
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Arches List
	 * @param name Tree Name
	 * @throws GraphNotReadyException
	 */
	public Tree(ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		super (Nodes, Archs, name); 
	
	}
	
	
	/**
	 * Method To Add A Root To The Tree
	 * If Not Present In The Nodes List, Adds It
	 * 
	 * @param Root Root Node
	 * @throws TreeNotReadyException Tree Not Correctly Initialized
	 */
	public void setRoot (Node<T> Root) throws TreeNotReadyException {
		
		if (!this.nodes.contains(Root)) {
			
			try {
				
				this.addNode(Root);
				
			} catch (GraphNotReadyException e) {

				throw new TreeNotReadyException (e.getMessage());
				
			}
			
		}
		
		if (this.archsToNode(Root) == null) { // Check If There Aren't Arches That Arrive To The Selected Root

			this.root = Root;
			
		} else {
			
			throw new TreeNotReadyException ("There Is An Arch With The Root As Ending Node!!!");
			
		}
		
	}
	
	
	/**
	 * Checks If The Arch Is Correct:
	 * 1) Starting And Ending Nodes Are In nodeList 
	 * 2) There Is Only One Arch (This One) Entering In End Node
	 * 3) Root Cannot Be Already A Node
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialized
	 * 
	 */
	@Override
	protected boolean checkArch (Arch<T> arch) throws GraphNotReadyException {
		
		System.out.println ("checkArch Tree: " + arch.toString());
		
		this.checkGraphReady(false);
		
		boolean returnValue = false;
		
		if (super.checkArch(arch)) { 
			
			if (this.archsToNode(arch.getB()) == null) { // No Other Arches Ending In Node B
				
				returnValue = true;
				
			}
			
			if (this.root != null) { // If Root Has Been Already Set			
			
				if (arch.getB().equals(this.root)) { // Root Cannot Be An Ending Node
				
				returnValue = false;
				
				}
				
			}
			
		}
			
		
		System.out.println ("		Returns: " + returnValue);
		
		return returnValue;
		
	}
	
	
	/**
	 * Check If The Tree Is Correctly Initialized
	 * 
	 * @param checkZero Flag Used To Check If The Tree Is NonEmpty
	 * @throws TreeNotReadyException Tree Is Not Correctly Initialized
	 */
	protected void checkTreeReady(boolean checkZero) throws TreeNotReadyException {
		
		try {
			
			super.checkGraphReady(checkZero);
			
		} catch (GraphNotReadyException e) {
			
			throw new TreeNotReadyException (e.getMessage());
			
		}
		
		if (checkZero) {
			
			if (this.root == null) {
				
				throw new TreeNotReadyException ("No Root!!!");
				
			}
			
		}
		
	}
	
	

}
