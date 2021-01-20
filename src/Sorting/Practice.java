package Sorting;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			System.out.println("¼ö ÀÔ·Â >>");
			array[i] = sc.nextInt();	
		}
		InsertionSort(5, array);
	}

	private static void InsertionSort(int i, int[] array) {
		for (int j = 1; j < array.length; j++) {
			int a = array[j];
			int b = j-1;
			
			while(b >= 0 && array[b] > a) {
				array[j+1] = a;
				j--;
			}
			array[b+1] = a;
		}
	}
	}


