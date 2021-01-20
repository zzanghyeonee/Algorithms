package MST;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	private static int INF = 999;
	private static int[][] vector = {{0,INF,6,3,INF},{3,0,INF,INF,INF},{INF,INF,0,2,INF},{INF,1,1,0,INF},{INF,4,INF,2,0}};
	private static int result = 0;
	private static int[] touch = new int[5];
	private static int[] length = new int[5];
	private static int[] visited = new int[5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 : " );
		int start = sc.nextInt();
		System.out.print("끝 : ");
		int end = sc.nextInt();
		for (int i = 0; i < touch.length; i++) {
			touch[i] = start;
			length[i] = vector[start][i];
		}
		dijkstra(start, end);
	}

	public static void dijkstra(int start, int end) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int pos = 0;
		visited[start] = -1;
			for (int i = 0; i < vector[start].length; i++) {
				if(vector[start][i] == INF) continue;
				if(vector[start][i] == 0) continue;
				pq.add(vector[start][i]);
			}
				int vector = pq.poll();
				for (int j = 0; j < Dijkstra.vector[start].length; j++) {
					if(vector == Dijkstra.vector[start][j]) {
						if(visited[j] == -1) continue;
						pos = j;
						result = result + vector;
						break;
					}
				}
				if(visited[end] == -1) {
					System.out.println(result);
				} else {
					dijkstra(pos, end);
				}
		}
}

