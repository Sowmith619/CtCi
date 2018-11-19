package java_basic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Priorityqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p_queue();
		p_queue2();
		test_treeMap();
	}
	static class comparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg1.compareTo(arg0);
		}
		
	}
	public static void p_queue() {
		PriorityQueue<String> pQueue=new PriorityQueue<>(new comparator());
		pQueue.add("AA");
		pQueue.add("ZZ");
		pQueue.add("YY");
		pQueue.add("CC");
		pQueue.add("BB");
		
		
		for(String s:pQueue)
			System.out.println(s);
		
		Iterator itr = pQueue.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	public static void p_queue2() {
		PriorityQueue<String> pQueue = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String a, String b) {
				return -a.compareTo(b);
			}
		});
		pQueue.add("AA");
		pQueue.add("ZZ");
		pQueue.add("YY");
		pQueue.add("CC");
		pQueue.add("BB");
		System.out.println("pqueue_2");
		for(String s:pQueue)
			System.out.println(s);
	}
	public static void test_treeMap() {
		//No ordering, null is allowed
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Mon", 1);
		map.put("Wed", 3);
		map.put("Fri", 5);
		System.out.println("HashMap:"+map);
		//insertion order maintained
		LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();
		map2.put("Mon", 1);
		map2.put("Wed", 3);
		map2.put("Fri", 5);
		System.out.println("LinkedHashMap:"+map2);
		//natural ordering or comparator ordering
		TreeMap<String, Integer> map3 = new TreeMap<>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		map3.put("Mon", 1);
		map3.put("Wed", 3);
		map3.put("Fri", 5);
		System.out.println("TreeMap:"+map3);
		for(Map.Entry<String, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		

	}

}
