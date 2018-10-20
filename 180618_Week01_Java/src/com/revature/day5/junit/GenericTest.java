package com.revature.day5.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericTest {

	/*
	 * JUnit is a testing tool for unit tests.
	 * A unit test is the most micro level of testing that you can perform on an application
	 * The goal of unit testing is to have a test for every single method in the application
	 * to ensure it works as expected befere you even bother running it
	 */
	
	//BeforeClass methods should aim to set up the global environment for your tests
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("===Before Class===");
	}

	//Should aim to perform a global tear down of all test data (IE, here is where you
	//should delete any test data that adds data in the database)
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("===After Class===");
	}

	//Before should be used to set up the environment for each individual test
	@Before
	public void setUp() throws Exception {
		System.out.println("===Before===");
	}

	//After should be used to tear down the environment for each individual test
	@After
	public void tearDown() throws Exception {
		System.out.println("===After===");
	}

	//Indicates a specific test to be run
	@Test
	public void test1() {
		System.out.println("Test 1");
		fail("Not yet implemented");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
		fail("Not yet implemented");
	}
	@Test
	public void test3() {
		System.out.println("Test 3");
		fail("Not yet implemented");
	}

}
