package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class CaloriesGreedy2 {
	private static int maxUnits = 750;
	private static String[] foods = { "wine", "beer", "pizza", "burger", "fires", "coke", "apple", "donut" };
	private static int[] values = { 89, 90, 95, 100, 90, 79, 50, 10 };
	private static int[] calories = { 123, 154, 258, 354, 365, 150, 95, 195 };
	private static int[] density = new int[foods.length];

	public static void main(String[] args) {
		System.out.println("Use Greedy by value to allocate\n" + maxUnits + " " + "calories");
		testGreedy(foods, maxUnits, values);
		System.out.println("Use Greedy by calories to allocate\n" + maxUnits + " " + "calories");
		testGreedy(foods, maxUnits, calories);
		System.out.println("Use Greedy by density to allocate\n" + maxUnits + " " + "calories");
		testGreedy(foods, maxUnits, density);
	}

	private static void testGreedy(String[] foods, int maxUnits, int[] key) {
		if (key == values) {
			int tmp = 0;
			int tmp2 = 0;
			String tmp3 = null;
			int v = 0;
			int tmp4 = maxUnits;
			int tmp5 = maxUnits;
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length-1; j++) {
					if(values[j] < values[j+1]) {
						tmp = values[j];
						values[j] = values[j+1];
						values[j+1] = tmp;
						
						tmp2 = calories[j];
						calories[j] = calories[j+1];
						calories[j+1] = tmp2;
						
						tmp3 = foods[j];
						foods[j] = foods[j+1];
						foods[j+1] = tmp3;
					}
				}
			}
			for (int i = 0, j = 8; i < j; i++) {
				if (tmp4 >= calories[i]) {
					tmp4 = tmp4 - calories[i];
					v = v + values[i];
				}
			}
			System.out.println("Total value of items taken = " + v);
			for (int i = 0, j = 8; i < j; i++) {
				if (tmp5 >= calories[i]) {
					tmp5 = tmp5 - calories[i];
					System.out.println(foods[i] + "<" + values[i] + " , " + calories[i] + ">");
				}
			}
		}
		if (key == calories) {
			int tmp = 0;
			int tmp2 = 0;
			String tmp3 = null;
			int v = 0;
			int tmp4 = maxUnits;
			int tmp5 = maxUnits;
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length-1; j++) {
					if(calories[j] > calories[j+1]) {
						tmp = calories[j];
						calories[j] = calories[j+1];
						calories[j+1] = tmp;
						
						tmp2 = values[j];
						values[j] = values[j+1];
						values[j+1] = tmp2;
						
						tmp3 = foods[j];
						foods[j] = foods[j+1];
						foods[j+1] = tmp3;
					}
				}
			}
			for (int i = 0; i < key.length; i++) {
				if (tmp4 >= calories[i]) {
					tmp4 = tmp4 - calories[i];
					v = v + values[i];
				}
			}
			System.out.println("Total value of items taken = " + v);
			for (int i = 0, j = 8; i < j; i++) {
				if (tmp5 >= calories[i]) {
					tmp5 = tmp5 - calories[i];
					System.out.println(foods[i] + "<" + values[i] + " , " + calories[i] + ">");
				}
			}
		}
		if (key == density) {
			int tmp = 0;
			int tmp2 = 0;
			int tmp3 = 0;
			String tmp4 = null;
			int tmp5 = maxUnits;
			int tmp6 = maxUnits;
			int v = 0;
			for (int i = 0; i < key.length; i++) {
				density[i] = values[i]*10000/calories[i];
			}
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length-1; j++) {
					if(density[j] < density[j+1]) {
						tmp = density[j];
						density[j] = density[j+1];
						density[j+1] = tmp;
						
						tmp2 = calories[j];
						calories[j] = calories[j+1];
						calories[j+1] = tmp2;
						
						tmp3 = values[j];
						values[j] = values[j+1];
						values[j+1] = tmp3;
						
						tmp4 = foods[j];
						foods[j] = foods[j+1];
						foods[j+1] = tmp4;
					}
				}
			}
			for (int i = 0; i < key.length; i++) {
				if (tmp5 >= calories[i]) {
					tmp5 = tmp5 - calories[i];
					v = v + values[i];
				}
			}
			System.out.println("Total value of items taken = " + v);
			for (int i = 0; i < key.length; i++) {
				if (tmp6 >= calories[i]) {
					tmp6 = tmp6 - calories[i];
					System.out.println(foods[i] + "<" + values[i] + " , " + calories[i] + ">");
				}
			}
		}
	}
}
