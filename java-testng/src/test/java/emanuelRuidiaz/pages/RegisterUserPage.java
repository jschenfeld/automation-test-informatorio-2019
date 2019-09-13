package emanuelRuidiaz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import emanuelRuidiaz.persona.Persona;

public class RegisterUserPage extends AbstractPage {

	public RegisterUserPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "email_create")
	private WebElement email_create;
	
	@FindBy(id = "SubmitCreate")
	private WebElement buttonSubmit;
	
	public void stepOne(Persona persona) {
		email_create.sendKeys(persona.getEmail());
		buttonSubmit.click();
	}
	
	@FindBy(id = "id_gender1")
	private WebElement genderMr;
	
	public WebElement getGenderMr() {
		return genderMr;
	}

	@FindBy(id = "id_gender2")
	private WebElement genderMrs;
	
	@FindBy(id = "customer_firstname")
	private WebElement inputFirstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement inputLastName;
	
	@FindBy(id = "passwd")
	private WebElement inputPassword;
	
	@FindBy(id = "address1")
	private WebElement inputAddress;
	
	@FindBy(id = "city")
	private WebElement inputCity;
	
	@FindBy(id = "id_state")
	private WebElement stateDropDown;
	
	@FindBy(id = "postcode")
	private WebElement inputZip;
	
	@FindBy(id = "id_country")
	private WebElement countryDropDown;
	
	@FindBy(id = "phone_mobile")
	private WebElement inputMobilPhone;
	
	@FindBy(id = "submitAccount")
	private WebElement buttonRegister;
	
	public void stepTwo(Persona persona) {
		
		if(persona.getGender().toString() == "Mr") {
			genderMr.click();
		}else {
			genderMrs.click();
		}
		
		inputFirstName.sendKeys(persona.getFirstName());
		
		inputLastName.sendKeys(persona.getLastName());
		
		inputPassword.sendKeys(persona.getPassword());
		
		inputAddress.sendKeys(persona.getAddress());
		
		inputCity.sendKeys(persona.getCity());
		
		stateDropDown.sendKeys(persona.getState());
		
		inputZip.sendKeys(persona.getZip());
		
		countryDropDown.sendKeys(persona.getCountry());
		
		inputMobilPhone.sendKeys(persona.getMobilePhone());
		
		buttonRegister.click();
	}
	
	@FindBy(css = "a[title = 'View my customer account'] span")
	private WebElement sessionUser;

	public WebElement getSessionUser() {
		return sessionUser;
	}

	
}
