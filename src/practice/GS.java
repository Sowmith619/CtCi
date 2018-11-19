package practice;

public class GS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		secondSmallest();
		secondLargest();
	}
	public static void secondSmallest() {
		int[] arr = new int[] {1,5,4,6,7,3,9};
		int first=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(first>arr[i]) {
				second=first;
				first=arr[i];
			}else if(second>arr[i] && first!=arr[i])
				second=arr[i];
		}
		System.out.println(first+":"+second);
	}
	public static void secondLargest() {
		int[] arr = new int[] {1,6,8,3,5,2};
		int first = Integer.MIN_VALUE, second=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(first<arr[i]) {
				second=first;
				first=arr[i];
			}else if(second<arr[i] && first!=arr[i])
				second=arr[i];
		}
		System.out.println(first+":"+second);
	}
}
