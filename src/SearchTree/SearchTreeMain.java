package SearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchTreeMain {
	private static String items[] = { "a", "b", "c", "d" };
	private static int values[] = { 6, 7, 8, 9 };
	private static int calories[] = { 3, 3, 2, 5 };
	private static int remaincalories = 5;
	private String item;
	private int value, calorie;
	private static int maxvalue = 0;
	private static ArrayList<SearchTreeMain> taken;
	private static ArrayList<SearchTreeMain> left = new ArrayList<SearchTreeMain>();
	private static ArrayList<SearchTreeMain> left2 = new ArrayList<SearchTreeMain>();
	private static HashMap<String, Integer> memo = new HashMap<String, Integer>();

	public SearchTreeMain(String item, int value, int calorie) {
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
		return "SearchTreeMain [item=" + item + ", value=" + value + ", calorie=" + calorie + "]";
	}

	public static void main(String[] args) {
		taken = new ArrayList<SearchTreeMain>();
		for (int i = 0; i < items.length; i++) {
			SearchTreeMain st = new SearchTreeMain(items[i], values[i], calories[i]);
			left.add(st);
		}
		left2 = left;
		searchDP(taken, left2, maxvalue, remaincalories, memo);//left(foodlist), 5, memo;
		initial();
		searchDP(taken, left2, maxvalue, remaincalories, memo);
		initial();
		searchDP(taken, left2, maxvalue, remaincalories, memo);
		initial();
		searchDP(taken, left2, maxvalue, remaincalories, memo);
		for (String key : memo.keySet()) {
			int value = memo.get(key);
			System.out.println(key + " = " + value);
		}
	}

	private static void initial() {
		taken.clear();
		maxvalue = 0;
		remaincalories = 5;
		left2.remove(0);
	}

	private static void searchDP(List<SearchTreeMain> taken, List<SearchTreeMain> subLeft2, int maxvalue, int remaincalories, HashMap<String, Integer> memo) {
		int tmpvalue = maxvalue;
		int tmpcalories = remaincalories;
		taken.add(subLeft2.get(0));
		List<SearchTreeMain> subLeft = subLeft2.subList(1, subLeft2.size());
			if(ispossible(taken, remaincalories)) {
					tmpcalories = tmpcalories - taken.get(taken.size()-1).getCalorie();
					tmpvalue = tmpvalue + taken.get(taken.size()-1).getValue();
				String key = taken.toString();
				if(!memo.containsKey(key)) {
					memo.put(key, tmpvalue);
				} else {
				}
				if(!subLeft.isEmpty()) {
					searchDP(taken, subLeft, tmpvalue, tmpcalories, memo);
				}
			} else {
				taken.remove(taken.size()-1);
				if(!subLeft.isEmpty()) {
					searchDP(taken, subLeft, tmpvalue, tmpcalories, memo);
				}
			}
	}

	private static boolean ispossible(List<SearchTreeMain> taken, int remaincalories) {
		if(taken.get(taken.size()-1).getCalorie() > remaincalories) return false;
		else {
			return true;
		}
	}
}
