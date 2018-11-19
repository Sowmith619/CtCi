package com;

public class prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nthPrime(5);
		System.out.println();
		print_N_primes(5);
		
		pancakeSort();
	}
	/*
	The maximum execution time of this algorithm is O(sqrt (n)), 
	which will be achieved if 'n' is prime or the product of two large prime numbers.

	Average execution time is tricky; I'd say something like O(sqrt(n) / log n), 
	because there are not that many numbers with only large prime factors.
	*/

	public static void nthPrime(int n) {
		int num=0;
		int count=0;
		while(count<n) {
			num++;
			if(isPrime(num))
				count++;	
		}
		System.out.print(num);
	}
	public static void print_N_primes(int n) {
		int num=0;
		int count=0;
		while(count<n) {
			num++;
			
			if(isPrime(num)) {
				System.out.print(num+" ");
				count++;
			}
		}
	}
	public static boolean isPrime(int num) {
		/*if(num<2)
			return false;
		if(num==2)
			return true;
		if(num%2==0)
			return false;
		for(int i=3;i<num/2;i+=2) {
			if(num%i==0)
				return false;
		}
		return true;*/
		if(num<2) return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	//PANCAKE sort
	public static void pancakeSort() {
		int[] arr = new int[] {9,1,2,3,5};
		for(int i=arr.length-1;i>=0;i--) {
			int maxElemIndex=i;
			for(int j=i;j>=0;j--) {
				if(arr[j]>arr[maxElemIndex]){
					maxElemIndex = j;
				}
			}
			flip(arr, maxElemIndex+1);
			flip(arr, i+1);
		}
		System.out.println("");
		for(int n:arr)
			System.out.print(n+" - ");
	}
	//flip 1st k elem
	public static void flip(int[] arr, int k) {
		if(arr==null)
			return;
		for(int i=0;i<k/2;i++) {
			int temp = arr[i];
			arr[i]=arr[k-i-1];
			arr[k-i-1]=temp;
		}
	}
}
