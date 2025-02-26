package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	CategoryPage categoryPage;

	@Test
	public void verifyUserCanChangeStatus() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		categoryPage = home.clickOnCategoryMenu().clickOnActiveStatusIcon();
		boolean isAlertPresent = categoryPage.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.ct_verifyUserCanChangeStatus);
	}

	@Test
	public void verifyUserCanDeleteCategory() throws IOException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		categoryPage = home.clickOnCategoryMenu().clickOndeleteCategoryIcon();
		boolean isAlertPresent = categoryPage.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.ct_verifyUserCanDeleteCategory);
	}
}
