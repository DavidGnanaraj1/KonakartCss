package com.atmecs.automations.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.atmecs.automations.constants.FilePath;
import com.atmecs.automations.reports.ExtentReport;
import com.atmecs.automations.reports.LogReport;
import com.atmecs.automations.utils.PropertiesFileReader;


public class BrowserInvoke  {
	public static WebDriver driver;
    	LogReport log = new LogReport();
		Properties properties;
		
		String browser;
		
		

@Parameters({"browser"})
@BeforeTest
public void initializeBrowser(@Optional("IamOptional") String browser) throws Exception {

		    PropertiesFileReader.loadProperty(FilePath.CONFIG_FILE);

			String url=PropertiesFileReader.getData("url");
//			browser = properties.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",FilePath.CHROME_FILE);
				driver = new ChromeDriver();
				log.info("Chrome browser opens");
			} 
			else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",FilePath.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox browser opens");
			}
			else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",FilePath.IE_FILE);
				driver = new InternetExplorerDriver();
				log.info("IE browser opens");
			}

			
			driver.get(url);
			log.info("Application is open");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
	}


