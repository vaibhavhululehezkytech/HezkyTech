package utils.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.logger.LogsManager;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    private WebDriver driver = null;

    private boolean headlessMode = false;

    private int timeoutSeconds = 0;
    static LogsManager logManager = new LogsManager(DriverManager.class.getName());

    /**
     * An extending class must implement a method named initializeDriver and return
     * the appropriate WebDriver instance
     *
     * @return WebDriver
     */
    protected abstract WebDriver initializeDriver();

    public boolean isDriverInitialized() {
        return driver != null;
    }

    /**
     *
     */
    void createDriver() {
        this.driver = initializeDriver();
        logManager.logInformation("Initialized Driver (" + uniqueId() + ")", false, true);
    }

    /**
     * Return the WebDriver.
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }

        return driver;
    }

    /**
     * Maximize browser window using this driver
     * @return DriverManager
     */
    public DriverManager maximizeWindow() {
        driver.manage().window().maximize();
        return this;
    }

    /**
     * Return a unique identifier for this driver.
     *
     * @return int Unique ID for this driver
     */
    private int uniqueId() {
        return driver.hashCode();
    }

    /**
     * Set number of seconds this driver shall wait for element to appear on the
     * page.
     *
     * @param seconds Number of seconds to wait
     */
    public void waitSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Setter for headlessMode class attribute.
     *
     * @param headlessMode true if running in headless mode, false otherwise.
     */
    public void setHeadlessMode(boolean headlessMode) {
        this.headlessMode = headlessMode;
    }

    /**
     *
     * @return boolean
     */
    public boolean isHeadlessMode() {
        return headlessMode;
    }

    /**
     * Quits this driver, closing every associated window.
     */
    public void quitDriver() {

        logManager.logInformation("Closing Driver (" + uniqueId() + ")", false, true);

        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Set number of seconds this driver shall wait for page load.
     *
     * @param seconds Number of seconds to wait
     */
    public void setPageLoadTimeoutSeconds(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
        timeoutSeconds = seconds;
    }

    public int getPageLoadTimeoutSeconds() {
        return timeoutSeconds;
    }

    public WebDriverWait getWebDriverWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, timeoutInSeconds);
    }

    public Actions getActions() {
        return new Actions(driver);
    }
}
