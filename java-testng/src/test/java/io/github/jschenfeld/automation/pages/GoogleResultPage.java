package io.github.jschenfeld.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage extends Page {


	@FindBy(xpath = "(//*[@class='g']/descendant::a)[1]")
	private WebElement firstResult;
	
	@FindBys(@FindBy(xpath = "//*[@class='g']/descendant::a[1]"))
	private List<WebElement> resultLinks;
	
	@FindBy(xpath = "(//*[@class='g'])[1]")
	private WebElement resultBlock;

	public GoogleResultPage() {
		super();
		isElementPresent(15, resultBlock);

	}

	public <T> T clickFirstResult(Class<T> returnPage) {
		System.out.println("Clicking first result");
		firstResult.click();
		return PageFactory.initElements(driver, returnPage);
	}	
	
	public void clickResultX(int index){
		By locator = By.xpath("((//*[@class='g'])[" + index + "]/descendant::a)[1]");
		WebElement element = driver.findElement(locator); 
		element.click();
	}
	
	public void clickResultX2(int index){
		resultLinks.get(index).click();
	}
	
	public void clickinFirstResult(){
		By locator = By.xpath("/*/descendant::a");
		resultBlock.findElement(locator).click();
	}
}
