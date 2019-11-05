package io.github.jschenfeld.automation.appium.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.github.jschenfeld.automation.appium.MobileBaseTest;
import io.github.jschenfeld.automation.appium.pages.bienapp.AgendaPage;
import io.github.jschenfeld.automation.appium.pages.bienapp.FavoritePage;
import io.github.jschenfeld.automation.appium.pages.bienapp.HomePage;
import io.github.jschenfeld.automation.appium.pages.bienapp.InformationPage;
import io.github.jschenfeld.automation.appium.pages.bienapp.SearchPage;

public class BienAppTest extends MobileBaseTest {

	
	@Test(enabled = false)
	public void agendaTitle() {
		HomePage homePage = new HomePage(getDriver());
		AgendaPage agendaPage = homePage.getMenu().openAgenda();
		assertEquals(agendaPage.getTitleText(), "GRILLA POR DÍA");
	}
	
	@Test(enabled = false)
	public void favouriteTitle() {
		HomePage homePage = new HomePage(getDriver());
		FavoritePage favoritePage = homePage.getMenu().openFavorite();
		assertEquals(favoritePage.getTitleText(), "MI GRILLA");
	}
	
	@Test(enabled = false)
	public void checkTitleInSearchPage() {
		HomePage homePage = new HomePage(getDriver());
		SearchPage searchPage = homePage.getMenu().openSearch();
		assertEquals(searchPage.getTitleText(), "Buscá tus eventos...");

	}
	
	@Test
	public void checkTitleInformationPage() {
		HomePage homePage = new HomePage(getDriver());
		InformationPage informationPage = homePage.getHeader().openInfomation();
		assertEquals(informationPage.getTitleText(), "Quienes somos...");
		informationPage.moveToBotton();
	}

	@Override
	protected String getConfigName() {
		return "bienApp.config";
	}
}