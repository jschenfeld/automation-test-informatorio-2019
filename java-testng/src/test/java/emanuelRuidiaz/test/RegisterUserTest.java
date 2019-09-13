package emanuelRuidiaz.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import emanuelRuidiaz.pages.RegisterUserPage;
import emanuelRuidiaz.persona.Country;
import emanuelRuidiaz.persona.Persona;
import emanuelRuidiaz.persona.Persona.gender;
import emanuelRuidiaz.seleniumUtils.RandomStrOrInt;
import emanuelRuidiaz.seleniumUtils.SeleniumUtils;
import emanuelRuidiaz.persona.State;

public class RegisterUserTest extends AbstractTest {

	@Override
	protected String getBaseUrl() {
		return "http://automationpractice.com/index.php";
	}
	
	@DataProvider(name = "usuario")
	public Object[][] registroUsuario(){
		Persona persona = new Persona();
		persona.setFirstName("Emanuel");
		persona.setLastName("Ruidiaz");
		persona.gender = gender.Mr;
		persona.setEmail(RandomStrOrInt.getString(7) + "@gmail.com");
		persona.setPassword(RandomStrOrInt.getString(9));
		persona.setAddress("Av 9 de Julio");
		persona.setCity("Resistencia");
		persona.setZip("15232");
		persona.setMobilePhone("3636458875");
		persona.setCountry(Country.getUnitedStates());
		persona.setCity("Los Angeles");
		persona.setState(State.getCalifornia());
		return new Object[][]{ { persona } };
	}
	
	
	@Test(dataProvider = "usuario")
	public void registerUser(Persona persona) {
		
		RegisterUserPage page = new RegisterUserPage(getDriver());
		page.stepOne(persona);
		
		SeleniumUtils.waitDinamico(getDriver(), page.getGenderMr());
		
		page.stepTwo(persona);
		
		SeleniumUtils.waitDinamico(getDriver(), page.getSessionUser());
		
		String name = persona.getFirstName() + " " + persona.getLastName();
		
		System.out.println("name: " + name);
		System.out.println("name WebElement: " + page.getSessionUser().getText());
		
		Assert.assertEquals(name, page.getSessionUser().getText());
		
	}

}
