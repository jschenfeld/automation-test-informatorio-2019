package io.github.jschenfeld.automation.appium.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.appium.MobileBaseTest;
import io.github.jschenfeld.automation.appium.pages.HomeScreenYoutube;

public class YoutubeTest extends MobileBaseTest {


	@Test
	public void searchDevWeek() throws MalformedURLException, InterruptedException {
		HomeScreenYoutube homeScreen = new HomeScreenYoutube(getDriver());
		homeScreen.tapOnSearch();
		new HomeScreenYoutube(getDriver());
		homeScreen.typeThingToSearch("Globant DevWeek Resistencia");
		homeScreen.searchDevWeek();
		new HomeScreenYoutube(getDriver());
		assertEquals(homeScreen.getResultList(), 5);
	}

	@Override
	protected String getConfigName() {
		return "youtube.config";
	}
}
