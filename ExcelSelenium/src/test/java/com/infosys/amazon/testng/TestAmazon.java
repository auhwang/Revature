package com.infosys.amazon.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infosys.amazon.pages.AmazonPF;
import com.infosys.amazon.util.ExcelDataConfig;

public class TestAmazon {
	public static WebDriver driver;
	WebDriverWait wait;
	public final String url = "https://www.amazon.com/";
	public AmazonPF amazonPF;
	ExcelDataConfig exceldataConfig;
	
	@BeforeTest(groups= {"setup"})
	public void setup() {
		//setup driver
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();

		//setup waits
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 3);
	}
	
	@BeforeMethod(groups= {"setup"})
	public void setupMethod() {
		//navigate to homepage
		driver.get(url);
		
		//confirm user is on home page
		assertEquals(driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	@Test(dataProvider="amazData", groups= {"allTests"})
	public void testCart(int rowN, String item, int resultN) {
		//initialize page factory
		amazonPF = new AmazonPF(driver);
		//search for given item from data provider
		amazonPF.searchItem(item);
		
		String resultBase = "//*[@id=\"result_";
		String resultTail = "\"]";
		String itemName = " ";
		WebElement result = null;
		Boolean checkValidResult = false;
		int itemsInCart = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).getText());
		
		while(!checkValidResult) {
			//check if the result exists and assign xpath if it does
			try {
				assertTrue(elementExists(By.xpath(resultBase + resultN + resultTail)),"Search result not found");
			}catch(AssertionError e)
	        {
				exceldataConfig.putData(0,rowN, 1, "No Item Found");
	            assertTrue(elementExists(By.xpath(resultBase + resultN + resultTail)),"Search result not found");
	        }
			result = driver.findElement(By.xpath(resultBase + resultN + resultTail));
			//if text contains shop by category, get the next result
			if(result.getText().contains("Shop by Category")) {
				resultN = resultN + 1;
			}else {
				checkValidResult = true;
			}
		}
		
		//get the item name and put it in the excel sheet
		try {
			itemName = result.findElement(By.tagName("h2")).getText();
		}catch(NoSuchElementException e) {
			exceldataConfig.putData(0,rowN, 1, "Not a valid item to add to cart");
			assertTrue(false, "Not a valid item to add to cart");
		}
		exceldataConfig.putData(0,rowN, 1, itemName);
		
		//save substring for later verification and navigate to item page
		itemName = itemName.substring(1, itemName.indexOf(" "));
		result.findElement(By.tagName("h2")).click();
		
		//add the item to the cart
		assertTrue(elementExists(By.xpath("//*[@id=\"add-to-cart-button\"]")),"Add to cart is not available");
		assertTrue(driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).isDisplayed(), "Add to cart is not visible");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		//wait for cart to update and click cart
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"nav-cart-count\"]"), Integer.toString(itemsInCart+1)));
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", cart);
		
		//check the items in cart to see if newly added item exists
		List<WebElement> cartItems = driver.findElements(
				By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]"));
		assertTrue(cartItems.size() > 0, "There are no items in the cart");
		for(WebElement e: cartItems) {
			assertTrue(e.getText().contains(itemName),"Item was not successfully added to the cart");
		}

		
	}
	
	@DataProvider(name="amazData")
	public Object[][] excelSearchData(){
		exceldataConfig = new ExcelDataConfig("src/test/resources/amazonData.xlsx");
		int rowCount = exceldataConfig.getRowCount(0);
		Object[][] data = new Object[rowCount][3];
		for (int i = 0; i < rowCount; i++) {
			data[i][0] = i;
			data[i][1] = exceldataConfig.getStringData(0, i, 0);
			data[i][2] = exceldataConfig.getIntData(0, i, 2);
		}
		return data;
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
