package io.github.jschenfeld.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

	protected static WebDriver driver;

	public Page() {
		PageFactory.initElements(driver, this);
	}

	public static void setDriver(WebDriver driver) {
		Page.driver = driver;
	}

	public static void closeBrowser() {
		if (null != Page.driver) {
			Page.driver.close();
		}
	}
}