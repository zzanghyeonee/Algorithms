package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class TSPbit {
	private static int visited = 0;
	private static int visited2 = 15; // visited배열과 비교하기 위해 사용
	private static ArrayList<Integer> path = new ArrayList<Integer>();
	private static ArrayList<Integer> cost = new ArrayList<Integer>();
	private static int vector[][] = { { 0, 2, 9, 999 }, { 1, 0, 6, 4 }, { 999, 7, 0, 8 }, { 6, 3, 999, 0 } };
	private static int tmpcost = 0; // 현재 cost값 저장
	
	public static int t(int i, int j) {
		tmpcost = tmpcost + vector[0][i] + vector[i][j];
		visited = (int) (visited + Math.pow(2, i) + Math.pow(2, j));
		path.add(i);
		path.add(j);
		int j2 = 0;
		
		if(!(getBit(~visited) == getBit(0))) {
			for (int p = 0; p < 4; p++) {
				if((visited2 - visited == (int)Math.pow(2, p))) {
					j2 = p;
				}
			}
			t(i, j, j2);
		}
		
		if(visited == visited2) {
			path.removeAll(path);
			path.add(0);
			visited = (int)Math.pow(2, 0);
		}
		return tmpcost;
	}

	public static void t(int i, int j, int j2) {
		tmpcost = tmpcost + vector[j][j2] + vector[j2][0];
		path.add(j2);
		visited = (int) (visited + Math.pow(2, j2));
		path.add(0);
	}
	
	public static String getBit(int n) {
		
		String zero = "0000";
		String bit = zero + Integer.toBinaryString(n);
		return bit.substring(bit.length() - 4);
	}

	public static void main(String[] args) {
		path.add(0);
		visited = (int)Math.pow(2, 0);

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
