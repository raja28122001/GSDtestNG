package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

	public Homepage(WebDriver d) {
		super(d);
	}
	
	@FindBy(id="O365_UniversalMeContainer")
	WebElement profile_element;
	
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement txt_userName;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement txt_email;
	
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement link_oneCognizant;
	
	
	public void clickProfile() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(profile_element).click().perform();
		Thread.sleep(2000);
		act.moveToElement(profile_element).doubleClick().perform();
	}
	
	public String getUsername() {
		return txt_userName.getText();
	}
	
	public String getEmail() {
		return txt_email.getText();
	}
	
	public void clickOneC() {
		link_oneCognizant.click();
	}
	
	public WebElement getOnecLink() {
		return link_oneCognizant;
	}
}
