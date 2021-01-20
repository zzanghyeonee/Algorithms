package Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수 입력 >>");
		int num = sc.nextInt();
		fibo(num);
	}

	private static void fibo(int num) {
		int[] s = new int[num];
		s[0] = 0;
		s[1] = 1;
		for (int i = 2; i < s.length; i++) {
			s[i] = s[i-1] + s[i-2];
		}
		System.out.println(Arrays.toString(s));
		System.out.println(num + "번째 값은" + s[s.length-1]);
	}

}

