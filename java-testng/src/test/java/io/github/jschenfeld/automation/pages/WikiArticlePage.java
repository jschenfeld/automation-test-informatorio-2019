package io.github.jschenfeld.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiArticlePage extends Page {

	@FindBy(id = "firstHeading")
	private WebElement firstHeading;

	public WikiArticlePage() {
		super();
		isElementPresent(15, firstHeading);
	}

	public String getFirstHeadingText() {
		return firstHeading.getText();
	}

}
