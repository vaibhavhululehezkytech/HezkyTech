package pages.uipages.HezkyTech;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class CustomerPanelPageUI extends PageUIBase {

	//Comapny logo on Landing page
	@FindBy(xpath = "//img[@src='assets/svg/hezky_logo_V2.svg']")
	public static WebElement companyLogoOnLandingPageText;
	// Broken links
	@FindBy(tagName = "a")
	public static List<WebElement> checkBrokenLinksList;
	// customerID Textfiled
	@FindBy(xpath = "//input[@placeholder='Customer ID']")
	public static WebElement customerIDTextField;
	// Username Textfiled
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	public static WebElement userNameTextField;
	// Password Textfield
	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement passwordTextField;
	// Submit Button
	@FindBy(xpath = "//button[@aria-label='Sign In']")
	public static WebElement signInButton; //
	// Home page loaded verification text of Username
	@FindBy(xpath = "//span[text()='Vaibhav']")
	public static WebElement usernameValidationText;
	// Comapny logo
	@FindBy(xpath = "//img[@src='/assets/svg/hezkytech_logo.svg']")
	public static WebElement companyLogoText;

	// Dashboard
	@FindBy(xpath = "//a[text()=' Dashboard ']")
	public static WebElement dashboardButton;
	// Assets
	@FindBy(xpath = "//a[text()=' Assets ']")
	public static WebElement assetsButton;
	// Incidents
	@FindBy(xpath = "//a[text()=' Incidents ']")
	public static WebElement incidentsButton;
	// Reports
	@FindBy(xpath = "//a[text()=' Reports ']")
	public static WebElement reportsButton;
	// Admin
	@FindBy(xpath = "//span[text()='Admin']")
	public static WebElement adminButton;
	// Show More 1
	@FindBy(xpath = "(//a[text()='Show More'])[1]")
	public static WebElement showMore1Button;
	// Show More 2
	@FindBy(xpath = "(//a[text()='Show More'])[2]")
	public static WebElement showMore2Button;
	// Show less 1
	@FindBy(xpath = "(//a[text()='Show Less'])[1]")
	public static WebElement showLess1Button;
	// Show less 2
	@FindBy(xpath = "(//a[text()='Show Less'])[2]")
	public static WebElement showLess2Button;
	// Location Icon
	@FindBy(xpath = "//button[@data-target='#filterGroupModel']")
	public static WebElement locationIconButton;
	// Expand Location
	@FindBy(xpath = "(//i[@class='fa fa-plus' and (@aria-hidden='true')])[1]")
	public static WebElement expandLocationButton;
	// Select Location 
	@FindBy(xpath = "(//mat-tree-node[@role='treeitem'])[1]")
	public static WebElement selectLocationButton;
	// Notification Icon
	@FindBy(xpath = "//button[@matbadgecolor='warn']")
	public static WebElement notificationIconButton;
	// UserName
	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[2]//span")
	public static WebElement userNameButton;
	// Assigned User
	@FindBy(xpath = "//select[@name='users']")
	public static WebElement assignedUserButton;
	// Acknowledge
	@FindBy(xpath = "//button[@class='btn btn-acknowledged form-control btn_ack']")
	public static WebElement acknowledgeButton;
	// Alert Okey= //button//span[text()='Okay']
	@FindBy(xpath = "//button//span[text()='Okay']")
	public static WebElement alertOkayButton;
	// Alert Cancel
	@FindBy(xpath = "//button//span[text()='Cancel']")
	public static WebElement alertCancelButton;
	// Alert Popup Text
	@FindBy(xpath = "//h4[text()='Alert']")
	public static WebElement alertPopupValidationText;

	// Asset page
	// Asset count
	@FindBy(xpath = "//h3[text()='ASSETS ']//span")
	public static WebElement assetCountButton;
	// Asset Normal
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[1]")
	public static WebElement normalAssetButton;
	// Asset with Alarm
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[2]")
	public static WebElement assetWithAlarmButton;
	// Asset inactive
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[3]")
	public static WebElement inactiveAssetButton;
	// Add Asset
	@FindBy(xpath = "//*[text()=' Add Asset']")
	public static WebElement addAssetButton;
	// Asset Search reload
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[5]")
	public static WebElement reloadSearchAssetButton;
	// Asset Filter
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[6]")
	public static WebElement filterAssetButton;
	// Expand Asset
	@FindBy(xpath = "(//h3[text()='ASSETS ']//following::td)[2]//img")
	public static WebElement expandAssetButton;
	// Edit Asset
	@FindBy(xpath = "(//h3[text()='ASSETS ']//span//following::button)[7]")
	public static WebElement editAssetButton;

	// Add asset page
	// Close add asset page
	@FindBy(xpath = "(//h5//span//following::button)[1]")
	public static WebElement closeAddAssetPageButton;
	// configure new sensor
	@FindBy(xpath = "(//h5//span//following::button)[2]")
	public static WebElement configureNewSensorButton;
	// Submit Asset
	@FindBy(xpath = "(//h5//span//following::button)[3]")
	public static WebElement submitAssetButton;
	// Submit And Add Another
	@FindBy(xpath = "(//h5//span//following::button)[4]")
	public static WebElement submitAndAddAnotherAssetButton;
	// Reset Add Asset page
	@FindBy(xpath = "(//h5//span//following::button)[5]")
	public static WebElement resetAddaAssetPageButton;

	// Select environment button
	@FindBy(xpath = "//select")
	public static WebElement selectEnvioronmentButton;
	// select from dropdown
	@FindBy(xpath = "//select//option[text()='Cooler']")
	public static WebElement selectCoolerButton;

	// Asset name textfield (//input[@type='text'])[1]
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public static WebElement assetNameTextField;
	// make textfiled
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public static WebElement makeTextField;
	// Model textfiled
	@FindBy(xpath = "(//input[@type='text'])[3]")
	public static WebElement modelTextField;
	// tag textfiled
	@FindBy(xpath = "(//input[@type='text'])[5]")
	public static WebElement tagTextField;
	// searchDeviceEUI textfiled
	@FindBy(xpath = "(//input[@type='search']")
	public static WebElement searchDeviceEUITextField;
	// select DevcieEUI
	@FindBy(xpath = "(//input[@type='search']//following::div//li)[1]")
	public static WebElement selectDevcieEUIButton;

	// selectSensorTypeButton
	@FindBy(xpath = "//select[@name='sensor_type']")
	public static WebElement selectSensorTypeButton;
	// Select sensor type from dropdown
	@FindBy(xpath = "//select//option[text()='Neither']")
	public static WebElement selectSensorTypeFromFropdownButton;

	// submit sensorType
	@FindBy(xpath = "(//button[text()='Submit'])[2]")
	public static WebElement submitSensorTypeButton;
	// reset sensorType
	@FindBy(xpath = "(//button[text()='Reset'])[2]")
	public static WebElement resetSensorTypeButton;

	// Asset details page
	// navigateToAssetDetailsButton
	@FindBy(xpath = "(//tr//td[3])[1]")
	public static WebElement navigateToAssetDetailsButton;

	// create Alarm
	@FindBy(xpath = "//*[text()=' Create Alarm ']")
	public static WebElement createAlarmButton;
	// select Temperaturer alarm button
	@FindBy(xpath = "//a[text()='Temperature']")
	public static WebElement selectTemperatureAlarmButton;
	// select Temperaturer alarm button
	@FindBy(xpath = "//a[text()='Humidity']")
	public static WebElement selectHumidityAlarmButton;
	// select Temperaturer alarm button
	@FindBy(xpath = "(//a[text()='Pressure'])[1]")
	public static WebElement selectPressureAlarmButton;

	// Alarm name textfiled
	@FindBy(xpath = "(//label[@for='alarm_name']//following::input)[1]")
	public static WebElement alarmNameTextField;
	// Alarm name textfiled
	@FindBy(xpath = "(//label[@for='tags']//following::input)[1]")
	public static WebElement tagInAlarmTextField;
	// Alarm name textfiled
	@FindBy(xpath = "(//label[@for='delay_vlaue']//following::input)[1]")
	public static WebElement deleyIncidentTextField;

	
	
	
	// Select alrm Threashould /
	@FindBy(xpath = "//select[@name='threshold_condition']")
	public static WebElement threashouldAlarmButton;
	// GreaterThan Threashould
	@FindBy(xpath = "//OPTION[@value='Greater than']")
	public static WebElement greaterThanThreashouldAlarmButton;
	// LessThan Threashould
	@FindBy(xpath = "//OPTION[@value='Less than']")
	public static WebElement lessThanThreashouldAlarmButton;
	// select Hooter
	@FindBy(xpath = "//ng-multiselect-dropdown[@name='hooters']")
	public static WebElement selectHooterDropdownButton;
	// select severities
	@FindBy(xpath = "//ng-multiselect-dropdown[@name='severities']")
	public static WebElement severityDropdownButton;
	// select all severity
	@FindBy(xpath = "//input[@aria-label='multiselect-select-all']")
	public static WebElement selectAllCheckboxButton;
	// low severuty
	@FindBy(xpath = "//input[@aria-label='Low']")
	public static WebElement lowCheckboxButton;
	// mediam severity
	@FindBy(xpath = "//input[@aria-label='Medium']")
	public static WebElement mediumCheckboxButton;
	// high severity
	@FindBy(xpath = "//input[@aria-label='High']")
	public static WebElement highCheckboxButton;
		
		
		
}
