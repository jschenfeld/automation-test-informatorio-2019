package io.github.jschenfeld.automation.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.ToolsQaIframePracticePage;
import io.github.jschenfeld.automation.selenium.pages.ToolsQaSwitchWindowPracticePage;

public class ToolQaTest extends AbstractUiTest {

	@Override
	protected String getBaseUrl() {
		return "https://www.toolsqa.com/iframe-practice-page/";
	}
	
	@Test
	public void newTab() throws InterruptedException {
		ToolsQaIframePracticePage iframePage = new ToolsQaIframePracticePage(getDriver());
		ToolsQaSwitchWindowPracticePage switchWindowsPage = iframePage.clickSwitchWindowsLink();
		switchWindowsPage.clickNewBrowserTabButton();
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.toolsqa.com/");
	}

}