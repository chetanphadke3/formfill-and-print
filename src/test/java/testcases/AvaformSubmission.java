package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.FillAvaform;
import helper.JsExecutor;
import utility.Initialization;

public class AvaformSubmission {

	WebDriver driver = null;
	@BeforeClass
	@Parameters("browser")
	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this
		if (browser.equalsIgnoreCase("firefox")) {

			/* Commenting the code as gecko driver not set */
			System.setProperty("webdriver.gecko.driver", "E:\\Backup\\Data from D\\software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);*/
			driver = new FirefoxDriver();
			driver = Initialization.start(driver);
		}

		else if (browser.equalsIgnoreCase("ie")) {
			// If the browser is InternetExplorer, then do this
			System.setProperty("webdriver.ie.driver",
					"C:\\chetan.phadke\\Backup\\Data from D\\software\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}

		else {
			// If no browser is mentioned, then do this
			System.setProperty("webdriver.chrome.driver",
					"C:\\chetan.phadke\\Backup\\Data from D\\software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver = Initialization.start(driver);

		}

	}

	@Test
	public void avaforSubmission() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Refreshing the page in case webelements are not visible.
		driver.navigate().refresh();

		JsExecutor js = new JsExecutor();
		js.avaformInTest(driver);

		Thread.sleep(5000);
		

		FillAvaform fa = new FillAvaform();
		

		
		// Filling the name.
		fa.fillName(driver);

		// Filling the email.
		fa.fillEmail(driver);

		// Filling the company.
		fa.fillCompany(driver);

		// Filling the company.
		fa.fillPhone(driver);

		// Submitting the avaform
		fa.submitAvaform(driver);

		Thread.sleep(10000);
		
		//To print the submitted data in console.
		js.printData();

		String actualurl = driver.getCurrentUrl();
		String exp2 = "https://avalara-stage.adobemsbasic.com/qa/avaform/generic-thank-you.html";
		
		//To verify that Generic Thank you page is not displayed after form submission.
		if (!actualurl.equals(exp2)) {
			System.out.println("Working fine totally");
		} else {
			System.out.println("Avaform got submitted into Eloqua");
		}

	}

	@AfterClass
	@Parameters("browser")
	public void afterTest(String browser) {
		
		//Printing the Browser and Closing the driver.
		System.out.println("Test case completed successfully!" + "\n Closing the browser-" + browser);
		driver.quit();

	}

}
