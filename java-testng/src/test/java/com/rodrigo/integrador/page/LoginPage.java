package com.rodrigo.integrador.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.JsUtils;
import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;


public class LoginPage {
	
	@FindBy(xpath = "//form[@id='create-account_form']//input[@id='email_create']")
	private WebElement inputEmailFormCreate;
	
	@FindBy(xpath = "//form[@id='login_form']//input[@id='email']")
	private WebElement inputEmailFormLogin;
	
	@FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
	private WebElement inputPasswordFormLogin;
	
	@FindBy(xpath = "//form[@id='login_form']//button[@id='SubmitLogin']")
	private WebElement buttonAceptarFormLogin;
	
	@FindBy(xpath = "//form[@id='create-account_form']//button[@type='submit']")
	private WebElement buttonCreateFormCreate;
	
	@FindBy(xpath = "//div[@id='center_column']/h1")
	private WebElement labelAuthentication;
	
	@FindBy(xpath = "//form[@id='create-account_form']//div[@id='create_account_error']//li")
	private WebElement mjeError;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']//li")
	private WebElement mjeLoginEmailError;
	
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void crearCuenta(String email) {
		inputEmailFormCreate.sendKeys(email);
		
		buttonCreateFormCreate.submit();
	}
	
	public void completarFormularioLogin(String email, String password) {

		JsUtils.scrollIntoView(this.driver, this.inputEmailFormLogin);
		this.inputEmailFormLogin.sendKeys(email);
		
		JsUtils.scrollIntoView(this.driver, this.inputPasswordFormLogin);
		this.inputPasswordFormLogin.sendKeys(password);
		
		JsUtils.scrollIntoView(this.driver, this.buttonAceptarFormLogin);
		this.buttonAceptarFormLogin.click();
	}
	
	public String tituloPagina() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, this.labelAuthentication);
		return labelAuthentication.getText();
	}
	
	public String emailError() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, this.mjeError);
		return mjeError.getText();
	}
	
	public String emailLoginError() {
		SeleniumUtils.esperarVisibilidadDelElemento(this.driver, this.mjeLoginEmailError);
		return mjeLoginEmailError.getText();
	}
}
