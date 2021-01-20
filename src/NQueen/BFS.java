package NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	private static int[] nodes = new int[4];
	private static ArrayList<ArrayList<Integer>> arrgraph;
	private static Queue q;

	public BFS(int node) {
		arrgraph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < node; i++) {
			arrgraph.add(new ArrayList<Integer>());
		}
	}

	public void put(int a, int b) {
		arrgraph.get(a).add(b);
		arrgraph.get(b).add(a);
	}

	private static void BFSearch(int i) {
		nodes[i-1] = 1;
		System.out.print(i);
		for (int j = 0; j < arrgraph.get(i).size(); j++) {
			q.offer(arrgraph.get(i).get(j));
			nodes[arrgraph.get(i).get(j)-1] = 0;
		}

		while (q.isEmpty() == false) {
			int a = (int) q.remove();
			System.out.print("->" + a);
			for (int k = 1; k < arrgraph.get(a).size(); k++) {
				if (nodes[arrgraph.get(a).get(k) - 1] == 0) {
					nodes[a - 1] = 1;
					for (int l = 0; l < q.size(); l++) { //중복 제거
						if(q.contains(arrgraph.get(a).get(k))) {
							continue;
						}
						q.offer(arrgraph.get(a).get(k));
					}
				} 
				else if(nodes[arrgraph.get(a).get(k)-1] == 1) {
					continue;
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS d = new BFS(5);
		q = new LinkedList();
		d.put(1, 2);
		d.put(1, 3);
		d.put(1, 4);
		d.put(2, 4);
		d.put(3, 4);

		BFSearch(1);
	}
}
