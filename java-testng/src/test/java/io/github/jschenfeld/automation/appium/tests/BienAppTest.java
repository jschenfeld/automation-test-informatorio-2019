package io.github.jschenfeld.automation.appium.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.github.jschenfeld.automation.appium.MobileBaseTest;
import io.github.jschenfeld.automation.appium.pages.bienapp.AgendaPage;
import io.github.jschenfeld.automation.appium.pages.bienapp.HomePage;

public class BienAppTest extends MobileBaseTest {

	
	@Test
	public void agendaTitle() throws InterruptedException {
		((AndroidDriver<WebElement> ) getDriver()).getContextHandles()
		HomePage homePage = new HomePage(getDriver());
		AgendaPage agendaPage = homePage.getMenu().openAgenda();
		assertEquals(agendaPage.getTitleText(), "GRILLA POR DÍA");
		HomePage backToHomePage = agendaPage.getMenu().openHome();
	}

	@Override
	protected String getConfigName() {
		return "bienApp.config";
	}
}