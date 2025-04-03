
package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import HezkyTechTestData.CustomerPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class AssetPageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	CustomerPanelTestData customerPanelTestData = new CustomerPanelTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}
	@Test(description = "Verify Asset page is loaded with all correct contents", priority=1)
	public void AS_001_verifyAssetPageLoadedWithCorrectContents() {
	    
	}

	@Test(description = "Verify user click on 'Normal' button it displays normal assets only", priority=2)
	public void AS_002_verifyNormalButtonDisplaysNormalAssets() {
	    
	}

	@Test(description = "Verify user click on 'Alarm' tab it displays assets with alarm only", priority=3)
	public void AS_003_verifyAlarmTabDisplaysAssetsWithAlarm() {
	    
	}

	@Test(description = "Verify user click on 'Inactive' button it displays inactive assets only", priority=4)
	public void AS_004_verifyInactiveButtonDisplaysInactiveAssets() {
	    
	}

	@Test(description = "Verify user click on 'All' button it displays all assets", priority=5)
	public void AS_005_verifyAllButtonDisplaysAllAssets() {
	    
	}

	@Test(description = "Verify the number of assets is displayed along Normal, Alarm, Inactive, and Assets button", priority=6)
	public void AS_006_verifyNumberOfAssetsDisplayed() {
	    
	}

	@Test(description = "Verify when user click on any one of Normal, Alarm, Inactive, and Assets button the selected button remains highlighted", priority=7)
	public void AS_007_verifySelectedButtonRemainsHighlighted() {
	    
	}

	@Test(description = "Verify Add asset button functionality", priority=8)
	public void AS_009_verifyAddAssetButtonFunctionality() {
	    
	}

	@Test(description = "Verify search functionality works dynamically", priority=9)
	public void AS_010_verifySearchFunctionalityWorksDynamically() {
	    
	}

	@Test(description = "Verify Asset table has all respective columns", priority=10)
	public void AS_011_verifyAssetTableHasAllColumns() {
	    
	}

	@Test(description = "Verify All columns show correct data", priority=11)
	public void AS_012_verifyAllColumnsShowCorrectData() {
	    
	}

	@Test(description = "Verify ASSETS column shows Asset name and Expand button", priority=12)
	public void AS_013_verifyAssetsColumnShowsAssetNameAndExpandButton() {
	    
	}

	@Test(description = "Verify click on expand asset button shows READING TYPE, LAST READING, ACTIVE ALARMS, 24 HOURS HIGH/LOW Columns", priority=13)
	public void AS_014_verifyExpandAssetButtonShowsColumns() {
	    
	}

	@Test(description = "Verify '+' button should change to '-' when asset is expanded", priority=14)
	public void AS_015_verifyExpandButtonChangesToMinus() {
	    
	}

	@Test(description = "Verify expanded asset is closed when click on expand button", priority=15)
	public void AS_016_verifyExpandedAssetClosesOnClick() {
	    
	}

	@Test(description = "Verify READING TYPE column shows Icons for TEMPERATURE, HUMIDITY, AND PRESSURE", priority=16)
	public void AS_017_verifyReadingTypeColumnShowsIcons() {
	    
	}

	@Test(description = "Verify LAST READING column shows LAST READINGS for TEMPERATURE, HUMIDITY, AND PRESSURE in respective row", priority=17)
	public void AS_018_verifyLastReadingColumnShowsReadings() {
	    
	}

	@Test(description = "Verify Expandable shows temp, humidity, and pressure reading as per attached sensor", priority=18)
	public void AS_019_verifyExpandableShowsReadingsAsPerSensor() {
	    
	}

	@Test(description = "Verify ACTIVE ALARMS column shows all active alarms for TEMPERATURE, HUMIDITY, AND PRESSURE in respective row in color code for severity", priority=19)
	public void AS_020_verifyActiveAlarmsColumnShowsAlarms() {
	    
	}

	@Test(description = "Verify 24 HOURS HIGH/LOW column shows High and Low reading for TEMPERATURE, HUMIDITY, AND PRESSURE in respective row", priority=20)
	public void AS_021_verify24HoursHighLowColumnShowsReadings() {
	    
	}

	@Test(description = "Verify LOCATION Column shows respective location for the Asset", priority=21)
	public void AS_022_verifyLocationColumnShowsLocation() {
	    
	}

	@Test(description = "Verify LAST READING column is showing time of last updated reading from sensor", priority=22)
	public void AS_023_verifyLastReadingColumnShowsTime() {
	    
	}

	@Test(description = "Verify ACTIVE ALARMS column shows all active alarm Icons with colors as per severity", priority=23)
	public void AS_024_verifyActiveAlarmsColumnShowsIcons() {
	    
	}

	@Test(description = "Verify TEMPERATURE Column shows current updated temperature for the asset", priority=24)
	public void AS_025_verifyTemperatureColumnShowsCurrentTemperature() {
	    
	}

	@Test(description = "Verify Humidity Column shows current updated humidity for the asset", priority=25)
	public void AS_026_verifyHumidityColumnShowsCurrentHumidity() {
	    
	}

	@Test(description = "Verify pressure column displays only when there is a pressure sensor attached to any sensor", priority=26)
	public void AS_027_verifyPressureColumnDisplaysOnlyWithSensor() {
	    
	}

	@Test(description = "Verify pressure column shows current updated pressure for the asset", priority=27)
	public void AS_028_verifyPressureColumnShowsCurrentPressure() {
	    
	}

	@Test(description = "Verify If sensor is inactive it should show N/A in columns", priority=28)
	public void AS_029_verifyInactiveSensorShowsNA() {
	    
	}

	@Test(description = "Verify If pressure sensor is not attached to Asset it should show N/A as reading in Pressure column", priority=29)
	public void AS_030_verifyPressureSensorNotAttachedShowsNA() {
	    
	}

	@Test(description = "Verify Actions column should show Clickable 'Edit' Button", priority=30)
	public void AS_031_verifyActionsColumnShowsEditButton() {
	    
	}

	@Test(description = "Verify click on Edit button navigates to Edit Asset page", priority=31)
	public void AS_032_verifyEditButtonNavigatesToEditPage() {
	    
	}

	@Test(description = "Verify All previous data is available on edit asset page", priority=32)
	public void AS_033_verifyPreviousDataAvailableOnEditPage() {
	    
	}

	@Test(description = "Verify all updated information for asset should be saved and updated in Asset list", priority=33)
	public void AS_034_verifyUpdatedInformationSaved() {
	    
	}

	@Test(description = "Verify Updated information for asset is reflected on Asset details page", priority=34)
	public void AS_035_verifyUpdatedInformationReflectedOnDetailsPage() {
	    
	}

	@Test(description = "Verify filter functionality", priority=35)
	public void AS_036_verifyFilterFunctionality() {
	    
	}

	@Test(description = "Verify filter popup has working close button", priority=36)
	public void AS_037_verifyFilterPopupHasCloseButton() {
	    
	}

	@Test(description = "Verify filter popup has working Reset button", priority=37)
	public void AS_038_verifyFilterPopupHasResetButton() {
	    
	}

	@Test(description = "Verify filter has required options", priority=38)
	public void AS_039_verifyFilterHasRequiredOptions() {
	    
	}

	@Test(description = "Verify Environment has required option with Checkbox", priority=39)
	public void AS_040_verifyEnvironmentHasRequiredOptionWithCheckbox() {
	    
	}

	@Test(description = "Verify Make & Model has required option with Dropdown and values", priority=40)
	public void AS_041_verifyMakeAndModelHasRequiredOption() {
	    
	}

	@Test(description = "Verify Tags has required option with Dropdown and selectable checkbox values", priority=41)
	public void AS_042_verifyTagsHasRequiredOption() {
	    
	}

	@Test(description = "Verify Alarm Type has required option with Checkbox", priority=42)
	public void AS_043_verifyAlarmTypeHasRequiredOption() {
	    
	}

	@Test(description = "Verify user can select and un-select the filter option", priority=43)
	public void AS_044_verifyUserCanSelectAndUnselectFilterOption() {
	    
	}

	@Test(description = "Verify filter popup has working Apply button", priority=44)
	public void AS_045_verifyFilterPopupHasApplyButton() {
	    
	}

	@Test(description = "Verify Filter popup should be closed automatically and shows filtered list", priority=45)
	public void AS_046_verifyFilterPopupClosesAutomatically() {
	    
	}

	@Test(description = "Verify Add asset button functionality", priority=46)
	public void AS_047_verifyAddAssetButtonFunctionality() {
	    
	}

	@Test(description = "Verify user can enter data in all textbox in add asset popup", priority=47)
	public void AS_048_verifyUserCanEnterDataInAddAssetPopup() {
	    
	}

	@Test(description = "Verify user can select Environment from dropdown", priority=48)
	public void AS_049_verifyUserCanSelectEnvironmentFromDropdown() {
	    
	}

	@Test(description = "Verify user can select Year for asset", priority=49)
	public void AS_050_verifyUserCanSelectYearForAsset() {
	    
	}

	@Test(description = "Verify user cannot save asset without mandatory data with alert message", priority=50)
	public void AS_051_verifyUserCannotSaveAssetWithoutMandatoryData() {
	    
	}

	@Test(description = "Verify '*' is present for all mandatory fields", priority=51)
	public void AS_052_verifyAsteriskPresentForMandatoryFields() {
	    
	}

	@Test(description = "Verify 'Reset' button resets whole form", priority=52)
	public void AS_053_verifyResetButtonResetsForm() {
	    
	}

	@Test(description = "Verify Configure New Sensor button opens popup with Title", priority=53)
	public void AS_054_verifyConfigureNewSensorButtonOpensPopup() {
	    
	}

	@Test(description = "Verify Device EUI functionality", priority=54)
	public void AS_055_verifyDeviceEUIFunctionality() {
	    
	}

	@Test(description = "Verify Sensor type dropdown functionality", priority=55)
	public void AS_056_verifySensorTypeDropdownFunctionality() {
	    
	}

	@Test(description = "Verify User can configure sensor with all mandatory data with alert message", priority=56)
	public void AS_057_verifyUserCanConfigureSensorWithMandatoryData() {
	    
	}

	@Test(description = "Verify User can configure Multiple sensors with all mandatory data", priority=57)
	public void AS_058_verifyUserCanConfigureMultipleSensors() {
	    
	}

	@Test(description = "Verify User cannot configure sensor without mandatory data", priority=58)
	public void AS_059_verifyUserCannotConfigureSensorWithoutMandatoryData() {
	    
	}

	@Test(description = "Verify user gets error message if sensor is already configured to another asset", priority=59)
	public void AS_060_verifyErrorMessageForAlreadyConfiguredSensor() {
	    
	}

	@Test(description = "Verify 'Add more sensor' button functionality", priority=60)
	public void AS_061_verifyAddMoreSensorButtonFunctionality() {
	    
	}

	@Test(description = "Verify asset is added with all mandatory details", priority=61)
	public void AS_062_verifyAssetAddedWithMandatoryDetails() {
	    
	}

	@Test(description = "Verify newly Added Asset is displaying in the List", priority=62)
	public void AS_063_verifyNewlyAddedAssetDisplaysInList() {
	    
	}

	@Test(description = "Verify that a pen-like icon is visible in the row of each asset", priority=63)
	public void AS_064_verifyEditIconVisibleInEachRow() {
	    
	}

	@Test(description = "Verify hover on Edit icon", priority=64)
	public void AS_065_verifyHoverOnEditIcon() {
	    
	}

	@Test(description = "Verify Click on the Edit icon", priority=65)
	public void AS_066_verifyClickOnEditIcon() {
	    
	}

	@Test(description = "Verify that the asset details page opens with all previous data", priority=66)
	public void AS_067_verifyAssetDetailsPageOpensWithPreviousData() {
	    
	}

	@Test(description = "Verify that the updated asset details are reflected in the list", priority=67)
	public void AS_068_verifyUpdatedAssetDetailsReflectedInList() {
	    
	}

	@Test(description = "Verify if the calibration due popup is displayed 3 months before the calibration due date", priority=68)
	public void AS_069_verifyCalibrationDuePopupDisplayed3MonthsBefore() {
	    
	}

	@Test(description = "Verify that an email alert is sent to all users with access to the location 3 months before the calibration due date", priority=69)
	public void AS_070_verifyEmailAlertSent3MonthsBefore() {
	    
	}

	@Test(description = "Verify alert email sent 1 month before, 15 days before, on the due date, and when overdue", priority=70)
	public void AS_071_verifyAlertEmailsSentAtIntervals() {
	    
	}

	@Test(description = "Verify that the popup for 1 month before the calibration due date correctly states 'Calibration due in 1 month'", priority=71)
	public void AS_072_verifyPopupFor1MonthBeforeCalibrationDue() {
	    
	}

	@Test(description = "Verify the popup alert on the due day", priority=72)
	public void AS_073_verifyPopupAlertOnDueDay() {
	    
	}

	@Test(description = "Verify Click on the 'Dismiss' button on the popup", priority=73)
	public void AS_074_verifyClickOnDismissButton() {
	    
	}

	@Test(description = "Verify the popup alert when the calibration is overdue", priority=74)
	public void AS_075_verifyPopupAlertWhenCalibrationOverdue() {
	    
	}

	@Test(description = "Verify that the popup reappears after dismissal when a new interval is reached and until calibration is completed", priority=75)
	public void AS_076_verifyPopupReappearsAfterDismissal() {
	    
	}
}