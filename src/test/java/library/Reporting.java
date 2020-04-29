package library;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

public class Reporting {
	
	public static void setReportInfo() throws CustomException{
		try {
			Reporter.loadXMLConfig("src/test/resources/Config/extent-config.xml");
			Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
			Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
			Reporter.setSystemInfo("Operating System", System.getProperty("os.name"));
			Reporter.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
			Reporter.setSystemInfo("OS Version", System.getProperty("os.version"));
			Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
			
			Reporter.setSystemInfo("Browser:", Configuration.browser);
			Reporter.setSystemInfo("Application URL:", Configuration.webUrl);
			Reporter.setSystemInfo("Screenshot For All:", Configuration.screenshotForAll);
			Reporter.setSystemInfo("Report Folder:", Configuration.reportFolder);
			Reporter.setSystemInfo("Driver Path:", Configuration.driverPath);
			
			Reporter.setSystemInfo("Node:", Configuration.hub + " - " + Configuration.hubAddress);
			Reporter.setSystemInfo("Failed Retest Retry Attempt : " , System.getProperty("cucumber.reports.retryCount"));
			
				
		} catch (Exception e) {
			throw new CustomException(e);
		}
		
	}
	
	public static void attachScreenshot(WebDriver driver) throws IOException{
		
		Reporter.addScreenCaptureFromPath(GenericFunctions.captureScreenshot(driver));
	}
	
	public static void stepLog(String message) {
		
		Reporter.addStepLog("<br>" + message + "<br>");
	}
	
	

	

}
