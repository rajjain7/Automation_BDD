package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="")
	private WebElement username;
	
	@FindBy(id="")
	private WebElement password;
	
	

}
