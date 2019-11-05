package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.github.jschenfeld.automation.appium.pages.BaseScreen;

public class FavoritePage extends BaseScreen {
	
	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
	private AndroidElement title;

	private MenuWidget menu;
	
	public FavoritePage(WebDriver driver) {
		super(driver);
		switchToNativeView();
	}

	public MenuWidget getMenu() {
		return menu;
	}

	public String getTitleText() {
		return title.getText();
	}
}
