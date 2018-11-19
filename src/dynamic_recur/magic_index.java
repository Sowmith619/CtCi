package dynamic_recur;

public class magic_index {
	//A magic index in an array is defined as an index such that A[i]=i. 
	//Given a sorted array of distinct integers, write a method to find a magic index
	//FOLLOWUP: What if the values are not distinct?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		index1();
		multiply();
	}
	
	public static void index1() {
		int[] arr = new int[] {-40,-20,-1,1,2,3,5,7,9,12,13};
		//Distinct values
		int res = helper(arr, 0, arr.length-1);
		System.out.println(res);
		//not Distinct values
		//arr = new int[] {-10,-5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		res = helper2(arr, 0, arr.length-1);
		System.out.println(res);
	}
	public static int helper(int[] arr, int start, int end) {
		if(end<start) return -1;
		int mid=(start+end)/2;
		if(arr[mid]==mid)
			return mid;
		else if(arr[mid]>mid)
			return helper(arr, start, mid-1);
		else
			return helper(arr, mid+1, end);
	}
	//not Distinct valuesa
	public static int helper2(int[] arr, int start, int end) {
		if(end<start) return -1;
		
		int midIndex = (start+end)/2;
		int midValue = arr[midIndex];
		if(midIndex==midValue) return midIndex;
		
		int leftIndex = Math.min(midIndex-1, midValue);
		int left = helper2(arr, start, leftIndex);
		if(left>=0) 
			return left;
		int rightIndex = Math.max(midIndex+1, midValue);
		int right = helper2(arr, rightIndex, end);
		return right;
	}
	// Recursive Multiply
	public static void multiply() {
		int a = 10;
		int b = 15;
		
		int bigger = a>b?a:b;
		int smaller = a>b?b:a;
		System.out.println("Multiply:"+multiplyHelper(smaller, bigger));
	}
	public static int multiplyHelper(int smaller, int bigger) {
		if(smaller==0) return 0;
		else if(smaller==1) return bigger;
		
		int s = smaller>>1;
		int halfprod = multiplyHelper(s, bigger);
		
		if(smaller%2==0)
			return halfprod+halfprod;
		else
			return halfprod+halfprod+bigger;
	}

}
