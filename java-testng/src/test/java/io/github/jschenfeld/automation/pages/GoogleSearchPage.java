package io.github.jschenfeld.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends Page {

	@FindBy(name = "q")
	private WebElement campoConsulta;

	@FindBy(xpath = "(//input[@name='btnK'])[last()]")
	private WebElement botonBuscar;

	public GoogleSearchPage() {
		super();
		driver.get("https://google.com.ar");
	}

	public GoogleResultPage buscar(String consulta) {
		campoConsulta.sendKeys(consulta, Keys.TAB);
		botonBuscar.click();
		return new GoogleResultPage();
	}
}