package io.github.jschenfeld.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.pages.GoogleResultPage;
import io.github.jschenfeld.automation.pages.GoogleSearchPage;
import io.github.jschenfeld.automation.pages.WikiArticlePage;

public class GoogleSearchTest extends Base {

	@Test
	public void first(){
		GoogleSearchPage googleSearchPage = new GoogleSearchPage();
		GoogleResultPage googleResultPage = googleSearchPage.buscar("Resistencia ciudad wiki");
		WikiArticlePage wikiArticlePage = googleResultPage.clickFirstResult(WikiArticlePage.class);
		assertEquals(wikiArticlePage.getFirstHeadingText(), "Resistencia (ciudad)");
	}
}