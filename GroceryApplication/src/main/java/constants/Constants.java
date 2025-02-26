package constants;

public class Constants {

	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ ("\\src\\main\\resources\\config.properties");

	public static final String lp_verifyLoginwithvalidCredentials = "login failed for valid credentials";
	public static final String lp_verifyUserLoginWithInvalidUsernameAndValidPassword = "Alert message is not as expected";
	public static final String lp_verifyUserLoginWithValidUsernameAndInvalidPassword = "Alert message is not as expected";
	public static final String lp_verifyUserLoginWithInvalidUsernameAndInvalidPassword = "Alert message is not as expected";

	public static final String TEST_DATA_FILE = System.getProperty("user.dir")
			+ ("\\src\\test\\resources\\TestData\\TestData.xlsx");

	public static final String sc_verifyAddNewSubcategorywithValidDetails = "Subcategory not added successfully";
	public static final String sc_verifySubCategoryIsDeleted = "Subcategory  not deleted successfully";

	public static final String mp_verifyAdminUser_ManageProductIsDeleted = "Manage Product not deleted successfully";

	public static final String us_verifyAdminUserCanChangeTheStatus = "User Status  not changed successfully";
	public static final String us_verifyAdminUserCanAddNewUsers = "User not created successfully";
	public static final String us_verifyAdminUserCanDeleteUsers = "User not deleted successfully";

	public static final String TEST_DATA_IMAGE = System.getProperty("user.dir")
			+ ("\\src\\test\\resources\\Images\\Ice-cream.jpeg");

	public static final String mn_verifyAdminUserCanAddNews = "News  not added successfully";
	public static final String mn_verifyAdminUserCanManageAndEditNews = "News not updated successfully";
	public static final String mn_verifyAdminUserCanDeleteNews = "News not deleted successfully";

	public static final String mc_verifyUserIsAbleToEditContactDetails = "Contact details were not updated successfully";

	public static final String mf_verifyUserCanUpdateAdminFooterDetails = "Footer Text  not updated successfully";

	public static final String ct_verifyUserCanChangeStatus = "Category Status  not changed successfully";
	public static final String ct_verifyUserCanDeleteCategory = "Category Status  not deleted successfully";
}
