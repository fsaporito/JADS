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
	 * @param Archs Archs List
	 * @param name Graph Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 */
	public GraphNotOriented(ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, String name) throws GraphNotReadyException {
		
		super(Nodes, Archs, name);
		
	}

	
	/**
	 * Method To Add An Arch To The Graph
	 * 
	 * @param Arch Arch To Add
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
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

}
