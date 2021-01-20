package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSorting {
	public static int array[] = new int[5];

	public static void quicksort(int low, int high, int[] s) {
		int pp = (low + high) / 2;
		if (low < high) {
			partition(low, high, s);
			quicksort(low, pp - 1, s);
			quicksort(pp + 1, high, s);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("수 입력 >>");
			array[i] = sc.nextInt();
		}
		quicksort(0, array.length - 1, array);
	}

	public static void partition(int low, int high, int[] s) {
		int pivot = s[(low + high) / 2];
		while(low <=high) {
			while(s[low] < pivot) low++;
			while(s[high] > pivot) high--;

			if(low <= high) {
				swap(s, low, high);
				low++;
				high--;
			}
		}
		System.out.println(Arrays.toString(s));
	}

	private static void swap(int[] s, int low, int high) {
		int tmp = s[low];
		s[low] = s[high];
		s[high] = tmp;
	}
}
