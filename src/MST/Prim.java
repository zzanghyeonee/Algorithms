package MST;

import java.util.Arrays;

public class Prim {
	private static int INF = 999;
	private static int[][] vector = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 },
			{ INF, 6, 4, 0, 5 }, { INF, INF, 2, 5, 0 } };
	private static int[] distance = new int[5];
	private static int[] distance2 = new int[5];
	private static int[] nearest = new int[5];

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
