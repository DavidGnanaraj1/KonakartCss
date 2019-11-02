package com.atmecs.Konakart_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.konakart_automation.testbase.BrowserInvoke;



public class WebTables extends  BrowserInvoke {

	public void webtablecelldata(int rowno,int cellno) {
		
		//WebElement baseTable = driver.findElement(By.);
	//	WebElement tableRow = baseTable.findElement(By.);
    //    String rowtext = tableRow.getText();
	
		    String textfirst  = "div#rb-calendar_return_cal table tbody tr:nth-child(";
		    String textsec    = Integer.toString(rowno);
		    String textthird  = ") td:nth-child(";
	        String textfourth = Integer.toString(cellno)+")";
	        		
		    String textfull   = textfirst+textsec+textthird+textfourth;
		    WebElement celldata = driver.findElement(By.cssSelector(textfull));
		    String celltext   = celldata.getText();
		    System.out.println(celltext);
	}
	
	public void webtablecolrowno() {
		List  col = driver.findElements(By.cssSelector("div#rb-calendar_return_cal table tbody tr:nth-of-type(3) td"));
        System.out.println("No of cols are : " +col.size()); 

        List  rows = driver.findElements(By.cssSelector("div#rb-calendar_return_cal table tbody tr")); 
        System.out.println("No of rows are : " + rows.size());
		
		}
	
	public void webtablerowvalues(int rowno) {
		String textfirst  = "div#rb-calendar_onward_cal table tbody tr:nth-of-type(";
	    String textsec    = Integer.toString(rowno);
	    String textthird  = ") td:nth-of-type(";
       
//		for(int listindex;listindex<=size;listindex++) {
//			 String textfourth = Integer.toString(listindex)+")";
//		List<WebElement>list = driver.findElement(By.cssSelector("div#rb-calendar_onward_cal table tbody tr:nth-of-type(6) td:nth-of-type(1)"));
//		driver.findElement(By.cssSelector("div#rb-calendar_onward_cal table tbody tr:nth-of-type(6) td:nth-of-type(1)"));
//		
//		
//	}
}
	
}

