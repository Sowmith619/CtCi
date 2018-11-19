package com;

public class anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		anagram();
		//anagram2();
		test();
	}
	public static void test() {
		int[] arr = new int[] {1, 5, 3, 7, 3, 6, 2};
		int x = 0;
		for (int i = 0; i < arr.length ; i++) {
		    if ( arr[i] >= 6 ) {
		        i++;
		    } else {
		        x += arr[i];
		    }
		}
		System.out.print(x);

	}
	public static void anagram() {
		String small ="Hello";
		String big = "HelloWorld";
		int[] alpha = new int[26];
		
		for(char c:small.toLowerCase().toCharArray()) {
			alpha[c-'a']++;
			//System.out.println(c-'a');
		}
		
		for(char c:big.toLowerCase().toCharArray())
			if(alpha[c-'a']>0)
				alpha[c-'a']--;
		
		for(int n:alpha)
			if(n>0) {
				System.out.println("False: Not anagram");
				return;
				}
		
		System.out.println("True: Is an anagram");
	}
	public static void anagram2() {
		String small = "Hello!!";
		String big = "HelloWorld!@#!$%";
		int[] alpha = new int[256];
		for(char c:small.toCharArray())
			alpha[c]++;
		
		for(char s:big.toCharArray())
			if(alpha[s]>0)
				alpha[s]--;
		
		for(int n:alpha)
			if(n>0) {
				System.out.println("False: Not anagram");
				return;
						}
		
		System.out.println("True: Is an anagram");
	}
}
