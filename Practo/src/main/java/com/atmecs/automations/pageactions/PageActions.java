package com.atmecs.automations.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.utils.LogReport;
import com.atmecs.practo.utils.PropertiesFileReader;

public class PageActions {
	LogReport log = new LogReport();
	PropertiesFileReader prop = new PropertiesFileReader();
    
	public  void click(WebDriver driver, String locator) throws IOException {
		prop.loadProperty(FilePath.LOCATORS_FILE);
		
		driver.findElement(By.xpath(prop.getData(locator))).click();
	}

	public  void dropdown(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public  void sendKeys(WebDriver driver, String locator, String value) throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getData(locator)));
		element.sendKeys(value);
	}


	public void isDisplayed(WebDriver driver,String path) {
	boolean isDisplayed=driver.findElement(By.xpath(path)).isDisplayed();
	
	if(isDisplayed==true)
	{
		log.info("Element is displayed");
	}
	else
	{
		log.info("Element not found");
	}
	}
	
	
}
