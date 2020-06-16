package pomClassPackage;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravellersPage 
{
	WebDriver driver;
	Logger log2=Logger.getLogger("Desirestay");
	
	@FindBy(xpath="//button[@id='flip']")
	 WebElement continue_button;
	
	//@FindBy(xpath="//div[@class='reptallt']/div[4]/div[1]")
	// WebElement conveniencefees;
	
	@FindBy(xpath="//div[@class='padpaspotr']/div[2]/div/div[2]/div[2]/div/div[4]")
	 WebElement conveniencefees;
	
	int i=0, j=0;
	
	public TravellersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	 //* date generic function  *//
	public void dateFunction(String year,int month,String day) throws InterruptedException
	{
		
		  List 	<WebElement> dob= driver.findElements(By.xpath("//*[contains(@id,'-date-picker-')]"));
			 
			dob.get(j).click();
			Thread.sleep(1000);
			
		WebElement year1=(driver.findElement(By.cssSelector(".ui-datepicker-year")));
		 year1.click();
		Select year_sel=new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));

		year_sel.selectByVisibleText(year);

		WebElement month1= driver.findElement(By.cssSelector(".ui-datepicker-month"));
		
		month1.click();
		Thread.sleep(1000);
		
		Select month_sel=new Select(month1);
		month_sel.selectByIndex(month-1);

		//table[@class='ui-datepicker-calendar']/tbody/tr/td")
		List <WebElement> days= driver.findElements(By.tagName("td"));

		for( WebElement day1: days)
		{
			if(day.equalsIgnoreCase(day1.getText()))
			{ 
				Thread.sleep(1000);
				day1.click();
				break;
			}
		}
            j++;
            
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,100)");
          	   
			 
	}
	 
	
	
	
	//* travellers addition  *//
	
	public void travellersDetailsAddition(String salu, String fname, String lname ,String  date) throws InterruptedException, IOException
	{
	
		
		log2.info("==========  Travellers details addition starts =================");
		Thread.sleep(2000);
		List  	<WebElement> Fname= driver.findElements(By.xpath("//input [contains(@id,'passenger-first-name-')]"));
		  
		 List	<WebElement> Lname= driver.findElements(By.xpath("//input[contains(@id,'passenger-last-name-')]"));
		                                              
		// List	<WebElement> salutation= driver.findElements(By.xpath("//div/select"));
		 
		 
		 
		   List	<WebElement> salutation= driver.findElements(By.xpath("//div[@class='selectedwrap']/select"));
		 System.out.println(salutation.size());
		   
		   WebElement ele=salutation.get(i);
		
		   Select sel=new Select(ele);
		  sel.selectByVisibleText(salu);
		
		log2.info("the salutation is selected");
		
		
			Fname.get(i).sendKeys(fname);
	        log2.info("Fname is entered");
			
			
			Lname.get(i).sendKeys(lname); 
			log2.info("Lname is entered");
	      Thread.sleep(2000);
	      
	      String[] str=date.split("-");
	      
			String day=(str[0].replace("0",""));
			
			int month=Integer.parseInt(str[1].replace("0",""));
			
			String year=str[2];
			Thread.sleep(1000);
			System.out.println("the date is =" +day+","+month+","+year);
			
			dateFunction(year,month,day);
			Thread.sleep(1000);
			log2.info("date is selected");
		     
			i++;		
	}
	
	public String registered_Convenience() throws InterruptedException, NumberFormatException
	{
	
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", convenience);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		  String actual_convenience = conveniencefees.getText();
        // double s2 =Double.parseDouble (s1.substring(2));
			Thread.sleep(2000);
		 // int actual_convenience=(int)s2;
		  log2.info("the actual convenience fees :"+actual_convenience);
		  Thread.sleep(2000);
		  return actual_convenience;
	}
	
	
	public void flightBooking() throws InterruptedException
	{
		Thread.sleep(4000);
		continue_button.submit();
		
	}

}
