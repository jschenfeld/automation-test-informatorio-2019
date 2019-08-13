package io.github.jschenfeld.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.jschenfeld.automation.selenium.pages.GoogleBusquedaPageFactory;
import io.github.jschenfeld.automation.selenium.pages.GoogleBusquedaPageObject;
import io.github.jschenfeld.automation.selenium.pages.GoogleResultadosPageFactory;

public class MiPrimerTestDeUi {
	
	private WebDriver driver;

	@BeforeMethod
	public void inicializarBrowser() {
//		System.setProperty("webdriver.chrome.driver", 
//				"/home/jonatan.schenfeld/.m2/repository/webdriver/chromedriver/linux64/76.0.3809.68/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
	}

	@Test(enabled = false)
	public void busquedaEnGoogle() {
		driver.get("https://www.google.com.ar");

		GoogleBusquedaPageObject googleBusquedaPage = new GoogleBusquedaPageObject(driver);
		googleBusquedaPage.ingresarBusqueda("Informatorio Chaco");
		googleBusquedaPage.clickBotonBuscar();
		
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void busquedaEnGoogleUsandoPageFactory() {
		driver.get("https://www.google.com.ar");

		GoogleBusquedaPageFactory googleBusquedaPage = new GoogleBusquedaPageFactory(driver);
		googleBusquedaPage.buscar("Informatorio Chaco");
		GoogleResultadosPageFactory googleResultadosPageFactory = new GoogleResultadosPageFactory(driver);
		googleResultadosPageFactory.abrirLaPaginaDelPoloIt();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("https://poloitchaco.org.ar/informatorio/", driver.getCurrentUrl());
	}

	@AfterMethod(alwaysRun = true)
	public void cerrarBrowser() {
		if (null != driver) {
			driver.quit();
		}
	}
}