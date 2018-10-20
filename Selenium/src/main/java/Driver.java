import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	static WebDriver driver;
	static String url = "http://newtours.demoaut.com/";
	
	public static void main(String[] args) throws InterruptedException{
		//Chrome
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();
		
		driver.get(url);
		Thread.sleep(2000);
		checkTitle("Welcome: Mercury Tours");
		driver.quit();	//Very important
		/*
		 * You will have background processes you have to force quit if you do
		 * not end the application with this
		 */
		
		//Firefox
//		System.setProperty("webdriver.gecko.driver","Driver/geckodriver");
//		driver = new FirefoxDriver();
//		
//		driver.get(url);
//		Thread.sleep(2000);
//		driver.quit();
	}
	
	public static void checkTitle(String expected) {
		String testString = "Test: ";
		String actual = driver.getTitle();
		if(!actual.equals(expected)) {
			System.out.println(testString + "Failed");
			System.out.println("Expected \'" + expected + "\'");
			System.out.println("Actual \'" + actual + "\'");
		}else {
			System.out.println(testString + "Passed");
		}
	}
}
