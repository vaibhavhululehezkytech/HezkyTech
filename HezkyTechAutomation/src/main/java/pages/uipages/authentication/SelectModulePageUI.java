package pages.uipages.authentication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageUIBase;

public class SelectModulePageUI extends PageUIBase {

	@FindBy(xpath = "//div[@title='Administrator']")
	public static WebElement administratorModuleLink;

	@FindBy(xpath = "//h6[text()='BPMOptimization']")
	public static WebElement pmoModuleLink;
	
	@FindBy(xpath = "//a[@href='#/companymaster']")
	public static WebElement companyButton;
	
	@FindBy(xpath = "//a[@href='#/my-assessment']")
	public static WebElement ramgpsModuleLink;
	@FindBy(xpath = "//h6[text()='Work Management']")
	public static WebElement getProductivityStudyLink;
	
	@FindBy(xpath = "//a[@href='#/ecr-analysis']")
	public static WebElement ecrModuleLink;
	
	@FindBy(xpath = "//a[@href='#/objective-assessment']")
	public static WebElement objectiveAlignmentButton;
	
	@FindBy(xpath = "//a[@href='#/control-tower']")
	public static WebElement controlTowerButton;
	
	@FindBy(xpath = "//*[@href='#/fmea']")
	public static WebElement pcrModuleLink;


	@FindBy(xpath ="//*[text()='Performance Analytix']")
	public static WebElement performanceAnalytixModuleLink;
}
