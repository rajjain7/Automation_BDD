package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
			logConfiguration();
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
	

	public static void setProperties() {
		try {
			implicitWait=properties.getProperty("implicitWait","10");
			explicitWait=Long.parseLong(properties.getProperty("explicitWait", "60"));
			
			reportLog=properties.getProperty("reportLog","./output/") + date + "/report.log";
			reportFolder=properties.getProperty("reportFolder","./output") + date + "/";
			reportExcelFile=properties.getProperty("reportExcelFile","./output/") + date + "/report.xlsx";
			reportExcelSheetName=properties.getProperty("reportExcelSheetName","Status");
			
			screenshot=properties.getProperty("screenshotFolder","./output/") + date + "/Screenshots/";
			screenshotFolder=properties.getProperty("screenshotFolder","./output/") + date + "/";
			screenshotForAll=properties.getProperty("screenshotForAll","NO");
			
			//testDataSheetPath=properties.getProperty("testDataSheetPath");
			
		}catch (Exception e) {
			Log.error("There is some problem in getting properties from config file "+e.getMessage());
			e.printStackTrace();
		}
		}
		
		public static String getProperty(String propertyName) {
			@SuppressWarnings("unused")
			InputStream input=null;
			
			try {
				String fileName=environment+".properties";
				FileInputStream fis=new FileInputStream(new File("src/test/resources/Config/"+fileName));
				properties1=new Properties();
				properties.load(fis);
				
			}catch (IOException ex) {
				ex.printStackTrace();
				
			}
		
			return properties1.getProperty(propertyName);
			
						
			
}}
	
	
	

