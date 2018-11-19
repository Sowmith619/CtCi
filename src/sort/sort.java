package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"a","aa", "ab", "c"};
		sort obj = new sort();
		obj.string_sort(arr);
		System.out.print("\n");
		int[] nums = new int[] {1, 3, 111, 11};
		obj.nums_sort(nums);
		
		sort();
		
	}
	public void nums_sort(int[] nums) {
		Arrays.sort(nums);
		for(int num:nums)
			System.out.print(num+" : ");
		
        List<Integer> list = new ArrayList<>();
        int curr=1;
        
        for(int i=0;i<nums.length;i++){
        	curr=nums[i];
            list.add(curr);
            if(curr*10<=nums[i])
                curr *= 10;
            else if(curr%10 != 9 && curr+1<=nums[i])
                curr++;
            else{
                while((curr/10)%10 == 9)
                    curr /= 10;
                curr = curr/10 + 1;
            }
        }
		for(int num:list)
			System.out.print(num+" : ");

    }
	
	
	public void string_sort(String[] arr) {
		//lexicographically
		boolean didSwap=true;
		while(didSwap) {
			didSwap= false;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i].compareTo(arr[i+1])> 0) {
					didSwap = true;
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		
		for(String str:arr)
			System.out.print(str+" : ");
		
		String[] arr2 = {"a","aa", "ab", "c"};
		Arrays.sort(arr2);
		//for(String str:arr2)
		//	System.out.println(str);
	}
	//Sort
	public static void display(int[] arr, String name) {
		System.out.print("\n"+name+" : ");
		for(int n:arr)
			System.out.print(n+"-");
	}
	public static void sort() {
		int[] arr = new int[] {1,2,9,4,5};
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
		display(arr, "mergeSort");
		
		arr = new int[] {1,2,9,4,5};
		quickSort(arr, 0, arr.length-1);
		display(arr, "quickSort");
	}
	//MergeSort
	public static void mergeSort(int[] arr, int[] helper, int start, int end) {
		if(start>=end) return;
		int mid = (start+end)/2;
		mergeSort(arr, helper, start, mid);
		mergeSort(arr, helper, mid+1, end);
		merge(arr, helper, start, mid, end);
	}
	public static void merge(int[] arr, int[] helper, int start, int mid, int end) {
		for(int i=start;i<=end;i++)
			helper[i]=arr[i];
		int h_left=start, h_right=mid+1, curr=start;
		while(h_left<=mid && h_right<=end) {
			if(helper[h_left]<helper[h_right])
				arr[curr++]=helper[h_left++];
			else
				arr[curr++]=helper[h_right++];
		}
		while(h_left<=mid)
			arr[curr++]=helper[h_left++];
	}
	//QuickSort
	public static void quickSort(int[] arr, int left, int right) {
		if(left>=right) return;
		int index = partition(arr, left, right);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];
		while(left<=right) {
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++; right--;
			}
		}
		return left;
	}
	
}
