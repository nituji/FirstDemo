package pomClassPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage 


{
	WebDriver driver;
	Logger log2=Logger.getLogger("Desirsaty");
	
	@FindBy(xpath="//div[@id='flight_search_result']/div/div[@id='t-w-i-1']/div/div/div[3]/div/div[2]/div/form/button")
	 private WebElement book_button;
	
	@FindBy(xpath="//div[@id='flight_search_result']/div/div[@id='t-w-i-1']/div/div/div[3]/div/div/div/div/span")
	private WebElement prices;
	
		@FindBy(id="total_records")
		protected WebElement records;
		
		//review page locators//
		@FindBy(id="booking_user_name")
		private WebElement email_id;
		
		@FindBy(xpath="//label[@for='alreadyacnt']")
		private WebElement have_account;
		

		@FindBy(id="booking_user_mobile")
		private WebElement mobile_num;
		
		@FindBy(id="terms_cond1")
		private WebElement terms_condition;
		
		@FindBy(id="continue_as_guest")
		private WebElement continue_button;
		
		@FindBy(xpath="//div[@class='reptallt']/div[4]/div")
		WebElement convenience;
	
	
	
	   public SearchResultPage(WebDriver driver)
	     
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
	   
	
	   
	   public void bookAsGuest(String email, String mobile) throws InterruptedException
	   {
		  
		   email_id.sendKeys(email);
		   log2.info("entered  valid email id");
		   
		   mobile_num.sendKeys(mobile);
		   log2.info("entered mobile number");
		   

		   
		   continue_button.click();
		   log2.info("clicked on book as guest button");
	   }
	   
	   public String flightDetails() throws InterruptedException
	   {
		   log2.info("======== booking the flight based on flight code starts =================");
		   Thread.sleep(20000);
		   
	
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			
			log2.info("total number of flights available are = "+records.getText());
			
			 Thread.sleep(4000);
			String  price= prices.getText();
			  
			  Thread.sleep(2000);
			  log2.info("price for selected flight : "+price);
			  
			  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		   book_button.click();
		   log2.info("clicked on book now button");
		   
		   return price;
	   }
	
	   
	public String guest_Convenience() throws InterruptedException, NumberFormatException
	{
		
		  String actual_convenience = convenience.getText();
        // double s2 =Double.parseDouble (s1.substring(2));
         
		 // int actual_convenience=(int)s2;
		  log2.info("the actual convenience fees :"+actual_convenience);
		   
		  return actual_convenience;
	}
	
	 public String[] Flightprice() throws InterruptedException{
		
		 WebDriverWait wait = new WebDriverWait(driver,60);
			
		 wait.until(ExpectedConditions.visibilityOfAllElements(book_button));
		// By.xpath("//div[@id='flight_search_result']/div/div[@id='t-w-i-1']/div/div/div[3]/div/div[2]/div/form/button"));
			Thread.sleep(5000);
		 
			List<WebElement> Allflightprice=driver.findElements(By.xpath("//div [@class='priceflights']"));
			
			int length=Allflightprice.size();
			//System.out.println(length);
			//log.info("printed size");
			 log2.info("number of prices : "+length);
			String[] s=new String[length];
			
			
			for(int i=0;i<length;i++)
			{
			String price=Allflightprice.get(i).getText();
				//System.out.println(price);
			log2.info("flight price : "+price);
			
				s[i]=price;
				}
			return s;
			
			
			}

 public String[] Flightnameandnumber() throws InterruptedException
 {
	 WebDriverWait wait = new WebDriverWait(driver,60);
		
	 wait.until(ExpectedConditions.visibilityOfAllElements(book_button));
	 
			Thread.sleep(5000);
			List<WebElement> length2=driver.findElements(By.xpath("//div [@class='m-b-0 text-center']"));
			
		  int lenth=length2.size();
		  log2.info("number of flights : "+lenth);
		  String[] s2=new String[lenth];

		    for(int i=0;i<lenth;i++)
		{
			String Flight_name=length2.get(i).getText();
			
			log2.info("flight name : "+Flight_name);
			s2[i]=Flight_name;

		}
		  return s2;

		}

/* public String geturl()
 {
	 log2.info("flight name : "+driver.getCurrentUrl());
	 return driver.getCurrentUrl();
	 
 }
 public void refreshMethod(String url)
 {
	 driver.navigate().to(url);
	log2.info("url entered : ");
	 driver.navigate().refresh();
	 log2.info("window refresh  : ");
 }
 
 
 public void windowhndl() throws InterruptedException {
		
		String parent_window=driver.getWindowHandle();
	    System.out.println("Before switching title is "+parent_window);
	   Set<String> s1=driver.getWindowHandles();
	   Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
		String child_window=i1.next();
		if(!parent_window.equalsIgnoreCase(child_window))
		{
			driver.switchTo().window(child_window);
			Thread.sleep(10000);
			System.out.println("After switching title is"+driver.getTitle());
			//driver.close();
		}
			
			
		}
		
		driver.switchTo().window(parent_window);
		System.out.println("Back to the parent window"+driver.getTitle());
		Thread.sleep(5000);
		}*/
		
	
		
	 



}
	
     	





