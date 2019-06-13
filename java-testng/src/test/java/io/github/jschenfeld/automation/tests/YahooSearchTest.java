package io.github.jschenfeld.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.pages.WikiArticlePage;
import io.github.jschenfeld.automation.pages.YahooResultPage;
import io.github.jschenfeld.automation.pages.YahooSearchPage;

public class YahooSearchTest extends Base {

	@Test
	public void buscarResistenciaConYahoo() {

		YahooSearchPage searchPage = new YahooSearchPage();
		searchPage.completarCampoDeBusqueda("Resistencia ciudad wiki");
		YahooResultPage resultPage = searchPage.clickBotonBuscar();
		WikiArticlePage wikiPage = resultPage.clickFirstResultLink();
		assertEquals(wikiPage.getFirstHeadingText(), "Resistencia (ciudad)");
	}
}