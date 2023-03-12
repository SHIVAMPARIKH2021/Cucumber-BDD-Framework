package ca.amazon.apphooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ca.amazon.factory.DriverFactory;
import ca.amazon.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
//AppHooks
	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigurationReader configReader;
	Properties prop;
	
	/**
	 * Here for @Before annotation, order=0 will be executed first
	 */
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigurationReader();
		prop = configReader.initialiseProperties();
	}
	
	/**
	 * Here we are storing returning object of 'initialiseDriver()' method.
	 * This way we can avoid null pointer Exception in @After annotaion's methods i.e. quitBrowser() method
	 */
	@Before(order=1)
	public void getBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initialiseDriver(browserName);
		driver.navigate().refresh();
	}
	
	/**
	 * Here for @After annotaion, order=1 will be executed first and than order=0 will be executed
	 */
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	/**
	 * This method will take a screen shot whenever a scenario is going to fail
	 * @throws IOException 
	 * Here to use byte[] is necessary instead of 'File' as we use in TDD Framework
	 * jenkins will take only byte[] type not the 'File' type
	 */
	@After(order=1)
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll("", "_");
			byte[] srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcPath, "image/png", screenShotName);
		}
		
	}
}
