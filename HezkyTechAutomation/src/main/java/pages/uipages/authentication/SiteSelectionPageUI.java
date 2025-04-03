package pages.uipages.authentication;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class SiteSelectionPageUI extends PageUIBase {

	@FindBy(xpath = "//*[text()='Site:']/parent::*/following-sibling::*")
	public static WebElement siteSelectionDropdown;
	
	@FindBy(xpath = "//kendo-popup//input")
	public static WebElement searchSiteTextField;
	
	@FindBy(xpath = "//kendo-popup//kendo-list//li/*")
	public static List<WebElement> siteTextList;
	
	@FindBy(xpath = "//*[text()='Select Site']/following-sibling::*/button")
	public static WebElement changeSiteSubmitButton;
	
	@FindBy(xpath = "//h6[text()='Select Site']")
	public static WebElement siteSelectioPopupTitleText;
	
	@FindBy(xpath = "(//li[@role='option'])[2]")
	public static WebElement site1Button;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
