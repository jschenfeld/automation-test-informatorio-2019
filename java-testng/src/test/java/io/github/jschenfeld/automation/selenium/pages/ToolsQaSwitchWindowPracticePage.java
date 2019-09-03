package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.utils.JsUtils;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class ToolsQaSwitchWindowPracticePage extends AbstractPage {
	
	@FindBy(xpath = "//button[text()='New Browser Tab']")
	private WebElement newBrowserTabButton;
	
	@FindBy(xpath = "//h1[normalize-space()='Automation Practice Switch Windows']")
	private WebElement headerSwitchWindowsPractice;
	
	public ToolsQaSwitchWindowPracticePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewBrowserTabButton() throws InterruptedException {
		SeleniumUtils.esperarVisibilidadDelElemento(driver, headerSwitchWindowsPractice);
		JsUtils.scrollIntoView(driver, headerSwitchWindowsPractice);
		SeleniumUtils.esperarVisibilidadDelElemento(driver, newBrowserTabButton);
		Thread.sleep(10000);
		newBrowserTabButton.click();
		SeleniumUtils.esperarNuevaVentana(driver);
		SeleniumUtils.switchToLastWindows(driver);
	}

}
