package io.github.jschenfeld.automation.selenium;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.GoogleBusquedaPageObject;

public class GoogleSearch extends AbstractUiTest {
	
	
	@Override
	protected String getBaseUrl() {
		return "https://www.google.com.ar";
	}
	
	
	@Test
	public void busquedaEnGoogle() {

		GoogleBusquedaPageObject googleBusquedaPage = new GoogleBusquedaPageObject(getDriver());
		googleBusquedaPage.ingresarBusqueda("Informatorio Chaco");
		googleBusquedaPage.clickBotonBuscar();
		
		System.out.println(getDriver().getCurrentUrl());
	}

}