package CowTransport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BruteForce {
	private static HashMap<String, Integer> result;
	private static ArrayList<BruteForce> cows;
	private String name;
	private int weight;
	private static String[] names = {"Maggie", "Herman", "Besty", "oreo", "Moo Moo", "Milkshake", "Millie", "Lola", "Florence", "Henrietta"};
	private static int[] weights = {3, 7, 9, 6, 3, 2, 5, 2, 2, 9};
	private static int maxWeight = 10;
	private static int count = 0;

	public BruteForce(String name, int weight) {
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
			BruteForce cow = new BruteForce(names[i], weights[i]);
			cows.add(cow);
		}
		bruteforceCowTransport(cows, maxWeight);
		System.out.println(count);
		
	}

	private static void bruteforceCowTransport(ArrayList<BruteForce> cows, int maxWeight) {
		Collections.shuffle(cows);
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
					cows.set(j, new BruteForce(cows.get(j).getName(), 999));
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

