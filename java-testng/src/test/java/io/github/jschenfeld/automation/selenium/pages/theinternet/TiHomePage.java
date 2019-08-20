package io.github.jschenfeld.automation.selenium.pages.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.pages.AbstractPage;

public class TiHomePage extends AbstractPage {
	
	@FindBy(linkText = "Dropdown")
	private WebElement dropdown;

	public TiHomePage(WebDriver driver) {
		super(driver);
	}
	
	public TiDropDownPage clickDropDownLink() {
		dropdown.click();
		return new TiDropDownPage(driver);
	}
}