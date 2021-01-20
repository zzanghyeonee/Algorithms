package MST;

import java.util.Arrays;

public class Prim2 {
	private static int INF = 999;
	private static int[][] vector = { { 0, 7, INF, INF, 3, 10, INF }, { 7, 0, 4, 10, 2, 6, INF },
			{ INF, 4, 0, 2, INF, INF, INF }, { INF, 10, 2, 0, INF, 9, 4 }, { 3, 2, INF, INF, 0, INF, 5 },
			{ 10, 6, INF, 9, INF, 0, INF }, { INF, INF, INF, 4, 5, INF, 0 } };
	private static int[] distance = new int[7];
	private static int[] distance2 = new int[7];
	private static int[] nearest = new int[7];

	public static void main(String[] args) {
		Arrays.fill(distance2, -1);
		for (int i = 0; i < distance.length; i++) {
			distance[i] = vector[0][i];
		}
		Prim(0);
	}

	private static void Prim(int i) {
		int min = 100;
		int pos = 0;
		int pos2 = 0;
		int k = 0;
		distance[i] = -1;

		if (Arrays.equals(distance, distance2)) {
			System.out.println("종료");
		} else {
			for (int j = 0; j < distance.length; j++) {
				if (distance[j] == -1)
					continue;
				if (distance[j] > vector[i][j]) {
					distance[j] = vector[i][j];
					nearest[j] = i;
				}
			}

			for (k = 0; k < distance.length; k++) {
				if (distance[k] == -1)
					continue;
				if (min > distance[k]) {
					min = distance[k];
					pos = k;
					pos2 = nearest[k];
				}
			}
			System.out.println(pos2 + " - " + pos);
			Prim(pos);
		}
	}
}
