package library;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventImplementations implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Log.info("Trying to accept Alert");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		Log.info("Alert Accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		Log.info("Alert Dismissed");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		Log.info("Trying to dismiss Alert");
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		Log.info("");
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		Log.info("");
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if (element!=null) {
			Log.info("Found Element By: " +element.toString());
		}
			else {
				Log.info("After searching for element on page - " + driver.getTitle() + " element is not found");
			}
			
		}
		
	

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		try {
			throwable.printStackTrace();
			Reporting.attachScreenshot(driver);
			Log.error("Screenshot is attached to report on Exception - " + throwable.getStackTrace());
		} catch (IOException e) {
			Log.error(e.toString());
			e.printStackTrace();
		}
		
	}

}
