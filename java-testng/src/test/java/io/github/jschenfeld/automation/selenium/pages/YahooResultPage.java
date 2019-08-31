package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class YahooResultPage extends AbstractPage {
	
	@FindBy(xpath = "(//div[@id=\"web\"]//li/div//h3/a)[1]")
	private WebElement firstResult;

	public YahooResultPage(WebDriver driver) {
		super(driver);
	}
	
	public WikipediaArticuloPage clickFirstResult() {
		firstResult.click();
		SeleniumUtils.switchToWindow(driver);
		return new WikipediaArticuloPage(driver);
	}
}