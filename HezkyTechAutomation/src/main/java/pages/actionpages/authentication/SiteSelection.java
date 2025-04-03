package pages.actionpages.authentication;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageActionsBase;
import pages.uipages.authentication.SiteSelectionPageUI;
import utils.webdrivers.DriverManager;

public class SiteSelection extends PageActionsBase {

	public SiteSelection(DriverManager driverManager) {
		super(driverManager, new SiteSelectionPageUI());		
	}
	
	/**
	 * Method is used to verify Site selection popup visibility 
	 */
	public void verifySiteSelectionPopUpLoaded() {
		
		String siteSelectioPopupTitleText = "siteSelectioPopupTitle";
		WebElement siteSelectioPopupTitleTextElement  = pageObject.getText(siteSelectioPopupTitleText);
		
		Assert.assertTrue(browserActions.waitForElementVisible(siteSelectioPopupTitleTextElement, smallPageTimeout,
				siteSelectioPopupTitleText), "Site Selection Popup Title text not visible");
		
		String changeSiteSubmitButton = "changeSiteSubmit";
		WebElement changeSiteSubmitButtonElement  = pageObject.getButton(changeSiteSubmitButton);
		
		Assert.assertTrue(browserActions.waitForElementVisible(changeSiteSubmitButtonElement, smallPageTimeout,
				changeSiteSubmitButton), "Change Site submit button not visible");
		
		String siteSelectionDropdown = "siteSelection";
		WebElement siteSelectionDropdownElement  = pageObject.getDropDown(siteSelectionDropdown);
		
		Assert.assertTrue(browserActions.waitForElementVisible(siteSelectionDropdownElement, smallPageTimeout,
				siteSelectionDropdown), "Site selection dropdown not visible");
	
	}
	
	/**
	 * Method is used to selection Site
	 * @param siteText
	 */
	public void selectSite(String siteText) {
		
		verifySiteSelectionPopUpLoaded();
		
		String siteSelectionDropdown = "siteSelection";
		WebElement siteSelectionDropdownElement  = pageObject.getDropDown(siteSelectionDropdown);
		
		if(browserActions.waitForElementClickable(siteSelectionDropdownElement, smallPageTimeout, siteSelectionDropdown)) {
			browserActions.clickButton(siteSelectionDropdownElement, siteSelectionDropdown);
		}
		
		String searchSiteTextField = "searchSite";
		WebElement searchSiteTextFieldElement = pageObject.getTextField(searchSiteTextField);
		
		if(browserActions.waitForElementClickable(searchSiteTextFieldElement, smallPageTimeout, searchSiteTextField)) {
			browserActions.addDataInTheTextField(searchSiteTextFieldElement, siteText, searchSiteTextField);
		}
		
		String siteTextList = "siteText";
		List<WebElement> siteTextListElements = pageObject.getList(siteTextList);
		
		if (siteTextListElements.size() != 0
				&& browserActions.getTextContentOfElement(siteTextListElements.get(0), siteTextList).equals(siteText)) {
			browserActions.clickButton(siteTextListElements.get(0), siteTextList);			
		} else  {
			Assert.fail("Expected Site List not displayed");
		}
	
		clickOnSumbitPopUpButton();
		browserActions.waitForSeconds(smallPageTimeout);
	}
	
	/**
	 * Method is used to click on Submit button ofSite Selection Pop-up
	 */
	public void clickOnSumbitPopUpButton() {
		String changeSiteSubmitButton = "changeSiteSubmit";
		WebElement changeSiteSubmitButtonElement  = pageObject.getButton(changeSiteSubmitButton);
		
		if(browserActions.waitForElementClickable(changeSiteSubmitButtonElement, smallPageTimeout, changeSiteSubmitButton)) {
			browserActions.clickButton(changeSiteSubmitButtonElement, changeSiteSubmitButton);
		}
	}
	
}
