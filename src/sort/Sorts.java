package sort;

import java.util.Arrays;

public class Sorts {
	//display
	public static void display(int[] arr, String name) {
		System.out.print("\n"+name+"\t");
		for(int n:arr)
			System.out.print(n+" ");
	}
	public static int[] init() {
		return new int[] {9,1,2,7,8,3,4,5};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = init();
		//MergeSort
		display(arr, "Input Array::>");
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
		display(arr, "MergeSort::");
		
		//QuickSort
		arr=init();
		quickSort(arr, 0, arr.length-1);
		display(arr, "QuickSort");
		//BubbleSort
		arr=init();
		bubbleSort(arr);
		//SelectionSort
		arr=init();
		selectionSort(arr);
		//InsertionSort
		arr=init();
		insertionSort(arr);
		//BucketSort
		arr=init();
		bucketSort(arr);
		//pancake Sort
		arr=init();
		pancakeSort(arr);
		display(arr,"PancakeSort");
		//HeapSort
		arr=init();
		heapSort(arr);
		display(arr,"HeapSort");
		//Binary Search
		System.out.println("\nBinary Search: "+binarySearch(5));
		arr = new int[] {1,5,8,3,5,7};
		System.out.println("Binary Search Recursion: "+binarySearchRecursion(arr, 0, arr.length, 5));
		System.out.println("Binary Search Rotated Arr: "+binarySearch_rotated(new int[] {2,5,6,7,1,2,2}, 2));
	}
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
		int h_left=start;
		int h_right=mid+1;
		int curr=start;
		while(h_left<=mid && h_right<=end) {
			if(helper[h_left]>helper[h_right])
				arr[curr++]=helper[h_right++];
			else
				arr[curr++]=helper[h_left++];
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
		int pivot = arr[(right+left)/2];
		while(left<=right) {
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	//Bubble Sort : pair wise comparison and at the end the arr is sorted
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		display(arr, "BubbleSort");
	}
	//SelectionSort: find the smallest elem["index"] and swap with ith elem
	public static void selectionSort(int[] arr) {
		init();
		for(int i=0;i<arr.length;i++) {
			int index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[index])
					index=j;
			}
			if(i!=index) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		display(arr, "SelectionSort:");
	}
	//Insertion Sort: pick incorrect elem & insert into correct pos in rearranged arr. 
	//similar to Shuffling cards
	public static void insertionSort(int[] arr) {
		init();
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j=i-1;
			while(j>=0 && key<arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		display(arr, "InsertionSort");
	}
	//bucketSort
	public static void bucketSort(int[] arr) {
		init();
		int maxValue=9;
		
		int[] bucket = new int[maxValue+1];
		for(int n:arr) 
			bucket[n]++;
		int pos=0;
		for(int i=0;i<bucket.length;i++)
			for(int j=0;j<bucket[i];j++)
				arr[pos++]=i;
		
	    display(arr,"BucketSort");
	}
	//pancake sort
	public static void pancakeSort(int[] arr) {
		for(int i=arr.length-1;i>=0;i--) {
			int maxIndex = findIndex(arr, i);
			flip(arr, maxIndex);
			flip(arr, i);
		}
	}
	public static int findIndex(int[] arr, int k) {
		int index=0;
		for(int i=0;i<=k;i++)
			if(arr[i]>arr[index])
				index=i;
		return index;
	}
	public static void flip(int[] arr, int k) {
		double pivot = Math.floor((k+1)/2);
		for(int i=0;i<(int)pivot;i++) {
			int temp = arr[i];
			arr[i] = arr[k-i];
			arr[k-i] = temp;
		}
	}
	//HeapSort
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--)
			heapify(arr, n, i);
		for(int i=n-1;i>=0;i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, n, i);
		}
	}
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = left+1;
		if(left<n && arr[left]<arr[largest])
			largest = left;
		if(right<n && arr[right]<arr[largest])
			largest = right;
		if(largest!=i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
	//Binary Search: find 5
	public static int binarySearch(int x) {
		int[] arr = new int[] {9,1,2,7,8,3,4,5};
		Arrays.sort(arr);
		display(arr, "BinarySearch i/p");
		int start=0, end = arr.length-1;
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid]==x)
				return arr[mid];
			else if(arr[mid]>x)
				end=mid-1;
			else 
				start=mid+1;
		}
		return -1;
	}
	
	public static int binarySearchRecursion(int[] arr, int start, int end, int n) {
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(arr[mid]==n)
			return arr[mid];
		else if(arr[mid]>n)
			return binarySearchRecursion(arr, start, mid-1, n);
		else
			return binarySearchRecursion(arr, mid+1, end, n);
	}
	//rotated arr, binary search
	public static int binarySearch_rotated(int[] arr, int target) {
		int start=0, end=arr.length-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid]==target) return mid;
			if(arr[mid]>arr[start] || arr[mid]>arr[end]) {
				if(target>=arr[start] && target<arr[end])
					end=mid-1;
				else
					start=mid+1;
			}else if(arr[mid]<arr[start] || arr[mid]<arr[end]){
				if(target>arr[mid] && target<=arr[end])
					start=mid+1;
				else
					end=mid-1;
			}else
				end--;
		}
		return -1;
	}
	
}
