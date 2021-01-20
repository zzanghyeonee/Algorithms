package Fibonacci;

import java.util.Scanner;

public class Fibonacci {
	public static int f(int n) {
		if (n <= 0) {
			return 0;
		}
		if(n <= 1) {
			return 1;
		}
		else {
			return f(n-1) + f(n-2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¼ö ÀÔ·Â >>");
		int num = sc.nextInt();
		System.out.println(f(num));
	}
}
