package practice;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class maxSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSubarray();
		slidingWindowMaximum();
		slidingWindowMedian();
	}
	//Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
	public static void maxSubarray() {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int max=nums[0], maxEnd=nums[0];
		for(int i=1;i<nums.length;i++) {
			maxEnd = Math.max(maxEnd+nums[i], nums[i]);
			max = Math.max(maxEnd, max);
		}
		System.out.println("Max:"+max);
	}
	//Sliding Window Maximum
	public static void  slidingWindowMaximum() {
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k=3;
		
		Deque<Integer> queue = new ArrayDeque<>();
		int[] res = new int[nums.length-k+1];
		int index=0;
		for(int i=0;i<nums.length;i++) {
			while(!queue.isEmpty() && queue.peek()<i-k+1)
				queue.poll();
			while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i])
				queue.pollLast();
			queue.offer(i);
			if(i>=k-1)
				res[index++]=nums[queue.peek()];
		}
		System.out.print("slidingWindowMaximum:");
		for(int n:res)
			System.out.print(n+" ");
	}
	//sliding Window Median
	public static void slidingWindowMedian() {
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k=3;
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		int[] res = new int[nums.length-k+1];
		for(int i=0;i<nums.length;i++) {
			if(left.size()<=right.size()) {
				right.add(nums[i]);
				left.add(right.remove());
			}else {
				left.add(nums[i]);
				right.add(left.remove());
			}
			if(left.size()+right.size()==k) {
				int median;
				if(left.size()==right.size())
					median = (left.peek()+right.peek())/2;
				else
					median = left.peek();
				int start=i-k+1;
				res[start]=median;
				if(!left.remove(nums[start]))
					right.remove(nums[start]);
			}
		}
		
		System.out.println("\nslidingWindowMedian:");
		for(int n:res)
			System.out.println(n);
	}


}
