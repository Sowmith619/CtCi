package practice;

import java.util.HashMap;

class Key{
	String key;
	Key(String key){
		this.key=key;
	}
	@Override
	public int hashCode() {
		int hash = (int) key.charAt(0);
		System.out.println("HashCode for key:"+key+"="+hash);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		return key.equals(((Key)obj).key);
	}
	
}
public class cloudera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testHashMap();
	}
	public static void testHashMap() {
		HashMap map = new HashMap<>();
		map.put(new Key("Tom"), 20);
		map.put(new Key("Jill"), 25);
		map.put(new Key("Jack"), 24);
        System.out.println();
        System.out.println("Value for key Tom: " +
                            map.get(new Key("Tom")));
        System.out.println("Value for key Jill: " +
                            map.get(new Key("Jill")));
	}

}
