package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.aspect.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = null;
		try {
			//add boolean flag to simulate exceptions
			boolean tripwire = false;
			theAccountDAO.findAccounts(tripwire);
		}catch(Exception exc) {
			System.out.println("\n\nMain Program caught exception: " + exc);
		}
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("===========");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//cose the context
		context.close();

	}

}
