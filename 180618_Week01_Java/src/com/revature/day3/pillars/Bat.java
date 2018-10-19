package com.revature.day3.pillars;

public class Bat extends Animal implements animalActions{ //abstraction and polymorphism
	private int limbs = 3; //encapsulationg
	
	public String batStuff() {
		return "echoo choo hoo oo o";
	}
	
	@Override //inheritance
	public boolean isAlive() {
		return super.isAlive();
	}
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "sucking blood";
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "swoosh";
	}
	
	@Override
	public int getLimbs() {
		// TODO Auto-generated method stub
		return limbs;
	}
}
