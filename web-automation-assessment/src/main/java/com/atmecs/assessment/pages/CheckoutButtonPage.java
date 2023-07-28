package com.atmecs.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.page.keys.CheckOutPageKeys;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class CheckoutButtonPage {
	PropertyParser propertyParser_CheckOutPage,propertyParser_HomePage;
	
	public CheckoutButtonPage() {
		propertyParser_CheckOutPage = new PropertyParser(FilePathConstants.CHECKOUT_PAGE_LOCATOR_FILE_PATH);
		propertyParser_HomePage = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);

	}

	public void checkoutButton(WebDriver driver) {

		String addToCartIconID = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.ADDTOCART_ICON_ID);
		WebElement addToCartIcon = driver.findElement(By.id(addToCartIconID));
		addToCartIcon.click();
		String checkoutButtonID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.CHECKOUT_BUTTON_KEY);
		WebElement checkoutButton = driver.findElement(By.id(checkoutButtonID));
		
		boolean checkoutButton_Disabled=!checkoutButton.isEnabled();
		
		Verify.verifyStringAndStopTest(checkoutButton.isEnabled(), checkoutButton_Disabled, "Checkout Button should be disabled with out adding product");
		Reporter.log("Checkout Button should be disabled with out adding product");

	}

}
