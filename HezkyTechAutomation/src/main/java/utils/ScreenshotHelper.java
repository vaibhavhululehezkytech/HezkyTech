package utils;

import java.io.File;
import java.nio.file.Files;
import utils.logger.LogsManager;
import utils.webdrivers.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class ScreenshotHelper {

    static final String TESTOUTPUTDIRNAME = "test-output";
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static String screenshotDirectoryPath = USER_DIRECTORY + FILE_SEPARATOR + TESTOUTPUTDIRNAME + FILE_SEPARATOR
            + "screenshots";
    static LogsManager logManager = new LogsManager(ScreenshotHelper.class.getName());

   private ScreenshotHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static void setupScreenshotDirectory() {

        File directory = new File(screenshotDirectoryPath);
       
        try {
            if (!directory.exists()) {
                directory.mkdir();
                logManager.logInformation("Screenshot report directory created. " + directory.getPath(), false, true);
                
            }

            logManager.logInformation("Screenshot Directory is: " + screenshotDirectoryPath, false, true);

        } catch (Exception e) {

            
            logManager.logInformation("Exception in the set up screenshot directory", false, true);

            e.printStackTrace();

            screenshotDirectoryPath = USER_DIRECTORY;
        }
    }

    public static String takeScreenshot(DriverManager driverManager, String filename) {
        File destFile = null;
        String currentTimeMillis = "_" + String.valueOf(System.currentTimeMillis()).substring(7);
        File srcFile = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {

            destFile = new File(screenshotDirectoryPath + FILE_SEPARATOR + filename + currentTimeMillis + ".png");
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (Exception e) {
        	
            logManager.logException(e, false, true);
        }

        return destFile != null ? destFile.getPath() : "";

    }

}
