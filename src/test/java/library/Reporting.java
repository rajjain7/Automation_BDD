package library;

import com.vimalselvam.cucumber.listener.Reporter;

public class Reporting {
	
	public static void setReportInfo() throws CustomException{
		try {
			Reporter.loadXMLConfig("src/test/resources/Config/extent-config.xml");
			
		}
		
	}

}
