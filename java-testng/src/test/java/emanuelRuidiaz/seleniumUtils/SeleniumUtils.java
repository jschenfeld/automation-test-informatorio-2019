package emanuelRuidiaz.seleniumUtils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static boolean waitDinamico(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		return wait.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element)) != null;
	}
	
}