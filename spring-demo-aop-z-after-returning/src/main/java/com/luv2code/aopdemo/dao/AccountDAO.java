package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.aspect.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		//create sample accounts
		Account temp1 = new Account("john", "silver");
		Account temp2 = new Account("tom", "gold");
		Account temp3 = new Account("bob", "bobbert");
		
		//add them to accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount() {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");

		this.name = name;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");

		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");

		this.serviceCode = serviceCode;
	}
	
}
