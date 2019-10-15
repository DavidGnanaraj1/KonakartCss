package com.atmecs.TaskKonakart.konakart_automation.helpers;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.TaskKonakart.konakart.pageactions.PageActions;
import com.atmecs.TaskKonakart.konakart.pageactions.SelectLocators;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.ExcelReader;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;
import com.atmecs.TaskKonakart.konakart_automation.utils.TestDataProvider;

public class SearchProductsHelper extends BrowserInvoke{

LogReport log =new LogReport();
static final String locatorprop=FilePath.LOCATORS_FILE;

	@Test
	public static  void searchProducts(String searchinput,String specificsearch) throws IOException, InterruptedException {
		SelectLocators selloc = new SelectLocators();
	
		PageActions pageactions = new PageActions();
		
		pageactions.dropdown(locatorprop,"loc.search.dropdown", searchinput);
		
		
		WebElement searchbox=driver.findElement(selloc.selLocators(locatorprop,"loc.search.searchbox"));
		searchbox.sendKeys(specificsearch);

	    Thread.sleep(3000);
		
		pageactions.click(locatorprop,"loc.search.btn");
		 	
	}
}



