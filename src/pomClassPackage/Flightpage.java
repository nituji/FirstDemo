package pomClassPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class Flightpage 
{
	
WebDriver driver;
Logger log=Logger.getLogger("DesireStay");
	
	@FindBy(css="a[aria-controls='flight']")
	private WebElement flight;
	
	@FindBy(xpath=".//*[@id='flight_form']/div/div/div[1]/div/label[3]")
	private WebElement multi_city ;
	
	@FindBy(id="from")
	private WebElement from;
	
	@FindBy(id="to")
	private WebElement to;
	
	@FindBy(id="flight_datepicker1")
	private WebElement datepicker1;
	
	@FindBy(xpath="//*[@id=\"flight_form\"]/div/div/div[4]/div[1]/div[2]/span")
	private WebElement travellers;
	
	@FindBy(id="OWT_adult")
	private WebElement num_adults;
	
	@FindBy(xpath="//button[@data-field='adult' and @data-type='minus']")
	private WebElement adult_minus;
	
	@FindBy(xpath="//button[@data-field='adult' and @data-type='plus']")
	private WebElement adult_plus;
	
	@FindBy(id="OWT_child")
	private WebElement num_child;
	
	@FindBy(xpath="//button[@data-field='child' and @data-type='plus']")
	private WebElement child_plus;
	
	@FindBy(xpath="//button[@data-field='child' and @data-type='minus']")
	private WebElement child_minus;
	
	@FindBy(id="OWT_infant")
	private WebElement num_infant;
	
	@FindBy(xpath="//button[@data-field='infant' and @data-type='plus']")
	private WebElement infant_plus;
	
	@FindBy(xpath="//button[@data-field='infant' and @data-type='minus']")
	private WebElement infant_minus;
	
	@FindBy(xpath="//ul[@id='ui-id-3']/li[2]/a")
	private WebElement fromoption;
	
	@FindBy(xpath="//ul[@id='ui-id-4']/li[2]/a")
	private WebElement tooption;
	
	@FindBy(id="m_flight_datepicker2")
	private WebElement datepicker2;
	
	@FindBy(id="m_from3")
	private WebElement from3;
	
	@FindBy(id="m_to3")
	private WebElement to3;
	
	@FindBy(id="m_flight_datepicker3")
	private WebElement datepicker3;
	
	@FindBy(id="m_from4")
	private WebElement from4;
	
	@FindBy(id="m_to4")
	private WebElement to4;
	
	@FindBy(id="m_flight_datepicker4")
	private WebElement datepicker4;
	
	@FindBy(id="m_from5")
	private WebElement from5;
	
	@FindBy(id="m_to5")
	private WebElement to5;
	
	@FindBy(id="m_flight_datepicker5")
	private WebElement datepicker5;
	
	@FindBy(id="add_city")
	private WebElement add_city;
	
	@FindBy(id=".//*[@id='multi_city_container_3']/div[2]/button")
	private WebElement remove_city3;
	
	@FindBy(id=".//*[@id='multi_city_container_4']/div[2]/button")
	private WebElement remove_city4;
	
	@FindBy(id=".//*[@id='multi_city_container_5']/div[2]/button")
	public WebElement remove_city5;
	
	@FindBy(xpath="//div[contains(text(),'Advanced options')]")
	private WebElement advance_options;
	
	@FindBy(id="choosen_airline_class")
	private WebElement airline_class;
	
	@FindBy(id="choosen_preferred_airline")
	private WebElement choose_airlines; 
	
	@FindBy(id="flight-form-submit")
	private WebElement search_flight ;
	
	@FindBy(id="total_records")
	private WebElement total_records;
	
	@FindBy(xpath=".//h2[contains(text(),'Perfect Holidays')]")
	private WebElement heading;
	
	
     public	Flightpage(WebDriver driver)
     
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
     
     public  void add_travellers(int adult, int child,int infant)
     {
    	 
    	 travellers.click();
    	 log.info("clicked on travellers");
    	 
         int adults=Integer.parseInt(num_adults.getAttribute("value"));
         if(adult==1)
 		{
 			while(adults!=1)
 			{
 				adult_minus.click();
 				log.info("clicked on adult decrement");
 				--adults;
 			}
 		}
 		while(adult !=0 && adult > 1)
 		{
 			if(adults < adult)
 			{
 			adult_plus.click();
 			log.info("clicked on adult increment");
 			--adult;
 			}
 			else if(adults > adult)
 			{
 				adult_minus.click();
 				log.info("clicked on adult decrement");
 				--adult;
 			}
 			else 
 			{
 				break;
 			}
 			
 		}
 		
 		 int children=Integer.parseInt(num_child.getAttribute("value"));
 		 
 		 
 		
 		while(child !=0)
 		{
 			
 			if(children < child)
 			{
 				
 			child_plus.click();
 			log.info("clicked on child increment");
 			--child;
 			}
 			else if(children > child)
 			{
 				child_minus.click();
 				log.info("clicked on child decrement");
 				--child;
 			}
 			else 
 			{
 				break;
 			}
 			
 		}
 		
        int infants=Integer.parseInt(num_infant.getAttribute("value"));
 		
 		while(infant!=0)
 		{
 			
 			if(infants < infant)
 			{
 				
 			infant_plus.click();
 			log.info("clicked on infant increment");
 			--infant;
 			}
 			else if(infants > infant)
 			{
 				infant_minus.click();
 				log.info("clicked on infant decrement");
 				--infant;
 			}
 			else 
 			{
 				break;
 			}
 			
 		}
    	 
     }
     public void city_addition(String source,String destination,String date) throws IOException, InterruptedException
     {
    	
    	 from.clear();
    	 from.sendKeys(source);
    	 log.info("entered from city");
    	Thread.sleep(2000);
    	 fromoption.click();
    	 log.info("from city selected from dropdown");
 		
 		
 		to.clear();
 		to.sendKeys(destination);
 		 log.info("entered to city");
 		Thread.sleep(2000);
 		tooption.click();
 		log.info("to city selected to dropdown");
 		
 		((JavascriptExecutor)driver).executeScript ("document.getElementById('flight_datepicker1').removeAttribute('readonly',0);"); 
         
 		datepicker1.clear();
      	
 		datepicker1.sendKeys(date);
 		Thread.sleep(1000);
 		datepicker1.click();
     	log.info("date is selected from datepicker");
     	Thread.sleep(1000);
     	
          
     }
	public void onewaySearh(String source,String destination,String date,int adult, int child,int infant) throws IOException, InterruptedException
	{
		city_addition(source,destination, date);
		add_travellers( adult,child, infant);
		search_flight.click();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(20000);
		log.info("clicked on search button");
	}
	
	public void navigateMethod(String url) throws InterruptedException
	{
		driver.navigate().to(url);
    	log.info("webdriver navigated to supervision");
    	Thread.sleep(3000);
		
	}

	
	
}
