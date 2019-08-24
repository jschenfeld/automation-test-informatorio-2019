package io.github.jschenfeld.automation.selenium.pages.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.pages.AbstractPage;

public class TiNewWindowPage extends AbstractPage {
	
	@FindBy(tagName = "h3")
	private WebElement title;

	public TiNewWindowPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle() {
		return title.getText();
	}
}