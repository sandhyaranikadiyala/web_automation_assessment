package com.atmecs.assessment.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.messages.ErrorMessages;
import com.atmecs.assessment.page.keys.MenuItemsPageKeys;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class SwagLabsMenuPage {
	PropertyParser propertyParser_MenuPage, propertyParser_HomePage;
	private static final Logger logger = LogManager.getLogger(SwagLabsMenuPage.class);

	public SwagLabsMenuPage() {
		propertyParser_MenuPage = new PropertyParser(FilePathConstants.MENU_PAGE_LOCATOR_FILE_PATH);
		propertyParser_HomePage = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);

	}

	public void testMenuButton(WebDriver driver) {
		try {
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

		} catch (NoSuchElementException noSuchElementException) {
			logger.error(noSuchElementException.getLocalizedMessage());
		}

	}

	public void testAllItemsButton(WebDriver driver) {
		String allItemsButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.ALL_ITEMS_BUTTON_KEY);
		if (allItemsButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.ALL_ITEMS_BUTTON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement allItemsButton = driver.findElement(By.xpath(allItemsButtonXpath));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allItemsButtonXpath)));
		boolean allItemsButton_Enabled=allItemsButton.isDisplayed();
		Verify.verifyBoolean(allItemsButton.isDisplayed(),allItemsButton_Enabled, "All Items link is working properly");
		allItemsButton.click();

		String addToCartButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.ADD_TO_CART_KEY);
		if (addToCartButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.ADD_TO_CART_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}

		WebElement addToCart = driver.findElement(By.xpath(addToCartButtonXpath));
		addToCart.click();
		logger.info("Click All Items Button added item to the cart");

	}

	public void testAboutButton(WebDriver driver) {

		String AboutButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.ABOUT_BUTTON_KEY);
		if (AboutButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.ABOUT_BUTTON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement aboutButton = driver.findElement(By.xpath(AboutButtonXpath));
		boolean aboutButton_Enabled=aboutButton.isDisplayed();
		Verify.verifyBoolean(aboutButton.isDisplayed(),aboutButton_Enabled, "About link button is working properly");
		aboutButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Verify.verifyString(driver.getTitle(), "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing",
				"About link text as expected.");
		logger.info("Click About Button and get the title");
		driver.navigate().back();

	}

	public void testResetAppStateButton(WebDriver driver) {
		String menuButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.MENU_BUTTON_KEY);
		WebElement menuBtn = driver.findElement(By.xpath(menuButtonXpath));
		menuBtn.click();

		String resetAppStateButtonXpath = propertyParser_MenuPage
				.getPropertyValue(MenuItemsPageKeys.RESET_APP_STATE_BUTTON_KEY);
		if (resetAppStateButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX
					+ MenuItemsPageKeys.RESET_APP_STATE_BUTTON_KEY + ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement resetAppStateButton = driver.findElement(By.xpath(resetAppStateButtonXpath));
		resetAppStateButton.click();
		String cartIconXpath = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.CART_ICON_KEY);
		if (cartIconXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.CART_ICON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}

		WebElement cartIcon = driver.findElement(By.xpath(cartIconXpath));
		List<WebElement> cartItems = driver.findElements(By.xpath(cartIconXpath));
		
		Verify.verifyString("cart items:: "+cartItems.size(),"cart items:: "+ 0, "Reset App State functionality is clear the cart .");
		logger.info("Reset App State Button is working correctly");

	}

	public void testLogoutButton(WebDriver driver) {
		String logoutButtonXpath = propertyParser_MenuPage.getPropertyValue(MenuItemsPageKeys.LOGOUT_BUTTON_KEY);
		if (logoutButtonXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + MenuItemsPageKeys.LOGOUT_BUTTON_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement logoutButton = driver.findElement(By.xpath(logoutButtonXpath));
		boolean logoutButton_Enabled=logoutButton.isDisplayed();
		Verify.verifyBoolean(logoutButton.isDisplayed(), logoutButton_Enabled,"Logout button is working properly");
		logoutButton.click();
	}
}
