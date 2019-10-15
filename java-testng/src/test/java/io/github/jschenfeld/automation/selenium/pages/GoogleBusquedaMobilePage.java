package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleBusquedaMobilePage {
	
	private WebDriver driver;
	
	@FindBy(name = "q")
	private WebElement campoDeBusqueda;
	
	@FindBy(xpath = "(//button)[last()] | (//input[@name='btnK'])[last()]")
	private WebElement botonBuscar;
	
	public GoogleBusquedaMobilePage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	public void ingresarBusqueda(String consulta) {
		campoDeBusqueda.sendKeys(consulta);
	}
	
	public void clickBotonBuscar() {
		botonBuscar.submit();
	}
	
	private void initElements() {
		PageFactory.initElements(driver, this);
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
