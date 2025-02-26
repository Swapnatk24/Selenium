package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategoryPage subCategoryPage;

	@Test(groups = "smoke")
	public void verifyAddNewSubcategorywithValidDetails() throws IOException, AWTException, InterruptedException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		subCategoryPage = home.clickOnSubCategory().clickOnNewSubCategoryButton().clickOnCategoryDropDown()
				.enterSubCategoryField().clickOnChooseFileButton().clickOnSaveButton();
		boolean isalertPresent = subCategoryPage.isAlertDisplayed();
		Assert.assertTrue(isalertPresent, Constants.sc_verifyAddNewSubcategorywithValidDetails);
	}

	@Test
	public void verifySubCategoryIsDeleted() throws IOException, AWTException, InterruptedException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		subCategoryPage = home.clickOnSubCategory().deleteSubCategory();
		boolean isalertPresent = subCategoryPage.isAlertDisplayed();
		Assert.assertTrue(isalertPresent, Constants.sc_verifySubCategoryIsDeleted);

	}
}
