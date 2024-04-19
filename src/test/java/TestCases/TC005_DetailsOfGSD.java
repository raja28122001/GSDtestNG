package TestCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import utility.ExcelUtility;

public class TC005_DetailsOfGSD  extends BaseClass{
	
	
	
	@Test(invocationCount=3)
	@Parameters({"browser"})
	public void getGSDdetails(String br) throws IOException {
		
		// generating a random nummber
		int x = generateRandomNumber();
		
		if(br.equals("chrome"))
	    excel = new ExcelUtility("C:\\Users\\2318630\\eclipse-workspace\\GSDProject\\testData\\Chrome_GsdOutput.xlsx");
		if(br.equals("edge"))
	    excel = new ExcelUtility("C:\\Users\\2318630\\eclipse-workspace\\GSDProject\\testData\\Edge_GsdOutput.xlsx");	
		 
		logger.info("********************TC005_DetailsOfGsd*********************");
		
		try {
		    gp.clickCountryInput();
		    logger.info("Clicked Country Input Box");
		    
			gp.selectCountry(x);
			logger.info("Selected Random Country from the Country List");
			
			String countryName = gp.getDefaultCountry();
			
			System.out.println("-----"+countryName+"------");
			
			List<String> gsdContent = gp.getGsdContents();
			for(int i=0; i<gsdContent.size();i++) {
				int cellNo=0;
				excel.setCellData(countryName, i, cellNo, gsdContent.get(i));
				System.out.println(gsdContent.get(i));
			}
			
			logger.info("Captured Contents Of Gsd for the "+countryName+" Country");
			Assert.assertTrue(true);
			
		}
		catch(Exception e) {
			logger.error("TC005 Test Failed For The Country ");
			Assert.fail();
		}	
	}
	
	
	
	

}
