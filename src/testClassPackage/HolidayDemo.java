package testClassPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class HolidayDemo

{
	WebDriver driver;	
	  
	  @BeforeTest
	   public void launchBrowser() throws InterruptedException
	   {
		  System.setProperty("webdriver.chrome.driver","G:\\jarFile2\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
			
			//Getting Current URL
			
			driver.get("http://192.168.0.165/123holidays/");
			
			// Maximizing Current URL
			
			driver.manage().window().maximize();
			
			//Taking for waiting time
			Thread.sleep(2000);
			
	   }
	  
	  
	  @BeforeTest
	  
	  public void loginPage() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  WebElement MyAccount5=driver.findElement(By.xpath("//div[contains(text(),'My Account')]"));
		  Thread.sleep(2000);
		  MyAccount5.click();
		  
		  Thread.sleep(1000);
		  WebElement LoginId=driver.findElement(By.xpath(".//*[@id='email']"));
		  LoginId.sendKeys("test.provab15@gmail.com");
		  
		  WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
		  Password.sendKeys("Provab@123");
		  
		  WebElement Login1=driver.findElement(By.xpath("//*[@id='login_submit']"));
		  Login1.click();
		  
		  System.out.println("Successfully Logged in");
		  
	  }
	  
	  
	  
	  @Test
	  public void FlightIndexPage() throws InterruptedException
	  {
		  Thread.sleep(3000);
		 WebElement  From=driver.findElement(By.xpath(".//*[@id='from']"));
		 From.sendKeys("blr");
		  Thread.sleep(2000);
		  
		  //WebElement FromCity=driver.findElement(By.xpath(".//*[@id='ui-id-17']/a"));
		  WebElement FromCity=driver.findElement(By.xpath("//ul[@id='ui-id-3']/li[2]/a"));
		  

		  Thread.sleep(2000);
		  FromCity.click();
		  
		  //@FindBy(xpath="//ul[@id='ui-id-1']/li[2]/a")
			//private WebElement fromoption;
			
		  
		  Thread.sleep(2000);
		   WebElement To=driver.findElement(By.xpath(".//*[@id='to']"));
		   Thread.sleep(2000);
		   To.sendKeys("del");
		   Thread.sleep(2000);
	       WebElement ToCity=driver.findElement(By.xpath("//ul[@id='ui-id-4']/li[2]/a"));
	       Thread.sleep(2000);
		   ToCity.click(); 
		 
		   Thread.sleep(2000);
		   WebElement datepicker=driver.findElement(By.xpath(".//*[@id='flight_datepicker1']"));
		   //datepicker.sendKeys("14");
		   //datepicker.sendKeys("17");
		   
		   
			//@FindBy(id="flight_datepicker1")
			//private WebElement datepicker1;
		   
	        ((JavascriptExecutor)driver).executeScript ("document.getElementById('flight_datepicker1').removeAttribute('readonly',0);"); 
	         
	        datepicker.sendKeys("17-2-2019");
	        Thread.sleep(2000);
	        datepicker.click();
	      	
	 		//datepicker1.sendKeys(date);
	 		//Thread.sleep(2000);
	 		//datepicker1.click();
		  
			//@FindBy(xpath="//ul[@id='ui-id-2']/li[2]/a")
			//private WebElement tooption;
		  
	        
	        WebElement search=driver.findElement(By.xpath(".//*[@id='flight-form-submit']"));
	        search.click();
	       
	        
	        
	  }
	        
	        
	        
	   @Test
	   
	   public void SearchResultPage()
	   {
		   System.out.println("..............Price Before Sorting.............");
	        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);	
			//Thread.sleep(2000);
			List<WebElement> Allflightprice=driver.findElements(By.xpath("//div [@class='priceflights']"));
			
			// WebDriverWait wait = new WebDriverWait(driver,600);
			// wait.until(ExpectedConditions.visibilityOfAllElements(Allflightprice));

			 
			 System.out.println(Allflightprice);
			
			int length=Allflightprice.size();
			
			//log.info("printed size");
			String[] s=new String[length];
			System.out.println(length );
			
			for(int i=0;i<length;i++)
			{
			String price=Allflightprice.get(i).getText();
			
				System.out.println(price);
				
				//s[i]=price;
			}
			
	   }
		//List<WebElement> descending=driver.findElements(By.xpath("//ul[@class='sortul']/li/a[2]"));
		@Test
		public void sortingacending() throws InterruptedException
		{
			Thread.sleep(5000);
			 System.out.println("..............Price After Ascending  Sorting.............");
			WebElement acending=driver.findElement(By.xpath(".//*[@id='top-sort-list-1']/div/div/div/ul/li[5]/a[1]"));
			acending.click();
			
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			List<WebElement> Allflightprice1=driver.findElements(By.xpath("//div [@class='priceflights']"));
	         System.out.println(Allflightprice1);
			
			int length1=Allflightprice1.size();
			
			//log.info("printed size");
			String[] s1=new String[length1];
			System.out.println(length1 );
			
			for(int i=0;i<length1;i++)
			{
			String price1=Allflightprice1.get(i).getText();
				System.out.println(price1);
				//s[i]=price;
			}
			
			
	}
		
	@Test
		public void sortingdescending() throws InterruptedException
		{
		  
			Thread.sleep(10000);
			 System.out.println("..............Price After Descending Sorting.............");
			WebElement descending=driver.findElement(By.xpath(".//*[@id='top-sort-list-1']/div/div/div/ul/li[5]/a[2]"));
			descending.click();
			
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			List<WebElement> Allflightprice2=driver.findElements(By.xpath("//div [@class='priceflights']"));
	         System.out.println(Allflightprice2);
			
			int length2=Allflightprice2.size();
			
			//log.info("printed size");
			String[] s2=new String[length2];
			System.out.println(length2 );
			
			for(int i=0;i<length2;i++)
			{
			String price2=Allflightprice2.get(i).getText();
				System.out.println(price2);
				//s[i]=price;
			}
			driver.close();
	}
	  
		



}
