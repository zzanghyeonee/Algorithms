package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	private static int[] array = new int[5];
	public static void main(String[] args) {
		int j = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("수 입력 >>");
			array[i] = sc.nextInt();
		} 
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(binarysearch(0, array.length-1));
	}

	private static int binarysearch(int low, int high) {
		int mid;
		int x = 29;
	
		if(low > high) {
			return 0;
		}
		else {
			mid = (low+high)/2;
			if(x == array[mid]) {
				return mid;
			} else if(x < array[mid]){
				return binarysearch(low, mid-1);
			} else {
				return binarysearch(mid+1, high);
			}
		}
	}
}
