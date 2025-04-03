package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.ExtentReport;
import utils.ScreenshotHelper;
import utils.logger.LogsManager;
import utils.readers.Config;
import utils.webdrivers.DriverManager;
import utils.webdrivers.DriverManagerFactory;

/**
 * This class acts as a base class for all test classes(classes containing
 * tests) and contains methods decorated with TestNG annotations which provides
 * special behavior for those methods.
 */

/**
 *  @author vaibhav hulule
 *	Inject DriverManager details in driverManager reference variable
 *	
 */	
public abstract class TestBase {
	
    /**
     * @author vaibhav hulule
     * DriverManager class instance which will get instantiated in the @BeforeClass
     * annotated method and this will be used by all the test classes which extends
     * this class. This is the base reference holding browser on which all the test
     * execution will be done.
     */
    protected DriverManager driverManager = null;
	
    /**
     * LogsManager instance which sets logger class as current class i.e. TestBase
     * class and all logs logged in this class will be saved in the Log4j
     * execution-log.txt file with this class reference. Log file can be found in
     * test-output/logs directory in the project root directory.
     */
   static LogsManager logManager = new LogsManager(TestBase.class.getName());
   
   protected abstract void initPageObject();
   
    /**
     * This method is annotated with TestNG annotation @BeforeSuite so it will be
     * executed once every time before any class gets executed in a test suite. This
     * method loads all the configuration files present in the project root
     * directory, initializes extent report with the name of suite file name and
     * set-ups screenshot directory.
     * 
     * @param context object - used to get suite name from the test suite file name
     */
    @BeforeSuite
    public void initializeExtentReport(ITestContext context) {

        logManager.logInformation("Executing Before Suite Method.", false, false);

        String suiteName = context.getCurrentXmlTest().getSuite().getName();

        Config.loadTestConfigurationFiles();

        try {
            ExtentReport.initializeReport(suiteName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ScreenshotHelper.setupScreenshotDirectory();
    }

    /**
     * This method is annotated with TestNG annotation @BeforeClass so this method
     * will be executed once before starting execution of test method in the class.
     * This method has optional parameter with TestNG annotation @Parameter. Value
     * for this parameter will be passed from the XML test suite file.
     * 
     * @param browserName browserName - this is optional parameter, if not passed
     *                    the it uses the value specified in @Optional annotation.
     */
    @BeforeClass
    @Parameters("browserName") 
    public void initializeDriver(@Optional("chrome") String browserName) {
  
    	driverManager = DriverManagerFactory.getManager(browserName).maximizeWindow();
        
    	driverManager.getDriver();

        if (!driverManager.isDriverInitialized()) {
            logManager.logError("Driver is not initialized.");

            System.exit(1);
        }
 
        driverManager.waitSeconds(Config.getSmallestPageTimeoutSeconds());

        driverManager.setPageLoadTimeoutSeconds(Config.getLargestPageTimeoutSeconds());

        logManager.logClassProcessingStartedMessage(this.getClass().getName());
    }

    /**
     * This method is annotated with TestNG annotation @BeforeMethod so it will be
     * executed once every time before starting execution of the test method. This
     * method will create a test in the extent report.
     * 
     * @param method class object - this will be used to get the name of the test
     *               method to log in the extent report
     */
    @BeforeMethod
    public void initializeExtentTest(Method method) {

        ExtentReport.initializeExtentReportTests(method);

        logManager.logMethodStartedMessage(method.getName());
    }

    /**
     * This method is annotated with TestNG annotation @AfterMethod so it will be
     * executed once every time after finishing execution of the test method. This
     * method will log the status of test in the Extent Report. If test fails then
     * it will attach screenshot in the Extent Report. Finally it will flush the
     * extent report data.
     * 
     * @param result - which provides the status of test execution
     */
    @AfterMethod
    public void afterMethodUpdateExtentReportWithTestDetails(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            // add screenshot in extent report
            logManager.addScreenshot(driverManager, result.getName());

            logManager.logFail("TEST CASE FAILED IS: " + result.getName());

            logManager.logFail("TEST CASE FAILED REASON: " + result.getThrowable());

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            logManager.logSuccess("TEST CASE PASSED IS: " + result.getName());

        } else if (result.getStatus() == ITestResult.SKIP) {

            logManager.logSkipped("TEST CASE SKIPPED IS: " + result.getName(), true, true);
        }

        ExtentReport.flushReport();

        logManager.logMethodCompletedMessage(result.getName());
    }
    
    @AfterClass
	public void logClassExecutionCompletedMsg() {
		driverManager.getDriver().manage().deleteAllCookies();
		driverManager.quitDriver();
		logManager.logClassProcessingCompletedMessage(this.getClass().getName());
	}

//	@AfterSuite
//	public void quitDriver() {
//		driverManager.quitDriver();
//	}

}
