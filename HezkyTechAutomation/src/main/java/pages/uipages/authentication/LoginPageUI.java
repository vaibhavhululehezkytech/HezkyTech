package pages.uipages.authentication;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class LoginPageUI extends PageUIBase {

	@FindBy(xpath = "//input[@placeholder='Access code*' and contains (@type,'text')]")
	@CacheLookup
	public static WebElement accessCodeTextField;
	
	@FindBy(xpath = "//input[@placeholder='Username*']")
	public static WebElement userNameTextField;
	
	@FindBy(xpath = "//input[@placeholder='Password*']")
	public static WebElement passwordTextField;
	
	@FindBy(xpath = "//*[text()='SIGN IN']")
	public static WebElement signInButton;
		
	
}
