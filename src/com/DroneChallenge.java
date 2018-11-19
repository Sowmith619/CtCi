package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DroneChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		drone();
		differentNumber();
		uniq();
		pancakeSort();
		findRoot();
	}
	public static void drone() {
		int[][] route = new int[][] {{0,2,10},{3,5,0}, {9,20,6}, {10,12,15}, {10,10,8}};
		//diff = 10  -6  -9  7
		//e    = 10   4  -5  2		
		//find the min energy
		int energy=0, largestMin=0;
		for(int i=1;i<route.length;i++) {
			energy += route[i-1][2]-route[i][2];
			if(energy<largestMin)
				largestMin = energy;
		}
		System.out.println(-1*largestMin);
		
		//the different between start and highest point
		int maxHeight=0;
		for(int i=0;i<route.length;i++) {
			if(maxHeight<route[i][2])
				maxHeight=route[i][2];
		}
		System.out.println(maxHeight-route[0][2]);
	}
	//find the smallest integer val NOT in arr
	public static void differentNumber() {
		int[] arr = new int [] {0, 9, 1, 1, 8, 1, 4, 2, 6};
		//runtime: O(n) | space: O(n)
		Set<Integer> set = new HashSet<>();
		for(int n:arr)
			set.add(n);
			
		int num=0;
		while(num<=Integer.MAX_VALUE) {
			if(!set.contains(num)) {
				System.out.println("Min Integer value NOT in arr :"+num);
				break;
			}
			num++;
		}
		//runtime: O(nlogn) | space: O(1)
		Arrays.sort(arr);
		int i=0;
		num=0;
		while(num<=Integer.MAX_VALUE) {
			if(num<arr[i]){
				System.out.println("Min Integer value NOT in arr :"+num);
				break;
			}else if(num==arr[i]){
				num++;
			}			
			i++;
		}
	}
	//Smallest Substring of all characters
	public static void uniq()
	{
		char[] ch = new char[] {'a', 'b', 'c'};
		String str = new String("aaabbbabc");
		
		int[] track = new int[ch.length];
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			for(int j=0;j<ch.length;j++) {
				if(c==ch[j])
					track[j]=track[j]+1;
			}
		}
		
		System.out.println("min :"+track[ch.length-1]);
		
        /*Map<Character, Integer> map = new HashMap();
        int min=0, i=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j)))
                i=Math.max(i, map.get(s.charAt(j)));
            map.put(s.charAt(j),j+1);
            min = Math.min(min, j-i+1);
        }
        System.out.println("min :"+min);*/
	}
	//pancake sort
	public static void pancakeSort() {
		int[] arr = new int[] {1,5,4,3,2};
		for(int i=arr.length-1;i>=0;i--) {
			int index=findMax(arr,i);
			flip(arr,index);
			flip(arr, i);
		}
		for(int n:arr)
			System.out.print(n+"-");
	}
	public static int findMax(int[] arr, int k) {
		int max=0;
		for(int i=0;i<=k;i++)
			if(arr[i]>arr[max])
				max=i;
		return max;
	}
	public static void flip(int[] arr, int k) {
		double pivot = Math.floor((k+1)/2);
		for(int i=0;i<pivot;i++) {
			int temp = arr[i];
			arr[i] = arr[k-i];
			arr[k-i] = temp;
		}
	}
	//find root : Math.sqrt(x,n)
	//returns the positive n’th root of 'x' within an error of 0.001 i.e |y-root(x,n)| < 0.001)
	public static void findRoot() {
		double x=27, n=3; //to find: Math.sqrt(x,n)
		
		double start=0, end=x;
		double approx = (start+end)/2; //approx root
		while(approx-start>=0.001) {
			if(Math.pow(approx, n)>x)
				end=approx;
			else if(Math.pow(approx, n)<x)
				start=approx;
			else
				break;
			approx=(start+end)/2;
		}
		approx=Math.round(approx*1000);
		approx=approx/1000;
		System.out.println("\nApprox root:"+approx);
	}
}
