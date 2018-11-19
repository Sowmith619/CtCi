package com;

import java.util.HashSet;
import java.util.Set;

public class palindrome_substring {
	int count;
	Set<String> set = new HashSet<>();
	int lo, maxlen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("aabaa");
		palindrome_substring obj = new palindrome_substring();
		obj.palindrome(s);
	}
	public void palindrome(String s) {
		for(int i=0;i<s.length();i++) {
			extend(set,s,i,i);
			extend(set,s,i,i+1);
		}
		System.out.println("Palindromic Substring::"+count);
		System.out.println("\nDistinct::"+set.size());
		for(String st: set)
			System.out.println("Values::"+st);
		System.out.println("\nLongest::"+s.substring(lo, lo+maxlen));
	}
	public void extend(Set<String> set, String s, int i, int j) {
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
			set.add(s.substring(i, j+1));
			i--; j++;
			count++;
		}
		if(maxlen<j-i-1) {
			lo=i+1;
			maxlen=j-i-1;
		}
	}

	
}
