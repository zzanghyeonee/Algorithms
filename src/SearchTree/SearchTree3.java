package SearchTree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SearchTree3 {
	private static String items[] = { "a", "b", "c", "d" };
	private static int values[] = { 6, 7, 8, 9 };
	private static int calories[] = { 3, 3, 2, 5 };
	private String item;
	private int value;
	private int calorie;
	private static ArrayList<SearchTree3> st = new ArrayList<SearchTree3>();
	private static ArrayList<SearchTree3> taken = new ArrayList<SearchTree3>();
	private static ArrayList<Integer> vals = new ArrayList<Integer>();
	private static ArrayList<SearchTree3> tmp1 = new ArrayList<SearchTree3>();
	private static ArrayList<SearchTree3> tmp3 = new ArrayList<SearchTree3>();

	public SearchTree3(String item, int value, int calorie) {
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
			SearchTree3 name = new SearchTree3(items[i], values[i], calories[i]);
			st.add(name);
		}

		for (int i = 0; i < st.size(); i++) {
			taken.add(st.get(i));
			getResult(taken);
			taken.clear();
		}
		for (int i = 0; i < st.size(); i++) {
			for (int j = 1; j < st.size(); j++) {
				if (i < j) {
					taken.add(st.get(i));
					taken.add(st.get(j));
					getResult(taken);
					taken.clear();
				}
			}
		}
		for (int i = 0; i < st.size(); i++) {
			for (int j = 1; j < st.size(); j++) {
				for (int j2 = 2; j2 < st.size(); j2++) {
					if (i < j && j < j2) {
						taken.add(st.get(i));
						taken.add(st.get(j));
						taken.add(st.get(j2));
						getResult(taken);
						taken.clear();
					}
				}
			}
		}
		taken = st;
		getResult(taken);
		taken.clear();

		System.out.println("====================================");
		Collections.sort(vals, Collections.reverseOrder());
		System.out.println("가장 최적화된 가치 : " + vals.get(0));
	}

	private static void getResult(ArrayList<SearchTree3> taken) {
		int totalCalorie = 5;
		for (int i = 0; i < st.size(); i++) {
			tmp1.add(st.get(i));
		}
		int[] tmp = new int[16];
		int sumVal = 0;
		for (int i = 0; i < taken.size(); i++) {
			totalCalorie = totalCalorie - taken.get(i).getCalorie();
			if (totalCalorie >= 0) {
				tmp3.add(taken.get(i));
				tmp1.removeAll(taken);
				sumVal = sumVal + taken.get(i).getValue();
				tmp[i + 1] = sumVal;
			} else {
				totalCalorie = totalCalorie + taken.get(i).getCalorie();
				tmp1.removeAll(taken);
				tmp[i + 1] = tmp[i];
			}
		}
		Integer[] val = new Integer[tmp.length];
		for (int i = 0; i < val.length; i++) {
			val[i] = Integer.valueOf(tmp[i]);
		}
		Arrays.sort(val, Collections.reverseOrder());
		vals.add(val[0]);
		System.out.println("=============================================");
		System.out.println("사용한 item : " + tmp3.toString());
		System.out.println("남은 item : " + tmp1.toString());
		System.out.println("현재 value : " + val[0] + "\n남은 칼로리 양 : " + totalCalorie);
		tmp1.clear();
		tmp3.clear();
	}
}
