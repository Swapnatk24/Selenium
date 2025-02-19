package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	FileUploadUtility fileuploadutility = new FileUploadUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newsubcategorybutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefilebutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=2446&page_ad=1']")
	WebElement editsubcategory;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[2]/td[5]/a[2]")
	WebElement deleteicon;

	public SubCategoryPage clickOnNewSubCategoryButton() {
		newsubcategorybutton.click();
		return this;
	}

	public SubCategoryPage clickOnCategoryDropDown() {
		// Using the utility to select "Icecream" from the dropdown
		pageutility.selectDropdownByVisibleText(categorydropdown, "Icecream");
		return this;
	}

	public SubCategoryPage enterSubCategoryField() {
		String subcategoryname = "Butterscotch" + pageutility.generateCurrentDateAndTime();
		subcategoryfield.sendKeys(subcategoryname);
		return this;
	}

	public SubCategoryPage clickOnChooseFileButton() {
		// choosefilebutton.click();
		pageutility.clickJavaScriptExecutor(choosefilebutton, driver);
		fileuploadutility.fileuploadusingSendkeys(choosefilebutton, Constants.TEST_DATA_IMAGE);
		return this;
	}

	public SubCategoryPage clickOnSaveButton() {
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		//savebutton.click();
		return this;
	}

	public SubCategoryPage EditSubCategory() {

		editsubcategory.click();
		return this;
	}

	public SubCategoryPage deleteSubCategory() throws InterruptedException {
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