package io.github.jschenfeld.automation.selenium.pages.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.jschenfeld.automation.selenium.utils.SeleniumUtils;

public class ApAuthentication {
	
	private WebDriver driver;
	
	//login locators
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement buttonLogin;
	
	@FindBy(id = "create_account_error")
	private WebElement createAccountError;
	
	
	//registration locators
	@FindBy(id = "email_create")
	private WebElement emailCreate;
	
	@FindBy(id = "SubmitCreate")
	private WebElement buttonCreate;
	
	public ApAuthentication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static ApAuthentication using(WebDriver driver) {
		return new ApAuthentication(driver);
	}
	
	
	public ApAuthentication email(String email) {
		this.email.sendKeys(email);
		return this;
	}
	
	public ApAuthentication password(String password) {
		this.password.sendKeys(password);
		return this;
	}
	
	public ApHomePage clickLogin() {
		this.buttonLogin.click();
		return new ApHomePage(driver);
	}
	
	
	public ApHomePage login(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.buttonLogin.click();
		return new ApHomePage(driver);
	}
	
	public ApAuthentication emailAddressCreate(String email) {
		emailCreate.sendKeys(email);
		emailCreate.sendKeys(Keys.TAB);
		return this;
	}
	
	public ApAuthentication clickCreate() {
		buttonCreate.submit();
		return this;
	}
	
	public String getEmailCreateColor() {
		return emailCreate.getCssValue("color");
	}

	public String getCreateAccountError() {
		SeleniumUtils.esperarVisibilidadDelElemento(driver, createAccountError);
		return createAccountError.getText();
	}
	
	public String getCreateAccountErrorWithoutPageFactory() {
		final By locator = By.id("create_account_error");
		WebElement element = SeleniumUtils.esperarVisibilidadDelElemento(driver, locator);
		return element.getText();
	}
}