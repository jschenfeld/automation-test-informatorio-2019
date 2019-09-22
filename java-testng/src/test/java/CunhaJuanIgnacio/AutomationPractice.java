package CunhaJuanIgnacio;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import CunhaJuanIgnacio.dtos.UserDTO;
import CunhaJuanIgnacio.pages.AutomationPracticeHome;
import CunhaJuanIgnacio.pages.AutomationPracticeSingUp;
import CunhaJuanIgnacio.utils.BasePage;

public class AutomationPractice extends BasePage {

	

	UserDTO newUser = new UserDTO("male", "Juan", "Cunha", "12345", 11, 10, 1988, "160 viv. SH C81", "Gutemberg 4300",
			"Brasil 467", "Corrientes", "Florida", 48994, "USA", "None", 4440036, 154792984, "none");

	@Override
	protected String getBaseUrl() {		
		return "http://automationpractice.com/index.php?controller=authentication&back=my-account:8080";
	}
	
	

	
	@Test(groups = {"integrator"})
	public void mailWrongFormat(){
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());

		checkMail.enterMail("dskjfskdjfhsdkjf");
		checkMail.checkMailFormat();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText(), "Invalid email address.");
		
	}
	
	@Test(priority = 1,groups = {"integrator"})
	public void testMail() {

		
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());

		checkMail.enterMail(newUser.getMail());
		checkMail.clickCreateAccount();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "CREATE AN ACCOUNT");

	}

	@Test(priority = 2,groups = {"integrator"})
	public void singUp() {
		
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());

		checkMail.enterMail(newUser.getMail());
		checkMail.clickCreateAccount();		
		
		AutomationPracticeSingUp singUp = new AutomationPracticeSingUp(getDriver());
		singUp.pickGender(newUser.getGender());
		singUp.enterFirstName(newUser.getName());
		singUp.enterLastName(newUser.getLastName());
		singUp.enterPass(newUser.getPassword());
		singUp.enterBirthDay(newUser.getBirthDay(), newUser.getBirthMonth(), newUser.getBirthYear());

		singUp.enterCompany(newUser.getAdressCompany());
		singUp.enterAddress1(newUser.getAdress1());
		singUp.enterAddress2(newUser.getAdress2());
		singUp.enterCity(newUser.getCity());
		singUp.enterAddresState(newUser.getState());
		singUp.enterPostalCode(newUser.getPostalCode());
		//singUp.selectCountry();
		singUp.enterAnotherInfo(newUser.getAdditionalInfo());
		singUp.enterHomePhone(newUser.getHomePhone());
		singUp.enterMobilePhone(newUser.getMobilePhone());
		singUp.enterAlias(newUser.getAddresFutureReference());

		singUp.createAccount();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//a[@class='account']/span")).getText(), newUser.getName() + " " + newUser.getLastName());

	}
	
	@Test(priority = 3,groups = {"integrator"})
	public void logIn() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(newUser.getMail());
		checkMail.passwordLogIn(newUser.getPassword());
		checkMail.logInPass();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//a[@class='account']/span")).getText(), newUser.getName() + " " + newUser.getLastName());
	}
	
	@Test(groups = {"negativePath"})
	public void logInUserDontExist() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(new UserDTO().getMail());
		checkMail.passwordLogIn(new UserDTO().getPassword());
		checkMail.logInFail();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//div[contains(@class,'alert')]/ol/li")).getText(), "Authentication failed.");
	}
	
	@Test(groups = {"negativePath"})
	public void logInEmptyPassword() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(new UserDTO().getMail());		
		checkMail.logInFail();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//div[contains(@class,'alert')]/ol/li")).getText(), "Password is required.");
	}
	
	@Test(groups = {"negativePath"})
	public void logInEmpty() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());		
			
		checkMail.logInFail();
		
		Assert.assertEquals(getDriver().findElement(By.xpath("//div[contains(@class,'alert')]/ol/li")).getText(), "An email address required.");
	}
	
	
	
	
	

	

	
}
