package io.github.jschenfeld.automation.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

public class MobileBaseTest {
	
	private WebDriver driver;


	@BeforeMethod
	public void inicializarAplicacion() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("fullReset", false);
		caps.setCapability("clearSystemFiles", false);
		caps.setCapability("appPackage", "com.google.android.youtube");
		caps.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
		caps.setCapability("deviceName", "R58M71DBJSR");
		caps.setPlatform(Platform.ANDROID);
		URL url = new URL("http://127.0.0.1:4444/wd/hub");
		driver = new AndroidDriver<>(url, caps);
	}
	
	@AfterMethod(alwaysRun = true)
	public void cerrarBrowser() {
		if (null != driver) {
			driver.quit();
		}
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
}