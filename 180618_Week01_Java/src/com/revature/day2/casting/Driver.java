package com.revature.day2.casting;

public class Driver {
	
	public static void main(String[] args) {
		//underscores used for legibility
		int i = 32_768;		//number of max size: 32 bits;
		short s = 32767;	//number: 16 bits;
		long l = 20;		//number: 64 bits; L at the end of the number
		float f = 5.5f;		//decimal value support: 32 bits;
		double d = 10.10;	//decimal value support: 64 bits;
		byte b = 80;		//number: 8 bits; -128 - 127
		char c = 'r';		//number/letter 16 bits; chars are written with apostrophes not quotes
		boolean bool;		//A boolean only needs a bit, but might have byte reserved
		
		/*
		 * Two kinds of casting in Java
		 * -Explicit casting
		 * --Where you specifically write out what datatype you want to cast to, IE convert to.
		 * -Implicit casting
		 * --Java will convert the datatype into the needed one for you, without you having to type it out
		 */
		
		//EXPLICIT CASTING
		s = (short)i;	//overflows so it becomes the 2's complement -32768
		System.out.println(s);
		
		//Implicit Casting
		i = s;
		
		i = (int)l;
		l = i;
		
		s = (short)l;
		l = s;
		
		//because chars are unsigned
		c = (char)s;
		c = (char)i;
		c = (char)b;
		
		f = (float)d;
		d = f;
	}

}
