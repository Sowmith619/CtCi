package CtCi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayString {
	public static void main(String[] args) {
		isUnique();
		checkPermutation();
		urlify();
		oneAway();
		compression();
		rotateMatrix();
		spiralMatrix();
		zeroMatrix();
	}
	//[1.1]Check isUnique: time O(n); space O(1) as the loop will not iterate over more than 128 character
	public static void isUnique() {
		String s = "Holla";
		int[] alpha = new int[126];
		for(char c:s.toCharArray()) {
			alpha[c]++;
			if(alpha[c]>1) {
				System.out.println("Not Unique");
				return;
			}
		}
		System.out.println("Is Unique");		
	}
	//[1.2]Check Permutation
	public static void checkPermutation() {
		int[] alpha = new int[26];
		String s1 = "god", s2="dog";
		//Soln 1:
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(s1.toCharArray());
		Arrays.sort(s2.toCharArray());
		boolean result = ch1.toString().equals(ch2.toString());
		System.out.println("Permutation:"+ result);
		//soln 2:
		for(char c:s1.toCharArray())
			alpha[c-'a']++;
		for(char c:s2.toCharArray())
			alpha[c-'a']--;
		for(int n:alpha) {
			if(n!=0) {
				System.out.println("Not a Permutation");
				return;
			}
		}
		System.out.println("Is a permutation");
	}
	//[1.3]URLify: add '%20' inplace of ' ' in a string
	public static void urlify() {
		String s = "Hello World  ";
		char[] c = s.toCharArray();
		int trueLen = 10, i=s.length()-1;
		while(i>=0) {
			if(c[trueLen]==' ') {
				c[i]='0';
				c[i-1]='2';
				c[i-2]='%';
				i=i-3;
				trueLen--;
			}else {
				c[i]=s.charAt(trueLen);
				trueLen--;		
				i--;
			}
		}
		System.out.println("String:"+ String.valueOf(c));
	}
	//[1.5] one away: find if a string is one edit or 
	public static void oneAway() {
		String s1="pale", s2="palb";
		if(s1.length()==s2.length()) {
			System.out.println("oneAway-One Edit Replace:"+oneEditReplace(s1, s2));
		}else if(s1.length()>s2.length()) {
			System.out.println("oneAway-One Edit Insert:"+oneEditInsert(s1, s2));
		}else if(s1.length()<s2.length()) {
			System.out.println("oneAway-One Edit Insert:"+oneEditInsert(s2, s1));
		}
	}
	public static boolean oneEditReplace(String s1, String s2) {
		boolean diffFound = false;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				if(diffFound)
					return false;
				diffFound = true;
			}
		}
		return true;
	}
	public static boolean oneEditInsert(String s1, String s2) {
		if(s1.length() != s2.length()+1)
			return false;
		int index1=0, index2=0;
		while(index1<s1.length() && index2<s2.length()) {
			if(s1.charAt(index1)!=s2.charAt(index2)) {
				if(index1!=index2)
					return false;
				index1++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	//[1.6] string compression: aaabb -> a3b2
	public static void compression() {
		String s = "aaabb";
		char[] chars = s.toCharArray();
		int index=0, indexAns=0;
		while(index < chars.length) {
			char ch = s.charAt(index);
			int count = 0;
			while(index<s.length() && ch == chars[index]) {
				index++;
				count++;
			}
			chars[indexAns++] = ch;
			if(count>1) {
				for(char c: String.valueOf(count).toCharArray()) {
					chars[indexAns++] = c;
				}
			}
		}
		
		System.out.println("Compressed String:"+String.valueOf(chars));
		System.out.println("Len:"+indexAns);
	}
	//[1.7] Rotate Matrix
	public static void rotateMatrix() {
		int[][] mat = {	{1,1,1}, 
						{0,0,0}, 
						{1,1,1}};
		System.out.println("Rotate Matrix: Input matrix");
		displayMatrix(mat);
		int n = mat.length;
		for(int layer=0;layer<n/2;layer++) {
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<=last;i++) {
				int offset = i-first;
				int top = mat[i][first];
				mat[i][first] = mat[last-offset][first];
				mat[last-offset][first] = mat[last][last-offset];
				mat[last][last-offset] = mat[last][i];
				mat[last][i] = top;
			}
		}
		System.out.println("Rotate Matrix: Using offset");
		displayMatrix(mat);
		
		//Method 2:rotate 90 Transpose -> Flip
		//rotate 180  Transpose -> Flip -> Transpose -> Flip
		mat = new int[][] {{1,1,1}, {0,0,0}, {1,1,1}};
		
		for(int i=0;i<mat.length;i++) {
			for(int j=i;j<mat[0].length;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length/2;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][mat[0].length-1-j];
				mat[i][mat[0].length-1-j] = temp;
			}
		}
		
		System.out.println("Rotate Matrix: Using Transpose -> Flip ");
		displayMatrix(mat);
	}
	public static void displayMatrix(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+"  ");
			}
			System.out.print("\n");
		}
	}
	//Matrix: convert a matrix elements into a list in spiral order
	public static void spiralMatrix() {
		int[][] mat = new int[][] {{1,1,1}, {0,0,0}, {1,1,1}};
		
		List<Integer> res = new LinkedList<>( );
		int top=0, bottom=mat.length-1;
		int left=0, right=mat[0].length-1;
		
		while(top<=bottom && left<=right) {
			for(int i=left;i<=right;i++)
				res.add(mat[top][i]);
			top++;
			for(int i=top;i<=bottom;i++)
				res.add(mat[i][right]);
			right--;
			if(top<=bottom) {
				for(int i=right;i>=left;i--)
					res.add(mat[bottom][i]);
				bottom--;
			}
			if(right<=left) {
				for(int i=bottom;i<=top;i++)
					res.add(mat[i][top]);
				right++;
			}
		}
		System.out.println("Matrix Spiral:"+res);
	}
	//[1.8] ZeroMatrix
	public static void zeroMatrix() {
		int[][] mat = new int[][] {{1,1,1}, {1,0,1}, {1,1,1}};
		boolean fr=false, fc=false;
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j] == 0) {
					if(i==0) fc=true;
					if(j==0) fr=true;
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		for(int i=1;i<mat.length;i++) {
			for(int j=1;j<mat[0].length;j++) {
				if(mat[i][0]==0 || mat[0][j]==0)
					mat[i][j]=0;
			}
		}
		if(fr) {
			for(int i=0;i<mat[0].length;i++)
				mat[0][i]=0;
		}
		if(fc) {
			for(int i=0;i<mat.length;i++)
				mat[i][0]=0;
		}
		System.out.println("ZeroMatrix");
		displayMatrix(mat);
	}
}
