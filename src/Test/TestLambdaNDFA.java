package Test;


import DataStructures.Node;
import DataStructures.Arch;
import Automata.LambdaNDFA;
import Exceptions.AutomatonNotReadyException;
import Exceptions.GraphNotReadyException;
import Exceptions.WrongArchException;


public class TestLambdaNDFA {

	public static void main (String[] args) throws GraphNotReadyException, AutomatonNotReadyException, WrongArchException {
		
		
		/*
		 * 	  |	   a	|    b	  |	Lambda
		 * q0 |	  q1	| q1, q2  |	q1, q2
		 * q1 |	q0, q2	| q0, q2  |		
		 * q2 |   -     | q0, q1  |	 
		 * 
		 */
		
		
		// Nodes Creation
		Node<String> Q0 = new Node<String> ("q0");		
		Node<String> Q1 = new Node<String> ("q1");		
		Node<String> Q2 = new Node<String> ("q2");	
		Node<String> Q3 = new Node<String> ("q3");			
		Node<String> Q4 = new Node<String> ("q4");
		Node<String> Q5 = new Node<String> ("q5");
		Node<String> Q6 = new Node<String> ("q6");
	
		Node<String> Start = Q0;
	
		
		// Archs Creation
		Arch<String> A01 = new Arch<String> (Q0, Q1, "");
		Arch<String> A01a = new Arch<String> (Q0, Q1, "a");
		Arch<String> A02 = new Arch<String> (Q0, Q2, "");
		Arch<String> A03a = new Arch<String> (Q0, Q3, "a");
		Arch<String> A04b = new Arch<String> (Q0, Q4, "b");		
		Arch<String> A06a = new Arch<String> (Q0, Q6, "a");	
		
		Arch<String> A12 = new Arch<String> (Q1, Q2, "");
		Arch<String> A14 = new Arch<String> (Q1, Q4, "");
		
		Arch<String> A22b = new Arch<String> (Q2, Q2, "b");
		
		Arch<String> A30a = new Arch<String> (Q3, Q0, "a");
		Arch<String> A32 = new Arch<String> (Q3, Q2, "");
		Arch<String> A35b = new Arch<String> (Q3, Q5, "b");
		
		Arch<String> A40b = new Arch<String> (Q4, Q0, "b");
		Arch<String> A41a = new Arch<String> (Q4, Q1, "a");
		Arch<String> A42b = new Arch<String> (Q4, Q2, "b");
		
		Arch<String> A50 = new Arch<String> (Q5, Q0, "");
		Arch<String> A52 = new Arch<String> (Q5, Q2, "");
		Arch<String> A55a = new Arch<String> (Q5, Q5, "a");
		
		Arch<String> A64 = new Arch<String> (Q6, Q4, "");
		Arch<String> A66b = new Arch<String> (Q6, Q6, "b");
		
	
	
		// Automa Creation
		LambdaNDFA<String> Automa = new LambdaNDFA<String> ("NDFA");
				
		
		
		try {
			
			// Adding Nodes 
			
			Automa.addNode(Q0);
			
			Automa.addNode(Q1);
			
			Automa.addFinalNode(Q1);
		
			Automa.addNode(Q2);
			
			Automa.addFinalNode(Q2);
			
			Automa.addNode(Q3);
			
			Automa.addNode(Q4);
			
			Automa.addNode(Q5);
			
			Automa.addNode(Q6);
			
			
			// Adding Archs
			Automa.addArch(A01);	
			Automa.addArch(A01a);
			Automa.addArch(A02);			
			Automa.addArch(A03a);
			Automa.addArch(A04b);
			Automa.addArch(A06a);
			
			Automa.addArch(A12);		
			Automa.addArch(A14);
			
			Automa.addArch(A22b);
			
			Automa.addArch(A30a);
			Automa.addArch(A32);
			Automa.addArch(A35b);
			
			Automa.addArch(A40b);;
			Automa.addArch(A41a);
			Automa.addArch(A42b);
			
			Automa.addArch(A50);;
			Automa.addArch(A52);
			Automa.addArch(A55a);			
			
			Automa.addArch(A64);
			Automa.addArch(A66b);
			
			
			
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
			
			
			
			System.out.println (" - a (True): " + Automa.transitionFunctionExtended("a"));
			
			System.out.println (" - b (True): " + Automa.transitionFunctionExtended("b"));
			
			System.out.println (" - abc (False): " + Automa.transitionFunctionExtended("abc"));
			
			System.out.println (" - abb (True): " + Automa.transitionFunctionExtended("abb"));
			
			System.out.println (" - abaaaabbb (True): " + Automa.transitionFunctionExtended("abaaaabbb"));
			
			/*
			System.out.println (" - bac (False): " + Automa.transitionFunctionExtended("bac"));
			
			System.out.println (" - babc (True): " + Automa.transitionFunctionExtended("babc"));
			
			System.out.println (" - aaaa (True): " + Automa.transitionFunctionExtended("aaaa"));
			
			System.out.println (" - aabb (True): " + Automa.transitionFunctionExtended("aabb"));
			
			System.out.println (" - baba (True): " + Automa.transitionFunctionExtended("baba"));
			
			System.out.println (" - aaaabbb (True): " + Automa.transitionFunctionExtended("aaaaaabbb"));
			
			System.out.println (" - aaaabbcca (False): " + Automa.transitionFunctionExtended("aaaaaabbcca"));
			
			System.out.println (" - aaaabbbcc (True): " + Automa.transitionFunctionExtended("aaaaababbcc"));*/
		
		} catch (AutomatonNotReadyException e) {

			e.printStackTrace();
		
		}
	
	}
	
}