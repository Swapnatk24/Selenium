package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	public WebDriver driver;

	// select DD with value
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	// select DD with index
	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

//scroll
	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public int random(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

//current date and time
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public void actions(WebElement element, WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		//action.sendKeys(Keys.ARROW_DOWN).perform();

	}

//alert
	public void alerthandling(WebElement element, WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	// Switch to a specific iframe
	public void switchToIframe(WebDriver driver, String iframeId) {
		driver.switchTo().frame(iframeId);
	}

	// Switch back to the default content
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Handle an alert (accept it)
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}


	// Send text to a text input field
	public void sendTextToElement(WebElement element, String text) {
		element.clear();
		
	}

	// Select a value from a dropdown by visible text
	public String selectDropdownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		return select.getFirstSelectedOption().getText();
	}

	// Select a value from a dropdown by value
	public String selectDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		return select.getFirstSelectedOption().getText();
	}

	// Scroll the page to the element
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Get the current page title
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Verify if an element is displayed
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// Verify if an element is enabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}


	// Select a checkbox
	public void selectCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Deselect a checkbox
	public void deselectCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Get a list of all visible elements
	public List<WebElement> getVisibleElements(WebDriver driver, By locator) {
		return driver.findElements(locator);
	}
}
