package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePageTitle() {
		//driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "");
	}

}
