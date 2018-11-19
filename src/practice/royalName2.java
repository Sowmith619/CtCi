package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class royalName2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Albert II","Polo IV","Alexander V","Elizabeth XXV",
				  "Albert XL","Polo XLVI","William IX","Edward XXXIX",
				  "Elizabeth XIX"};

		String[] sortedNames = sort(names);
		print(sortedNames);
	}
	public static String[] sort(String[] names) {
		TreeMap<String, TreeMap<Integer, Integer>> map = new TreeMap<>();
		for(int i=0;i<names.length;i++) {
			String name = names[i].split(" ")[0];
			String roman = names[i].split(" ")[1];
			int num = convertToNum(roman);
			if(map.containsKey(name)) {
				map.get(name).put(num, i);
			}else {
				TreeMap<Integer, Integer> temp = new TreeMap<>();
				temp.put(num, i);
				map.put(name, temp);
			}
		}
		int index=0;
		String[] ans = new String[names.length];
		for(String name:map.keySet()) 
			for(int number:map.get(name).keySet())
				ans[index++]=names[map.get(name).get(number)];
		return ans;
	}
	public static int convertToNum(String roman) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50); map.put('C', 100);
		int curr=0, prev=0, sum=0;
		for(int i=roman.length()-1;i>=0;i--) {
			curr = map.get(roman.charAt(i));
			if(curr>=prev)
				sum+=curr;
			else
				sum-=curr;
			prev=curr;
		}
		return sum;
	}
	public static void print(String[] names) {
		for(String s:names)
			System.out.println(s);
	}

}
