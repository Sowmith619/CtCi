import static org.testng.Assert.assertEquals;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4 };
		call_array(arr[0], arr);
		System.out.println(arr[0] + "," + arr[1]);

		String s = "a5";
		System.out.println(Pattern.matches("[a-z][0-9]", s));
		System.out.println(Pattern.matches("^aa*[0-9]", s));
		System.out.println(s.matches("[a-z]{1,}."));
		System.out.println(s.matches("[a-z][0-9]"));
	}

	static void call_array(int i, int[] arr) {
		arr[i] = 6;
		i = 5;
	}

}
