package io.github.jschenfeld.automation.selenium.pages.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.pages.AbstractPage;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class TiMultipleWindows extends AbstractPage {
	
	@FindBy(linkText = "Click Here")
	private WebElement clickHere;

	public TiMultipleWindows(WebDriver driver) {
		super(driver);
	}

	public TiNewWindowPage clickLink() {
		clickHere.click();
		SeleniumUtils.switchToWindow(driver, 1);
		return new TiNewWindowPage(driver);
	}
}