package runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.RetryAcceptance;
import com.vimalselvam.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import library.Configuration;
import library.CustomException;
import library.GenericFunctions;
import library.Reporting;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions()
@CucumberOptions(features="src/test/resources/Features", dryRun=false, glue="src/test/java/stepDefinitions",tags= {"login"},
plugin= {"com.cucmber.listener.ExtentCucumberFormatter:" })

public class TestRunner {
	
	@BeforeClass
	public static void setup() throws Exception {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(Configuration.reportFolder + "report.html");
		GenericFunctions.createScreenShotFolder();
		GenericFunctions.killProcess("chromedriver.exe");
	}
	
	@RetryAcceptance
	public static boolean retryCheck(final Throwable e) {
		return true;
	}
	
	@AfterClass
	public static void tearDown() throws CustomException {
		Reporting.setReportInfo();
	}
	
	
	

}
