package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.testbase.BrowserInvoke;
import com.atmecs.practo.utils.PropertiesFileReader;


public class Click extends BrowserInvoke {
	PropertiesFileReader prop = new PropertiesFileReader();

	public void clickElements(String keys) throws IOException {
		
		driver.findElement(By.xpath(prop.getData(keys))).click();
	}

	public void enterValues(String keys,String valuestoenter) throws IOException {
		
		 WebElement elements1 = driver.findElement(By.xpath(prop.getData(keys)));
		elements1.sendKeys(valuestoenter);
	}

}

