package MST;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
	private static int INF = 999;
	private static int[][] vector = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 },
			{ INF, 6, 4, 0, 5 }, { INF, INF, 2, 5, 0 } };
	private static int[] disjoint = new int[5];
	private static int[][] sortVector = new int[14][3];
	
	public static void main(String[] args) {
		int k = 0;
		for (int i = 0; i < disjoint.length; i++) {
			disjoint[i] = i;
		}
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length; j++) {
				if(vector[i][j] == 0) continue;
				if(vector[i][j] == INF) continue;
					sortVector[k][0] = i;
					sortVector[k][1] = j;
					sortVector[k][2] = vector[i][j];
					k++;
				}
		}
		
		for (int i = 0; i < sortVector.length; i++) { //중복되는 값을 제거하기 위함.
			int tmp = sortVector[i][2];
			for (int j = i+1; j < sortVector.length; j++) {
				if(tmp == sortVector[j][2]) {
					sortVector[j][2] = INF; // 무한히 큰 값을 주어 정렬했을 때 비교할 필요 없게 만듦.
				}
			}
		}
		
		Arrays.sort(sortVector, new Comparator<int[]>()
		{
		    @Override
		    public int compare(int[] int1, int[] int2)
		    {
		        Integer numOfKeys1 = int1[2];
		        Integer numOfKeys2 = int2[2];
		        return numOfKeys1.compareTo(numOfKeys2);
		    }
		});
		
		kruskal(sortVector, disjoint);
}

	private static void kruskal(int[][] sortVector, int[] disjoint) {
		for (int i = 0; i < sortVector.length; i++) {
			if(disjoint[sortVector[i][0]] == disjoint[sortVector[i][1]]) continue;
			disjoint[sortVector[i][1]] = disjoint[0]; // 서로소 확인
			System.out.println(sortVector[i][0] + " - " + sortVector[i][1]);
		}
	}
}
