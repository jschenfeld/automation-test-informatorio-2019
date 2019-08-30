package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuruResultPage extends AbstractPage {

	@FindBy(css = ".SearchKeyword")
	private WebElement courseTitle;
	
	public GuruResultPage(WebDriver driver) {
		super(driver);
	}

	public String getCourseTitle() {
		return courseTitle.getText();
	}
}