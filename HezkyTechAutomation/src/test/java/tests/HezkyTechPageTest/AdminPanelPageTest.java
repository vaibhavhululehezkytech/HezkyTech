package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HezkyTechTestData.AdminPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class AdminPanelPageTest extends TestBase{

	HezkyTechPageBase hezkyTechPageBase;
	AdminPanelTestData adminPanelTestData =  new AdminPanelTestData();
	
	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);		
	}
	
	@Test(description = "Verify user is able to login using valid  login credintials")
	public void verify_valid_login() {
				
		hezkyTechPageBase.adminPanel().fillUpCredintials( adminPanelTestData.username, adminPanelTestData.password);
		hezkyTechPageBase.adminPanel().clickOnInventoryManagementButton();
		hezkyTechPageBase.adminPanel().clickOnGatewayManagementButton();
	}

}
