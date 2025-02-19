package testscripts;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "Swapna";
		String password = "admin";
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyUserLoginWithInvalidUsernameAndValidPassword);
	}

	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "admin";
		String password = "admin52";
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		// boolean actualResult=login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyUserLoginWithValidUsernameAndInvalidPassword);
	}

	@Test(dataProvider = "dataprovider")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		// boolean actualResult=login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyUserLoginWithInvalidUsernameAndInvalidPassword);
	}

	@DataProvider(name = "dataprovider")
	public Object[][] dpmethod1() {
		return new Object[][] { { "abc", "123" }, { "def", "456" }, { "ghi", "rain" }, { "xyz", "qwerty" } };
	}

	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.loginUsingExcelData();
		boolean expectedResult = true;
		boolean actualResult = login.isHomePageisLoaded();
		Assert.assertEquals(actualResult, expectedResult, Constants.lp_verifyLoginwithvalidCredentials);

	}

}