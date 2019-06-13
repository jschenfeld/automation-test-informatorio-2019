package io.github.jschenfeld.automation.tests;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.pages.GoogleSearchPage;

public class FirstTest extends Base {

	@Test
	public void first(){
		GoogleSearchPage googleSearchPage = new GoogleSearchPage();
		googleSearchPage.buscar("Jonatan Schenfeld");
	}
}