package pomClassPackage;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class promocode

{
	
		WebDriver driver;
		Logger log=Logger.getLogger("http://192.168.0.165/123holidays/");
		 
				@FindBy(name="passenger-first-name-1")
				private WebElement firstname; 
				
				@FindBy(name="passenger-last-name-1")
				private WebElement lastname;
				
				@FindBy(xpath="//input[@id='code']")
				private WebElement promocode;
				
				@FindBy(xpath="//input[@id='apply']")
				private WebElement apply;
				
				@FindBy(id="total_booking_amount")
				private WebElement beforpromocodeprice;
				
				@FindBy(id="total_booking_amount")
				private WebElement afterpromocodeprice;
				
				@FindBy(xpath="//p[@class='error_promocode text-danger']")
				private WebElement invalidtext;
				
				@FindBy(xpath="//div[@class='notese']")
				private WebElement text;
				
				
				
				 public	promocode(WebDriver driver)
			     
					{
						PageFactory.initElements(driver, this);
						this.driver=driver;
					}
				 
				 public String[] addcode(String promo) throws InterruptedException
				 {

				      String[] prices= new String[2];
				     
				     
					 Thread.sleep(3000);
					 	String before=beforpromocodeprice.getText();
						 Thread.sleep(3000);
						 System.out.println("Before applying promocode,The Flight price is:"+before);
						 Thread.sleep(3000);
						 promocode.sendKeys(promo);
						 Thread.sleep(1000);
						 apply.click();
						 Thread.sleep(3000);
						 String after=afterpromocodeprice.getText();
						 Thread.sleep(3000);
						 System.out.println("After applying promocode,The Flight price is:"+after);
						 prices[0]=before;
						 prices[1]=after;
						return prices;
									
				 }
				 		 
				 
	}
	
	
	

