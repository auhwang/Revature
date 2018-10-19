package com.revature.day3.shortcircuits;

public class Driver {

	public static void main(String[] args) {
		/*
		 * A comparator is any operator that aims to compare 2 entities
		 * IE: >,<,<=,>=,etc
		 * Two big comparators are the AND and OR operators
		 * 
		 */
		if(returnTrue());
		if(returnFalse());
		System.out.println("============");
		
		System.out.println(returnFalse() && returnTrue());
		System.out.println(returnTrue() || returnFalse());
		System.out.println("==========");
		/*
		 * Normal & and | will check all sides of the comparison regardless if they are true or false.
		 * This can be wasteful.
		 * So instead, we have short-circuit operators, where if it is noted that an AND or OR
		 * statement will evaluate true or false, regardless of the rest of the comparison, then
		 * it will stop checking altogether and return the answer
		 */
		System.out.println(returnFalse() || returnTrue());
		System.out.println(returnTrue() || returnFalse() && returnTrue() || returnTrue());
		System.out.println("================");
	}
	public static boolean returnTrue() {
		System.out.println("returned true");
		return true;
	}
	public static boolean returnFalse() {
		System.out.println("returned false");
		return false;
	}

}
