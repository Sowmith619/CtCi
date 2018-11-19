package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sunil on 10/31/17.
 */
//Iterative using Stack
public class graph_DFS2 {
    private int V;
    private LinkedList<Integer> adj[];

    graph_DFS2(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
    //recursive
    void DFSUtil(int v, boolean visited[]){
        visited[v]=true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n=i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }
    //iterative using stack
    void DFS(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        visited[s]=true;
        stack.push(s);
        System.out.print(s+" ");
        while(!stack.isEmpty()){
            s=stack.peek();
            stack.pop();
            if(visited[s]==false){
                System.out.print(s+" ");
                visited[s]=true;
            }

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    stack.push(n);
                }
            }
        }

    }
    public static void main(String[] args){
        graph_DFS2 dfs = new graph_DFS2(4);

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
