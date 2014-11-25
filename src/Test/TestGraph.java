package Test;

import DataStructures.Arch;
import DataStructures.GraphOriented;
import DataStructures.Node;
import Exceptions.GraphNotReadyException;
import Exceptions.WrongArchException;

public class TestGraph {

	public static void main (String[] args) throws WrongArchException {
			
		// Nodes Creation
		System.out.println ("\nNodes Creation: ");
		
		Node<String> Q0 = new Node<String> ("q0");	
		System.out.println (" - Q0: " + Q0.toString());
		
		Node<String> Q1 = new Node<String> ("q1");	
		System.out.println (" - Q1: " + Q1.toString());
		
		Node<String> Q2 = new Node<String> ("q2");		
		System.out.println (" - Q2: " + Q2.toString());
		
		Node<String> Q3 = new Node<String> ("q3");		
		System.out.println (" - Q3: " + Q3.toString());
		
		Node<String> Q4 = new Node<String> ("q4");		
		System.out.println (" - Q4 " + Q4.toString());
		
		Node<String> Q5 = new Node<String> ("q5");		
		System.out.println (" - Q5 " + Q5.toString());
		
		Node<String> Q6 = new Node<String> ("q6");		
		System.out.println (" - Q6 " + Q6.toString());
		
		
		// Archs Creation
		System.out.println ("\nArchs Creation: ");
		
		Arch<String> A00 = new Arch<String> (Q0, Q0, "1");
		System.out.println (" - A00: " + A00.toString());
		
		Arch<String> A01 = new Arch<String> (Q0, Q1, "0");		
		System.out.println (" - A01: " + A01.toString());
		
		Arch<String> A10 = new Arch<String> (Q1, Q0, "1");
		System.out.println (" - A10: " + A10.toString());
		
		Arch<String> A11 = new Arch<String> (Q1, Q1, "0");
		System.out.println (" - A11: " + A11.toString());
		
		Arch<String> A12 = new Arch<String> (Q1, Q2, "1");
		System.out.println (" - A12: " + A12.toString());
		
		Arch<String> A34 = new Arch<String> (Q3, Q4, "0");
		System.out.println (" - A34: " + A34.toString());
		
		Arch<String> A45 = new Arch<String> (Q4, Q5, "1");
		System.out.println (" - A45: " + A45.toString());
		
		Arch<String> A53 = new Arch<String> (Q5, Q3, "0");
		System.out.println (" - A53: " + A53.toString());
		
		
// ################################################################
//			Graph Test
// ################################################################
			
		System.out.println ("\n");
		
		GraphOriented<String> G1 = new GraphOriented<String> ("G1");
		
		try {
			
			G1.addNode(Q0);
			G1.addNode(Q1);
			G1.addNode(Q2);
			G1.addNode(Q3);
			G1.addNode(Q4);
			G1.addNode(Q5);
			G1.addNode(Q6);
			
			
			G1.addArch(A00);
			G1.addArch(A01);
			G1.addArch(A10);
			G1.addArch(A11);
			G1.addArch(A12);
			G1.addArch(A34);
			G1.addArch(A45);
			G1.addArch(A53);
			
			System.out.println ("\n\n\nTO STRING:\n");
			
			System.out.println(G1.toString());
			
		} catch (GraphNotReadyException e) {
			
			e.printStackTrace();
			
		}
	
	
	}

}
