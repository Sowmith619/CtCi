package java_basic;

import java_basic.MyHashMap.Entry;

class MyHashMap{
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];
	
	class Entry{
		final String key;
		String value;
		Entry next;
		Entry(String k, String v) {
			key=k;
			value=v;
		}
		public String getValue() {
			return value;
		}
		public String getKey() {
			return key;
		}
		public void setValue(String v) {
			value=v;
		}
	}
	public Entry get(String k) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];
		
		while(e!=null) {
			if(e.key.equals(k)) {
				return e;
			}
			e=e.next;
		}
		return null;
	}
	public void put(String k, String v) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];
		if(e!=null) {
			if(e.key.equals(k))
				e.value=v;
			else {
				while(e.next!=null) {
					e=e.next;
				}
				Entry entryInOldBucket = new Entry(k,v);
				e.next = entryInOldBucket;
			}
		}else {
			Entry entryInNewBucket = new Entry(k,v);
			table[hash] = entryInNewBucket;
		}
	}
}
public class HashMap_impl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");

        Entry e = myHashMap.get("Awadh");
        System.out.println(""+e.getValue());
	}

}
