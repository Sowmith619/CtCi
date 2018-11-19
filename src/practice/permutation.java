package practice;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class permutation {

	public static void main(String[] args) {
		stringPermutation();
		permutationNum();
		genParen();
		paint();
	}
	public static void display(List<String> list) {
		int count=0;
		for(String s:list) {
			System.out.print(s+" ");
			count++;
			if(count==10) {
				count=0;
				System.out.println("");
			}
		}
		System.out.println("");
	}
	public static void stringPermutation() {
		System.out.println("String Permutation::");
		String str = "abc";
		List<String> list = new LinkedList<>();
		helper(list, str,"");
		display(list);
		
		helper2(str,"");
		System.out.println("\nhelper2 above");	
	}
	//String permutation
	public static void helper(List<String> list, String str, String prefix) {
		if(str.length()==0)
			list.add(prefix);
		else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0, i)+str.substring(i+1);
				helper(list, rem, prefix+str.charAt(i));
			}
		}
	}
	public static void helper2(String str, String prefix) {
		/*if(str.length()==0)
			System.out.print(prefix+"-");
		else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0, i)+str.substring(i+1);
				helper2(rem, prefix+str.charAt(i));
			}
		}*/
		if(str.length()==0) {
			System.out.print(prefix+"-");
		}else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0, i)+str.substring(i+1);
				helper2(rem, prefix+str.charAt(i));
			}
		}
	}
	//permutation	
	public static void permutationNum() {
		int[] nums = new int[] {1,2};
		List<List<Integer>> list = new LinkedList<>();
		backtrack(list, new LinkedList<>(), nums);
		System.out.println("Permutation:"+list);
	}
	public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
		if(temp.size()==nums.length)
			list.add(new LinkedList<>(temp));
		else {
			for(int i=0;i<nums.length;i++) {
				temp.add(nums[i]);
				backtrack(list, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}
	//22. Generate Parentheses
	public static void genParen() {
		int n=4;
		List<String> list = new LinkedList<>();
		backtrack(list, "", 0, 0, n);
		display(list);
	}
	public static void backtrack(List<String> list, String str, int open, int close, int max) {
		if(str.length()==2*max)
			list.add(str);
		else {
			if(open<max)
				backtrack(list, str+"(", open+1, close, max);
			if(close<open)
				backtrack(list, str+")", open, close+1, max);
		}
	}
	//paint 
	enum Color {Black, White, Red, Yellow, Green};
	public static void display(Color[][] screen) {
		for(int i=0;i<screen.length;i++) {
			System.out.println();
			for(int j=0;j<screen[0].length;j++) {
				System.out.print(screen[i][j]+" ");
			}
		}
	}
	public static void paint() {
		int n=2;
		Color[][] screen = new Color[n][n];
		Random rand = new Random();
		
		for(int i=0;i<n;i++) {
			System.out.println();
			for(int j=0;j<n;j++) {
				screen[i][j]=Color.values()[rand.nextInt(5)];
				//int val = (int)(Math.random()*5+0);
				//int val = rand.nextInt(5);
				double val = Math.random();
				System.out.println(val);
			}
		}
		display(screen);
		System.out.println("res:"+PaintFill(screen, 1,1,Color.Red));
		display(screen);
	}
	public static boolean PaintFill(Color[][] screen, int r, int c, Color nColor) {
		if(screen[r][c]==nColor) return false;
		return PaintFill(screen, r, c, screen[r][c], nColor);
	}
	public static boolean PaintFill(Color[][] screen, int r, int c, Color oColor, Color nColor) {
		if(r<0 || c<0 || r>=screen.length || c>=screen.length)
			return false;
		if(screen[r][c]==oColor) {
			screen[r][c]=nColor;
			PaintFill(screen, r+1, c, oColor, nColor);
			PaintFill(screen, r-1, c, oColor, nColor);
			PaintFill(screen, r, c+1, oColor, nColor);
			PaintFill(screen, r, c-1, oColor, nColor);
		}
		return true;
	}
}

