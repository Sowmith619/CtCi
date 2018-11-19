package practice;

public class Student{
	int roll;
	String name;
	int age;
	public Student(int roll, String name, int age ){
		this.roll=roll;
		this.name=name;
		this.age=age;
	}
	public int compareTo(Student st) {
		if(age==st.age)
			return 0;
		else if(age>st.age)
			return 1;
		else
			return -1;
	}
}
