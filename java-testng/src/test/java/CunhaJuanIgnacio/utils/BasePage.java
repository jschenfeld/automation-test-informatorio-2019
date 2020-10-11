package CunhaJuanIgnacio.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.jschenfeld.automation.selenium.utils.WebDriverUtils.Driver;
public abstract class BasePage {
	
	private WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void inicializarBrowser(@Optional(value = "CHROME") String browser) {
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
