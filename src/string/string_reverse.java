package string;

import java.util.regex.Pattern;

public class string_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse();
		reverseVowels();
	}
	public static void reverse() {
		String str = "HelloWorld!!!";
		
		char[] ch = str.toCharArray();
		int p1=0, p2=str.length()-1;
		while(p1<p2) {
			char temp = ch[p1];
			ch[p1] = ch[p2];
			ch[p2] = temp;
			p1++; p2--;
		}
		System.out.println("Reverse="+String.valueOf(ch));
		//reverse only alphanumeric
		ch = str.toCharArray();
		p1=0; p2=str.length()-1;
		while(p1<p2) {
			if(!Character.isLetterOrDigit(str.charAt(p1))) {
				p1++;
			}else if(!Character.isLetterOrDigit(str.charAt(p2))) {
				p2--;
			}else {
				char temp = ch[p1];
				ch[p1] = ch[p2];
				ch[p2] = temp;
				p1++; p2--;
			}
		}
		System.out.println("Reverse2="+String.valueOf(ch));
		//using regex
		ch = str.toCharArray();
		p1=0; p2=str.length()-1;
		while(p1<p2) {
			if(Pattern.matches("[!,-/_]", ""+ch[p1]))
				p1++;
			else if((""+ch[p2]).matches("[!,-/_]"))
				p2--;
			else {
				char temp = ch[p1];
				ch[p1] = ch[p2];
				ch[p2] = temp;
				p1++; p2--;
			}
		}
		System.out.println("Reverse3 using regex="+String.valueOf(ch));
	}
	public static void reverseVowels() {
		String vowels = "aeiouAEIOU";
		String input = "HelloWorld, everyday is beautiful!";
		char[] ch = new char[input.length()];
		int index=0, p1=0, p2=input.length()-1;
		for(char c:input.toCharArray())
			ch[index++]=c;
		while(p1<p2) {
			while(p1<p2 && !vowels.contains(ch[p1]+""))
				p1++;
			while(p1<p2 && !vowels.contains(ch[p2]+""))
				p2--;
			if(p1<p2) {
				ch[p1]=input.charAt(p2);
				ch[p2]=input.charAt(p1);
				p1++;
				p2--;
			}
		}
		System.out.println("Reversed vowels string:"+String.valueOf(ch));
	}

}
