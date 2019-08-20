package io.github.jschenfeld.automation.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.jschenfeld.automation.selenium.pages.automationpractice.ApHomePage;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiDynamicPage;
import io.github.jschenfeld.automation.selenium.pages.automationpractice.ApAuthentication;

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
		
		TiDynamicPage theInternetDynamicPage = new TiDynamicPage(driver);
		theInternetDynamicPage.clickStartButton();
		//Espera explicita fija
		Thread.sleep(15000);
		assertEquals(theInternetDynamicPage.getMessage(), "Hello World!");
	}
	
	@Test
	public void loginFluent() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		String nombre = ApAuthentication.using(driver)
		.email("info@matorio.com")
		.password("12345")
		.clickLogin().getLoggerUser();
		
		Assert.assertEquals(nombre, "a b");
	}
	
	@Test 
	public void login() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		ApAuthentication loginPage = new ApAuthentication(driver);
		ApHomePage homePage = loginPage.login("info@matorio.com", "12345");
		Assert.assertEquals(homePage.getLoggerUser(), "a b");
	}
}