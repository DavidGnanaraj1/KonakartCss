package com.atmecs.TaskKonakart.konakart.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;

import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;


public class SelectLocators extends BrowserInvoke {

	/**
	 * selLocators method used to select different type of locators from locators.properties file
	 *  where they are represented the locator type
	 * @throws InterruptedException 
	 */
	public By selLocators(String path,String locators) throws IOException, InterruptedException  {
				String []locatorarr;
				String locate=PropertiesFileReader.getData(FilePath.LOCATORS_FILE, locators);
				locatorarr=locate.split("\\s");
			    By loc = null ;
			    String locatetype="CSS";
			   
				 switch (locatetype) {
				 
			        case "XPATH": 
			        	
			             loc=By.xpath(locatorarr[1]);
			             return loc;
			            
			        case "CSS":
			        	Thread.sleep(3000);
			            loc=By.cssSelector(locate);
			            return loc;
			            
			        case "ID": 
			             loc=By.id(locatorarr[1]);
			             return loc;
			          
			        case "NAME": 
			            loc=By.name(locatorarr[1]);
			            return loc;
			        case "TAGNAME": 
			             loc=By.id(locatorarr[1]);
			             return loc;
			          
			        case "LINKTEXT": 
			            loc=By.linkText(locatorarr[1]);
			            return loc;
			           
			        case "PARTIALLINKTEXT": 
			            loc=By.partialLinkText(locatorarr[1]);
			            return loc;
	}
				return loc;
				
}
	
}