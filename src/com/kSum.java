package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class kSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 0, -1, 0, -2, 2};
		System.out.print("4Sum\n");
		find4Sum(arr, 0);
		//findSum(arr,0);
		System.out.print("\n3Sum\n");
		find3Sum(arr,0);
		combinationProduct();
	}
	
	public static void find4Sum(int[] arr, int a) {
		
		if(arr==null || arr.length<4) return;
		Arrays.sort(arr);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=0;i<arr.length;i++) { // 3ptr-->start[2loop+1ptr]; 1ptr-->end
			if(i>0 && arr[i]==arr[i-1]) continue; //to improve speed; this or while
 			for(int j=i+1;j<arr.length;j++) {
 				if(j>0 && arr[j]==arr[j-1]) continue;
				int p1=j+1;
				int p2=arr.length-1;
				while(p1<p2){
					int sum = arr[i]+arr[j]+arr[p1]+arr[p2];
					if(sum==a) {
						res.add(Arrays.asList(arr[i], arr[j], arr[p1], arr[p2]));	
						//while(p1<p2 && arr[p1]==arr[p1+1]) p1++;
						//while(p1<p2 && arr[p2]==arr[p2-1]) p2--;
						p1++; p2--;
					}else if(sum<a) {
						p1++;
					}else
						p2--;
				}
			}
		}

		for(List<Integer> l:res) {
			for(int k:l)
				System.out.print(k+" ");
			System.out.println();
		}
	}
	public static void findSum(int[] arr, int a) {
		if(arr==null || arr.length<4) System.out.println("No 4Sum");;
		Arrays.sort(arr);
		int[] res = null;
		for(int i=0;i<arr.length;i++) { 
			for(int j=i+1;j<arr.length;j++) {
				int p1=j+1;
				int p2=arr.length-1;
				while(p1<p2) {
					int sum = arr[i]-arr[j]+arr[p1]+arr[p2];
					if(sum==a) {
						res = new int[] {arr[i], arr[j], arr[p1], arr[p2]};
						break;
					}else if(sum<a)
						p1++;
					else
						p2--;
				}
			}
		}
		for(int k:res)
			System.out.print(k+" ");
	}
	public static void find3Sum(int[] arr, int a) { //3pointers = 1loop(start)+2ptr(start+end)
		arr = new int[] {-1, 0, 1, 2, -1, -4};
		if(arr==null || arr.length<3) return;
		Arrays.sort(arr);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=0;i<arr.length;i++) {
			if(i>0 && arr[i]==arr[i-1]) continue;
			int p1=i+1;
			int p2=arr.length-1;
			while(p1<p2) {
				int sum=arr[i]+arr[p1]+arr[p2];
				if(sum==a) {
					res.add(Arrays.asList(arr[i], arr[p1], arr[p2]));
					//while(p1<p2 && arr[p1]==arr[p1+1]) p1++;
					//while(p1<p2 && arr[p2]==arr[p2-1]) p2--;
					p1++; p2--;
				}else if(sum<a) {
					p1++;
				}else
					p2--;
			}
		}
		
		for(List<Integer> l:res) {
			for(int k:l)
				System.out.print(k+" ");
			System.out.println();
		}
	}
	//Combination product
	// given 12: return all multiple of 12, no duplicate
	public static void combinationProduct() {
		int num=60;
		
		Map<Integer, Integer> map = new HashMap<>();
		int n=0;
		while(n<num/2) {
			n++;
			if(num%n==0 && !map.containsKey(num/n))
				map.put(n, num/n);
		}
		System.out.println("\nCombination Product:");
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		//Subarray
		minSizeSubarraySum();
		maxSizeSubarraySum();
		subArrSumEqualK();
		maxSubArr();
		maxProductSubarr();
	}
	//209. Minimum Size Subarray Sum
	//For example, given the array [2,3,1,2,4,3] and s = 7,
	//the subarray [4,3] has the minimal length under the problem constraint. 
	public static void minSizeSubarraySum() {
		int[] nums = {2,3,1,2,4,3};
		int k=7;
		
		int p1=0, sum=0, min=Integer.MAX_VALUE;
		int start=0, end=0;
		for(int p2=0;p2<nums.length;p2++) {
			sum+=nums[p2];
			while(sum>=k) {
				//min=Math.min(min, p2+1-p1);
				if(min>p2+1-p1) {
					min=p2+1-p1;
					start=p1; end=p2;
				}
				sum-=nums[p1++];
			}
		}
		min = min==Integer.MAX_VALUE?0:min;
		System.out.println("Minimum Size Subarray Sum:"+min+" start:"+start+" end:"+end);
	}
	// Maximum Size Subarray Sum
	//Given nums = [1, -1, 5, -2, 3], k = 3,
	//return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
	public static void maxSizeSubarraySum() {
		int[] nums = {1, -1, 5, -2, 3};
		int k=3;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int max=0, sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(sum==k)
				max = Math.max(max, i+1);
			if(map.containsKey(sum-k))
				max = Math.max(max, i-map.get(sum-k));
			if(!map.containsKey(sum))
				map.put(sum, i);
			
		}
		System.out.println("Maximun Size Subarray Sum:"+max);
	}
	// Subarray Sum Equals K
	//find the total number of continuous subarrays whose sum equals to k.
	public static void subArrSumEqualK() {
		int[] nums = {1, -1, 5, -2, 3};
		int k=3;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count=0, sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(map.containsKey(sum-k))
				count+=map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		System.out.println("Subarray Sum Equals K:"+count);
	}
	
	//53. Maximum Subarray
	//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	//the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
	public static void maxSubArr() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		int max=nums[0], maxEnd=nums[0];
		for(int i=1;i<nums.length;i++) {
			maxEnd = Math.max(maxEnd+nums[i], nums[i]);
			max = Math.max(max, maxEnd);
		}
		System.out.println("maxSubArr:"+max);
	}	
	//152. Maximum Product Subarray
	//For example, given the array [2,3,-2,4],
	//the contig	uous subarray [2,3] has the largest product = 6. 
	public static void maxProductSubarr() {
		int[] nums = {2,3,-2,4};
		
		int max=nums[0], min=nums[0], result = nums[0];
		for(int i=1;i<nums.length;i++) {
			int temp = max;
			max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
			min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
			result = Math.max(result,max);
		}
		System.out.println("Maximum Product Subarray:"+result);
	}
}																																																																																																																																																																							
