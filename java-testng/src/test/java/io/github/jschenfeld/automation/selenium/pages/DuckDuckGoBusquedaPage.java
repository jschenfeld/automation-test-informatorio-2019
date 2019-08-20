package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class DuckDuckGoBusquedaPage {
	
	@FindBy(id = "search_form_input_homepage")
	private WebElement campoDeBusqueda;
	
	@FindBy(id = "search_button_homepage")
	private WebElement botonBuscar;
	
	public DuckDuckGoBusquedaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		SeleniumUtils.esperarVisibilidadDelElemento(driver, campoDeBusqueda);
	}

	public void ingresarBusqueda(String consulta) {
		campoDeBusqueda.sendKeys(consulta);
	}
	
	public void clickBuscar() {
		botonBuscar.click();
	}
}