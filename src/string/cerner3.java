package string;

import java.util.HashMap;
import java.util.Map;

public class cerner3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lpsub_manacher();
		longestSubstringWithoutRepeatingCharacters();
		longestSubstringWithAtMost_K_distinctCharacters();
		longestSubstringwithAtLeast_K_repeatingCharacters();
	}
	/* (c)Manacher's Algorithm: linear time
	 * [X]case1:new palindrome is Totally contained under curr palindrome
	 * [X]case2:curr Palindrome expands till end of input
	 * [GO]case3:new Palindrome expands till rightEdge & 
	 *           its mirror palindrome is prefix for curr palindrome[pick this char as center]
	 * [X]case4:new Palindrome expands till right edge & its mirror expands beyond left
	 * To handle even size palindrome input '$' intermittently
	 * */
	public static void lpsub_manacher() {
		String s = "baaabad";
		int index=0;
		char newInput[] = new char[2*s.length()+1];
		for(int i=0;i<newInput.length;i++) {
			if(i%2!=0)
				newInput[i]=s.charAt(index++);
			else
				newInput[i]='$';
		}
		
		int[] res = new int[newInput.length];
		int i=0, start=0, end=0;
		//here i is the center.
		while(i<newInput.length) {
			//expand around i. See how far we can go.
			while(start>0 && end<newInput.length-1 && newInput[start-1]==newInput[end+1]) {
				start--;
				end++;
			}
			//set the longest value of palindrome around center i at res[i]
			res[i]=end-start+1;
			//case 2. Current palindrome is proper suffix of input. No need to proceed, break out.
			if(end==res.length-1)
				break;
			//Mark newCenter based even or old number input.
			int newCenter = end+(i%2==0?1:0);
			
			for(int j=i+1;j<=end;j++) {
	            //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. 
				//So take minimum of either left side palindrome or distance of j to end.
				res[j]=Math.min(res[i-(j-i)], 2*(end-j)+1);
                //Only proceed if we get case3. This check makes sure we do not pick j as new center for case1/case4
                //As soon as we find a center lets break out of this inner while loop.
				if(res[i-(j-i)]/2 ==end-j) {
					newCenter = j;
					break;
				}
			}
			//make i as newCenter. Set right & left to atleast the value 
			//we already know should be matching based of left side palindrome.
			i=newCenter;
			end=i+res[i]/2;
			start=i-res[i]/2;
		}
		int max = Integer.MIN_VALUE, pt=0;
		for(int k=0;k<res.length;k++) {
			int val;
			val = res[k]/2;
			if(max<val) {
				max=val;
				pt=k/2;
			}				
		}
		int low = pt-max/2;
		int hi = max%2==0?pt+max/2-1:pt+max/2;
		System.out.println("max:"+max+" pt:"+pt);
		System.out.println("Manacher's Algorithm: linear time:max:"+max +" substring:"+s.substring(low, hi+1));
		System.out.println();
	}
	//3	Longest Substring Without Repeating Characters 
	// [i,j] --> [i, j', j] => [j'+1, j]
	public static void longestSubstringWithoutRepeatingCharacters() {
		String s = "HelloWorld";
		Map<Character, Integer> map = new HashMap<>();
		int j=0, max=0;
		String res="";
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i)))
				j = Math.max(j, map.get(s.charAt(i))+1);
			map.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
			/*if(max<i+1-j) {
				max = i+1-j;
				res = s.substring(j, i+1);
			}*/
		}
		System.out.println("longestSubstringWithoutRepeatingCharacters: max:"+max+" str:"+res);
	}
	//	340	Longest Substring with At Most K Distinct Characters 
	public static void longestSubstringWithAtMost_K_distinctCharacters() {
		String s = "HelloWorld";
		int k=2;
		if(s==null || s.length()==0 || k<=0) {
			System.out.print("No LongestSubstringWith_K_uniqueChar");
			return;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		int i=0, j=0, max=0; //i:tail  j:head
		String res="";
		for(i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
			
			if(map.size()>k) {
				max = Math.max(max, i-j); //take res = s.substring(j, i);
				while(map.size()>k) {
					char c = s.charAt(j);
					if(map.get(c)==1) {
						map.remove(c);
					}else {
						map.put(c, map.get(c)-1);
					}
					j++;
				}
			}
			if(j<s.length()) {
				max = Math.max(max, i-j);
			}
		}
				
		System.out.println("LongestSubstringWith_K_uniqueChar K:"+k+" maxLen:"+max+" str:"+res);
	}
	//395. Longest Substring with At Least K Repeating Characters
	public static void longestSubstringwithAtLeast_K_repeatingCharacters() {
		String s = "aaabb";
		int k=3;
		
		char[] str = s.toCharArray();
		int start=0, end=s.length();
		int res = helper(str, start, end, k);
		System.out.println("longestSubstringwithAtLeast_K_repeatingCharacters: "+res);
	}
	public static int helper(char[] str, int start, int end, int k) {
		if(end-start<k) {
			//System.out.println("longestSubstringwithAtLeast_K_repeatingCharacters Not exist");
			return 0;
		}
		int[] count = new int[26];
		for(int i=start;i<end;i++) {
			int index = str[i]-'a';
			count[index]++;
		}
		for(int i=0;i<26;i++) {
			if(count[i]<k && count[i]>0) {
				for(int j=start;j<end;j++) {
					if(str[j]==i+'a') {
						int left = helper(str, start, j, k);
						int right = helper(str, j+1, end, k);
						return Math.max(left, right);
					}
				}
			}
		}
		return end-start;
	}

}
