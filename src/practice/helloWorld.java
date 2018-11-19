package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class helloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		bracket();
		isValidParenthesis();
	}
	public static void test() {
		String str = "Hello World! Hello!";
		List<String> list = Arrays.asList(str.split(" "));
		System.out.println(list.size());
		for(String n:list)
			System.out.println(n);
		
	}
	//check if the brackets correctly match
	//find min num of brackets you need to add to the input to make it balanced
	public static void bracket() {
		String text = ")(()))";
		int sum=0, negCount=0;
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)=='(')
				sum++;
			else if(text.charAt(i)==')' && sum>0)
				sum--;
			else if(text.charAt(i)==')' && sum<=0)
				negCount++;
		}
		sum+=negCount;
		System.out.println("sum:"+sum);
	}
	public static void isValidParenthesis() {
		String s = "()[]{}()";
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') stack.push(')');
			else if(s.charAt(i)=='[') stack.push(']');
			else if(s.charAt(i)=='{') stack.push('}');
			else if(stack.isEmpty() || s.charAt(i)!=stack.pop()) {
				System.out.println("isValidParenthesis: False");
				return;
			}
		}
		System.out.println("isValidParenthesis:"+stack.isEmpty());
	}

}
