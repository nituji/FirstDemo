package pomClassPackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testClassPackage.BaseClass;

public class RegistrationPage extends BaseClass

{

	WebDriver driver;
	Logger log=Logger.getLogger("DesireStay");
	
	@FindBy(xpath="//div[@class='userorlogin']")
	private WebElement my_account;
	
	@FindBy(xpath=".//*[@id='login']/div[11]/a")
	 private WebElement signup;
	 
	@FindBy(xpath="//form[@id='register_user_form']/div[2]/input")
	 private WebElement email;
	
	@FindBy(css="#register_user_form > div:nth-child(3) > input")
	 private WebElement phone;
	
	@FindBy(xpath="//*[@id=\"register_user_form\"]/div[4]/input")
	 private WebElement pass;
	
	@FindBy(xpath="//*[@id=\"register_user_form\"]/div[5]/input")
	 private WebElement repass;
	
	@FindBy(xpath="//*[@id=\"register_user_form\"]/div[7]/div[1]/div/div/label")
	 private WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"register_user_button\"]")
	 private WebElement submit;
	
	@FindBy(xpath="//*[@id=\"register-status-wrapper\"]")
	 private WebElement message;
	
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public String registration(String email_id ,String phonenumber, String password,String repassword) throws InterruptedException
	{
		String expected_message="mahananda.provab@gmail.com Already Registered!!!";
		my_account.click();
       log.info("clicked on my account");
		Thread.sleep(2000);
		signup.click();
		 log.info("clicked on signup");
		Thread.sleep(2000);
		email.sendKeys(email_id);
		 log.info("entered email id");
		phone.sendKeys(phonenumber);
		log.info("entered phone number");
		pass.sendKeys(password);
		log.info("entered password");
		repass.sendKeys(repassword);
		log.info("entered retype password");
		checkbox.click();
		log.info("selected checkbox");
		submit.click();
		log.info("clicked on submit");
		Thread.sleep(2000);
		String actual_message=message.getText();
		if (actual_message.contains("you have successfully registered with us!!"))
		{ 
		    log.info("registration is Successful");
		    return "pass";
		  }
		
		else 
		{
			log.info("registration is fail");
			return "fail";
		}
	}
		
	
}