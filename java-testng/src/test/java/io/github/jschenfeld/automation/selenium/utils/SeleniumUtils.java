package io.github.jschenfeld.automation.selenium.utils;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
	
	
	public static void switchToWindows(WebDriver driver) {
		String actualWindows = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		if(iterator.hasNext()) {
			String hash = iterator.next();
			if(actualWindows.equals(hash) && iterator.hasNext()) {
				hash = iterator.next();
			}
			driver.switchTo().window(hash);
		}
	}
	
	public static void switchToLastWindows(WebDriver driver) {
		String actualWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if (!string.equals(actualWindow)) {
				driver.switchTo().window(string);
			}
		}
	}
	
	public static void switchToWindow(WebDriver driver, int index) {
		Object[] allWindows = driver.getWindowHandles().toArray();
		driver.switchTo().window(allWindows[index].toString());
		
	}
	
}