package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class BaseClass {
	Properties prop;
	FileInputStream fs;

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(@Optional("chrome") String browser) throws Exception { // Initialize browser here
																							// based on the "browser"
																							// parameter
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Initializing Chrome browser...");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {

			System.out.println("Initializing Edge browser...");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.out.println("Initializing Firefox browser...");
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser");
		}

		// Get the URL from the properties file and navigate to it
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitutility.implicitWait(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.captureFailureScreenShot(driver, itestresult.getName());
			
		}
		// driver.quit();
	}
}
