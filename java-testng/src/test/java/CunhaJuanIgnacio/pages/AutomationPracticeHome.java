package CunhaJuanIgnacio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CunhaJuanIgnacio.utils.SeleniumUtils;



public class AutomationPracticeHome {
	private WebDriver driver;
	
	@FindBy(id = "email_create")
	private WebElement inputEmail;
	
	@FindBy(id = "email")
	private WebElement emailLogIn;
	
	@FindBy(id = "passwd")
	private WebElement passwordLogIn;
	
	@FindBy(id = "SubmitCreate")
	private WebElement createAccount;
	
	@FindBy(id = "SubmitLogin")
	private WebElement logInButton;
	
	
	//Next Page Web Element for wait
	@FindBy(id = "id_gender1")
	private WebElement radioBotton;
	
	@FindBy(xpath = "//h1")
	private WebElement createAccountText;
	
	
	@FindBy(id = "create_account_error")
	private WebElement wrongFormat;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]/ol/li")
	private WebElement logInFail;
	
	@FindBy(xpath = "//a[@class='account']/span")
	private WebElement logInConfirm;
	
	public AutomationPracticeHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public AutomationPracticeHome enterMail(String mail) {
		inputEmail.sendKeys(mail);
		return this;
	}
	
	public AutomationPracticeSingUp clickCreateAccount() {
		createAccount.click();		
		SeleniumUtils.waitElementVisibility(driver, radioBotton); 
		return new AutomationPracticeSingUp(driver);
	}
	
	public String assertCreateAccount() {
		SeleniumUtils.waitElementVisibility(driver, radioBotton);
		return createAccountText.getText();
	}
	
	public AutomationPracticeHome checkMailFormat() {
		createAccount.click();		
		SeleniumUtils.waitElementVisibility(driver, wrongFormat);
		return this;
	}
	
	public String wrongFormat() {
		return wrongFormat.getText();
	}
	
	public AutomationPracticeHome emailLogIn(String email){
		emailLogIn.sendKeys(email);
		return this;
	}
	
	public AutomationPracticeHome passwordLogIn(String password) {
		passwordLogIn.sendKeys(password);
		return this;
	}
	
	public AutomationPracticeHome logInFail() {
		logInButton.click();
		SeleniumUtils.waitElementVisibility(driver, logInFail);
		return this;
	}
	
	public String assertLogInFail() {		
		SeleniumUtils.waitElementVisibility(driver, logInFail);
		return logInFail.getText();
	}
	
	public AutomationPracticeHome logInPass() {
		logInButton.click();
		SeleniumUtils.waitElementVisibility(driver, logInConfirm);
		return this;
	}
	
	public String assertLogInPass() {		
		SeleniumUtils.waitElementVisibility(driver, logInConfirm);
		return logInConfirm.getText();
	}
	
}
