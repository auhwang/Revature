package com.revature.day3.pillars;

public class Dog extends Animal implements animalActions{
	private int limbs = 4;
	//This dog is-a Animal
	//This dog has-a heart
	
	//This is a has a relationship
	private Heart heart;
	

	public Dog() { 
		heart = new Heart(true,937);
	}
	
	/**
	 * The bark method......
	 * @return String
	 */
	public String bark() {
		return "ruff ruff my heart weights " + heart.getWeight() + " pounds";
	}
	
	@Override
	public boolean isAlive() {
		//The super keyword is always a reference to the direct parent class
		return super.isAlive();
		//So essentially this translates into Animal.isAlive();
	}
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "ruaaaa";
	}
	
	@Override
	public int getLimbs() {
		// TODO Auto-generated method stub
		return limbs;
	}

}
