package io.github.jschenfeld.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooResultPage extends Page {

	@FindBy(xpath = "(//div[@id='web']/descendant::h3[@class='title']/a)[1]")
	private WebElement firstResultLink;
	
	public YahooResultPage() {
		super();
		isElementPresent(15, firstResultLink);
	}

	public WikiArticlePage clickFirstResultLink(){
		firstResultLink.click();
		switchToLastWindows();
		return new WikiArticlePage();
	}
}
