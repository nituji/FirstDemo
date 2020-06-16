package testClassPackage;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import genericPackage.Generic;
import pomClassPackage.Flightpage;
import pomClassPackage.Loginpage;
import pomClassPackage.SearchResultPage;
import pomClassPackage.Supervisionpage;
import pomClassPackage.TravellersPage;

public class ConvenienceTest extends BaseClass

{
	Generic g1=new Generic();
	
	@Test(enabled = false,priority=1)
	public void loginMethod() throws InterruptedException
	{
		String username=g1.getData("Sheet1", 1, 1);
	    String password=g1.getData("Sheet1", 2, 1);
		
		Loginpage lp= new  Loginpage(driver);
		String status=lp.login(username,password);
		g1.setData("Sheet1", 1,2, status);
		
	}
	
	@Test(enabled = true)
	public void GuestuserconvenienceFees() throws InterruptedException, AWTException, IOException, NumberFormatException
	{
		 String expected_convenience;
		Flightpage fp= new Flightpage(driver);
		Supervisionpage sp= new Supervisionpage(driver);
		SearchResultPage srp=new SearchResultPage(driver);
		
		
		String url=g1.getData("Sheet2", 2, 1);
		String un=g1.getData("Sheet2", 3, 1);
		String pass=g1.getData("Sheet2", 4, 1);
		 
		fp.navigateMethod(url);
		
		sp.adminLogin(un, pass);
		
		String convenience_type=g1.getData("Sheet2", 7, 1);
		String value=g1.getData("Sheet2",7, 2);
		String per_pax=g1.getData("Sheet2", 7, 3);
		sp.addConvenience(convenience_type,value, per_pax );
		System.out.println(value);
		
		String url1=g1.getData("Sheet2", 10, 1);
		fp.navigateMethod(url1);
		
		String source=g1.getData("Sheet1", 12, 1);
	    String destination=g1.getData("Sheet1", 13, 1);
	     String date=g1.getData("Sheet1",14,1);
	     
	    int adult=Integer.parseInt(g1.getData("Sheet1",15,1));
		int child=Integer.parseInt(g1.getData("Sheet1",16,1));
		int infant =Integer.parseInt(g1.getData("Sheet1",17,1));
		 int count=(adult+child+infant);
		 
		int value1=Integer.parseInt(value);
		System.out.println(value1);
		 fp.onewaySearh(source, destination, date, adult,  child, infant);
		 
		String  price = srp.flightDetails();
		g1.setData("Sheet2", 2,5, price);
		
		String actual_convenience= srp.guest_Convenience();
		g1.setData("Sheet2", 2,6, actual_convenience);
		
		int price1=Integer.parseInt(price);
		
		if(convenience_type.contains("percentage"))
		{
			expected_convenience =String.valueOf(((price1*value1)/100));
			g1.setData("Sheet2", 2,7, expected_convenience);
		}
		else if(per_pax.equalsIgnoreCase("yes"))
		{
			expected_convenience = String.valueOf((value1*count));
			g1.setData("Sheet2", 2,7, expected_convenience);
		}
		else
		{
			expected_convenience = String.valueOf(value1);		
			g1.setData("Sheet2", 2,7, expected_convenience);
		}
		
	}
	
	@Test(enabled = true, priority=1)
	public void rigistereduserconvenienceFees() throws InterruptedException, AWTException, IOException, NumberFormatException
	{
		 String expected_convenience;
			Flightpage fp= new Flightpage(driver);
			Supervisionpage sp= new Supervisionpage(driver);
			SearchResultPage srp=new SearchResultPage(driver);
			TravellersPage tp= new TravellersPage(driver);
			
			
			String url=g1.getData("Sheet2", 2, 1);
			String un=g1.getData("Sheet2", 3, 1);
			String pass=g1.getData("Sheet2", 4, 1);
			 
			fp.navigateMethod(url);
			
			sp.adminLogin(un, pass);
			
			String convenience_type=g1.getData("Sheet2", 7, 1);
			String value=g1.getData("Sheet2",7, 2);
			String per_pax=g1.getData("Sheet2", 7, 3);
			sp.addConvenience(convenience_type,value, per_pax );
			System.out.println(value);
			
			String url1=g1.getData("Sheet2", 10, 1);
			fp.navigateMethod(url1);
			
			loginMethod();
			
			String source=g1.getData("Sheet1", 12, 1);
		    String destination=g1.getData("Sheet1", 13, 1);
		     String date=g1.getData("Sheet1",14,1);
		     
		    int adult=Integer.parseInt(g1.getData("Sheet1",15,1));
			int child=Integer.parseInt(g1.getData("Sheet1",16,1));
			int infant =Integer.parseInt(g1.getData("Sheet1",17,1));
			 int count=(adult+child+infant);
			 
			int value1=Integer.parseInt(value);
			System.out.println(value1);
			 fp.onewaySearh(source, destination, date, adult,  child, infant);
			 
			String  price = srp.flightDetails();
			g1.setData("Sheet2", 2,5, price);
			
			String actual_convenience= tp.registered_Convenience();
			g1.setData("Sheet2", 2,6, actual_convenience);
			
			int price1=Integer.parseInt(price);
			
			if(convenience_type.contains("percentage"))
			{
				expected_convenience =String.valueOf(((price1*value1)/100));
				g1.setData("Sheet2", 2,7, expected_convenience);
			}
			else if(per_pax.equalsIgnoreCase("yes"))
			{
				expected_convenience = String.valueOf((value1*count));
				g1.setData("Sheet2", 2,7, expected_convenience);
			}
			else
			{
				expected_convenience = String.valueOf(value1);		
				g1.setData("Sheet2", 2,7, expected_convenience);
			}
		
	}
	

}
