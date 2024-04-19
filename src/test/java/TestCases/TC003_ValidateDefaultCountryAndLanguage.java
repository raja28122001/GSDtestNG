package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class TC003_ValidateDefaultCountryAndLanguage extends BaseClass {
	
	
	@Test
	public void countryAndLanguageValidation() {
		
		logger.info("*****************TC003_ValidateDefaultCountryAndLanguage***************** ");
		try {
			String exp_country = "India";
			String exp_language ="English";	
			
			String actual_country = gp.getDefaultCountry();
			String actual_language = gp.getDefaultLanguage();
			
			System.out.println("Default Country :"+actual_country);
			System.out.println("Default Language :"+actual_language);
			
			logger.info("Captured Default Country And Language");
					
			logger.info("Validating Default Country And Language");
			if(exp_country.equals(actual_country)&&exp_language.equals(actual_language)) {
				logger.info("TC003_Test Passed");
				Assert.assertTrue(true);
			}
			else {
				logger.error("TC003_Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e) {
			logger.error("TC003_Test Failed");
			Assert.fail();
		}
		
	}
	
	
	

}
