package io.github.jschenfeld.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.jschenfeld.automation.selenium.utils.WebDriverUtils.Driver;

public abstract class AbstractUiTest {

	private WebDriver driver;

	@BeforeMethod
	@Parameters(value = "browser")
	public void inicializarBrowser(@Optional(value = "REMOTE_FIREFOX_LINUX") String browser) {
		System.out.println("browser " + browser);
		driver = Driver.valueOf(browser).build();
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