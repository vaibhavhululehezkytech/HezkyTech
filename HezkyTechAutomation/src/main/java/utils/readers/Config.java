package utils.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import utils.logger.LogsManager;

public class Config {
    private static String projectBaseDirectory = System.getProperty("user.dir");
    private static Map<String, String> globalProperties = new HashMap<>();
    private static String propertiesDirectoryPath = projectBaseDirectory + File.separator + "properties"
            + File.separator;

    static LogsManager logManager = new LogsManager(Config.class.getName());

    private Config() {
        throw new IllegalStateException("Utility class - ConfigReader");
    }

    public static void loadTestConfigurationFiles() {
        Config.loadEnvironmentSpecificProperties();
        Config.loadCommonProperties();
    }

    private static void loadEnvironmentSpecificProperties() {
        String propertyFileName = "";
        String env = getTestRunEnvironment();

        propertyFileName = propertiesDirectoryPath + "env." + env + ".properties";

        // Load Test Environment Specific Properties
        loadPropertyFile(propertyFileName);
        logManager.logInformation("Test Environment Specific property file loaded successfully." + propertyFileName,
                false, true);

    }

    /**
     * This method returns the test run environment specified in the command line.
     * If no environment is specified then it returns "test" as execution
     * environment. All property file names should be specified with all the lower
     * case letter. On Windows environment file name are not case sensitive but in
     * Linux environment those are case sensitive.
     * 
     * @return env - Environment name as lowercase.
     */
    public static String getTestRunEnvironment() {

        String env = System.getProperty("execution.env");

        if (env == null || env.isEmpty()) {
            logManager.logInformation("env not set, using default 'test'", false, true);
            env = "test";
        }

        return env.toLowerCase();
    }

    private static void loadCommonProperties() {
        String commonPropertiesFileName = "env.common.properties";

        String propertyFilePath = propertiesDirectoryPath + File.separator + commonPropertiesFileName;

        try {
            loadPropertyFile(propertyFilePath);
            logManager.logInformation("Common property file loaded successfully." + propertyFilePath, false, true);
        } catch (Exception e) {
            logManager.logInformation("Failed to load common property file: " + propertyFilePath, false, true);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void loadPropertyFile(String fileName) {
        InputStream inputStream = null;
        Properties prop = new Properties();

        try {
            inputStream = new FileInputStream(fileName);
            prop.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            logManager.logInformation("Error while reading config file: " + fileName, false, true);
            logManager.logException(e, false, true);

            logManager.logInformation("Execution stopped due to unavailability of data." + fileName, false, true);
            System.exit(0);
        }

        globalProperties.putAll((Map) prop);
    }

    private static String getPropertyValue(String propertyName) {
        return globalProperties.get(propertyName).trim();
    }

    public static String getAccessBaseURL() {
    	
    	 String url = getPropertyValue("Access_Base_URL");
    	
        return url;
    }

    static String getTestDataDirectoryPath() {
        return projectBaseDirectory + "//src//test//resources//";
    }

    static String getTestDataFileName() {
        return getPropertyValue("Test_Data_File_Name");
    }

    public static String getImagePath(String image) {
        return "\\src\\test\\resources\\profilePictures\\" + image;
    }

    public static int getSmallestPageTimeoutSeconds() {
        try {
            return Integer.parseInt(getPropertyValue("Smallest_Page_Timeout_Seconds"));
        } catch (Exception e) {
            return 5;
        }
    }

    public static int getSmallPageTimeoutSeconds() {
        try {
            return Integer.parseInt(getPropertyValue("Small_Page_Timeout_Seconds"));
        } catch (Exception e) {
            return 15;
        }
    }

    public static int getMediunPageTimeoutSeconds() {
        try {
            return Integer.parseInt(getPropertyValue("Mediun_Page_Timeout_Seconds"));
        } catch (Exception e) {
            return 30;
        }
    }

    public static int getLargePageTimeoutSeconds() {
        try {
            return Integer.parseInt(getPropertyValue("Large_Page_Timeout_Seconds"));
        } catch (Exception e) {
            return 45;
        }
    }

    public static int getLargestPageTimeoutSeconds() {
        try {
            return Integer.parseInt(getPropertyValue("Largest_Page_Timeout_Seconds"));
        } catch (Exception e) {
            return 60;
        }
    }
}