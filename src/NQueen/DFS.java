package NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	private static int[] nodes = new int[4];
	private static ArrayList<ArrayList<Integer>> arrgraph;
	private static Stack s;

	public DFS(int node) {
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
		nodes[i - 1] = 1;
		System.out.print(i);
		for (int j = 0; j < arrgraph.get(i).size(); j++) {
			s.push(arrgraph.get(i).get(j));
			nodes[arrgraph.get(i).get(j) - 1] = 1;
		}

		while (s.isEmpty() == false) {
			int a = (int) s.pop();
			System.out.println("->" + a);
			for (int k = 1; k < arrgraph.get(a).size(); k++) {
				if (nodes[arrgraph.get(a).get(k) - 1] == 1) {
					nodes[arrgraph.get(a).get(k) - 1] = 0;
				} else if (nodes[arrgraph.get(a).get(k) - 1] == 0) {
					nodes[a-1] = 1;
					System.out.print("->" + a);
					s.push(arrgraph.get(a).get(k));
				}
			}
		}
	}

	public static void main(String[] args) {
		Arrays.fill(nodes, 1);
		DFS d = new DFS(5);
		s = new Stack();
		d.put(1, 2);
		d.put(1, 3);
		d.put(1, 4);
		d.put(2, 4);
		d.put(3, 4);

		DFSearch(1);
	}
}
