package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement statusbutton;//active or inactive
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[4]/a[2]")
	WebElement deleteicon;
	
	public CategoryPage clickOnActiveStatusIcon() {
		waitutility.waitUntilElementisClickable(driver, statusbutton);
		statusbutton.click();
		return this;
	}
	public CategoryPage clickOndeleteCategoryIcon() throws InterruptedException {
		pageutility.actions(deleteicon, driver);
		waitutility.waitUntilElementisClickable(driver, deleteicon);
		pageutility.clickJavaScriptExecutor(deleteicon, driver);
		Thread.sleep(5000);
		pageutility.alerthandling(deleteicon, driver);
		return this;
	}
	
	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}
}
