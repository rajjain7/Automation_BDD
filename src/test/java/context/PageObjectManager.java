package context;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	public PageObjectManager(final WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLoginPage() {
		if(this.loginPage==null) {
			this.loginPage=new LoginPage(this.driver);
		}
		return this.loginPage;
	}
	
	
	

}
