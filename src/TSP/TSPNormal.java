package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TSPNormal {
	private static boolean[] visited = new boolean[4];
	private static boolean[] visited2 = new boolean[4]; // visited배열과 비교하기 위해 사용
	private static ArrayList<Integer> path = new ArrayList<Integer>();
	private static ArrayList<Integer> cost = new ArrayList<Integer>();
	private static int vector[][] = { { 0, 2, 9, 999 }, { 1, 0, 6, 4 }, { 999, 7, 0, 8 }, { 6, 3, 999, 0 } };
	private static int tmpcost = 0; // 현재 cost값 저장

	public static void t(int i, int j) {
		tmpcost = tmpcost + vector[i][j];
		path.add(j);
		visited[j] = true;
		
		if(Arrays.equals(visited, visited2)) {
			path.add(0);
			tmpcost = tmpcost + vector[j][0];
			path.removeAll(path);
			path.add(0);
			Arrays.fill(visited, false);
			visited[0] = true;
			return;
		}
		else {
			int k = 6 - (i+j); // visited인덱스합 - 거쳐간 visited인덱스합
			t(j,k);
		}
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
				tmpcost = tmpcost + vector[0][i];
				path.add(i);
				visited[i] = true;
				t(i, j);
				cost.add(tmpcost);
				tmpcost = 0;
			}
		}
		Collections.sort(cost);
		System.out.println(cost.get(0));
	}
}
