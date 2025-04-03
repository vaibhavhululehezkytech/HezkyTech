package utils.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.logger.LogsManager;

class SafariBrowser {

	static LogsManager logManager = new LogsManager(SafariBrowser.class.getName());
	
	private SafariBrowser() {
        throw new IllegalStateException("SafariBrowser - cannot be instantiated.");

	}

    public static WebDriver getInstance() {
        /*
         * To run Safari Browser correctly with WebDriver, need to do the below settings
         * Load Safari Browser -> Preferences pane -> Safari -> Preferences - >
         * Extensions Select Selenium Web Driver Extension and make it enabled. That it!
         * *
         */

        WebDriver driver = null;
        try {
            driver = new SafariDriver();
        } catch (Exception e) {
          logManager.logException(e, false, true);
        }
        return driver;
    }
}
