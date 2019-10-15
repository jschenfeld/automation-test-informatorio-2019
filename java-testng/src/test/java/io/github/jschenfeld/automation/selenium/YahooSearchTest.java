package io.github.jschenfeld.automation.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.WikipediaArticuloPage;
import io.github.jschenfeld.automation.selenium.pages.YahooHomePage;
import io.github.jschenfeld.automation.selenium.pages.YahooResultPage;

public class YahooSearchTest extends AbstractUiTest {
	
	
	@Override
	protected String getBaseUrl() {
		return "https://ar.search.yahoo.com/";
	}
	
	
	
	@Test
	public void searchResistencia() {
		YahooHomePage homePage = new YahooHomePage(getDriver());
		homePage.typeQuery("Resistencia ciudad Wikipedia");
		YahooResultPage resultPage = homePage.clickSearch();
		WikipediaArticuloPage articuloPage = resultPage.clickFirstResult();
		Assert.assertEquals(articuloPage.obtenerTituloTexto(), "Resistencia (ciudad)");
	}
	
	@Test
	public void searchResistenciaFluent() {
		String title = YahooHomePage.using(getDriver())
		.typeQuery("Resistencia Ciudad Wikipedia")
		.clickSearch().clickFirstResult().obtenerTituloTexto();
		
		Assert.assertEquals(title, "Resistencia (ciudad)");
	}
}