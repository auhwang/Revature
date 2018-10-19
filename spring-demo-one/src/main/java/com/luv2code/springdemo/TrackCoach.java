package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	//define a private field for the dependency
	private FortuneService fortuneService;
	
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}	
	
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	public String getDailyFortune() {
		//use myfortuneService to get a fortune
		return "Just Do It: " + fortuneService.getFortune();
	}

	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");

	}
	
}
