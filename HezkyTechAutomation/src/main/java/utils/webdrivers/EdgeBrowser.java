package utils.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.logger.LogsManager;

class EdgeBrowser {
	static LogsManager logManager = new LogsManager(EdgeBrowser.class.getName());
	
	private EdgeBrowser() {
     throw new IllegalStateException("EdgeDriver - cannot be instantiated.");

	}

 public static WebDriver getInstance() {
     /*
      * To run Edge Browser correctly with WebDriver, need to do the below settings
      * Load Edge Browser -> Preferences pane -> Edge -> Preferences - >
      * Extensions Select Selenium Web Driver Extension and make it enabled. That it!
      * *
      */

     WebDriver driver = null;
     try {
         driver = new EdgeDriver();
     } catch (Exception e) {
       logManager.logException(e, false, true);
     }
     return driver;
 }
}
