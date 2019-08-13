package io.github.jschenfeld.automation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckDuckGoResultadosPage {
	
	@FindBy(xpath = "(//div[@id='links']/div)[1]/descendant::a[@class='result__a']")
	private WebElement linkPrimerResultado;

	public DuckDuckGoResultadosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void abrirPrimerResultado() {
		linkPrimerResultado.click();
	}
}