package com.revature.day3.finalex;

public class finalhelper {
	//final on a field enforces a constant
	//you cannot change this anywhere else in the application
	public final int SOME_NUMBER = 200;
	//NOTE: Convention suggests that you use all caps and underscores when naming constants
	
	public void method1() {
		//SOME_NUMBER += 10;		you cannot alter final fields
		System.out.println("Method1");
	}
	public final void method2() {
		System.out.println("Method2");
	}
	//overloading works
	public void method2(int a) {
		
	}
	
}
