package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[5]/a[1]")
	WebElement lockicon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameTF;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTF;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypeTF;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement savebutton;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[5]/a[3]")
	WebElement deleteicon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public AdminUserPage clickOnStatusIcon() {
		lockicon.click();
		return this;
	}

	public AdminUserPage clickOnNewButton() {
		pageutility.clickJavaScriptExecutor(newbutton, driver);
		return this;
	}

	public AdminUserPage enterAdminUserInformations() {
		String username = fakerutility.generateFullName();
		usernameTF.sendKeys(username);
		String password = fakerutility.generatePassword();
		passwordTF.sendKeys(password);
		pageutility.selectDropdownByVisibleText(usertypeTF, "Admin");
		savebutton.click();
		return this;
	}

	public AdminUserPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		return this;
	}

	public AdminUserPage deleteAdminUsers() throws InterruptedException {
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
