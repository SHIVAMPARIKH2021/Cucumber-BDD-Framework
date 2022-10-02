package ca.amazon.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	protected static Logger log = Logger.getLogger(DriverFactory.class);
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
	/**
	 * This method will initialise(set) the 'theradLocalDriver' according to value of the method argument
	 * theradLocalDriver is used with Generic <WebDriver>
	 */
	public WebDriver initialiseDriver(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
			log.info("Connecting with 'Chrome' Browser");
		}
		
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			threadLocalDriver.set(new EdgeDriver());
			getDriver().navigate().refresh();
			log.info("Connecting with 'Chrome' Browser");
		}
		
		else {
			log.info("Failed to connect with browser "+ browser+". Please enter the correct browser name");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}
}
