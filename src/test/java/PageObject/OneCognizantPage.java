package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCognizantPage extends BasePage{

	public OneCognizantPage(WebDriver d) {
		super(d);
	}
	
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement txt_searchBoxChrome;
	
	@FindBy(xpath="//input[@id = 'oneCSearchTop']")
	WebElement txt_searchBoxEdge;
	
	@FindBy(xpath="(//div[@class='appsResultText' and text()='Live Support - GSD'])")
	WebElement logo_gsd;
	
	@FindBy(xpath="//ul[@class = 'searchBasedTopBar']/li")
	WebElement icon_search;
	
	public void  serachGsdChrome(String input) {
		txt_searchBoxChrome.sendKeys(input);	
	}
	
	public void  serachGsdEdge(String input) {
		txt_searchBoxEdge.sendKeys(input);	
	}

	public void clickingGsgLogo() {
		logo_gsd.click();
	}
	
	public void clickSearchIcon() {
		icon_search.click();
	}
	
	
}
