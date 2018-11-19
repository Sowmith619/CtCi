package string;

import java.util.Arrays;
import java.util.HashMap;

public class cerner2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		string_2();
		palindromic();
		palindromicSubString();
		pattern();
		subarr_sum();
		
		lpsub();  //lpsub_manacher();
		lpseq();
		LongestCommonSubstring();
		longestCommonSeq();
		edit();
		longestCommonPrefix();
	}
	//2nd largest word in given String
	public static void string_2() {
		String s = "Hello World Welcome !";
		String[] words = s.split(" ");
		int max=0, next=0;
		for(String w:words) {
			if(max<w.length()) {
				next=max;
				max=w.length();
			}
		}
		System.out.println("max:"+max+" next:"+next);
	}
	//Check if a given String is Palindromic with one edit or not
	public static void palindromic() {
		String s = "heeeeh";
		System.out.println(isPalindrome(s, 0, s.length()-1));
		System.out.println(isPalindrome(110001));
		boolean res=false;
		//one edit possible, check if the new string is a palindrome
		int start=0, end=s.length()-1;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) {
				res = isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
				break;
			}
			start++; end--;
			res=true;
		}
		System.out.println("Is Palindromic with edit:"+res);
	}
	public static boolean isPalindrome(String s, int start, int end) {
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	public static boolean isPalindrome(int num) {
		int reverse=0;
		while(num>reverse) {
			reverse = reverse*10 + num%10;
			num=num/10;
		}
		return num==reverse || num==reverse/10;
	}

	//find the repeating pattern
	public static void pattern() {
		String s="absabsabs";
		int l = s.length();
		for(int i=l/2;i>0;i--) {
			if(l%i==0) {
				int m = l/i;
				String sub = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<m;j++)
					sb.append(sub);
				if(sb.toString().equals(s)){
					System.out.println("The repeating pattern is:"+sub);
					break;
				}
			}
		}
	}
	//209. Minimum Size Subarray Sum
	public static void subarr_sum() {
		int[] nums = new int[] {2,3,1,2,4,3};
		int s=3;
		int start=0, end=0;
		int p1=0, sum=0, min=Integer.MAX_VALUE;
		for(int p2=0;p2<nums.length;p2++) {
			sum+=nums[p2];
			while(sum>=s) {
				//min=Math.min(min, p2+1-p1);
				if(min>p2+1-p1 && sum==s) {
					min=p2+1-p1;
					start=p1;
					end=p2;
				}
				sum-=nums[p1];
				p1++;
			}
		}
		System.out.println("Minimum Size Subarray Sum:"+min);
		System.out.println("Start:"+start+" end:"+end);
	}
	//5. Longest Palindromic Substring : runtime:O(n^2) space:O(1)
	//(a)expand around center
	static int lo=0, max=0;
	static int count=0;
	public static void palindromicSubString() {
		String s = "abaq";
		for(int i=0;i<s.length();i++) {
			extend(s, i,i);
			extend(s, i, i+1);
		}
		System.out.println("extend @center:Palindromic Substring:"+s.substring(lo,  lo+max+1));
		System.out.println("Palindromic Substring: count:"+count);
	}
	public static void extend(String s, int start, int end) {
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
			start--; end++;
			count++;
		}
		start++; end--;
		if(max<end-start) {
			lo=start;
			max=end-start;
		}
	}
	//(b)LongestPalindromicSubString-dynamic programming: runtime:O(n^2) space:O(n^2)
	public static void lpsub() {
		String s = "cbbd";
		int start=0, end=0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--) {
			dp[i][i]=true;
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])) {
					dp[i][j]=true;
					start=i;
					end=j;
				}else
				 	dp[i][j]=false;
			}
		}
		System.out.println("Longest Palindromic Substring_DP:"+s.substring(start, end+1)+" size:"+(end-start+1));
	}

	//516. Longest Palindromic Subsequence: runtime:O(n^2) space:O(n^2)
	public static void lpseq() {
		String s = "agbdba";
		int[][] dp = new int[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--) {
			dp[i][i]=1;
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j))
					dp[i][j]=dp[i+1][j-1]+2;
				else
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		System.out.println("Longest Palindromic Subsequence:"+dp[0][s.length()-1]);
	}
	/*     a g b d b a
	 *   # 0 1 2 3 4 5
	 * a 0 1 1 1 1 3 5  <-ans:dp[0][s.length()]
	 * g 1   1 1 1 3 3 
	 * b 2     1 1 3 3
	 * d 3       1 1 1
	 * b 4         1 1
	 * a 5           1 <- start here 
	 */
	//Longest Common Substring
	public static void LongestCommonSubstring() {
		String b="abcd", a="abcui";
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++) {
			for(int j=0;j<=b.length();j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1)) {
						dp[i][j]=dp[i-1][j-1]+1;
						max=Math.max(max, dp[i][j]);
				}else
					dp[i][j]=0;
			}
		}
		System.out.println("Longest Common Substring:"+max);
	}
	//Longest Common Subsequence
	public static void longestCommonSeq() {
		String a = "abcd", b="aebd";
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++) {
			for(int j=0;j<=b.length();j++) {
				if(i==0||j==0)
					dp[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println("Longest Common Subsequence:"+dp[a.length()][b.length()]);
	}
	//one edit distance
	public static void edit() {
		String a="dog", b="bog";
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++) {
			for(int j=0;j<=b.length();j++) {
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+1; //consider dp[i-1][j-1] for replace
					
			}
		}
		System.out.println("One Edit:"+dp[a.length()][b.length()]);
	}
	//Longest Common Prefix: RunTime=O(minLen*n) space=O(1)
	public static void longestCommonPrefix() {
		String[] strs = new String[] {"abc","abcko", "abcolp"};
		int min=Integer.MAX_VALUE;
		for(String s:strs)
			min=Math.min(min, s.length());
		String res=strs[0].substring(0, min);
		for(int i=0;i<min;i++) {
			for(int j=0;j<strs.length-1;j++) {
				String s1=strs[j];
				String s2=strs[j+1];
				if(s1.charAt(i)!=s2.charAt(i))
					res=s1.substring(0, i);
			}
		}
		//res=res==null?strs[0].substring(0, min):res;
		System.out.println("longestCommonPrefix:"+res);
	}
}
