package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAsdf() {
		System.out.println(getClass() + ": Doing my db work: adding an account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep now");
	}
}
