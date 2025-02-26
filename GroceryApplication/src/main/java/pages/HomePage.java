package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public HomePage(WebDriver driver) { // cons

		this.driver = driver;
		PageFactory.initElements(driver, this);// initElements=initialise all web elements
	}

	@FindBy(xpath = "//li//p[text()='Sub Category']")
	WebElement subcategory;
	@FindBy(xpath = "//li//p[text()='Manage Contact']")
	WebElement managecontact;
	@FindBy(xpath = "//li//p[text()='Manage Product']")
	WebElement manageproduct;
	@FindBy(xpath = "//li//p[text()='Manage Footer Text']")
	WebElement managefootertext;
	@FindBy(xpath = "//li//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement adminusermenu;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/a")
	WebElement categorymenu;

	public SubCategoryPage clickOnSubCategory() {
		subcategory.click();
		return new SubCategoryPage(driver);

	}

	public ManageContactPage clickOnManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);

	}

	public AdminUser_ManageProductPage clickOnDeleteProduct() {
		manageproduct.click();
		return new AdminUser_ManageProductPage(driver);
	}

	public ManageFooterPage clickOnAdminUserManageFooterText() {
		managefootertext.click();
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);

	}

	public AdminUserPage clickOnAdminUserMenu() {
		pageutility.clickJavaScriptExecutor(adminusermenu, driver);
		return new AdminUserPage(driver);

	}

	public CategoryPage clickOnCategoryMenu() {
		categorymenu.click();
		return new CategoryPage(driver);

	}

}
