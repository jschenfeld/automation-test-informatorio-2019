package io.github.jschenfeld.automation.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.github.jschenfeld.automation.appium.utils.ApplicationProperties;
import io.github.jschenfeld.automation.appium.utils.Configuration;

public abstract class MobileBaseTest {

	private WebDriver driver;

	protected abstract String getConfigName();

	@BeforeMethod
	public void inicializarAplicacion() throws MalformedURLException {
		Properties prop = ApplicationProperties.load(getConfigName());
		Configuration cfg = ConfigFactory.create(Configuration.class, prop);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("fullReset", cfg.fullReset());
		caps.setCapability("clearSystemFiles", cfg.clearSystemFiles());
		caps.setCapability("appPackage", cfg.appPackage());
		caps.setCapability("appActivity", cfg.appActivity());
		if (cfg.isApp()) {
			String app = new File(ClassLoader.getSystemResource(cfg.app()).getFile()).getAbsolutePath();
			caps.setCapability("app", app);
		}
		caps.setCapability("deviceName", cfg.deviceName());
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