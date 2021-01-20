package Sorting;

import java.lang.reflect.Array;
import java.util.Scanner;

public class InsertionSorting {
	
	public static void InsertionSort(int n, int[] S) {
		for (int i = 1; i < S.length; i++) {
			int a = S[i];
			int j = i-1;
			
			while(j>=0 && S[j] > a) {
				S[j+1] = S[j];
				j--;
			}
			S[j+1] = a;
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
		InsertionSort(5, array);
	}

}
