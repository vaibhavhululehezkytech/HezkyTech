package pages.HezkyTech;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.PageActionsBase;
import pages.uipages.HezkyTech.CustomerPanelPageUI;
import pages.uipages.HezkyTech.UploadCertificatePageUI;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class UploadCertificate extends PageActionsBase {

	/**
	 * This class contains only login page related actions method
	 * 
	 * @author Vaibhav Hulule
	 */
	public UploadCertificate(DriverManager driverManager) {
		super(driverManager, new UploadCertificatePageUI());
		browserActions.load(Config.getAccessBaseURL());
	}

	/**
	 * Method is used to login the page and accessible by outside classes
	 * 
	 * @param userName
	 * @param password
	 */
	public void fillUpCredintials(String userName, String password) {

		logManager.logInformation("Trying to login: ", true, true);
		addUserNameDetails(userName);
		addPasswordDetails(password);
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
	public void clickOnLoginButton() {
		logManager.logInformation("Trying to click on login button: ", true, true);

		String signInButton = "signIn";
		WebElement signInButtonElement = pageObject.getButton(signInButton);

		if (browserActions.waitForElementClickable(signInButtonElement, largePageTimeout, signInButton)) {
			browserActions.clickButton(signInButtonElement, signInButton);
			logManager.logInformation("Clicked on login button", true, true);
			browserActions.waitForSeconds(smallestPageTimeout);
		} else {
			Assert.fail("Submit button is not Clickable");
		}

	}
	//Click on management button
	
	public void managementButton() {
		logManager.logInformation("Trying to click on management button: ", true, true);

		String managementButton = "management";
		WebElement managementButtonElement = pageObject.getButton(managementButton);

		if (browserActions.waitForElementVisible(managementButtonElement, smallPageTimeout, managementButton)) {
			browserActions.clickButton(managementButtonElement, managementButton);
			logManager.logInformation("Clicked on management button", true, true);
		} else {
			Assert.fail("Management Button is not Clickable");
		}
	}

	//Click on  certificate management button
	public void certificateManagementButton() {
		logManager.logInformation("Trying to click on certificate management button: ", true, true);

		String certificateManagementButton = "certificateManagement";
		WebElement certificateManagementButtonElement = pageObject.getButton(certificateManagementButton);

		if (browserActions.waitForElementClickable(certificateManagementButtonElement, largePageTimeout, certificateManagementButton)) {
			browserActions.clickButton(certificateManagementButtonElement, certificateManagementButton);
			logManager.logInformation("Clicked on certificate management button", true, true);
			browserActions.waitForSeconds(smallestPageTimeout);
		}
		else {
			Assert.fail("certificate management Button is not Clickable");
		}
	

	}
	//Click on add certificate  button
	public void addCertificateButton() {
		logManager.logInformation("Trying to click on add certificate  button: ", true, true);

		String addCertificateButton = "addCertificate";
		WebElement addCertificateButtonElement = pageObject.getButton(addCertificateButton);

		if (browserActions.waitForElementClickable(addCertificateButtonElement, largePageTimeout, addCertificateButton)) {
			browserActions.clickButton(addCertificateButtonElement, addCertificateButton);
	
			logManager.logInformation("Clicked on add certificate management button", true, true);
			browserActions.waitForSeconds(smallestPageTimeout);
		}
		else {
			Assert.fail("Add certificate  Button is not Clickable");
		}
	}

}
