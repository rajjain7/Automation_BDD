package library;


import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GenericFunctions {
	
	public static void clickEvent(final WebDriver driver, WebElement element) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
	}
	
	public static void rightClick(final WebDriver driver, WebElement element) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
		
	}
	
	
	public static void focusOnElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].focus()",element);
		
	}
	
	public static void waitForElementtoBeDisplayed(final WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Configuration.explicitWait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void createScreenShotFolder() {
		File ReportsFolder= new File(Configuration.screenshotFolder);
		if(ReportsFolder.exists()) {
			String arr[]=ReportsFolder.list();
			boolean flag=false;
			for(int i=0;i<arr.length;i++) {
				if(arr[i].endsWith("Screenshots")) {
					flag=true;
				}
			}
			if(!flag) {
				if(new File(Configuration.screenshotFolder + "Screenshots/").mkdir()) {
					Log.info("Screenshot Folder Created");
				}
			}
		}
	}
	
	public static String captureScreenshot(final WebDriver driver) throws InterruptedException {
		
		String methodName=Thread.currentThread().getStackTrace()[2].getMethodName();
		
		if(methodName.toUpperCase().startsWith("EXCEPTION")
				|| Boolean.parseBoolean(Configuration.screenshotForAll)==true) {
			String sScreenShotName=methodName + System.currentTimeMillis() + ".JPEG";
			Thread.sleep(7000);
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination = new File (Configuration.screenshot + sScreenShotName);
			
			try{
				FileUtils.copyFile(src, destination);
				Log.info("Screenshot: " +sScreenShotName + " is taken and placed at : " + destination);
			
			} catch (IOException e) {
				System.out.println("Capture Failed "+ e.getMessage());
			}
			return "Screenshots/" + sScreenShotName;
		}else {
			return "";
					}			
	}
	
	public static void killProcess(final String serviceName)  throws CustomException{
		try {
			Runtime.getRuntime().exec("taskkill /F /IM " + serviceName);
			Log.info(serviceName + " is killed from system processes ");
		} catch (IOException e) {
			throw new CustomException(e);
		}
	}
	
	
	
	
	
	

}
