package utils.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.logger.LogsManager;

class HeadlessChromeBrowser extends DriverManager {
	static LogsManager logManager = new LogsManager(HeadlessChromeBrowser.class.getName());

    @Override
    public WebDriver initializeDriver() {

        WebDriver driver = null;

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getHeadlessChromeOptions());
            logManager.logInformation("Headless Chrome is launched.", false, true);
           
        } catch (Exception e) {
            logManager.logException(e, false, true);
        }

        return driver;

    }

    private static ChromeOptions getHeadlessChromeOptions() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        options.addArguments("--start-maximized");

        return options;
    }
}
