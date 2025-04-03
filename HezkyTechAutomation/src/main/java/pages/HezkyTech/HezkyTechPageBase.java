package pages.HezkyTech;


import utils.webdrivers.DriverManager;

public class HezkyTechPageBase {
	
protected DriverManager driverManager;

public HezkyTechPageBase(DriverManager driverManager) {		
	this.driverManager = driverManager;		
	}

public AdminPanel adminPanel() {
	return new AdminPanel(driverManager);
}
public CustomerPanel customerPanel() {
	return new CustomerPanel(driverManager);
}
public UploadCertificate  uploadCertificate() {
	return new UploadCertificate(driverManager);
}
}

