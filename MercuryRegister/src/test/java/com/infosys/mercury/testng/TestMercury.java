package com.infosys.mercury.testng;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infosys.mercury.pages.RegisterPOM;
import com.infosys.mercury.util.ExcelDataConfig;

public class TestMercury {
	public static WebDriver driver;
	WebDriverWait wait;
	public final String url = "http://newtours.demoaut.com/mercuryregister.php?osCsid=cf3cb09975f3327be3cccde4e83bb0ba";
	ExcelDataConfig exceldataConfig;
	RegisterPOM regPom;
	
	@BeforeTest(groups= {"setup"})
	@Parameters("browser")
	public void setup(String browserName) {
		//setup driver
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver");
			driver = new FirefoxDriver();
		}

		//setup waits
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 3);
	}
	
	@BeforeMethod(groups= {"setup"})
	public void setupMethod() {
		//navigate to homepage
		driver.get(url);
		
		//confirm user is on home page
		assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}
	
	@Test(dataProvider="mercData", groups= {"allTests"})
	public void testRegister(Object[] data) {
		//initialize page factory
		//amazonPF = new AmazonPF(driver);
		//search for given item from data provider
		//amazonPF.searchItem(item);
		
		//initialize the POM
		regPom = new RegisterPOM(driver,wait);
		regPom.registerUser(data);
		
		assertEquals("Note: Your user name is " + data[10] + ".",
				driver.findElement(By.xpath("/html/body/div/table/"
						+ "tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
						+ "tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/"
						+ "a/font/b")).getText());

		
	}
	
	@DataProvider(name="mercData")
	public Iterator<Object[]> excelSearchData(){
		exceldataConfig = new ExcelDataConfig("src/test/resources/mercuryData.xlsx");
		int rowCount = exceldataConfig.getRowCount(0);
		Collection<Object[]> data = new ArrayList<Object[]>();
		for (int i = 0; i < rowCount; i++) {
			int colCount = exceldataConfig.getColCount(0, i);
			//for loop
			
			Object[] rowData = new Object[colCount];
			for (int j = 0; j < colCount; j++) {
				rowData[j] = exceldataConfig.getIntAsStringData(0, i, j);
			}
			data.add(rowData);
		}
		return data.iterator();
	}
	
	@AfterTest(groups= {"teardown"})
	public void tearDown() throws InterruptedException{
		driver.quit();
	}
	
	@AfterClass(groups= {"teardown"})
	public void tearDownClass() {
		exceldataConfig.writeData();
		exceldataConfig.closeWB();
	}
	
	private boolean elementExists(By by) {
	    try {
	        driver.findElement(by);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
}
