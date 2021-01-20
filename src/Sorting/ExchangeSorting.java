package Sorting;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ExchangeSorting {
	
	public static void exchangeSort(int n, int[] S) {
		for (int i = 0; i < S.length; i++) {
			int tmp = S[i];
			for (int j = i+1; j < S.length; j++) {
				if(tmp > S[j]) {
					tmp = S[i];
					S[i] = S[j];
					S[j] = tmp;
				}
			}
		}
		for (int k = 0; k < S.length; k++) {
			System.out.print(S[k] + "  ");			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			System.out.println("¼ö ÀÔ·Â >>");
			array[i] = sc.nextInt();	
		}
		exchangeSort(5, array);
	}

}
