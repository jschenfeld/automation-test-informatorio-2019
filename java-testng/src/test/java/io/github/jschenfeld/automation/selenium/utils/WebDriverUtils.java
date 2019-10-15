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

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
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
		CHROME_MOBILE {
			@Override
			public WebDriver build() {
				WebDriverManager.chromedriver().setup();
				System.out.println("Remote Chrome Mobile");
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", "iPhone X");
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				return new ChromeDriver(chromeOptions);
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
				System.out.println("Chrome");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.LINUX);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_CHROME_MOBILE_LINUX {
			@Override
			public WebDriver build() {
				System.out.println("Remote Chrome Mobile");
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", "iPhone X");
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.LINUX);
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_FIREFOX_LINUX {
			@Override
			public WebDriver build() {
				System.out.println("Firefox");
				DesiredCapabilities caps = DesiredCapabilities.firefox();
				caps.setPlatform(Platform.LINUX);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_CHROME_WINDOWS {
			@Override
			public WebDriver build() {
				System.out.println("Chrome");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.WINDOWS);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_CHROME_MOBILE_WINDOWS {
			@Override
			public WebDriver build() {
				System.out.println("Remote Chrome Mobile");
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", "iPhone X");
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.WINDOWS);
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		CHROME_MOBILE_ANDROID {
			@Override
			public WebDriver build() {
				System.out.println("Remote Chrome Mobile");

				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.ANDROID);
				caps.setCapability("platformName", Platform.ANDROID);
				caps.setCapability("deviceName", "Galaxy Tab A (2016)");
				return new AndroidDriver<>(getHubUrl(), caps);
			}
		},
		REMOTE_CHROME_MOBILE_ANDROID {
			@Override
			public WebDriver build() {
				System.out.println("Remote Chrome Mobile");
//				Map<String, String> mobileEmulation = new HashMap<>();
//				mobileEmulation.put("deviceName", "iPhone X");
//				
//				ChromeOptions chromeOptions = new ChromeOptions();
//				WebDriverManager.chromedriver().setup();

				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.ANDROID);
				caps.setCapability("platformName", Platform.ANDROID);
				caps.setCapability("deviceName", "Galaxy Tab A (2016)");

//				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		},
		REMOTE_FIREFOX_WINDOWS {
			@Override
			public WebDriver build() {
				System.out.println("Firefox");
				DesiredCapabilities caps = DesiredCapabilities.firefox();
				caps.setPlatform(Platform.WINDOWS);
				return new RemoteWebDriver(getHubUrl(), caps);
			}
		};

		public abstract WebDriver build();
	}

	public static URL getHubUrl() {
		String hubUrl = System.getProperty("hubUrl");
		if(null == hubUrl || hubUrl.isEmpty()) {
			hubUrl = "http://127.0.0.1:4444/wd/hub";
		}
		
		URL url = null;
		try {
			System.out.println("HUB_URL: " + hubUrl);
			url = new URL(hubUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return url;
	}

}
