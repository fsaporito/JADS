package DataStructures;

import java.util.ArrayList;

import Exceptions.GraphNotReadyException;

public class Tree<T> extends GraphOriented<T> {
	
	
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
	 * Checks If The Arch Is Correct:
	 * 1) Starting And Ending Nodes Are In nodeList 
	 * 2) There Is Only One Arch (This One) Entering In End Node
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialized
	 * 
	 */
	@Override
	protected boolean checkArch (Arch<T> arch) throws GraphNotReadyException {
		
		System.out.println ("checkArch Graph: " + arch.toString());
		
		this.checkGraphReady(false);
		
		boolean returnValue = false;
		
		if (super.checkArch(arch)) { 
			
			if (this.archsToNode(arch.getB()) == null) { // No Other Arches Ending In Node B
				
				returnValue = true;
				
			}
			
		}
		
		System.out.println ("		Returns: " + returnValue);
		
		return returnValue;
		
	}

}
