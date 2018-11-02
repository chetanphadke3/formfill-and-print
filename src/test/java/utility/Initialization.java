package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Initialization {

	private static Properties prop = null;

	static {
		File file = new File("config.properties");
		try {
			FileInputStream input = new FileInputStream(file);
			prop = new Properties();
			prop.load(input);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static WebDriver start(WebDriver driver) {
		
		//Deleting the cookies.
		driver.manage().deleteAllCookies();
		
		//Opening the url from configuration file.
		driver.get(prop.getProperty("url"));
		//Maximizing the window.
		driver.manage().window().maximize();
		return driver;
	}
}
