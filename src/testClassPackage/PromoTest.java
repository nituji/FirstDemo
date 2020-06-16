package testClassPackage;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import genericPackage.Generic;
import pomClassPackage.Flightpage;
import pomClassPackage.SearchResultPage;
import pomClassPackage.Supervisionpage;
import pomClassPackage.promocode;

public class PromoTest extends BaseClass
{
	Generic g1=new Generic();
	
	@Test
	public void promoMethod() throws InterruptedException, IOException, AWTException
	{
		
		
		Flightpage fp= new Flightpage(driver);
		Supervisionpage sp= new Supervisionpage(driver);
		SearchResultPage srp=new SearchResultPage(driver);
		
		
		String url=g1.getData("Sheet2", 2, 1);
		String un=g1.getData("Sheet2", 3, 1);
		String pass=g1.getData("Sheet2", 4, 1);
		 
		fp.navigateMethod(url);
		
		sp.adminLogin(un, pass);
           
		sp.addpromo();
		
		fp.navigateMethod("http://192.168.0.165/123holidays/");
		
		String source=g1.getData("Sheet1", 12, 1);
	    String destination=g1.getData("Sheet1", 13, 1);
	     String date=g1.getData("Sheet1",14,1);
	     
	    int adult=Integer.parseInt(g1.getData("Sheet1",15,1));
		int child=Integer.parseInt(g1.getData("Sheet1",16,1));
		int infant =Integer.parseInt(g1.getData("Sheet1",17,1));
		
		 fp.onewaySearh(source, destination, date, adult,  child, infant);
		
		
		
		srp.flightDetails();
		
		String email=g1.getData("Sheet1",21,1);
		String mobile=g1.getData("Sheet1",22,1);
		
		
		srp.bookAsGuest(email, mobile);
		
		promocode pc=new promocode(driver);
		String promo=g1.getData("Sheet4",1 , 0);
	     String[] s1=pc.addcode(promo);
	     g1.setData("Sheet4",1,1,s1[0]);
	     g1.setData("Sheet4",1,2,s1[1]); 
	}
	

}
