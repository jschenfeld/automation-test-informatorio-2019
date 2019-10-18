package io.github.jschenfeld.automation.selenium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.github.jschenfeld.automation.selenium.pages.youtube.HomeScreenYoutube;

public class YoutubeTest extends MobileBaseTest {

	    @Test
	    public void selectOpenAmesTest() throws MalformedURLException, InterruptedException{
	    	HomeScreenYoutube homeScreen = new HomeScreenYoutube(getDriver());
	    	homeScreen.tapOnSearch();
			new HomeScreenYoutube(getDriver());
			homeScreen.typeThingToSearch();
			homeScreen.searchDevWeek();
			new HomeScreenYoutube(getDriver());
			assertEquals(homeScreen.getResultList(), 5);
	    }
}