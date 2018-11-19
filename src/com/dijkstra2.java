package com;

public class dijkstra2 {
	static int V=9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //                            0, 1, 2, 3, 4, 5, 6, 7, 8
        int graph[][] = new int[][]{ {0, 4, 0, 0, 0, 0, 0, 8, 0},   //0
                                     {4, 0, 8, 0, 0, 0, 0, 11,0},   //1
                                     {0, 8, 0, 7, 0, 4, 0, 0, 2},   //2
                                     {0, 0, 7, 0, 9, 14,0, 0, 0},   //3
                                     {0, 0, 0, 9, 0, 10,0, 0, 0},   //4
                                     {0, 0, 4, 14,10,0, 2, 0, 0},   //5
                                     {0, 0, 0, 0, 0, 2, 0, 1, 6},   //6
                                     {8, 11,0, 0, 0, 0, 1, 0, 7},   //7
                                     {0, 0, 2, 0, 0, 0, 6, 7, 0}};  //8
        dijkstra(graph, 2);
	}
	public static void print(int[] dist) {
		for(int i=0;i<V;i++) {
			System.out.println(i+"-->"+dist[i]);
		}
	}
	public static void dijkstra(int[][] graph, int src) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];
		for(int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for(int i=0;i<V;i++) {
			int u = minimunDistance(dist, sptSet);
			sptSet[u] = true;
			for(int v=0;v<V;v++) {
				if(!sptSet[v] && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0 && dist[u]+graph[u][v]<dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		print(dist);
	}
	public static int minimunDistance(int[] dist, boolean[] sptSet) {
		int min=Integer.MAX_VALUE, min_index=-1;
		for(int i=0;i<V;i++) {
			if(min>=dist[i] && !sptSet[i]) {
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}
}
