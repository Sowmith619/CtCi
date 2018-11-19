package java_basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class enum_ex {
	public enum Level{
		High, Medium, Low;
	}
	public enum Level2{
		High(3), Medium(2), Low(1);
		
		final int levelCode;
		Level2(int levelCode) {
			this.levelCode=levelCode;
		}
		public int getLevelCode() {
			return this.levelCode;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level l = Level.High;
		System.out.println(l);
		
		Level2 l2=Level2.Low;
		System.out.println(l2+":"+l2.getLevelCode());
		
		list_ex();
		
	}
	public static void list_ex() {
		List<Integer> list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
		}
		System.out.println(list.size());
	}

}
