package sort;

import java.util.Arrays;

/**
 * Created by sunil on 11/8/17.
 */
public class peeks_valleys {
    public static void main(String[] args){
        peeks_valleys pv = new peeks_valleys();
        int[] arr = new int[]{0,1,4,7,8,9};

        System.out.print("Input:: ");
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");

        System.out.print("\nSort Result::  ");
        pv.sort(arr);

        System.out.print("\nSort2 Result:: ");
        pv.sort2(arr);
        
        matrix();
        
        System.out.println("Find Peak1 : "+ pv.findPeak1());
        int[] nums = {1,2,1,3,5,6,7};
        System.out.println("Find Peak2 : "+ pv.findPeak2(nums, 0, nums.length-1));
    }
    //find peak
    public int findPeak1() {
    	int[] nums = {1,2,1,1};
    	int l=0, r=nums.length-1;
    	while(l<r) {
    		int mid = (l+r)/2;
    		if(nums[mid]>nums[mid+1]) {
    			r=mid;
    		}else {
    			l=mid+1;
    		}
    	}
    	return nums[l];
    }
    
    public int findPeak2(int[] nums, int l, int r) {
    	if(l==r)
    		return nums[l];
    	int mid = (l+r)/2;
    	if(nums[mid]>nums[mid+1]) {
    		return findPeak2(nums, l, mid);
    	}else {
    		return findPeak2(nums, mid+1, r);
    	}
    }
    // Sort method 1::
    //peek_valley generation after sorting the array
    public void sort(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2)
        {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    // Sort method 2::
    // peek & valley generation without sort function
    public static void sort2(int[] arr) {
    	arr = new int[]{0,1,4,7,8,9};
    	for(int i=1;i<arr.length;i++) {
    		int biggestIndex = biggestIndex(arr, i-1, i, i+1);
    		if(i!=biggestIndex) {
    			int temp = arr[i];
    			arr[i] = arr[biggestIndex];
    			arr[biggestIndex] = temp;
    		}
    	}

    	for(int n:arr)
    		System.out.print(n+" ");
    }
    //return the Index which has the biggest value
    public static int biggestIndex(int[] arr, int a, int b, int c) {
    	int aVal = a>=0 && a<arr.length ? arr[a] : Integer.MIN_VALUE;
    	int bVal = b>=0 && b<arr.length ? arr[b] : Integer.MIN_VALUE;
    	int cVal = c>=0 && c<arr.length ? arr[c] : Integer.MIN_VALUE;
    	int max = Math.max(Math.max(aVal, bVal), cVal);
    	if(max==aVal) return a;
    	else if(max==bVal) return b;
    	else return c;
    }
    //Sorted matrix search
    public static void matrix() {
    	int[][] matrix = new int[][] {{15,20,25,30},{35,40,45,50},{55,60,65,70},{75,80,85,90}};
    	
    	System.out.println("\nMatrix::");
    	for(int i=0;i<matrix.length;i++) {
    		for(int j=0;j<matrix.length;j++) {
    			System.out.print(matrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    	int target = 60;
    	int row = 0, col=matrix[0].length-1;
    	while(row<matrix.length && col>=0) {
    		if(matrix[row][col]==target) {
    			System.out.println("Element found:"+matrix[row][col]+" at:"+row+"-"+col);
    			return;
    		}else if(matrix[row][col]<target)
    			row++;
    		else
    			col--;
    	}
    	System.out.println("Target not found");
    }
}
