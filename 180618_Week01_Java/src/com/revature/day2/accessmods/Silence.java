package com.revature.day2.accessmods;

public class Silence {
	/*
	 * There are two kinds of 'modifiers' available in java that can be used.
	 * One of the two are called 'access modifiers' which there are four:
	 * -private
	 * ---Restricts access to a class entity from anywhere that is not from the class itself.
	 * ---IE, you cannot access a private method or variable from outside of this class
	 * -default(no modifier)
	 * ---We refer to this modifier as default, when in reality it is just any variable with no
	 * distinctive access modifier on it. 
	 * Access is restricted to anything that is within the same package as each other
	 * -protected
	 * ---Protected offers access to any classes within the same package or any
	 * ---direct subclasses(child classes)
	 * -public
	 * ---Accessible from anywhere within the application
	 * 
	 * The other subset can be called non-access modifiers
	 * -static
	 * ---Sets the resource to be available without instantiating the class
	 * ---Limits to only one instance of the resource shared among the other instances of the class
	 * -final
	 * ---Depending on where it goes, limits availability/mutation of a resource
	 * -abstract
	 * ---Foregoes body implementation of a method until inherited
	 * -synchronized
	 * ---Limits the amount of threads that can access a resource to one at a time
	 * -transient
	 * ---Anything transient is witheld from serialization
	 * -native
	 * ---No body for the method, implementation is done outside of java
	 * -strictfp
	 * ---if on class, all methods are strictfp
	 * ---all floating points conform to IEEE standards
	 * -volatile
	 * ---A volatile variable must be accessed via main memory, not an individual
	 * ---thread's stack memory. It essentially marks the variable as an important
	 * ---resource that will be hit by multiple threads
	 */
	private String priv = "private";
	String def = "default";
	protected String prot = "protected";
	public String pub = "Public";
	
	//which access mod above can NOT be accessed within this class
	public void output() {
		//everything is accessible because it is in the class it was created in
		System.out.println(priv);
		System.out.println(def);
		System.out.println(prot);
		System.out.println(pub);
	}
}
