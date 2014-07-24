package Automata;

import DataStructures.Node;
import DataStructures.Arch;
import Exceptions.AutomatonNotReadyException;
import Exceptions.GraphNotReadyException;


import java.util.ArrayList;


public class DFA<T> extends NDFA<T> {
	
	
	
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
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	public DFA (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, Node<T> Start, ArrayList<Node<T>> FinalNodes, String Name) throws GraphNotReadyException, AutomatonNotReadyException {
		
		super(Nodes, Archs, Start, FinalNodes, Name);
				
		this.checkArchsList();		
		
	}
	
	
	
	/**
	 * Checks If The Archs Are Correct:
	 * 1) Starting And Ending Nodes Are In nodeList
	 * 2) No Lambda Transition 
	 * 3) No DUplicate Label For The Same Node (DETERMINISTIC AUTOMATON)
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialised 
	 * 
	 */
	@Override
	protected boolean checkArch (Arch<T> arch) throws GraphNotReadyException {
		
		System.out.println ("checkArch DFA: " + arch.toString());
		
		boolean returnValue = true; // Return Value
		
		if (super.checkArch (arch)) { // Look Point 1 & 2
		
			for (int i = 0; (i < this.archs.size() && returnValue); i++) { // Loop On Every Arch
				
				if (arch.getLabel().equals(this.archs.get(i))) { // Double Label
					
					returnValue = false; // Wrong Arch
					
				}
				
			}		
		
		}  else {
			
			returnValue = false;
			
		}
		
		System.out.println ("		Returns: " + returnValue);
		
		return returnValue;
		
	}
	
	
	
	/**
	 * Transiction Function 
	 * 
	 * @param a Symbol To Check
	 * @param currentState DFA Current State
	 * @return The Arriving Node If There Is An Arch Labelled a From currentState, Null Otherwise
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	private Node<T> transitionFunction (String a, Node<T> currentState) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(true, true, true); // Check If The DFA Is Ready
		 
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
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	@Override
	public boolean transitionFunctionExtended (String word) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(true, true, true); // Check If The DFA Is Ready
		 
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
			
			this.checkAutomatonReady (true, true, true);
		
		} catch (AutomatonNotReadyException e) {
			
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
			
			toString +=  "\n\t\t" + this.finalNodes.get(i).getValue();
			
		}
		
		return toString;
		
	}

	
	
}

