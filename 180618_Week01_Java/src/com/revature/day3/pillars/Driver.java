package com.revature.day3.pillars;

public class Driver {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Bat bat = new Bat();
		Driver d = new Driver();
		d.moveAll(dog,bat);
		d.covariance();
	}
	
	public void moveAll(animalActions ...animals) {
		for(animalActions animal: animals) {
			System.out.println(animal.move());
		}
	}
	public void covariance() {
		A a = new A();
		B b = new B();
		C c = new C();
		System.out.println("==============");
		System.out.println(a.field);
		System.out.println(b.field);
		System.out.println(c.field);
		
		//C c2 = (C)new A();		//you cannot cas A to C, A has no way of getting the extra methods
										//gets a ClassCastException
		//Only have access to A's methods
		//But, we get C's implementation
		//However, we retain A's instance variable values
		//This is called variable shadowing
		A a2 = new C();
		a2.method1();
		System.out.println(a2.field);

		a = c;
		a.method1();
		a = new A();
		//c = (C)a;				/still a class cast exception
		
	}
}
