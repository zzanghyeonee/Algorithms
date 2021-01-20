package TSP;

import java.util.ArrayList;
import java.util.Collections;

public class TSPDP {
	private static ArrayList<Integer> path = new ArrayList<Integer>();
	private static int vector[][] = { { 0, 2, 9, 999 }, { 1, 0, 6, 4 }, { 999, 7, 0, 8 }, { 6, 3, 999, 0 } };
	private static ArrayList<Integer> cost = new ArrayList<>();
	private static int[][] D = new int[10][10];
	private static int result = 0;

	private static int tsp(int i, int j) {
	 if(count(j) == 0) {
		 return D[i][1];
	 }
	 
	 else if(count(j) == 1) {
		 return D[i][j] + tsp(j,0);
	 }
	 
	 else if(count(j) == 2) {
		 for (int j2 = 1; j2 < 4; j2++) {
			for (int k = 1; k < 4; k++) {
				int p =(int)(Math.pow(2, j2) + Math.pow(2, k));
				if(p==j) {
					result = D[1][i] +  D[i][(int)Math.pow(2, j2)] + tsp((int)Math.pow(2, j2), (int)Math.pow(2, k));
					path.add(result);
				}
			}
		} 
		 Collections.sort(path);
		 result = path.get(0);
		 path.removeAll(path);
	 }
	 return result;
	}

	public static int count(int n) { // 2진수에서 1의 개수 구하기
		String str = getBit(n);
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				cnt++;
			}
		}
		return cnt;
	}

	public static String getBit(int n) {
		String zero = "0000";
		String bit = zero + Integer.toBinaryString(n);
		return bit.substring(bit.length() - 4);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				D[(int)Math.pow(2, i)][(int)Math.pow(2, j)] = vector[i][j];
			}
		
	}
		
		tsp(2,12); // 0->1
		cost.add(result);
		result = 0;
		tsp(4,10); // 0->2
		cost.add(result);
		result = 0;
		tsp(8,6); // 0->3
		cost.add(result);
		result = 0;
		Collections.sort(cost);
		System.out.println(cost.get(0));
	}
}

