package utils.logger;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import utils.ExtentReport;
import utils.webdrivers.DriverManager;

public class LogsManager {

    static String fileSeparator = System.getProperty("file.separator");
    private Logger log;
    static boolean configurationLoaded = false;

    /**
     * This references the path of the log4j configuration file, which should be loaded before starting any logging.
     */
    private static String log4jConfigFilePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator
            + "main" + fileSeparator + "java" + fileSeparator + "utils" + fileSeparator + "logger" + fileSeparator
            + "log4j2.xml";

    /**
     * This is parameterized constructor which takes name of the class as parameter.
     * It first loads the configuration file if not loaded already and sets logger
     * with the class name provided as parameter.
     * 
     * @param loggerName - name of the class for which log has to be initiated
     */
    public LogsManager(String loggerName) {

        if (!configurationLoaded)
            loadLog4jConfiguration();

        initializeLogger(loggerName);
    }

    /**
     * This method initializes logger with class name provided as a parameter. It
     * registers the class name provided so that the logs added will be logged with
     * registered class' name.
     * 
     * @param loggingClassName
     */
    private void initializeLogger(String loggingClassName) {
        log = LogManager.getLogger(loggingClassName);
        
        if(log == null) {
           
            logInformation("Failed to get Log4j logger created for the class: " + loggingClassName + ". System existing.", false, true);
            System.exit(78);
        }
    }

    /**
     * This method loads the log4j configuration file. This file can be located in
     * the logger package.
     */
    public static void loadLog4jConfiguration() {
        Configurator.initialize(null, log4jConfigFilePath);
        configurationLoaded = true;
    }

    /**
     * This method adds class execution started log in the log4j log file. Ideally
     * this should be called explicitly before starting class execution and testBase
     * would be the best choice to call this method.
     * 
     * @param className - name of the class for which execution would be start
     */
    public void logClassProcessingStartedMessage(String className) {
        logClassProcessingStatusAs(className, "Started");

    }

    /**
     * This method adds class execution completed log in the log4j log file. Ideally
     * this should be called explicitly after finishing class execution and testBase
     * would be the best choice to call this method.
     * 
     * @param className - name of the class for which execution has been finished
     */
    public void logClassProcessingCompletedMessage(String className) {
        logClassProcessingStatusAs(className, "Completed");
    }

    /**
     * This method logs class processing status. Status parameter can be set as Completed, Started, Paused, Skipped etc.
     * @param className - Name of the class for which processing status has to be logged
     * @param status - Status to be logged e.g. Started, Completed, Paused, Skipped
     */
    private void logClassProcessingStatusAs(String className, String status) {
        
         String starsDecoration = "****************************************************************************************";
        
        log.info(starsDecoration);

        log.info("# # # # # Execution of Class {} {} # # # # #", className, status);

        log.info(starsDecoration);
    }
    
    /**
     * This method adds method execution started log in the log4j log file. Ideally
     * this should be called before starting method execution and testBase would be
     * the best choice to call this method.
     * 
     * @param methodName - name of the method for which execution would start
     */
    public void logMethodStartedMessage(String methodName) {

        log.info("= = = = = Execution of Method {} Started  = = = = =\n", methodName);

    }

    /**
     * This method adds method execution finished log in the log4j log file. Ideally
     * this should be called after finishing method execution and testBase would be
     * the best choice to call this method.
     * 
     * @param methodName - name of the method for which execution has been completed
     */
    public void logMethodCompletedMessage(String methodName) {

        log.info("= = = = = Execution of Method {} Completed  = = = = =\n\n", methodName);

    }

    /**
     * This method logs the message in the log4j logger and based on the parameters
     * provided it will also be logged in the extent report and to the console. This
     * method logs the message as information in the log4j and in the extent report.
     * 
     * @param message           - Message to log
     * @param logInExtentReport - If message has to be added in the Extent Report
     * @param displayInConsole  - If message has to be shown in console
     */
    public void logInformation(String message, boolean logInExtentReport, boolean displayInConsole) {

        log.info(message);

        if (logInExtentReport)
            ExtentReport.logInformation(message);

        if (displayInConsole)
            System.out.println(message);
    }

    /**
     * This method logs the message in the log4j logger and based on the parameters
     * provided it will also be logged in the extent report and to the console. This
     * method logs the message as success in the log4j report and in the extent
     * report.
     * 
     * @param message - Message to log
     */
    public void logSuccess(String message) {
        log.info("Success: {}", message);
        
        ExtentReport.logSuccess(message);
        
       logInformation(message, false, true);
    }

    /**
     * This method logs the message in the log4j logger and based on the parameters
     * provided it will also be logged in the extent report and to the console. This
     * method logs the message as warning in the log4j report and in the extent
     * report.
     * 
     * @param message           - Message to log
     * @param logInExtentReport - If message has to be added in the Extent Report
     * @param displayInConsole  - If message has to be shown in console
     */
    public void logWarning(String message, boolean logInExtentReport, boolean displayInConsole) {
        log.warn(message);

        if (logInExtentReport)
            ExtentReport.logWarning(message);

        if (displayInConsole)
        	 logInformation(message, false, true);
    }

    /**
     * This method logs the message in the log4j logger and also loggs in the extent
     * report and to the console. This method logs the message as error.
     * 
     * @param message - Message to log in all loggers
     */
    public void logError(String message) {
        log.error(message);

        ExtentReport.logError(message);

        logInformation(message, false, true);
    }
    
    /**
     * This method logs the message in the log4j logger and also loggs in the extent
     * report and to the console. This method logs the message as Fail.
     * 
     * @param message - Message to log in all loggers
     */
    public void logFail(String message) {
        log.error(message);

        ExtentReport.logFail(message);

        logInformation(message, false, true);
    }

    /**
     * This method logs the exception in the log4j logger and based on the
     * parameters provided it will also be logged in the extent report and to the
     * console. report.
     * 
     * @param e           - Exception to log
     * @param logInExtentReport - If message has to be added in the Extent Report
     * @param displayInConsole  - If message has to be shown in console
     */
    public void logException(Exception e, boolean logInExtentReport, boolean displayInConsole) {
        
        String stackTrace = Arrays.toString(e.getStackTrace());
        
        log.info("Exception: {}", stackTrace);

        if (logInExtentReport)
            ExtentReport.logException(e);

        if (displayInConsole)
            System.out.println(e.getStackTrace());
    }

    /**
     * This method logs the message in the log4j logger and based on the parameters
     * provided it will also be logged in the extent report and to the console. This
     * method logs the message as skipped in the log4j report and in the extent
     * report.
     * 
     * @param message           - Message to log
     * @param logInExtentReport - If message has to be added in the Extent Report
     * @param displayInConsole  - If message has to be shown in console
     */
    public void logSkipped(String message, boolean logInExtentReport, boolean displayInConsole) {
        log.info("Skipped: {}", message);

        if (logInExtentReport)
            ExtentReport.logSkipped(message);

        if (displayInConsole)
        	 logInformation(message, false, true);
    }

    public void addScreenshot(DriverManager driverManager, String fileName) {
        ExtentReport.addScreenshot(driverManager, fileName);
    }
}
