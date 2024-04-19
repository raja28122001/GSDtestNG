package TestCases;

import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.GSDPage;
import PageObject.Homepage;
import PageObject.OneCognizantPage;
import TestBase.BaseClass;

public class TC001_ValidateUserInfo extends BaseClass {
	
	
	@Test
	
	public void getUserInfo(){
		
		 hp = new Homepage(driver);
		
		try {
			
			logger.info("************TC001_ValidateUserInfo Started ****************");
			hp.clickProfile();
			logger.info("clicked User Profile");
			SoftAssert sa = new SoftAssert();
			Thread.sleep(2000);
			String userName = hp.getUsername();
			String email = hp.getEmail();
			
			logger.info("Captured UserInfo");
			
			System.out.println("User Info  \nUserUserName : "+userName);
			System.out.println("Email : "+email);
			
			

			if(userName.equals("M, Vimal (Contractor)") && email.equals("2318630@cognizant.com")) {
				logger.info("TC001 Test passed");
				Assert.assertTrue(true);
			}
			else {
				logger.error("TC001 Test Failed");
				Assert.fail();
			}
		}
		catch(Exception e) {
			logger.error("TC001 Test Failed");
			Assert.fail();
    	}
		
	}
	
}
