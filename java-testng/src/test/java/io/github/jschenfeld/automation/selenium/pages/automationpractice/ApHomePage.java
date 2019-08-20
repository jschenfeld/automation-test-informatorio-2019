package io.github.jschenfeld.automation.selenium.pages.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class ApHomePage {

	private WebDriver driver;
	
	@FindBy(css = ".logout")
	private WebElement logout;
	
	@FindBy(css = ".header_user_info a span")
	private WebElement logedUserText;
	
	public ApHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, logout);
	}

	public String getLoggerUser() {
		return logedUserText.getText();
	}	
}