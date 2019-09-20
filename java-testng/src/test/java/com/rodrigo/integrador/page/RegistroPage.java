package com.rodrigo.integrador.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rodrigo.itegrador.dto.UserDto;

import io.github.jschenfeld.automation.selenium.utils.JsUtils;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;


public class RegistroPage {
	@FindBy(xpath = "//div[@id='center_column']//h1[contains(text(),'Create')]")
	private WebElement lblAuthentication;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='customer_firstname']")
	private WebElement inputFirstName;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='customer_lastname']")
	private WebElement inputLastName;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='passwd']")
	private WebElement inputPasswd;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='firstname']")
	private WebElement inputAdressFirstName;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='lastname']")
	private WebElement inputAdressLastname;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='address1']")
	private WebElement inputAdressAddress1;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='city']")
	private WebElement inputAdressCity;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//select[@id='id_state']")
	private WebElement inputAdressState;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='postcode']")
	private WebElement inputAdressPostcode;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//select[@id='id_country']")
	private WebElement inputAdressCountry;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//textarea[@id='other']")
	private WebElement inputAdditionalInformation;

	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='phone_mobile']")
	private WebElement inputPhoneNumber;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//input[@id='alias']")
	private WebElement inputAlias;
	
	@FindBy(xpath = "//form[@id='account-creation_form']//button[@type='submit']")
	private WebElement btnAceptar;
	
	private WebDriver driver;
	
	public RegistroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void completarFormulario(UserDto entity) {
		JsUtils.scrollIntoView(this.driver, inputFirstName);
		inputFirstName.sendKeys(entity.getFirstName());
		
		JsUtils.scrollIntoView(this.driver, inputLastName);
		inputLastName.sendKeys(entity.getLastName());
		
		JsUtils.scrollIntoView(this.driver, inputPasswd);
		inputPasswd.sendKeys(entity.getPassword());
		
		JsUtils.scrollIntoView(this.driver, inputAdressAddress1);
		inputAdressAddress1.sendKeys(entity.getAdress());
		
		JsUtils.scrollIntoView(this.driver, inputAdressCity);
		inputAdressCity.sendKeys(entity.getCity());
		
		JsUtils.scrollIntoView(this.driver, inputAdressState);
		Select inputsel = new Select(inputAdressState);
		inputsel.selectByVisibleText(entity.getState());
		
		JsUtils.scrollIntoView(this.driver, inputAdressPostcode);
		inputAdressPostcode.sendKeys(entity.getCodePostal());
		
		JsUtils.scrollIntoView(this.driver, inputAdressCountry);
		inputsel = new Select(inputAdressCountry);
		inputsel.selectByVisibleText(entity.getCountry());
		
		JsUtils.scrollIntoView(this.driver, inputAdditionalInformation);
		inputAdditionalInformation.sendKeys(entity.getAditionalInformation());
		
		JsUtils.scrollIntoView(this.driver, inputPhoneNumber);
		inputPhoneNumber.sendKeys(entity.getMobilePhone());
		
		JsUtils.scrollIntoView(this.driver, inputAlias);
		inputAlias.sendKeys(entity.getAdressAlias());
		
		btnAceptar.click();
	}
	
	
	public String tituloPagina() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, lblAuthentication);
		return lblAuthentication.getText();
	}
}
