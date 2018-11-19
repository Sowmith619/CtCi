package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable {
	//using the Student class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(101, "Alice", 23));
		list.add(new Student(102, "Jack", 24));
		list.add(new Student(103, "Rose", 20));
		
		//Collections.sort(list);
		for(Student s:list) {
			System.out.println(s.roll+":"+s.name+":"+s.age);
		}
		System.out.println((int)'A'+":"+(int)'Z');
		
	}

}
