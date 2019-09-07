package io.github.jschenfeld.automation.selenium.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {

	public enum Driver {
		CHROME {
			@Override
			public WebDriver build() {
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
			}
		},
		FIREFOX {
			@Override
			public WebDriver build() {
				WebDriverManager.firefoxdriver().setup();
				return new FirefoxDriver();
			}
		},
		REMOTE_CHROME_LINUX {
			@Override
			public WebDriver build() {
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.LINUX);
				caps.setBrowserName("chrome");
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_CHROME_MOBILE_LINUX {
			@Override
			public WebDriver build() {
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", "iPhone X");
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.LINUX);
				caps.setBrowserName("chrome");
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_FIREFOX_LINUX {
			@Override
			public WebDriver build() {
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.LINUX);
				caps.setBrowserName("firefox");
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		};

		public abstract WebDriver build();
	}

	public static URL getHubUrl() {
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return url;
	}

}
