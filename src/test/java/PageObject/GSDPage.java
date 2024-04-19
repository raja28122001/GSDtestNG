package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GSDPage extends BasePage {

	public GSDPage(WebDriver d) {
		super(d);
	}
	
	@FindBy(xpath="//p[@class='Welcome-automated-text' and contains(text(),'Welcome')]")
	WebElement txt_wlcmMsg;
	
	@FindBy(xpath="(//a[@id='menu1']/span[@class='optionLangSelected'])[1]")
	WebElement txt_defaultLanguage;
	
	@FindBy(xpath="(//a[@id='menu2']/span)[1]")
	WebElement txt_defaultCountry;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu langList']/li[@role='presentation']/a)[position()<=2]")
	List<WebElement> dropdownElements_language;
	
	@FindBy(id="menu2")
	WebElement txtInput_country;
	
	@FindBy(xpath="//ul[@class='dropdown-menu countryList pt-0 show']/li[@role='presentation']/a")
	List<WebElement> dropdownElmnts_country;
	
	@FindBy(xpath="//div[@class='col-md-12 application-tiles']")
	List<WebElement> txt_gsdContents;
	
	
	public String getWelcomeMsg() {
		return txt_wlcmMsg.getText();
	}

	public String getDefaultCountry() {
		return txt_defaultCountry.getText();
	}
	
	public String getDefaultLanguage() {
		return txt_defaultLanguage.getText();
	}
	
	public void clickDefaultLanguage() {
		txt_defaultLanguage.click();
	}
	
	public List<WebElement> getLanguageListElements(){
		return dropdownElements_language;
	}
	
	public void clickCountryInput() {
		txtInput_country.click();
	}
	
	public void selectCountry(int randomNo) {
		List<WebElement>countryList = dropdownElmnts_country;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	     for(int i=1;i<=countryList.size();i++) {		
				WebElement e =countryList.get(randomNo);
				js.executeScript("arguments[0].click();",e);
				break;	
			}	
	}
	
	public List<String> getGsdContents() {
		
		List<WebElement> gsdContents = txt_gsdContents;
		List<String> gsdData = new ArrayList();
		int i=1;
		for(WebElement e:gsdContents) {	
			String options = i+". " +e.getText();   
			gsdData.add(options);
			
			String toolTip = " Tooltip is : "+e.getAttribute("data-bs-original-title");
            gsdData.add(toolTip);
			i++;
		}
		
		return gsdData;
	}
	
	
}
