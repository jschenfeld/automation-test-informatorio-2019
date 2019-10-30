package io.github.jschenfeld.automation.appium.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

	public ApplicationProperties(String fileName) {
		load(fileName);
	}
	
	private static Properties prop = new Properties();
	
	public static Properties load(String fileName) {
		try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("./" + fileName);){
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return prop; 
	}
	
	public static Properties getProperties() {
		return prop;
	}
}