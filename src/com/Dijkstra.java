package com;


/**
 * Created by sunil on 11/1/17.
 */
public class Dijkstra {
    //total vertex
    static final int V=9;

    public void printGraph(int[] dist, int n){
        for(int i=0;i<n;i++){
            System.out.println(i+" => "+dist[i]);
        }
    }
    public int minDistance(int[] dist, boolean[] sptSet){
        int min=Integer.MAX_VALUE, min_index=-1;
        for(int i=0;i<V;i++){
            if(dist[i]<=min && !sptSet[i]){
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }
    public void dijkstra(int[][] graph, int src){
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V]; //shortest path tree set
        //initialize to default val
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            sptSet[i]=false;
        }
        //distance of source to itself is 0
        dist[src]=0;
        //find the shortest path for all vertices
        for(int count=0;count<V;count++){
            //pick min distance vertex from the set vertex not yet processed. u is src in 1st iter
            int u = minDistance(dist, sptSet);
            //marked pciked vertex as processed
            sptSet[u]=true;
            //update dist value of adjacent vertices
            for(int v=0;v<V;v++){
                //update dist[v] only if #it is not in sptSet, #edge exist between u-v,
                // #total wt of path smaller then curr val, dist[v]
                if(!sptSet[v] && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0  &&
                        dist[u]+graph[u][v]<dist[v])
                    dist[v]=dist[u]+graph[u][v];
            }
        }
        printGraph(dist,V);
    }
    public static void main(String[] args){
        //                            0, 1, 2, 3, 4, 5, 6, 7, 8
        int graph[][] = new int[][]{ {0, 4, 0, 0, 0, 0, 0, 8, 0},   //0   distance of Node '0' to other nodes
                                     {4, 0, 8, 0, 0, 0, 0, 11,0},   //1
                                     {0, 8, 0, 7, 0, 4, 0, 0, 2},   //2
                                     {0, 0, 7, 0, 9, 14,0, 0, 0},   //3
                                     {0, 0, 0, 9, 0, 10,0, 0, 0},   //4
                                     {0, 0, 4, 14,10,0, 2, 0, 0},   //5
                                     {0, 0, 0, 0, 0, 2, 0, 1, 6},   //6
                                     {8, 11,0, 0, 0, 0, 1, 0, 7},   //7
                                     {0, 0, 2, 0, 0, 0, 6, 7, 0}};  //8
        Dijkstra t = new Dijkstra();
        t.dijkstra(graph,2);
    }
}
