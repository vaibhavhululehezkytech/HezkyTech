
package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import HezkyTechTestData.CustomerPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class LoginPageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	CustomerPanelTestData customerPanelTestData = new CustomerPanelTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}
	
	@Test(description = "Verify Company logo is clearly visible on landing page", priority=1)
	public void LP_001_verifyCompanyLogoVisible() {
		hezkyTechPageBase.customerPanel().verifyCompnyLogoLodedOnLandingPage();
	}

	@Test(description = "Verify Page scroll is present on page when needed", priority=2)
	public void LP_002_verifyPageScrollPresence() {
		hezkyTechPageBase.customerPanel().verifyPageScrollPresence();
	    
	}

	@Test(description = "Verify Mouse cursor is displaying at Email textbox by default",enabled=false, priority=3)
	public void LP_003_verifyMouseCursorAtEmailTextbox() {
	    
	}

	@Test(description = "Verify that on mouse hover cursor icon gets changed or not if the object is a link.",enabled=false, priority=4)
	public void LP_004_verifyCursorChangeOnHover() {
	    
	}

	@Test(description = "Verify that the icon name/Tooltips showing or not when hovering the mouse on the object.",enabled=false, priority=5)
	public void LP_005_verifyTooltipOnHover() {
	    
	}

	@Test(description = "Verify mouse cursor is showing or not when user click on Text on page",enabled=false, priority=6)
	public void LP_006_verifyMouseCursorOnTextClick() {
	    
	}

	@Test(description = "Verify all links are clickable on the page", priority=7)
	public void LP_007_verifyAllLinksClickable() {
		hezkyTechPageBase.customerPanel().checkBrokenLinks();
	    
	}

	@Test(description = "Verify user can navigate back easily after clicking the links like about us, terms and conditions, privacy and policy.", priority=8)
	public void LP_008_verifyNavigationBackFromLinks() {
		hezkyTechPageBase.customerPanel().navigateBackFromVariousLinks();
	}

	@Test(description = "Verify forgot password functionality", priority=9)
	public void LP_009_verifyForgotPasswordFunctionality() {
	    
	}

	@Test(description = "Verify user can navigate back to login page from forgot password popup", priority=10)
	public void LP_010_verifyNavigationBackFromForgotPassword() {
	    
	}

	@Test(description = "Verify when user enter incorrect Email in forgot password popup error message should be displayed", priority=11)
	public void LP_011_verifyErrorMessageForInvalidEmail() {
	    
	}

	@Test(description = "Verify OTP is sent when user enter valid email in email textbox of Forgot password pop-up", priority=12)
	public void LP_012_verifyOTPSentForValidEmail() {
	    
	}

	@Test(description = "Verify update password page is showing after OTP sent to valid email", priority=13)
	public void LP_013_verifyUpdatePasswordPageAfterOTP() {
	    
	}

	@Test(description = "Verify user can not update password using wrong OTP and error message is showing", priority=14)
	public void LP_014_verifyErrorForWrongOTP() {
	    
	}

	@Test(description = "Verify resend OTP button functionality", priority=15)
	public void LP_015_verifyResendOTPFunctionality() {
	    
	}

	@Test(description = "Successful login with valid username, password, and Customer ID", priority=16)
	public void LP_016_verifySuccessfulLogin() {
	    
	}

	@Test(description = "Verify user gets Authentication via OTP Sent to Email after inserting valid credentials", priority=17)
	public void LP_017_verifyOTPSentAfterValidLogin() {
	    
	}

	@Test(description = "Verify authorization page is open after user insert all valid credentials", priority=18)
	public void LP_018_verifyAuthorizationPageAfterLogin() {
	    
	}

	@Test(description = "Verify user is logged in successfully after valid OTP", priority=19)
	public void LP_019_verifySuccessfulLoginAfterOTP() {
	    
	}

	@Test(description = "Verify user can't log-in using after invalid OTP", priority=20)
	public void LP_020_verifyLoginFailureWithInvalidOTP() {
	    
	}

	@Test(description = "Verify user can not log in using invalid username and password combination", priority=21)
	public void LP_021_verifyLoginFailureWithInvalidCredentials() {
	    
	}

	@Test(description = "Verify Login failure with incorrect Customer ID", priority=22)
	public void LP_022_verifyLoginFailureWithIncorrectCustomerID() {
	    
	}

	@Test(description = "Verify Login failure with missing Customer ID", priority=23)
	public void LP_023_verifyLoginFailureWithMissingCustomerID() {
	    
	}

	@Test(description = "Verify Account lockout after 05 failed login attempts", priority=24)
	public void LP_024_verifyAccountLockoutAfterFailedAttempts() {
	    
	}

	@Test(description = "Verify error message for after 05 failed login attempts", priority=25)
	public void LP_025_verifyErrorMessageAfterFailedAttempts() {
	    
	}

	@Test(description = "Verify Successful login after entering correct Customer ID on retry", priority=26)
	public void LP_026_verifySuccessfulLoginAfterRetry() {
	    
	}

	@Test(description = "Verify Error message for missing fields", priority=27)
	public void LP_027_verifyErrorMessageForMissingFields() {
	    
	}

	@Test(description = "Verify Ensure customer-specific data is only accessible after successful login", priority=28)
	public void LP_028_verifyDataAccessAfterLogin() {
	    
	}
}