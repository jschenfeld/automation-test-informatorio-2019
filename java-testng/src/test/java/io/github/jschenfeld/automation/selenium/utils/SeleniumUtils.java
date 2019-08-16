package io.github.jschenfeld.automation.selenium.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	
	public static WebElement esperarVisibilidadDelElemento(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elementoEncontrado = wait
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element));
		return  elementoEncontrado;
	}
}