package pages.uipages.HezkyTech;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class UploadCertificatePageUI extends PageUIBase {
	
	// Username Textfiled
		@FindBy(xpath = "//input[@placeholder='Email ID']")
		public static WebElement userNameTextField;
		// Password Textfield
		@FindBy(xpath = "//input[@placeholder='Password']")
		public static WebElement passwordTextField;
		// Submit Button 
		@FindBy(xpath = "(//button[@type='submit']//span)[1]")
		public static WebElement signInButton; 
		// management Button 
		@FindBy(xpath = "(//a[@class='dropdown-toggle nav-link'])[1]")
		public static WebElement managementButton;
		//certificate Management Button
		@FindBy(xpath = "//div[@class='dropdown-menu show']//a[contains(text(),' Certificate Management ')]")
		public static WebElement certificateManagementButton; 
		//Add certificate button
		@FindBy(xpath = "//a[@data-target='#add_certificate']")
		public static WebElement addCertificateButton;
}
