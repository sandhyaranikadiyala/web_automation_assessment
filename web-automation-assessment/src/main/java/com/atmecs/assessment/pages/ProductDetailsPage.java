package com.atmecs.assessment.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.page.keys.YourCartPageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class ProductDetailsPage {
	PropertyParser propertyParser_HomePage, propertyParser_CartPage;
	private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class);

	public ProductDetailsPage() {
		propertyParser_HomePage = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);
		propertyParser_CartPage = new PropertyParser(FilePathConstants.YOUR_CART_PAGE_LOCATOR_FILE_PATH);

	}

	private String initialProductName;
	private String initialProductPrice;
	private String initialProductImage;

	public void ProductDetails(WebDriver driver) {

		String productElementClassName = propertyParser_HomePage
				.getPropertyValue(ProductHomePageKeys.PRODUCT_ELEMENT_KEY);
		String productNameClassName = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.PRODUCT_NAME_KEY);
		String productPriceClassName = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.PRODUCT_PRICE_KEY);
		String productImageXpath = propertyParser_HomePage.getPropertyValue(ProductHomePageKeys.PRODUCT_IMGE_KEY);

		WebElement productElement = driver.findElement(By.className(productElementClassName));
		WebElement productName = productElement.findElement(By.className(productNameClassName));
		WebElement productPrice = productElement.findElement(By.className(productPriceClassName));
		WebElement productImage = productElement.findElement(By.xpath(productImageXpath));

		initialProductName = productName.getText();
		initialProductPrice = productPrice.getText();
		initialProductImage = productImage.getAttribute("src");

		String productAddToCartButtonID = propertyParser_HomePage
				.getPropertyValue(ProductHomePageKeys.PRODUCT_ADDTOCART_BUTTON_KEY);
		WebElement productAddToCartButton = productElement.findElement(By.id(productAddToCartButtonID));
		productAddToCartButton.click();

		String cartIconButtonID = propertyParser_CartPage.getPropertyValue(YourCartPageKeys.CART_ICON_BUTTON_KEY);
		WebElement cartIconButton = driver.findElement(By.id(cartIconButtonID));
		cartIconButton.click();

		String cartProductElementClassName = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CART_PRODUCT_ELEMENT_KEY);
		String cartProductNameClassName = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CART_PRODUCT_NAME_KEY);
		String cartProductPriceClassName = propertyParser_CartPage
				.getPropertyValue(YourCartPageKeys.CART_PRODUCT_PRICE_KEY);

		WebElement cartProductElement = driver.findElement(By.className(cartProductElementClassName));
		WebElement cartProductName = cartProductElement.findElement(By.className(cartProductNameClassName));
		WebElement cartProductPrice = cartProductElement.findElement(By.className(cartProductPriceClassName));

		String updatedProductName = cartProductName.getText();
		String updatedProductPrice = cartProductPrice.getText();
		String updatedProductImage = null;

		Verify.verifyString(initialProductName, updatedProductName, "Product name same as expected");
		Verify.verifyString(initialProductPrice, updatedProductPrice, "Product price same as expected");
		Verify.verifyString(initialProductImage, updatedProductImage,
				"Product image is not visible after product adding to the cart");

		WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));

		boolean removeButton_Enabled = removeButton.isEnabled();
		Verify.verifyBoolean(removeButton.isEnabled(), removeButton_Enabled, "Remove button is enabled");

	}

}
