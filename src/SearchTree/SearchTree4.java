package SearchTree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SearchTree4 {
	private static String items[] = {"a", "b", "c", "d"};
	private static int values[] = {6, 7, 8, 9};
	private static int calories[] = {3, 3, 2, 5};
	private static String item;
	private static int value;
	private static int calorie;
	private static int totalCalorie = 5;
	//private static int val = 0;
	private static ArrayList<SearchTree4> st = new ArrayList<SearchTree4>();
	private static ArrayList<SearchTree4> taken = new ArrayList<SearchTree4>();
	private static int[] sumVal = new int[16];
	public SearchTree4(String item, int value, int calorie) {
		this.item = item;
		this.value = value;
		this.calorie = calorie;
	}
	
	public String getItem() {
		return item;
	}
	public int getValue() {
		return value;
	}
	public int getCalorie() {
		return calorie;
	}
	
	@Override
	public String toString() {
		return "item=" + item + ", value=" + value + ", calorie=" + calorie + "\n";
	}
	public static void main(String[] args) {
		int[] s = {1, 2, 3, 4};
		List list = (List) Arrays.asList(s);
		Collections.reverse((java.util.List<?>) list);
		System.out.println(list);
	}

	private static void getResult(ArrayList<SearchTree4> taken) {
	}
	
}
