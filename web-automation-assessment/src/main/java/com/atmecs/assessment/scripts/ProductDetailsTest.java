package com.atmecs.assessment.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.assessment.base.TestBase;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.pages.ProductDetailsPage;
import com.atmecs.assessment.pages.SwagLabsLoginPage;
import com.atmecs.assessment.utils.ExcelDataProvider;

/**
 * This class is used to verify product name, price, and the image is displayed
 * correctly, and the Remove button is enabled.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ProductDetailsTest extends TestBase {

	@Test
	public void testProductDetails() {

		Reporter.log(InfoMessages.OPENING_BROWSER_MESSAGE);
		browser.openURL(ExcelDataProvider.URL);
		Reporter.log(InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
		browser.maximizeWindow();

		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage();
		boolean loginSuccess = swagLabsLoginPage.login(ExcelDataProvider.USERNAME, ExcelDataProvider.PASSWORD,
				browser.getDriver());
		if (loginSuccess == true) {

			ProductDetailsPage productDetailsPage = new ProductDetailsPage();
			productDetailsPage.ProductDetails(browser.getDriver());

			swagLabsLoginPage.logout(browser.getDriver());

		} else {

			Reporter.log(InfoMessages.LOGIN_FAILED);

		}

	}
}
