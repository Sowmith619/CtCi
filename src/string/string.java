package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		replaceSpace();
		reverseVowels();
		palindromePermutation();
		palindromePermutation2();
		oneEditAway();
	}
	//replace " " --> "%20"
	public static void replaceSpace() {
		String str = "Hello World !    ";
		char[] ch = str.toCharArray();
		int index = str.length();
		int trueLen = 12;
		for(int i=trueLen;i>=0;i--) {
			if(str.charAt(i)==' ') {
				ch[index-1]='0';
				ch[index-2]='2';
				ch[index-3]='%';
				index=index-3;
			}else {
				ch[index-1]=str.charAt(i);
				index--;
			}
		}
		System.out.println("After replace:"+String.valueOf(ch));
	}
	public static void reverseVowels() {
		String vowels = "aeiouAEIOU";
		String input = "HelloWorld, everyday is beautiful!";
		char[] ch = new char[input.length()];
		int index=0, p1=0, p2=input.length()-1;
		for(char c:input.toCharArray())
			ch[index++]=c;
		while(p1<p2) {
			if(!vowels.contains(ch[p1]+"")) {
				p1++;
				continue;
			}
			if(!vowels.contains(ch[p2]+"")) {
				p2--;
				continue;
			}
			ch[p1]=input.charAt(p2);
			ch[p2]=input.charAt(p1);
			p1++; p2--;
				
		}
		System.out.println("\nReversed vowels string:"+String.valueOf(ch));
	}
	//Palindrome Permutation - 1
	//https://leetcode.com/articles/palindrome-permutation/
	//"code" -> False, "aab" -> True, "carerac" -> True. 
	public static void palindromePermutation() {
		//Using array: runtime: O(n), space: O(128)
		int[] arr = new int[128];
		String s="Heellooq";
		int count=0;
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
			if(arr[s.charAt(i)]%2==0)
				count--;
			else
				count++;
		}
		System.out.println("PalindromePermutation Using array:"+(count<=1));
		
		//Using set: runtime: O(n), space: O(n)
		HashSet<Character> set = new HashSet<>();
		count=0;
		for(int i=0;i<s.length();i++) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
				count++;
			}else {
				set.add(s.charAt(i));
			}
		}
		System.out.println("PalindromePermutation using set:"+(set.size()<=1));
		//size of the longest palindrome from this string
		if(!set.isEmpty()) {
			System.out.println("PalindromePermutation:"+(2*count+1));
		}else {
			System.out.println("PalindromePermutation:"+(2*count));
		}
	}
	/* Palindrome Permutation - 2
	https://leetcode.com/articles/palindrome-permutation-ii/
	Given s = "aabb", return ["abba", "baab"]
	Given s = "abc", return []
	*/
	public static void palindromePermutation2() {
		String s = "hheeq";
		List<String> res = new LinkedList<>();
		int count=0;
		int[] arr = new int[128];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
			if(arr[s.charAt(i)]%2==0)
				count--;
			else
				count++;
		}
		if(s=="" || count>1) {
			System.out.println("No Palindromic Permutation");
			return;
		}
		String temp="";
		if(count==1) {
			for(int i=0;i<128;i++) {
				if(arr[i]%2==1) {
					temp+=(char)i;
					break;
				}
			}
		}
		backtrack(arr,res, temp, s.length());
		System.out.print("PalindromePermutation2:  ");
		display(res);
	}
	public static void backtrack(int[] arr, List<String> res, String curr, int len) {
		if(curr.length()==len) {
			res.add(curr);
			return;
		}
		for(int i=0;i<128;i++) {
			if(arr[i]>1) {
				arr[i]-=2;
				String temp = (char)i+ curr +(char)i;
				backtrack(arr, res, temp, len);
				arr[i]+=2;
			}
		}
	}
	
	public static void display(List<String> list) {
		System.out.print("[ ");
		for(String s:list)
			System.out.print(s+" ");
		System.out.println("]");
	}
	/*
	One Edit Away:
	EXAMPLE
	pale, ple -> true
	pales, pale -> true
	pale, bale -> true
	pale, bae -> false
	*/
	public static void oneEditAway() {
		String s1="pale", s2="paleq";
		boolean check=false;
		if(s1.length()==s2.length()) {
			check=oneEditReplace(s1,s2);
			System.out.println("oneEditReplace:"+check);
		}			
		else if(s1.length()+1==s2.length()) {
			check=oneEditInsert(s1,s2); //(smaller, larger)
			System.out.println("oneEditInsert_1:"+check);
		}			
		else if(s1.length()-1==s2.length()) {
			check=oneEditInsert(s2,s1);
			System.out.println("oneEditInsert_2:"+check);
		}			
		System.out.println("oneEdit:"+check);
	}
	public static boolean oneEditReplace(String s1, String s2) {
		int l1=0, l2=0;
		boolean foundDiff=false;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				if(foundDiff)
					return false;
				foundDiff=true;
			}
		}
		return true;
	}
	public static boolean oneEditInsert(String s1, String s2) {
		int l1=0, l2=0;
		while(l1<s1.length() && l2<s2.length()) {
			if(s1.charAt(l1)!=s2.charAt(l2)) {
				if(l1!=l2)
					return false;
				l2++;
			}else {
				l1++;
				l2++;
			}
		}
		return true;
	}
}
