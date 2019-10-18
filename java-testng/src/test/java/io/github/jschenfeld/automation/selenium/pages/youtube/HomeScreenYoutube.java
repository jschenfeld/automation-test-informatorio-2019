package io.github.jschenfeld.automation.selenium.pages.youtube;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * This class represents the Home screen of the AUT.
 */
public class HomeScreenYoutube extends BaseScreen {

	public HomeScreenYoutube(WebDriver driver) throws MalformedURLException, InterruptedException {
		super((AndroidDriver<WebElement>) driver);
		switchToNativeView();
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Search']")
	private MobileElement searchButton;
	
	@AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
	private MobileElement searchBox;
	
	@AndroidFindBy(id = "com.google.android.youtube:id/title")
	private MobileElement titleDevWeek;
	
	@AndroidFindBy(id="com.google.android.youtube:id/video_info_view")
	private List<MobileElement> devWeekVideos;
	
	@AndroidFindBy(id="com.google.android.youtube:id/results")
	private MobileElement results;

	public void tapOnSearch() {
		tapElementWait(searchButton, 15);
	}
	
	public void typeThingToSearch() throws InterruptedException {
		tapElementWait(searchBox, 15);
		searchBox.sendKeys("Globant DevWeek Resistencia");
	}
	
	public void searchDevWeek() throws InterruptedException {
		pressDeviceEnter();
	}
	
	public void clickOnVideo() throws InterruptedException {
		tapElementWait(devWeekVideos.get(1), 15);

	}
	
	public String titleDevWeek() throws InterruptedException {
		System.out.println("element titleDevWeek is present: " + waitUntilElementIsPresent(titleDevWeek, 15));
		return titleDevWeek.getText();
	}

	public int getResultList() {
		waitUntilElementIsPresent(results, 20);
		return devWeekVideos.size();
	}	
}