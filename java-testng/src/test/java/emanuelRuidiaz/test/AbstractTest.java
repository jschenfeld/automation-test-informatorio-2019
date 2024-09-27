package emanuelRuidiaz.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void inicializarBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getBaseUrl());
	}
	
	@AfterMethod()
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
