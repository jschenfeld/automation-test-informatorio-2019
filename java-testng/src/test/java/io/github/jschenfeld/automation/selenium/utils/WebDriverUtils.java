package io.github.jschenfeld.automation.selenium.utils;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {
	
	public enum Driver{
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
				URL url = null;
				return new RemoteWebDriver(url, caps);
			}
		},
		REMOTE_CHROME_ANDROID {
			@Override
			public WebDriver build() {
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.ANDROID);
				URL url = null;
				return new RemoteWebDriver(url, caps);
			}
		};
		
		public abstract WebDriver build();
	}

}
