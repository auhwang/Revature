package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.aspect.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoAp");
		System.out.println("===========");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//cose the context
		context.close();

	}

}
