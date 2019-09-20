package com.rodrigo.integrador.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;


public class HomePage {
	@FindBy(xpath = "//div[@class='header_user_info']/a[@class='login']")
	private WebElement btnLoginLink;
	
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void clickLoginLink() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, btnLoginLink);
		btnLoginLink.click();
	}

}
