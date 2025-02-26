package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static int implicitWaitDuration = 5;
	public static int explicitWaitDuration = 10;

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Wait for an element to be visible
	public void waitUntilElementisVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for an element to be clickable
	public void waitUntilElementisClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for all elements are visible
	public void waitUntilAllElementareVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	// Wait for all elements are selected
	public void waitUntilElementisSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
	}
}
