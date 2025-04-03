package pages.actionpages.authentication;

import utils.webdrivers.DriverManager;

public class LoginPageBase {

	protected DriverManager driverManager;
		
	public LoginPageBase(DriverManager driverManager) {		
		this.driverManager = driverManager;		
	}
	
	public Login login() {
		return new Login(driverManager);
	}
	
	public SiteSelection siteSelection() {
	 return new SiteSelection(driverManager);	
	}
	
	public SelectModule selectModule() {
		return new SelectModule(driverManager);
	}
	
}
