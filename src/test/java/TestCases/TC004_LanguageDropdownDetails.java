package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class TC004_LanguageDropdownDetails extends BaseClass {
	
	
	@Test
	public void languageDropdownDetails() {
		
		logger.info("*****************TC004_LanguageDropdownDetails********************");
		
		try {
			
			gp.clickDefaultLanguage();
			
			logger.info("Clicked Default Language Options");
			
			List<WebElement> languageList = gp.getLanguageListElements();
			
			System.out.println("\nDropdown Languages in GSD Page");
			
			for( WebElement e:languageList) {
				System.out.println(e.getAttribute("innerHTML"));
			}
			logger.info("Captued Dropdown elements of Language");
			
			if(languageList.size()==2) {
				logger.info("TC004 Test Passed");
				Assert.assertTrue(true);
			}
			else {
				logger.error("TC004 Test Failed");
				Assert.fail();
			}
		}
		
		catch(Exception e) {
			logger.error("TC004 Test Failed");
			Assert.fail();
		}	
	}
}
