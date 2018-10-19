package com.revature.day2.strings;

public class Immutability {
	
	/*
	 * The String class is one of the most important classes in Java.
	 * As it provides us a means to use human language throughout applications for our end users,
	 * in a convenient fashion
	 * 
	 * String is essentially an array of characters.
	 * String is also a FINAL class. This means you may NOT inherit in order to make your own
	 * version.
	 * String is also IMMUTABLE
	 * -once a string is set, it can not be changed ever again
	 * --You would need to create a new String.
	 * --Immutable simply means unchangeable
	 */
	public static void main(String[] args) {
		
		//order of operations in most languages is from left to right
		System.out.println(2+5+7); 			//14;
		System.out.println(2*5-7);			//3
		System.out.println(2-5*7);			//-33
		//PEMDAS is maintained
		System.out.println(2/5+10-2*4);		//2
		System.out.println("d" + 5 + 10);	//d510
		System.out.println(5 + 10 + "d");	//15d
		System.out.println(5 + 10 + "d" + 10 + 5);	//15d510
		
		System.out.println("===Main example===");
		//String s1 = "dog";
		//s1 += "s";
		//System.out.println(s1);
		
		//Stacks and Heaps
		/*
		 * STACKS
		 * -A stack is more constant in the memory it allocates filo
		 * -local variables
		 * -object/method references
		 * -every thread has it's own stack
		 * -stack overflow
		 */
		/*
		 * HEAPS
		 * -instance variables
		 * -objects
		 * -string pool
		 * -out of memory error
		 */
		//String pool
		//-A string pool is inside the heap
		//--string s1 is inside the string pool
		/*
		String s2 = "dog";
		//--string s2 references the same dog in the string pool
		//s1 and s2 are called string literals
		String s3 = "cat";
		//s1 and s2 are the same object while s3 is a seperate one put into the string pool
		String s4 = new String("bob");
		String s5 = "bob";
		//s4 is put into the heap while s5 into the string pool
		s4 = s4.intern();
		//moves s4 into the string pool and destroys the one in the heap
		s2 += "s";
		//creates a new object in the heap dogs which s2 points to
		s2 += "y";
		//creates a new object in the heap dogsy which s2 points to and since nothing points to dogs
		//it is destroyed
		*/
		String s1 = "dog";
		System.out.println(System.identityHashCode(s1) + ":s1 = " + s1);
		s1 += "s";
		System.out.println(System.identityHashCode(s1) + ":s1 = " + s1);
		s1 = "dogs";
		System.out.println(System.identityHashCode(s1) + ":s1 = " + s1);
		String s2 = "dogs";
		System.out.println(System.identityHashCode(s2) + ":s2 = " + s2);
		String s3 = new String("dogs");
		System.out.println(System.identityHashCode(s3) + ":s3 = " + s3);
		System.out.println(System.identityHashCode(s3.intern()) + ":s3 = " + s3);
		String s4 = new String("dogs");
		s4 = s4.intern();
		System.out.println(System.identityHashCode(s4) + ":s4 = " + s4);
		
		//== vs .equals()
		/*
		 * == is a comparator. It will check to see if two resources are exactly the same
		 * .equals is a method inherited by the Object class where, in String, it has been overridden
		 * to check values with eachother as opposed to exact matches
		 * ---NOTE: .equals, as it is in the Object class, behaves the same as ==.
		 * ---It will compare to see if two objects are exactly the same
		 * ---This is why you need to override the .equals() in any class
		 * ---that you make and intend to compare
		 */
		
		System.out.println("====comparing====");
		String person1 = "bob";
		String person2 = "bob";
		String person3 = new String("bob");
		System.out.println(person1.equals(person2));	//true
		System.out.println(person1.equals(person3));	//true
		System.out.println(person1 == person2);			//true
		System.out.println(person1 == person3);			//false
		
		String person4 = "bo";
		person4 += "b";
		System.out.println(person1 == person4);			//false
		System.out.println(person1.equals(person4));	//true
		
		System.out.println("=============");
		/*
		 * In situations where a string will go through numerous manipulations, one can reach a point
		 * where you are dealing with a huge overhead and memory consumption since you
		 * are creating a new string every time.
		 * THerefore, in order to be efficient, and stop wasting memory, java offers a mutable
		 * version of a String we can use:
		 * --StringBuilder and StringBuffer
		 * 
		 * What is the difference between String, StringBuffer, and StringBuilder?
		 * -String is immutable
		 * -StringBuffer and StringBuilder wrap around the String class in order to make it
		 * 	mutable. THerefore, they are mutable. The difference between the two, however,
		 * 	is that StringBuffer is ThreadSafe, whereas StringBuilder is not
		 * 		-Note: Thread safe means we only allow one thread to interact with a resource at at
		 * 			a given time.
		 * 		-Note: StringBuilder/Buffer is substantially more costly of an object than String,
		 * 			but we only need to create one
		 */
		StringBuilder sb = new StringBuilder("bobbert");
		System.out.println(sb.toString() + ":" + System.identityHashCode(sb));
		sb.append(sb.toString() + ":" + System.identityHashCode(sb));
		System.out.println("====Performance Test====");
		String str = "";
		StringBuilder sbui = new StringBuilder("");
		StringBuffer sbuf = new StringBuffer("");
		int iterations = 10000;
		
		long curtime;
		
		curtime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			str += "s";
		}
		System.out.println("String: " + (System.currentTimeMillis() - curtime));
		
		curtime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			sbui.append("s");
		}
		System.out.println("StringBuilder: " + (System.currentTimeMillis() - curtime));
		
		curtime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			sbuf.append("s");
		}
		System.out.println("StringBuffer: " + (System.currentTimeMillis() - curtime));
	}

}
