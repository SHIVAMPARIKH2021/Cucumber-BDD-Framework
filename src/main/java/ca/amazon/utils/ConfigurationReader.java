package ca.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private Properties prop;
	private FileInputStream file;
	
	/**
	 * Instead of creating a constructor as we use in TDD frameworks, I am creating a method
	 * This method will be helpful in Hooks (@Befor and @After)hooks to launch the browser
	 */
	public Properties initialiseProperties() {
		prop = new Properties();
		try {
			file = new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\amazon\\src\\test\\resources\\configuration\\config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Configurations are not found; Restart the process or Check the program");
		}
		return prop;
	}
}
