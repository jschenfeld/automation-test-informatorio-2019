package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends AbstractPage {

	@FindBy(name = "p")
	private WebElement inputText;
	
	@FindBy(xpath = "//button[@tabindex='2']")
	private WebElement buttonSearch;
	
	public YahooHomePage(WebDriver driver) {
		super(driver);
	}
	
	public static YahooHomePage using(WebDriver driver) {
		return new YahooHomePage(driver);
	}

	public YahooHomePage typeQuery(String query) {
		inputText.sendKeys(query);
		return this;
	}
	
	public YahooResultPage clickSearch() {
		inputText.submit();
		return new YahooResultPage(driver);
	} 
}
