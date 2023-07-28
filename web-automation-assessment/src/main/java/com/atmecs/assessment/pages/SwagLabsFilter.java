package com.atmecs.assessment.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.messages.ErrorMessages;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class SwagLabsFilter {
	PropertyParser propertyParser;
	private static final Logger logger = LogManager.getLogger(SwagLabsFilter.class);

	public SwagLabsFilter() {
		propertyParser = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);
	}

	public void testFilterPage(WebDriver driver) {
		String dropdownFilterXpath = propertyParser.getPropertyValue(ProductHomePageKeys.DROPDOWN_SELECTOR_KEY);
		if (dropdownFilterXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.DROPDOWN_SELECTOR_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement dropdownFilter = driver.findElement(By.xpath(dropdownFilterXpath));
		dropdownFilter.click();
		String optionAZXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_AZ_KEY);
		if (optionAZXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.OPTION_AZ_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement optionAZ = driver.findElement(By.xpath(optionAZXpath));
		boolean optionAZ_Enabled=optionAZ.isDisplayed();
		Verify.verifyBoolean(optionAZ.isDisplayed(),optionAZ_Enabled, "Option 'Name (A to Z)' is displayed");
		optionAZ.click();
		String optionAZ_AddCartXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_AZ_ADDTOCART_KEY);
		WebElement optionAZ_AddCart = driver.findElement(By.xpath(optionAZ_AddCartXpath));
		optionAZ_AddCart.click();
		Reporter.log("Product added to the cart using dropdown filter optionAZ");

		String optionZAXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_ZA_KEY);
		if (optionZAXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.OPTION_ZA_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement optionZA = driver.findElement(By.xpath(optionZAXpath));
		boolean optionZA_Enabled=optionZA.isDisplayed();
		Verify.verifyBoolean(optionZA.isDisplayed(),optionZA_Enabled, "Option 'Name (Z to A)' is displayed");
		dropdownFilter.click();
		optionZA.click();
		String optionZA_AddCartXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_ZA_ADDTOCART_KEY);
		WebElement optionZA_AddCart = driver.findElement(By.xpath(optionZA_AddCartXpath));
		optionZA_AddCart.click();
		Reporter.log("Product added to the cart using dropdown filter optionZA");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement filterDropdwn = driver.findElement(By.xpath(dropdownFilterXpath));
		filterDropdwn.click();

		String optionLOHIXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_LOHI_KEY);
		if (optionLOHIXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.OPTION_LOHI_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement optionLOHI = driver.findElement(By.xpath(optionLOHIXpath));
		boolean optionLOHI_Enabled=optionLOHI.isDisplayed();
		Verify.verifyBoolean(optionLOHI.isDisplayed(),optionLOHI_Enabled, "Option 'Price (low to high)' is displayed");
		optionLOHI.click();
		String optionLOHI_AddCartXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_LOHI_ADDTOCART_KEY);
		WebElement optionLOHI_AddCart = driver.findElement(By.xpath(optionLOHI_AddCartXpath));
		optionLOHI_AddCart.click();
		Reporter.log("Product added to the cart using dropdown filter optionLOHI");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement filterDrpdwn = driver.findElement(By.xpath(dropdownFilterXpath));
		filterDrpdwn.click();

		String optionHILOXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_HILO_KEY);
		if (optionHILOXpath.length() == 0) {
			logger.error(ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + ProductHomePageKeys.OPTION_HILO_KEY
					+ ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
			return;
		}
		WebElement optionHILO = driver.findElement(By.xpath(optionHILOXpath));
		boolean optionHILO_Enabled=optionHILO.isDisplayed();
		Verify.verifyBoolean(optionHILO.isDisplayed(), optionHILO_Enabled,"Option 'Price (high to low)' is displayed");
		optionHILO.click();
		String optionHILO_AddCartXpath = propertyParser.getPropertyValue(ProductHomePageKeys.OPTION_HILO_ADDTOCART_KEY);
		WebElement optionHILO_AddCart = driver.findElement(By.xpath(optionHILO_AddCartXpath));
		optionHILO_AddCart.click();
		Reporter.log("Product added to the cart using dropdown filter optionHILO");
		Reporter.log("The dropdown filters working properly");

	}

}
