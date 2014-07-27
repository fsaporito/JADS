package DataStructures;

import java.util.ArrayList;

import Exceptions.GraphNotReadyException;



public class GraphOriented<T> extends Graph<T> {
		
	
	
	/**
	 * Constructor That Creates An Empty Oriented Graph
	 * 
	 * @param name Graph Name
	 */
	public GraphOriented (String name) {
		
		super(name);
		
	}
	
		
	
	/**
	 * Constructor That Creates The Graph
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Archs List
	 * @param name Graph Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	public GraphOriented (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		super(Nodes, Archs, name);
		
	}
	
	
		
	/**
	 * Method To Add An Arch To The Graph
	 * 
	 * @param Arch Arch To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	@Override
	public void addArch (Arch<T> Arch) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (!this.archs.contains(Arch)) {
			
			if (this.checkArch(Arch)) {
				
				this.archs.add(Arch);
				
			}
		
		}	
			
	}
		
	
	
	/**
	 * Checks If The Arch Is Correct:
	 * 1) Starting And Ending Nodes Are In nodeList 
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialised
	 * 
	 */
	@Override
	protected boolean checkArch (Arch<T> arch) throws GraphNotReadyException {
		
		System.out.println ("checkArch Graph: " + arch.toString());
		
		this.checkGraphReady(false);
		
		boolean returnValue = false;
		
		if (arch != null) { // Arch Must'n Be Null
			
			if (arch.getA() != null) { // Start Node Must'n Be Null
				
				if (this.nodes.contains(arch.getA())) { // Start Node Must Be In The Automaton
				
					if (arch.getB() != null) { // Ending Node Must'n Be Null
					
						if (this.nodes.contains(arch.getB())) { // Ending Node Must Be In The Automaton
						
							if (arch.getLabel() != null) { // Label Must'n Be Null
							
								returnValue = true;
								
							}
							
						}						
						
					}
					
				}
				
			}
			
		}
		
		System.out.println ("		Returns: " + returnValue);
		
		return returnValue;
		
	}
	
		
	
	/**
	 * Finds All The Archs With Label label
	 * 
	 * @param label Label To Look For
	 * @return The Arraylist Containing All The Arch Wich Match The Lablel, Null If No Arch Found
	 * @throws GraphNotReadyException 
	 */
	@Override
	public ArrayList<Arch<T>> archsWithLabel (String label) throws GraphNotReadyException {
		
		
		this.checkGraphReady(false);
		
		ArrayList<Arch<T>> archsList = new ArrayList<Arch<T>>(); // Return Value
				
		if (label != null) { // Label Mustn't Be Null
			
			for (int i = 0; i < this.archs.size(); i++) { // Check For Every Arch
					
				if (label.equals(this.archs.get(i).getLabel())) { // Same Label
								
					archsList.add(this.archs.get(i)); // Add Found Arch To ArrayList
								
				}					
							
			} 
				
		} else { // Label Null Not Accepted
				
			archsList = null;
				
		}				
		
		if (archsList != null) {
			
			if (archsList.size() == 0) { // No Archs, Return Null
				
				archsList = null;
				
			}	
			
		}
		
		return archsList;
		
	}
	
	
	
	/**
	 * Finds All The Archs Between Two Nodes
	 * 
	 * @param node1 First Node
	 * @param node2 Second Node
	 * @return The Arraylist Containing All The Arch, Null If No Arch Between The Two Nodes
	 */
	@Override
	public ArrayList<Arch<T>> archsBetweenNodes (Node<T> node1, Node<T> node2) {
		
		ArrayList<Arch<T>> archsList = new ArrayList<Arch<T>>(); // Return Value
		
		if (node1 != null && node2 != null) { // The Nodes Mustn't Be Null
			
			if ( (this.nodes.contains(node1)) && (this.nodes.contains(node2)) ) { // Nodes Must Be Contained In The Node List
				
				for (int i = 0; i < this.archs.size(); i++) { // Check For Every Arch
					
					if (node1.equals(this.archs.get(i).getA())) { // Node1 Is The First Node In The Arch
								
						if (node2.equals(this.archs.get(i).getB())) { // Node2 Is The Second Node In The Arch
									
							archsList.add(this.archs.get(i));
									
						}
								
					}					
							
				} 
				
			} else {
				
				archsList = null;
				
			}				
			
		} else {
			
			archsList = null;
			
		}
		
		if (archsList != null) {
			
			if (archsList.size() == 0) {
				
				archsList = null;
				
			}	
			
		}
		
		return archsList;
		
	}
	
	
	
	/**
	 * Method To Find All The Archs Starting From node
	 * 
	 * @param node Starting Node
	 * @return The Archs List, Null If Empty
	 */
	@Override
	public ArrayList<Arch<T>> archsFromNode (Node<T> node) {
		
		ArrayList<Arch<T>> archsList = new ArrayList<Arch<T>>(); // Return Value
		
		if (node != null) { // The Node Mustn't Be Null
			
			if (this.nodes.contains(node)) { // Node Must Be Contained In The Node List
				
				for (int i = 0; i < this.archs.size(); i++) {
					
					// Takes Only The Archs With node As Initial Node
					if (this.archs.get(i).getA().equals(node)) {
						
						archsList.add(this.archs.get(i));
						
					}
					
				}
				
			} else {
				
				archsList = null;
				
			}
			
		} else {
			
			archsList = null;
			
		}
		
		return archsList;
		
	}
	
	
	
	/**
	 * Method To Find All The Archs Ending At node
	 * 
	 * @param node End Node Node
	 * @return The Archs List, Null If Empty
	 */
	@Override
	public ArrayList<Arch<T>> archsToNode (Node<T> node) {
		
		ArrayList<Arch<T>> archsList = new ArrayList<Arch<T>>(); // Return Value
		
		if (node != null) { // The Node Mustn't Be Null
			
			if (this.nodes.contains(node)) { // Node Must Be Contained In The Node List
				
				for (int i = 0; i < this.archs.size(); i++) {
					
					// Takes Only The Archs With node As Ending Node
					if (this.archs.get(i).getB().equals(node)) {
						
						archsList.add(this.archs.get(i));
						
					}
					
				}
				
			} else {
				
				archsList = null;
				
			}
			
		} else {
			
			archsList = null;
			
		}
		
		return archsList;
		
	}

	
}
