package com.atmecs.practo.helpers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.testbase.BrowserInvoke;
import com.atmecs.practo.utils.PropertiesFileReader;

public class SearchHelpersA2 extends BrowserInvoke{
    PropertiesFileReader prop = new PropertiesFileReader();
	
	
	
public void searchHelpers() throws IOException {
		WebElement searchbox=driver.findElement(By.cssSelector(PropertiesFileReader.getData("loc.searchbox")));
		searchbox.click();
		
		searchbox.sendKeys("Pond");
		
		
		
	}
}
