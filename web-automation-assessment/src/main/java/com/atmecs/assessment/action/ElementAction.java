package com.atmecs.assessment.action;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import com.atmecs.assessment.base.TestBase;

public class ElementAction extends TestBase {
	public static boolean isElementPresent(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Web element is not present");
		} catch (NullPointerException exception) {
			System.out.println("Web element is null");
		}
		return false;
	}

}
