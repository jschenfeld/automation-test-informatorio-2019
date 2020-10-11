package CunhaJuanIgnacio.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import CunhaJuanIgnacio.utils.SeleniumUtils;

public class AutomationPracticeSingUp {
	private WebDriver driver;
	
	public AutomationPracticeSingUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	//FindBy Web Elements
	
	@FindBy(id = "id_gender1")
	private WebElement genderMale;
	
	@FindBy(id = "id_gender2")
	private WebElement genderFemale;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastName;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	//-----------
	@FindBy(id = "days")
	private WebElement dayWebElement;
	
	@FindBy(id = "months")
	private WebElement monthWebElement;
	
	@FindBy(id = "years")
	private WebElement yearWebElement;
	
	@FindBy(id= "id_state")
	private WebElement stateWebElement;
	//-----------
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "address1")
	private WebElement address1;
	
	@FindBy(id = "address2")
	private WebElement address2;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "postcode")
	private WebElement postalCode;
	
	@FindBy(xpath = "//div/select[@id='id_country']/option[@value=21]")
	private WebElement country;
	
	@FindBy(id = "other")
	private WebElement otherInfo;
	
	@FindBy(id = "phone")
	private WebElement homePhone;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobile;
	
	@FindBy(id = "alias")
	private WebElement alias;	
	
	@FindBy(id = "submitAccount")
	private WebElement createButton;
	
	//Waits
	
	@FindBy(xpath = "//a[@class='account']/span")
	private WebElement userConfirm;
	
	//SingUp methods
	
	public AutomationPracticeSingUp pickGender(String gender) {		
		if(gender.equals("male")) {
			genderMale.click();			
		}else if(gender.equals("female")){
			genderFemale.click();			
		}
		return this;
	}	
	
	public AutomationPracticeSingUp enterFirstName(String name) {
		firstName.sendKeys(name);
		return this;
	}
	
	public AutomationPracticeSingUp enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}
	
	public AutomationPracticeSingUp enterPass(String pass) {
		password.sendKeys(pass);
		return this;
	}
	
	
	/**
	 * Method to select day, month and year of birth
	 * @param day
	 * @param month
	 * @param year
	 */
	public AutomationPracticeSingUp enterBirthDay(Integer day,Integer month, Integer year){	
		
		Select daySelect = new Select(dayWebElement);
		daySelect.selectByValue(day.toString());
		
		Select monthSelect = new Select(monthWebElement);
		monthSelect.selectByValue(month.toString());
		
		Select yearSelect = new Select(yearWebElement);
		yearSelect.selectByValue(year.toString());
		return this;
	}
	
	public AutomationPracticeSingUp enterCompany(String company) {
		this.company.sendKeys(company);
		return this;
	}
	
	
	public AutomationPracticeSingUp enterAddress1(String address) {
		this.address1.sendKeys(address);
		return this;
	}
	
	public AutomationPracticeSingUp enterAddress2(String address){
		this.address2.sendKeys(address);
		return this;
	}
	
	public AutomationPracticeSingUp enterCity(String city) {
		this.city.sendKeys(city);
		return this;
	}
	
	public AutomationPracticeSingUp enterAddresState(String state) {		
		Select stateSelect = new Select(stateWebElement);
		stateSelect.selectByVisibleText(state);
		return this;		
	}
	
	public AutomationPracticeSingUp enterPostalCode(Integer postalCode) {
		this.postalCode.sendKeys(postalCode.toString());
		return this;
	}
	
	public AutomationPracticeSingUp selectCountry(){
		country.click();
		return this;
	}
	
	public AutomationPracticeSingUp enterAnotherInfo(String otherInfo) {
		this.otherInfo.sendKeys(otherInfo);
		return this;
	}
	
	public AutomationPracticeSingUp enterHomePhone(Integer phone) {
		homePhone.sendKeys(phone.toString());
		return this;
	}
	
	public AutomationPracticeSingUp enterMobilePhone(Integer mobilePhone) {
		mobile.sendKeys(mobilePhone.toString());
		return this;
	}
	
	public AutomationPracticeSingUp enterAlias(String alias) {
		this.alias.clear();
		this.alias.sendKeys(alias);
		return this;
	}
	
	public AutomationPracticeSingUp createAccount() {
		this.createButton.click();
		SeleniumUtils.waitElementVisibility(driver, userConfirm);
		return this;
	}
	
	public String assertNameAndLastName() {
		SeleniumUtils.waitElementVisibility(driver, userConfirm);
		return userConfirm.getText();
	}
}
