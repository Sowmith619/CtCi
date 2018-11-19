package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sunil on 10/31/17.
 */

//Recursive
public class graph_DFS {
    private int V;
    private LinkedList<Integer> adj[];

    graph_DFS(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
    //Recursive
    void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> iter = adj[v].listIterator();
        while(iter.hasNext()){
            int n=iter.next();
            while(!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v){
        boolean visited[] = new boolean[V];
        //Recursive
        //DFSUtil(v,visited);
        //iterative;
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            v=stack.pop();
            System.out.print(v+" ");
            visited[v]=true;
            Iterator<Integer> iter = adj[v].listIterator();
            while(iter.hasNext()){
                int n=iter.next();
                if(!visited[n])
                    stack.push(n);
            }
        }
    }
    public static void main(String[] args){
        graph_DFS dfs = new graph_DFS(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        System.out.println("Following is the DFS (starting from vertex 2)");
        dfs.DFS(2);
    }


}
