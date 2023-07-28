package com.atmecs.assessment.browserinterface;

import org.openqa.selenium.WebDriver;

/**
 * This is interface class for abstract methods related to browser.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public interface IBrowser {

	/**
	 * This method is used to open the browser with a URL
	 *
	 * @param URL
	 */
	public void openURL(String URL);

	/**
	 * This method closes the browser.
	 */
	public void closeBrowser();

	/**
	 * This method maximizes the browser window.
	 */
	public void maximizeWindow();

	/**
	 * This method refreshes the browser.
	 */
	public void refreshBrowser();

	/**
	 * This method gets the currently opened url in browser.
	 */
	public String getCurrentURL();

	/**
	 * This method is used to get webdriver instance
	 *
	 * @return
	 */
	public WebDriver getDriver();

	/**
	 * This method is used to get currently opened page title
	 *
	 * @return
	 */
	public String getCurrentPageTitle();
}
