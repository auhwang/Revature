package com.revature.day2.exceptions;

import java.io.IOException;

import javax.crypto.ExemptionMechanismException;
import javax.management.RuntimeErrorException;

/*
 * Throwable
 * -Error
 * ---Out of memory
 * ---Stack overflow
 * -Exceptions
 * --Runtime Exception
 * ---Division by zero
 * ---Index out of bounds
 * ---Null pointer
 * ---Runtime exceptions and all of it's children are considered unchecked exceptions
 * --IOException
 * ---File not found
 * --Anything other than Runtime exceptions are checked exceptions
 * --Checked exceptions are checked to be possible during compile time
 */
public class Driver {
	public static void main(String[] args) throws Exception{
		Driver d = new Driver();
		//d.divideByZero();
		d.goodHandling();
		try {
			d.ducking();
		}catch(Exception e) {
			System.out.println("asdfa");
		}
		try {
			d.method1();
		}catch(Exception e) {
			
		}
		d.weird();
		d.oops();
		System.out.println("====End of Execution====");
	}
	
	/*
	 * An exception can be described as an incident where something unexpected occurs.
	 * -An application behaves in a manner it should not.
	 * 
	 * An Exception is NOT an error
	 * Both are two separate classes
	 * An error can be described as:
	 * -An Incident that cannot be reasonable recovered from
	 */
	public void divideByZero() {
		//Below is risky code, so it should go into a 'try' block. The first requirement
		//for exception handling
		try {
			System.out.println(1/0);
		}
		//Try is not enough, need one more thing
		//In this case we use a catch block
		catch(ArithmeticException e){
			/*
			 * A catch block will describe which exception it is looking for. If the detailed
			 * exception occurs, it will be caught, and the flow of execution will be
			 * re-routed into the catch block for any cleanup that should occur
			 */
			System.out.println("====Exception Handled====");
			e.printStackTrace();
		}finally{
			/*
			 * A finally block is a block that you can use which will execute no matter what
			 * If an exception occurs, it will be handled, and the finally block will execute next.
			 * If no exception occurs, the finally block will execute next.
			 * If an exception crashes the application, the finally block will execute next
			 * There are only TWO ways where this block will NOT execute.
			 * Either the application crashes via error, or a user invokes System.exit(0)
			 */
			System.out.println("====Finally Block Executed====");
		}
		//A try block requires either a catch or finally block
		
		System.out.println("====End of divideByZero====");
	}
	
	public void goodHandling() {
		//You can use the 'throw' keyword to manually invoke any exception of your choice
		try {
			System.out.println(1/0); 	//Arithmetic exception
			Object o = null;
			o.toString();				//NullPointerException
			int array[] = {1};
			array[99] = 22;				//ArrayOutOfBoundsException
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		/*
		 * When using multiple catch blocks, be sure to order from child exceptions to parent ones
		 * A try block can have 0-many catch blocks, assuming a finally block is attached for the
		 * 0 catch block case
		 */
		
	}
	public void checkedException() {
		try {
			throw new IOException();	//if you don't handle this checked exception,
											//your code will not compile
		}catch(Exception e){
			System.out.println("goteeeeeem");
		}
	}
	
	/*
	 * When it comes to exception handling, one does not need to worry about a try catch block right away.
	 * If the exception is something you would have handled elsewhere, you can choose to propogate the
	 * exception. Also called ducking the exception. Where, instead of handling it, you just throw
	 * it up to the calling method/class to handle instead.
	 */
	public void ducking() throws Exception{
		throw new Exception();
	}
	public void method1() throws IOException{
		method2();
	}
	public void method2() throws IOException{
		method3();
	}
	public void method3() throws IOException{
		throw new IOException();
	}
	public String weird() {
		try {
			throw new Exception();
		}catch(Exception e) {
			return "catch";
		}finally {
			return "finally";
		}
	}
	public void oops() {
		try {
			throw new RyanWasWrong();
		}catch(RyanWasWrong e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
