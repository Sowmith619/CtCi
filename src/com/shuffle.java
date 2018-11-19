package com;

/**
 * Created by sunil on 12/21/17.
 */
public class shuffle {
    public static void main(String[] args){
        int[] cards  = new int[]{0,1,2,3,4,5,6,7,8,9};

        //iterative Solution
        for(int i=0;i<cards.length;i++){
            int k = rand(0,i);
            int temp = cards[k];   //swap
            cards[k] = cards[i];
            cards[i] = temp;
        }
        for(int c:cards)
            System.out.print(c+"\t");

        //Recursive Solution
        int[] res = shuffle_recur(cards, cards.length-1);
        System.out.println("");
        for(int c:res)
            System.out.print(c+"\t");

        //Shuffle a subset
        cards  = new int[]{0,1,2,3,4,5,6,7,8,9};
        int m=3;
        int[] subset = new int[m];
        for(int i=0;i<m;i++)
            subset[i]=cards[i];
        for(int i=m;i<cards.length;i++){
            int k = rand(0,i);
            if(k<m)
                subset[k]=cards[i];
        }
        System.out.println("\nSubset::");
        for(int c:subset)
            System.out.print(c+"\t");
        System.out.println("\ncards::");
        for(int c:cards)
            System.out.print(c+"\t");
    }
    //Random function
    public static int rand(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }
    //Recursive function
    public static int[] shuffle_recur(int[] cards, int i){
        if(i==0)
            return cards;

        shuffle_recur(cards,i-1);  // Shuffle earlier part
        int k=rand(0,i);         // Pick random index to swap with
        int temp = cards[k];         // Swap
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;
    }

}
