package io.github.jschenfeld.automation.appium.pages;

import static io.github.jschenfeld.automation.appium.utils.AndroidUISelectorBuilder.text;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.android.Connection;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.github.jschenfeld.automation.appium.utils.NumberOfMobileElementsToBeMoreThan;

/**
 * Abstract class representation of a screen in the AUT.
 */
public abstract class BaseScreen {
	
	@AndroidFindBy(id = "com.google.android.youtube:id/load_progress")
	private MobileElement loadProgress;

	protected AndroidDriver<WebElement> driver;

	/**
	 * Screen constructor.
	 *
	 * @param pDriver An <code>AppiumDriver</code> instance.
	 */
	public BaseScreen(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
//		waitForinvisibilityOf(driver, 20, loadProgress);
		initElements();
	}
	
	public static boolean waitForinvisibilityOf(AppiumDriver driver, int timeLimitInSeconds, final MobileElement mobileElement) {
	       boolean isElementPresent;
	       try {
	           WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
	           wait.until(ExpectedConditions.invisibilityOf(mobileElement));
	           isElementPresent = mobileElement.isDisplayed();
	           return isElementPresent;
	       } catch (Exception e) {
	           isElementPresent = false;
	           System.out.println(e.getMessage());
	           return isElementPresent;
	       }
	   }

	/**
	 * Page factory.
	 */
	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	/**
	 * Gets the <code>AndroidDriver</code> instance.
	 * 
	 * @return An <code>AndroidDriver</code> instance.
	 */
	protected AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	/**
	 * An implementation of the Wait interface that may have its timeout and polling
	 * interval configured on the fly.
	 * 
	 * @param object
	 * @param timeOutSeconds The timeout duration (seconds)
	 * @return
	 */
	protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
		return new FluentWait<>(object).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withTimeout(timeOutSeconds, SECONDS)
				.pollingEvery(1, SECONDS);
	}

	/**
	 * Gets the <code>waitOn</code> instance.
	 * 
	 * @return A <code>FluentWait</code> instance.
	 */
	protected FluentWait<AndroidDriver<WebElement>> getWait() {
		return waitOn(getDriver(), 10);
	}

	/**
	 * Click on a given <code>MobileElement</code> element. If this causes a new
	 * screen to load, you should discard all references to this element and any
	 * further operations performed on this element will throw a
	 * <code>StaleElementReferenceException</code>.
	 * 
	 * @param element A <code>MobileElement</code> instance.
	 * @trown <code>TimeoutException</code> - If the timeout expires because the
	 *        element is not visible or is disabled such that you cannot click it.
	 */
	protected void click(WebElement element) {
		getWait().until(elementToBeClickable(element)).click();
	}

	protected void tapElementWait(MobileElement mobileElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
		wait.until(visibilityOf(mobileElement)).click();
	}
	
	protected boolean waitUntilElementIsPresent(MobileElement mobileElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
		return wait.until(visibilityOf(mobileElement)) != null;
	}

	protected void scrollScreen(MobileElement element) {
		TouchActions action = new TouchActions(driver);
		action.scroll(element, 10, 100);
		action.perform();
	}

	protected void pressDeviceBackButton() {
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	protected void pressDeviceRecentButton() {
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

	protected void pressDeviceHomeButton() {
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}

	protected void pressDeviceEnter() {
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	/**
	 * Click on a element, given a <code>List</code> of <code>MobileElement</code>
	 * and their position on the list. (1 based list).
	 * 
	 * @param elements A <code>MobileElement</code> list.
	 * @param index    The position of the element on the list (1 based list).
	 */
	protected void click(By elements, int index) {
		getWait().until(new NumberOfMobileElementsToBeMoreThan(elements, index - 1));
		click(getDriver().findElements(elements).get(index));
	}

	/**
	 * Click on an element element given the element text If this causes a new
	 * screen to load, you should discard all references to this element and any
	 * further operations performed on this element will throw a
	 * <code>StaleElementReferenceException</code>.
	 * 
	 * @param text The element text.
	 * @trown <code>TimeoutException</code> - If the timeout expires because the
	 *        element is not visible or is disabled such that you cannot click it.
	 */
	protected void click(String text) {
		By locator = text(text);
		getWait().until(elementToBeClickable(locator)).click();
	}

	/**
	 * Get the visible text of this element
	 * 
	 * @param element A <code>MobileElement</code> instance.
	 * @trown <code>TimeoutException</code> - If the timeout expires because the
	 *        element is not visible.
	 * @return The element text.
	 */
	protected String getText(WebElement element) {
		return getWait().until(visibilityOf(element)).getText();
	}

	/**
	 * Use this method to simulate typing into an element, which may set its value.
	 * 
	 * @param element A <code>MobileElement</code> instance.
	 * @param text    Character sequence to send to the element
	 * @trown <code>TimeoutException</code> - If the timeout expires because the
	 *        element is not visible or is disabled such that you cannot type on it.
	 */
	protected void type(WebElement element, String text) {
		getWait().until(elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}

	protected void typeSlow(WebElement element, String text) {
		getWait().until(elementToBeClickable(element));
		element.clear();
		for (char ch : text.toCharArray()) {
			String a = ch + "";
			element.sendKeys(a);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("error: " + e.getMessage());
			}
		}

	}

	/**
	 * Hides the keyboard if it is showing.
	 */
	protected void hideKeyboard() {
		getDriver().hideKeyboard();
	}

	/**
	 * Checking that an element, known to be present on the screen, is visible.
	 * 
	 * @param element A <code>AndroidElement</code> instance.
	 * @trown <code>TimeoutException</code> - If the timeout expires because the
	 *        element is not visible.
	 * @return True if the element is visible otherwise return false.
	 */
	protected boolean elementExists(WebElement element) {
		try {
			getWait().until(visibilityOf(element));
		} catch (Exception toe) {
			return false;
		}
		return true;
	}

	protected boolean mobileElementExists(MobileElement element) {
		try {
			waitOn(element, 2);
		} catch (Exception toe) {
			return false;
		}
		return true;
	}

	/**
	 * Verify text is present in a element by locator
	 * 
	 * @param locator
	 * @param text
	 * @return
	 */
	protected boolean verifyTextBy(By locator, String text) {
		List<WebElement> elements = getDriver().findElements(locator);
		for (WebElement element : elements) {
			System.out.println("Text element : " + element.getText());
			if (element.getText().contains(text)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Switch to web view context
	 * 
	 */
	protected void switchToWebview() {
		getDriver().context("WEBVIEW");
	}

	/**
	 * Switch to native context
	 * 
	 */
	protected void switchToNativeView() {
		getDriver().context("NATIVE_APP");
	}
	
	protected void swipe(PointOption el0, PointOption el1) {
		TouchAction t = new TouchAction(getDriver());
		t.longPress(el0).moveTo(el1).release().perform();
	}
	
	
}