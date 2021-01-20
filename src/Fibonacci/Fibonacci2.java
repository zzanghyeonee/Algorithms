package Fibonacci;

import java.util.Scanner;

public class Fibonacci2 {
	public static void main(String[] args) {
		int f1 = 0;
		int f2 = 1;
		int f = 0;
		
		for (int i = 0; i < 6; i++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		System.out.println(f);
	}
}
