package testscripts;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.SubCategoryPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageContactTest extends BaseClass {

	ManageContactPage manageContact; // Page Object class for ManageContactPage
	LoginPage login;
	HomePage home;
	SubCategoryPage sc;

	@Test
	public void verifyUserIsAbleToEditContactDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageContact = home.clickOnManageContact();
		manageContact.enterContactDetailsToUpdate();

		boolean isalertPresent = manageContact.isAlertDisplayed();
		Assert.assertTrue(isalertPresent, Constants.mc_verifyUserIsAbleToEditContactDetails);
	}

}
