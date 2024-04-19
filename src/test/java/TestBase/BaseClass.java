package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PageObject.GSDPage;
import PageObject.Homepage;
import PageObject.OneCognizantPage;
import utility.ExcelUtility;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	public static Homepage hp;
	public static GSDPage gp;
	public static OneCognizantPage op;
	public static Logger logger;
	public static FileInputStream file;
	public static ExcelUtility excel;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browserName){
		
		switch(browserName.toLowerCase()) {
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("No matching browser"); return;
		}
		
		try {
			p = new Properties();
			file = new FileInputStream("C:\\Users\\2318630\\eclipse-workspace\\GSDProject\\src\\test\\resources\\config.properties");
			p.load(file);
		}
		catch(Exception e) {
			System.out.println("file not found!");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(this.getClass());
		
		logger.info("-----------Driver setup done with "+browserName+" browser------------------");
		
	}
	
	@AfterTest
	public void close() {
		logger.info("----------Driver Closed---------------");
		driver.quit();
	}
	
	
	// method tp generate random number
	public int generateRandomNumber() {
		
		int x;
		while(true) {
			x=(int) (Math.random()*100);
			if(x>=1&&x<=56) {
					break;
			  }
			}
		return x;
	}
	
	
	public String captureScreen(String ssName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + ssName + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;

	}
	

}
