package SearchTree;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchTree {
	private static String items[] = { "a", "b", "c", "d" };
	private static int values[] = { 6, 7, 8, 9 };
	private static int calories[] = { 3, 3, 2, 5 };
	private String item;
	private int value, calorie;
	private static int totalCalories = 5;
	private static int val = 0;
	private static int j = 0;
	private static ArrayList<SearchTree> list = new ArrayList<SearchTree>();

	public SearchTree(String item, int value, int calorie) {
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
		for (int i = 0; i < items.length; i++) {
			SearchTree st = new SearchTree(items[i], values[i], calories[i]);
			list.add(st);
		}
		System.out.println("현재 가치  = " + val + ", 남은 칼로리 양 = " + totalCalories);
		System.out.println("=============================================");
		System.out.println();
		getResult(list);
	}
	public static void getResult(ArrayList<SearchTree> list) {
		ArrayList<SearchTree> taken = new ArrayList<SearchTree>();
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		ArrayList<SearchTree> s = new ArrayList<SearchTree>();
		s = list;
		while (true) {
			for (int i = 0; i < s.size(); i++) {
				taken.add(s.get(i));
				if (totalCalories > 0 && taken.get(i).getItem().equals(list.get(i).getItem())) {
					s.remove(i);
					h.put(taken.get(i).getItem(), taken.get(i).getValue());
					val = val + taken.get(i).getValue();
					totalCalories = totalCalories - taken.get(i).getCalorie();
					System.out.println(s.toString());
					System.out.println();
					System.out.println((j+1) + "번째 계산에서 선택한 item과 가치 = " + h + " , 현재 가치와 남은 칼로리 = " + val + " , " + totalCalories);
					j++;
				} else if (taken.get(i).getCalorie() > totalCalories) {
					continue;
				}
				System.out.println(list.toString());
				System.out.println((j+1) + "번째 계산에서 선택한 item과 가치 = " + h + " , 현재 가치와 남은 칼로리 = " + val + " , " + totalCalories);
				j++;
				if (totalCalories == 0)
					break;
			}
		}
	}
}
