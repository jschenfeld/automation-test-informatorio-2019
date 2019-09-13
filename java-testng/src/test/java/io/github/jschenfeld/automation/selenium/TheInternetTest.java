package io.github.jschenfeld.automation.selenium;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.theinternet.TiDropDownPage;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiHomePage;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiMultipleWindows;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiNewWindowPage;

public class TheInternetTest extends AbstractUiTest {

	@Override
	protected String getBaseUrl() {
		return "http://the-internet.herokuapp.com";
	}

	@Test(dataProvider = "dpDropdown")
	public void testDropdown(String option) {
		TiHomePage homePage = new TiHomePage(getDriver());
		TiDropDownPage dropDownPage = homePage.clickDropDownLink();
		dropDownPage.selectByText(option);
		Assert.assertEquals(dropDownPage.getTextOfSelectedOption(), option);
	}
	
	@Test(dataProvider = "dpDropdownIndex")
	public void testDropdownByIndex(int option) {
		TiHomePage homePage = new TiHomePage(getDriver());
		TiDropDownPage dropDownPage = homePage.clickDropDownLink();
		dropDownPage.selectByIndex(option);
	}
	
	@Test
	public void testMultipleWindows() {
		TiHomePage homePage = new TiHomePage(getDriver());
		TiMultipleWindows tiMultipleWindows = homePage.clickMultipleWindows();
		TiNewWindowPage tiNewWindowPage = tiMultipleWindows.clickLink();
		Assert.assertEquals(tiNewWindowPage.getTitle(), "New Window");
	}
	
	@DataProvider
	public Object[] dpDropdown() {
		return new Object[] {"Option 1", "Option 2"};
	}
	
	@DataProvider
	public Object[] dpDropdownIndex() {
		return new Object[] {0, 1, 2};
	}
}
