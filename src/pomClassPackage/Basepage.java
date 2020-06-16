package pomClassPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage 

{
	WebDriver driver;
	Logger log=Logger.getLogger("DesireStay");
	public Basepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
    public void preMethod(String key,String value, String link)
    {
    	
	System.setProperty(key, value);
	driver = new ChromeDriver();
	log.info("browser is launched");
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.get(link);
	log.info("entered the url");
    driver.manage().window().maximize();
    log.info("page is maximized");
    
    }
 }

