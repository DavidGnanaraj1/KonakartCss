package com.atmecs.practo.testscripts;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.atmecs.automations.pageactions.PageActions;
import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.testbase.BrowserInvoke;
import com.atmecs.practo.utils.ExcelFileReader;
import com.atmecs.practo.utils.LogReport;
import com.atmecs.practo.utils.PropertiesFileReader;
import com.atmecs.practo.utils.TestDataProvider;

public class PhpTravels extends BrowserInvoke {

	PropertiesFileReader prop = new PropertiesFileReader();
	// ExcelFileReader readexcel = new ExcelFileReader(FilePath.TESTDATA_FILE);
	// LogReport log =new LogReport();
	// Logger log = Logger.getLogger(Login.class);
	int adultno = 10, childno = 15, infantno = 20;

	//@Test(dataProvider = "login", dataProviderClass = TestDataProvider.class)
	public void selectNoOfPersons(String username, String password) throws IOException, InterruptedException {

		WebElement adultplusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(1) button:nth-of-type(1)"));
		WebElement adultminusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(1) button:nth-of-type(2)"));
		WebElement childplusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(2) button:nth-of-type(1)"));
		WebElement childminusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(2) button:nth-of-type(2)"));
		WebElement infantplusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(3) button:nth-of-type(1)"));
		WebElement infantminusbtn = driver
				.findElement(By.cssSelector("#flights div.col-4:nth-of-type(3) button:nth-of-type(2)"));

		driver.findElement(By.cssSelector(".text-center.flights")).click();
		// WebElement
		// fromcity=driver.findElement(By.cssSelector(".select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active
		// input"));
		// fromcity.click();
		// fromcity.sendKeys("Pondicherry Airport");
		System.out.println(username);

		WebElement adulttext = driver
				.findElement(By.cssSelector(".row.gap-5 div.col-4:nth-of-type(1) div.form-icon-left div"));
		JavascriptExecutor execute = (JavascriptExecutor) driver;

		for (int i = 0; i < adultno - 1; i++) {
			adultplusbtn.click();
			driver.findElement(By.cssSelector(".row.mb-10")).click();
			// execute.executeScript("alert('ok');");
			// driver.switchTo().alert().accept();
			String sText = execute.executeScript(
					"return document.querySelector(\".row.gap-40.gap-md-20 .col-12.col-md-3.go-right:nth-of-type(2) ul li:nth-of-type(4)\").value;")
					.toString();
			System.out.println(sText);
		}

		for (int i = 0; i < childno; i++) {
			childplusbtn.click();
			driver.findElement(By.cssSelector(".row.mb-10")).click();
		}

		for (int i = 0; i < infantno; i++) {
			infantplusbtn.click();
			driver.findElement(By.cssSelector(".row.mb-10")).click();
		}

		
	}
	//@Test
	public void php() throws IOException {
	   	PageActions pageactions = new PageActions();
	 	PropertiesFileReader prop = new PropertiesFileReader();
	 	prop.loadProperty(FilePath.LOCATORS_FILE);
	   	Alert alrt;
	   	try {
	   	alrt=driver.switchTo().alert();
		alrt.accept();
	   	}catch(NoAlertPresentException e) {
	   		System.out.println("No alert is present");
	   	}
	   
	   	pageactions.click(driver,"loc.fromcity");
		pageactions.sendKeys(driver,"loc.fromcity" ,"Gachibowli, Hyderabad");
		pageactions.click(driver, "loc.tiocity");
		pageactions.sendKeys(driver,"loc.tiocity" ,"Pondicherry");
		pageactions.click(driver,"loc.calendar");
		pageactions.click(driver, "loc.date");
		pageactions.click(driver, "loc.returncale");
		pageactions.click(driver, "loc.retdate");
		//pageactions.click(driver,"loc.searchbtn");
		boolean element = driver.findElement(By.cssSelector(".clearfix.search-wrap button")).isDisplayed();
		System.out.println(element);
		driver.findElement(By.cssSelector(".fl.search-box.date-box.gtm-returnCalendar+button")).click();
		
		driver.findElement(By.cssSelector(".clearfix.search-wrap button")).click();
				
	}
	
	@Test
	public void atmecs() throws IOException {
		PageActions pageactions = new PageActions();
	 	PropertiesFileReader prop = new PropertiesFileReader();
	 	prop.loadProperty(FilePath.LOCATORS_FILE);
	 	//List<WebElement> homelist=driver.findElements(By.xpath("http://www.atmecs.com/"));
	    String[] listsup= new String[5];
		java.util.List<WebElement> homelist =driver.findElements(By.xpath(prop.getData("loc.home")));
		int nos; 
        nos=homelist.size();
	 
        String exptitle="Home | Atmecs, Inc. | Digital Solutions & Product Engineering Services";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, exptitle);
	 	
        for(int i=0;i<=nos;i++) {
	 		String textfirst1=".menu-collapser+ul li:nth-child(";
		 	String textsec1  =Integer.toString(i);
		 	String textthird1 =")";
		 	String fulltext=textfirst1+textsec1+textthird1;
		 	java.util.List<WebElement> homelist1=driver.findElements(By.cssSelector("fulltext"));
		 
		 	  java.util.List <String > values = new ArrayList<>();

		 	
		 	 for (WebElement e : homelist) {
		 	    values.add(e.getText());
         	 	 }
	 	
	 	}
	 	
	 	
	 	}
	 	
	 	
	@AfterSuite
	public void driverClose() {
		driver.close();
	}
}
