package CowTransport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Greedy {
	private static HashMap<String, Integer> result;
	private static ArrayList<Greedy> cows;
	private String name;
	private int weight;
	private static String[] names = {"Maggie", "Herman", "Besty", "oreo", "Moo Moo", "Milkshake", "Millie", "Lola", "Florence", "Henrietta"};
	private static int[] weights = {3, 7, 9, 6, 3, 2, 5, 2, 2, 9};
	private static int maxWeight = 10;
	private static int count = 0;

	public Greedy(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Greedy [name=" + name + ", weight=" + weight + "]";
	}

	public static void main(String[] args) {
		cows = new ArrayList<>();
		result = new HashMap<>();
		for (int i = 0; i < names.length; i++) {
			Greedy cow = new Greedy(names[i], weights[i]);
			cows.add(cow);
		}
		greedycowTransport(cows, maxWeight);
		System.out.println(count); //총 경우의수
		
	}

	private static void greedycowTransport(ArrayList<Greedy> cows, int maxWeight) {
		Comparator<Greedy> c = new Comparator<Greedy>() {
			@Override
			public int compare(Greedy o1, Greedy o2) { //무게순으로 내림차순, 무게가 같다면 이름순 정렬
				if(o1.getWeight() < o2.getWeight()) {
					return 1;
				} else if(o1.getWeight() > o2.getWeight()) {
					return -1;
				} else {
					return o1.getName().compareToIgnoreCase(o2.getName());
				}
			}
		};
		Collections.sort(cows, c);
		
		for (int i = 0; i < cows.size(); i++) {
			int tmpWeight = maxWeight;
			if(tmpWeight > cows.get(i).getWeight()) {
				result.put(cows.get(i).getName(), cows.get(i).getWeight());
				tmpWeight = tmpWeight - cows.get(i).getWeight();
			}
			for (int j = i+1; j < cows.size(); j++) {
				if(cows.get(j).getWeight() <= tmpWeight) {
					result.put(cows.get(j).getName(), cows.get(j).getWeight());
					tmpWeight = tmpWeight - cows.get(j).getWeight();
					cows.set(j, new Greedy(cows.get(j).getName(), 999));
				}
			}
			if(!result.isEmpty()) {
				System.out.println(result.toString());
				result.clear();
				count++;
			}
		}
	}
}

