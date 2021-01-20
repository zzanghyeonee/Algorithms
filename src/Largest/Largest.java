package Largest;

public class Largest {
	public static int largest(int[] list) {
		int index, max = Integer.MAX_VALUE;
		max = list[0];
		for (index = 0; index < list.length; index++) {
			if(list[index]>max) {
				max = list[index];
			}
		}
		return max;
	}
}
