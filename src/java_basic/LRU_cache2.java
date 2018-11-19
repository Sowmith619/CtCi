package java_basic;

import java.util.LinkedHashMap;

public class LRU_cache2 {
	
	LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	int size;
	LRU_cache2(int size){
		this.size=size;
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			int value = map.remove(key);
			map.put(key, value);
			return value;
		}
		return -1;
	}
	public void put(int key, int value) {
		if(map.containsKey(key))
			map.remove(key);
		else if(map.size()+1>size)
			map.remove(map.keySet().iterator().next());
		map.put(key, value);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU_cache2 obj = new LRU_cache2(5);
		obj.put(1,11);
		obj.put(2, 22);
		obj.put(3, 33);
		obj.put(4, 44);
		obj.put(5, 55);
		obj.put(6, 66);
		System.out.println(obj.get(2));
	}
}
