package com.revature.day3.pillars;

public class C extends B{
	public char field = 'C';
	@Override
	//When overriding I can not change return type or parameter count
	//Access can be changed to be more accessible
	public void method1() {
		System.out.println("method in C");
	}
	public void method2() {
		System.out.println("method in C");
	}
	public void method3() {
		System.out.println("method in C");
	}
}
