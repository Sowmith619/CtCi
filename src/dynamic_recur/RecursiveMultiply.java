package dynamic_recur;

import java.util.Random;

public class RecursiveMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = 10;
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		System.out.println("Product="+helper(smaller,bigger));
		System.out.println("Product="+helper2(smaller,bigger));
		System.out.println("Add:"+add(a,b));
		
		//test_random();
		shuffle();
		random();
	}
	public static int helper(int smaller, int bigger) {
		if(smaller==0) return 0;
		else if(smaller==1) return bigger;
		
		int s = smaller>>1;
		System.out.print("s:"+s+" smaller:"+smaller+" bigger:"+bigger+"\n");
		int halfprod = helper(s, bigger);
		System.out.print("halfprod:"+halfprod+" s:"+s+" smaller:"+smaller+" bigger:"+bigger+"\n");
		if(smaller%2==0)
			return halfprod+halfprod;
		else
			return halfprod+halfprod+bigger;
	}
	public static int helper2(int smaller, int bigger) {
		if(smaller==0) return 0;
		else if(smaller==1) return bigger;
		
		int s = smaller>>1;
		int halfprod = helper2(s,bigger);
		if(smaller%2==0)
			return halfprod+halfprod;
		else
			return halfprod+halfprod+bigger;
	}
	//add without +
	public static int add(int a, int b) {
		while(b!=0) {
			int sum=a^b;
			int carry = (a&b)<<1;
			a=sum;
			b=carry;
		}
		return a;
	}
	//testing random function
	public static void test_random() {
		//Random: using Math.Random() or Random class
		int num=0;
		int[] prob = new int[5];
		for(int i=0;i<1000000;i++) {
			num = (int)(Math.random()*5+1);
			prob[num-1]++;
		}
		for(int i=0;i<prob.length;i++)
			System.out.println("(a)Prob of "+(i+1)+" is="+(((float)prob[i]/1000000)*100)+"%");
		
		prob = new int[5];
		Random rand = new Random();
		num=0;
		for(int i=0;i<1000000;i++) {
			num = (int)rand.nextInt(5);
			prob[num]++;
		}
		for(int i=0;i<prob.length;i++)
			System.out.println("(b)Prob of "+(i+1)+" is="+(((float)prob[i]/1000000)*100)+"%");
	}
	//shuffle cards
	public static void shuffle() {
		int[] cards = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};
		Random rand = new Random();
		for(int i=0;i<cards.length;i++) {
			int k = rand.nextInt(i+1);
			//int k = (int)(Math.random()*i+0);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
		for(int n:cards)
			System.out.print(n+"-");
		//recursion
		cards = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};
		cards = shuffle_helper(cards, cards.length-1);
		System.out.println("\nRecursion:");
		for(int n:cards)
			System.out.print(n+"-");
	}
	//Recursion: top - down
	public static int[] shuffle_helper(int[] cards, int i) {
		if(i==0) return cards;
		
		shuffle_helper(cards, i-1);
		int k = (int)(Math.random()*i+0);
		
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		return cards;
	}
	//Random Set: Randomly generate a subset of 'm' integer from an array of size 'n'
	public static void random() {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] subset = new int[5];
		int n = arr.length, m=subset.length;
		
		for(int i=0;i<m;i++)
			subset[i]=arr[i];
		
		for(int i=m;i<n;i++) {
			int k = (int)(Math.random()*i+0);
			if(k<m)
				subset[k]=arr[i];
		}
		System.out.print("\nRandom subset:");
		for(int num:subset)
			System.out.print(num+"-");
	}
}
