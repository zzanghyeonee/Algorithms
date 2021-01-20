package NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DFSRecursive {
	private static int[] nodes = new int[4];
	private static ArrayList<ArrayList<Integer>> arrgraph;
	private static Stack s;

	public DFSRecursive(int node) {
		arrgraph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < node; i++) {
			arrgraph.add(new ArrayList<Integer>());
		}
	}

	public void put(int a, int b) {
		arrgraph.get(a).add(b);
		arrgraph.get(b).add(a);
	}

	private static void DFSearch(int i) {
		System.out.print("->" + i);
		
		push(i);
		
		for (int j = 1; j < arrgraph.get(i).size(); j++) {
			if(nodes[arrgraph.get(i).get(j)-1] == 1) {
				nodes[arrgraph.get(i).get(j)-1] = 0;
			}
			else {
				int a = (int)s.pop();
				nodes[i-1] = 1;
				DFSearch(a);
			}
		}
		
		
	}
	
	private static void push(int i) {
		for (int j = 1; j < arrgraph.get(i).size() ; j++) {
			if(nodes[arrgraph.get(i).get(j)-1] == 0) {
				s.push(arrgraph.get(i).get(j));
			}
		}
	}

	public static void main(String[] args) {
		Arrays.fill(nodes, 1);
		DFSRecursive d = new DFSRecursive(5);
		s = new Stack();
		d.put(1, 2);
		d.put(1, 3);
		d.put(1, 4);
		d.put(2, 4);
		d.put(3, 4);
		System.out.print(1);
		for (int j = 0; j < arrgraph.get(1).size(); j++) {
			s.push(arrgraph.get(1).get(j));
		}

		for (int j = 0; j < arrgraph.get(1).size(); j++) {
			int a = (int) s.pop();
			DFSearch(a);
			System.out.println();
		}
	}
}
