package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.testbase.BrowserInvoke;
import com.atmecs.practo.utils.ExcelFileReader;
import com.atmecs.practo.utils.LogReport;
import com.atmecs.practo.utils.PropertiesFileReader;
import com.atmecs.practo.utils.TestDataProvider;

public class PhpTravels extends BrowserInvoke {

	PropertiesFileReader readprop = new PropertiesFileReader();
	// ExcelFileReader readexcel = new ExcelFileReader(FilePath.TESTDATA_FILE);
	// LogReport log =new LogReport();
	// Logger log = Logger.getLogger(Login.class);
	int adultno = 10, childno = 15, infantno = 20;

	@Test(dataProvider = "login", dataProviderClass = TestDataProvider.class)
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

		driver.close();
	}
}
