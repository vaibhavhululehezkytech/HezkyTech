package utils.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import utils.logger.LogsManager;

class HtmlUnitBrowser {

	static LogsManager logManager = new LogsManager(HtmlUnitBrowser.class.getName());
	private HtmlUnitBrowser() {
        throw new IllegalStateException("HtmlUnitBrowser - cannot be instantiated.");

	}

    public static WebDriver getInstance() {
        WebDriver driver = null;
        try {
            driver = new HtmlUnitDriver();
        } catch (Exception e) {
        	logManager.logException(e, false, true);
           
        }
        return driver;
    }
}
