package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TSPVisitedToBit {
	private static int visited = 0;
	private static int visited2 = 15; // visited배열과 비교하기 위해 사용
	private static ArrayList<Integer> path = new ArrayList<Integer>();
	private static ArrayList<Integer> cost = new ArrayList<Integer>();
	private static HashMap<String, Integer> pathcost = new HashMap<String, Integer>();
	private static int vector[][] = { { 0, 2, 9, 999 }, { 1, 0, 6, 4 }, { 999, 7, 0, 8 }, { 6, 3, 999, 0 } };
	private static int tmpcost = 0; // 현재 cost값 저장

	public static void t(int i, int j) {
		tmpcost = tmpcost + vector[i][j];
		path.add(j);
		visited = (int) (visited + Math.pow(2, j));
		
		if(visited == visited2) {
			path.add(0);
			tmpcost = tmpcost + vector[j][0];
			pathcost.put(path.toString(), tmpcost);
			path.removeAll(path);
			path.add(0);
			visited = (int)Math.pow(2, 0);
			return;
		}
		else if(!(getBit(~visited) == getBit(0))) {
			int k = 6 - (i+j); // visited인덱스합 - 거쳐간 visited인덱스합
			t(j,k);
		}
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
				tmpcost = tmpcost + vector[0][i];
				path.add(i);
				visited = (int) (visited + Math.pow(2, i));
				t(i, j);
				cost.add(tmpcost);
				tmpcost = 0;
			}
		}
		Collections.sort(cost);
		System.out.println(cost.get(0));
		ArrayList<String> keyset = new ArrayList<>(pathcost.keySet());
		Collections.sort(keyset, (o1,o2) -> (pathcost.get(o1).compareTo(pathcost.get(o2))));
		
		for(String key : keyset) {
			System.out.println("key : " + key + " / " + "value : " + pathcost.get(key));
		}
		System.out.println();
	}
}
