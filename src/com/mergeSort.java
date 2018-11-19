package com;

public class mergeSort {
	//static int[] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeSort obj = new mergeSort();
	
		int[] arr = new int[] {5,1,2,3,4};
		obj.merge_sort(arr,0, arr.length-1);
		for(int j:arr)
			System.out.print(j+" - ");
	}
	public void merge_sort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			merge_sort(arr, start, mid);
			merge_sort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	public void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[arr.length];
		for(int i=start;i<=end;i++)
			temp[i] = arr[i];
		int left = start;
		int right = mid+1;
		int curr = start;
		while(left<=mid && right<=end) {
			if(arr[left]<=arr[right])
				arr[curr++]=temp[left++];
			else
				arr[curr++]=temp[right++];
		}
		while(left<=mid)
			arr[curr++]=temp[left++];
	}

}
