package com;

public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5,6};
		System.out.println("Binary Search Result:"+binarySearch(arr, 5));
		shiftedBinarySearch();
	}
	public static int binarySearch(int[] arr, int val){
		int start=0, end=arr.length;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==val)
				return mid;
			else if(arr[mid]>val) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}
	public static void shiftedBinarySearch() {
		int[] arr = new int[] {3,4,5,1,2};
		int num=1;
		int start=0, end=arr.length-1;
		boolean found=false;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==num) {
				System.out.println("shiftedBinarySearch Found @ "+mid);
				found=true;
				break;
			}
			System.out.println("mid:"+arr[mid]);
			 if(arr[mid]<=arr[end]){
				if(num>arr[mid] && num<=arr[end]) {
					start=mid+1;
					System.out.println("2)start=mid+1:"+start);
				}					
				else {
					end=mid-1;
					System.out.println("2)end=mid-1:"+end);
				}					
			}else if(arr[mid]>=arr[start]) {
				if(num>=arr[start] && num<arr[mid]) {
					end=mid-1;
					System.out.println("1)start=mid+1:"+start);
				}					
				else {
					start=mid+1;
					System.out.println("1)end=mid-1:"+end);
				}					
			}		
		}
		if(!found) System.out.println("shiftedBinarySearch Not Found");
	}

}
