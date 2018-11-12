package com.infosys.amazon.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPF {
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	WebElement searchButton;
	
	public AmazonPF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inputItem(String item) {
		searchBar.clear();
		searchBar.sendKeys(item);
	}
	
	public void submitSearch() {
		searchButton.click();
	}
	
	public void searchItem(String item) {
		inputItem(item);
		submitSearch();
	}
}
