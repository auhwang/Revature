package com.revature.day3.cli;

public class Driver {
	public static void main(String[] args) {
		/*
		 * args serves to hold running the application using command line arguments
		 * There are two ways to do this.
		 * The IDE way or using the command line
		 */
		System.out.println(args.length);
		for(String s:args) {
			System.out.println(s);
		}
		
		/*
		 * Using command line args:
		 * With IDE
		 * 1. Navigate to:
		 * 		run > run configurations > (click the arguments tab) > write arguments
		 * 			separated by spaces.
		 * 2. Run the app
		 * 
		 * With command line
		 * just write it at the end or
		 * 1. Navigate to your src folder
		 * 2. Invoke the java compiler for your project
		 * 2.5 e.g. javac package
		 * package\file.java
		 * 3. next execute using java
		 * 3.5 e.g. java package.package.file arg1 arg2 argetc
		 */
	}
}
