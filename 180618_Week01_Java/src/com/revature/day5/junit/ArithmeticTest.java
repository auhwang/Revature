package com.revature.day5.junit;

//A static import brings in an entire class and lets you use it as if the methods were defined within
//the class itself
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
 * Assert statements
 * -Assert equals/not equals
 * -Assert True/False
 * -Assert Same/Not Same
 * -Assert arrayequals
 * -Assert null/notnull
 * 
 */
public class ArithmeticTest {

	Arithmetic ari = null;


	@Before
	public void setUp() throws Exception {
		ari = new Arithmetic();
	}

	@After
	public void tearDown() throws Exception {
		ari = null;
	}

	@Test
	public void add() {
		assertEquals(40,ari.add(10,30));
		/*
		 * Assert methods:
		 * -assertEquals
		 * -assertNotEquals
		 * -assert
		 */
	}
	
	@Test
	public void sub() {
		assertEquals(-20,ari.sub(10,30));
	}

	@Test
	public void mul() {
		assertEquals(300,ari.mul(10,30));
	}
	
	@Test
	public void div() {
		assertEquals(0,ari.div(10,30));
	}
	
	@Ignore //ignore will skip a test
	@Test
	public void dayOffThisMonday() {
		fail("I got no money!");
	}
	
	/*
	 * Should you want a certain exception to be shown, you can configure a test to pass
	 *  for specific exceptions using the @Test's (expected = exception.class) configuration
	 */
	@Test(expected=ArithmeticException.class)
	public void imagonadividebyzero() {
		ari.div(10,0);
	}
	
	/*
	 * If you want a test to fail for taking too long, use:(timeout=milliseconds)
	 * The test will fail if it passes the time threshold.
	 */
	@Test(timeout=3000)
	public void timerTest() throws Exception{
		Thread.sleep(4000);
	}
}
