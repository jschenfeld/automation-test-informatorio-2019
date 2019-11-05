package io.github.jschenfeld.automation.appium.pages.bienapp;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;

@AndroidFindBy(xpath = "(//android.widget.FrameLayout)[last()]")
public class MenuWidget extends Widget {
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	private MobileElement homeButton;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[2]")
	private MobileElement agendaButton;

	@AndroidFindBy(xpath = "(//android.widget.Button)[3]")
	private MobileElement favoriteButton;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[4]")
	private MobileElement searchButton;
	
	public MenuWidget(WebElement element) {
		super(element);
	}

	public HomePage openHome() {
		homeButton.click();
		return new HomePage(getWrappedDriver());
	}
	
	public AgendaPage openAgenda() {
		agendaButton.click();
		return new AgendaPage(getWrappedDriver());
	}
	
	public FavoritePage openFavorite() {
		favoriteButton.click();
		return new FavoritePage(getWrappedDriver());
	}
	
	public SearchPage openSearch() {
		searchButton.click();
		return new SearchPage(getWrappedDriver());
	}
}