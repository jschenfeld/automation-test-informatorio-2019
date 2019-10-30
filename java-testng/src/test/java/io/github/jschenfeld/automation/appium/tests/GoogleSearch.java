package io.github.jschenfeld.automation.appium.tests;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.AbstractUiTest;
import io.github.jschenfeld.automation.selenium.pages.GoogleBusquedaMobilePage;

public class GoogleSearch extends AbstractUiTest {
	
	
	@Override
	protected String getBaseUrl() {
		return "https://www.google.com.ar";
	}
	
	
	@Test
	public void busquedaEnGoogle() {

		GoogleBusquedaMobilePage googleBusquedaPage = new GoogleBusquedaMobilePage(getDriver());
		googleBusquedaPage.ingresarBusqueda("Informatorio Chaco");
		googleBusquedaPage.clickBotonBuscar();
		
		System.out.println(getDriver().getCurrentUrl());
	}

}