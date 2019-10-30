package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.WebDriver;

import io.github.jschenfeld.automation.appium.pages.BaseScreen;

public class HomePage extends BaseScreen {
	
	private MenuWidget menu;

	public HomePage(WebDriver driver) {
		super(driver);
		switchToNativeView();
	}
	
	public MenuWidget getMenu() {
		return menu;
	}
}