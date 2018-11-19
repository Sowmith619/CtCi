package com;

import java.util.ArrayList;
import java.util.List;

public class Static {
	static int check=10;
	static final List<Integer> num=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		System.out.println(check);
		check++;
		System.out.println(check);
		Static obj = new Static();
		obj.method();
		method2(count);
		
		System.out.println("final::"+ num.size());
		num.add(12);
		System.out.println("final::"+ num.size());
	}
	public void method() {
		int checker=0;
		System.out.println(check);
		check++;
		System.out.println(check);
		
	}
	public static void method2(int count) {
		System.out.println(check);
		check++;
		System.out.println(count);
		//method();
	}
}
