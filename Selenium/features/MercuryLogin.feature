#Feature is the first keyword of a feature file that designates it as such
Feature: Mercury Tours Login
	I wish to login to Mercury tours using proper credentials
	
	#Scenario: this keyword designates a single test
	#Scenario outline must be used in lieu of scenario if using example tables
#	Scenario Outline: Logging into mercury tours
#		Given a user is at the login screen for mercury tours.
#		When a user inputs a "<username>", "<password>", and clicks submit
#		Then a user shall be redirected to the find flights page

	Scenario Outline: Logging into mercury tours
		Given a user is at the login screen for mercury tours.
		When a user inputs a username
		|	field			|	value			|	type		|
		|	userName	|	bobbert		|	text		|
		|	password	|	bobbert		|	text		|
		|	login			|						|	click		|
		|	fromPort	|	Frankfurt	|	weblist	|
		|	toMonth		|	11				|	weblist	|
		
		And a passwrod and clicks submit
		Then a user shall be redirected to the find flights page
		
#Other keywords worth noting
#AND will split a given statement into two versions of it
#BUT will split a given statement into two versions of it
#Functionally, these two aren't different, the difference lies within
#the interpretation of gherkin

#Background replaces the scenario tag for creating a test
#a background scenario runs once, for each scenario on the geature file
#It actls like a setup of a scenario file

#Examples table must be formatted like below. whitespace doesn't matter
#Examples: 
#|	username	| password 	|
#| bobbert 	| bobbert  	|
#| tropicana	| tropicana	|
#| goodbye		| hello			|
#Example tables provide us the opportunity for data driven frameworks
#the test will rerun for each record of data