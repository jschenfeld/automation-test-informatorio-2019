package CunhaJuanIgnacio.utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {
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
		};

		public abstract WebDriver build();
	}
}
