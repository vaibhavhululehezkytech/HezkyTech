package testdata;

import utils.readers.Config;


public class AuthTestData {

	/**
	 * Get test environment - Used in this class only to initiate data according to
	 * the test environment, no need to expose outside
	 */
	private static String env = Config.getTestRunEnvironment();
	
	/**
	 * username_Standard_User will be used as a username while logging in the system with
	 */
	public String username = "";
	public String username1 = "";
	public String username2 = "";
	public String username3 = "";


	/**
	 * password_Standard_User will be used as a password while logging in the system with
	 */
	public String password = "";
	public String password1 = "";
	public String password2 = "";
	public String password3 = "";

	
	/**
	 * Constructor which will initialize all the class fields based on the test
	 * execution environment
	 */
	public AuthTestData() {

		if (env.toLowerCase().contains("test")) {
			// QA environment Test Data

			username = "";
			password = "";
			
					    
		
		} else if (env.toLowerCase().contains("uat")) {
			// UAT Environment Test Data

			username = "";
			password = "";


		} else if (env.toLowerCase().contains("production")) {
			// Production Environment Test Data

			username = "";
			password = "";


		}
	}
	
	
}
