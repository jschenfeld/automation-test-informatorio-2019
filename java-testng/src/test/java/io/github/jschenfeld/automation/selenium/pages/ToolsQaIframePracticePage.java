package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.selenium.utils.JsUtils;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class ToolsQaIframePracticePage extends AbstractPage {

	@FindBy(name = "iframe2")
	private WebElement iframe2;
	
	@FindBy(xpath = "//h3[text()='Widgets']/following-sibling::ul/li[3]/a")
	private WebElement switchWindownLink;
	
	@FindBy(xpath = "//h3[text()='Widgets']")
	private WebElement widgets;
	
	public ToolsQaIframePracticePage(WebDriver driver) {
		super(driver);
	}

	public ToolsQaSwitchWindowPracticePage clickSwitchWindowsLink() {
		JsUtils.scrollIntoView(driver, iframe2);
		driver.switchTo().frame(iframe2);
		SeleniumUtils.esperarVisibilidadDelElemento(driver, widgets);
		JsUtils.scrollIntoView(driver, widgets);
		SeleniumUtils.esperarVisibilidadDelElemento(driver, switchWindownLink);
		switchWindownLink.click();
		return new ToolsQaSwitchWindowPracticePage(driver);
	}
}
