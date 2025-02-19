package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;

public class ManageFooterTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageFooterPage admin_managefooter;

	@Test
	public void verifyUserCanUpdateAdminFooterDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		admin_managefooter = home.clickOnAdminUserManageFooterText().clickOnAdminUserupdateIcon()
				.enterFooterTextDetails();
		boolean isalertpresent = admin_managefooter.isAlertDisplayed();
		Assert.assertTrue(isalertpresent, Constants.mf_verifyUserCanUpdateAdminFooterDetails);
	}
}
