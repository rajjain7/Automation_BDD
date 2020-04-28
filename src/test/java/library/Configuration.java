package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

public class Configuration {

	public static Properties properties;
	public static Properties properties1;
	
	public static String environment;
	public static String browser;
	public static String driverPath;
	public static String webUrl;
	
	public static String implicitWait;
	public static Long explicitWait;
	
	public static String reportLog;
	public static String reportFolder;
	public static String reportExcelFile;
	public static String reportExcelSheetName;
	
	public static String screenshot;
	public static String screenshotFolder;
	public static String screenshotForAll;
	
	public static String hub;
	public static String hubAddress;
	
	public static String userName;
	public static String password;
	
	public static String date;
	public static String defaultWindow;
	
	static {
		try {
			
			propertyConfiguration();
			LogConfiguration();
			setProperties();
			setNode();
			setUser();
			setEnvironment();
			
			browser=properties.getProperty("browser", "IE");
			driverPath=properties.getProperty("driverPath", "src/test/resources/Utility/");
			Log.info("Values from properties file fetched successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setEnvironment(){
		environment=System.getProperty("environment");
		
		if(environment ==null)
			environment="dev";
		
		webUrl=getProperty("applicationUrl");
		
	}
	
	public static void setNode() {
		hub=System.getProperty("hub");
		
		if(hub==null)
			hubAddress="LOCAL";
		else {
			hubAddress="test";
		}
	}
	
	public static void setUser() {
		try {
			userName=System.getProperty("user");
			if (userName==null)
				userName=getProperty("userName");
				password=getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void propertyConfiguration() {
		try {
			FileInputStream fis=new FileInputStream(new File("src/test/resources/Config/Config.properties"));
			properties=new Properties();
			properties.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void logConfiguration() {
		DateFormat dateFormat=new SimpleDateFormat(
				Configuration.properties.getProperty("dateFormat", "dd_MM_yyyy_HH_mm_ss"));
		Configuration.date=dateFormat.format(new Date());
		System.setProperty("my.logsDir", ".target/cucumber-reports/" + Configuration.date + "/report.log");
		DOMConfigurator.configure("log4j.xml");
		Log.info("log4j is configured successfully");
		
		}
	}
	
	

