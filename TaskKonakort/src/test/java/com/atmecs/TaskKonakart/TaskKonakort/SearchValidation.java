package com.atmecs.TaskKonakart.TaskKonakort;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.TaskKonakart.konakart.pageactions.SelectLocators;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.helpers.SearchProductsHelper;
import com.atmecs.TaskKonakart.konakart_automation.helpers.SortingDateVerify;
import com.atmecs.TaskKonakart.konakart_automation.reports.ExtentReport;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;
import com.atmecs.TaskKonakart.konakart_automation.utils.TestDataProvider;
import com.relevantcodes.extentreports.LogStatus;

public class SearchValidation extends BrowserInvoke {
	LogReport log = new LogReport();
	static final String locatorprop = FilePath.LOCATORS_FILE;
	ExtentReport extrep = new ExtentReport();

	/**
	 * Search validation method searches for "The wheel of time game" ,and check the
	 * product which is displayed and Negative scenario for searching a pendrives
	 * ,and verifying error message occurred
	 */
	@Test(dataProvider = "konakart", dataProviderClass = TestDataProvider.class)
	public void searchValidation(String searchinput, String specificsearch)
			throws IOException, InterruptedException, ParseException {
		extrep.startReport();
		extrep.startTest("searchvalidation");
		SelectLocators selloc = new SelectLocators();

		SearchProductsHelper.searchProducts(searchinput, specificsearch);

		String elem = driver.findElement(selloc.selLocators(locatorprop, "loc.verify.gametitle")).getText();
		if (elem.contains("The Wheel Of Time")) {
			log.info("Games validated");
		}

		// Negative scenario
		SearchProductsHelper.searchProducts("Electronics", "Pendrives");
        Thread.sleep(3000);
		Boolean negscen = driver.findElement(selloc.selLocators(locatorprop, "loc.unavlble")).isDisplayed();

		if (negscen == true) {
			log.info("product unavailability message verified");
		}
		driver.findElement(selloc.selLocators(locatorprop, "loc.homebc")).click();
		Thread.sleep(3000);

		HeroImage heroimage = new HeroImage();
		heroimage.HeroImage();

		extrep.endreport("All details are validated");
	}
}
