package com.atmecs.practo.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.utils.LogReport;
import com.atmecs.practo.utils.PropertiesFileReader;


public class BrowserInvoke {
	    public  WebDriver driver;
@SuppressWarnings("deprecation")
@Parameters("browser")
	    @BeforeTest
public  void browserInvoke(String browser) throws IOException {
		
	PropertiesFileReader prop = new PropertiesFileReader();
		prop.loadProperty(FilePath.CONFIG_FILE);
	//	String browser = PropertiesFileReader.getData("browser");
	    LogReport log = new LogReport();
		String url =prop.getData("url");
		System.out.println(browser);
		
		switch (browser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser opens");
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_FILE);
			driver = new FirefoxDriver();
		    log.info("Firefox browser opens");
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", FilePath.IE_FILE);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
			driver = new InternetExplorerDriver(capabilities);
		    log.info("IE browser opens");
			break;
		}
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
}