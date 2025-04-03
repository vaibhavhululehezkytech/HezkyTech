package utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import utils.logger.LogsManager;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

public class BrowserActions extends BrowserActionBase {

    private static final String IN_THE_ELEMENT = " in the element: ";
    private static final String EXCEPTION_IS = ". Exception is: ";
    private static final String IN_DROPDOWN = " in the dropdown: ";

    private LogsManager logManager;
    private DriverManager driverManager;

    
    public BrowserActions(DriverManager driverManager) {
        super(driverManager);
        this.driverManager = driverManager;
        logManager = new LogsManager(BrowserActions.class.getName());
    }

    public void clearTextField(WebElement element, String elementName) {
        try {
            element.clear();
            logManager.logInformation("Text field cleared: " + elementName, false, false);

        } catch (Exception e) {
            logManager.logError("Exception while clearing text element: " + e);
            logManager.addScreenshot(driverManager, "Failed_ToClearTextField");

            Assert.fail("Unable to clear the text field: " + elementName + " " + e.getMessage());
        }
    }

    public void addDataInTheTextField(WebElement element, String textData, String elementName) {

   clearTextField(element, elementName);

        try {
            element.sendKeys(textData);
            logManager.logInformation("Added text: " + textData + IN_THE_ELEMENT + elementName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while adding text: " + textData + " " + IN_THE_ELEMENT + elementName + " "
                    + EXCEPTION_IS + " " + e.getMessage());
            logManager.logException(e, false, false);

            logManager.addScreenshot(driverManager, "Failed_ToAddTextInTextField");

            Assert.fail("Unable to add data in the text field: " + elementName + " " + e.getMessage());
        }
    }
    public void addDataInTheTextArea(WebElement element, String textData, String elementName) {


    	element.click();
    	try {
    	element.sendKeys(textData);
    	logManager.logInformation("Added text: " + textData + IN_THE_ELEMENT + elementName, true, false);

    	} catch (Exception e) {
    	logManager.logError("Exception while adding text: " + textData + " " + IN_THE_ELEMENT + elementName + " "
    	+ EXCEPTION_IS + " " + e.getMessage());
    	logManager.logException(e, false, false);

    	logManager.addScreenshot(driverManager, "Failed_ToAddTextInTextArea");

    	Assert.fail("Unable to add data in the text Area: " + elementName + " " + e.getMessage());
    	}
    	}

    public void clickOnEnterKey(WebElement element, String elementName) {

        try {
            element.sendKeys(Keys.ENTER);
            logManager.logInformation("Click on textfield: " + elementName, true, false);

        } catch (Exception e) {
            logManager.logException(e, false, false);

            logManager.addScreenshot(driverManager, "Failed_ToAddTextInTextField");

            Assert.fail("Unable to add data in the text field: " + elementName + " " + e.getMessage());
        }
    }

    public String getTextWithinElement(WebElement element, String elementName) {
        try {
            return element.getText();

        } catch (Exception e) {
            logManager.logError("Exception while getting text within element: " + elementName);
            logManager.logError(e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_WhileGettingTextWithinElement");
        }
        return "";
    }

    public boolean isTextFieldEmpty(WebElement element, String elementName) {

        String textFieldValue = element.getAttribute("value");

        logManager.logInformation("Checking if textfield '" + elementName + "' empty: ", false, false);

        boolean result = false;

        if (textFieldValue.isEmpty()) {
            result = true;
        }

        logManager.logInformation("Is Textfield '" + elementName + "' empty: " + result, false, false);

        return result;
    }

    public String getTextWithinDisableElement(WebElement element, String elementName) {
        String text = "";

        try {
            text = element.getAttribute("value");

        } catch (Exception e) {
            logManager.logWarning("Exception while getting value attribute of field: " + elementName, false, true);
            logManager.addScreenshot(driverManager, "Failed_WhileGettingTextWithinDisabledElement");
        }

        return text;
    }

    public String getTextContentOfElement(WebElement element, String elementName) {
        String result = "";

        try {
            result = element.getAttribute("textContent");
            return result;

        } catch (Exception e) {
            logManager.logWarning("Exception while getting text content of element '" + elementName + "' "
                    + EXCEPTION_IS + " " + e.getMessage(), true, false);
            logManager.addScreenshot(driverManager, "Failed_WhileGettingTextContentOfElement");
        }
        return result;

    }

    public WebElement getWebElementByXpath(String xpath) {
        return driverManager.getDriver().findElement(By.xpath(xpath));
    }

    public List<WebElement> getWebElementsByXpath(String xpath) {
        return driverManager.getDriver().findElements(By.xpath(xpath));
    }

    public boolean isFieldReadOnly(WebElement element, String elementName) {

        try {
            if (element.getAttribute("disabled").equalsIgnoreCase("on")) {
                return true;
            }
        } catch (Exception e) {
            logManager.logInformation("Field is not read only: " + elementName, false, false);
        }

        try {
            if (element.getAttribute("disabled").equalsIgnoreCase("true")) {
                return true;
            }
        } catch (Exception e) {
            logManager.logInformation("Field is not disabled: " + elementName, false, false);
        }

        try {
            if (element.getAttribute("readOnly").equalsIgnoreCase("true")) {
                return true;
            }
        } catch (Exception e) {
            logManager.logInformation(
                    "Exception while checking field: '" + elementName + "' is readonly: " + e.getMessage(), false,
                    false);
        }

        return false;
    }

    public boolean isElementEnable(WebElement element, String elementName) {
        boolean result = false;

        try {
            if (element.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
                return true;
            }
        } catch (Exception e) {
            logManager.logInformation("Field is not disabled: " + elementName, false, false);
        }
        return result;

    }

    // Dropdown Field Related Methods
    public boolean selectDropDownValueByVisibleText(WebElement dropdown, String visibleText, String dropdownName) {
        Select select = new Select(dropdown);

        try {
            select.selectByVisibleText(visibleText);
            return true;

        } catch (Exception e) {

            logManager.logError("Exception while selecting visible text '" + visibleText + "' " + IN_DROPDOWN + " '"
                    + dropdownName + "' " + EXCEPTION_IS + ": " + e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_SelectDropDownValueByVisibleText");

            Assert.fail("Unable to select value by visible text: " + visibleText + " from dropdown: " + dropdownName
                    + " : " + e.getMessage());

            return false;
        }
    }

    public boolean selectDropDownTextByValue(WebElement dropdown, String value, String dropdownName) {
        Select select = new Select(dropdown);
        try {
            select.selectByValue(value);
            return true;

        } catch (Exception e) {

            logManager.logError("Exception while selecting value '" + value + "' " + IN_DROPDOWN + dropdownName
                    + EXCEPTION_IS + e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_selectDropDowntTextByValue");
            Assert.fail("Unable to select test by value: '" + value + "' from dropdown: " + dropdownName + " : "
                    + e.getMessage());

            return false;
        }
    }

    public void selectDropDownOptionAtIndex(WebElement dropdown, int index, String dropdownName) {
        Select select = new Select(dropdown);

        try {
            select.selectByIndex(index);

        } catch (Exception e) {

            logManager.logError("Exception while selecting value at index " + index + " " + IN_DROPDOWN + ": "
                    + dropdownName + " " + EXCEPTION_IS + e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_selectDropDownOptionAtIndex");
        }
    }

    public String getSelectedTextInDropdown(WebElement dropdownelement, String dropdownName) {

        try {
            Select select = new Select(dropdownelement);
            return select.getFirstSelectedOption().getText();

        } catch (Exception e) {
            logManager.logInformation("Exception while getting first selected text from the select: " + dropdownName,
                    false, false);

            logManager.addScreenshot(driverManager, "Failed_getSelectedTextInDropdown");
        }

        return "";
    }

    // Radio Button Related Methods
    public void selectRadioButton(WebElement element, String radioButtonName) {
        try {
            if (!element.isSelected()) {
                element.click();

                logManager.logInformation("Radio button selected: " + radioButtonName, false, false);
            } else {
                logManager.logWarning("Radio button is already selected: " + radioButtonName, true, true);
            }

        } catch (Exception e) {
            logManager.logError("Exception while selecting radio button: " + radioButtonName);
            logManager.logException(e, true, true);

            logManager.addScreenshot(driverManager, "Failed_selectRadioButton");
            Assert.fail("Failed to select the radio button: " + radioButtonName + " : " + e.getMessage());
        }
    }

    // Generic Element Methods

    /**
     * This method will check if element is showing on the page. If element is not
     * showing then it will just log information that element is not showing. This
     * method best suited to cross check if element is no more showing on the page.
     * 
     * @param element     This is Web Element to check whether it is displayed on
     *                    the page
     * @param elementName This is the name of the Web Element
     * @return boolean This return true if element displayed otherwise return false
     */
    public boolean isElementDisplayed(WebElement element, String elementName) {

        // Increased timeout from 3 seconds to 7 due to failing tests in OSE, likely due
        // to exceeding timeout
        setDefaultDriverTimeout(7);
        logManager.logInformation("Checking if " + elementName + " visible: ", false, false);

        boolean result = false;

        try {
            if (element.isDisplayed()) {
                result = true;
                logManager.logInformation("Element is showing on the page.", false, false);
            }

        } catch (Exception e) {

            // Let's log the actual exception message to see if there's something to help
            // identify why the exception is thrown
            logManager.logInformation(e.getMessage(), false, false);
            logManager.logInformation(elementName + " is not displayed." + elementName, false, false);
        }
        setDefaultDriverTimeout();

        return result;
    }

    /**
     * This method will log an error and fail the test if element is not displayed
     * on the page
     * 
     * @param element     This is Web Element to check whether it is displayed on
     *                    the page
     * @param elementName This is the name of the Web Element
     * @return boolean This return true if element displayed otherwise return false
     */
    public boolean isElementDisplayedWithAssertFail(WebElement element, String elementName) {

        boolean result = true;
        try {
            if (!isElementDisplayed(element, elementName)) {
                result = false;
                logManager.addScreenshot(driverManager, "Failed_" + elementName + "_isNotShowing");
                Assert.fail("Element " + elementName + " is not showing on the page.");
            }
        } catch (AssertionError e) {
            logManager.logError("Element : " + elementName + " is  not Showing");
        }

        return result;
    }

    public void scrollToLoadElementVisible(WebElement element, String elementName) {
        try {
            ((JavascriptExecutor) driverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);

        } catch (Exception e) {
            logManager.logWarning(
                    "Exception while scrolling for element: " + elementName + " " + EXCEPTION_IS + " " + e.getMessage(),
                    false, false);

            logManager.addScreenshot(driverManager, "Failed_scrollToLoadElementVisible");
        }
    }

    public boolean isFieldHasFocus(WebElement element, String elementName) {
        boolean result = false;

        try {
            if (element.equals(driverManager.getDriver().switchTo().activeElement())) {
                result = true;

            } else {
                WebElement focusedElement = driverManager.getDriver().switchTo().activeElement();
                logManager.logInformation(
                        "Element " + elementName + " is not currently focused. Focused Element is: " + focusedElement,
                        false, false);
            }

        } catch (Exception e) {
            logManager.logInformation("Exception while checking if " + elementName + " is focused: " + e.getMessage(),
                    false, false);
            logManager.addScreenshot(driverManager, "Failed_isFieldHasFocus");
        }

        return result;

    }

    public String getErrorMessageShowingForField(WebElement element, String elementName) {
        try {
            return element.getAttribute("validationMessage");

        } catch (Exception e) {
            logManager.logWarning(
                    "Exception while getting error message for element: " + elementName + ": " + e.getMessage(), false,
                    false);
            logManager.addScreenshot(driverManager, "Failed_getErrorMessageShowingForField");

            return "";
        }
    }

    public String getSourceOfImage(WebElement imageLocator, String imageName) {
        try {
            return imageLocator.getAttribute("src");

        } catch (Exception e) {
            logManager.logError("Cannot get image file path for image: " + imageName + ": " + e.getMessage());
            logManager.addScreenshot(driverManager, "Failed_getSourceOfImage");

            return "";
        }
    }
    

    public String getAttributeOfWebElement(WebElement element, String attribute, String elementName) {
        try {
            return element.getAttribute(attribute);

        } catch (Exception e) {
            logManager.logWarning("Exception while getting attribute " + attribute + " for field: " + elementName,
                    false, false);

            logManager.addScreenshot(driverManager, "Failed_getAttributeOfWebElement");

            return "";
        }
    }

    // Page Related Methods
    public void load(String url) {

        logManager.logInformation("Loading URL in browser: " + url, true, false);

        try {
            driverManager.getDriver().get(url);
            waitForPageLoadCompletes(Config.getLargestPageTimeoutSeconds());

            logManager.logInformation("Page loaded.", true, false);

        } catch (Exception e) {
            logManager.logError("Error while loading URL: " + url + " " + e.getMessage());
            logManager.addScreenshot(driverManager, "Failed to load URL: " + url);
        }
    }

    public String getPageURL() {
        return driverManager.getDriver().getCurrentUrl();
    }

    public String getPageTitle() {
        return driverManager.getDriver().getTitle();
    }

    public void refreshPage() {
        try {
            driverManager.getDriver().navigate().refresh();

        } catch (Exception e) {
            logManager.logError("Exception while refreshing the page. " + e.getMessage());
            logManager.addScreenshot(driverManager, "Failed_refreshPage");
        }
    }

    public void goToBackPage() {
        try {
            driverManager.getDriver().navigate().back();

        } catch (Exception e) {
            logManager.logError("Exception while loading back page.");
            logManager.addScreenshot(driverManager, "Failed_goToBackPage");
        }
    }

    // Alert Related Methods
    public boolean isAlertShowing() {
        boolean result = false;

        try {
            if (driverManager.getWebDriverWait(2).until(ExpectedConditions.alertIsPresent()) != null)
                result = true;
        } catch (Exception e) {
            logManager.logWarning("Alert is not showing on the page.", true, true);
            logManager.addScreenshot(driverManager, "Check_isAlertShowingOnPage");
        }

        return result;
    }

    public boolean isAlertShowingWithAssertFail() {
        boolean result = true;
        try {
            if (!isAlertShowing()) {
                result = false;
                Assert.fail("Alert is not showing.");
            }
        } catch (AssertionError e) {
            logManager.logError(e.getMessage());
        }

        return result;
    }

    public String getAlertText() {
        String noAlertText = "Failed: No Alert Present on the page.";
        String result = "";

        try {
            if (isAlertShowing())
                result = driverManager.getDriver().switchTo().alert().getText();
            else
                result = noAlertText;

        } catch (Exception e) {
            logManager.logError("Alert is not present on the page.");
            logManager.addScreenshot(driverManager, "Failed_getAlertText");

            result = noAlertText;
        }

        return result;
    }

    public boolean acceptAlert() {
        boolean result = false;

        if (isAlertShowing()) {
            driverManager.getDriver().switchTo().alert().accept();
            logManager.logInformation("Alert is closed.", true, false);

            result = true;
        }

        return result;
    }

    public boolean dismissAlert() {
        boolean result = false;

        if (isAlertShowing()) {
            driverManager.getDriver().switchTo().alert().dismiss();
            logManager.logInformation("Alert is closed.", true, false);

            result = true;
        }

        return result;
    }

    public void addTextInAlertTextBox(String inputText) {

        if (isAlertShowing()) {
            driverManager.getDriver().switchTo().alert().sendKeys(inputText);
            logManager.logInformation("Added text in alert text box." + inputText, true, false);

        }

    }

    // Window Related Methods
    public String getCurrentWindowHandle() {
        try {
            return driverManager.getDriver().getWindowHandle();

        } catch (Exception e) {
            logManager.logError("Exception while getting current window handle. Exception is: " + e.getMessage());
        }

        return "";
    }

    public void closeCurrentTab() {
        try {
            driverManager.getDriver().close();
        } catch (Exception e) {
            logManager.logError("Exception while closing current tab: Exception is: " + e.getMessage());
            logManager.addScreenshot(driverManager, "Failed_closeCurrentTab");

        }

    }

    public void goToWindow(String windowHandle) {
        try {
            driverManager.getDriver().switchTo().window(windowHandle);
        } catch (Exception e) {
            logManager.logError(
                    "Exception while loading window :   " + windowHandle + " " + EXCEPTION_IS + " " + e.getMessage());
            logManager.addScreenshot(driverManager, "Failed_goToWindow");
        }

    }

    public Set<String> getAllWindowHandles() {
        try {
            return driverManager.getDriver().getWindowHandles();

        } catch (Exception e) {
            logManager.logError("Exception while getting all window handles.");
        }

        return new HashSet<>();
    }

    // Common Browser Methods
    public void scrollUpByPixels(int pixels) {
        try {
            pixels = pixels * -1;
            ((JavascriptExecutor) driverManager.getDriver()).executeScript("window.scrollBy(0, arguments[0]);", pixels);

        } catch (Exception e) {
            logManager.logInformation(
                    "Exception while scrolling up by pixels: " + pixels + EXCEPTION_IS + e.getMessage(), false, false);
            logManager.addScreenshot(driverManager, "Failed_scrollUpByPixels");
        }
    }

    public void scrollDownAtTheBottomOfPage() {
        try {
            ((JavascriptExecutor) driverManager.getDriver())
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        } catch (Exception e) {
            logManager.logInformation(
                    "Exception while scrolling down at the bottom of the page: Exception is: " + e.getMessage(), false,
                    true);

            logManager.addScreenshot(driverManager, "Failed_scrollDownAtTheBottomOfPage");
        }

    }
    public void verifyPageScrollPresence() {
        
        Long scrollHeight = (Long) ((JavascriptExecutor) driverManager.getDriver()).executeScript("return document.documentElement.scrollHeight");
        Long clientHeight = (Long) ((JavascriptExecutor) driverManager.getDriver()).executeScript("return document.documentElement.clientHeight");

        if (scrollHeight > clientHeight) {
            System.out.println("Test Passed: Scroll is present on the page when needed.");
        } else {
            System.out.println("Test Failed: Scroll is NOT present on the page when needed.");
        }
    }
    
    public void scrollUpAtTheTopOfPage() {
        try {
            ((JavascriptExecutor) driverManager.getDriver())
                    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        } catch (Exception e) {
            logManager.logInformation(
                    "Exception while scrolling down at the bottom of the page: Exception is: " + e.getMessage(), false,
                    true);

            logManager.addScreenshot(driverManager, "Failed_scrollDownAtTheBottomOfPage");
        }

    }

    public void pressKey(String keyName) {
        Actions action = driverManager.getActions();
        logManager.logInformation("In Press Key Method", false, true);
        try {          
                action.sendKeys(Keys.valueOf(keyName.toUpperCase())).build().perform();
                logManager.logInformation("Pressing Tab Key", false, true);
            
        } catch (Exception e) {
            logManager.logError("Exception while pressing Escape key");
        }
    }

    // Common Function Methods

    public String getCurrentDateTime() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
    }

    // Upload file using robot class

    public void uploadFileUsingRobotClass(String imagePath, WebElement browseFileButton) {
        String profileImagePath = System.getProperty("user.dir") + imagePath;
        System.out.println("ProfileImagePath");
        logManager.logInformation("Image used to upload profile picture is: " + profileImagePath, false, true);

        StringSelection select = new StringSelection(profileImagePath);

        // copy the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

        // Click on Upload file button
        scrollToLoadElementVisible(browseFileButton, "Browse Button");
        scrollUpByPixels(70);
        clickButton(browseFileButton, "Browse Button");
        //clickButtonUsingJavaScript(browseFileButton, "Browse Button");
        
        logManager.logInformation("Clicked on the Upload file button.", true, true);

        // Paste path using robot class
        Robot robot;

        try {
            robot = new Robot();

            driverManager.getActions().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

            waitForSeconds(10);

            // Press CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            logManager.logError("Exception while uploading file.");
            logManager.logException(e, true, true);
        }
    }

    public String getCssValueOfWebElement(WebElement element, String attribute, String elementName) {
        try {
            return element.getCssValue(attribute);

        } catch (Exception e) {
            logManager.logWarning("Exception while getting attribute " + attribute + " for field: " + elementName,
                    false, false);

            logManager.addScreenshot(driverManager, "Failed_getAttributeOfWebElement");

            return "";
        }
    }


    /**
     * Method will be used to double-click on element
     * @param element
     * @param elementName
     */
    public void doubleClickOnElement(WebElement element, String elementName) {

        try {
            Actions action = driverManager.getActions();
            action.doubleClick(element).build().perform();
            logManager.logInformation("Double click on element: " + elementName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while double clicking on element: " + elementName);

            logManager.addScreenshot(driverManager, "Failed_doubleClickElement");

            Assert.fail("Failed to double click on the element: " + elementName + " : " + e.getMessage());
        }
    }
    
    public void moveToElementByAxisElement(WebElement element, String elementName) {

        try {
            Actions action = driverManager.getActions();
            action.moveToElement(element, 120, 1);
            logManager.logInformation(" click on element: " + elementName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while double clicking on element: " + elementName);

            logManager.addScreenshot(driverManager, "Failed_doubleClickElement");

            Assert.fail("Failed to  click on the element: " + elementName + " : " + e.getMessage());
        }
    }
    
    public void moveToElementAtCenterOfScreen(WebElement element, String elementName) {

		try {
			String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
					+ "var elementTop = arguments[0].getBoundingClientRect().top;"
					+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";

			((JavascriptExecutor) driverManager.getDriver()).executeScript(scrollElementIntoMiddle, element);
			logManager.logInformation(" Scroll on element: " + elementName, true, false);

		} catch (Exception e) {
			logManager.logError("Exception while scrolling on element: " + elementName);

			logManager.addScreenshot(driverManager, "Failed_To_Scroll");

			Assert.fail("Failed to scroll on the element: " + elementName + " : " + e.getMessage());
		}
    }
    
    /**
	 * Verify element background color
	 */
	public boolean verifyElementBackGroundColor(WebElement element, String elementName, String colorCode) {
		
		boolean result = false;
		
		if (isElementDisplayed(element, elementName)
				&& element.getCssValue("background-color").equals(colorCode)) {
			logManager.logInformation("Element Color is getting displayed as expected.", true, false);
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Method to get the latest file from specified location
	 * @param dirPath
	 * @return last Modified File
	 */
	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	/**
	 * Verify file/Report is downloaded correctly
	 * return true if downloaded file is correct else false
	 */
	public boolean checkFileIsDownloadedCorrectly(String expectedFileName) {
		
		boolean result = false;
		
		String downloadPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "downloadedReports";
		
		waitForSeconds(3);
		File getLatestFile = getLatestFilefromDir(downloadPath);		
		if (getLatestFile != null) {
			String fileName = getLatestFile.getName();

			logManager.logInformation("File name is " + fileName, false, false);
			
			result = (fileName.contains(expectedFileName))? true : false;

		} else {
			logManager.logInformation("Invalid download path or path does not contain File/report.", true, false);
		}
		return result;
	}
	
}
