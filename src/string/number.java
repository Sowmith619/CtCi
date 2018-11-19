package string;

import java.util.ArrayList;
import java.util.List;

public class number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNumbers();
	}
	public static void createNumbers() {
		int num = 83405, k=1;;
		List<Integer> list = new ArrayList<>();
		while(Math.pow(num%10,k)!=0) {
			k = num%100 - num%10;
			list.add(k);
		}
		System.out.println(k);
	}

}
