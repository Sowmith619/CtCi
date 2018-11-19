package com;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bruteForce();
		int[] arr = new int[] {1,9,7,3,2,4,5};
		optimal(arr, 0, arr.length-1);
		
		arr = new int[] {1,9,7,3,3,2,4,5};
		int res = optimal2(arr, 0, arr.length-1);
		System.out.print("Optimal2 Magic index at "+res);
	}
	public static void bruteForce() {
		int[] arr =  new int[] {1,9,7,3,2,4,5};
		for(int i=0;i<arr.length;i++)
			if(arr[i]==i)
				System.out.print("Magic index found at "+i);
	}
	public static void optimal(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			if(arr[mid]==mid)
				System.out.println("\nMagic index found at "+mid);
			else if(arr[mid]>mid)
				optimal(arr, start, mid-1);
			else if(arr[mid]<mid)
				optimal(arr, mid+1, end);
		}
	}
	//if Duplicates exist
	public static int optimal2(int[] arr, int start, int end) {
		if(start>end) return -1;
		
		int midIndex = (start+end)/2;
		int midValue = arr[midIndex];
		if(midIndex == midValue)
			return midIndex;
		
		int leftIndex = Math.min(midIndex-1, midValue);
		int leftValue = optimal2(arr, start, leftIndex);
		if(leftValue>=0)
			return leftValue;
		
		int rightIndex = Math.max(midIndex+1,  midValue);
		int rightValue = optimal2(arr, rightIndex, end);
		return rightValue;
	}
}
