package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class arrayPair {
	public static void main(String[] args) {
		arrayPair();
		allArrayPair();
		findMinCommonElem();
	}
	public static void arrayPair() {
		int sum=5;
		int[] arr = new int[] {1,6,3,2,5,4};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = null;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(sum-arr[i]))
				res = new int[] {map.get(sum-arr[i]), i};
			map.put(arr[i], i);
		}
		if(res==null) System.out.println("No array pair");
		else System.out.println("arrayPair : "+res[0]+" "+res[1]);
	}
	public static void allArrayPair() {
		int sum=5;
		int[] arr = new int[] {1,6,3,2,5,4};

		Map<Integer, Integer> map = new HashMap<>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 0);
		}
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(sum-arr[i]))
				count++;
			if(sum==arr[i]+arr[i])
				count--;
		}
		System.out.println("Array Pair count:"+(count/2));
	}
	public static void findMinCommonElem() {
		int[] arr1 = new int[] {6,4,2,1};
		int[] arr2 = new int[] {9,8,1};
		int min=Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int n:arr1)
			set.add(n);
		for(int n:arr2) {
			if(set.contains(n)) {
				min = Math.min(min, n);
			}
		}
		System.out.println("MinCommonElem:"+min);
	}
}
