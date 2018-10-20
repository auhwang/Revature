package com.revature.day2.controlstates;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Control statements are any blocks of code that can control the flow of applications.
		 * IE. Different branches, loops, etc.
		 */
		
		//FOR LOOP
		//for(incrementor:Condition:increment block)
		System.out.println("===FOR LOOP===");
		for(int i = 5; i > 0; i--) {
			System.out.println(i);
		}
		//POST FIX
		//i-- / i++ is an example of POST FIX, what this does is use the variable
		//i then, once done, adds 1 to it
		//PRE FIX
		//--i / ++i will be scenerios where when i is used, it will add/subtract 1 first, then use it
		
		int j = 10;
		System.out.println(j++); //10
		System.out.println(++j); //12
		
		//NOTE: you can make an infinite loop with for(;;)
		
		//enchanced for loop(foreach loop)
		
		//you make arrays by using a datatype with empty brackets
		//then instantiate with 'new' and indicate the size of the array. Array sizes can NOT be changed
		//arrays in java are 0 index based. IE, the first number is at index 0;
		//and in the below example, the LAST number is in index 4
		System.out.println("====foreach loop====");
		int[] nums = new int[5];
		for(int num:nums) {
			System.out.println(num);
		}
		
		int[] nums2 = {1,2,3,4,5};
		for(int num:nums2) {
			System.out.println(num);
		}
		
		//WHILE LOOP
		System.out.println("===While loop====");
		int k = 5;
		while(k>0) {
			k--;
			System.out.println("still running");
		}
		System.out.println("broke out of the loop");
		//do-while loop
		//execute once gaurenteed, then check condition
		do {
			System.out.println("still running");
			k--;
		}while(k > 0 && k < 5);
		
		int l = 10;
		if(l<90) {
			System.out.println("asdf");
		}else if(l>59) {
			System.out.println("jklm");
		}else {
			System.out.println("qwer");
		}
		
		System.out.println("===SWITCH===");
		int rando = (int)(Math.random()*4);
		
		switch(rando) {
		default:	//used when no other case gets matched
			System.out.println("casedef");
			break;  //break statements take control out of the current loop
					//in this case the loop is the switch statement, not the case
		case 0:
			System.out.println("case0");
			//without the break statement, it will run case by case
			break;
		case 1:
			System.out.println("case1");
			break;
		case 2:
			System.out.println("case2");
			break;
		}
		
		for(int m = 0; m < 50; m++) {
			if(m==30) break;
			if(m%2==1) continue;	//skips directly to the next loop iteration
			System.out.println(m);
		}
	}

}
