package context;

import library.WebDriverManager;

public class TestContextManager {
	
	public WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContextManager() {
		this.webDriverManager=new WebDriverManager();
		this.pageObjectManager=new PageObjectManager(this.webDriverManager.getDriver());
		this.webDriverManager.setIsBrowserClosed(false);
	}

	public PageObjectManager getPageObjectManager() {
		return this.pageObjectManager;
	}
	
	public WebDriverManager getWebDriverManager() {
		return this.webDriverManager;
	}
	
	

}
