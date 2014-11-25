package DataStructures;

import java.util.ArrayList;

import Exceptions.GraphNotReadyException;

public class GraphNotOriented<T> extends Graph<T> {

	
	/**
	 * Constructor That Creates An Empty Not Oriented Graph
	 * 
	 * @param name Graph Name
	 */
	public GraphNotOriented (String name) {
		
		super(name);
		
	}
	
	
	/**
	 * Constructor That Creates The Graph
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Arches List
	 * @param name Graph Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	public GraphNotOriented(ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		super(Nodes, Archs, name);
		
	}

	
	/**
	 * Method To Add An Arch To The Graph
	 * 
	 * @param Arch Arch To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialized
	 */
	@Override
	public void addArch(Arch<T> Arch) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (!this.archs.contains(Arch)) {
				
			if (this.checkArch(Arch)) {
					
				this.archs.add(Arch);
					
			}	
				
		}
		
	}

	@Override
	protected boolean checkArch(Arch<T> arch) throws GraphNotReadyException {
		// TODO Auto-generated method stub
		
		this.connectedComponents();
		
		return false;
	}

	@Override
	public ArrayList<Arch<T>> archsWithLabel(String label)
			throws GraphNotReadyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arch<T>> archsBetweenNodes(Node<T> node1, Node<T> node2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arch<T>> archsFromNode(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Arch<T>> archsToNode(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Check If The Graph Is Connected Using BFS
	 * 
	 * @return True If The Graph Is Connected, False Otherwise
	 * @throws GraphNotReadyException Graph Not Correctly Initialized
	 */
	@Override
	public boolean isConnected () throws GraphNotReadyException {
		
		boolean returnValue = true; // Return Value
		
		this.checkGraphReady(true); // Check If The Graph Is Ready
		
		Node<T> nodeTMP; // Temporary Node
		
		this.bfs(this.nodes.get(0));
		
		for (int i = 0; (i < this.nodes.size() && returnValue); i++) { // Loop Over All Nodes
			
			nodeTMP = this.nodes.get(i); // Temporary Node Assignment
			
			if (!nodeTMP.getColor().equals("BLACK")) {
				
				returnValue = false;
				
			}
						
		}
		
		return returnValue;
		
		
	}
	

}
