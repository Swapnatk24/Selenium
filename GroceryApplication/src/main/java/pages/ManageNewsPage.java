package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/section/div[1]/a[1]")
	WebElement newbutton;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[2]/a[1]")
	WebElement editIcon;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTF;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatebutton;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteIcon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageNewsPage clickonNewManageNewsButton() {
		waitutility.waitUntilElementisClickable(driver, newbutton);
		newbutton.click();
		newsTF.sendKeys("Unlock 25% Off Your First Order – Shop Now!");
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		//savebutton.click();
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		return this;
	}

	public ManageNewsPage clickOnManageNewsEditIcon() {

		waitutility.waitUntilElementisClickable(driver, editIcon);
		editIcon.click();
		return this;
	}

	public ManageNewsPage enterNewstoUpdate() {

		newsTF.clear();
		newsTF.sendKeys("Welcome! Your First Purchase Comes with a 25% Discount!");
		waitutility.waitUntilElementisClickable(driver, updatebutton);
		// pageutility.actions(updatebutton, driver);
		updatebutton.click();
		return this;
	}

	public ManageNewsPage clickOnManageNewsDeleteIcon() throws InterruptedException {

		//waitutility.waitUntilElementisClickable(driver, deleteIcon);
		//pageutility.clickJavaScriptExecutor(deleteIcon, driver);
		//deleteIcon.click();
		pageutility.actions(deleteIcon, driver);
		waitutility.waitUntilElementisClickable(driver, deleteIcon);
		pageutility.clickJavaScriptExecutor(deleteIcon, driver);
		Thread.sleep(5000);
		pageutility.alerthandling(deleteIcon, driver);
		return this;
		
	}
	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}
}
