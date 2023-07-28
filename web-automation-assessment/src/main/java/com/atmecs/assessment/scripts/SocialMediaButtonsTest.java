package com.atmecs.assessment.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.atmecs.assessment.base.TestBase;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.pages.SocialMediaButtons;
import com.atmecs.assessment.pages.SwagLabsLoginPage;
import com.atmecs.assessment.utils.ExcelDataProvider;

/**
 * This class is used to verify that Twitter, Facebook & LinkedIn buttons are
 * visible and redirecting to their respective pages.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class SocialMediaButtonsTest extends TestBase {

	@Test
	public void testSocialMediaButtons() {

		Reporter.log(InfoMessages.OPENING_BROWSER_MESSAGE);
		browser.openURL(ExcelDataProvider.URL);
		Reporter.log(InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
		browser.maximizeWindow();

		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage();
		boolean loginSuccess = swagLabsLoginPage.login(ExcelDataProvider.USERNAME, ExcelDataProvider.PASSWORD,
				browser.getDriver());
		if (loginSuccess == true) {
			SocialMediaButtons socialMediaButtonsPage = new SocialMediaButtons();
			socialMediaButtonsPage.socialMediaButtons(browser.getDriver());

			swagLabsLoginPage.logout(browser.getDriver());
		} else {

			Reporter.log(InfoMessages.LOGIN_FAILED);

		}

	}

}
