package io.github.jschenfeld.automation.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.jschenfeld.automation.selenium.pages.TheInternetDynamicPage;

public class WaitExampleTest {

	private WebDriver driver;
	
	@BeforeMethod
	public void iniciarNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void cerrarNavegador() {
		if(null != driver) {
			driver.quit();
		}
	}
	
	@Test
	public void waitTest() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		TheInternetDynamicPage theInternetDynamicPage = new TheInternetDynamicPage(driver);
		theInternetDynamicPage.clickStartButton();
		//Espera explicita fija
		Thread.sleep(15000);
		assertEquals(theInternetDynamicPage.getMessage(), "Hello World!");
	}

}
