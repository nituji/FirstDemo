package testClassPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import genericPackage.Generic;
import pomClassPackage.Flightpage;
import pomClassPackage.SearchResultPage;
import pomClassPackage.Supervisionpage;
import pomClassPackage.TravellersPage;

public class MarkupTest extends BaseClass
{
	Generic g1=new Generic();
	
	@Test(priority=1 ,enabled = false)
	public void plusmarkupMethod() throws IOException, InterruptedException
	{
		Supervisionpage superpage=new Supervisionpage(driver);
		
		  superpage.newWindow();
			
			String un=g1.getData("Sheet2", 3, 1);
			String pass=g1.getData("Sheet2", 4, 1);
			superpage.adminLogin(un, pass);
			superpage.settingofmarkup0();
		
			Flightpage fp= new Flightpage(driver);
		String source=g1.getData("Sheet1", 12, 1);
	    String destination=g1.getData("Sheet1", 13, 1);
	     String date=g1.getData("Sheet1",14,1);
	     
	    int adult=Integer.parseInt(g1.getData("Sheet1",15,1));
		int child=Integer.parseInt(g1.getData("Sheet1",16,1));
		int infant =Integer.parseInt(g1.getData("Sheet1",17,1));
		
		 fp.onewaySearh(source, destination, date, adult,  child, infant);
		
		  SearchResultPage sp=new SearchResultPage(driver);
		
		String[] s1=sp.Flightnameandnumber();
		for(int i=1;i<s1.length-1;i++)
		{
			String names=s1[i];
			g1.setData("Sheet3", i, 0, names);
		}
		
		
		
     String[] s2=sp.Flightprice();
		
		for(int i=1;i<s2.length-1;i++)
		{
			String price=s2[i];
			g1.setData("Sheet3", i, 1, price);
		}
		
		
	
		superpage.newWindow();
			
		String markup=g1.getData("Sheet3", 1, 4);
		System.out.println(markup);
		superpage.Markupadding(markup);
		fp.onewaySearh(source, destination, date, adult,  child, infant);
		
		
	     String[] s3=sp.Flightprice();
			
			for(int i=1;i<s3.length-1;i++)
			{
				String price=s3[i];
				g1.setData("Sheet3", i, 2, price);
			}
			
			for(int i=1;i<s3.length-1;i++)
			{
				//double s2 =Double.parseDouble (s1.substring(2));
				int difference=Integer.parseInt(s3[i].substring(2))-Integer.parseInt(s2[i].substring(2));
				String diffamount=Integer.toString(difference);
			
				g1.setData("Sheet3", i, 3, diffamount);
			}
	}
	

	
	
	@Test(priority=2 ,enabled = true)
	public void percentagemarkup() throws InterruptedException, IOException{
		
		Supervisionpage superpage=new Supervisionpage(driver);
		
		superpage.newWindow();
		
		String un=g1.getData("Sheet2", 3, 1);
		String pass=g1.getData("Sheet2", 4, 1);
		superpage.adminLogin(un, pass);
		superpage.settingofmarkup0();
		
		Flightpage fp= new Flightpage(driver);
		
		String source=g1.getData("Sheet1", 12, 1);
	    String destination=g1.getData("Sheet1", 13, 1);
	     String date=g1.getData("Sheet1",14,1);
	     
	    int adult=Integer.parseInt(g1.getData("Sheet1",15,1));
		int child=Integer.parseInt(g1.getData("Sheet1",16,1));
		int infant =Integer.parseInt(g1.getData("Sheet1",17,1));
		
		 fp.onewaySearh(source, destination, date, adult,  child, infant);
		
		
		SearchResultPage sp=new SearchResultPage(driver);
		
		String[] s1=sp.Flightnameandnumber();
		for(int i=1;i<s1.length-1;i++)
		{
			String names=s1[i];
			g1.setData("Sheet5", i, 0, names);
		}
		
		
		
     String[] s2=sp.Flightprice();
		
		for(int i=1;i<s2.length-1;i++)
		{
			String price=s2[i];
			g1.setData("Sheet5", i, 1, price);
		}
	
		
		superpage.newWindow();
		
	
		String markup=g1.getData("Sheet5", 1, 4);
		superpage.settingpecentage(markup);
		fp.onewaySearh(source, destination, date, adult,  child, infant);
		
		
	     String[] s3=sp.Flightprice();
			
			for(int i=1;i<s3.length-1;i++)
			{
				String price=s3[i];
				g1.setData("Sheet5", i, 2, price);
			}
			
			for(int i=1;i<s3.length-1;i++)
			{
				int difference=Integer.parseInt(s3[i].substring(2))-Integer.parseInt(s2[i].substring(2));
				String diffamount=Integer.toString(difference);
			
				g1.setData("Sheet5", i, 3, diffamount);
				
		   }
	}
}
