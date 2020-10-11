package CunhaJuanIgnacio;


import org.testng.Assert;
import org.testng.annotations.Test;

import CunhaJuanIgnacio.dtos.UserDTO;
import CunhaJuanIgnacio.pages.AutomationPracticeHome;
import CunhaJuanIgnacio.pages.AutomationPracticeSingUp;
import CunhaJuanIgnacio.utils.BasePage;

public class AutomationPractice extends BasePage {	

	UserDTO newUser = new UserDTO();
	

	@Override
	protected String getBaseUrl() {		
		return "http://automationpractice.com/index.php?controller=authentication&back=my-account:8080";
	}
	
	@Test(groups = {"integrator"})
	public void mailWrongFormat(){		
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		checkMail.enterMail("dskjfskdjfhsdkjf");
		checkMail.checkMailFormat();
		
		Assert.assertEquals(checkMail.wrongFormat(), "Invalid email address.");
		
	}
	
	@Test(priority = 1,groups = {"integrator"})
	public void testMail() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		checkMail.enterMail(newUser.getMail())
		.clickCreateAccount();
		
		Assert.assertEquals(checkMail.assertCreateAccount(), "CREATE AN ACCOUNT");

	}
	
	
	
	@Test(priority = 2,groups = {"integrator"})
	public void singUp() {	
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.enterMail(newUser.getMail());				
		
		AutomationPracticeSingUp singUp = checkMail.clickCreateAccount();
		singUp.pickGender(newUser.getGender())
		.enterFirstName(newUser.getName())
		.enterLastName(newUser.getLastName())
		.enterPass(newUser.getPassword())
		.enterBirthDay(newUser.getBirthDay(), newUser.getBirthMonth(), newUser.getBirthYear())

		.enterCompany(newUser.getAdressCompany())
		.enterAddress1(newUser.getAdress1())
		.enterAddress2(newUser.getAdress2())
		.enterCity(newUser.getCity())
		.enterAddresState(newUser.getState())
		.enterPostalCode(newUser.getPostalCode())
		
		.enterAnotherInfo(newUser.getAdditionalInfo())
		.enterHomePhone(newUser.getHomePhone())
		.enterMobilePhone(newUser.getMobilePhone())
		.enterAlias(newUser.getAddresFutureReference())

		.createAccount();
		
		Assert.assertEquals(singUp.assertNameAndLastName(), newUser.getName() + " " + newUser.getLastName());

	}
	
	@Test(priority = 3,groups = {"integrator"})
	public void logIn() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(newUser.getMail())
		.passwordLogIn(newUser.getPassword())
		.logInPass();
		
		Assert.assertEquals(checkMail.assertLogInPass(), newUser.getName() + " " + newUser.getLastName());
	}
	
	@Test(groups = {"negativePath"})
	public void logInUserDontExist() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(new UserDTO().getMail())
		.passwordLogIn("askjdfhkasdjhf")
		.logInFail();
		
		Assert.assertEquals(checkMail.assertLogInFail(), "Authentication failed.");
	}
	
	@Test(groups = {"negativePath"})
	public void logInEmptyPassword() {
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());
		
		checkMail.emailLogIn(newUser.getMail())
		.logInFail();
		
		Assert.assertEquals(checkMail.assertLogInFail(), "Password is required.");
	}
	
	@Test(groups = {"negativePath"})
	public void logInEmpty() {	
		AutomationPracticeHome checkMail = new AutomationPracticeHome(getDriver());	
		checkMail.logInFail();
		
		Assert.assertEquals(checkMail.assertLogInFail(), "An email address required.");
	}
	

	

	
}
