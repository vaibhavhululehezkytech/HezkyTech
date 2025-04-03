package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.logger.LogsManager;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class ExtentReport {

    private ExtentReport() {
        throw new IllegalStateException("Utility class - ExtentReport - cannot be instantiated.");
    }

    private static boolean isExtentReportDirectorySetUp = false;
    private static ExtentReports extReport;
    private static ExtentTest extTest = null;
    private static ExtentTest testNode = null;

    private static LogsManager logManager = new LogsManager(ExtentReport.class.getName());

    public static ExtentReports initializeReport(String suiteName) {

        // Strip out whitespaces
        suiteName = suiteName.replaceAll("\\s+", "_");

        ExtentHtmlReporter htmlReporter;

        setupExtentReportDirectory();

        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/test-output/extentReports/" + suiteName + ".html");

        htmlReporter.config().setDocumentTitle(suiteName); // Title of report
        htmlReporter.config().setReportName(suiteName); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);

        extReport = new ExtentReports();
        extReport.attachReporter(htmlReporter);

        // Passing General information
       // extReport.setSystemInfo("Host name", Config.getCastlebranchBaseURL());
        extReport.setSystemInfo("Environment", Config.getTestRunEnvironment());

        return extReport;
    }

    public static void initializeExtentReportTests(Method method) {
        String testDescription = "";

        List<String> testGroups;

        if (extReport == null) {
        	logManager.logError("Extent is null");
            return;
        }

        if (method == null) {
            logManager.logError("Method is null");
            return;
        }

        testDescription = method.getAnnotation(Test.class).description();

        logManager.logInformation("test description is: " + testDescription, false, true);

        if (!testDescription.isEmpty()) {
            extTest = extReport.createTest(testDescription);
        } else
            extTest = extReport.createTest(method.getName());

        extTest.assignAuthor("Test Automation");

        testGroups = Arrays.asList(method.getAnnotation(Test.class).groups());

        if (!testGroups.isEmpty()) {
            for (String group : testGroups) {
                extTest.assignCategory(group);
            }
        } else {
            extTest.assignCategory("Smoke");
        }
    }

    private static void setupExtentReportDirectory() {

        String fileSeparator = System.getProperty("file.separator");

        File directory = new File(
                System.getProperty("user.dir") + fileSeparator + "test-output" + fileSeparator + "extentReports");

        try {
            if (!directory.exists()) {
                directory.mkdir();
                logManager.logInformation("Extent Report Directory Created.", false, true);
                isExtentReportDirectorySetUp = true;
            } else {
                if (!isExtentReportDirectorySetUp) {
                    FileUtils.cleanDirectory(directory);
                    logManager.logInformation("Extent report directory cleared.", false, true);
                    isExtentReportDirectorySetUp = true;
                }
            }
        } catch (IOException e) {
            logManager.logInformation("Exception in the set up screenshot directory.", false, true);
            logManager.logException(e, false, false);
        }
    }

    public static void closeNode() {
        testNode = null;
    }

    public static void createNode(String nodeName) {
        testNode = extTest.createNode(nodeName);
    }

    public static void flushReport() {
        if (extReport != null)
            extReport.flush();

    }

    public static void logInformation(String log) {
        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.INFO, log);
            } else {
                extTest.log(Status.INFO, log);
            }
        }

    }

    public static void logSuccess(String log) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.PASS, MarkupHelper.createLabel(log, ExtentColor.GREEN));
            } else {
                extTest.log(Status.PASS, MarkupHelper.createLabel(log, ExtentColor.GREEN));
            }
        }

    }

    public static void logWarning(String log) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.WARNING, MarkupHelper.createLabel(log, ExtentColor.ORANGE));
            } else {
                extTest.log(Status.WARNING, MarkupHelper.createLabel(log, ExtentColor.ORANGE));
            }
        }

    }

    public static void logError(String log) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.ERROR, MarkupHelper.createLabel(log, ExtentColor.RED));
            } else {
                extTest.log(Status.ERROR, MarkupHelper.createLabel(log, ExtentColor.RED));
            }
        }

    }
    
    public static void logFail(String log) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.FAIL, MarkupHelper.createLabel(log, ExtentColor.RED));
            } else {
                extTest.log(Status.FAIL, MarkupHelper.createLabel(log, ExtentColor.RED));
            }
        }

    }

    public static void logSkipped(String log) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.log(Status.SKIP, MarkupHelper.createLabel(log, ExtentColor.GREY));
            } else {
                extTest.log(Status.SKIP, MarkupHelper.createLabel(log, ExtentColor.GREY));

            }
        }

    }

    public static void logException(Exception e) {

        if (extTest != null) {
            if (testNode != null) {
                testNode.error(Arrays.toString(e.getStackTrace()));
            } else {
                extTest.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void addScreenshot(DriverManager driverManager, String fileName) {

        String screenshotPath = ScreenshotHelper.takeScreenshot(driverManager, fileName);

        if (!screenshotPath.isEmpty())
            try {

                if (extTest != null) {
                    if (testNode != null) {
                        testNode.addScreenCaptureFromPath(screenshotPath);
                    } else {
                        extTest.addScreenCaptureFromPath(screenshotPath);
                    }
                }

            } catch (IOException e) {
                logManager.logError("Exception while adding screenshot: " + fileName);
                logManager.logException(e, false, false);
            }

    }

}
