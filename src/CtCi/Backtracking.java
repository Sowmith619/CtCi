package CtCi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Backtracking {
	public static void main(String[] args) {
		String str = "abc";
		List<String> list = new LinkedList<>();
		
		permutation(list, str, "");
		System.out.println("Permutation:\n"+list);
		
		List<List<Integer>> res = subsets(new int[] {1,2,3});
		System.out.println("Subsets-I:\n"+res);
	}
	//Simple permutation
	public static void permutation(List<String> list, String str, String prefix) {
		if(str.length()==0) {
			list.add(prefix);
		}else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0, i)+str.substring(i+1);
				permutation(list, rem, prefix+str.charAt(i));
			}
		}
	}
	//A General approach to backtracking question (Subset, Permutation, Combination sum, Palindrome Partition)\
	//[1.1] Subsets
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
		list.add(new ArrayList<>(temp));
		for(int i=start;i<nums.length;i++) {
			temp.add(nums[i]);
			backtrack(list, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
