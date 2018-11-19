package java_basic;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	private String name;
	private int grade;
	private double gpa;
	
	public Student(String name, int grade, double gpa) {
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
	}
	
	public String getName() { return name; }
	public int getGrade() { return grade; }
	public double getGpa() { return gpa; }
	
	public boolean equals( Student other) {
		return this.getGrade() == other.getGrade();
	}
	public int compareTo(Student other) {
		return (int) (this.gpa-other.gpa);
	}
	public String toString() {
		return "[name=" + this.name + ", grade=" + this.grade + ", gpa=" + this.gpa + "]";
	}
	/*
	public int compareTo(Student other) {
		if(this.getGrade() > other.getGrade())
			return 1;
		else if(this.getGrade() < other.getGrade())
			return -1;
		else
			return 0;
	}*/
	/*
	public int compareTo(Student other) {
		if(this.getName().compareTo(other.getName()) > 0)
			return 1;
		else if(this.getName().compareTo(other.getName()) < 0)
			return -1;
		else
			return 0;
	}*/
	/**
     * Comparator to sort Students list or array in order of name
     */
    public static Comparator<Student> NameComparator = new Comparator<Student>() {

        @Override
        public int compare(Student e1, Student e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    /**
     * Comparator to sort Students list or array in order of Age
     */
    public static Comparator<Student> GradeComparator = new Comparator<Student>() {

        @Override
        public int compare(Student e1, Student e2) {
            return e1.getGrade() - e2.getGrade();
        }
    };

    /**
     * Comparator to sort Students list or array in order of gpa
     */
    public static Comparator<Student> GpaComparator = new Comparator<Student>() {

        @Override
        public int compare(Student e1, Student e2) {
            return (int) (e1.getGpa() -  e2.getGpa());
        }
    };
}

class sortByGradeOrName implements Comparator<Student>{
	public int compare(Student o1, Student o2) {
		int flag = o1.getGrade() - o2.getGrade();
		if(flag==0) flag = o1.getName().compareTo(o2.getName());
		return flag;
	}
}
