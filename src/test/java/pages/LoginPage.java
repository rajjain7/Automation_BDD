package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import library.Configuration;
import library.GenericFunctions;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="__w2_wFRKVF3O20_email")
	private WebElement username;
	
	@FindBy(id="__w2_wFRKVF3O20_password")
	private WebElement password;
	
	@FindBy(id="__w2_wFRKVF3O20_submit_button")
	private WebElement login;
	
	//@FindBy(xpath="")
	//private WebElement t;
	
	
	public void loginAppliaction() throws InterruptedException {
		//driver.get(Configuration.webUrl);
		//GenericFunctions.switchToNewWindow(driver);
		username.sendKeys(Configuration.userName);
		password.sendKeys(Configuration.password);
		login.submit();
	}
	
	public void verifyLoginPageTitle() throws InterruptedException {
		driver.get(Configuration.webUrl);
		GenericFunctions.switchToNewWindow(driver);
		Assert.assertEquals(driver.getTitle(), "");
		
	}

}
