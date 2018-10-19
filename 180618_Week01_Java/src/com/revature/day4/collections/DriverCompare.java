package com.revature.day4.collections;

import java.util.Arrays;
import java.util.List;
public class DriverCompare {
	public static void main(String[] args) {
		List<Person> p = Arrays.asList(new Person("a",12),
				new Person("c",66),
				new Person("b",98));
		for(Person q:p) {
			System.out.println(q);
		}
		System.out.println("===Sorted===");
		p.sort(null);
		for(Person q:p) {
			System.out.println(q);
		}
		System.out.println("===Comparator===");
		p.sort(new PersonAgeComparator());
		for(Person q:p) {
			System.out.println(q);
		}
	}
}
