package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import HezkyTechTestData.CustomerPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class CustomerPanelPageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	CustomerPanelTestData customerPanelTestData = new CustomerPanelTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}

	@Test(description = "Verify user is able to login using valid  login credintials", priority=1)
	public void verify_valid_login() {

		hezkyTechPageBase.customerPanel().fillUpCredintials(customerPanelTestData.username,customerPanelTestData.customerID,
				customerPanelTestData.password);
	}
	@Test(description = "Verify Company Logo is loaded on page",priority=2)
	public void verify_Company_Logo() {

		hezkyTechPageBase.customerPanel().verifyCompnyLogoLoded();
	}
	@Test(description = "Verify user can select location ",priority=3)
	public void verify_selectLocation() {
		hezkyTechPageBase.customerPanel().locationIconButton();
		hezkyTechPageBase.customerPanel().expandLocationButton();
		hezkyTechPageBase.customerPanel().selectLocationButton();
	}
	@Test(description = "Verify user can not add aseet withoudt manadaoty data",priority=4)
	public void verify_Add_Asset_Without_Mandatory_Data() {

		hezkyTechPageBase.customerPanel().assetsButton();
		hezkyTechPageBase.customerPanel().clickAddAssetButton();
		hezkyTechPageBase.customerPanel().clickSelectEnvironmentButton();
		hezkyTechPageBase.customerPanel().clickSubmitAssetButton();
	}
	@Test(description = "Verify user can add asset with manadatory data",priority=5)
	public void verify_Add_Asset_With_Mandatory_Data() {
		
	}
}
