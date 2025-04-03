package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HezkyTechTestData.UploadCertificateTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class UploadCertificatePageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	UploadCertificateTestData uploadCertificateTestData = new UploadCertificateTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}
	
	@Test(description = "Verify user is able to login using valid  login credintials", priority=1)
	public void verify_valid_login() {

		hezkyTechPageBase.uploadCertificate().fillUpCredintials(uploadCertificateTestData.username, uploadCertificateTestData.password);
		hezkyTechPageBase.uploadCertificate().clickOnLoginButton();
		hezkyTechPageBase.uploadCertificate().managementButton();
//		hezkyTechPageBase.uploadCertificate().certificateManagementButton();
//		hezkyTechPageBase.uploadCertificate().addCertificateButton();
		
	}
	
	
	
}
