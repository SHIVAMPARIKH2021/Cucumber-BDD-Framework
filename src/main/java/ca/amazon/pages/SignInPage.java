package ca.amazon.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignInPage {
	
	 private WebDriver driver;
	 private static Actions action;

	 //1.By Locators
	 private By SignInDropDown = By.xpath("//span[text()= 'Hello, sign in']");
	 private By SignInButton = By.xpath("//span[text()='Sign in']");
	 private By EmailorMobile = By.id("ap_email");
	 private By ContinueButton = By.xpath("//input[@tabindex='5'and@id='continue']");
    
	 //Constructor of the Page
	 public SignInPage(WebDriver driver) {
		this.driver = driver;
	 }
	 
	
	 //3. Page acitons: methods to create Test Cases
	 public void signinDropDown() throws InterruptedException{
		action = new Actions(driver);
		action.moveToElement(driver.findElement(SignInDropDown)).build().perform();
	 }
	 
	 public void clickOnSignin() throws InterruptedException {
		 action = new Actions(driver);
		 action.moveToElement(driver.findElement(SignInButton)).build().perform();
		 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		 action.click(driver.findElement(SignInButton)).build().perform();
	 }
	 
	 public void clickOnContinue() {
		 action = new Actions(driver);
		 action.moveToElement(driver.findElement(ContinueButton)).build().perform();
		 action.click();
	 }
	
	 public void Email(String username) {
		driver.findElement(EmailorMobile).click();
		driver.findElement(EmailorMobile).sendKeys(username);
	 }
	
	 public SignInRedirectPage Continue() {
		driver.findElement(ContinueButton).click();
		return new SignInRedirectPage();
	 }
	
	 public String getPageTitle() {
		return driver.getTitle();
	 }
}
