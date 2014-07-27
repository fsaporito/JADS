package Automata;

import java.util.ArrayList;

import DataStructures.Arch;
import DataStructures.GraphOriented;
import DataStructures.Node;
import Exceptions.AutomatonNotReadyException;
import Exceptions.GraphNotReadyException;

public class LambdaNDFA<T> extends GraphOriented<T> {
	
	// Invert Hierarchy Order:  Actually DFA >> NDFA >> lambdaNFA
	// Implements checkArchs To Verify 1
	
	/** Start Node */
	protected Node<T> start;
	
	/** FinalNodes List (Accepting States)*/
	protected ArrayList<Node<T>> finalNodes;
	
	
	/**
	 * Constructor That Create An Empty LambdaNDFA
	 * 
	 * @param name Lambda NDFA's Name
	 */
	public LambdaNDFA (String name) {
		
		super(name);
		
		this.finalNodes = new ArrayList<Node<T>>();
	
	}

	
	/** 
	 * Constructor That Creates The LambdaNDFA
	 * 
	 * @param Nodes Nodes List
	 * @param Archs Archs List
	 * @param Start Start State
	 * @param FinalNodes FinalNodes List
	 * @param Name LambdaNDFA's Name
	 * @throws GraphNotReadyException Graph Is Not Correctly Initialised
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	public LambdaNDFA (ArrayList<Node<T>> Nodes, ArrayList<Arch<T>> Archs, Node<T> Start, ArrayList<Node<T>> FinalNodes, String Name) throws GraphNotReadyException, AutomatonNotReadyException {
		
		super (Nodes, Archs, Name);
		
		this.start = Start;
		
		this.finalNodes = FinalNodes;
		
		this.checkFinalNodeDuplicates();
		
		this.checkArchsList();
		
	}
	
	
	


	/**
	 * Check If The Automaton Is Correctly Initialised
	 * 
	 * @param checkStart Check The Start State
	 * @param checkFinal Check If There Is A FinalState List
	 * @param checkEmptyFinalNodes Check If The FinalState List Is Empty
	 * @throws AutomatonNotReadyException Automaton Not Correctly Initialised
	 */
	protected void checkAutomatonReady (boolean checkStart, boolean checkFinal, boolean checkEmptyFinalNodes) throws AutomatonNotReadyException {
		
		try { // Check If The Graph Is Ready
			
			this.checkGraphReady (false);
		
		} catch (GraphNotReadyException e) {
			
			throw new AutomatonNotReadyException (e.getMessage());
	
		}
		
		if (checkStart) { // Check If There Is A Start State
		
			if (this.start == null) {
	
				throw new AutomatonNotReadyException ("No Start Node In The Graph");
	
			}
			
		}
		
		if (checkFinal) { // Check If There Is A FInalNodes List

			if (this.finalNodes == null) {
	
				throw new AutomatonNotReadyException ("Final Nodes Null");
	
			}
		
			if (checkEmptyFinalNodes) { // CHeck If The FinalNodes List Is Empty
			
				if (this.finalNodes.size() == 0) {
			
					throw new AutomatonNotReadyException ("No Final Nodes In The Graph");
	
				}
				
			}
			
		}
		
	}

	
	
	/**
	 * Checks If The Arch Is Correct:
	 * - Starting And Ending Nodes Are In nodeList 
	 * 
	 * @param arch Arch To Check
	 * @throws GraphNotReadyException Graph No Correctly Initialised
	 * 
	 */
	@Override
	protected boolean checkArch (Arch<T> arch) throws GraphNotReadyException {
		
		System.out.println ("checkArch lambdaNDFA: " + arch.toString());
		
		boolean returnValue = false;
		
		if (super.checkArch(arch)) { 
			
			if (arch.getFixed()) { 
				
				returnValue = true;
				
			}
			
		}
		
		System.out.println ("		Returns: " + returnValue);
		
		return returnValue;
		
	}

	
	
	/**
	 * Check If The Final Node List Has Duplicates
	 * 
	 * @throws AutomatonNotReadyException
	 */
	protected void checkFinalNodeDuplicates() throws AutomatonNotReadyException {
		
		try {
			
			this.checkNodeDuplicates(this.finalNodes);
			
		} catch (GraphNotReadyException e) {
			
			throw new AutomatonNotReadyException ("Duplicate entries in the finalNodeList!!!");
		
		}
		
	}
	
	
	
	/**
	 * Method To Add A Final Node To The DFA
	 * If Not Present In The Nodes List, Adds It
	 * 
	 * @param Node Final Node
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	public void addFinalNode (Node<T> Node) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(false, true, false);
		
		if (!this.nodes.contains(Node)) {
			
			try {
				
				this.addNode(Node);
			
			} catch (GraphNotReadyException e) {
				
				throw new AutomatonNotReadyException (e.getMessage());
				
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
	 * @throws AutomatonNotReadyException Automaton Not Correctly Initialised
	 */
	public void setStart (Node<T> Start) throws AutomatonNotReadyException {
		
		if (!this.nodes.contains(Start)) {
			
			try {
				
				this.addNode(Start);
				
			} catch (GraphNotReadyException e) {

				throw new AutomatonNotReadyException (e.getMessage());
				
			}
			
		}

		this.start = Start;
		
	}
	
	
	/** 
	 * Method To Add An Arch 
	 * (Must Be With fixedLabel)
	 * 
	 * @param Arch Arch To Be Added To The NDFA
	 * @throws GraphNotReadyException The Graph Is Not Correctly Initialised
	 */
	@Override
	public void addArch (Arch<T> Arch) throws GraphNotReadyException {
		
		System.out.println ("addArch: " + Arch.toString());
		
		this.checkGraphReady (false);
		
		System.out.println ("	- Graph Is Ready :)");

		if (Arch.getFixed()) { // Label Must Be Fixed
			
			System.out.println ("	- Label Is Fixed :)");
	
			if (!this.archs.contains(Arch)) { // Arch Can't Be Already Present
			
				System.out.println ("	- Arco Non Già Presente :)");
				
				if (this.checkArch(Arch)) {
					
					System.out.println ("	- Arco Ok :)");
				
					this.archs.add(Arch);
					
					System.out.println ("	- Arco Aggiunto :)");
					
				}
				
			}
			
		}	
		
	}

	


	/**
	 * Enclose The Current State
	 * 
	 * @param currentState DFA Current State
	 * @return Arrayist With The Nodes
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	public ArrayList<Node<T>> enClose (Node<T> currentState, ArrayList<Node<T>> enclosedStates) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(true, true, true); // Check If The NDFA Is Ready
		
		enclosedStates.add(currentState); // Add currentState To The List With The Already Enclosed States
		
		ArrayList<Node<T>> enclosedNodes = new ArrayList<Node<T>>(); // Enclosed Nodes List
		 
		ArrayList<Arch<T>> encloseArch = new ArrayList<Arch<T>>(); // Arch With Lambda Transition
		
		// Find Lambda Transition Archs
		try {
			
			encloseArch = this.archsWithLabel("");
		
		} catch (GraphNotReadyException e) {
			
			throw new AutomatonNotReadyException (e.getMessage());
			
		} 
		
		if (encloseArch != null && encloseArch.size() > 0) { // At Least One Arch Found
			
			for (int i = 0; i < encloseArch.size(); i++) { // For Every Lambda Transition Arch
				
				if (currentState.equals(encloseArch.get(i).getA())) { // Find Every Lambda Transition Arch That Start With currentState
					
					enclosedNodes.add(encloseArch.get(i).getB()); // Add Reachable Node Via Lambda Transition To ArrayList
					
				}				
				
			}
			
			if (enclosedNodes.size() > 0) { // At Least One Reachale Node With Lamda Transition
				
				ArrayList<Node<T>> enclosedNodesTMP = new ArrayList<Node<T>>(); // Enclosed Nodes List
				
				for (int i = 0; i < enclosedNodes.size(); i++) { // Second Enclose
					
					if (!enclosedStates.contains(enclosedNodes.get(i))) { // Not Already Enclosed
						
						// Enclose The State
						enclosedNodesTMP = enClose (enclosedNodes.get(i), enclosedStates);
						
						enclosedStates = enclosedNodesTMP;
						
					}
					
				}
							
				
			}
			
		}
		
		return enclosedStates;
					
	}
	
	
	
	/**
	 * Transiction Function 
	 * 
	 * @param a Symbol To Check
	 * @param currentState DFA Current State
	 * @return The Arriving Node If There Is An Arch Labelled a From currentState, Null Otherwise
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	private ArrayList<Node<T>> transitionFunction (String a, Node<T> currentState) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(true, true, true); // Check If The DFA Is Ready

		ArrayList<Node<T>> finalNodes = new ArrayList<Node<T>>(); // Return Value
		
		// Takes Only The Archs With currentState As Initial Node
		ArrayList<Arch<T>> archsList = this.archsFromNode(currentState);
				 
		for (int j = 0; j < archsList.size(); j++) {
						
			// Check If The Arch Has a As Label
			if (archsList.get(j).getLabel().equals(a)) {
									
				finalNodes.add(archsList.get(j).getB());				
							
			}
			
		}
		
		if (finalNodes.size() < 1) {
			
			finalNodes = null;
			
		}
			
		return finalNodes;
					
	}
					
		
	
	/**
	 * Transiction Function Extended To String, To Check If The
	 * Passed String Is Accepted By The NDFA
	 * 
	 * @param word Word To Check
	 * @return True If The Word Belongs To The DFA's Language, False Otherwise
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	public boolean transitionFunctionExtended (String word) throws AutomatonNotReadyException {
		
		this.checkAutomatonReady(true, true, true); // Check If The DFA Is Ready
		 
		boolean accepted = false;
		
		if (word != null) { // Null Word Cannot Be Accepted
		
			accepted = this.recursiveTransictionFunctionExtended(word, this.start);
			
		}
		
		return accepted;
		
		
	}
	
	
	/**
	 * Recursive Transiction Function To Check If The Passed String Is Accepted
	 * By Calling Itself On Every State Generate By The TransictionFunction, 
	 * Reducing Step By Step The Word
	 * 
	 * @param word Word To Check
	 * @return True If The Word Belongs To The DFA's Language, False Otherwise
	 * @throws AutomatonNotReadyException DFA Not Correctly Initialised
	 */
	private boolean recursiveTransictionFunctionExtended (String word, Node<T> currentState) throws AutomatonNotReadyException {
		
		boolean accepted = false; // Return Value
		
		ArrayList<Node<T>> enclosedNodes = new ArrayList<Node<T>>(); // enclose(currentState)
		
		enclosedNodes = this.enClose(currentState, enclosedNodes); // Closing currentState
		
		if ( word != null) { // Still Character To Compute
			
			boolean TMPaccepted = false; // Recursive Function Return Value
				
			ArrayList<Node<T>> nextStates = new ArrayList<Node<T>>(); // Next States In The Computation
			
			ArrayList<Node<T>> nextStatesTMP = new ArrayList<Node<T>>(); // Next States TMP For The Enclosed State
		
			for (int i = 0; i < enclosedNodes.size(); i++) { // Transition Function For Every Enclosed State
				
				nextStatesTMP = this.transitionFunction(word.substring(0, 1), enclosedNodes.get(i)); // Transition Function Computation
				
				if (nextStatesTMP != null) {
			
					for (int j = 0; j < nextStatesTMP.size(); j++) { // Add Every Node To The ArrayList

						if (!nextStates.contains(nextStatesTMP.get(j))) {
						
							nextStates.add(nextStatesTMP.get(j));
							
						}
						
					}
					
				}
				
			}
				
			if (nextStates != null || nextStates.size() == 0) { // There Is An Arch, Go On With The Computation
				
				String nextWord = new String();
						
				if (word.length() > 1) { // Recursive Step
					
					nextWord = word.substring(1);
					
				} else { // // Word Ended, Pass null As Word
					
					nextWord = null;
				}
					
				for (int i = 0; i < nextStates.size(); i++) {
					
					TMPaccepted = this.recursiveTransictionFunctionExtended(nextWord, nextStates.get(i)); // Calculate Result From nextStatus(i)
					
					accepted = accepted || TMPaccepted; 
					
				}
				
			} 
						
		} else { // Finished Computing, Check If Final State
					
			for (int i = 0; (i  < enclosedNodes.size() && !accepted); i++) {
				
				if (this.finalNodes.contains(enclosedNodes.get(i))) { // If In Final State, Accept
								
					accepted = true;
							
				} else { // Not In Final State
								
					accepted = false;						
							
				}
				
			}
								
		}
	
		return accepted;		
		
	}
	
	
	public String enCloseToString (Node<T> nodeToEnclose) throws AutomatonNotReadyException {
		
		String toString = new String();
		
		ArrayList<Node<T>> enclosedStates = new ArrayList<Node<T>>();
		
		ArrayList<T> enclosedStatesValues = new ArrayList<T>();
		
		enclosedStates = this.enClose(nodeToEnclose, new ArrayList<Node<T>>());
		
		for (int i = 0; i < enclosedStates.size(); i++) {
			
			enclosedStatesValues.add(enclosedStates.get(i).getValue());
			
		}
		
		toString = enclosedStatesValues.toString();
		
		return toString;		
		
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
		
		toString += "\n\n\tStart Node: " + start.getValue().toString();
		
		toString += "\n\n\tFinal Nodes = [";
		
		for (int i = 0; i < this.finalNodes.size(); i++) {
			
			if (i == 0) {
			
				toString +=  this.finalNodes.get(i).getValue();
				
			} else  {
				
				toString += ", " +  this.finalNodes.get(i).getValue();
				
			}
			
		}
		
		toString += "]";
		
		toString += "\n\n\tClosures:";
		
		for (int i = 0; i < this.nodes.size(); i++) {
			
			try {
				
				toString += "\n\t\tEnclose(" + this.nodes.get(i).getValue() + ") = " + this.enCloseToString(this.nodes.get(i));
				
			} catch (AutomatonNotReadyException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		return toString;
	
	}
	
	
}
