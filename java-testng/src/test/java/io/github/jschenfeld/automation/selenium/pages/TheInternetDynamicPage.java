package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class TheInternetDynamicPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='start']/button")
	private WebElement start;
	
	@FindBy(id = "loading")
	private WebElement finish;
	
	@FindBy(xpath = "//*[@id='finish']/h4")
	private WebElement message;
	
	public TheInternetDynamicPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickStartButton(){
		start.click();
		//espera explicita dinamica
		SeleniumUtils.esperarVisibilidadDelElemento(driver, finish);
	}
	
	public String getMessage(){
		return message.getText();
	}
}