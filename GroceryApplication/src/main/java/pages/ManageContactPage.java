package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;

	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editmanagecontacticon;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumberfield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addressfield;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytimefield;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverychargelimitfield;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageContactPage enterContactDetailsToUpdate() {
		waitutility.waitUntilElementisClickable(driver, editmanagecontacticon);
		editmanagecontacticon.click();

		// Generate and set values for fields
		String phonenumber = fakerutility.generatePhoneNumber();
		phonenumberfield.clear();
		phonenumberfield.sendKeys(phonenumber);

		String email = fakerutility.generateEmail();
		emailfield.clear();
		emailfield.sendKeys(email);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");

		String address = fakerutility.generateAddress();
		addressfield.clear();
		addressfield.sendKeys(address);

		// Update delivery information
		deliverytimefield.clear();
		deliverytimefield.sendKeys("60");

		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys("250");

		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}

}
