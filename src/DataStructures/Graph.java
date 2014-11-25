package DataStructures;

import java.util.ArrayList;

import Exceptions.AutomatonNotReadyException;
import Exceptions.GraphNotReadyException;

public abstract class Graph<T> {

	/** Nodes List */
	protected ArrayList<Node<T>> nodes;
	
	/** Arches List */
	protected ArrayList<Arch<T>> archs;
	
	/** Graph's Name */
	protected String name;
	
	/** Number Of Connected Components */
	protected int connectedComponents;
	
	/**
	 * Constructor That Creates An Empty Graph
	 * 
	 * @param name Graph Name
	 */
	public Graph(String name) {
		
		this.nodes = new ArrayList<Node<T>> ();
		
		this.archs = new ArrayList<Arch<T>> ();
		
		this.name = name;	
		
		this.connectedComponents = 0;
		
	}

	
	
	/**
	 * Constructor That Creates The Graph
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Arches List
	 * @param name Graph Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	public Graph (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		this.nodes = Nodes;
		
		this.checkNodeDuplicates(this.nodes);
		
		this.archs = Archs;
		
		this.name = name;
		
		this.connectedComponents = 0;
		
		this.checkGraphReady(false);
		
		this.connectedComponents();
		
	}
	
	
	
	/**
	 * Method To Add A Node To The Graph
	 * 
	 * @param Node Node To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	public void addNode (Node<T> Node) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (!this.nodes.contains(Node)) {
			
			this.nodes.add(Node);
		
		}	
		
		this.connectedComponents();
			
	}

	
	
	/**
	 * Method To Add An Arch To The Graph
	 * 
	 * @param Arch Arch To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	public abstract void addArch (Arch<T> Arch) throws GraphNotReadyException;
		
	
	
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
	 * Checks If The Arch Is Correct
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialized
	 * 
	 */
	protected abstract boolean checkArch (Arch<T> arch) throws GraphNotReadyException;
	
	
	
	/**
	 * Checks If The Every Arch Is Correct
	 * By Calling checkArch On Every Single Arch
	 * And checkArchDuplicates To See If There Are Doubles
	 *  
	 * @throws AutomatonNotReadyException Wrong Arches
	 */
	protected void checkArchsList () throws GraphNotReadyException {
		
		for (int i = 0; i < this.archs.size(); i++) {
			
			if (!this.checkArch(this.archs.get(i))) {
				
				throw new GraphNotReadyException ("Wrong Archs!!!");
				
			}
			
		}
		
		this.checkArchDuplicates();
		
	}

	
	
	/**
	 * Check If The Arches List Has Duplicates
	 * 
	 * @throws GraphNotReadyException Duplicate Arch In The Arches List
	 */
	protected void checkArchDuplicates () throws GraphNotReadyException {
		
		if (this.archs != null) {
			
			Arch<T> tmpArch;
			
			int duplicateArchCounter = 0;
		
			for (int i = 0; i < this.archs.size(); i++) {
				
				duplicateArchCounter = 0;
				
				tmpArch = this.archs.get(i);
				
				for (int j = 0; j < this.archs.size(); j++) {
					
					if (tmpArch.equals(this.archs.get(j))) {
						
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
	 * Check If The Graph Is Correctly Initialized
	 * 
	 * @param checkZero Flag Used To Check If The Graph Is NonEmpty
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	protected void checkGraphReady(boolean checkZero) throws GraphNotReadyException {
		
		if (this.nodes == null) {
			
			throw new GraphNotReadyException ("Nodes Null");
			
		} else {
			
			this.checkNodeDuplicates(this.nodes);
			
		}
		
		if (this.archs == null) {
			
			throw new GraphNotReadyException ("Archs Null");
			
		}
		
		if (checkZero) {
			
			if (this.nodes.size() == 0) {
				
				throw new GraphNotReadyException ("No Nodes In The Graph");
				
			}
			
			if ( this.archs.size() == 0) {
				
				throw new GraphNotReadyException ("No Archs In The Graph");
				
			} else {
				
				this.checkArchsList();
				
			}
			
		}
		
	}
	
	
	
	/**
	 * Finds All The Arches With Label label
	 * 
	 * @param label Label To Look For
	 * @return The ArrayList Containing All The Arch Which Match The Label, Null If No Arch Found
	 * @throws GraphNotReadyException 
	 */
	public abstract ArrayList<Arch<T>> archsWithLabel (String label) throws GraphNotReadyException;
	
	
	
	/**
	 * Finds All The Arches Between Two Nodes
	 * 
	 * @param node1 First Node
	 * @param node2 Second Node
	 * @return The ArrayList Containing All The Arch, Null If No Arch Between The Two Nodes
	 */
	public abstract ArrayList<Arch<T>> archsBetweenNodes (Node<T> node1, Node<T> node2);
	
	
	
	/**
	 * Method To Find All The Arches Starting From node
	 * 
	 * @param node Starting Node
	 * @return The Arches List, Null If Empty
	 */
	public abstract ArrayList<Arch<T>> archsFromNode (Node<T> node);
	
	
	
	/**
	 * Method To Find All The Arches Ending At node
	 * 
	 * @param node End Node Node
	 * @return The Arches List, Null If Empty
	 */
	public abstract ArrayList<Arch<T>> archsToNode (Node<T> node);
	
	
	
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
	 * @return ArrayList Containing All The Neighbors, Null If None Or If The node Isn't Present In The Graph
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
	 * Visits The Graph With A Breath First Search
	 * 
	 * @param sourceNode Starting Node
	 * @throws GraphNotReadyException 
	 * 
	 */
	public void bfs (Node<T> sourceNode) throws GraphNotReadyException {
		
		if (!this.nodes.contains(sourceNode)) {
			
			throw new GraphNotReadyException ("Node: " + sourceNode.getValue() + "Doesn't Belong To The Graoh!!!");
			
		}
		
		this.checkGraphReady(false);
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			this.nodes.get(i).setColorWhite();
			
			this.nodes.get(i).setParent(null);
			
			this.nodes.get(i).setDistance(Double.POSITIVE_INFINITY);
			
		}
		
		Queue<Node<T>> nodeQueue = new Queue<Node<T>>();
		
		sourceNode.setColorGray();
		
		sourceNode.setDistance(0);
		
		nodeQueue.enQueue(sourceNode);
		
		Node<T> nodeTMP = null;
		
		ArrayList<Node<T>> neighborhoodTMP = new ArrayList<Node<T>>();
		
		while (!nodeQueue.emptyQueue()) {
			
			nodeTMP = nodeQueue.deQueue();
			
			neighborhoodTMP = this.neighborhood(nodeTMP);
			
			for (int i = 0; i < neighborhoodTMP.size(); i++) {
				
				if (neighborhoodTMP.get(i).isColorWhite()) {
										
					neighborhoodTMP.get(i).setColorGray();
					
					neighborhoodTMP.get(i).setDistance(nodeTMP.getDistance()+1);
					
					neighborhoodTMP.get(i).setParent(nodeTMP);
					
					nodeQueue.enQueue(neighborhoodTMP.get(i));					
					
				}
				
			}
			
			nodeTMP.setColorBlack();
			
		}
		
	}
	
	
	
	/**
	 * Visits The Graph With A Breath First Search
	 * 
	 * @return Number Of Connected Components
	 * @throws GraphNotReadyException 
	 * 
	 */
	public int dfs () throws GraphNotReadyException {
		
		this.checkGraphReady(false);
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			this.nodes.get(i).setColorWhite();
			
			this.nodes.get(i).setParent(null);
			
		}
		
		int time = 0;
		
		int connectedComponents = 0;
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			if (this.nodes.get(i).isColorWhite()) {
				
				connectedComponents++;
				
				time = this.dfsVisit (this.nodes.get(i), time);
				
			}
			
		}
		
		return connectedComponents;
		
	}
	
	
	/**
	 * Recursive Step For Deep Search
	 * 
	 * @param sourceNode Starting Node
	 * @param time Time Parameter
	 * @return Number of Connected Components
	 */
	private int dfsVisit (Node<T> sourceNode, int time) {
		
		time++;
		
		sourceNode.setDiscoveryTIME(time);
		
		sourceNode.setColorGray();
		
		ArrayList<Node<T>> neighborhoodTMP = this.neighborhood(sourceNode);
		
		ArrayList<Arch<T>> archFromSource = this.archsFromNode(sourceNode);
		
		for (int i = 0; i < neighborhoodTMP.size(); i++) {
			
			if (neighborhoodTMP.get(i).isColorWhite()) {
				
				for (int j = 0; j < archFromSource.size(); j++) {
					
					if (archFromSource.get(j).getB().equals(neighborhoodTMP.get(i))) {
						
						archFromSource.get(j).setTypeTreeEdge();
						
					}
					
				}
				
				neighborhoodTMP.get(i).setParent(sourceNode);
				
				time = this.dfsVisit (neighborhoodTMP.get(i), time);
				
			} else if (neighborhoodTMP.get(i).isColorGray()) {
				
				for (int j = 0; j < archFromSource.size(); j++) {
					
					if (archFromSource.get(j).getB().equals(neighborhoodTMP.get(i))) {
						
						archFromSource.get(j).setTypeBackEdge();
						
					}
					
				}
				
			} else if (neighborhoodTMP.get(i).isColorBlack()) {
				
				for (int j = 0; j < archFromSource.size(); j++) {
					
					if (archFromSource.get(j).getB().equals(neighborhoodTMP.get(i))) {
						
						if (sourceNode.getDiscoveryTIME() < neighborhoodTMP.get(i).getDiscoveryTIME()) {
						
							archFromSource.get(j).setTypeForwardEdge();
							
						} else {
							
							archFromSource.get(j).setTypeCrossEdge();
							
						}
						
					}
					
				}
				
			}
			
		}
		
		sourceNode.setColorBlack();
		
		time++;
		
		sourceNode.setDiscoveryTIME(time);
		
		return time;
		
	}
	
	
	/**
	 * Update The Field ConnectedComponents
	 * And Sets The Colors To Default
	 *  
	 * @return Connected Components Number
	 * @throws GraphNotReadyException
	 */
	public int connectedComponents () throws GraphNotReadyException {
		
		this.connectedComponents = this.dfs();
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			this.nodes.get(i).setColorWhite();
			
		}
		
		return this.connectedComponents;
		
	}
	
	
	
	/**
	 * Check If The Graph Is Connected
	 * 
	 * @return True If The Graph Is Connected, False Otherwise
	 * @throws GraphNotReadyException Graph Not Correctly Initialized
	 */
	public boolean isConnected () throws GraphNotReadyException {
		
		boolean returnValue = true; // Return Value
		
		this.checkGraphReady(true); // Check If The Graph Is Ready
		
		Node<T> nodeTMP; // Temporary Node
		
		for (int i = 0; (i < this.nodes.size() && returnValue); i++) { // Loop Over All Nodes
			
			nodeTMP = this.nodes.get(i); // Temporary Node Assignment
			
			for (int j = 0; (i < this.nodes.size() && returnValue); j++) { // Loop Over All The Others Nodes
				
				if (!nodeTMP.equals(this.nodes.get(j))) { // Don't Analyze The Temporary Node
					
					if (!this.neighbor(nodeTMP, this.nodes.get(j))) { // Check If Neighbor With The Generic Node
						
						returnValue = false; // No Neighbor, The Graph Isn't Connected
						
					}
					
				}
				
			}			
						
		}
		
		return returnValue;
		
		
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
		
		String toString = "Graph";
		
		toString += "\n\tName: " + this.name;
		
		toString += "\n\n\tNodes:";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			toString +=  "\n\t\t" + this.nodes.get(i);
			
		}
		
		toString += "\n\n\tArchs:";
		
		for (int i = 0; i < this.archs.size(); i++) {
			
			toString +=  "\n\t\t" + this.archs.get(i);
			
		}
		
		toString += "\n\n\tisConnected: ";
		
		try {
			
			toString += this.isConnected();
			
		} catch (GraphNotReadyException e) {
			
			e.printStackTrace();
			
		}
		
		toString += "\n\n\tConnected Components: " + this.connectedComponents;
		
		
		toString += "\n\n\tNeighbors: ";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			toString +=  "\n\t\t - " + this.nodes.get(i).getValue();
			
			ArrayList<Node<T>> n = new ArrayList<Node<T>> ();
			
			n = this.neighborhood(this.nodes.get(i));			
			
			if (n.size() > 0) {
				
				toString += ": " + n.size() + " Neighbors :)";
				
				for (int j = 0; j < n.size(); j++) {
					
					toString += "\n\t\t\t" + n.get(j).toString();
					
				}
				
			} else {
				
				toString += ": None :(";
				
			}			
			
		}
		
		return toString;
		
	}
	
	
}
