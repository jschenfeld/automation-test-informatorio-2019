package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class GuruTestHomePage extends AbstractPage {

	@FindBy(xpath = "//div[contains(@class,'top-banner')]/iframe")
	private WebElement topBannerIframe;
	
	@FindBy(xpath = "(//ul[not(@class)]/li/a)[1]")
	private WebElement firstLink;
	
	public GuruTestHomePage(WebDriver driver) {
		super(driver);
	}
	
	public GuruResultPage clickFirstCourse() {
		driver.switchTo().frame(topBannerIframe);
		firstLink.click();
		SeleniumUtils.switchToLastWindows(driver);
		return new GuruResultPage(driver);
	}
	
	public String getTextFirstCourse() {
		driver.switchTo().frame(topBannerIframe);
		String title = firstLink.getText();
		driver.switchTo().defaultContent();
		return title;
	}
	
	

}
