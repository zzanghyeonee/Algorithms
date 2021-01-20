package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSorting {
	
	public static void Merge(int[] S, int m, int middle, int n) {
		int U[] = new int[S.length];
		
		int i = m;
		int j = middle+1;
		int k = m;
		
		while(i <= middle && j<=n) {
			if(S[i] <= S[j]) {
				U[k] = S[i];
				i++;
			}else {
				U[k] = S[j];
				j++;
			}
			k++;
		}
		if(i > middle) {
			for (int l = j; l <= n; l++, k++) {
				U[k] = S[l];
			}
		}else {
			for (int l = i; l <= middle; l++,k++) {
				U[k] = S[l];
			}
		}
		
		for (int l = m; l <= n; l++) {
			S[l] = U[l];
		}
		System.out.println(Arrays.toString(S));
		}
	
	public static void MergeSort(int[] S, int m, int n) {
		int middle;
		
		if (m < n) {
			middle = (m+n)/2;
			MergeSort(S, 0, middle);
			MergeSort(S, middle+1, n);
			Merge(S, m , middle, n);
		}
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
