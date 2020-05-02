package context;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
	public PageObjectManager(final WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLoginPage() {
		if(this.loginPage==null) {
			this.loginPage=new LoginPage(this.driver);
		}
		return this.loginPage;
	}
	
	public HomePage getHomePage() {
		if(this.homePage==null) {
			this.homePage=new HomePage(this.driver);
		}
		return this.homePage;
	}
	
	
	

}
