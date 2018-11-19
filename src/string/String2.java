package string;

public class String2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longest();
		palindromic();
		
		permutationOfString();
	}
	public static void longest() {
		String s = "Hello and welcome!";
		String[] words = s.split(" ");
		int max=Integer.MIN_VALUE;
		int temp=0;
		for(String w:words) {
			if(max<w.length()) {
				temp=max;
				max=w.length();
			}
				
		}
		System.out.println("Max Len:"+max);
		System.out.println("2nd Max Len:"+temp);
	}
	public static void palindromic() {
		int num=100;
		System.out.println(isPalindrome(10701));
		System.out.println(isPalindrome2("10001"));
		
	}
	public static boolean isPalindrome(int num) {
		int temp = num;
		int reverse=0;
		//take half and then compare
		while(num>reverse) {
			reverse = reverse*10 + num%10;
			num = num/10;
		}
		return num==reverse || num==reverse/10;
	}
	public static boolean isPalindrome2(String s) {
		int start=0, end=s.length()-1;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++; end--;
		}
		return true;
	}
	//find all permutation of String
	public static void permutationOfString() {
		String str = "abc";
		System.out.print("permutationOfString: ");
		backtrack(str,"");
	}
	public static void backtrack(String str, String prefix) {
		if(str.length()==0) {
			System.out.print(prefix+" ");
			return;
		}
		for(int i=0;i<str.length();i++) {
			String temp = str.substring(0, i)+str.substring(i+1);
			backtrack(temp, prefix+str.charAt(i));
		}
	}
}
