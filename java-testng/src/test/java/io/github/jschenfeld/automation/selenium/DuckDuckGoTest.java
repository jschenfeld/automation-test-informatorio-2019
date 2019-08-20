package io.github.jschenfeld.automation.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.jschenfeld.automation.selenium.pages.DuckDuckGoBusquedaPage;
import io.github.jschenfeld.automation.selenium.pages.DuckDuckGoResultadosPage;
import io.github.jschenfeld.automation.selenium.pages.WikipediaArticuloPage;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class DuckDuckGoTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void iniciarNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void buscarPoloIt() {
		driver.get("https://duckduckgo.com/");
		
		DuckDuckGoBusquedaPage busquedaPage = 
				new DuckDuckGoBusquedaPage(driver);
		busquedaPage.ingresarBusqueda("Resistencia Chaco wiki");
		busquedaPage.clickBuscar();
		DuckDuckGoResultadosPage resultadosPage = 
				new DuckDuckGoResultadosPage(driver);
		resultadosPage.abrirPrimerResultado();
		WikipediaArticuloPage articuloPage = 
				new WikipediaArticuloPage(driver);
		Assert.assertEquals(articuloPage.obtenerTituloTexto(),
				"Resistencia, Chaco");	
	}

	@AfterMethod
	public void cerrarNavegador() {
		if(null != driver) {
			driver.quit();
		}
	}
	
}
