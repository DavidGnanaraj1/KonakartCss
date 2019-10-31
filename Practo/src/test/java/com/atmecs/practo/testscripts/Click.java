package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.testbase.BrowserInvoke;
import com.atmecs.practo.utils.PropertiesFileReader;


public class Click extends BrowserInvoke {
	

	public static void clickElements(String keys) throws IOException {
		
		driver.findElement(By.xpath(PropertiesFileReader.getData(keys))).click();
	}

	public static void enterValues(String keys,String valuestoenter) throws IOException {
		
		 WebElement elements1 = driver.findElement(By.xpath(PropertiesFileReader.getData(keys)));
		elements1.sendKeys(valuestoenter);
	}

}

