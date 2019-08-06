package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleBusquedaPageFactory {

	@FindBy(name = "q")
	private WebElement campoDeBusqueda;

	@FindBy(name = "btnK")
	private WebElement botonBuscar;

	public GoogleBusquedaPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ingresarBusqueda(String consulta) {
		campoDeBusqueda.sendKeys(consulta);
		campoDeBusqueda.sendKeys(Keys.TAB);
	}

	public void clickBotonBuscar() {
		botonBuscar.submit();
	}

	public void buscar(String consulta) {
		ingresarBusqueda(consulta);
		clickBotonBuscar();
	}
}