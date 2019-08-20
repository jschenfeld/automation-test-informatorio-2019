package io.github.jschenfeld.automation.selenium.pages.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.github.jschenfeld.automation.selenium.pages.AbstractPage;

public class TiDropDownPage extends AbstractPage {

	@FindBy(id = "dropdown")
	private WebElement dropdown;

	public TiDropDownPage(WebDriver driver) {
		super(driver);
	}

	public void selectByText(String text) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	

	public String getSelectedOption() {
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}

	public void selectByIndex(int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public void selectByValue(String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

}
