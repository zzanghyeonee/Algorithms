package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	private static ArrayList<ArrayList<Integer>> arrGraph;

	public Graph(int x) {
		arrGraph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < x; i++) {
			arrGraph.add(new ArrayList<Integer>());
		}
	}
	
	public void put(int x ,int y) {
		arrGraph.get(x).add(y);
		arrGraph.get(y).add(x);
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int data = s.nextInt();
			int data2 = s.nextInt();
			g.put(data, data2);
		}
		getResult();
	}
	
	private static void getResult() {
		for (int i = 1; i < arrGraph.size(); i++) {
			System.out.print("접점" + i + "의 인접리스트");

			for (int j = 0; j < arrGraph.get(i).size(); j++) {
					System.out.print("->" + arrGraph.get(i).get(j));
				}
			System.out.println();
			}
		}
	}

