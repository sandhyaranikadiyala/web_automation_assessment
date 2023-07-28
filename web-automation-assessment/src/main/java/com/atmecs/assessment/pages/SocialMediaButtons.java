package com.atmecs.assessment.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.atmecs.assessment.constants.Constants;
import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.page.keys.ProductHomePageKeys;
import com.atmecs.assessment.utils.PropertyParser;
import com.atmecs.assessment.verification.Verify;

public class SocialMediaButtons {
	PropertyParser propertyParser;
	private static final Logger logger = LogManager.getLogger(SocialMediaButtons.class);

	public SocialMediaButtons() {
		propertyParser = new PropertyParser(FilePathConstants.PRODUCT_HOMEPAGE_LOCATOR_FILE_PATH);
	}

	public void socialMediaButtons(WebDriver driver) {

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String twitterButtonClassName = propertyParser.getPropertyValue(ProductHomePageKeys.TWITTER_BUTTON_KEY);
		WebElement twitterButton = driver.findElement(By.className(twitterButtonClassName));

		String twitterButtonurlXpath = propertyParser.getPropertyValue(ProductHomePageKeys.TWITTERBUTTONURL_KEY);
		WebElement twitterButtonurl = driver.findElement(By.xpath(twitterButtonurlXpath));
		String twitterUrlText = twitterButtonurl.getAttribute("href");
		System.out.println("Twitter Url : " + twitterUrlText);
		boolean twitterButton_Enabled=twitterButton.isDisplayed();
		Verify.verifyBoolean(twitterButton.isDisplayed(), twitterButton_Enabled,"Twitter button is working properly");
		Reporter.log("Twitter button is working properly");

		twitterButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String facebookButtonClassName = propertyParser.getPropertyValue(ProductHomePageKeys.FACEBOOK_BUTTON_KEY);
		WebElement facebookButton = driver.findElement(By.className(facebookButtonClassName));
		boolean facebookButton_Enabled=facebookButton.isDisplayed();
		Verify.verifyBoolean(facebookButton.isDisplayed(), facebookButton_Enabled,"Facebook button is working properly");
		facebookButton.click();
		Reporter.log("Facebook button is working properly");
		driver.navigate().to(Constants.PREVIOUSWINDOW);

		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String linkedInButtonClassName = propertyParser.getPropertyValue(ProductHomePageKeys.LINKEDIN_BUTTON_KEY);
		WebElement linkedInButton = driver.findElement(By.className(linkedInButtonClassName));
		boolean linkedInButton_Enabled=linkedInButton.isDisplayed();
		Verify.verifyBoolean(linkedInButton.isDisplayed(),linkedInButton_Enabled, "LinkedIn button is working properly");

		linkedInButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("LinkedIn button is working properly");
		driver.navigate().to(Constants.PREVIOUSWINDOW);
	

	}

}
