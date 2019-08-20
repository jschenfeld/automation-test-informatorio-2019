package io.github.jschenfeld.automation.selenium.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	
	public static boolean esperarVisibilidadDelElemento(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofMillis(200L))
				.until(ExpectedConditions.visibilityOf(element)) != null;
	}
	
	public static WebElement esperarVisibilidadDelElemento(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofMillis(200L))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
}