package utils.webdrivers;

public class DriverManagerFactory {

    private DriverManagerFactory() {

    }

    public static DriverManager getManager(String browsername) {

        DriverManager driverManager = null;

        switch (browsername) {
        case "chrome":
            driverManager = new ChromeBrowser();
            driverManager.setHeadlessMode(false);
            break;

        case "headlesschrome":
            driverManager = new HeadlessChromeBrowser();
            driverManager.setHeadlessMode(true);
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + browsername);
        }

        driverManager.createDriver();

        return driverManager;
    }

}
