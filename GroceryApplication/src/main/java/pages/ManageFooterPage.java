package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")
	WebElement editadminusericon;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement enteraddressfield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumberfield;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement adminuserupdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageFooterPage clickOnAdminUserupdateIcon() {
		editadminusericon.click();
		return this;
	}

	public ManageFooterPage enterFooterTextDetails() {
		waitutility.waitUntilElementisClickable(driver, adminuserupdatebutton);
		enteraddressfield.clear();
		String address = fakerutility.generateAddress();
		enteraddressfield.sendKeys(address);
		emailfield.clear();
		String email = fakerutility.generateEmail();
		emailfield.sendKeys(email);
		phonenumberfield.clear();
		String phonenumber = fakerutility.generatePhoneNumber();
		phonenumberfield.sendKeys(phonenumber);
		pageutility.actions(adminuserupdatebutton, driver);
		adminuserupdatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}
}
