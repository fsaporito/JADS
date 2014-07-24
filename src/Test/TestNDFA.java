package Test;

import DataStructures.Node;
import DataStructures.Arch;
import Automata.NDFA;
import Exceptions.AutomatonNotReadyException;
import Exceptions.GraphNotReadyException;
import Exceptions.WrongArchException;


public class TestNDFA {

	public static void main (String[] args) throws GraphNotReadyException, AutomatonNotReadyException, WrongArchException {
		
		
		/*
		 * 	  |	   a	|    b	  |	c
		 * q0 |	  q1	| q1, q2  |	-
		 * q1 |	q0, q2	| q0, q2  |	q1
		 * q2 |   -     | q0, q1  | -	 
		 * 
		 */
		
		// RegularExpression
		String reg = "(1*00*)^(+)";
		
		// Nodes Creation
		Node<String> Q0 = new Node<String> ("q0");	
	
		Node<String> Q1 = new Node<String> ("q1");	
	
		Node<String> Q2 = new Node<String> ("q2");		
	
		Node<String> Start = Q0;
	
		
		// Archs Creation
		Arch<String> A01a = new Arch<String> (Q0, Q1, "a");
		Arch<String> A01b = new Arch<String> (Q0, Q1, "b");
		Arch<String> A02b = new Arch<String> (Q0, Q2, "b");	
		
		Arch<String> A10a = new Arch<String> (Q1, Q0, "a");		
		Arch<String> A10b = new Arch<String> (Q1, Q0, "b");
		Arch<String> A11c = new Arch<String> (Q1, Q1, "c");
		Arch<String> A12a = new Arch<String> (Q1, Q2, "a");
		Arch<String> A12b = new Arch<String> (Q1, Q1, "b");	
			
		
		Arch<String> A20b = new Arch<String> (Q2, Q0, "b");	
		Arch<String> A21b = new Arch<String> (Q2, Q1, "b");
	
	
		// AUtoma Creation
		NDFA<String> Automa = new NDFA<String> ("NDFA");
				
		
		
		try {
			
			// Adding Nodes 
			
			Automa.addNode(Q0);
			
			Automa.addNode(Q1);
			
			Automa.addFinalNode(Q1);
		
			Automa.addNode(Q2);
			
			
			// Adding Archs
			Automa.addArch(A01a);			
			Automa.addArch(A01b);			
			Automa.addArch(A02b);
			
			Automa.addArch(A10a);		
			Automa.addArch(A10b);
			Automa.addArch(A11c);
			Automa.addArch(A12a);
			Automa.addArch(A12b);	
			
			Automa.addArch(A20b);
			Automa.addArch(A21b);
			
			
			// Adding Start Node
			Automa.setStart(Start);
			
		} catch (GraphNotReadyException e1) {
			
			e1.printStackTrace();
			
		} catch (AutomatonNotReadyException e) {

			e.printStackTrace();
			
		}		
		
	
		System.out.println (Automa.toString());
		
		
		try {			
		
			System.out.println ("\n\nExtended Transiction Function:");
			
			System.out.println ("REGULAR EXPRESSION = " + reg);
			
			System.out.println (" - a (True): " + Automa.transitionFunctionExtended("a"));
			
			System.out.println (" - b (True): " + Automa.transitionFunctionExtended("b"));
			
			System.out.println (" - c (False): " + Automa.transitionFunctionExtended("c"));
			
			System.out.println (" - abc (True): " + Automa.transitionFunctionExtended("abc"));
			
			System.out.println (" - bac (False): " + Automa.transitionFunctionExtended("bac"));
			
			System.out.println (" - babc (True): " + Automa.transitionFunctionExtended("babc"));
			
			System.out.println (" - aaa (True): " + Automa.transitionFunctionExtended("aaa"));
			
			System.out.println (" - aabb (True): " + Automa.transitionFunctionExtended("aabb"));
			
			System.out.println (" - baba (True): " + Automa.transitionFunctionExtended("baba"));
			
			System.out.println (" - aaaabbb (True): " + Automa.transitionFunctionExtended("aaaaaabbb"));
			
			System.out.println (" - aaaabbcca (False): " + Automa.transitionFunctionExtended("aaaaaabbcca"));
			
			System.out.println (" - aaaabbbcc (True): " + Automa.transitionFunctionExtended("aaaaababbcc"));
		
		} catch (AutomatonNotReadyException e) {

			e.printStackTrace();
		
		}
	
	}
	
}
