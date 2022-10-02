package ca.amazon.stepdefinitions;

import org.junit.Assert;

import ca.amazon.factory.DriverFactory;
import ca.amazon.pages.SignInPage;
import ca.amazon.pages.SignInRedirectPage;
import ca.amazon.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn {

	SignInPage signinpage = new SignInPage(DriverFactory.getDriver());
	ConfigurationReader configreader;
	
	SignIn signin;
	
	@Given("User should be on SignIn Page")
	public void user_should_be_on_sign_in_page() throws InterruptedException {
		configreader = new ConfigurationReader();
		String URL = configreader.initialiseProperties().getProperty("url");
	    DriverFactory.getDriver().get(URL);
	    DriverFactory.getDriver().navigate().refresh();
	}

	@When("User mouse hover on sign in menu")
	public void user_mouse_hover_on_sign_in_menu() throws InterruptedException {
	    signinpage.signinDropDown();
	}

	@When("Click on the Sign in button")
	public void click_on_the_sign_in_button() throws InterruptedException {
	    signinpage.clickOnSignin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {
	    String title=signinpage.getPageTitle();
	    Assert.assertTrue(title.contains(expectedPageTitle));
	}
	
	@When("User enter the username {string}")
	public void user_enter_the_username(String username) throws InterruptedException {
		signinpage.signinDropDown();
		signinpage.clickOnSignin();
	    signinpage.Email(username);
	}

	@When("User click on sign in button")
	public void user_click_on_sign_in_button() {
	    signinpage.clickOnContinue();
	}

	@Then("User should be redirected to SignInRedirect page")
	public void user_should_be_redirected_to_sign_in_redirect_page() { 
		Assert.assertEquals(signinpage.Continue().getClass(), new SignInRedirectPage().getClass());
	}
	
	@Then("Page title of SignInRedirect  page should be {string}")
	public void page_title_of_sign_in_redirect_page_should_be(String PageTitle) {
	    String NewTitle = signinpage.getPageTitle();
	    Assert.assertTrue(NewTitle.contains(PageTitle));
	}
	
}
