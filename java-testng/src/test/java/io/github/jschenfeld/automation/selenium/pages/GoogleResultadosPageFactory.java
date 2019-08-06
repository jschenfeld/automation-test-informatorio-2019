package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultadosPageFactory {

	@FindBy(xpath = "//a/h3[text()='Informatorio - Polo IT Chaco']")
	private WebElement poloItlink;
	
	public GoogleResultadosPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void abrirLaPaginaDelPoloIt() {
		poloItlink.click();
	}
}
