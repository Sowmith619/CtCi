package moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class smallestDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commonMin();
		smallestDifference();
		factorialZeros();
		factZeros();
		//fibin
		int n=5;
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibin(i));
		}
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibinIter(i));
		}
	}
	//find the common min in 2 arr
	public static void commonMin() {
		int[] a = {1,4,6,8};
		int[] b = {9,7,6};
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			set.add(a[i]);
		}
		for(int i=0;i<b.length;i++) {
			if(set.contains(b[i])) {
				min = b[i]<min ? b[i]:min;
			}
		}
		min = min==Integer.MAX_VALUE?0:min;
		System.out.println("min:"+min);
		
		//find ALL common elem in 2 arr;
		a = new int[] {8,7,3,2,1};
		b = new int[] {10,2,1,30,40};
		Arrays.sort(a);
		Arrays.sort(b);
		int p1=0, p2=0;
		List<Integer> list = new LinkedList();
		while(p1<a.length && p2<b.length) {
			if(a[p1]==b[p2]) {
				list.add(a[p1]);
				p1++;p2++;
			}				
			else if(a[p1]<b[p2])
				p1++;
			else 
				p2++;
		}
		System.out.print("Common Elem = ");
		for(int n:list) 
			System.out.print(n+" ");
	}
	//Given 2 arrays of integers, compute the pair of values (one value in each
	//array) with the smallest (non-negative) difference. Return the difference.
	public static void smallestDifference() {
		int[] a = new int[] {1,4,6,8};  //9&8
		int[] b = new int[] {9,7,12};
		Arrays.sort(a);
		Arrays.sort(b);
		int p1=0, p2=0, diff=Integer.MAX_VALUE;
		while(p1<a.length && p2<b.length) {
			if(diff>Math.abs(a[p1]-b[p2]))
				diff=Math.abs(a[p1]-b[p2]);
			else if(a[p1]<b[p2])
				p1++;
			else
				p2++;			
		}
		System.out.println("\nsmallestDifference:"+diff);
	}
	
	//trailing zeros in factorial
	public static void factorialZeros() {
		int num=19;
		int count=0;
		for(int i=2;i<=num;i++)
			count+=factorsOf5(i);
		//calcu factorial
		int fact=1;
		for(int i=2;i<=num;i++)
			fact*=i;
		System.out.println("Factorial:"+fact);
		System.out.println("Trailing zeros:"+count);
	}
	public static int factorsOf5(int i) {
		int count=0;
		while(i%5==0) {
			count++;
			i/=5;
		}
		return count;
	}
	//factorial trailing zeros optimized
	public static void factZeros() {
		int num=19;
		int count=0;
		for(int i=5;num/i>0;i*=5)
			count+=num/i;
		System.out.println("factZeros="+count);
	}
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	//Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
	public static int fibin(int n) {
		if(n==0||n==1) return n;
		return fibin(n-1)+fibin(n-2);
	}
	public static int fibinIter(int n) {
		if(n==0||n==1) return n;
		int a=0, b=1, z=0;
		for(int i=2;i<=n;i++) {
			z=a+b;
			a=b;
			b=z;
		}
		return z;
	}
}
