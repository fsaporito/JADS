package Test;

import DataStructures.Arch;
import DataStructures.Graph;
import DataStructures.Node;
import Exceptions.GraphNotReadyException;

public class TestGraph {

	public static void main (String[] args) {
			
		// Nodes Creation
		System.out.println ("\nNodes Creation: ");
		
		Node<String> Q0 = new Node<String> ("q0");	
		System.out.println (" - Q0: " + Q0.toString());
		
		Node<String> Q1 = new Node<String> ("q1");	
		System.out.println (" - Q1: " + Q1.toString());
		
		Node<String> Q2 = new Node<String> ("q2");		
		System.out.println (" - Q2: " + Q2.toString());
		
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
		
		
// ################################################################
//			Graph Test
// ################################################################
			
		System.out.println ("\n");
		
		Graph<String> G1 = new Graph<String> ("G1");
		
		try {
			
			G1.addNode(Q0);
			G1.addNode(Q1);
			G1.addNode(Q2);
			
			G1.addArch(A00);
			G1.addArch(A01);
			G1.addArch(A10);
			G1.addArch(A11);
			
			System.out.println(G1.toString());
		
		} catch (GraphNotReadyException e) {
			
			e.printStackTrace();
			
		}
	
	
	}

}
