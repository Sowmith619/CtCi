package java_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

class MyMap {
	class Container{
		Object key;
		Object value;
		public void insert(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	private List<Container> recordList;
	public MyMap() {
		this.recordList = new ArrayList<Container>();
	}
	public void put(Object k, Object v) {
		Container c = new Container();
		c.insert(k, v);
		//remove old and insert new
		for(int i=0;i<recordList.size();i++) {
			Container c1 = recordList.get(i);
			if(c1.key.equals(k)) {
				//remove existing object
				recordList.remove(i);
				break;
			}
		}
		recordList.add(c);
	}
	public Object get(Object k) {
		for(int i=0;i<this.recordList.size();i++) {
			Container con = recordList.get(i);
			if(k.toString() == con.key.toString())
				return con.value;
		}
		return null;
	}
}

public class Map_impl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMap map = new MyMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		System.out.println(map.get("3"));
		map.put("3", "4");
		
		System.out.println(map.get("1"));
		System.out.println(map.get("3"));
		System.out.println(map.get("8"));
	}

}
