package io.github.jschenfeld.automation.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public static WebDriver getDriver(Browser browser) {		
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(browser.setDriver());
		return eventFiringWebDriver.register(new EventHandler());
	}

	public enum Browser {
		ANDROID_CHROME {
			@Override
			public WebDriver setDriver() {
				WebDriverManager.chromedriver().setup();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("chrome");
	    		capabilities.setCapability("platformName","Android");
	    		capabilities.setCapability("deviceName", "Galaxy J7 Prime");
				try {
					return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				} catch (MalformedURLException e) {
					throw new RuntimeException("Malformed url.");
				}
			}
		},
		CHROME {
			@Override
			public WebDriver setDriver() {
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				return driver;
			}
		},
		FIREFOX {
			@Override
			public WebDriver setDriver() {
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver =  new FirefoxDriver();
				driver.manage().window().maximize();
				return driver;
			}
		};

		public abstract WebDriver setDriver();
	}
}