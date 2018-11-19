package java_basic;

import java.util.Arrays;

public class classRoom {

	public static void main(String[] args) {
		//Example of comparable interface
		// TODO Auto-generated : Name | grade | gpa
		//Student.init();
		Student s1 = new Student("Joe", 12, 3.5);
		Student s2 = new Student("Bob", 9, 3.4);
		
		//java.lang.Comparable: compareTo example
		Student[] sArr = new Student[4];
		sArr[0] = new Student("Mikey", 25, 2.0);
		sArr[1] = new Student("Arun", 29, 1.0);
		sArr[2] = new Student("Lisa", 32, 4.0);
		sArr[3] = new Student("Pankaj", 35, 3.0);
		Arrays.sort(sArr);
		System.out.println("java.lang.Comparable:Default Sorting of Student list:\n"+Arrays.toString(sArr));
		
		// java.util.Comparator
		//sort Student array using Comparator by Salary
		Arrays.sort(sArr, Student.NameComparator);
		System.out.println("java.util.Comparator:Student list sorted by Name:\n"+Arrays.toString(sArr));

		//sort Student array using Comparator by Age
		Arrays.sort(sArr, Student.GradeComparator);
		System.out.println("java.util.Comparator:Student list sorted by Grade:\n"+Arrays.toString(sArr));

		//sort Student array using Comparator by Name
		Arrays.sort(sArr, Student.GpaComparator);
		System.out.println("java.util.Comparator:Student list sorted by GPA:\n"+Arrays.toString(sArr));
		
		//sort Student array using Comparator by Name
		Arrays.sort(sArr, new sortByGradeOrName());
		System.out.println("java.util.Comparator:sortByGradeOrName:\n"+Arrays.toString(sArr));
				
		//comparator implemented as a separate class
		String a="aello";
		String b="fello";
		System.out.println("CompareTo in String "+a.compareTo(b));
		
		System.out.println("CompareTo return "+s1.compareTo(s2));
		int result = s1.compareTo(s2);
		//ascending
		if(result<0)
			System.out.println(s1.getName()+" comes before "+ s2.getName());
		else if(result>0)
			System.out.println(s2.getName()+" comes before "+ s1.getName());
		else
			System.out.println(s1.getName() +" equals "+s2.getName());
		int[] arr = {1,2,3,4,10};
		;
		System.out.print(g(arr));
	}
	static int x=0;
	public static void f() {
		x++;
	
	}
	public static int g(int[] arr) {
		/*int sum=0;
		for(int i=0;i<18;i+=3)
			sum+=i;
		System.out.print(sum);*/
		return arr[1];
	}

}
