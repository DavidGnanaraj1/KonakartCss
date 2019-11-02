package com.atmecs.automations.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.practo.utils.LogReport;

public class PageActions {
	LogReport log = new LogReport();
	public  void click(WebDriver driver, String locator) {
		
		
		driver.findElement(By.xpath(locator)).click();
	}

	public  void dropdown(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public  void sendKeys(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
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
