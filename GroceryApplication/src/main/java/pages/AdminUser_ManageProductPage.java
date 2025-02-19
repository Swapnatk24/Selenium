package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUser_ManageProductPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	FakerUtility fakerutility = new FakerUtility();

	public AdminUser_ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " /html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[9]/a[2]/i")
	WebElement au_ManageProductDeleteIcon;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public AdminUser_ManageProductPage clickOnManageProductIcon() {
		au_ManageProductDeleteIcon.click();
		return this;
	}

	public AdminUser_ManageProductPage deleteManageProduct() throws InterruptedException {
		pageutility.actions(au_ManageProductDeleteIcon, driver);
		waitutility.waitUntilElementisClickable(driver, au_ManageProductDeleteIcon);
		pageutility.clickJavaScriptExecutor(au_ManageProductDeleteIcon, driver);
		Thread.sleep(5000);
		pageutility.alerthandling(au_ManageProductDeleteIcon, driver);
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}

}
