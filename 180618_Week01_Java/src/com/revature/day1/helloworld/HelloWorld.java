package com.revature.day1.helloworld;
//The first line of any java file, will be the package structure.
//Exception for when you use the default package (don't do this)
/*
 * Packages are simply collection/groupings of folders that
 * sort and organize classes. THese also play a role into which
 * classes can access others depending on package location.
 */
public class HelloWorld {
	/*
	 * The main method MUST adhere to the following criteria:
	 * -public
	 * -static
	 * -return nothing (void)
	 * -lower case method name of 'main'
	 * -take a single parameter of a string array
	 */
	public static void main(String args[]) {
		System.out.println("Hello World.");
	}
	/*
	 * shortcut for System.out.println() = syso + ctrl + 'space'
	 */
}
