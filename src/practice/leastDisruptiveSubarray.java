package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leastDisruptiveSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate();
		maxSubarray();
		minSizeSubarraySum();
		maxProductSubarray();
		getDifferentNumber();
	}
	public static void calculate() {
		int[] a = new int[] {9,2,3,4,5};
		int[] b = new int[] {3,2,3};
		int distanceSum=0;
		int min=Integer.MAX_VALUE, minIndex=0;
		for(int i=0;i<=a.length-b.length;i++) {
			distanceSum=0;
			for(int j=0;j<b.length;j++) {
				distanceSum+=Math.abs(a[i+j]-b[j]);
			}
			if(min>distanceSum) {
				min=distanceSum;
				minIndex = i;
			}
		}
		System.out.println("leastDisruptiveSubarray: min:"+min+" minIndex:"+minIndex);
	}
	//given the array [-2,1,-3,4,-1,2,1,-5,4]
	//the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
	public static void maxSubarray() {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int max=nums[0], maxEnd=nums[0];
		for(int i=1;i<nums.length;i++) {
			maxEnd = Math.max(maxEnd, nums[i]);
			max = Math.max(maxEnd, max);
		}
		System.out.println("maxSubarray: max:"+max);
		
		/*int max=Integer.MIN_VALUE, maxEnd=0;
		int start=0, end=0, s=0;
		for(int i=0;i<nums.length;i++) {
			maxEnd+=nums[i];
			if(max<maxEnd) {
				max=maxEnd;
				start=s;
				end=i;
			}
			if(maxEnd<0) {
				s=i+1;
				maxEnd=0;
			}
		}
		System.out.println("maxSubarray:"+max+" start:"+start+" end:"+end);
		*/
	}
	// given the array [2,3,1,2,4,3] and s = 7; ans=subarray [4,3]
	public static void minSizeSubarraySum() {
		int[] nums = new int[] {2,3,1,2,4,3};
		int s=7;
		int p1=0, sum=0, min=Integer.MAX_VALUE;
		for(int p2=0;p2<nums.length;p2++) {
			sum+=nums[p2];
			while(sum>=s) {
				min=Math.min(min, p2+1-p1);
				sum-=nums[p1];
				p1++;
			}
		}
		min=min==Integer.MAX_VALUE?0:min;
		System.out.println("minSizeSubarraySum:"+min);
	}
	//given the array [2,3,-2,4],
	//the contiguous subarray [2,3] has the largest product = 6. 
	public static void maxProductSubarray() {
		int[] nums = new int[] {2,3,-2,4};
		int max=nums[0], min=nums[0], result=nums[0];
		for(int i=1;i<nums.length;i++) {
			int temp = max;
			max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
			min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
			result = Math.max(max, result);
		}
		System.out.println("maxProductSubarray:"+result);
	}
	//get a different number: find the smallest +ve number not in given arr
	public static void getDifferentNumber() {
		int[] arr = new int[] {4,3,2,1};
		//Approach 1: time:O(n) space:O(n)
		int min = 1;
		HashSet<Integer> set = new HashSet<>();
		for(int n:arr)
			set.add(n);
		while(min<Integer.MAX_VALUE) {
			if(!set.contains(min)) {
				System.out.println("Approach 1:The smallest +ver number not in arr:"+min);
				break;
			}
			min++;
		}
		//Approach 2: time=O(nlogn) space=O(1)
		arr = new int[] {4,3,2,1};
		Arrays.sort(arr);
		int res=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				res=i+1;
				break;
			}
		}
		res = res==0?arr.length+1:res;
		System.out.println("Approach 2:The smallest +ver number not in arr:"+res);
		//Approach 3: time O(n) space O(1)
		int[] nums = new int[] {4,3,2};
		res=0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
            	//swap
            	System.out.println("i:"+i+" nums[i]:"+nums[i]+" nums[nums[i]-1]:"+nums[nums[i]-1]);
            	int a=i, b=nums[i]-1;
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
            }
        }
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i+1) {
				res=i+1;
				break;
			}
		}
		res = res==0?nums.length+1:res;
		System.out.println("Approach 3:The smallest +ver number not in arr:"+res);
		System.out.println("Error");
	}
}
