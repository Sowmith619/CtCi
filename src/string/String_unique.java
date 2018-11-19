package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class String_unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "helo";
		HashMap<Character, Integer> map = new HashMap<>();
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(map.containsKey(ch[i])) {
				System.out.println("Not Unique");
				break;
			}else {
				map.put(ch[i], 1);
			}
		}
		int[] check = new int[26];
		//check for unique
		System.out.println("Result:"+check(str));
		for(int i=0;i<str.length();i++) {
			check[str.charAt(i)-'a']++;
		}
		//first unique char
		for(int i=0;i<str.length();i++) {
			/*if(--check[str.charAt(i)-'a'] == 0) {
				System.out.println("First Unique char:"+str.charAt(i));
				break;
			}*/
			//for checking if string is unique
			check[str.charAt(i)-'a']--;
		}
		for(int n:check) {
			if(n!=0) System.out.println("Not Unique");
		}
		
		permutation();
		url();
		perm();
		oneAway();
	}
	public static boolean check(String str) {
		boolean[] check = new boolean[126];
		for(int i=0;i<str.length();i++) {
			if(check[str.charAt(i)])
				return false;
			check[str.charAt(i)]=true;
		}
		return true;
	}
	public static void permutation() {
		String s="Hello123@";
		String t="oHell123@";
		int[] count = new int[128];
		for(char c:s.toCharArray())
			count[c]++;
		for(char c: t.toCharArray()) {
			if(--count[c]<0) {
				System.out.println("Not Permutation");
				return;
			}
		}
		System.out.println("Is Permutation");
	}
	public static void url() {
		String str = "Hello World, there!    ";
		int len=19, count=0; //len of the string till '!'
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ')
				count++;
		}
		int index = len + count*2;  //str.length
		System.out.println("\nURL:: index:"+index+" count:"+count);
		char[] ch = str.toCharArray();
		for(int i=len-1;i>=0;i--) {
			if(ch[i]==' ') {
				ch[index-1]='0';
				ch[index-2]='2';
				ch[index-3]='%';
				index=index-3;
			}else {
				ch[index-1]=ch[i];
				index--;
			}
		}
		System.out.println("URLify:"+String.valueOf(ch));
	}
	public static void perm() {
		//to be a palindrome::
		//String with even length --> 0 odd_counts of char OR 
		//String with odd length --> 1 odd_count
		String str = "taco cat";
		Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
        	if(str.charAt(i)>='a' && str.charAt(i)<='z') {
            if (!set.add(str.charAt(i)))
                set.remove(str.charAt(i));
        	}
        }
		if(set.size()<=1)
			System.out.println("\nPermutation of Palindrom:True: "+str);
		else
			System.out.println("\nPermutation of Palindrom:False: "+str);
	}
	public static void perm2() {
		String str = "taco cat";
		int[] alpha = new int[26];
		int countOdd=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				alpha[str.charAt(i)-'a']++;
				if(alpha[str.charAt(i)-'a']%2==1)
					countOdd++;
				else
					countOdd--;
			}
		}
		if(countOdd<=1)
			System.out.println("\nPermutation of Palindrom:True: "+str);
		else
			System.out.println("\nPermutation of Palindrom:False: "+str);
	}
	//oneEdit away :: replace, insert, delete one char O(n)
	public static void oneAway() {
		String s1="pale";
		String s2= "pade";
		boolean result = true;
		if(s1.length()==s2.length())
			result = oneEditReplace(s1,s2);
		else if(s1.length()+1==s2.length())
			result = oneEditInsert(s1,s2);
		else if(s1.length()==s2.length()+1)
			result = oneEditInsert(s2,s1);
		System.out.println("oneAway ::"+result);
		System.out.println("oneAway combined::"+oneEditAway(s1, s2));
	}
	public static boolean oneEditReplace(String s1, String s2) {
		boolean found=false;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				if(found)
					return false;
				found=true;
			}
		}
		return true;
	}
	public static boolean oneEditInsert(String s1, String s2) {
		int index1=0, index2=0;
		while(index1<s1.length() && index2<s2.length()) {
			if(s1.charAt(index1)!=s2.charAt(index2)) {
				if(index1!=index2)
					return false;
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	//combining replace and insert
	public static boolean oneEditAway(String first, String second) {
		int index1=0, index2=0;
		String s1 = first.length()<second.length()?first:second;
		String s2 = first.length()<second.length()?second:first;
		boolean found= false;
		while(index1<s1.length() && index2<s2.length()) {
			if(s1.charAt(index1)!=s2.charAt(index2)) {
				if(found)
					return false;
				found=true;
				if(s1.length()==s2.length())
					index1++;
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
}
