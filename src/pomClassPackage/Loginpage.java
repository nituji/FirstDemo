package pomClassPackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 

{
	
	WebDriver driver;
	Logger log=Logger.getLogger("DesireStay");
	
	@FindBy(xpath="//div[@class='userorlogin']")
	private WebElement my_account;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login_submit")
	private WebElement login;
	
	@FindBy(xpath="/html/body/div[2]/header/div[3]/div/div[2]/div[2]/div[1]/a/div/div[2]")
	private WebElement element;
	
	public	Loginpage(WebDriver driver)
   {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public String login(String un,String pwd) throws InterruptedException
	{
		my_account.click();
		Thread.sleep(1000);
		log.info("clicked on my account");
		email.sendKeys(un);
		Thread.sleep(1000);
		log.info("entered username ");
		password.sendKeys(pwd);
		log.info("entered password");
		Thread.sleep(1000);
		login.click();
		Thread.sleep(5000);
		log.info("clicked on login button");
		
		if(element.isDisplayed())
		{
			log.info("login successful");
			return "pass";
		}
		else
		{
			log.info("login successful");
			return "fail";
		}
		
	}
	
	
	

}
