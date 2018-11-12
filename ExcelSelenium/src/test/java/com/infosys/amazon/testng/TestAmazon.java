package com.infosys.amazon.testng;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
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
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 3);
		driver.get(url);
	}
	
	@Test(dataProvider="amazData", groups= {"allTests"})
	public void testCart(int rowN, String item) {
//		assertEquals(driver.getTitle(),
//				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		amazonPF = new AmazonPF(driver);
		amazonPF.searchItem(item);
		
		try {
			assertTrue(elementExists(By.xpath("//*[@id=\"result_0\"]")),"Search result not found");
		}catch(AssertionError e)
        {
			exceldataConfig.putData(0,rowN, 1, "No Item Found");
            System.out.println(item + ": " + e.getMessage());
            assertTrue(elementExists(By.xpath("//*[@id=\"result_0\"]")),"Search result not found");
        }
		String itemName = driver.findElement(By.xpath("//*[@id=\"result_0\"]"))
				.findElement(By.tagName("h2")).getText();
		exceldataConfig.putData(0,rowN, 1, itemName);
		itemName = itemName.substring(1, itemName.indexOf(" "));
		driver.findElement(By.xpath("//*[@id=\"result_0\"]"))
			.findElement(By.className("a-link-normal")).click();
		
		assertTrue(elementExists(By.xpath("//*[@id=\"add-to-cart-button\"]")),"Add to cart is not available");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).click();
		driver.navigate().refresh();
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
		Object[][] data = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			data[i][0] = i;
			data[i][1] = exceldataConfig.getData(0, i, 0);
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
