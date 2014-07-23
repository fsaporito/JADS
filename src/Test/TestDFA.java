package Test;

import DataStructures.Node;
import DataStructures.Arch;
import Automata.DFA;
import Exceptions.DFANotReadyException;
import Exceptions.GraphNotReadyException;


public class TestDFA {

	public static void main (String[] args) throws GraphNotReadyException, DFANotReadyException {
		
		
		// Nodes Creation
		Node<String> Q0 = new Node<String> ("q0");	
	
		Node<String> Q1 = new Node<String> ("q1");	
	
		Node<String> Q2 = new Node<String> ("q2");		
	
		Node<String> Start = Q0;
	
		
		// Archs Creation
		Arch<String> A01 = new Arch<String> (Q0, Q1, "0");
	
		Arch<String> A00 = new Arch<String> (Q0, Q0, "1");
		
		Arch<String> A10 = new Arch<String> (Q1, Q0, "1");	
		
		Arch<String> A11 = new Arch<String> (Q1, Q1, "0");	
	
	
		// AUtoma Creation
		DFA<String> Automa = new DFA<String> ("DFA");
				
		
		
		try {
			
			// Adding Nodes 
			
			Automa.addNode(Q0);
			
			Automa.addNode(Q1);
			
			Automa.addFinalNode(Q1);
		
			Automa.addNode(Q2);
			
			
			// Adding Archs
			Automa.addArch(A00);
			
			Automa.addArch(A01);
			
			Automa.addArch(A10);
			
			Automa.addArch(A11);
			
			
			// Adding Start Node
			Automa.setStart(Start);
			
		} catch (GraphNotReadyException e1) {
			
			e1.printStackTrace();
			
		} catch (DFANotReadyException e) {

			e.printStackTrace();
			
		}		
		
	
		System.out.println (Automa.toString());
		
		
		try {			
		
			System.out.println ("\n\nExtended Transiction Function:");
			
			System.out.println (" - 0 (True): " + Automa.transitionFunctionExtended("0"));
			
			System.out.println (" - 10 (True): " + Automa.transitionFunctionExtended("10"));
			
			System.out.println (" - 111010 (True): " + Automa.transitionFunctionExtended("111010"));
			
			System.out.println (" - 101010 (True): " + Automa.transitionFunctionExtended("101010"));
		
		} catch (DFANotReadyException e) {

			e.printStackTrace();
		
		}
	
	}
	
}
