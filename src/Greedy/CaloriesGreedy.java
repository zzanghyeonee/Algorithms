package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CaloriesGreedy {
	private static double maxUnits = 750.0;
	private String food;
	private double value;
	private double calorie;
	private double density;
	private static String[] foods = { "wine", "beer", "pizza", "burger", "fires", "coke", "apple", "donut" };
	private static double[] values = { 89.0, 90.0, 95.0, 100.0, 90.0, 79.0, 50.0, 10.0 };
	private static double[] calories = { 123.0, 154.0, 258.0, 354.0, 365.0, 150.0, 95.0, 195.0 };
	private static double[] density2 = new double[foods.length];
	private static ArrayList<CaloriesGreedy> list = new ArrayList<CaloriesGreedy>();

	public CaloriesGreedy(final String food, final double value, final double calorie, final double density) {
		this.food = food;
		this.value = value;
		this.calorie = calorie;
		this.density = density;
	}

	public final double getValue() {
		return value;
	}

	public final String getName() {
		return food;
	}

	public final double getcalorie() {
		return calorie;
	}

	public final double getDensity() {
		return density * 10000;
	}

	public static void main(final String[] args) {
		for (int i = 0; i < foods.length; i++) {
			density2[i] = values[i] / calories[i];
			CaloriesGreedy f = new CaloriesGreedy(foods[i], values[i], calories[i], density2[i]);
			list.add(f);
		}
		System.out.println("Use Greedy by value to allocate\n" + maxUnits + " " + "calories");
		testGreedy(values);
		System.out.println("Use Greedy by calories to allocate\n" + maxUnits + " " + "calories");
		testGreedy(calories);
		System.out.println("Use Greedy by density to allocate\n" + maxUnits + " " + "calories");
		testGreedy(density2);
	}

	private static void testGreedy(final double[] key) {
		if (key == values) {
			Comparator<CaloriesGreedy> v = new Comparator<CaloriesGreedy>() {

				@Override
				public int compare(final CaloriesGreedy o1, final CaloriesGreedy o2) {
					return (int) (o2.getValue() - o1.getValue());
				}
			};
			Collections.sort(list, v);
			getResult();
		}
		if (key == calories) {
			Comparator<CaloriesGreedy> c = new Comparator<CaloriesGreedy>() {

				@Override
				public int compare(final CaloriesGreedy o1, final CaloriesGreedy o2) {
					return (int) (o1.getcalorie() - o2.getcalorie());
				}
			};
			Collections.sort(list, c);
			getResult();
		}
		if (key == density2) {
			Comparator<CaloriesGreedy> d = new Comparator<CaloriesGreedy>() {

				@Override
				public int compare(final CaloriesGreedy o1,  CaloriesGreedy o2) {
					return (int) (o2.getDensity() - o1.getDensity());
				}
			};
			Collections.sort(list, d);
			getResult();
		}
	}
	private static void getResult() {
		double tmp = maxUnits;
		double val = 0;
		for (int i = 0; i < list.size(); i++) {
			if (tmp > list.get(i).getcalorie()) {
				tmp = tmp - list.get(i).getcalorie();
				val = val + list.get(i).getValue();
				System.out.println(list.get(i).getName() + "  :  " + "<" + list.get(i).getValue() + " , "
						+ list.get(i).getcalorie() + ">");
			}
		}		
		System.out.println("Total value of items taken = " + val);
	}
}
