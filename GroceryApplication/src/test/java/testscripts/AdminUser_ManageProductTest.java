package testscripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.AdminUser_ManageProductPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class AdminUser_ManageProductTest extends BaseClass {

	// public WebDriver driver;
	LoginPage login;
	HomePage home;
	AdminUser_ManageProductPage adminuserManageProduct;

	@Test
	public void verifyAdminUserCanManageAndDeleteProduct() throws IOException, AWTException, InterruptedException {
		// Initialize page objects
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuserManageProduct=home.clickOnDeleteProduct().deleteManageProduct();	
		boolean isAlertPresent = adminuserManageProduct.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.mp_verifyAdminUser_ManageProductIsDeleted);
	}
}
