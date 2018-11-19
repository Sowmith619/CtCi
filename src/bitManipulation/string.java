package bitManipulation;

import java.util.HashMap;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count_say();
		compress();
		letters_numbers();
	}
	public static void count_say() {
		int n=10;
		
		StringBuilder curr=new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		
		for(int i=1;i<n;i++) {
			System.out.println(i+":Count & Say:"+curr.toString());
			prev=curr;
			curr=new StringBuilder();
			count=1;
			say=prev.charAt(0);
			for(int j=1;j<prev.length();j++) {
				if(say!=prev.charAt(j)) {
					curr.append(count).append(say);
					count=1;
					say=prev.charAt(j);
				}else {
					count++;
				}
			}
			curr.append(count).append(say);
		}
		System.out.println("10:Count & Say:"+curr.toString());
	}
	public static void compress() {
		String str = "HelloWorld!!!";
		
		char[] chars = str.toCharArray();
		int index=0, indexAns=0;
		while(index<chars.length) {
			char currChar = chars[index];
			int count=0;
			while(index<chars.length && currChar==chars[index]) {
				index++;
				count++;
			}
			chars[indexAns++]=currChar;
			if(count>1)
				for(char c:String.valueOf(count).toCharArray())
					chars[indexAns++]=c;
		}
		System.out.println("\nCompress:");
		for(int i=0;i<indexAns;i++)
			System.out.print(chars[i]);
		System.out.println();
	}
	//max subarray with equal num of letter & digit
	//1)compute delta arr with diff
	//2)find pair in delta arr with matching value & largest span
	//3)return subarr (p1+1,p2)
	public static void letters_numbers() {
		String str = "Hello2018World2018";
		
		//Generate the delta arr
		int[] delta = new int[str.length()];
		int diff=0;
		for(int i=0;i<str.length();i++) {
			if(Character.isAlphabetic(str.charAt(i)))
				diff++;
			else if(Character.isDigit(str.charAt(i)))
				diff--;
			delta[i]=diff;
		}
		//find the max span
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int p1=0, p2=0;
		for(int i=0;i<delta.length;i++) {
			if(!map.containsKey(delta[i])) {
				map.put(delta[i],i);
			}else {
				int match = map.get(delta[i]);
				int distance = i-match;
				if(distance>(p2-p1)) {
					p1=match;
					p2=i;
					
				}
			}
		}
		//res [p1+1, p2]
		System.out.println("\nletters_numbers:"+str.substring(p1+1, p2+1));
	}
}
