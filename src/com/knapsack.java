package com;

/**
 * Created by sunil on 11/24/17.
 */
public class knapsack {
    public static void main(String[] args){
        knapsack ks = new knapsack();
        //given a bag of size W, we need to maximize the value of items that can be put in it.
        //given W, find max val && sum(w)<=W
        int[] val = new int[]{60,100,120};
        int[] wt = new int[]{10,20,30};
        int W=50;
        int n = val.length;
        System.out.println("Recursion::"+ks.recursion(W,wt,val,n));

        System.out.println("DP::"+ks.dynamic(W,wt,val,n));
    }
    //Time complexity :O(2^n); space :O(1)
    public int recursion(int W, int[] wt, int[] val, int n){
        //3 condition
        //vals length is 0 or the W is 0
        if(n==0 || W==0) return 0;
        //If wt of the nth item is more than W, we exclude this from the list.
        if(wt[n-1]>W) return recursion(W, wt, val, n-1);
        //if nth item wt is less than W return max wt of
        //1)nth item included 2)nth item not included
        else
            return Math.max(recursion(W,wt,val,n-1), val[n-1]+recursion(W-wt[n-1], wt, val, n-1));
    }
    //Time & Space Complexity: O(nW), n is the number of items & W is the capacity of knapsack.
    public int dynamic(int W, int[] wt, int[] val, int n){
        int[][] k = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0||w==0)
                    k[i][w]=0;
                else if(wt[i-1]>w)
                    k[i][w]=k[i-1][w];
                else
                    k[i][w]=Math.max(k[i-1][w], val[i-1]+k[i-1][w-wt[i-1]]);
            }
        }
        return k[n][W];
    }
}