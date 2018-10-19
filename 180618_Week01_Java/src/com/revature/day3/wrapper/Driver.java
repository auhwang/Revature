package com.revature.day3.wrapper;

public class Driver {

	public static void main(String[] args) {
		/*
		 * A wrapper class is the object representation of a primitive value, thus giving
		 * us methods to call on any primitive values
		 */
		
		//Wrapper class
		/*
		 * A wrapper class is simply the primitive datatype, with a capital first letter
		 * Exceptions being:
		 * 	Integer
		 * 	Character
		 * Where the full name is also used
		 */
		
		System.out.println(Integer.MAX_VALUE);
		
		/*
		 * Autoboxing
		 * -Autoboxing is the implicit conversion of a primitive value into its
		 * wrapper class. This takes place any time you use a primitive as a parameter
		 * that expects a wrapper class.
		 * 
		 * Likewise
		 * Auto-unboxing
		 * -the reverse, implicitly unwrapping a wrapper class back into its primitive form
		 */

		Driver d = new Driver();
		System.out.println(d.addition(5, 15));	//autobox
	}
	
	public int addition(Integer a, Integer b) {

		return a + b; //auto-unboxing occurs during the arithmetic
	}

}
