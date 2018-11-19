import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class data_structure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("Set:" + set);
		System.out.println("List:" + list);

		System.out.println(set.contains(5));

		System.out.println(list.contains(5));
		System.out.println(list.get(1));
		set.remove(1);
		System.out.println("Set:" + set);
	}

}
