package com;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find_arr obj = new find_arr();
		int[] in = new int[] {1,1,1};
		int[] res = obj.arr(in);
		for(int i:res) {
			System.out.println(i);
		}
	}
	public int[] arr(int[] in) {
		List<Integer> sel = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i:in) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else
				map.put(i, 1);
		}
		
		for(Map.Entry<Integer, Integer> elem : map.entrySet()) {
			if(elem.getValue()==1)
				sel.add(elem.getKey());
		}
		int[] res = new int[sel.size()];
		int j=0;
		for(int i:sel) {
			res[j]=i;
			j++;
		}
		return res;
	}

}
