package com.atmecs.assessment.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.assessment.browser.Browser;
import com.atmecs.assessment.browserinterface.IBrowser;

/**
 * This is base class initializing web drivers and extent report
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class TestBase {
	public IBrowser browser = null;

	@BeforeClass
	public void beforeClass() {
		browser = new Browser();
	}

	@AfterClass
	public void afterClass() {
		browser.closeBrowser();
	}

}
