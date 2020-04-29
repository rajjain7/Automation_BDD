package library;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverManager {
	
	private WebDriver webDriver;
	private DesiredCapabilities capabilities;
	private EventFiringWebDriver driver;
	
	private Boolean isBrowserClosed;
	
	private EventImplementations eventImplementations=new EventImplementations();
	
	public void setIsBrowserClosed(final Boolean browserStatus) {
		this.isBrowserClosed=browserStatus;
	}
	
	public WebDriver getDriver(){
		if(this.driver!=null)
			return this.driver;
			return initializeDriver(Configuration.browser);
		
	}
	
	public WebDriver initializeDriver(String browser) {
		try {
			if(!Configuration.hubAddress.equalsIgnoreCase("LOCAL")) {
				System.setProperty("java.awt.headless", "false");
				
				switch (browser.toUpperCase()) {
				
				case "IE":
				case "INTERNET EXPLORER":
					capabilities=DesiredCapabilities.internetExplorer();
					capabilities.setBrowserName("internet explorer");
					capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					webDriver = new RemoteWebDriver(new URL(Configuration.hubAddress), capabilities);
					break;
					
				case "CH":
				case "CHROME":
					capabilities=DesiredCapabilities.chrome();
					capabilities.setBrowserName("chrome");
					ChromeOptions options=new ChromeOptions();
					options.merge(capabilities);
					webDriver=new RemoteWebDriver(new URL(Configuration.hubAddress),options);
					break;
							
				}
			}else {
				switch (browser.toUpperCase()) {
				case "IE":
				case "INTERNET EXPLORER":
					System.setProperty("webdriver.ie.driver", Configuration.driverPath + "IEDriverServer.exe");
					capabilities=DesiredCapabilities.internetExplorer();
					capabilities.setCapability("unexpectedAlertBehaviour","accept");
					capabilities.setCapability("ignoreZoomSetting", true);
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					InternetExplorerOptions options=new InternetExplorerOptions();
					options.merge(capabilities);
					webDriver =new InternetExplorerDriver(options);
					break;
					
				case "CH":
				case "CHROME":
					System.setProperty("webdriver.chrome.driver", Configuration.driverPath + "ChromeDriver.exe");
					ChromeOptions opts=new ChromeOptions();
					opts.setExperimentalOption("useAutomationExtension", false);
					webDriver = new ChromeDriver(opts);
					break;
					
				default:
					Log.info("Please provide IE or Chrome browser in Config file");
					break;	
					
				}
			}
			
			driver=new EventFiringWebDriver(webDriver);
			driver.register(eventImplementation);
			driver.manage().window().maximize();
			((RemoteWebDriver) webDriver).setFileDetector(new LocalFileDetector());
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.driver;
	}
	
	public void CloseDriver() {
		try {
			if(webDriver!=null) {
				webDriver.quit();
				setIsBrowserClosed(true);
			}else {
				Log.info("Driver instance is closed already");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

	
}
