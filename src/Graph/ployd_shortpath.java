package Graph;

class Ployd_shortpath {


	   int[][] graph = { { 0, 1, 999, 1, 5 }, { 9, 0, 3, 2, 999 }, { 999, 999, 0, 4, 999 }, { 999, 999, 2, 0, 3 },
	         { 3, 999, 999, 999, 0 } };

	   public Ployd_shortpath() {
	      for (int i = 0; i < graph.length; i++) {
	         for (int j = 0; j < graph.length; j++) {
	            for (int k = 0; k < graph.length; k++) {
	               if (graph[j][k] > graph[j][i] + graph[i][k]) {
	                  graph[j][k] = graph[j][i] + graph[i][k];
	               }
	            }
	         }
	      }
	   }
	   
	   public void printshortpath() {
	      for(int i=0; i<graph.length; i++) {
	         for(int j=0; j<graph.length;j++) {
	            System.out.print(graph[i][j]);
	         }
	         System.out.println();
	      }
	   }

	}
