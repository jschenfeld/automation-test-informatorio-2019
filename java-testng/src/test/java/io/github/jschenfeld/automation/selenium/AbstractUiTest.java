package io.github.jschenfeld.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractUiTest {

	private WebDriver driver;

	@BeforeMethod
	public void inicializarBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		driver.get(getBaseUrl());
	}
	
	@AfterMethod(alwaysRun = true)
	public void cerrarBrowser() {
		if (null != driver) {
			driver.quit();
		}
	}
	
	protected abstract String getBaseUrl();
	
	protected WebDriver getDriver() {
		return driver;
	}
}