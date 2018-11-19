package string;

import java.util.HashMap;

public class kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordPattern();
		naive_pattern_detection();		
		
		//using lps: lowest proper suffix
		kmp();
	}
	//detect Word pattern pattern 
	public static void wordPattern() {
		String str = "aaa bbb bbb ccc";
		String pattern ="abbc";
		
		String[] strs = str.split(" ");
		if(strs.length!=pattern.length()) {
			System.out.println("No pattern found, len unequal");
			return;
		}
		HashMap map = new HashMap<>();
		for(int i=0;i<pattern.length();i++) {
			if(map.put(strs[i], i)!=map.put(pattern.charAt(i), i)) {
				System.out.println("WordPattern:"+false);
				return;
			}
		}
		System.out.println("WordPattern:"+true);
	}
	//Naive pattern detection RT: O(p_len*(s_len-p_len+1)) = O(n^2)
	public static void naive_pattern_detection() {
		String str = "aaabc";
		String pat = "aab";
		for(int i=0;i<(str.length()-pat.length());i++) {
			int j=0;
			for(j=0;j<pat.length();j++)
				if(str.charAt(i+j)!=pat.charAt(j))
					break;
			if(j==pat.length())
				System.out.println("naive_pattern_detection : Pattern found @ "+i);
		}
	}

	//Optimized pattern detection RT: O(n)
	public static void kmp() {
		String str = "aaaaabc";
		String pat = "aaabc";
		
		int[] lps = new int[pat.length()];
		computeLPS(pat,lps); //longest proper prefix

		int i=0,j=0;
		while(i<str.length()) {
			if(pat.charAt(j)==str.charAt(i)) {
				i++; j++;
			}
			if(j==pat.length()) {
				System.out.println("KMP:Pattern found @ "+(i-j));
				j=lps[j-1];
			}else if(i<str.length() && pat.charAt(j)!=str.charAt(i)) {
				if(j!=0)  //reset pat pointer
					j=lps[j-1];
				else 
					i=i+1;
			}
		}
	}
	public static void computeLPS(String pat, int[] lps) {
		int len=0;
		int i=1;
		
		lps[0]=0;
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i++]=len;
			}else {
				if(len!=0) {
					len=lps[len-1];
				}else {
					lps[i++]=len;
				}
			}
		}
		for(int n:lps)
			System.out.print(n+"-");
		System.out.println("-> lps");
	}
}
