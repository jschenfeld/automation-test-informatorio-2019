package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.github.jschenfeld.automation.appium.pages.BaseScreen;

public class AgendaPage extends BaseScreen {
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[1])[1]")
	private MobileElement title;

	private MenuWidget menu;
	
	public AgendaPage(WebDriver driver) {
		super(driver);
		switchToNativeView();
	}
	
	public String getTitleText() {
		return title.getText();
	}

	public MenuWidget getMenu() {
		return menu;
	}
}
