package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class arr {
	//majority number: return the majority number in an arr
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		majority();
		majority2();
		
		wordDistance();
		wordDistance2();
		wordDistance3();
		
		rearrangeString();
	}
	//runs in O(N) time and 0(1) space.
	public static void majority() {
		int[] arr = new int[] {1,6,7,1,2,1,3,1,2,1,1};
		int majority=0, count=0;
		for(int n:arr) {
			if(n==majority)
				count++;
			else if(count==0) {
				majority=n;
				count++;
			}else
				count--;
			//System.out.println(majority+" count: "+count);
		}
		//verify occurance > [n.len/2]
		count=0;
		for(int n:arr)
			if(majority==n)
				count++;
		if(count>arr.length/2)
			System.out.println("Majority="+majority);
		else
			System.out.println("No Majority");
	}
	//find majority num more than [n/3]
	public static void majority2() {
		int[] arr = new int[] {3,3,3,1,1,1,2,1,3};
		int m1=0, count1=0, m2=0, count2=0;
		for(int n:arr) {
			if(n==m1) {
				count1++;
			}else if(n==m2) {
				count2++;
			}else if(count1==0) {
				m1=n;
				count1++;
			}else if(count2==0) {
				m2=n;
				count2++;
			}else {
				count1--;
				count2--;
			}
		}
		//verify
		count1=0; count2=0;
		for(int n:arr) {
			if(n==m1)
				count1++;
			else if(n==m2)
				count2++;
		}
		if(count1>arr.length/3)
			System.out.print("Majority2: "+m1+" - ");
		if(count2>arr.length/3)
			System.out.print(m2+"\n");
	}
	//Word distance: find the shortest distance between words[given] in a given string array
	public static void wordDistance() {
		String[] words = new String[] {"aa","dd", "cc", "bb", "dd","aa"};
		String word1="aa";
		String word2="bb";

		int dist1=-1, dist2=-1;
		int res=Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++) {
			String s = words[i];
			if(s.equals(word1)) {
				dist1=i;
				if(dist2!=-1) {
					res=Math.min(res, dist1-dist2);
				}
			}else if(s.equals(word2)) {
				dist2=i;
				if(dist1!=-1) {
					res=Math.min(res, dist2-dist1);
				}
			}
		}
		System.out.println("Shorted Word Distance:"+res);
	}
	//Word_distance2: if this has to be repeated multiple times
	//To make repeted call to shortest, the result can be saved to a ArrayList
	public static void wordDistance2() {
		String[] words = new String[] {"aa","dd", "cc", "bb", "dd","aa"};
		String word1 = "aa";
		String word2 = "bb";
		
		HashMap<String, List<Integer>> map = new HashMap<>();
		for(int i=0;i<words.length;i++) {
			if(map.containsKey(words[i]))
				map.get(words[i]).add(i);
			else {
				List<Integer> temp = new LinkedList<>();
				temp.add(i);
				map.put(words[i], temp);
			}
		}
		System.out.println("wordDistance2:"+map);
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int res = Integer.MAX_VALUE;
		int i=0, j=0;
		while(i<l1.size() && j<l2.size()) {
			res = Math.min(res, Math.abs(l1.get(i)-l2.get(j)));
			if(l1.get(i)<l2.get(j))
				i++;
			else
				j++;
		}
		System.out.println("WordDistance2:"+res);
	}
	//Word_distance3: if the words are same
	//Same as word_distance1, but extra code for isSame
	public static void wordDistance3() {
		String[] words = new String[] {"aa","dd", "cc", "bb", "dd","aa"};
		String word1 = "aa";
		String word2 = "aa";
		
		int dist1=-1, dist2=-1;
		int prev=-1;
		boolean isSame = word1.equals(word2);
		int res = Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++) {
			String s = words[i];
			if(isSame) {
				if (s.equals(word1)) {
					if (prev != -1)
						res = Math.min(res, i - prev);
					prev = i;
				}
			}else {
				if(s.equals(word1)) {
					dist1=i;
					if(dist2!=-1)
						res = Math.min(res, Math.abs(dist1-dist2));
				}else if(s.equals(word2)) {
					dist2=i;
					if(dist1!=-1)
						res = Math.min(res, Math.abs(dist1-dist2));
				}
			}
		}
		System.out.println("WordDistance3:"+res);
	}
	//Rearrange String k Distance Apart: Given a non-empty string str and an integer k, 
	//rearrange the string such that the same chars are at least distance k from each other.
	public static void rearrangeString() {
		String str = "aaabdbbccc";
		int k=2;
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		System.out.println("rearrangeString:"+map);
		//sort the chars by frequency
		PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				if(map.get(c1) != map.get(c2))
					return map.get(c2)-map.get(c1);
				else
					return c1.compareTo(c2);
			}
		});
		for(char c:map.keySet())
			queue.offer(c);
		
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		while(!queue.isEmpty()) {
			int count = Math.min(k, len);
			ArrayList<Character> temp = new ArrayList<>();
			for(int i=0;i<count;i++) {
				if(queue.isEmpty()) {
					System.out.println("");
					return;
				}
				
				char c = queue.poll();
				sb.append(String.valueOf(c));
				map.put(c, map.get(c)-1);
				if(map.get(c)>0)
					temp.add(c);
				len--;
			}
			for(char c:temp)
				queue.offer(c);
		}
		System.out.println("rearrangeString:"+sb.toString());
	}
}
