package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data = {
			"asdf",
			"qwer",
			"zxcv"
	};
	
	//create a random bumber generator
	private Random myRandom = new Random();
	
	public String getFortune() {
		// pick a random string from that array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
