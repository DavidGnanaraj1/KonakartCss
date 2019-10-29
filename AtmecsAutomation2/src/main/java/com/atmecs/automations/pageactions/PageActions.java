package com.atmecs.automations.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {

	public static void click(WebDriver driver, String locator) {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.findElement(By.xpath(locator)).click();
	}

	public static void dropdown(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static void sendKeys(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	
	
	
}
