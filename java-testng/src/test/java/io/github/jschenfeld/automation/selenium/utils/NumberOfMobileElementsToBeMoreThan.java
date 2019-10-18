package io.github.jschenfeld.automation.selenium.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NumberOfMobileElementsToBeMoreThan implements ExpectedCondition<Boolean> {

	By locator;
	int number;

	/**
	 * An expectation for checking number of AndroidElements with given locator
	 * 
	 * @param locator
	 *            used to find the element
	 * @param number
	 *            user to define maximum number of elements
	 */
	public NumberOfMobileElementsToBeMoreThan(By locator, int number) {
		this.locator = locator;
		this.number = number;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		@SuppressWarnings("unchecked")
		List<AndroidElement> elements = ((AndroidDriver<AndroidElement>) driver).findElements(locator);
		return (elements.size() > 0) ? true : false;
	}
}