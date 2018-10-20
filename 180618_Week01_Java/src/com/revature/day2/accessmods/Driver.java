package com.revature.day2.accessmods;

public class Driver {
	public static void main(String[] args) {
		Silence silence = new Silence();
		System.out.println("====Printing via the class itself====");
		silence.output();
		
		//System.out.println(silence.priv); //doesn't work, only accessible within the class
		System.out.println(silence.def);	//same package 
		System.out.println(silence.prot); 	//same package 
		System.out.println(silence.pub);
	}
}
