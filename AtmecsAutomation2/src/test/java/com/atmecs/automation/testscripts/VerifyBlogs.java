package com.atmecs.automation.testscripts;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.automations.constants.FilePath;
import com.atmecs.automations.helperpage.ValidateBlogDate;
import com.atmecs.automations.pageactions.PageActions;
import com.atmecs.automations.reports.ExtentReport;
import com.atmecs.automations.reports.LogReport;
import com.atmecs.automations.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyBlogs extends Suites {
	LogReport log = new LogReport();
	
	
@Test
public  void verifyBlogDetails() throws IOException, ParseException, InterruptedException {
	  
	  PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE); 
	  
//    PageActions.click(driver,PropertiesFileReader.getData("loc.homepage.insights"));
//    PageActions.click(driver,PropertiesFileReader.getData("loc.blogs.bloglink"));
//	  ValidateBlogDate.blogSearch(driver);
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.fl.search-box.date-box.gtm-onwardCalendar")));

      driver.findElement(By.cssSelector("div.fl.search-box.date-box.gtm-onwardCalendar")).click();
      WebTables table =new WebTables();
      table.webtablecolrowno();
      table.webtablecellddata(7, 2);
      driver.findElement(By.cssSelector("div#rb-calendar_onward_cal td.next")).click();
      
      }  

@AfterTest
public void driverClose() {
	
 driver.quit();
 
}



}
