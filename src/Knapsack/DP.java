package Knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class DP {
	private static int profit[] = { 50, 60, 140 };
	private static int weight[] = { 5, 10, 20 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가방의 무게 >>");
		int bag = sc.nextInt();

		profitDP(bag);
	}

	private static void profitDP(int bag) {
		int[] profitTotal = new int[bag];
		int tmp = 0;
		for (int i = 0; i < profitTotal.length; i++) {
			tmp = i+1;
			int p = 0;
			for (int j = 2; j >= 0; j--) {
				if (tmp >= weight[j]) {
					tmp = tmp - weight[j];
					p = p + profit[j];
				}
				profitTotal[i] = p;
			}
		}
		for (int i = 0; i < profitTotal.length; i++) {
			System.out.print(profitTotal[i] + " ");
		}
		System.out.println();
		System.out.println("가방에 담을 수 있는 물건의 최대 가치는" + profitTotal[bag-1]);
	}
}
