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
		
		List<List<Integer>> res = subsets(new int[] {1,2,2});
		System.out.println("Subsets-I:\n"+res);
		
		res = subsets2(new int[] {1,2,2});
		System.out.println("Subsets-II:\n"+res);
		
		res = permutate(new int[] {1,2,2});
		System.out.println("Permutation-I:\n"+res);
		
		res = permutate2(new int[] {1,2,2});
		System.out.println("Permutation-II:\n"+res);
		
		res = combinationSum(new int[] {1,2,2}, 3);
		System.out.println("combinationSum-I:\n"+res);
		
		res = combinationSum2(new int[] {1,2,2}, 3);
		System.out.println("combinationSum-II:\n"+res);
		
		List<List<String>> result = partition("Helle");
		System.out.println("Palindrome:\n"+result);
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
	//[1.1] Subsets - I
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		backtrack_s1(list, new ArrayList(), nums, 0);
		return list;
	}
	public static void backtrack_s1(List<List<Integer>> list, List<Integer> temp, int[] nums, int start)  {
		list.add(new ArrayList<>(temp));
		for(int i=start;i<nums.length;i++) {
			temp.add(nums[i]);
			backtrack_s1(list, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
	
	//[1.2] Subsets - II
	public static List<List<Integer>> subsets2(int[] nums){
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		backtrack_s2(list, new ArrayList<>(), nums, 0);
		return list;
	}
	public static void backtrack_s2(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
		list.add(new ArrayList<>(temp));
		for(int i=start;i<nums.length;i++) {
			if(i>start && nums[i]==nums[i-1]) continue;
			temp.add(nums[i]);
			backtrack_s2(list, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
	
	//[2.1] Permutation - I
	public static List<List<Integer>> permutate(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack_p1(list, new ArrayList<>(), nums);
		return list;
	}
	public static void backtrack_p1(List<List<Integer>> list, List<Integer> temp, int[] nums) {
		if(temp.size()==nums.length) {
			list.add(new ArrayList<>(temp));
		}else {
			for(int i=0;i<nums.length;i++) {
				if(temp.contains(nums[i])) continue;
				temp.add(nums[i]);
				backtrack_p1(list, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	//[2.2] Permutation - II
	public static List<List<Integer>> permutate2(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack_p2(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}
	public static void backtrack_p2(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used) {
		if(temp.size() == nums.length) {
			list.add(new ArrayList<>(temp));
		}else {
			for(int i=0;i<nums.length;i++) {
				if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
				used[i] = true;
				temp.add(nums[i]);
				backtrack_p2(list, temp, nums, used);
				used[i] = false;
				temp.remove(temp.size()-1);
			}
		}
	}
	
	//[3.1] Combination Sum - I
	public static List<List<Integer>> combinationSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack_cs1(list, new ArrayList<>(), nums, target, 0);
		return list;
	}
	public static void backtrack_cs1(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {
		if(remain<0) return;
		else if(remain==0) list.add(new ArrayList<>(temp));
		else {
			for(int i=start;i<nums.length;i++) {
				temp.add(nums[i]);
				backtrack_cs1(list, temp, nums, remain-nums[i], i);
				temp.remove(temp.size()-1);
			}
		}
	}
	 
	//[3.2] Combination Sum - II
	public static List<List<Integer>> combinationSum2(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack_cs2(list, new ArrayList<>(), nums, target, 0);
		return list;
	}
	public static void backtrack_cs2(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {
		if(remain<0) return;
		else if(remain==0) list.add(new ArrayList<>(temp));
		else {
			for(int i=start;i<nums.length;i++) {
				if(i>start && nums[i]==nums[i-1]) continue;
				temp.add(nums[i]);
				backtrack_cs2(list, temp, nums, remain-nums[i], i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	//[4] Palindrome Partitioning
	public static List<List<String>> partition(String s){
		List<List<String>> list = new ArrayList<>();
		backtrack_palindrome(list, new ArrayList<>(), s, 0);
		return list;
	}
	public static void backtrack_palindrome(List<List<String>> list, List<String> temp, String s, int start) {
		if(start==s.length()) {
			list.add(new ArrayList<>(temp));
		}else {
			for(int i=start;i<s.length();i++) {
				if(isPalindrome(s, start, i)) {
					temp.add(s.substring(start, i+1));
					backtrack_palindrome(list, temp, s, i+1);
					temp.remove(temp.size()-1);
					
				}
			}
		}
	}
	public static boolean isPalindrome(String s, int start, int end) {
		while(start<end)
			if(s.charAt(start++) != s.charAt(end--)) return false;
		return true;
	}
}