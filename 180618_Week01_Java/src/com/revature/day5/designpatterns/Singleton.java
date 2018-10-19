package com.revature.day5.designpatterns;

/*
 * The main goal of a singleton design pattern is to provide a single instance
 * of a class that can be shared application wide
 * There should never be more than one of instance of the class and there should never be a 
 * scenario where the instance is replaced or recreated
 */
public class Singleton {
	private static Singleton singleton;
	/*
	 * By making the constructor private we bar any user from explicitly creating a 'new'
	 * singleton object themselves
	 */
	private Singleton() {
		System.out.println("Instance Created");
	}
	
	/*
	 * By making the getter static, we can access it without creating instances of the object. We
	 * also get to leave the act of creating instances to the class itself
	 * This ensures that we will only ever have one singleton instance throughout the application
	 */
	
	public static Singleton getSingleton() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
