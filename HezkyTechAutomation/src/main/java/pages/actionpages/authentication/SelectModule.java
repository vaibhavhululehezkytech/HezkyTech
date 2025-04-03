package pages.actionpages.authentication;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.PageActionsBase;
import pages.uipages.authentication.SelectModulePageUI;
import utils.webdrivers.DriverManager;

public class SelectModule extends PageActionsBase {

	public SelectModule(DriverManager driverManager) {
		super(driverManager, new SelectModulePageUI());
	}

	/**
	 * Method is used to click on Administrator Module
	 */
	public void getAdministrator() {
		String administratorModuleLink = "administratorModule";
		WebElement administratorModuleTextElement = pageObject.getLink(administratorModuleLink);

		if (browserActions.waitForElementClickable(administratorModuleTextElement, mediumPageTimeout,
				administratorModuleLink)) {
			browserActions.clickButtonUsingJavaScript(administratorModuleTextElement, administratorModuleLink);
			browserActions.waitForSeconds(mediumPageTimeout);
		}
	}
	
	/**
	 * Method is used to click on Control tower Module
	 */
	public void getControlTower() {
		String controlTowerButton = "controlTower";
		WebElement controlTowerButtonElement = pageObject.getButton(controlTowerButton);
		if (browserActions.waitForElementClickable(controlTowerButtonElement, largePageTimeout, controlTowerButton))
			browserActions.clickButtonUsingJavaScript(controlTowerButtonElement, controlTowerButton);
		browserActions.waitForSeconds(smallPageTimeout);
	}

	
	
	/**
	 * Method is used to click on Ramgps Module
	 */
	public void getRamgps() {
		String ramgpsModuleLink = "ramgpsModule";
		WebElement ramgpsModuleLinkElement = pageObject.getLink(ramgpsModuleLink);

		if (browserActions.waitForElementClickable(ramgpsModuleLinkElement, largePageTimeout, ramgpsModuleLink)) {
			browserActions.clickButtonUsingJavaScript(ramgpsModuleLinkElement, ramgpsModuleLink);
			browserActions.waitForSeconds(smallestPageTimeout);
		}
	}

	/**
	 * Method is used to click on PMO Module
	 */
	public void getPMO() {
		String pmoModuleLink = "pmoModule";
		WebElement pmoModuleLinkElement = pageObject.getLink(pmoModuleLink);

		if (browserActions.waitForElementClickable(pmoModuleLinkElement, largePageTimeout, pmoModuleLink)) {
			browserActions.clickButtonUsingJavaScript(pmoModuleLinkElement, pmoModuleLink);
			browserActions.waitForSeconds(5);
		}
	}

	public void companyButton() {
		String companyButton = "company";
		WebElement companyButtonElement = pageObject.getButton(companyButton);

		Assert.assertTrue(browserActions.waitForElementClickable(companyButtonElement, largePageTimeout, companyButton),
				"abc");
	}

	/**
	 * Method is used to click on Productivity Study Module
	 */
	public void getProductivity_Study() {
		String getProductivityStudyLink = "getProductivityStudy";
		WebElement getProductivityStudyLinkElement = pageObject.getLink(getProductivityStudyLink);

		if (browserActions.waitForElementClickable(getProductivityStudyLinkElement, largePageTimeout,
				getProductivityStudyLink)) {
			browserActions.clickButtonUsingJavaScript(getProductivityStudyLinkElement, getProductivityStudyLink);
			browserActions.waitForSeconds(smallestPageTimeout);
		}
	}

	public void getECR() {
		String ecrModuleLink = "ecrModule";
		WebElement ecrModuleLinkElement = pageObject.getLink(ecrModuleLink);
		if (browserActions.waitForElementClickable(ecrModuleLinkElement, largePageTimeout, ecrModuleLink)) {
			browserActions.clickButtonUsingJavaScript(ecrModuleLinkElement, ecrModuleLink);
			browserActions.waitForSeconds(smallPageTimeout);
		}
	}

	public void getObjectiveAlignmentButton() {
		String objectiveAlignmentButton = "objectiveAlignment";
		WebElement objectiveAlignmentButtonElement = pageObject.getButton(objectiveAlignmentButton);

		if (browserActions.waitForElementClickable(objectiveAlignmentButtonElement, largePageTimeout,
				objectiveAlignmentButton)) {
			browserActions.clickButton(objectiveAlignmentButtonElement, objectiveAlignmentButton);
			browserActions.waitForSeconds(3);
		}
	}
	public void getPCR() {
		String pcrModuleLink = "pcrModule";
		WebElement pcrModuleLinkElement =pageObject.getLink(pcrModuleLink);

		if(browserActions.waitForElementClickable(pcrModuleLinkElement, largePageTimeout, pcrModuleLink))
		{
		browserActions.scrollToLoadElementVisible(pcrModuleLinkElement, pcrModuleLink);
		browserActions.clickButtonUsingJavaScript(pcrModuleLinkElement, pcrModuleLink);
		browserActions.waitForSeconds(smallestPageTimeout);
		}
		}

		public void getPerformanceAnalytix() {
		String performanceAnalytixModuleLink = "performanceAnalytixModule";
		WebElement performanceAnalytixModuleLinkElement =pageObject.getLink(performanceAnalytixModuleLink);

		if(browserActions.waitForElementClickable(performanceAnalytixModuleLinkElement, largePageTimeout, performanceAnalytixModuleLink))
		{
		browserActions.scrollToLoadElementVisible(performanceAnalytixModuleLinkElement, performanceAnalytixModuleLink);
		browserActions.clickButtonUsingJavaScript(performanceAnalytixModuleLinkElement, performanceAnalytixModuleLink);
		browserActions.waitForSeconds(smallestPageTimeout);
		}
		}
}
