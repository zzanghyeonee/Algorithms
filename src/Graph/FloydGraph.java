package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FloydGraph {
	private static ArrayList<ArrayList<Integer>> arrGraph;
	private static int[][] values = new int[5][5];
	private static int[][] vector = { { 0, 1, 999, 1, 5 }, { 9, 0, 3, 2, 999 }, { 999, 999, 0, 4, 999 },
			{ 999, 999, 2, 0, 3 }, { 3, 999, 999, 999, 0 } };

	public FloydGraph(int x) {
		arrGraph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < x; i++) {
			arrGraph.add(new ArrayList<Integer>());
		}
	}

	public void put(int x, int y) {
		arrGraph.get(x).add(y);
	}

	public static void main(String[] args) {
		FloydGraph g = new FloydGraph(6);
		g.put(1, 2);
		g.put(1, 4);
		g.put(1, 5);
		g.put(2, 1);
		g.put(2, 3);
		g.put(2, 4);
		g.put(3, 4);
		g.put(4, 3);
		g.put(4, 5);
		g.put(5, 1);
		getResult();
		getWeight();
		for (int j = 0; j < vector.length; j++) {
			for (int k = 0; k < vector.length; k++) {
				System.out.print(vector[j][k] + " ");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}
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

	private static void getWeight() {
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length; j++) {
				for (int k = 0; k < vector.length; k++) {
					if (vector[j][k] > vector[j][i] + vector[i][k]) {
						vector[j][k] = vector[j][i] + vector[i][k];
						values[j][k] = i+1; //배열의 시작은 0이므로 1을 더한다.
					}
				}
			}
		}
	}
}
