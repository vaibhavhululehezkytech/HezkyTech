package tests.authenticationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.actionpages.authentication.LoginPageBase;
import testdata.AuthTestData;
import testdata.SiteListTestData;
import tests.TestBase;

public class AuthenticationPageTest extends TestBase{	
	
	LoginPageBase loginBase;
	
	SiteListTestData siteListTestData =  new SiteListTestData();
	AuthTestData authTestData =new AuthTestData();
	
	@Override
	@BeforeClass
	protected void initPageObject() {
		loginBase = new LoginPageBase(driverManager);		
		
	}
	
	@Test(description = "Verify user is able to login using valid login credintials")
	public void verify_valid_login() {
				
    	loginBase.login().fillUpCredintials(siteListTestData.accessCode, siteListTestData.username, siteListTestData.password);	
		loginBase.siteSelection().selectSite(siteListTestData.siteName);
		loginBase.selectModule().getAdministrator();
		loginBase.selectModule().companyButton();
		
		
	}
	
}
