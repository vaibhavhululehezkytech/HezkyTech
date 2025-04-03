package pages;



import utils.BrowserActions;
import utils.logger.LogsManager;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

/**
 * A base class for all pages in the actions package. The intent of this class
 * will provide common objects which are used on the pages(classes) which
 * extends this class.
 *
 */
public class PageActionsBase {

	/**
	 * A Driver Manager instance which will be used indirectly to work with
	 * instances where WebDriver is needed
	 */
	protected DriverManager driverManager;

	/**
	 * A BrowserActions class instance, will be used for all the interactions with
	 * Application Under Test(AUT) in UI
	 */

	protected BrowserActions browserActions;

	/**
	 * A page object class instance where these actions are performed
	 */
	protected PageObjectInterface pageObject;

	/**
	 * Below variables are initiated with different timeout values which will be
	 * used while waiting something happen
	 */
	protected int smallestPageTimeout = Config.getSmallestPageTimeoutSeconds();
	protected int smallPageTimeout = Config.getSmallPageTimeoutSeconds();
	protected int mediumPageTimeout = Config.getMediunPageTimeoutSeconds();
	protected int largePageTimeout = Config.getLargePageTimeoutSeconds();
	protected int largestPageTimeout = Config.getLargestPageTimeoutSeconds();

	/**
	 * An instance of LogginManager which will be used to get logger and log details
	 * in the log file log file can be found in test-output/logs/test-execution.log
	 */
	protected LogsManager logManager;

	/**
	 * Constructor - which initializes instance variables
	 *
	 * @param dm Driver Manager instance used to access web drivers
	 * @param ui Page Object Interface instance
	 */
	public PageActionsBase(DriverManager dm, PageObjectInterface ui) {
		driverManager = dm;
		pageObject = ui;

		browserActions = new BrowserActions(dm);
		logManager = new LogsManager(this.getClass().getName());

		ui.initElements(dm);
	}

}
