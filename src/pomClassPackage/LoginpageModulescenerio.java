package pomClassPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageModulescenerio

{
WebDriver driver;

	

	@FindBy(xpath="//div [@class='userorlogin'][contains(text(), 'My Account')]")
	WebElement My_account;
	

	@FindBy(xpath=".//*[@id='login_submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']")
	WebElement Myaccount;
	@FindBy(xpath=".//*[@id='email']")
	WebElement Emailemail;
	
	@FindBy(xpath="//input [@id='password']")
	WebElement Password;
	

	public LoginpageModulescenerio(WebDriver driver)	
	
	{			
	this.driver=driver;			
	 PageFactory.initElements(driver, this);

	}

	/*CASE- 1. Both User name and Password are entered correctly. 
	Check whether Email field exists or not */
	 public void Userlogin() throws InterruptedException{
		 
		 My_account.click();
		 Thread.sleep(3000);
	    try
	        {
	          WebElement a1 = driver.findElement(By.xpath(".//*[@id='email']"));
	          System.out.println("---------Emaild exists --------------\n-----------------------");
	          a1.sendKeys("nitutest657@gmail.com");
	         }
	    catch(Throwable e)
	         {
	         System.out.println("Emaild not found: " + e.getMessage());
	         }
	  //Check whether Password field exists or not
	   
	
	    try
        {
	    	
	    	Thread.sleep(1000);
	 WebElement a2 = driver.findElement(By.xpath(".//*[@id='password']"));
         System.out.println("----------Passwordd exits ------------\n-----------------------");
         a2.sendKeys("Nitu@1234");
        }
    catch(Throwable e)
        {
	 System.out.println("Passwordd not found: " + e.getMessage());
        }
	    
	  //Asserting the Sign In button exists or not and clicking it
	    try
	       {
		WebElement button = driver.findElement(By.xpath(".//*[@id='login_submit']"));
	      System.out.println("Signbutton found");
	        
		button.click();
	        }
	    catch(Throwable e)
	        {
		System.out.println("Signbutton not found: "+ e.getMessage());
	        }
	    
	//click on the Account link which contain Signout button.
	     try
	        {
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	 
		WebElement acc = driver.findElement(By.xpath("//div [@class='userorlogin'][contains(text(),' Customer')] "));
		
		Actions actions = new Actions(driver);

		actions.moveToElement(acc).click().perform();
		Thread.sleep(1000);
		//actions.click();
		
		
		
		 System.out.println("--------account link found----------------------");
			//person.click();
		 Thread.sleep(1000);
	        }
		 catch(Throwable e)
	        {
		System.out.println("account link not found:"+e.getMessage());
		
	        }
	     Thread.sleep(3000);

	    //Asserting and clicking on the Signout button.
	    try
	       {	
	    	
		WebElement signout = driver.findElement(By.xpath("//a [@class='user_logout_button'][contains(text(),'Logout')]"));
	        System.out.println("--------Signout link exists  ---------\n-----------------------");
	        Thread.sleep(1000);
		signout.click();
	        }
	    catch(Throwable e)
	        {
		System.out.println("Signbutton not found: "+e.getMessage());
	        }
	    
	    
	 // CASE- 2. Both Email and Password Fields are blank.
	    try
	        {
	    	
	    	 My_account.click();
	    	 Thread.sleep(1000);
	    	 LoginButton.click();
		
	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
	String text = Myacclink.getText();
	
	if(text.equals("My Account"))
	
	{
	   System.out.println("----------Sucessfuln -------");
	}
	else
	{
		System.out.println("----------Loginure ----------");
			}
			
	}
	catch(Throwable e)
	{
			System.out.println("Error Username and Password fields are blank. \n----------------------- ");
	System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	
	driver.navigate().refresh();
	
	  }
	    
	 // CASE- 3. Email field is filled and Password field is blank
	    try
	    {	
	    	My_account.click();
	    	Emailemail.sendKeys("nitutest657@gmail.com");
	    	LoginButton.click();

	    	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
	    	String text = Myacclink.getText();
	    	if(text.equals("My Account"))
	    {
	    System.out.println("----------Sucessfuln -------\n-----------------------");
	    }
	    else
	    {
	    System.out.println("----------Loginure ----------\n-----------------------");
	    		}
	    		
	     }
	    catch(Throwable e)
	     {
	    		System.out.println("Error password field is blank. \n-----------------------");
	    System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	
	    driver.navigate().refresh();
	     }	
	    
	    
	 // CASE- 4. Email field is blank and Password field is filled

	    try
	    {		
	    	My_account.click();
	    	Password.sendKeys("Nitu@1234");
	    	LoginButton.click();


	    	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
	    	String text = Myacclink.getText();
	    	if(text.equals("My Account"))
	    {
	    System.out.println("----------Sucessfuln -------");
	    }
	    else
	    {
	    System.out.println("----------Loginure ----------");
	    		}
	    			
	    }
	    catch(Throwable e)
	    {
	        	System.out.println("Error email field is blank. \n-----------------------");
	    System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	    Password.clear();
	     }
	    

	  //CASE- 5. Email and Password are entered wrong 	

	  try
	  {
		  Emailemail.sendKeys("nitutest@gmail.com");
		  Password.sendKeys("jitu@1234");
	    	LoginButton.click();	 
	   
	    	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
	    	String text = Myacclink.getText();
	    	if(text.equals("My Account"))
	   {
	   System.out.println("----------Sucessfuln -------");
	   }
	   else
	   {
	   System.out.println("----------Loginure ----------");
	  		 }
	  		 
	    }
	  catch(Throwable e)
	  {
	  	
	  	  System.out.println("Error incorrect Email and Password. \n-----------------------");		  
	    System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	    Emailemail.clear();
	    Password.clear();
	  }
	  
	// CASE- 6. Email is wrong and Password is correct 	
	  try 
	  {
		  Emailemail.sendKeys("nitutest@gmail.com");
		  Password.sendKeys("Nitu@1234");
	    	LoginButton.click();	
	 	
	    	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
	    	String text = Myacclink.getText();
	    	if(text.equals("My Account")) 
	 {
	 System.out.println("Sucessfuln \n -----------------");
	 } 
	 else 
	 {
	 System.out.println("Loginure");
	 		}
	   } 
	  catch(Throwable e) 
	  {
	 	  
	 	  System.out.println("Error incorrect Email. \n-----------------------");
	   System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	   }
	  Emailemail.clear();
	    Password.clear();  
	   
	   
	   
	 //CASE- 7. Email is correct and Password is wrong 	
	  try
	  {Emailemail.sendKeys("nitutest657@gmail.com");
	  Password.sendKeys("nitu@1234");
  	LoginButton.click();	
	
  	WebElement Myacclink = driver.findElement(By.xpath("//a [@href='http://192.168.0.165/123holidays/index.php/user/profile/']"));
  	String text = Myacclink.getText();
  	if(text.equals("My Account")) 
	  {
	  System.out.println("----------Sucessfuln -------");
	  } 
	  else
	  {
	  System.out.println("----------Loginure ----------");
	 			}
	   }
	  catch(Throwable e)
	  {
	 	   System.out.println("Error incorrect Password. \n-----------------------");			  
	    System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	   }

	  Emailemail.clear();
	    Password.clear(); 

	 //closing current driver window	
	 		driver.close();
	 		
	 	}

}
