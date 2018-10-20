package com.revature.day4.collections;

import java.util.Comparator;

public class ReverseStringSort implements Comparator<String>{
	@Override
	public int compare(String s1, String s2){
		return s1.compareTo(s2)*-1;
	}
}
