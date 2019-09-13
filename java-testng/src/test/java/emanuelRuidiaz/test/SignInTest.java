package emanuelRuidiaz.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import emanuelRuidiaz.pages.SignInPage;
import emanuelRuidiaz.persona.Persona;

public class SignInTest extends AbstractTest {

	@Override
	protected String getBaseUrl() {
		return "http://automationpractice.com/index.php";
	}
	
	@DataProvider(name = "usuario")
	public Object[][] signInSuccessfully(){
		Persona persona = new Persona();
		persona.setFirstName("Emanuel");
		persona.setLastName("Ruidiaz");
		persona.setEmail("ema@ema.com");
		persona.setPassword("123456789");
		return new Object[][]{ { persona } };
	}
	
	@Test(priority = 2, dataProvider = "usuario")
	public void signInSuccessfullyTest(Persona persona) {
		
		SignInPage page = new SignInPage(getDriver());
		page.signIn(persona);	
		String name = persona.getFirstName() + " " + persona.getLastName();
		Assert.assertEquals(name, page.getSessionUser().getText());
		System.out.println(" SignInTest(successfully) - PASSED");
	}
	
	@DataProvider(name = "usuarioWrong")
	public Object[][] signInDenied(){
		Persona persona = new Persona();
		persona.setEmail("ema@ema.com");
		persona.setPassword("123456789123");
		return new Object[][]{ { persona } };
	}
	
	@Test(priority = 1,dataProvider = "usuarioWrong")
	public void signInDeniedTest(Persona persona) {
		
		SignInPage page = new SignInPage(getDriver());
		
		page.signIn(persona);
		
		String errorMessage = page.getError_message().getText();
		
		assertEquals(errorMessage, "There is 1 error");
		
		System.out.println(" SignInTest(denied) - PASSED");
	}

}
