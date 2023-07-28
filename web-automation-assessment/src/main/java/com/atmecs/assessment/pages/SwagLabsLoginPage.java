package com.atmecs.assessment.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.messages.ErrorMessages;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.page.keys.LoginPageKeys;
import com.atmecs.assessment.page.keys.MenuItemsPageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class SwagLabsLoginPage {
	PropertyParser propertyParser_LoginPage,propertyParser_MenuPage;
	private static final Logger logger = LogManager.getLogger(SwagLabsLoginPage.class);

	public SwagLabsLoginPage() {
		propertyParser_LoginPage = new PropertyParser(FilePathConstants.LOGIN_PAGE_LOCATOR_FILE_PATH);
		propertyParser_MenuPage = new PropertyParser(FilePathConstants.MENU_PAGE_LOCATOR_FILE_PATH);
		
	}

	public boolean login(String usernameText, String passwordText, WebDriver driver) {
		if (usernameText.length() == 0 || passwordText.length() == 0 || driver == null) {
			return false;
		}

		try {
			String usernameTextFieldXPath = propertyParser_LoginPage.getPropertyValue(LoginPageKeys.USERNAME_TEXT_FIELD_KEY);
			String passwordTextFieldXPath = propertyParser_LoginPage.getPropertyValue(LoginPageKeys.PASSWORD_TEXT_FIELD_KEY);
			String loginTextFieldXPath = propertyParser_LoginPage.getPropertyValue(LoginPageKeys.LOGIN_BUTTON_KEY);

			if (usernameTextFieldXPath.length() == 0 || passwordTextFieldXPath.length() == 0) {
				logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX
						+ LoginPageKeys.USERNAME_TEXT_FIELD_KEY + "or" + LoginPageKeys.PASSWORD_TEXT_FIELD_KEY
						+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
				return false;
			}

			WebElement usernameTextField = driver.findElement(By.xpath(usernameTextFieldXPath));

			WebElement passwordTextField = driver.findElement(By.xpath(passwordTextFieldXPath));
			usernameTextField.sendKeys(usernameText);
			passwordTextField.sendKeys(passwordText);

			WebElement loginButton = driver.findElement(By.xpath(loginTextFieldXPath));

			loginButton.click();

			return true;
		} catch (Exception exception) {
			logger.error(exception.getLocalizedMessage());

		}
		return false;
	}

	public void logout(WebDriver driver) {
		String menuButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.MENU_BUTTON_KEY);
		if (menuButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.MENU_BUTTON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement menuButton = driver.findElement(By.xpath(menuButtonXpath));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(menuButton));
		menuButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String logoutButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.LOGOUT_BUTTON_KEY);
		if (logoutButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.LOGOUT_BUTTON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutButtonXpath)));
		logoutButton.click();
		Reporter.log(InfoMessages.LOGOUT_MESSAGE);
		WebElement loginButtonAfterLogout = driver.findElement(By.id("login-button"));
		boolean loginButtonAfterLogout_Enabled=loginButtonAfterLogout.isDisplayed();
		Verify.verifyBoolean(loginButtonAfterLogout.isDisplayed(),loginButtonAfterLogout_Enabled, "Logout Success");

	}
}
