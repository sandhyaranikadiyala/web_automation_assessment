package com.atmecs.assessment.browser;

import com.atmecs.assessment.browserinterface.IBrowser;
import com.atmecs.assessment.driver.DriverManager;
import com.atmecs.assessment.enums.BrowserType;

import org.openqa.selenium.WebDriver;

public class Browser implements IBrowser {
	WebDriver driver = null;

	@Override
	public void openURL(String URL) {
		if (driver == null) {
			 
			DriverManager driverManager = new DriverManager();
			driver = driverManager.getWebDriver();
		}
		driver.get(URL);
	}

	@Override
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	@Override
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	@Override
	public void refreshBrowser() {
		driver.navigate().refresh();
	}

	@Override
	public String getCurrentURL() {
		String currentURL = null;

		try {
			currentURL = driver.getCurrentUrl();
		} catch (NullPointerException nullPointerException) {
			System.out.println("Browser is not available to get the current url " + nullPointerException.getMessage());
		}

		return currentURL;
	}

	@Override
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public String getCurrentPageTitle() {
		String currentPageTitle = null;

		try {
			currentPageTitle = driver.getTitle();
		} catch (NullPointerException nullPointerException) {
			System.out.println("Browser is not available to close the browser " + nullPointerException.getMessage());
		}

		return currentPageTitle;
	}

}
