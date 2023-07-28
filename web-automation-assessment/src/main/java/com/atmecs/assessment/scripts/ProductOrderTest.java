package com.atmecs.assessment.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.assessment.base.TestBase;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.pages.ProductOrderPage;
import com.atmecs.assessment.pages.SwagLabsLoginPage;
import com.atmecs.assessment.utils.ExcelDataProvider;

/**
 * This class is used to add a product with lowest price and verify the product
 * order functionality.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ProductOrderTest extends TestBase {

	@Test
	public void testProductOrderFunctionality() {

		Reporter.log(InfoMessages.OPENING_BROWSER_MESSAGE);
		browser.openURL(ExcelDataProvider.URL);
		Reporter.log(InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
		browser.maximizeWindow();

		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage();
		boolean loginSuccess = swagLabsLoginPage.login(ExcelDataProvider.USERNAME, ExcelDataProvider.PASSWORD,
				browser.getDriver());
		if (loginSuccess == true) {

			ProductOrderPage productOderPage = new ProductOrderPage();
			
			productOderPage.addLowestPriceItem(browser.getDriver());
			productOderPage.clickCartButton(browser.getDriver());
			productOderPage.clickCheckoutButton(browser.getDriver());
			productOderPage.clickContinueButton(browser.getDriver());
			productOderPage.clickFinishButton(browser.getDriver());

			swagLabsLoginPage.logout(browser.getDriver());
		} else {

			Reporter.log(InfoMessages.LOGIN_FAILED);

		}
		

	}

}
