package com.atmecs.automations.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActionsGettingText {
   
	 String text;
	
    public String getAttribute(WebDriver driver,String locator,String value)
    {
		WebElement element = driver.findElement(By.xpath(locator));
		 text = element.getAttribute("href");
		return text;
	}
	public  String getTitle(WebDriver driver,String locator) 
	{
		WebElement element = driver.findElement(By.xpath(locator));
		text=driver.getTitle();
		return text;	
	}
	public  String getImageSrc(WebDriver driver,String locator,String value)
	{
	WebElement element = driver.findElement(By.xpath(locator));
	text = element.getAttribute("src");
	return text;
	}
	
	public  String  getAttributeTitle(WebDriver driver,String locator) {
		WebElement element =driver.findElement(By.xpath(locator));
		text =element.getAttribute("title");
		return text;
	}
	public String getText(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		text = element.getText();
		return text;
	}
}

