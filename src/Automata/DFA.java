package Automata;

import DataStructures.Node;
import DataStructures.Arch;
import DataStructures.Graph;
import Exceptions.DFANotReadyException;
import Exceptions.GraphNotReadyException;


import java.util.ArrayList;


public class DFA<T> extends Graph<T> {
	
	
	/** Start Node */
	protected Node<T> start;
	
	/** FinalNodes List (Accepting States)*/
	protected ArrayList<Node<T>> finalNodes;
	
	
	
	/**
	 * Constructor That Create An Empty DFA
	 * 
	 * @param name DFA's Name
	 */
	public DFA (String name) {
		
		super(name);
		
		this.finalNodes = new ArrayList<Node<T>> ();
		
		
	}
	
	
	
	/** 
	 * Constructor That Creates The DFA
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Archs List
	 * @param Start Start State
	 * @param FinalNodes FinalNodes List
	 * @param Name DFA's Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 * @throws DFANotReadyException DFA Not Correctly Initialised
	 */
	public DFA (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, Node<T> Start, ArrayList<Node<T>> FinalNodes, String Name) throws GraphNotReadyException, DFANotReadyException {
		
		super (Nodes, Archs, Name);
		
		this.start = Start;
		
		this.finalNodes = FinalNodes;
		
		this.checkFinalNodeDuplicates();
		
	}
	


	/** 
	 * Method ToAdd An Arch 
	 * (Must Be With fixedLabel)
	 * 
	 * @param Arch Arch To Be Added To The DFA
	 * @throws GraphNotReadyException The Graph Is Not Correctly Initialised
	 */
	@Override
	public void addArch (Arch<T> Arch) throws GraphNotReadyException {
		
		this.checkGraphReady (false);

		if (Arch.getFixed()) { // Label Must Be Fixed
	
			if (!this.archs.contains(Arch)) { // Arch Can't Be Already Present
			
				boolean labelFound = false; // Flag
			
				// For Loop To Look If The Label Is Already Present In Another
				// Arch With The Same Starting Point (Node A)
				for (int i = 0; (i < this.archs.size() && !labelFound); i++) {
				
					if (this.archs.get(i).getA().equals(Arch.getA())) {
				
						if (this.archs.get(i).getLabel().equals(Arch.getLabel())) {
					
							labelFound = true;
					
						}
						
					}
				
				}
			
				if (!labelFound) { // Label Not Found, Proceed
				
					this.archs.add(Arch);
		
				}
				
			}
			
		}	
		
	}
	
	
	
	/**
	 * Method To Add A Final Node To The DFA
	 * If Not Present In The Nodes List, Adds It
	 * 
	 * @param Node Final Node
	 * @throws DFANotReadyException DFA Not Correctly Initialised
	 * @throws GraphNotReadyException Graph Not Correctly Initialised
	 */
	public void addFinalNode (Node<T> Node) throws DFANotReadyException {
		
		this.checkDFAReady(false, true, false);
		
		if (!this.nodes.contains(Node)) {
			
			try {
				
				this.addNode(Node);
			
			} catch (GraphNotReadyException e) {
				
				throw new DFANotReadyException (e.getMessage());
				
			}
			
		}
		
		if (!this.finalNodes.contains(Node)) {
				
			this.finalNodes.add(Node);
			
		}
		
	}
	
	
	
	/**
	 * Method To Add A Start State To The DFA
	 * If Not Present In The Nodes List, Adds It
	 * 
	 * @param Start Start Node
	 * @throws GraphNotReadyException Graph Not Correctly Initialised
	 */
	public void setStart (Node<T> Start) throws GraphNotReadyException {
		
		if (!this.nodes.contains(Start)) {
			
			this.addNode(Start);
			
		}

		this.start = Start;
		
	}
	
	
	
	/**
	 * Check If The Final Node List Has Duplicates
	 * 
	 * @throws DFANotReadyException
	 */
	protected void checkFinalNodeDuplicates() throws DFANotReadyException {
		
		try {
			
			this.checkNodeDuplicates(this.finalNodes);
			
		} catch (GraphNotReadyException e) {
			
			throw new DFANotReadyException ("Duplicate entries in the finalNodeList!!!");
		
		}
		
	}
	
	
	
	/**
	 * Check If The DFA Is Correctly Initialised
	 * 
	 * @param checkStart Check The Start State
	 * @param checkFinal Check If There Is A FinalState List
	 * @param checkEmptyFinalNodes Check If The FinalState List Is Empty
	 * @throws DFANotReadyException DFA Not Correctly Initialised
	 */
	protected void checkDFAReady (boolean checkStart, boolean checkFinal, boolean checkEmptyFinalNodes) throws DFANotReadyException {
		
		try { // Check If The Graph Is Ready
			
			this.checkGraphReady (false);
		
		} catch (GraphNotReadyException e) {
			
			throw new DFANotReadyException (e.getMessage());
	
		}
		
		if (checkStart) { // Check If There Is A Start State
		
			if (this.start == null) {
	
				throw new DFANotReadyException ("No Start Node In The Graph");
	
			}
			
		}
		
		if (checkFinal) { // Check If There Is A FInalNodes List

			if (this.finalNodes == null) {
	
				throw new DFANotReadyException ("Final Nodes Null");
	
			}
		
			if (checkEmptyFinalNodes) { // CHeck If The FinalNodes List Is Empty
			
				if (this.finalNodes.size() == 0) {
			
					throw new DFANotReadyException ("No Final Nodes In The Graph");
	
				}
				
			}
			
		}
		
	}


	
	/**
	 * Transiction Function 
	 * 
	 * @param a Symbol To Check
	 * @param currentState DFA Current State
	 * @return The Arriving Node If There Is An Arch Labelled a From currentState, Null Otherwise
	 * @throws DFANotReadyException DFA Not Correctly Initialised
	 */
	private Node<T> transitionFunction (String a, Node<T> currentState) throws DFANotReadyException {
		
		this.checkDFAReady(true, true, true); // Check If The DFA Is Ready
		 
		Node<T> finalNode = null; // Return Value
		
		boolean foundArch = false; // Arch Found Flag
		
		// Takes Only The Archs With currentState As Initial Node
		ArrayList<Arch<T>> archsList = this.archsFromNode(currentState);
		 
		for (int j = 0; (j < archsList.size() && !foundArch); j++) {
						
			foundArch = false;
						
			// Check If The Arch Has a As Label
			if (archsList.get(j).getLabel().equals(a)) {
									
				finalNode = archsList.get(j).getB();
								
				foundArch = true;
							
			}
			
		}
		
		return finalNode;
					
	}
					
		
	
	/**
	 * Transiction Function Extended To String, To Check If The
	 * Passed String Is Accepted By The DFA
	 * 
	 * @param word Word To Check
	 * @return True If The Word Belongs To The DFA's Language, False Otherwise
	 * @throws DFANotReadyException DFA Not Correctly Initialised
	 */
	public boolean transitionFunctionExtended (String word) throws DFANotReadyException {
		
		this.checkDFAReady(true, true, true); // Check If The DFA Is Ready
		 
		boolean accepted = true; // Return Value
		
		if (word != null) { // Word Must Be Different From Null
			
			Node<T> currentState = this.start; // Current State In The Computation
		
			Node<T> nextState = new Node<T>(null); // Next State In The Computation
			
			for (int i = 0; (i < word.length() + 1 && accepted); i++) { // Scan All The Symbols Of The Word
				
				if (i != (word.length() )) { // Not The Last Symbol
			
					accepted = false; // Accepted Flag
					
					nextState = this.transitionFunction(word.substring(i, i+1), currentState); // Calculate The Next State
					
					if (nextState != null) { // There Is An Arch, Go On With The Computation
						
						accepted = true;
						
						currentState = nextState;
					
					}
					
				} else { // Last Word
					
					if (accepted) {
					
						if (this.finalNodes.contains(currentState)) { // If In Final State, Accept
						
							accepted = true;
					
						} else { // Not In Final State
						
							accepted = false;						
					
						}
						
					}
					
				}				
				
			}
			
				
		} else { // Word Is Null
			
			accepted = false;
			
		}
		
		return accepted;
		
		
	}
	
	

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		try {
			
			this.checkDFAReady (true, true, true);
		
		} catch (DFANotReadyException e) {
			
			e.printStackTrace();
		
		}
		
		String toString = "DFA";
		
		toString += "\n\tName: " + this.name;
		
		toString += "\n\n\tNodes:";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			toString +=  "\n\t\t" + this.nodes.get(i);
			
		}
		
		toString += "\n\n\tArchs:";
		
		for (int i = 0; i < this.archs.size(); i++) {
			
			toString +=  "\n\t\t" + this.archs.get(i);
			
		}
		
		toString += "\n\n\t Start Node: " + start.toString();
		
		toString += "\n\n\tFinal Nodes:";
		
		for (int i = 0; i < this.finalNodes.size(); i++) {
			
			toString +=  "\n\t\t" + this.finalNodes.get(i);
			
		}
		
		return toString;
	}

	
	
}

