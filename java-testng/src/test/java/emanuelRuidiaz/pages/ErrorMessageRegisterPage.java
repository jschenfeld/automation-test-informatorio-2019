package emanuelRuidiaz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorMessageRegisterPage extends AbstractPage {

	public ErrorMessageRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email_create")
	private WebElement email_create;
	
	@FindBy(id = "SubmitCreate")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//*[contains(text(),'Invalid email address.')]")
	private WebElement error_message;
	
	public void submitData(String wrongEmail) {
		email_create.sendKeys(wrongEmail);
		buttonSubmit.click();
	}
	
	public WebElement getErrorMessage() {
		return error_message;
	}
	

}
