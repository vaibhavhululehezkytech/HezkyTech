package pages.uipages.HezkyTech;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class AdminPanelPageUI extends PageUIBase {
	
	
    // Username Textfiled 
	@FindBy(xpath = "//input[@placeholder='Email ID']")
	public static WebElement userNameTextField;
    //Password Textfield
	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement passwordTextField;
    //Submit Button
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement signInButton; //
	// Login page loaded verification text of Username
	@FindBy(xpath = "//span[text()='HezkyAdmin']")
	public static WebElement usernameValidationText;

	// HOMEPAGE

	// Inventory management Dropdown
	@FindBy(xpath = "//span[contains(text(),'Inventory Management')]")
	public static WebElement inventoryManagementButton;
	// Gateway management
	@FindBy(xpath = "//a[contains(text(),'Gateway Management')]")
	public static WebElement gatewayManagementButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
