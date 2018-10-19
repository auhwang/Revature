package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/*
 * With TestNG we get access to more before/after otpions than our jUnit predecessor
 * 
 * Should you utilize other classes within the test file, the before/after class annotation
 * will trigger
 * 
 * Should you utilize multiple test classes within the same class file (IE Suite)
 * the before/after test annotation will trigger
 * 
 * Should you utilize multiple suites, the before/after suite annotations trigger
 * 
 * Note: There is a 5th before/after annotation called before/after group.
 * Testing allows you make a custom group tag and apply them to the groupings of methods.
 * Before and after each specific group executes, these annotations will trigger
 */
public class NewTest {
  @Test
  public void f() {
	  System.out.println("Test f");
  }
  //skip a test
  @Test(enabled = false)
  public void g() {
	  System.out.println("Test g");
  }
  @Test
  public void h() {
	  System.out.println("Test h");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
