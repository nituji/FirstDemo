package testClassPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass

{
	public WebDriver driver;
	
    @BeforeClass
	public void precondition()
	{
	    System.setProperty("webdriver.chrome.driver", "G:\\jarFile2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://192.168.0.165/123holidays/");
		//driver.get("https://desirestay.com");
	    driver.manage().window().maximize();
	}
	


    @AfterClass
	public void postcondition()
	{
    	driver.close();
	}
	/*@AfterMethod
	public void postcondition() throws IOException, InterruptedException
	{
	
	 Thread.sleep(3000);
	   
	    	  //Capture entire page screenshot as buffer.
	    	  //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
	    	  File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	  
	    	 FileUtils.copyFile(screen, new File("G:\\seleniumtravel\\FirstDemo\\screenshots"+System.currentTimeMillis()+".png"));
     
		driver.close();
		
    }*/
    
}
