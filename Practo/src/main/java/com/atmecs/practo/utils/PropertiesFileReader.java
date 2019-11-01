package com.atmecs.practo.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	


	
			 File file;
			 FileReader filereader;
		     Properties properties;

			public  Properties loadProperty(String path) throws IOException {
				properties = new Properties();
				file = new File(path);
				filereader = new FileReader(file);
				properties.load(filereader);
				return properties;
			}

			
			public  String getData(String key) throws IOException {
				String data = properties.getProperty(key);
				return data;
			}

	}



