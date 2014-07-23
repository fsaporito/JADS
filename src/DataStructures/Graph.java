package DataStructures;

import java.util.ArrayList;

import Exceptions.GraphNotReadyException;



public class Graph<T> {
	
		
	/** Nodes List*/
	protected ArrayList<Node<T>> nodes;
	
	/** Archs List */
	protected ArrayList<Arch<T>> archs;
	
	/** Graph's Name*/
	protected String name;
	
	
	
	/**
	 * Constructor That Creates An Empty Graph
	 * 
	 * @param name Graph Name
	 */
	public Graph (String name) {
		
		this.nodes = new ArrayList<Node<T>> ();
		
		this.archs = new ArrayList<Arch<T>> ();
		
		this.name = name;
		
	}
	
		
	
	/**
	 * Constructor That Creates The Graph
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Archs List
	 * @param name Graph Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	public Graph (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		this.nodes = Nodes;
		
		this.checkNodeDuplicates(this.nodes);
		
		this.archs = Archs;
		
		this.checkArchDuplicates(this.archs);
		
		this.name = name;
		
	}
	
	
	
	/**
	 * Method To Add A Node To The Graph
	 * 
	 * @param Node Node To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	public void addNode (Node<T> Node) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (!this.nodes.contains(Node)) {
			
			this.nodes.add(Node);
		
		}	
			
	}
	
	
	
	/**
	 * Method To Add An Arch To The Graph
	 * 
	 * @param Arch Arch To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	public void addArch (Arch<T> Arch) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (!this.archs.contains(Arch)) {
			
			this.archs.add(Arch);
		
		}	
			
	}
	
	
	
	/**
	 * Check If The Node List Has Duplicates
	 * 
	 * @param Nodes Nodes List
	 * @throws GraphNotReadyException Duplicate Node In The Nodes List
	 */
	protected void checkNodeDuplicates (ArrayList<Node<T>> Nodes) throws GraphNotReadyException {
		
		if (Nodes != null) {
			
			Node<T> tmpNode;
			
			int duplicateNodeCounter = 0;
		
			for (int i = 0; i < Nodes.size(); i++) {
			
				duplicateNodeCounter = 0;
				
				tmpNode = Nodes.get(i);
				
				for (int j = 0; j < Nodes.size(); j++) {
					
					if (tmpNode.equals(Nodes.get(j))) {
						
						duplicateNodeCounter++;
						
					}
					
				}
				
				if (duplicateNodeCounter > 1) {
					
					throw new GraphNotReadyException ("Node " + tmpNode.toString() 
													+ " has " + duplicateNodeCounter 
													+ "entries in the nodeList!!!");
					
				}
			
			}
			
		}
		
	}
	
	
	
	/**
	 * Check If The Archs List Has Duplicates
	 * 
	 * @param Archs Archs List To Check
	 * @throws GraphNotReadyException Duplicate Arch In The Archs List
	 */
	protected void checkArchDuplicates (ArrayList<Arch<T>> Archs) throws GraphNotReadyException {
		
		if (Archs != null) {
			
			Arch<T> tmpArch;
			
			int duplicateArchCounter = 0;
		
			for (int i = 0; i < Archs.size(); i++) {
				
				duplicateArchCounter = 0;
				
				tmpArch = Archs.get(i);
				
				for (int j = 0; j < Archs.size(); j++) {
					
					if (tmpArch.equals(Archs.get(j))) {
						
						duplicateArchCounter++;
						
					}
					
				}
				
				if (duplicateArchCounter != 1) {
					
					throw new GraphNotReadyException ("Arch " + tmpArch.toString() 
													+ " has " + duplicateArchCounter 
													+ "entries in the archList!!!");
					
				}
			
			}
			
		}
		
	}
	
	
	
	/**
	 * Check If The Graph Correctly Initialised
	 * 
	 * @param checkZero Flag Used To Check If The Graph Is NonEmpty
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	protected void checkGraphReady(boolean checkZero) throws GraphNotReadyException {
		
		if (this.nodes == null) {
			
			throw new GraphNotReadyException ("Nodes Null");
			
		} else {
			
			this.checkNodeDuplicates(this.nodes);
			
		}
		
		if (this.archs == null) {
			
			throw new GraphNotReadyException ("Archs Null");
			
		} else {
			
			this.checkArchDuplicates(this.archs);
			
		}
		
		if (checkZero) {
			
			if (this.nodes.size() == 0) {
				
				throw new GraphNotReadyException ("No Nodes In The Graph");
				
			}
			
			if ( this.archs.size() == 0) {
				
				throw new GraphNotReadyException ("No Archs In The Graph");
				
			}
			
		}
		
	}

	
	
	/**
	 * Finds All The Archs Between Two Nodes
	 * 
	 * @param node1 First Node
	 * @param node2 Second Node
	 * @return The Arraylist Containing All The Arch, Null If No Arch Between The Two Nodes
	 */
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
	 * Method To Find If The Two Node Are Neighbor
	 * (Exists At Least An Arch BeetWen Them)
	 * 
	 * @param node1 First Node
	 * @param node2 Second Node
	 * @return True If The Nodes Are Neighborhood, False Otherwise
	 * 
	 */
	public boolean neighbor (Node<T> node1, Node<T> node2) {
		
		boolean result = false;
		
		if (this.archsBetweenNodes(node1, node2) != null) {
			
			result = true;
			
		}
				
		return result;
		
	}

	
	
	/**
	 * Method To Find All Of The Neighbors Of A Node In The Graph
	 * 
	 * @param node Node Of Whom Is To Be Found The Neighborhood
	 * @return Arraylist Containing All The Neighors, Null If None Or If The node Isn't Present In The Graph
	 */
	public ArrayList<Node<T>> neighborhood (Node<T> node) {
		
		ArrayList<Node<T>> neighborhood = new ArrayList<Node<T>>(); // Return Value
		
		if (node != null && this.nodes.contains(node)) { // node Mustn't Be Null And Contained In The Node List
			
			for (int i = 0; i < this.nodes.size(); i++) { // Look At Every Node
				
				if (this.neighbor(node, this.nodes.get(i))) { // The Nodes In The Pair Are Neighbor
							
					if (!neighborhood.contains(this.nodes.get(i))) { // No Duplicate Nodes
								
						neighborhood.add(this.nodes.get(i)); // Add The Node To The Neighborhood
								
					}					
					
				}
				
			}
			
		} else {
			
			neighborhood = null;
			
		}
		
		return neighborhood;
		
		
	}
	
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		try {
			
			this.checkGraphReady (true);
		
		} catch (GraphNotReadyException e) {
			
			e.printStackTrace();
	
		}
		
		return "Graph"  + "\n\t Name: " + this.name +
				"\n\t nodes:" + this.nodes.toString() + 
				"\n\t archs:" + archs.toString();
		
	}



}
