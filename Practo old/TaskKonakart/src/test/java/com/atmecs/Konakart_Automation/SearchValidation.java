package com.atmecs.Konakart_Automation;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.atmecs.konakart_automation.helpers.SearchProductsHelper;
import com.atmecs.konakart_automation.helpers.SortingDateVerify;
import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;


public class SearchValidation extends BrowserInvoke{
	LogReport log = new LogReport();
	ExtentReport extrep=new ExtentReport();


	@BeforeTest
	public void startReports() {
		startReport();
	}

	@Test
	public void searchValidation() throws IOException, InterruptedException, ParseException {
		extrep.extentreportStart("searchvalidation");
//
//		extrep.printMessage("started extent Report");
//		SearchProductsHelper.searchProducts("Games", "The Wheel Of Time");
//		String elem=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.games"))).getText();
//		if(elem.contains("The Wheel Of Time")) {
//			log.info("Games validated");
//		}
//		//Negative scenario
//		SearchProductsHelper.searchProducts("Electronics", "Pendrives");
//
//		Boolean negscen=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.unavlble"))).isDisplayed();
//
//		if(negscen==true) {
//			log.info("product unavailability message verified");
//		}
//
//		HeroImage  heroimage = new HeroImage();
//		heroimage.sortingVerification();
//
//
//		extrep.logMessage("Search validation ,Sorting of customer reviews completed");
		
		  driver.findElement(By.cssSelector("div.fl.search-box.date-box.gtm-onwardCalendar")).click();
	      WebTables table =new WebTables();
	      table.webtablecolrowno();
	      
	      WebDriverWait wait = new WebDriverWait(driver,30);
	     
	               wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#rb-calendar_onward_cal td.next")));

	      driver.findElement(By.cssSelector("div#rb-calendar_onward_cal td.next")).click();
	      table.webtablecelldata(4,2);
	      driver.close();
	}	
}
