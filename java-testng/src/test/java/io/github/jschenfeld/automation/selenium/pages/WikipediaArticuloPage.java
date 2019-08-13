package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaArticuloPage {

	@FindBy(id = "firstHeading")
	private WebElement primerTitulo;
	
	public WikipediaArticuloPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String obtenerTituloTexto() {
		return primerTitulo.getText();
	}
}