package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class graph_BFS {
    private int V;
    private LinkedList<Integer> adj[];

    graph_BFS(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void BFS(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            s=queue.poll();
            System.out.print(s+" ");
            visited[s]=true;
            Iterator<Integer> iter = adj[s].listIterator();
            while(iter.hasNext()){
                int n=iter.next();
                if(!visited[n])
                    queue.add(n);
            }
        }
/*        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(!queue.isEmpty()){
            s=queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }*/

    }

    public static void main(String[] arg){
        graph_BFS bfs = new graph_BFS(4);
        bfs.addEdge(0,1);
        bfs.addEdge(0,2);
        bfs.addEdge(1,2);
        bfs.addEdge(2,0);
        bfs.addEdge(2,3);
        bfs.addEdge(3,3);

        System.out.println("Following is BFS (starting from vertex 2)");
        bfs.BFS(2);
    }


}

