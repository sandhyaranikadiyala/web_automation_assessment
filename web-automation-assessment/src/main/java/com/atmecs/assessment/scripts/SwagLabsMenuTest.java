package com.atmecs.assessment.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.assessment.base.TestBase;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.pages.SwagLabsLoginPage;
import com.atmecs.assessment.pages.SwagLabsMenuPage;
import com.atmecs.assessment.utils.ExcelDataProvider;

public class SwagLabsMenuTest extends TestBase {

	@Test
	public void testMenuItems() {

		Reporter.log(InfoMessages.OPENING_BROWSER_MESSAGE);
		browser.openURL(ExcelDataProvider.URL);
		Reporter.log(InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
		browser.maximizeWindow();

		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage();
		boolean loginStatus = swagLabsLoginPage.login(ExcelDataProvider.USERNAME, ExcelDataProvider.PASSWORD,
				browser.getDriver());

		if (loginStatus == true) {

			SwagLabsMenuPage swagLabsMenuPage = new SwagLabsMenuPage();
			swagLabsMenuPage.testMenuButton(browser.getDriver());
			swagLabsMenuPage.testAllItemsButton(browser.getDriver());
			swagLabsMenuPage.testAboutButton(browser.getDriver());
			swagLabsMenuPage.testResetAppStateButton(browser.getDriver());
			swagLabsMenuPage.testLogoutButton(browser.getDriver());

		} else {

			Reporter.log(InfoMessages.LOGIN_FAILED);

		}

	}

}
