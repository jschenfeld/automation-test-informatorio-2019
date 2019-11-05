package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.github.jschenfeld.automation.appium.pages.BaseScreen;

public class InformationPage extends BaseScreen {

	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
	private MobileElement title;

	public InformationPage(WebDriver driver) {
		super(driver);
	}

	public String getTitleText() {
		return title.getText();
	}

	public void moveToBotton() {
		PointOption<?> el0 = PointOption.point(new Point(500, 1330));
		PointOption<?> el1 = PointOption.point(new Point(500, 400));
		swipe(el0, el1);
		swipe(el0, el1);
	}
}
