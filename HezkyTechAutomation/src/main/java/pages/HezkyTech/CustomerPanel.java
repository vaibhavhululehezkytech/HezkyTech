package pages.HezkyTech;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.PageActionsBase;
import pages.uipages.HezkyTech.CustomerPanelPageUI;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class CustomerPanel extends PageActionsBase {

	/**
	 * This class contains only login page related actions method
	 * 
	 * @author Vaibhav Hulule
	 */

	public CustomerPanel(DriverManager driverManager) {
		super(driverManager, new CustomerPanelPageUI());
		browserActions.load(Config.getAccessBaseURL());
	}

	/**
	 * Method is used to login the page and accessible by outside classes
	 * 
	 * @param userName
	 * @param password
	 */
	// verify Page Scroll Presence
	public void verifyPageScrollPresence() {
		browserActions.verifyPageScrollPresence();
	}

//Navigate Back From Various  Links
	public void navigateBackFromVariousLinks() {
		checkBrokenLinks();
	}

	// Check Broken links on landing page
	public void checkBrokenLinks() {
		String checkBrokenLinksList = "checkBrokenLinks";
		List<WebElement> checkBrokenLinksListElements = pageObject.getList(checkBrokenLinksList);

		for (int i = 0; i < checkBrokenLinksListElements.size(); i++) {
			try {
				// Re-locate elements to avoid StaleElementReferenceException
				checkBrokenLinksListElements = pageObject.getList(checkBrokenLinksList);
				WebElement link = checkBrokenLinksListElements.get(i);

				String url = link.getAttribute("href");

				if (url == null || url.isEmpty() || url.equals("#")) {
					System.out.println("Skipping invalid or empty link.");
					continue;
				}

				if (link.isDisplayed() && link.isEnabled()) {
					System.out.println("Checking link: " + url);

					// Scroll to the link
					browserActions.scrollToLoadElementVisible(link, checkBrokenLinksList);

					// Check if the link is actually clickable
					if (browserActions.waitForElementClickable(link, largePageTimeout, checkBrokenLinksList)) {

						// Verify if the link is broken using HTTP request
						if (isLinkBroken(url)) {
							System.out.println("Broken Link Found: " + url);
						} else {
							System.out.println("Valid Link: " + url);
							link.click();

							// Navigate back after clicking
							browserActions.goToBackPage();
						}
					}
				} else {
					System.out.println("Link is NOT clickable: " + url);
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element: Re-locating the link.");
			} catch (Exception e) {
				System.out.println("Exception while clicking the link.");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks if the given URL is broken (returns HTTP error).
	 */
	private boolean isLinkBroken(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();

			return responseCode >= 400; // If 400+ response, it's broken
		} catch (Exception e) {
			System.out.println("Error checking link: " + url);
			return true;
		}
	}
	/**
	 * Checks if the user can log in using valid credentials
	 */
	public void fillUpCredintials(String userName, String customerID, String password) {

		logManager.logInformation("Trying to login: ", true, true);
		addCustomerIDDetails(customerID);
		addUserNameDetails(userName);
		addPasswordDetails(password);
		clickOnLoginButton();
	}

	/**
	 * Method is used to add userName in UserName Text-field
	 * 
	 * @param userName
	 */
	private void addCustomerIDDetails(String customerID) {
		String customerIDTextField = "customerID";
		WebElement customerIDTextFieldElement = pageObject.getTextField(customerIDTextField);

		if (browserActions.waitForElementVisible(customerIDTextFieldElement, largestPageTimeout, customerIDTextField)) {
			browserActions.addDataInTheTextField(customerIDTextFieldElement, customerID, customerIDTextField);

		} else {

			Assert.fail("customerID field is not accessible");
		}

	}

	private void addUserNameDetails(String userName) {
		String userNameTextField = "userName";
		WebElement userNameTextFieldElement = pageObject.getTextField(userNameTextField);

		if (browserActions.waitForElementVisible(userNameTextFieldElement, largestPageTimeout, userNameTextField)) {
			browserActions.addDataInTheTextField(userNameTextFieldElement, userName, userNameTextField);

		} else {

			Assert.fail("Username field is not accessible");
		}

	}

	/**
	 * Method is used to add password in Password Text-field
	 * 
	 * @param password
	 */
	private void addPasswordDetails(String password) {
		String passwordTextField = "password";
		WebElement passwordTextFieldElement = pageObject.getTextField(passwordTextField);

		if (browserActions.waitForElementVisible(passwordTextFieldElement, largePageTimeout, passwordTextField)) {
			browserActions.addDataInTheTextField(passwordTextFieldElement, password, passwordTextField);
		} else {

			Assert.fail("Password fied is not accessible");
		}

	}

	/**
	 * Method is used to Click on Login Button
	 */
	private void clickOnLoginButton() {
		logManager.logInformation("Trying to click on login button: ", true, true);

		String signInButton = "signIn";
		WebElement signInButtonElement = pageObject.getButton(signInButton);

		String usernameValidationText = "usernameValidation";
		WebElement usernameValidationTextElement = pageObject.getText(usernameValidationText);

		if (browserActions.waitForElementClickable(signInButtonElement, largePageTimeout, signInButton)) {
			browserActions.clickButton(signInButtonElement, signInButton);
			browserActions.waitForSeconds(smallPageTimeout);

			Assert.assertTrue(browserActions.waitForElementVisible(usernameValidationTextElement, largePageTimeout,
					usernameValidationText), "Login Failed , Username Title text not visible");
		}

	}

	// companyLogoText on landingPage
	public void verifyCompnyLogoLodedOnLandingPage() {
		logManager.logInformation("Trying to verify Comapny logo is loaded or not: ", true, true);

		String companyLogoOnLandingPageText = "companyLogoOnLandingPage";
		WebElement companyLogoOnLandingPageTextElement = pageObject.getText(companyLogoOnLandingPageText);

		Assert.assertTrue(browserActions.waitForElementVisible(companyLogoOnLandingPageTextElement, largePageTimeout,
				companyLogoOnLandingPageText), "Company logo not visible");
	}

	// companyLogoText
	public void verifyCompnyLogoLoded() {
		logManager.logInformation("Trying to verify Comapny logo is loaded or not: ", true, true);

		String companyLogoText = "companyLogo";
		WebElement companyLogoTextElement = pageObject.getText(companyLogoText);

		Assert.assertTrue(
				browserActions.waitForElementVisible(companyLogoTextElement, largePageTimeout, companyLogoText),
				"Company logo not visible");
	}

	// Dashboard Button
	public void dashboardButton() {
		logManager.logInformation("Trying to click on Dashboard button: ", true, true);

		String dashboardButton = "dashboard";
		WebElement dashboardButtonElement = pageObject.getButton(dashboardButton);

		if (browserActions.waitForElementClickable(dashboardButtonElement, largePageTimeout, dashboardButton)) {
			browserActions.clickButton(dashboardButtonElement, dashboardButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Dashboard button", true, true);
		} else {
			Assert.fail("Dashboard Button is not Clickable");
		}
	}

// Asset button
	public void assetsButton() {
		logManager.logInformation("Trying to click on Assets button: ", true, true);

		String assetsButton = "assets";
		WebElement assetsButtonElement = pageObject.getButton(assetsButton);

		if (browserActions.waitForElementClickable(assetsButtonElement, largePageTimeout, assetsButton)) {
			browserActions.clickButton(assetsButtonElement, assetsButton);
			browserActions.waitForSeconds(smallPageTimeout);

			logManager.logInformation("clicked on Assets button", true, true);
		} else {

			Assert.fail("Assets Button/Dropdown is not Clickable ");
		}
	}

	// Incidents Button
	public void incidentsButton() {
		logManager.logInformation("Trying to click on Incidents button: ", true, true);

		String incidentsButton = "incidents";
		WebElement incidentsButtonElement = pageObject.getButton(incidentsButton);

		if (browserActions.waitForElementClickable(incidentsButtonElement, largePageTimeout, incidentsButton)) {
			browserActions.clickButton(incidentsButtonElement, incidentsButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Incidents button", true, true);
		} else {
			Assert.fail("Incidents Button is not Clickable");
		}
	}

	// Reports Button
	public void reportsButton() {
		logManager.logInformation("Trying to click on Reports button: ", true, true);

		String reportsButton = "reports";
		WebElement reportsButtonElement = pageObject.getButton(reportsButton);

		if (browserActions.waitForElementClickable(reportsButtonElement, largePageTimeout, reportsButton)) {
			browserActions.clickButton(reportsButtonElement, reportsButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Reports button", true, true);
			browserActions.uploadFileUsingRobotClass(reportsButton, reportsButtonElement);
		} else {
			Assert.fail("Reports Button is not Clickable");
		}
	}

	// Admin Button
	public void adminButton() {
		logManager.logInformation("Trying to click on Admin button: ", true, true);

		String adminButton = "admin";
		WebElement adminButtonElement = pageObject.getButton(adminButton);

		if (browserActions.waitForElementClickable(adminButtonElement, largePageTimeout, adminButton)) {
			browserActions.clickButton(adminButtonElement, adminButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Admin button", true, true);
		} else {
			Assert.fail("Admin Button is not Clickable");
		}
	}

	// Show More 1 Button
	public void showMore1Button() {
		logManager.logInformation("Trying to click on Show More 1 button: ", true, true);

		String showMore1Button = "showMore1";
		WebElement showMore1ButtonElement = pageObject.getButton(showMore1Button);

		if (browserActions.waitForElementClickable(showMore1ButtonElement, largePageTimeout, showMore1Button)) {
			browserActions.clickButton(showMore1ButtonElement, showMore1Button);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Show More 1 button", true, true);
		} else {
			Assert.fail("Show More 1 Button is not Clickable");
		}
	}

	// Show More 2 Button
	public void showMore2Button() {
		logManager.logInformation("Trying to click on Show More 2 button: ", true, true);

		String showMore2Button = "showMore2";
		WebElement showMore2ButtonElement = pageObject.getButton(showMore2Button);

		if (browserActions.waitForElementClickable(showMore2ButtonElement, largePageTimeout, showMore2Button)) {
			browserActions.clickButton(showMore2ButtonElement, showMore2Button);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Show More 2 button", true, true);
		} else {
			Assert.fail("Show More 2 Button is not Clickable");
		}
	}

	// Show Less 1 Button
	public void showLess1Button() {
		logManager.logInformation("Trying to click on Show Less 1 button: ", true, true);

		String showLess1Button = "showLess1";
		WebElement showLess1ButtonElement = pageObject.getButton(showLess1Button);

		if (browserActions.waitForElementClickable(showLess1ButtonElement, largePageTimeout, showLess1Button)) {
			browserActions.clickButton(showLess1ButtonElement, showLess1Button);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Show Less 1 button", true, true);
		} else {
			Assert.fail("Show Less 1 Button is not Clickable");
		}
	}

	// Show Less 2 Button
	public void showLess2Button() {
		logManager.logInformation("Trying to click on Show Less 2 button: ", true, true);

		String showLess2Button = "showLess2";
		WebElement showLess2ButtonElement = pageObject.getButton(showLess2Button);

		if (browserActions.waitForElementClickable(showLess2ButtonElement, largePageTimeout, showLess2Button)) {
			browserActions.clickButton(showLess2ButtonElement, showLess2Button);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Show Less 2 button", true, true);
		} else {
			Assert.fail("Show Less 2 Button is not Clickable");
		}
	}

	// Location Icon Button
	public void locationIconButton() {
		logManager.logInformation("Trying to click on Location Icon button: ", true, true);

		String locationIconButton = "locationIcon";
		WebElement locationIconButtonElement = pageObject.getButton(locationIconButton);

		if (browserActions.waitForElementClickable(locationIconButtonElement, largePageTimeout, locationIconButton)) {
			browserActions.clickButton(locationIconButtonElement, locationIconButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Location Icon button", true, true);
		} else {
			Assert.fail("Location Icon Button is not Clickable");
		}
	}

	// expandLocationButton
	public void expandLocationButton() {
		logManager.logInformation("Trying to click expand Location  button: ", true, true);

		String expandLocationButton = "expandLocation";
		WebElement expandLocationButtonElement = pageObject.getButton(expandLocationButton);

		if (browserActions.waitForElementClickable(expandLocationButtonElement, largePageTimeout,
				expandLocationButton)) {
			browserActions.clickButton(expandLocationButtonElement, expandLocationButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Expand Location Icon button", true, true);
		} else {
			Assert.fail("Expand Location is not clickable");
		}
	}

	// selectLocationButton
	public void selectLocationButton() {
		logManager.logInformation("Trying to click on Select Location  button: ", true, true);

		String selectLocationButton = "selectLocation";
		WebElement selectLocationButtonElement = pageObject.getButton(selectLocationButton);

		if (browserActions.waitForElementClickable(selectLocationButtonElement, largePageTimeout,
				selectLocationButton)) {
			browserActions.clickButton(selectLocationButtonElement, selectLocationButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Location is selected", true, true);
		} else {
			Assert.fail("Location   is not selected");
		}
	}

	// Notification Icon Button
	public void notificationIconButton() {
		logManager.logInformation("Trying to click on Notification Icon button: ", true, true);

		String notificationIconButton = "notificationIcon";
		WebElement notificationIconButtonElement = pageObject.getButton(notificationIconButton);

		if (browserActions.waitForElementClickable(notificationIconButtonElement, largePageTimeout,
				notificationIconButton)) {
			browserActions.clickButton(notificationIconButtonElement, notificationIconButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Notification Icon button", true, true);
		} else {
			Assert.fail("Notification Icon Button is not Clickable");
		}
	}

	// UserName Button
	public void userNameButton() {
		logManager.logInformation("Trying to click on UserName button: ", true, true);

		String userNameButton = "userName";
		WebElement userNameButtonElement = pageObject.getButton(userNameButton);

		if (browserActions.waitForElementClickable(userNameButtonElement, largePageTimeout, userNameButton)) {
			browserActions.clickButton(userNameButtonElement, userNameButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on UserName button", true, true);
		} else {
			Assert.fail("UserName Button is not Clickable");
		}
	}

	// Assigned User Button
	public void assignedUserButton() {
		logManager.logInformation("Trying to click on Assigned User button: ", true, true);

		String assignedUserButton = "assignedUser";
		WebElement assignedUserButtonElement = pageObject.getButton(assignedUserButton);

		if (browserActions.waitForElementClickable(assignedUserButtonElement, largePageTimeout, assignedUserButton)) {
			browserActions.clickButton(assignedUserButtonElement, assignedUserButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Assigned User button", true, true);
		} else {
			Assert.fail("Assigned User Button is not Clickable");
		}
	}

	// Acknowledge Button
	public void acknowledgeButton() {
		logManager.logInformation("Trying to click on Acknowledge button: ", true, true);

		String acknowledgeButton = "acknowledge";
		WebElement acknowledgeButtonElement = pageObject.getButton(acknowledgeButton);

		if (browserActions.waitForElementClickable(acknowledgeButtonElement, largePageTimeout, acknowledgeButton)) {
			browserActions.clickButton(acknowledgeButtonElement, acknowledgeButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Acknowledge button", true, true);
		} else {
			Assert.fail("Acknowledge Button is not Clickable");
		}
	}

	// Alert Okay Button
	public void alertOkayButton() {
		logManager.logInformation("Trying to click on Alert Okay button: ", true, true);

		String alertOkayButton = "alertOkay";
		WebElement alertOkayButtonElement = pageObject.getButton(alertOkayButton);

		if (browserActions.waitForElementClickable(alertOkayButtonElement, largePageTimeout, alertOkayButton)) {
			browserActions.clickButton(alertOkayButtonElement, alertOkayButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Alert Okay button", true, true);
		} else {
			Assert.fail("Alert Okay Button is not Clickable");
		}
	}

	// Alert Cancel Button
	public void alertCancelButton() {
		logManager.logInformation("Trying to click on Alert Cancel button: ", true, true);

		String alertCancelButton = "alertCancel";
		WebElement alertCancelButtonElement = pageObject.getButton(alertCancelButton);

		if (browserActions.waitForElementClickable(alertCancelButtonElement, largePageTimeout, alertCancelButton)) {
			browserActions.clickButton(alertCancelButtonElement, alertCancelButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Alert Cancel button", true, true);
		}
	}

	// Verify Alert popup loaded
	public void verifyAlertPopupTextVisible() {
		logManager.logInformation("Trying to verify if the Alert popup text is visible: ", true, true);

		String alertPopupValidationText = "alertPopupText";
		WebElement alertPopupTextElement = pageObject.getText(alertPopupValidationText);

		if (browserActions.waitForElementVisible(alertPopupTextElement, smallPageTimeout, alertPopupValidationText)) {
			logManager.logInformation("Alert popup text is visible", true, true);
		} else {
			Assert.fail("Alert popup text is not visible");
		}
	}

	// Asset Page //
	// Asset Count Button
	public void clickAssetCountButton() {
		logManager.logInformation("Trying to click on Asset Count button: ", true, true);

		String assetCountButton = "assetCount";
		WebElement assetCountButtonElement = pageObject.getButton(assetCountButton);

		if (browserActions.waitForElementClickable(assetCountButtonElement, largePageTimeout, assetCountButton)) {
			browserActions.clickButton(assetCountButtonElement, assetCountButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Asset Count button", true, true);
		} else {
			Assert.fail("Asset Count Button is not Clickable");
		}
	}

	// Normal Asset Button
	public void clickNormalAssetButton() {
		logManager.logInformation("Trying to click on Normal Asset button: ", true, true);

		String normalAssetButton = "normalAsset";
		WebElement normalAssetButtonElement = pageObject.getButton(normalAssetButton);

		if (browserActions.waitForElementClickable(normalAssetButtonElement, largePageTimeout, normalAssetButton)) {
			browserActions.clickButton(normalAssetButtonElement, normalAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Normal Asset button", true, true);
		} else {
			Assert.fail("Normal Asset Button is not Clickable");
		}
	}

	// Asset with Alarm Button
	public void clickAssetWithAlarmButton() {
		logManager.logInformation("Trying to click on Asset with Alarm button: ", true, true);

		String assetWithAlarmButton = "assetWithAlarm";
		WebElement assetWithAlarmButtonElement = pageObject.getButton(assetWithAlarmButton);

		if (browserActions.waitForElementClickable(assetWithAlarmButtonElement, largePageTimeout,
				assetWithAlarmButton)) {
			browserActions.clickButton(assetWithAlarmButtonElement, assetWithAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Asset with Alarm button", true, true);
		} else {
			Assert.fail("Asset with Alarm Button is not Clickable");
		}
	}

	// Inactive Asset Button
	public void clickInactiveAssetButton() {
		logManager.logInformation("Trying to click on Inactive Asset button: ", true, true);

		String inactiveAssetButton = "inactiveAsset";
		WebElement inactiveAssetButtonElement = pageObject.getButton(inactiveAssetButton);

		if (browserActions.waitForElementClickable(inactiveAssetButtonElement, largePageTimeout, inactiveAssetButton)) {
			browserActions.clickButton(inactiveAssetButtonElement, inactiveAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Inactive Asset button", true, true);
		} else {
			Assert.fail("Inactive Asset Button is not Clickable");
		}
	}

	// Add Asset Button
	public void clickAddAssetButton() {
		logManager.logInformation("Trying to click on Add Asset button: ", true, true);

		String addAssetButton = "addAsset";
		WebElement addAssetButtonElement = pageObject.getButton(addAssetButton);

		if (browserActions.waitForElementClickable(addAssetButtonElement, largePageTimeout, addAssetButton)) {
			browserActions.clickButton(addAssetButtonElement, addAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Add Asset button", true, true);
		} else {
			Assert.fail("Add Asset Button is not Clickable");
		}
	}

	// Reload Search Asset Button
	public void clickReloadSearchAssetButton() {
		logManager.logInformation("Trying to click on Reload Search Asset button: ", true, true);

		String reloadSearchAssetButton = "reloadSearchAsset";
		WebElement reloadSearchAssetButtonElement = pageObject.getButton(reloadSearchAssetButton);

		if (browserActions.waitForElementClickable(reloadSearchAssetButtonElement, largePageTimeout,
				reloadSearchAssetButton)) {
			browserActions.clickButton(reloadSearchAssetButtonElement, reloadSearchAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Reload Search Asset button", true, true);
		} else {
			Assert.fail("Reload Search Asset Button is not Clickable");
		}
	}

	// Filter Asset Button
	public void clickFilterAssetButton() {
		logManager.logInformation("Trying to click on Filter Asset button: ", true, true);

		String filterAssetButton = "filterAsset";
		WebElement filterAssetButtonElement = pageObject.getButton(filterAssetButton);

		if (browserActions.waitForElementClickable(filterAssetButtonElement, largePageTimeout, filterAssetButton)) {
			browserActions.clickButton(filterAssetButtonElement, filterAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Filter Asset button", true, true);
		} else {
			Assert.fail("Filter Asset Button is not Clickable");
		}
	}

	// Expand Asset Button
	public void clickExpandAssetButton() {
		logManager.logInformation("Trying to click on Expand Asset button: ", true, true);

		String expandAssetButton = "expandAsset";
		WebElement expandAssetButtonElement = pageObject.getButton(expandAssetButton);

		if (browserActions.waitForElementClickable(expandAssetButtonElement, largePageTimeout, expandAssetButton)) {
			browserActions.clickButton(expandAssetButtonElement, expandAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Expand Asset button", true, true);
		} else {
			Assert.fail("Expand Asset Button is not Clickable");
		}
	}

	// Edit Asset Button
	public void clickEditAssetButton() {
		logManager.logInformation("Trying to click on Edit Asset button: ", true, true);

		String editAssetButton = "editAsset";
		WebElement editAssetButtonElement = pageObject.getButton(editAssetButton);

		if (browserActions.waitForElementClickable(editAssetButtonElement, largePageTimeout, editAssetButton)) {
			browserActions.clickButton(editAssetButtonElement, editAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Edit Asset button", true, true);
		} else {
			Assert.fail("Edit Asset Button is not Clickable");
		}
	}

	// Add Asset page
	// Close Add Asset Page Button
	public void clickCloseAddAssetPageButton() {
		logManager.logInformation("Trying to click on Close Add Asset Page button: ", true, true);

		String closeAddAssetPageButton = "closeAddAssetPage";
		WebElement closeAddAssetPageButtonElement = pageObject.getButton(closeAddAssetPageButton);

		if (browserActions.waitForElementClickable(closeAddAssetPageButtonElement, largePageTimeout,
				closeAddAssetPageButton)) {
			browserActions.clickButton(closeAddAssetPageButtonElement, closeAddAssetPageButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Close Add Asset Page button", true, true);
		} else {
			Assert.fail("Close Add Asset Page Button is not Clickable");
		}
	}

	// Configure New Sensor Button
	public void clickConfigureNewSensorButton() {
		logManager.logInformation("Trying to click on Configure New Sensor button: ", true, true);

		String configureNewSensorButton = "configureNewSensor";
		WebElement configureNewSensorButtonElement = pageObject.getButton(configureNewSensorButton);

		if (browserActions.waitForElementClickable(configureNewSensorButtonElement, largePageTimeout,
				configureNewSensorButton)) {
			browserActions.clickButton(configureNewSensorButtonElement, configureNewSensorButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Configure New Sensor button", true, true);
		} else {
			Assert.fail("Configure New Sensor Button is not Clickable");
		}
	}

	// Submit Asset Button
	public void clickSubmitAssetButton() {
		logManager.logInformation("Trying to click on Submit Asset button: ", true, true);

		String submitAssetButton = "submitAsset";
		WebElement submitAssetButtonElement = pageObject.getButton(submitAssetButton);

		if (browserActions.waitForElementClickable(submitAssetButtonElement, largePageTimeout, submitAssetButton)) {
			browserActions.clickButton(submitAssetButtonElement, submitAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Submit Asset button", true, true);
		} else {
			Assert.fail("Submit Asset Button is not Clickable");
		}
	}

	// Submit and Add Another Asset Button
	public void clickSubmitAndAddAnotherAssetButton() {
		logManager.logInformation("Trying to click on Submit and Add Another Asset button: ", true, true);

		String submitAndAddAnotherAssetButton = "submitAndAddAnotherAsset";
		WebElement submitAndAddAnotherAssetButtonElement = pageObject.getButton(submitAndAddAnotherAssetButton);

		if (browserActions.waitForElementClickable(submitAndAddAnotherAssetButtonElement, largePageTimeout,
				submitAndAddAnotherAssetButton)) {
			browserActions.clickButton(submitAndAddAnotherAssetButtonElement, submitAndAddAnotherAssetButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Submit and Add Another Asset button", true, true);
		} else {
			Assert.fail("Submit and Add Another Asset Button is not Clickable");
		}
	}

	// Reset Add Asset Page Button
	public void clickResetAddAssetPage() {
		logManager.logInformation("Trying to click on Reset Add Asset Page button: ", true, true);

		String resetAddAssetPageButton = "resetAddAssetPage";
		WebElement resetAddAssetPageButtonElement = pageObject.getButton(resetAddAssetPageButton);

		if (browserActions.waitForElementClickable(resetAddAssetPageButtonElement, largePageTimeout,
				resetAddAssetPageButton)) {
			browserActions.clickButton(resetAddAssetPageButtonElement, resetAddAssetPageButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Reset Add Asset Page button", true, true);
		} else {
			Assert.fail("Reset Add Asset Page Button is not Clickable");
		}
	}

	// select environment
	public void clickSelectEnvironmentButton() {
		logManager.logInformation("Trying to click on Select Environment button", true, true);

		String selectEnvioronmentButton = "selectEnvioronment";
		WebElement selectEnvioronmentButtonElement = pageObject.getButton(selectEnvioronmentButton);
		if (browserActions.waitForElementClickable(selectEnvioronmentButtonElement, largePageTimeout,
				selectEnvioronmentButton)) {
			browserActions.clickButton(selectEnvioronmentButtonElement, selectEnvioronmentButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Environment button", true, true);

			// Now select the "Cooler" option
			String selectCoolerOptionButton = "selectCoolerOption"; // Optional, for logging
			WebElement selectCoolerButtonElement = pageObject.getButton(selectCoolerOptionButton);

			if (browserActions.waitForElementClickable(selectCoolerButtonElement, largePageTimeout,
					selectCoolerOptionButton)) {
				browserActions.clickButton(selectCoolerButtonElement, selectCoolerOptionButton);
				browserActions.waitForSeconds(smallestPageTimeout);
				logManager.logInformation("Selected Cooler environment", true, true);
			} else {
				Assert.fail("Cooler option is not clickable");
			}
		} else {
			Assert.fail("Select Environment Button is not clickable");
		}
	}

	// Asset Name Textfield
	public void addAssetNameDetails(String assetName) {
		String assetNameTextField = "assetName";
		WebElement assetNameTextFieldElement = pageObject.getTextField(assetNameTextField); // Direct reference to the
																							// field

		if (browserActions.waitForElementVisible(assetNameTextFieldElement, largestPageTimeout, assetNameTextField)) {
			browserActions.addDataInTheTextField(assetNameTextFieldElement, assetName, assetNameTextField);
		} else {
			Assert.fail("Asset name field is not accessible");
		}
	}

	// Make Textfield
	public void addMakeDetails(String make) {
		String makeTextField = "make";
		WebElement makeTextFieldElement = pageObject.getTextField(makeTextField); // Direct reference to the field

		if (browserActions.waitForElementVisible(makeTextFieldElement, largestPageTimeout, makeTextField)) {
			browserActions.addDataInTheTextField(makeTextFieldElement, make, makeTextField);
		} else {
			Assert.fail("Make field is not accessible");
		}
	}

	// Model Textfield
	public void addModelDetails(String model) {
		String modelTextField = "model";
		WebElement modelTextFieldElement = pageObject.getTextField(modelTextField); // Direct reference to the field

		if (browserActions.waitForElementVisible(modelTextFieldElement, largestPageTimeout, modelTextField)) {
			browserActions.addDataInTheTextField(modelTextFieldElement, model, modelTextField);
		} else {
			Assert.fail("Model field is not accessible");
		}
	}

	// Tag Textfield
	public void addTagDetails(String tag) {
		String tagTextField = "tag";
		WebElement tagTextFieldElement = pageObject.getTextField(tagTextField); // Direct reference to the field

		if (browserActions.waitForElementVisible(tagTextFieldElement, largestPageTimeout, tagTextField)) {
			browserActions.addDataInTheTextField(tagTextFieldElement, tag, tagTextField);
		} else {
			Assert.fail("Tag field is not accessible");
		}
	}

	// Search Device EUI Textfield
	public void addSearchDeviceEUIDetails(String deviceEUI) {
		String searchDeviceEUITextField = "searchdeviceEUI";
		WebElement searchDeviceEUITextFieldElement = pageObject.getTextField(searchDeviceEUITextField); // Direct
																										// reference to
																										// the field

		if (browserActions.waitForElementVisible(searchDeviceEUITextFieldElement, largestPageTimeout,
				searchDeviceEUITextField)) {
			browserActions.addDataInTheTextField(searchDeviceEUITextFieldElement, deviceEUI, searchDeviceEUITextField);
		} else {
			Assert.fail("Search Device EUI field is not accessible");
		}
	}

	// Select Device EUI Button

	public void clickSelectDeviceEUIButton() {
		logManager.logInformation("Trying to click on Select Device EUI button", true, true);

		String selectDeviceEUIButton = "selectDeviceEUI";
		WebElement selectDeviceEUIButtonElement = pageObject.getButton(selectDeviceEUIButton);

		if (browserActions.waitForElementClickable(selectDeviceEUIButtonElement, largePageTimeout,
				selectDeviceEUIButton)) {
			browserActions.clickButton(selectDeviceEUIButtonElement, selectDeviceEUIButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Device EUI button", true, true);
		} else {
			Assert.fail("Select Device EUI Button is not clickable");
		}
	}

	// Select sensorType
	public void clickSelectSensorTypeButton() {
		logManager.logInformation("Trying to click on Select Sensor Type button", true, true);

		String selectSensorTypeButton = "selectSensorType";
		WebElement selectSensorTypeButtonElement = pageObject.getButton(selectSensorTypeButton);
		if (browserActions.waitForElementClickable(selectSensorTypeButtonElement, largePageTimeout,
				selectSensorTypeButton)) {
			browserActions.clickButton(selectSensorTypeButtonElement, selectSensorTypeButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Sensor Type button", true, true);

			// Now select the "Neither" option
			String selectSensorTypeFromFropdownButton = "selectSensorTypeFromFropdown";
			WebElement selectSensorTypeFromDropdownElement = pageObject.getButton(selectSensorTypeFromFropdownButton);

			if (browserActions.waitForElementClickable(selectSensorTypeFromDropdownElement, largePageTimeout,
					selectSensorTypeFromFropdownButton)) {
				browserActions.clickButton(selectSensorTypeFromDropdownElement, selectSensorTypeFromFropdownButton);
				browserActions.waitForSeconds(smallestPageTimeout);
				logManager.logInformation("Selected 'Neither' sensor type", true, true);
			} else {
				Assert.fail("Neither option is not clickable");
			}
		} else {
			Assert.fail("Select Sensor Type Button is not clickable");
		}
	}

	// Submit Sensor Type Button
	public void clickSubmitSensorTypeButton() {
		logManager.logInformation("Trying to click on Submit Sensor Type button: ", true, true);

		String submitSensorTypeButton = "submitSensorType";
		WebElement submitSensorTypeButtonElement = pageObject.getButton(submitSensorTypeButton);

		if (browserActions.waitForElementClickable(submitSensorTypeButtonElement, largePageTimeout,
				submitSensorTypeButton)) {
			browserActions.clickButton(submitSensorTypeButtonElement, submitSensorTypeButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Submit Sensor Type button", true, true);
		} else {
			Assert.fail("Submit Sensor Type Button is not clickable");
		}
	}

	// Reset Sensor Type Button
	public void clickResetSensorTypeButton() {
		logManager.logInformation("Trying to click on Reset Sensor Type button: ", true, true);

		String resetSensorTypeButton = "resetSensorType";
		WebElement resetSensorTypeButtonElement = pageObject.getButton(resetSensorTypeButton);

		if (browserActions.waitForElementClickable(resetSensorTypeButtonElement, largePageTimeout,
				resetSensorTypeButton)) {
			browserActions.clickButton(resetSensorTypeButtonElement, resetSensorTypeButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Reset Sensor Type button", true, true);
		} else {
			Assert.fail("Reset Sensor Type Button is not clickable");
		}
	}

	// navigate To Asset Details Button
	public void navigateToAssetDetailsButton() {
		logManager.logInformation("Trying to  navigate  AssetDetails: ", true, true);

		String navigateToAssetDetailsButton = "navigateToAssetDetails";
		WebElement navigateToAssetDetailsButtonElement = pageObject.getButton(navigateToAssetDetailsButton);

		if (browserActions.waitForElementClickable(navigateToAssetDetailsButtonElement, largePageTimeout,
				navigateToAssetDetailsButton)) {
			browserActions.clickButton(navigateToAssetDetailsButtonElement, navigateToAssetDetailsButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Asset", true, true);
		} else {
			Assert.fail("Asset Button is not clickable");
		}
	}

	// Create Alarm Button

	public void clickCreateAlarmButton() {
		logManager.logInformation("Trying to click on Create Alarm button: ", true, true);

		String createAlarmButton = "createAlarm";
		WebElement createAlarmButtonElement = pageObject.getButton(createAlarmButton);

		if (browserActions.waitForElementClickable(createAlarmButtonElement, largePageTimeout, createAlarmButton)) {
			browserActions.clickButton(createAlarmButtonElement, createAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Create Alarm button", true, true);
		} else {
			Assert.fail("Create Alarm Button is not clickable");
		}
	}

	// Select Temperature Alarm Button
	public void clickSelectTemperatureAlarmButton() {
		logManager.logInformation("Trying to click on Select Temperature Alarm button: ", true, true);

		String selectTemperatureAlarmButton = "selectTemperatureAlarm";
		WebElement selectTemperatureAlarmButtonElement = pageObject.getButton(selectTemperatureAlarmButton);

		if (browserActions.waitForElementClickable(selectTemperatureAlarmButtonElement, largePageTimeout,
				selectTemperatureAlarmButton)) {
			browserActions.clickButton(selectTemperatureAlarmButtonElement, selectTemperatureAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Temperature Alarm button", true, true);
		} else {
			Assert.fail("Select Temperature Alarm Button is not clickable");
		}
	}

	// Select Humidity Alarm Button
	public void clickSelectHumidityAlarmButton() {
		logManager.logInformation("Trying to click on Select Humidity Alarm button: ", true, true);

		String selectHumidityAlarmButton = "selectHumidityAlarm";
		WebElement selectHumidityAlarmButtonElement = pageObject.getButton(selectHumidityAlarmButton);

		if (browserActions.waitForElementClickable(selectHumidityAlarmButtonElement, largePageTimeout,
				selectHumidityAlarmButton)) {
			browserActions.clickButton(selectHumidityAlarmButtonElement, selectHumidityAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Humidity Alarm button", true, true);
		} else {
			Assert.fail("Select Humidity Alarm Button is not clickable");
		}
	}

	// Select Pressure Alarm Button
	public void clickSelectPressureAlarmButton() {
		logManager.logInformation("Trying to click on Select Pressure Alarm button: ", true, true);

		String selectPressureAlarmButton = "selectPressureAlarm";
		WebElement selectPressureAlarmButtonElement = pageObject.getButton(selectPressureAlarmButton);

		if (browserActions.waitForElementClickable(selectPressureAlarmButtonElement, largePageTimeout,
				selectPressureAlarmButton)) {
			browserActions.clickButton(selectPressureAlarmButtonElement, selectPressureAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Pressure Alarm button", true, true);
		} else {
			Assert.fail("Select Pressure Alarm Button is not clickable");
		}
	}// Alarm name Textfileds

	public void addAlarmNameDetails(String alarmName) {
		String alarmNameTextField = "alarmName";
		WebElement alarmNameTextFieldElement = pageObject.getTextField(alarmNameTextField); // Direct reference

		if (browserActions.waitForElementVisible(alarmNameTextFieldElement, largestPageTimeout, alarmNameTextField)) {
			browserActions.addDataInTheTextField(alarmNameTextFieldElement, alarmName, alarmNameTextField);
		} else {
			Assert.fail("Alarm Name field is not accessible");
		}
	}

//tags in alarm
	public void addTagInAlarmDetails(String tagAlarm) {
		String tagInAlarmTextField = "tagInAlarm";
		WebElement tagInAlarmTextFieldElement = pageObject.getTextField(tagInAlarmTextField); // Direct reference

		if (browserActions.waitForElementVisible(tagInAlarmTextFieldElement, largestPageTimeout, tagInAlarmTextField)) {
			browserActions.addDataInTheTextField(tagInAlarmTextFieldElement, tagAlarm, tagInAlarmTextField);
		} else {
			Assert.fail("Tag in Alarm field is not accessible");
		}
	}

//delay incident
	public void addDelayIncidentDetails(String delayIncident) {
		String delayIncidentTextField = "delayIncident";
		WebElement delayIncidentTextFieldElement = pageObject.getTextField(delayIncidentTextField); // Direct reference

		if (browserActions.waitForElementVisible(delayIncidentTextFieldElement, largestPageTimeout,
				delayIncidentTextField)) {
			browserActions.addDataInTheTextField(delayIncidentTextFieldElement, delayIncident, delayIncidentTextField);
		} else {
			Assert.fail("Delay Incident field is not accessible");
		}
	}

	// Select Threshold Alarm Button
	public void clickSelectThresholdAlarmButton() {
		logManager.logInformation("Trying to click on Select Threshold Alarm button: ", true, true);

		String thresholdAlarmButton = "thresholdAlarm";
		WebElement thresholdAlarmButtonElement = pageObject.getButton(thresholdAlarmButton);

		if (browserActions.waitForElementClickable(thresholdAlarmButtonElement, largePageTimeout,
				thresholdAlarmButton)) {
			browserActions.clickButton(thresholdAlarmButtonElement, thresholdAlarmButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Threshold Alarm button", true, true);
		} else {
			Assert.fail("Select Threshold Alarm Button is not clickable");
		}
	}

	// Select Greater Than Threshold Button
	public void clickSelectGreaterThanThresholdButton() {
		logManager.logInformation("Trying to click on Select Greater Than Threshold button: ", true, true);

		String greaterThanThresholdButton = "greaterThanThreshold";
		WebElement greaterThanThresholdButtonElement = pageObject.getButton(greaterThanThresholdButton);

		if (browserActions.waitForElementClickable(greaterThanThresholdButtonElement, largePageTimeout,
				greaterThanThresholdButton)) {
			browserActions.clickButton(greaterThanThresholdButtonElement, greaterThanThresholdButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Greater Than Threshold button", true, true);
		} else {
			Assert.fail("Select Greater Than Threshold Button is not clickable");
		}
	}

	// Select Less Than Threshold Button
	public void clickSelectLessThanThresholdButton() {
		logManager.logInformation("Trying to click on Select Less Than Threshold button: ", true, true);

		String lessThanThresholdButton = "lessThanThreshold";
		WebElement lessThanThresholdButtonElement = pageObject.getButton(lessThanThresholdButton);

		if (browserActions.waitForElementClickable(lessThanThresholdButtonElement, largePageTimeout,
				lessThanThresholdButton)) {
			browserActions.clickButton(lessThanThresholdButtonElement, lessThanThresholdButton);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Less Than Threshold button", true, true);
		} else {
			Assert.fail("Select Less Than Threshold Button is not clickable");
		}
	}

	// Select Hooter Dropdown Button
	public void clickSelectHooterDropdownButton() {
		logManager.logInformation("Trying to click on Select Hooter Dropdown button: ", true, true);

		String selectHooterDropdown = "selectHooter";
		WebElement selectHooterDropdownElement = pageObject.getButton(selectHooterDropdown);

		if (browserActions.waitForElementClickable(selectHooterDropdownElement, largePageTimeout,
				selectHooterDropdown)) {
			browserActions.clickButton(selectHooterDropdownElement, selectHooterDropdown);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Hooter Dropdown button", true, true);
		} else {
			Assert.fail("Select Hooter Dropdown Button is not clickable");
		}
	}

	// Select Severity Dropdown Button
	public void clickSelectSeverityDropdownButton() {
		logManager.logInformation("Trying to click on Select Severity Dropdown button: ", true, true);

		String severityDropdown = "severityDropdown";
		WebElement severityDropdownElement = pageObject.getButton(severityDropdown);

		if (browserActions.waitForElementClickable(severityDropdownElement, largePageTimeout, severityDropdown)) {
			browserActions.clickButton(severityDropdownElement, severityDropdown);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select Severity Dropdown button", true, true);
		} else {
			Assert.fail("Select Severity Dropdown Button is not clickable");
		}
	}

	// Select All Checkbox Button
	public void clickSelectAllCheckboxButton() {
		logManager.logInformation("Trying to click on Select All Checkbox button: ", true, true);

		String selectAllCheckbox = "selectAllCheckbox";
		WebElement selectAllCheckboxElement = pageObject.getButton(selectAllCheckbox);

		if (browserActions.waitForElementClickable(selectAllCheckboxElement, largePageTimeout, selectAllCheckbox)) {
			browserActions.clickButton(selectAllCheckboxElement, selectAllCheckbox);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Select All Checkbox button", true, true);
		} else {
			Assert.fail("Select All Checkbox Button is not clickable");
		}
	}

	// Select Low Severity Checkbox Button
	public void clickLowSeverityCheckboxButton() {
		logManager.logInformation("Trying to click on Low Severity Checkbox button: ", true, true);

		String lowCheckbox = "lowCheckbox";
		WebElement lowCheckboxElement = pageObject.getButton(lowCheckbox);

		if (browserActions.waitForElementClickable(lowCheckboxElement, largePageTimeout, lowCheckbox)) {
			browserActions.clickButton(lowCheckboxElement, lowCheckbox);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Low Severity Checkbox button", true, true);
		} else {
			Assert.fail("Low Severity Checkbox Button is not clickable");
		}
	}

	// Select Medium Severity Checkbox Button
	public void clickMediumSeverityCheckboxButton() {
		logManager.logInformation("Trying to click on Medium Severity Checkbox button: ", true, true);

		String mediumCheckbox = "mediumCheckbox";
		WebElement mediumCheckboxElement = pageObject.getButton(mediumCheckbox);

		if (browserActions.waitForElementClickable(mediumCheckboxElement, largePageTimeout, mediumCheckbox)) {
			browserActions.clickButton(mediumCheckboxElement, mediumCheckbox);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on Medium Severity Checkbox button", true, true);
		} else {
			Assert.fail("Medium Severity Checkbox Button is not clickable");
		}
	}

	// Select High Severity Checkbox Button
	public void clickHighSeverityCheckboxButton() {
		logManager.logInformation("Trying to click on High Severity Checkbox button: ", true, true);

		String highCheckbox = "highCheckbox";
		WebElement highCheckboxElement = pageObject.getButton(highCheckbox);

		if (browserActions.waitForElementClickable(highCheckboxElement, largePageTimeout, highCheckbox)) {
			browserActions.clickButton(highCheckboxElement, highCheckbox);
			browserActions.waitForSeconds(smallPageTimeout);
			logManager.logInformation("Clicked on High Severity Checkbox button", true, true);
		} else {
			Assert.fail("High Severity Checkbox Button is not clickable");
		}
	}

}
