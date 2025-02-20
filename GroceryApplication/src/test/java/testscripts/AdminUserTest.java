package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminUserPage adminuserPage;

	@Test
	public void verifyAdminUserCanAddNewUsers() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuserPage=home.clickOnAdminUserMenu().clickOnNewButton().enterAdminUserInformations().clickOnSaveButton();
		
		boolean isAlertPresent = adminuserPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.us_verifyAdminUserCanAddNewUsers);
	}

	@Test(priority=1)
	public void verifyAdminUserCanChangeTheStatus() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuserPage=home.clickOnAdminUserMenu().clickOnStatusIcon();
		boolean isAlertPresent = adminuserPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.us_verifyAdminUserCanChangeTheStatus);

	}
	@Test
	public void verifyAdminUserCanDeleteUsers() throws IOException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuserPage=home.clickOnAdminUserMenu().deleteAdminUsers();
		boolean isAlertPresent = adminuserPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.us_verifyAdminUserCanDeleteUsers);

	}
	
}
