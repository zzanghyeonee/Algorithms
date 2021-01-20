package NQueen;

import java.util.Scanner;

public class NQueen2 {
	private static int[] Q;
	private static boolean check;
	private static int n;
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Q = new int[n+1];

		queens(0);
		System.out.println(count);
	}

	private static void queens(int i) {
		int m;
		if(promising(i)) {
			if(i==n) {
				++count; //체스판 끝까지 도달하면 count;
			}
			else {
				for (m = 1; m <= n; m++) {
					Q[i+1] = m;
					queens(i+1);
				}
			}
		}
	}

	private static boolean promising(int i) {
		int k = 1;
		check = true;

		while(k<i && check == true) {
			if(Q[i] == Q[k] || Math.abs(Q[i] - Q[k]) == Math.abs(i-k)) {
				check = false;
			}
			k++;
		}
		return check;
	}
}
