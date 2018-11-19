package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets(new int[] {1,2,3,3});
	}
	public static void subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack_subset(list, new ArrayList<>(), nums, 0);
		for(List<Integer> l:list) {
			for(int n:l)
				System.out.print(n);
			System.out.print("\n");
		}
	}
	public static void backtrack_subset(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.length;i++) {
			//for set with duplicate, skip the duplicates
			//if(i>start && nums[i]==nums[i-1]) continue;
			tempList.add(nums[i]);
			backtrack_subset(list, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}

}
