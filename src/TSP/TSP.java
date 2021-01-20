package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TSP {
	private static boolean[] visited = new boolean[4];
	private static boolean[] visited2 = new boolean[4]; // visited배열과 비교하기 위해 사용
	private static ArrayList<Integer> path = new ArrayList<Integer>();
	private static ArrayList<Integer> cost = new ArrayList<Integer>();
	private static int vector[][] = { { 0, 2, 9, 999 }, { 1, 0, 6, 4 }, { 999, 7, 0, 8 }, { 6, 3, 999, 0 } };
	private static int tmpcost = 0; // 현재 cost값 저장

	public static int t(int i, int j) {
		tmpcost = tmpcost + vector[0][i] + vector[i][j];
		visited[i] = true;
		visited[j] = true;
		path.add(i);
		path.add(j);

		for (int j2 = 0; j2 < visited.length; j2++) {
			if (visited[j2] == true)
				continue;
			t(i, j, j2);
		}

		if (Arrays.equals(visited, visited2)) {
			path.removeAll(path);
			path.add(0);
			Arrays.fill(visited, false);
			visited[0] = true;
		}
		return tmpcost;
	}

	public static void t(int i, int j, int j2) {
		tmpcost = tmpcost + vector[j][j2] + vector[j2][0];
		path.add(j2);
		visited[j2] = true;
	}

	public static void main(String[] args) {
		Arrays.fill(visited, false);
		Arrays.fill(visited2, true);
		path.add(0);
		visited[0] = true;

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				if (i == j)
					continue;
				cost.add(t(i, j));
				tmpcost = 0;
			}
		}
		Collections.sort(cost);
		System.out.println(cost.get(0));
	}
}
