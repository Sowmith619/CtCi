package practice;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

public class proofpoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="O an example of negative num= 0 -100.";
		System.out.println("String isValid:"+isValid(str));
	}
	public static boolean isValid(String input) {
		if(input==null || input.length()==0) return false;
		
		String[] str = input.split(" ");
		//String starts with a capital letter
		char firstChar = input.charAt(0);
		if(!Character.isUpperCase(firstChar)) {
			return false;
		}
		//String has an even number of quotation marks
		String temp = input;
		int quotationCount = temp.length()-temp.replace("\"", "").length();
		if(quotationCount%2!=0) {
			return false;
		}
		//String ends with a period character “."
		char lastChar = input.charAt(input.length()-1);
		if(lastChar!='.') {
			return false;
		}		
		//String has no period characters other than the last character 
		temp = input;
		int periodCharCount = temp.length()-temp.replace(".", "").length();
		if(periodCharCount!=1) {
			return false;
		}
		//Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)
		List<String> listOfNum = new LinkedList<>();
		for(int k=0;k<13;k++) {
			listOfNum.add(String.valueOf(k));
		}
		for(int i=0;i<str.length;i++) {
			String word = str[i].replaceAll("[-+,.\"]", "").trim();
			//using list
			if(listOfNum.contains(word)) {
				return false;
			}
			//using regex
			/*if(word.matches("^[0-9]|1[0-2]$")) {
				return false;
			}*/
			
			//using iteration
			/*for(int num=0;num<13;num++) {
				if(word.equals(String.valueOf(num))) {
					return false;
				}
			}*/	
		}
		
		return true;
	}
	
	@Test
	public void testCases_valid() {
		//Valid Sentences
		String s1 = "The quick brown fox said “hello Mr lazy dog”.";
		String s2 = "The quick brown fox said hello Mr lazy dog.";
		String s3 = "One lazy dog is too few, 13 is too many.";
		String s4 = "One lazy dog is too few, thirteen is too many.";
		assertEquals(isValid(s1), true);
		assertEquals(isValid(s2), true);
		assertEquals(isValid(s3), true);
		assertEquals(isValid(s4), true);		
	}
	@Test
	public void testCases_inValid() {
		//InValid Sentences
		String s1 = "The quick brown fox said \"hello Mr. lazy dog\".";
		String s2 = "the quick brown fox said “hello Mr lazy dog\".";
		String s3 = "\"The quick brown fox said “hello Mr lazy dog.\"";
		String s4 = "One lazy dog is too few, 12 is too many.";
		assertEquals(isValid(s1), false);
		assertEquals(isValid(s2), false);
		assertEquals(isValid(s3), false);
		assertEquals(isValid(s4), false);
	}

}
