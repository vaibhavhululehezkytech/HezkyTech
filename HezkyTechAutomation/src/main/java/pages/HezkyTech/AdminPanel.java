package pages.HezkyTech;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.PageActionsBase;

import pages.uipages.HezkyTech.AdminPanelPageUI;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class AdminPanel extends PageActionsBase {

/**
 * This class contains only login page related actions method
 * 
 * @author Vaibhav
 */
	public AdminPanel(DriverManager driverManager) {
		super(driverManager, new AdminPanelPageUI());
		browserActions.load(Config.getAccessBaseURL());
	}
	/**
	 * Method is used to login the page and accessible by outside classes
	 * 
	 * @param userName
	 * @param password
	 */
	public void fillUpCredintials( String userName, String password) {
		
		logManager.logInformation("Trying to login: ", true, true);
		addUserNameDetails(userName);
		addPasswordDetails(password);
		clickOnLoginButton();
	}


	/**
	 * Method is used to add userName in UserName Text-field
	 * 
	 * @param userName
	 */
	private void addUserNameDetails(String userName) {
		String userNameTextField = "userName";
		WebElement userNameTextFieldElement = pageObject.getTextField(userNameTextField);

		if (browserActions.waitForElementVisible(userNameTextFieldElement, smallPageTimeout, userNameTextField)) {
			browserActions.addDataInTheTextField(userNameTextFieldElement, userName, userNameTextField);
			
		}else {
			
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

		if (browserActions.waitForElementVisible(passwordTextFieldElement, smallPageTimeout, passwordTextField)) {
			browserActions.addDataInTheTextField(passwordTextFieldElement, password, passwordTextField);
		}else {
			
			Assert.fail("Password fied is not accessible");
		}

	}

	/**
	 * Method is used to Click on Login Button
	 */
	private void clickOnLoginButton() {
		String signInButton = "signIn";
		WebElement signInButtonElement = pageObject.getButton(signInButton);
		
		String usernameValidationText = "usernameValidation";
		WebElement usernameValidationTextElement  = pageObject.getText(usernameValidationText);
		
		

		if (browserActions.waitForElementClickable(signInButtonElement, smallPageTimeout, signInButton)) {
			browserActions.clickButton(signInButtonElement, signInButton);
			browserActions.waitForSeconds(mediumPageTimeout);
			
			Assert.assertTrue(browserActions.waitForElementVisible(usernameValidationTextElement, smallPageTimeout,
					usernameValidationText), "Login Failed , Username Title text not visible");
		}

	}	
// HomePAGE
	//click on Inventory Management
	public void clickOnInventoryManagementButton() {
		logManager.logInformation("Trying to click on Inventory Management: ", true, true);
		String inventoryManagementButton = "inventoryManagement";
		WebElement inventoryManagementButtonElement = pageObject.getButton(inventoryManagementButton);

		if (browserActions.waitForElementClickable(inventoryManagementButtonElement, largePageTimeout, inventoryManagementButton)) {
			browserActions.clickButton(inventoryManagementButtonElement, inventoryManagementButton);
			
		}else {
			
			Assert.fail("Inventory management Button/Dropdown is not Clickable ");
		}

	}
//click on Gateway Management 
	public void clickOnGatewayManagementButton() {
		logManager.logInformation("Trying to click on Gateway Management: ", true, true);
		String gatewayManagementButton = "gatewayManagement";
		WebElement gatewayManagementButtonElement = pageObject.getButton(gatewayManagementButton);

		if (browserActions.waitForElementClickable(gatewayManagementButtonElement, mediumPageTimeout, gatewayManagementButton)) {
			browserActions.clickButton(gatewayManagementButtonElement, gatewayManagementButton);
			logManager.logInformation("clicked on Gateway management button", true, true);
		} else{
			
			Assert.fail("Gateway management Button/Dropdown is not Clickable ");
		}

	}
}
