package com.revature.day2.varscopes;

public class Driver {
	public static void main(String[] args) {
		//You can access static fields with the name of the class directly
		System.out.println(Person.personCount); //0
		
		//Reference = Assignment/Object
		Person p1 = new Person("bibber",92);
		//When objects:
		//ClassName variableName = new ClassName()
		//Class - A blueprint for an object that structures different states and functionality
		//Object - An instantiation of a class, A runtime entity that can be altered and maintain
			//state changes
		
		System.out.println(p1.getAge()); //92
		System.out.println(p1.personCount); //1
		
		System.out.println("====Person 2====");
		Person p2 = new Person("Ryan",118);
		System.out.println(Person.personCount); //2
		System.out.println(p2.personCount); //2
	}
}
