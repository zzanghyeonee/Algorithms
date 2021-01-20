package NQueen;
import java.util.Scanner;

public class NQueen {
	private static int[] Q;
	private static boolean check;
	private static int n;
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			Q = new int[16];
			Q[0] = i;
			
			queens(1);
		}
		System.out.println(count);
	}

	private static void queens(int i) {
		if(i > n) {
			++count;
		} else {
			for (int j = 1; j <= n; j++) {
				Q[i] = j;
				if(promising(i)) {
					if(i==n) {
						queens(i+1);
					}
					else {
						Q[i] = 0;
					}
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
