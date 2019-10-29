package com.atmecs.automation.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.atmecs.automations.constants.FilePath;
import com.atmecs.automations.testbase.BrowserInvoke;
import com.atmecs.automations.utils.PropertiesFileReader;

public class Suites extends BrowserInvoke {
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@Test
public  void suitemethod() throws IOException {
		
	    PropertiesFileReader.loadProperty(FilePath.CONFIG_FILE);
		String browser = PropertiesFileReader.getData("browser");

		String browser1[] = browser.split(",");

		XmlSuite suite = new XmlSuite();
		suite.setName("HomePage");
		suite.setParallel("true");
		suite.setThreadCount(3);
		XmlTest xmlTest = new XmlTest(suite);

		for (String element : browser1) {
			xmlTest.setName("Test-1");
			xmlTest.setPreserveOrder("true");
			Map<String, String> map = new HashMap<String, String>();
			map.put("browser",element);
			xmlTest.setParameters(map);
			
			XmlClass xmlClass = new XmlClass(VerifyBlogs.class);
			List<XmlClass> list = new ArrayList<XmlClass>();
			list.add(xmlClass);
			xmlTest.setXmlClasses(list);
		}

		

		TestNG testng = new TestNG();

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		testng.setXmlSuites(suites);
		testng.run();

	}
}