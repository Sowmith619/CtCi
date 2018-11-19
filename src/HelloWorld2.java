import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HelloWorld2 {
	public void finalize() {// System.out.println("object is garbage collected");

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// test();
		// display();
		string();

	}

	public static void string() {
		String s = "HelloWorld";
		System.out.println(s.substring(2));
	}

	public static void test() {
		System.out.println("HelloWorld2!!");
		display();
		HelloWorld2 h1 = new HelloWorld2();
		HelloWorld2 h2 = new HelloWorld2();
		h1 = null;
		h2 = null;
		System.gc(); // reclaim unused runtime memory
		// Runtime.getRuntime().exec("notepad");
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println("Total Mem" + Runtime.getRuntime().totalMemory());
		System.out.println("Free Mem" + Runtime.getRuntime().freeMemory());
		for (int i = 0; i < 100000; i++)
			new HelloWorld2();
		System.out.println("After Total Mem" + Runtime.getRuntime().totalMemory());
		System.out.println("After Free Mem" + Runtime.getRuntime().freeMemory());
		System.gc(); // reclaim unused runtime memory
		System.out.println("After GC Total Mem" + Runtime.getRuntime().totalMemory());
		System.out.println("After GC Free Mem" + Runtime.getRuntime().freeMemory());

		char[] c = new char[] { '1', 'a', 'b', 'c' };
		int[] n = new int[] { 1, 7, 3, 9 };
		int num = 99;
		String s = "Heloo";
		System.out.println(s.isEmpty());
		String st = "He";
		char ch = 'e';
		char[] ch2 = new char[] { 'H', 'e' };
		System.out.println(String.valueOf(c));
		System.out.println(String.valueOf(num));
		System.out.println(new String(ch2));
		System.out.println(Arrays.toString(c));
		String temp = Arrays.toString(c);

		System.out.println(temp);
		System.out.println(s.toString());

		System.out.println(s.contains(st));
		String k = "9990";
		System.out.println("str-->int : " + Integer.valueOf(k));

		System.out.println("abs diff : " + Math.abs(-1 - (-1)));

		String s1 = "Welcome, HelloWorld", s2 = "z";
		System.out.println(s1.indexOf(s2));

		List<String> list = new LinkedList<>();
		list.add("10");
		list.add("20");
		list.add("30");
		String[] arr = list.toArray(new String[list.size()]);
		for (String str : arr)
			System.out.println(str);

	}

	public static void display() {
		System.out.println("Displayed from static function \"display\"");
		System.out.println("HelloWorld2");

		int[] arr = new int[] { 1, 5, 4, 2, 3 };
		Arrays.sort(arr);

		int n = 1;
		System.out.println(++n);

	}

}
