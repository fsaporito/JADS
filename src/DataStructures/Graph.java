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
	 */
	public Graph (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) {
		
		this.nodes = Nodes;
		
		this.archs = Archs;
		
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
	 * Check If The Graph Correctly Initialised
	 * 
	 * @param checkZero Flag Used To Check If The Graph Is NonEmpty
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	protected void checkGraphReady(boolean checkZero) throws GraphNotReadyException {
		
		if (this.nodes == null) {
			
			throw new GraphNotReadyException ("Nodes Null");
			
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
				
			}
			
		}
		
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
