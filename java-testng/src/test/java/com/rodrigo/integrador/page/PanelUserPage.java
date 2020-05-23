package com.rodrigo.integrador.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;


public class PanelUserPage {
	@FindBy(xpath = "//p[@class='info-account']//ancestor::div[@id='center_column']//h1")
	private WebElement labelTitulo;
	
	
	@FindBy(xpath = "//div[@class='header_user_info']//span")
	private WebElement spanUser;
	
	private WebDriver driver;
	
	public PanelUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public String tituloPagina() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, labelTitulo);
		return labelTitulo.getText();
	}
	
	public String nombreUsuario() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, spanUser);
		return spanUser.getText();
	}
	
}
