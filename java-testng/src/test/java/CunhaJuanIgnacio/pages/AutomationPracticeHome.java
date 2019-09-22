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
	
	public void enterMail(String mail) {
		inputEmail.sendKeys(mail);
	}
	
	public void clickCreateAccount() {
		createAccount.click();		
		SeleniumUtils.waitElementVisibility(driver, radioBotton);
	}
	
	public void checkMailFormat() {
		createAccount.click();		
		SeleniumUtils.waitElementVisibility(driver, wrongFormat);
	}
	
	public void emailLogIn(String email){
		emailLogIn.sendKeys(email);
	}
	
	public void passwordLogIn(String password) {
		passwordLogIn.sendKeys(password);
	}
	
	public void logInFail() {
		logInButton.click();
		SeleniumUtils.waitElementVisibility(driver, logInFail);
	}
	
	public void logInPass() {
		logInButton.click();
		SeleniumUtils.waitElementVisibility(driver, logInConfirm);
	}
	
}
