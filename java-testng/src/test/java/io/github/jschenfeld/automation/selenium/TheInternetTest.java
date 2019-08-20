package io.github.jschenfeld.automation.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.AbstractUiTest;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiDropDownPage;
import io.github.jschenfeld.automation.selenium.pages.theinternet.TiHomePage;

public class TheInternetTest extends AbstractUiTest {

	@Override
	protected String getBaseUrl() {
		return "http://the-internet.herokuapp.com";
	}

	@Test
	public void dropdown() {
		String option = "Option 2";
		TiHomePage homePage = new TiHomePage(getDriver());
		TiDropDownPage dropDownPage = homePage.clickDropDownLink();
		dropDownPage.selectByText(option);
		Assert.assertEquals(dropDownPage.getSelectedOption(), option);
	}
}
