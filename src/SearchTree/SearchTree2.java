package SearchTree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SearchTree2 {
	private static String items[] = {"a", "b", "c", "d"};
	private static int values[] = {6, 7, 8, 9};
	private static int calories[] = {3, 3, 2, 5};
	private static String taken[] = new String[items.length];
	private String item;
	private int value, calorie;
	private static int totalCalories = 5;
	private static int val = 0;
	private static ArrayList<SearchTree2> list = new ArrayList<SearchTree2>();
	public SearchTree2(String item, int value, int calorie) {
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
		String[] s = {"a", "b"};
		String[] s2 = {"c", "d"};
		ArrayList<String> name = new ArrayList<String>(Arrays.asList(s));
		name.addAll(Arrays.asList(s2));
		name.remove(3);
		System.out.println(name.toString());
	
	}
}
