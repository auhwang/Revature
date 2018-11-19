package com.infosys.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPOM {
	//driver used to navigate page
	private WebDriver driver;
	private WebDriverWait wait;
	
	//xpath of elements on page
	private By firstName = By.xpath("/html/body/div/table/tbody/tr/td[2]/"
			+ "table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[2]/td[2]/input");
	private By lastName = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/"
			+ "table/tbody/tr[3]/td[2]/input");
	private By phone = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/"
			+ "form/table/tbody/tr[4]/td[2]/input");
	private By email = By.xpath("//*[@id=\"userName\"]");
	private By address1 = By.xpath("/html/body/div/table/tbody/tr/td[2]"
			+ "/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[5]/td/form/table/tbody/tr[7]/td[2]/input");
	private By address2 = By.xpath("/html/body/div/table/tbody/tr/td[2]/"
			+ "table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[8]/td[2]/input");
	private By city = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/"
			+ "form/table/tbody/tr[9]/td[2]/input");
	private By state = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/"
			+ "table/tbody/tr[10]/td[2]/input");
	private By postal = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/"
			+ "table/tbody/tr[11]/td[2]/input");
	private By country = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/"
			+ "form/table/tbody/tr[12]/td[2]/select");
	private By userName = By.xpath("//*[@id=\"email\"]");
	private By password = By.xpath("/html/body/div/table/tbody/tr/td[2]/"
			+ "table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[15]/td[2]/input");
	private By confirmPass = By.xpath("/html/body/div/table/tbody/tr/td[2]/"
			+ "table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[16]/td[2]/input");
	private By submit = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/"
			+ "table/tbody/tr[18]/td/input");
	
	//constructor passed from test
	public RegisterPOM(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	//functionality
	public void registerUser(Object[] data) {
		inputFirstName((String)data[0]);
		inputLastName((String)data[1]);
		inputPhone((String)data[2]);
		inputEmail((String)data[3]);
		inputAddress1((String)data[4]);
		inputAddress2((String)data[5]);
		inputCity((String)data[6]);
		inputState((String)data[7]);
		inputPostal((String)data[8]);
		inputCountry((String)data[9]);
		inputUserName((String)data[10]);
		inputPassword((String)data[11]);
		inputConfirmPass((String)data[12]);
		submitLogin();
		
	}
	public void inputFirstName(String firstName) {
		driver.findElement(this.firstName).sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		driver.findElement(this.lastName).sendKeys(lastName);
	}
	
	public void inputPhone(String phone) {
		driver.findElement(this.phone).sendKeys(phone);
	}
	
	public void inputEmail(String email) {
		driver.findElement(this.email).sendKeys(email);
	}
	
	public void inputAddress1(String address1) {
		driver.findElement(this.address1).sendKeys(address1);
	}
	
	public void inputAddress2(String address2) {
		driver.findElement(this.address2).sendKeys(address2);
	}
	
	public void inputCity(String city) {
		driver.findElement(this.city).sendKeys(city);
	}
	
	public void inputState(String state) {
		driver.findElement(this.state).sendKeys(state);
	}
	
	public void inputPostal(String postal) {
		driver.findElement(this.postal).sendKeys(postal);
	}
	
	public void inputCountry(String country) {
		Select dropdown = new Select(driver.findElement(this.country));
		dropdown.selectByIndex(Integer.parseInt(country));
	}
	
	public void inputUserName(String userName) {
		driver.findElement(this.userName).sendKeys(userName);
	}
	
	public void inputPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void inputConfirmPass(String confirmPass) {
		driver.findElement(this.confirmPass).sendKeys(confirmPass);
	}
	
	public void submitLogin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		driver.findElement(submit).click();
	}
}
