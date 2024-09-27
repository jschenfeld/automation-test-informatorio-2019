package emanuelRuidiaz.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import emanuelRuidiaz.pages.ErrorMessageRegisterPage;
import emanuelRuidiaz.seleniumUtils.SeleniumUtils;

public class ErrorMessageRegisterTest extends AbstractTest {

	@Override
	protected String getBaseUrl() {
		return "http://automationpractice.com/index.php";
	}
	
	@Test
	public void RegisterError() {
		ErrorMessageRegisterPage page = new ErrorMessageRegisterPage(getDriver());
		page.submitData("wrongemail.com");
		SeleniumUtils.waitDinamico(getDriver(), page.getErrorMessage());
		String errorMessage = page.getErrorMessage().getText();
		assertEquals(errorMessage, "Invalid email address.");
		System.out.println(" Error message Register Test - PASSED");
	}
	

}
