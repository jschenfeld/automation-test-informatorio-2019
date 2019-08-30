package io.github.jschenfeld.automation.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.GuruResultPage;
import io.github.jschenfeld.automation.selenium.pages.GuruTestHomePage;

public class IframeExampleTest extends AbstractUiTest {

	@Override
	protected String getBaseUrl() {
		return "http://demo.guru99.com/test/guru99home/";
	}

	@Test
	public void iframeDemoGuru() {
		GuruTestHomePage testHomePage = new GuruTestHomePage(getDriver());
		String courseTitle = testHomePage.getTextFirstCourse();
		GuruResultPage resultPage = testHomePage.clickFirstCourse();
		Assert.assertEquals(resultPage.getCourseTitle(), courseTitle);
	}
}
