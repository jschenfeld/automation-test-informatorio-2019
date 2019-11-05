package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;

@AndroidFindBy(xpath = "(//android.widget.FrameLayout)[1]")
public class HeaderWidget extends Widget {
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	private MobileElement infoButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private MobileElement logo;
	
	protected HeaderWidget(WebElement element) {
		super(element);
	}
	
	public InformationPage openInfomation() {
		infoButton.click();
		return new InformationPage(getWrappedDriver());
	}
	
	public boolean isLogo() {
		return logo.isDisplayed();
	}
}
