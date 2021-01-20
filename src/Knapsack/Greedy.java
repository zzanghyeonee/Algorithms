package Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy {
	private static int profit[] = { 50, 60, 140 };
	private static int weight[] = { 5, 10, 20 };
	private static int maxprofit[] = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가방의 무게 >>");
		int bag = sc.nextInt();

		topWeight(bag);
		topProfit(bag);
		topDensity(bag);
		
		Arrays.sort(maxprofit);
		for (int i = 0; i < maxprofit.length; i++) {
			System.out.print(maxprofit[i] + " ");
		}
		System.out.println("가장 가치가 높은 것은" + maxprofit[2]);
	}

	private static void topWeight(int bag) {
		int p = 0;
		int tmp = bag;
		for (int i = 0; i < weight.length; i++) {
			if (tmp >= weight[i]) {
				tmp = tmp - weight[i];
				p = p + profit[i];
			}
		}
		maxprofit[0] = p;
	}

	private static void topProfit(int bag) {
		int p = 0;
		int tmp = bag;
		for (int i = 2; i >= 0; i--) {
			if (tmp >= weight[i]) {
				tmp = tmp - weight[i];
				p = p + profit[i];
			}
		}
		maxprofit[1] = p;
	}

	private static void topDensity(int bag) {
		int p = 0;
		int tmp = bag;
		int[][] density = new int[3][2];
		for (int i = 0; i < density.length; i++) {
			density[i][0] = profit[i] / weight[i];
			density[i][1] = weight[i];
		}
		for (int i = 1; i < density.length; i++) {
			int tmp2 = density[0][0];
			int tmp3 = density[0][1];
			if (tmp2 > density[i][0]) {
				tmp2 = density[0][0];
				density[0][0] = density[i][0];
				density[i][0] = tmp2;

				tmp3 = density[0][1];
				density[0][1] = density[i][1];
				density[i][1] = tmp3;
			}
		}
		for (int i = 2; i >= 0; i--) {
			if (tmp >= density[i][1]) {
				tmp = tmp - density[i][1];
				p = p + density[i][0]*density[i][1];
			}
		}
		maxprofit[2] = p;

	}
}