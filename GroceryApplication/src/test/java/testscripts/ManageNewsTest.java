package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNewsPage manageNewsPage;

	@Test
	public void verifyAdminUserCanAddNews() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageNewsPage = home.clickOnManageNews().clickonNewManageNewsButton().clickOnSaveButton();
		boolean isAlertPresent = manageNewsPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.mn_verifyAdminUserCanAddNews);
	}

	@Test
	public void verifyAdminUserCanManageAndEditNews() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageNewsPage = home.clickOnManageNews().clickOnManageNewsEditIcon().enterNewstoUpdate();
		boolean isAlertPresent = manageNewsPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.mn_verifyAdminUserCanManageAndEditNews);
	}

	@Test
	public void verifyAdminUserCanDeleteNews() throws IOException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageNewsPage = home.clickOnManageNews().clickOnManageNewsDeleteIcon();
		boolean isAlertPresent = manageNewsPage.isAlertDisplayed(); // Verify alert is displayed
		Assert.assertTrue(isAlertPresent, Constants.mn_verifyAdminUserCanDeleteNews);
	}
}
