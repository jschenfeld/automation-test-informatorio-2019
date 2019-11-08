package io.github.jschenfeld.automation.selenium.automationpractice;

import org.openqa.selenium.support.Color;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.jschenfeld.automation.selenium.AbstractUiTest;
import io.github.jschenfeld.automation.selenium.pages.automationpractice.ApAuthentication;

public class ApRegistracionTest extends AbstractUiTest {

	@Override
	protected String getBaseUrl() {
		return "http://automationpractice.com/index.php?controller=authentication";
	}

	@Test(dataProvider = "email")
	public void invalidEmail(String email) {
		ApAuthentication authPage = new ApAuthentication(getDriver());
		authPage.emailAddressCreate(email);
		
		String stringColor = authPage.getEmailCreateColor();
		Color expectedColor = new Color(241, 51, 64, 1);
		Color actualColor = Color.fromString(stringColor);
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualColor,  expectedColor);
		authPage.clickCreate();
		soft.assertEquals(authPage.getCreateAccountError(), 
				"Invalid email address.");
		soft.assertAll();
	}

	@DataProvider(name = "email")
	public Object[] getEmail(){
		return new Object[] {"", "a", "a@", "a@a", "@a.a"};
	}
	
	
	
	
	
	
	@DataProvider(name = "user")
	public Object[][] getUser(){
		return new Object[][] {
			{"", ""},
			{"b"},
			{""}
		};
	}
}
