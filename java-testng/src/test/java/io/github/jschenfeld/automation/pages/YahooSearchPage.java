package io.github.jschenfeld.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.github.jschenfeld.automation.tests.Base;

public class YahooSearchPage extends Page {

	@FindBy(name = "p")
	private WebElement campoTextoBusqueda;

	@FindBy(xpath = "//div[@title='Search']")
	private WebElement botonBuscar;

	public YahooSearchPage() {
		super();
		driver.get("https://ar.search.yahoo.com/");
		isElementPresent(15, botonBuscar);
	}

	public void completarCampoDeBusqueda(String keyword) {
		System.out.println("Filling search text box with: " + keyword);
		campoTextoBusqueda.sendKeys(keyword);
	}

	public YahooResultPage clickBotonBuscar() {
		System.out.println("Clicking search button.");
		botonBuscar.click();
		return new YahooResultPage();
	}

}