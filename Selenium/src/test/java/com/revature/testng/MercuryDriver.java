package com.revature.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryDriver {
	public static WebDriver driver;
	public final String url = "http://newtours.demoaut.com/";
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();
		/*
		 * We can configure our driver's implicit wait as soon as it is instantiated for
		 * any element, wait 3 seconds before determining a fail
		 */
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		/*
		 * Implicit waits are applied by defailt in this case. But should we decide that
		 * there is a specific point in time I want to wait, we have to use explicit waits.
		 * These are one time uses and must be executed at a specific point
		 */
		wait = new WebDriverWait(driver, 7);
		
		driver.get(url);
	}
	@AfterTest
	public void tearDown() throws InterruptedException{
		Thread.sleep(2500);
		driver.quit();
	}
	@Test
	public void loginToMercury() {
		/*
		 * sendKeys() simulates typing
		 * click() simulates clicking
		 */
		
		/*
		 * Our findElement aims to reference an an element on the page.
		 * It takes a parameter of the static class "By".
		 * "By" represents our element selector. Selenium, by default, offers several selectors.
		 * 
		 * -Name
		 * -Id
		 * -LinkText
		 * -PartialLinkText
		 * -TagName
		 * -ClassName
		 * --The most importatn
		 * 	-Xpath
		 * 	-CssSelector
		 */
		
		//Implicit wait test	-keep looking for a certain amount of time before failing
		//driver.findElement(By.name("Bobbert"));
		
		//Explicit wait test	-
		//WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("bobbert")));
		
		//fluentwait
		/*
		 * Unlike the explicit wait, which will check to see if an element is available every
		 * 500 millisecons. fluentWait offers us the ability to customize how frequent the
		 * element checks are during the wait. If having a check for element existence every
		 * half second is too frequent, I can use fluentWaits to change the poll times to be
		 * longer or shorter
		 */
//		Wait fwait = new FluentWait(driver)
//				.withTimeout(7,TimeUnit.SECONDS)
//				.pollingEvery(750,TimeUnit.SECONDS)
//				.ignoring(NoSuchELementException.class);
//		WebElement e1 = (WebElement)fwait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.name("bobbert")));
//				
		
		driver.findElement(By.name("userName")).sendKeys("bobbert");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bobbert");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		
		//This grabs a collection of elements
		List<WebElement> els = driver.findElements(By.name("tripType"));
		for(WebElement e: els) {
				e.click();
			}
		driver.findElement(By.name("findFlights")).click();
		els = driver.findElements(By.name("outFlight"));
		for(WebElement e: els) {
			e.click();
		}
		els = driver.findElements(By.name("inFlight"));
		for(WebElement e: els) {
			e.click();
		}
		driver.findElement(By.name("reserveFlights")).click();
		//grab all items from a drop down list
		els = driver.findElements(By.xpath("//select[@name='cc_exp_dt_yr']/option"));
		for(WebElement e : els) {
			e.click();
			
			if(ExpectedConditions.alertIsPresent().apply(driver)!=null) {
				driver.switchTo().alert().accept();
			}
			
			//driver.getWindowHandles();	gets unique ids for all open tabss
			//Useful for switching between the two
		}
		
	}
  
  

}
