package CunhaJuanIgnacio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void pickGender(String gender) {
		if(gender == "male") {
			genderMale.click();			
		}else if(gender == "female"){
			genderFemale.click();			
		}
	}	
	
	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}
	
	public void enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void enterPass(String pass) {
		password.sendKeys(pass);
	}
	
	
	/**
	 * Method to select day, month and year of birth
	 * @param day
	 * @param month
	 * @param year
	 */
	public void enterBirthDay(Integer day,Integer month, Integer year){
		WebElement enterDay = driver.findElement(By.xpath("//select[@id='days']/option["+(day+1)+"]"));
		enterDay.click();
		
		WebElement enterMonth = driver.findElement(By.xpath("//select[@id='months']/option["+(month+1)+"]"));
		enterMonth.click();
		
		WebElement enterYear = driver.findElement(By.xpath("//select[@id='years']/option[@value='"+(year)+"']"));
		enterYear.click();
	}
	
	public void enterCompany(String company) {
		this.company.sendKeys(company);
	}
	
	
	public void enterAddress1(String address) {
		this.address1.sendKeys(address);
	}
	
	public void enterAddress2(String address){
		this.address2.sendKeys(address);
	}
	
	public void enterCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void enterAddresState(String state) {
		WebElement enterState = driver.findElement(By.xpath("//div/select[@id='id_state']/option[text()='"+state+"']"));
		
		enterState.click();
				
	}
	
	public void enterPostalCode(Integer postalCode) {
		this.postalCode.sendKeys(postalCode.toString());
	}
	
	public void selectCountry(){
		country.click();
	}
	
	public void enterAnotherInfo(String otherInfo) {
		this.otherInfo.sendKeys(otherInfo);
	}
	
	public void enterHomePhone(Integer phone) {
		homePhone.sendKeys(phone.toString());
	}
	
	public void enterMobilePhone(Integer mobilePhone) {
		mobile.sendKeys(mobilePhone.toString());
	}
	
	public void enterAlias(String alias) {
		this.alias.clear();
		this.alias.sendKeys(alias);
	}
	
	public void createAccount() {
		this.createButton.click();
		SeleniumUtils.waitElementVisibility(driver, userConfirm);
	}
}
