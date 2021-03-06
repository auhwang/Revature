package com.revature.day3.pillars;

/*
 * When you make an abstract class, you put the class in a state where it may never be instantiated
 * This allows us to provide methods with implementation
 * Bare in mind, we are allowed to provide concrete method definitions with
 * (Concrete means method with implementation)
 * The purpose of an abstract class is to provide a class that you want all the children
 * to inherit method from.
 * Aids in enforcing a shared method pool
 */
public abstract class Animal {
	public abstract int getLimbs();
	public boolean isAlive() {
		return true;
	}
	
}
