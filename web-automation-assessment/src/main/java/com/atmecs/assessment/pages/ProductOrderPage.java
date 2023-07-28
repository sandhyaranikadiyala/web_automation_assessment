package com.atmecs.assessment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.atmecs.assessment.constants.Constants;
import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.messages.InfoMessages;
import com.atmecs.assessment.page.keys.CheckOutPageKeys;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.page.keys.YourCartPageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class ProductOrderPage {
	PropertyParser propertyParser_HomePage, propertyParser_CartPage, propertyParser_CheckOutPage;
	
	public ProductOrderPage() {
		propertyParser_HomePage = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);
		propertyParser_CartPage = new PropertyParser(FilePathConstants.YOUR_CART_PAGE_LOCATOR_FILE_PATH);
		propertyParser_CheckOutPage = new PropertyParser(FilePathConstants.CHECKOUT_PAGE_LOCATOR_FILE_PATH);

	}

	public void addLowestPriceItem(WebDriver driver) {

		String dropDownSelectorXpath = propertyParser_HomePage
				.getPropertyValue(ProductHomePageKeys.DROPDOWN_SELECTOR_KEY);
		String addToCartLowPriceXpath = propertyParser_HomePage
				.getPropertyValue(ProductHomePageKeys.ADDTOCART_LOWPRICE_KEY);
		WebElement dropDownValue = driver.findElement(By.xpath(dropDownSelectorXpath));
		dropDownValue.click();
		Select dropdown = new Select(dropDownValue);
		dropdown.selectByIndex(2);

		WebElement addToCart = driver.findElement(By.xpath(addToCartLowPriceXpath));
		addToCart.click();
		Reporter.log(InfoMessages.LOW_PRICE_MESSAGE);

	}

	public void clickCartButton(WebDriver driver) {

		String addToCartIconID = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.ADDTOCART_ICON_ID);
		WebElement addToCartIcon = driver.findElement(By.id(addToCartIconID));
		addToCartIcon.click();

		List<WebElement> cartItems = driver.findElements(By.id(addToCartIconID));
		Verify.verifyString("cart size::"+cartItems.size(), "cart size::"+1, "Product added to the cart with low price.");

		String cartProduct_ClassName = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CART_PRODUCT_CLASSNAME);
		WebElement cartProduct = driver.findElement(By.className(cartProduct_ClassName));

		String cartProductName_ClassName = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CART_PRODUCT_NAME_KEY);
		String cartProductName = driver.findElement(By.className(cartProductName_ClassName)).getText();

		Verify.verifyString(cartProductName, "Sauce Labs Onesie", "Product Name Matched");

		String removeButtonID = propertyParser_CartPage.getPropertyValue(YourCartPageKeys.REMOVE_BUTTON_KEY);
		WebElement removeButton = driver.findElement(By.id(removeButtonID));
		boolean removeButton_Enabled = removeButton.isEnabled();
		Verify.verifyBoolean(removeButton.isEnabled(), removeButton_Enabled, "Remove button is working properly");
		Reporter.log("Remove button is working properly");

		String continueShoppingButtonID = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CONTINUE_SHOPPING_BUTTON_KEY);
		WebElement continueShoppingButton = driver.findElement(By.id(continueShoppingButtonID));
		boolean continueShoppingButton_Enabled=continueShoppingButton.isEnabled();
		Verify.verifyBoolean(continueShoppingButton.isEnabled(),continueShoppingButton_Enabled, "Continue shopping button is working properly");
		Reporter.log("Continue shopping button is working properly");
	}

	public void clickCheckoutButton(WebDriver driver) {

		String checkoutButtonID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.CHECKOUT_BUTTON_KEY);
		WebElement checkoutButton = driver.findElement(By.id(checkoutButtonID));
		boolean checkoutButton_Enabled=checkoutButton.isEnabled();
		Verify.verifyBoolean(checkoutButton.isEnabled(),checkoutButton_Enabled, "Checkout button is working as expected");
		checkoutButton.click();
		
		String firstNameInputID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.FIRSTNAME_INPUT_KEY);
		String lastNameInputID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.LASTNAME_INPUT_KEY);
		String postalCodeInputID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.POSTALCODE_INPUT_KEY);

		WebElement firstNameInput = driver.findElement(By.id(firstNameInputID));
		WebElement lastNameInput = driver.findElement(By.id(lastNameInputID));
		WebElement postalCodeInput = driver.findElement(By.id(postalCodeInputID));
		
		Reporter.log(InfoMessages.ENTER_TEXT_MESSAGE);
		firstNameInput.sendKeys(Constants.FIRSTNAME);
		lastNameInput.sendKeys(Constants.LASTNAME);
		postalCodeInput.sendKeys(Constants.POSTALCODE);

	}

	public void clickContinueButton(WebDriver driver) {

		String continueButtonID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.CONTINUE_BUTTON_KEY);
		WebElement continueButton = driver.findElement(By.id(continueButtonID));
		continueButton.click();

	}

	public void clickFinishButton(WebDriver driver) {

		String finishButtonID = propertyParser_CheckOutPage.getPropertyValue(CheckOutPageKeys.FINISH_BUTTON_KEY);
		WebElement finishButton = driver.findElement(By.id(finishButtonID));
		boolean finishButton_Enabled = finishButton.isDisplayed();
		Verify.verifyBoolean(finishButton.isDisplayed(),finishButton_Enabled,"Finish button is working as expected");
		finishButton.click();
		Reporter.log("Finish button is working as expected");

		String confirmationMessageID = propertyParser_CheckOutPage
				.getPropertyValue(CheckOutPageKeys.CONFIRMATION_MESSAGE_KEY);
		WebElement confirmationMessage = driver.findElement(By.xpath(confirmationMessageID));
		boolean confirmationMessageButton_Enabled=confirmationMessage.isDisplayed();
		Verify.verifyBoolean(confirmationMessage.isDisplayed(),confirmationMessageButton_Enabled, "Confirmation message button is working properly");

	}

}
