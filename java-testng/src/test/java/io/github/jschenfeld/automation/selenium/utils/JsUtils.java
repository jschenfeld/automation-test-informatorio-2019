package io.github.jschenfeld.automation.selenium.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtils {
	
	public static void click(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver)
		.executeScript("arguments[0].click();", element);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver)
		.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollBy(WebDriver driver, int x, int y, WebElement element) {
		((JavascriptExecutor) driver)
		.executeScript(String.format("scrollBy(%d,%d);", x,y), element);
	}

}
