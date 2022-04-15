package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContextManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDef {
	
	TestContextManager context;
	LoginPage loginPageObj;
	HomePage homePageObj;
	WebDriver driver;
	
	
	public LoginStepDef(final TestContextManager testContext) {
		this.context=testContext;
		this.loginPageObj=this.context.getPageObjectManager().getLoginPage();
		this.homePageObj=this.context.getPageObjectManager().getHomePage();
		this.driver=this.context.webDriverManager.getDriver();
	}
	
	@Given("^user is on the login page of the application$")
	public void user_is_on_the_login_page_of_the_application() throws Throwable{
		loginPageObj.verifyLoginPageTitle();
	
		
	}
	
	@And("^user enters username,password and clicks on login$") 
	public void user_enters_username_password_and_clicks_on_login() throws Throwable{
		loginPageObj.loginAppliaction();
	}
	
	@Then("^user should be navigated to the homepage of the application$")
	public void user_should_be_navigated_to_the_homepage_of_the_application() throws Throwable{
		homePageObj.verifyHomePageTitle();
		
	}
	
	
	

}
