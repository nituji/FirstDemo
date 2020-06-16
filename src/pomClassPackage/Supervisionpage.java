package pomClassPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Supervisionpage
{

	
	WebDriver driver;
	Logger log=Logger.getLogger("123holidays");
	
	@FindBy(id="email")
	private WebElement eamil_id;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login_submit")
	private WebElement login;
	
	@FindBy(id="login_custom")
	private WebElement otp;
	
	@FindBy(xpath="/html/body/div[1]/header/nav/a")
	private WebElement side_bar;
	
	@FindBy(xpath="//ul[@id='magical-menu']/li[14]/a")
	private WebElement settings;
	
	@FindBy(xpath="//ul[@id='magical-menu']/li[14]/ul/li[1]/a")
	private WebElement convenience;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[3]/td[3]/label[1]/input")
	private WebElement percentage;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[3]/td[3]/label[2]/input")
	private WebElement plus;
	
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[3]/td[4]/input")
	private WebElement fees;
	
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[3]/td[5]/label[1]/input")
	private WebElement per_pax_yes;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[3]/td[5]/label[2]/input")
	private WebElement per_pax_no;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[8]/td/input[1]")
	private WebElement update_convenience;
	
	//markup elements
	@FindBy(xpath="//a [@class='sidebar-toggle']")
	private WebElement sidebar;
	@FindBy(xpath="	.//*[@id='magical-menu']/li[7]/a/span")
	private WebElement Markup;
	@FindBy(xpath=".//*[@id='magical-menu']/li[7]/ul/li[1]/a")
	private WebElement B2cmarkup;
	@FindBy(xpath=".//*[@id='magical-menu']/li[7]/ul/li[2]/a")
	private WebElement B2bmarkup;
	@FindBy(xpath=".//*[@id='magical-menu']/li[7]/ul/li[1]/ul/li[1]/a")
	private WebElement B2cflightmarkp;
	@FindBy(xpath=".//*[@id='value_type_plus']")
	private WebElement General_Markup;
	@FindBy(xpath=".//input [@id='generic_value']")
	private WebElement Markup_Value;
	@FindBy(xpath="//button [@id='general-markup-submit-btn']")
	private WebElement General_Markup_Save_button;
	@FindBy(xpath=".//*[@id='general-markup-submit-btn']")
	private WebElement save_Button;
	@FindBy(xpath="//input[@id='value_type_percent']")
	private WebElement precentagemarkupradiobutton;
	
	
	//promocode elements
	
	@FindBy(xpath="/html/body/div[1]/aside[1]/div/section/ul/li[14]/ul/li[2]/a")
	private WebElement promoclick;
	
	@FindBy(xpath="//a[@id='fromListHead']")
	private WebElement managepromocode;
	
	
	@FindBy(xpath="//input[@id='promo_code']")
	private WebElement promocodename;
	
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement Descriptionarea;
	
	@FindBy(xpath="//select[@id='module']")
	private WebElement Category;
	
		
	@FindBy(xpath="//input[@id='promo_codes_formvalue_typeplus']")
	private WebElement discounttype;
	
	@FindBy(xpath="//input[@id='value']")
	private WebElement discountvalue;
	
	
	@FindBy(xpath="//input[@id='minimum_amount']")
	private WebElement minimumamount;
	
	@FindBy(xpath="//input[@id='expiry_date']")
	private WebElement expirydate;
	
	
	@FindBy(xpath="//input[@id='promo_codes_formdisplay_home_pageNo']")
	private WebElement displayonhomepage;
	
	@FindBy(xpath="//input[@id='promo_codes_formstatus1']")
	private WebElement status;
	
	
	@FindBy(xpath="//button[@id='promo_codes_form_submit']")
	private WebElement save;
	

	
public 	Supervisionpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
			
	}


public void adminLogin(String un, String pwd) throws InterruptedException
{
	eamil_id.sendKeys(un);
	log.info("email id entered");
	
	pass.sendKeys(pwd);
	log.info("password entered");
	
	Thread.sleep(3000);
	otp.submit();
	log.info("clicked on login");
}



public void addConvenience(String convenience_type, String value, String per_pax ) throws InterruptedException, AWTException
{
	side_bar.click();
	Thread.sleep(4000);
	log.info("clicked on side menu");
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", settings);
	Thread.sleep(5000);
	log.info("scroll down the side bar");
	
	settings.click();
	log.info("clicked on settings");

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", convenience);
	Thread.sleep(5000);
	convenience.click();
	log.info("selected the convenience fees");
	
	
	
	if(convenience_type.equalsIgnoreCase("percentage"))
	{
		percentage.click();
		Thread.sleep(1000);
		log.info("selected the percentage radio button");
		
		fees.clear();
		Thread.sleep(1000);
		
		fees.sendKeys(value);
		log.info("entered the convenience fees");
	}
	
	else
	{    plus.click();
		Thread.sleep(1000);
		log.info("selected the plus radio button");
		
		fees.clear();
		Thread.sleep(1000);
		
		fees.sendKeys(value);
		Thread.sleep(1000);
		log.info("entered the convenience fees");
		
		if(per_pax.equalsIgnoreCase("yes"))
		{
			per_pax_yes.click();
			Thread.sleep(1000);
			log.info("selected on per passenger");
			
		}
		else
		{
			per_pax_no.click();
			Thread.sleep(1000);
			log.info("per passenger is not selected");
			
		}
	}
	Thread.sleep(2000);
	update_convenience.submit();

}

public void newWindow()
{
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

    driver.get("http://192.168.0.165/123holidays/supervision/index.php/general/indexL");
}
public void Markupadding(String markup) throws InterruptedException{
	sidebar.click();
	Markup.click();
	Thread.sleep(2000);
	log.info("Clicked on Markup");
	Thread.sleep(2000);
	B2cmarkup.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cMarkup");
	Thread.sleep(2000);
	B2cflightmarkp.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cflightMarkup");
	Markup_Value.clear();
	Thread.sleep(2000);
	General_Markup.click();
	log.info("Clicked on markup type radio button");
	Thread.sleep(2000);
	Markup_Value.sendKeys(markup);
	log.info("Entered markup value");
	Thread.sleep(2000);
	save_Button.click();
	log.info("Clicked on save button");
	
	driver.navigate().to("http://192.168.0.165/123holidays/");
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}


public void settingofmarkup0() throws InterruptedException{
	
	sidebar.click();
	Markup.click();
	Thread.sleep(2000);
	log.info("Clicked on Markup");
	Thread.sleep(2000);
	B2cmarkup.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cMarkup");
	Thread.sleep(2000);
	B2cflightmarkp.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cflightMarkup");
	Markup_Value.clear();
	Thread.sleep(2000);
	General_Markup.click();
	log.info("Clicked on markup type radio button");
	Thread.sleep(2000);
	Markup_Value.sendKeys("0");
	log.info("Entered markup value");
	Thread.sleep(2000);
	save_Button.click();
	log.info("Clicked on save button");
	driver.navigate().to("http://192.168.0.165/123holidays/");
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
		
}

public void settingpecentage(String markup) throws InterruptedException{
	
	sidebar.click();
	Markup.click();
	Thread.sleep(2000);
	log.info("Clicked on Markup");
	Thread.sleep(2000);
	B2cmarkup.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cMarkup");
	Thread.sleep(2000);
	B2cflightmarkp.click();
	Thread.sleep(2000);
	log.info("Clicked on b2cflightMarkup");
	Markup_Value.clear();
	Thread.sleep(2000);
	precentagemarkupradiobutton.click();
	log.info("Clicked on markup type radio button");
	Thread.sleep(2000);
	Markup_Value.sendKeys(markup);
	log.info("Entered markup value");
	Thread.sleep(2000);
	save_Button.click();
	log.info("Clicked on save button");
	driver.navigate().to("http://192.168.0.165/123holidays/");
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
		
}





public void addpromo() throws InterruptedException, AWTException
{
	side_bar.click();
	Thread.sleep(4000);
	log.info("clicked on side menu");
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", settings);
	Thread.sleep(5000);
	log.info("scroll down the side bar");
	
	settings.click();
	log.info("clicked on settings");

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promoclick);
	Thread.sleep(5000);
	promoclick.click();
	log.info("selected the promocode link");
	
	managepromocode.click();
	log.info("clicked on create promocode");
	
	promocodename.sendKeys("FLY50");
	log.info("entered the name of promo ");
	
	Thread.sleep(5000);
	Descriptionarea.sendKeys("best offers");
	log.info("entered description about promocode" );
	
	Category.click();
	log.info("selected the plus(rs) promo");
	
	Select sel= new Select(Category);
	Thread.sleep(3000);
	sel.selectByVisibleText("Flight");
	
	discounttype.click();
	Thread.sleep(3000);
	discountvalue.sendKeys("10");
	
	minimumamount.sendKeys("50");
	Thread.sleep(3000);
	((JavascriptExecutor)driver).executeScript ("document.getElementById('expiry_date').removeAttribute('readonly',0);"); 
    
	expirydate.clear();
	
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1000)");
		  
	expirydate.sendKeys("20-4-2019");
	Thread.sleep(3000);
	
	Actions actions = new Actions(driver);

	Robot robot = new Robot();

	robot.mouseMove(50,50);

	actions.click().build().perform();
	//expirydate.click();
	//Thread.sleep(3000);
	
	  Thread.sleep(3000);
	displayonhomepage.click();
	Thread.sleep(3000);
	status.click();
	Thread.sleep(3000);
	save.submit();
	log.info("clicked on create promocode");
}



}
