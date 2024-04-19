package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.GSDPage;
import PageObject.Homepage;
import PageObject.OneCognizantPage;
import TestBase.BaseClass;

public class TC002_ValidateWelcomeMsg extends BaseClass{
		
	@Test
	@Parameters({"browser"})
	public void welcomeMsgValidation(String browserName)  {
		
		
		op = new OneCognizantPage(driver);
	    gp = new GSDPage(driver);
		
		try {	
		logger.info("************TC002_ValidateWelcomeMsg***************");	

		hp.clickOneC();
		
		logger.info("Clicked OneC");
		
		//switching the driver to onec page
        Set<String> windId = driver.getWindowHandles();
		
		ArrayList<String> windIds = new ArrayList(windId);
		
		driver.switchTo().window(windIds.get(1));
		
		if(browserName.equals("chrome")) {
			op.serachGsdChrome("gsd");
		}
		
		else if(browserName.equals("edge")) {
			op.clickSearchIcon();
			op.serachGsdEdge("gsd");
		}
		
		logger.info("Searching Gsd in input search box");
		op.clickingGsgLogo();
		logger.info("Clicked GSD Link");
		driver.switchTo().frame("appFrame");
		
		
		String actual_wlcmMsg = gp.getWelcomeMsg();
		String exp_wlcmMsg = "Welcome to the all-in-one Live Support!";
		
		System.out.println("\nWelcome Message : "+actual_wlcmMsg);
		logger.info("Captured Welcome Message");
		
		logger.info("Validating Welcome Message");
			if(actual_wlcmMsg.equals(exp_wlcmMsg)) {
				logger.info("TC002 Test Passed");
				Assert.assertTrue(true);
			}
			else {
				logger.error("TC002 Test Failed");
				Assert.fail();
			}
		}
		
		catch(Exception e) {
			logger.error("TC002 Test Failed");
		Assert.fail();
		}	
	}
}
