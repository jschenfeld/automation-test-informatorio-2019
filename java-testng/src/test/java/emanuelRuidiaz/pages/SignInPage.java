package emanuelRuidiaz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import emanuelRuidiaz.persona.Persona;
import emanuelRuidiaz.seleniumUtils.SeleniumUtils;

public class SignInPage extends AbstractPage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a[class = 'login']")
	private WebElement signInButton;
	
	@FindBy(id = "email")
	private WebElement inputEmail;
	
	@FindBy(id = "passwd")
	private WebElement inputPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement buttonSignIn;
	
	@FindBy(css = "a[title = 'View my customer account'] span")
	private WebElement sessionUser;
	
	public WebElement getSessionUser() {
		return sessionUser;
	}

	public void signIn(Persona persona) {
		signInButton.click();
		SeleniumUtils.waitDinamico(driver, inputEmail);
		inputEmail.sendKeys(persona.getEmail());
		inputPassword.sendKeys(persona.getPassword());
		buttonSignIn.click();
	}
	
	@FindBy(css = "div[class = 'alert alert-danger'] p")
	private WebElement error_message;

	public WebElement getError_message() {
		return error_message;
	}
	

}
