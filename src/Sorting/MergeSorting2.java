package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSorting2 {
	public static void MergeSort(int[] S, int m, int n) {
		int middle;
		if(m < n) {
			middle = (m+n)/2;
			MergeSort(S, m, middle);
			MergeSort(S, middle+1, n);
			Merge(S, m, middle, n);
		}
	}

	private static void Merge(int[] S, int m, int middle, int n) {
		int[] Q = new int[S.length];
		int i = m;
		int j = middle + 1;
		int k = m;
		while(i <= middle && j <= n) {
			if(S[i] < S[j]) {
				Q[k] = S[i];
				i++;
			}else {
				Q[k] = S[j];
				j++;
			}
			k++;
		}
		
		if(i <= middle) {
			for (int k2 = m; k2 <= middle; k2++, k++) {
				Q[k] = S[k2];
			}
		}else {
			for (int k2 = j; k2 < n; k2++,k++) {
				Q[k] = S[k2];
			}
		}
		
		for (int k2 = i; k2 <= n ; k2++) {
			S[k2] = Q[k2];
		}
		
		System.out.println(Arrays.toString(S));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[6];
		for (int i = 0; i < array.length; i++) {
			System.out.println("¼ö ÀÔ·Â >>");
			array[i] = sc.nextInt();	
		}
		MergeSort(array, 0, array.length-1);
	}

}
