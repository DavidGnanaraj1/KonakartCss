package com.atmecs.automations.pageactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageActionsScrollDown {

	public void pageScrollDown(WebDriver driver)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,1200)");
	}
	
	public  void pageScrollDownTillElementVisible(WebDriver driver) 
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,-1700)");
	}

	public  void scrollToBottom(WebDriver driver)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	public  void pageScrollUp(WebDriver driver) 
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,-1700)");
	}

}


