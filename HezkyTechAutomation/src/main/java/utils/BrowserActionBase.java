package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.logger.LogsManager;
import utils.webdrivers.DriverManager;

public class BrowserActionBase {

    private LogsManager logManager;

    private static final String EXCEPTION_IS = ". Exception is: ";

    private DriverManager driverManager;

    public BrowserActionBase(DriverManager driverManager) {
        this.driverManager = driverManager;
        logManager = new LogsManager(BrowserActionBase.class.getName());
    }

    // Button Related Methods
    public void clickButton(WebElement element, String buttonName) {

        try {
            element.click();
            logManager.logInformation("Clicked on the button: " + buttonName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while clicking on button: " + buttonName);

            logManager.addScreenshot(driverManager, "Failed_clickButton");

            Assert.fail("Failed to click on the button: " + buttonName + " : " + e.getMessage());
        }
    }

    public void clickButtonUsingJavaScript(WebElement element, String buttonName) {
        try {
            ((JavascriptExecutor) driverManager.getDriver()).executeScript("arguments[0].click();", element);

        } catch (Exception e) {
            logManager.logError("Exception while clicking on the button using JS: " + buttonName + " " + EXCEPTION_IS
                    + " " + e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_clickButtonUsingJavaScript");

            Assert.fail("Failed to click on the button using JS: " + buttonName + " : " + e.getMessage());
        }

    }

    // This method is used to hover over an element
    public void hoverOnElement(WebElement element, String elementName) {

        try {
            Actions action = driverManager.getActions();
            action.moveToElement(element).build().perform();
            logManager.logInformation("Hovering on element: " + elementName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while hovering on element: " + elementName);

            logManager.addScreenshot(driverManager, "Failed_hoverElement");

            Assert.fail("Failed to hover on the element: " + elementName + " : " + e.getMessage());
        }
    }

    // Hyperlink Related Methods
    public void clickOnLink(WebElement element, String linkName) {
        try {
            element.click();
            logManager.logInformation("Clicked on the link: " + linkName, true, false);

        } catch (Exception e) {
            logManager.logInformation("Exception while Clicking on the link:  " + linkName, true, false);
            logManager.addScreenshot(driverManager, "Failed_clickOnLink");

            Assert.fail("Failed to click on the link: " + linkName + " : " + e.getMessage());
        }
    }

    // Checkbox Related Methods
    public void checkTheCheckbox(WebElement element, String checkboxName) {
        try {
            if (!element.isSelected()) {
                element.click();

                logManager.logInformation("Checkbox checked: " + checkboxName, true, false);

            } else {
                logManager.logWarning("Checkbox is already checked: " + checkboxName, true, true);
            }

        } catch (Exception e) {
            logManager.logError("Exception while checking the checkbox: " + checkboxName);
            logManager.logException(e, true, true);

            logManager.addScreenshot(driverManager, "Failed_checkTheCheckbox");

            Assert.fail("Failed to check the checkbox: " + checkboxName + " : " + e.getMessage());
        }
    }

    public void uncheckTheCheckbox(WebElement element, String checkboxName) {
        try {
            if (element.isSelected()) {
                element.click();
                logManager.logInformation("Checkbox unchecked: " + checkboxName, false, false);
            } else {
                logManager.logWarning("Checkbox is already unchecked: " + checkboxName, true, true);
            }

        } catch (Exception e) {
            logManager.logError("Exception while unchecking the checkbox: " + checkboxName);
            logManager.logException(e, true, true);

            logManager.addScreenshot(driverManager, "Failed_uncheckTheCheckbox");

            Assert.fail("Failed to uncheck the checkbox: " + checkboxName + " : " + e.getMessage());
        }
    }

    public boolean isCheckboxChecked(WebElement checkbox, String checkboxName) {
        boolean result = false;

        try {
            result = checkbox.isSelected();

        } catch (Exception e) {
            logManager.logError(
                    "Exception while checking if checkbox: " + checkboxName + " is checked: " + e.getMessage());

            logManager.addScreenshot(driverManager, "Failed_isCheckboxChecked");
        }

        return result;
    }

    public void setDefaultDriverTimeout(int seconds) {
        driverManager.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void setDefaultDriverTimeout() {
        driverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Wait Related Methods
    public boolean waitForElementVisible(WebElement element, int timeoutInSeconds, String elementName) {
        boolean result = false;
        logManager.logInformation("Waiting for element to be visible: " + elementName, false, false);

        try {
            WebDriverWait wait = driverManager.getWebDriverWait(timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            setDefaultDriverTimeout();

            result = element.isDisplayed();

        } catch (Exception e) {
            logManager.logError("WebElement is not visible: " + elementName);

            logManager.addScreenshot(driverManager, "Failed_waitForElementVisible");
        }

        return result;
    }

    public void waitForElementInvisible(WebElement element, int timeoutInSeconds, String elementName) {

        setDefaultDriverTimeout(1);

        BrowserActions browserAction = new BrowserActions(driverManager);

        boolean isElementShowing = browserAction.isElementDisplayed(element, elementName);

        if (isElementShowing) {
            logManager.logInformation("Element  is showing and waiting till it gets disappear: " + elementName, false,
                    false);

            // WebDriverWait and Expected Conditions don't work here. It waits for the full
            // time though element is not showing on the page.
            // driverManager getWebDriverWait (timeoutInSeconds) until(Expected
            // Conditions invisibilityOf (element) )

            int count = 1;
            while (isElementShowing && count < (timeoutInSeconds * 4)) {
                try {
                    Thread.sleep(250);
                    isElementShowing = browserAction.isElementDisplayed(element, elementName);
                    count++;
                } catch (Exception e) {
                    isElementShowing = false;
                    break;
                }
            }

            if (isElementShowing) {
                logManager.logWarning(
                        "Element  didn't disappear within timeout  seconds" + elementName + " " + timeoutInSeconds,
                        true, true);

                logManager.addScreenshot(driverManager, "Warning_elementStillVisible");

                // Try one more time to get element disappear
                logManager.logInformation("Waiting again to get element: " + elementName + " disappear.", false, false);

                try {
                    driverManager.getWebDriverWait(timeoutInSeconds).until(ExpectedConditions.invisibilityOf(element));
                } catch (Exception e) {
                    logManager.logError(elementName + " hasn't disappeared from the page.");
                    logManager.addScreenshot(driverManager, "Failed_elementStillVisible");
                }

            }

        } else {
            logManager.logInformation("Element is not showing on the page. " + elementName, false, false);

        }

        setDefaultDriverTimeout();
    }

    public void waitForPageLoadCompletes(int timeoutInSeconds) {
        logManager.logInformation("Waiting for page load to complete.", false, false);

        try {

            driverManager.getWebDriverWait(timeoutInSeconds).until(
                    dvr -> ((JavascriptExecutor) dvr).executeScript("return document.readyState").equals("complete"));

            driverManager.getWebDriverWait(timeoutInSeconds).until(dvr -> ((JavascriptExecutor) dvr).executeScript(
                    "return if(typeof(window.jQuery) != \"undefined\") {window.jQuery.active == 0} else {document.readyState == \"complete\"}"));

        } catch (Exception e) {
            setDefaultDriverTimeout();
        }

    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);

        } catch (Exception e) {
            logManager.logInformation("Exception while waiting for seconds: " + seconds, false, false);
            e.printStackTrace();
        }
    }

    /**
     * This method will wait for alert to show on the page for the number of seconds
     * specified in the parameter. If alert doesn't show on the page then it will
     * log exception but won't fail the test.
     * 
     * @param waitTimeInSeconds This wait time in number of seconds
     */
    public void waitForAlertToShowOnPage(int waitTimeInSeconds) {

        try {
            driverManager.getWebDriverWait(waitTimeInSeconds).until(ExpectedConditions.alertIsPresent());

            driverManager.getDriver().switchTo().alert();

        } catch (NoAlertPresentException e) {
            logManager.logInformation(
                    "Alert is not present on the page after waiting for seconds: " + waitTimeInSeconds, false, false);

            logManager.addScreenshot(driverManager, "Failed_waitForAlertToShowOnPage");
        }
    }

    public void waitForURLContains(String url, int timeoutInseconds) {
        try {
            driverManager.getWebDriverWait(timeoutInseconds).until(ExpectedConditions.urlContains(url));

        } catch (Exception e) {
            logManager.logError("Exception while redirecting to URL " + url);
            logManager.addScreenshot(driverManager, "Failed_waitForURLContains");
        }
    }

    public String getMonthName(String monthNameOrIndex) {
        try {

            int monthIndex = Integer.parseInt(monthNameOrIndex);

            if (monthIndex > 0 && monthIndex < 13) {
                switch (Integer.parseInt(monthNameOrIndex)) {
                case 2:
                    return "February";
                case 3:
                    return "March";
                case 4:
                    return "April";
                case 5:
                    return "May";
                case 6:
                    return "June";
                case 7:
                    return "July";
                case 8:
                    return "August";
                case 9:
                    return "September";
                case 10:
                    return "October";
                case 11:
                    return "November";
                case 12:
                    return "December";
                case 1:
                default:
                    return "January";
                }

            } else
                return "January";

        } catch (Exception e) {

            return monthNameOrIndex;
        }
    }
    
    /**
     * Method will use to wait till the element is not clickable
     * @param element
     * @param timeoutInSeconds
     * @param elementName
     * @return
     */
	public boolean waitForElementClickable(WebElement element, int timeoutInSeconds, String elementName) {
		boolean result = false;
		logManager.logInformation("Waiting for element to be Clickable: " + elementName, false, false);

		try {
			driverManager.getWebDriverWait(timeoutInSeconds)			
			.pollingEvery(Duration.ofMillis(100))
			.ignoring(WebDriverException.class) 
			.until(ExpectedConditions.elementToBeClickable(element));						
			result = element.isEnabled();

		} catch (Exception e) {
			logManager.logInformation("WebElement is not Clickable: " + elementName, true, false);

			logManager.addScreenshot(driverManager, "Failed_waitForElementClickable");
		}

		return result;
	}

	/**
	 * Method will wait for grid table to load
	 * @param timeoutInSeconds
	 * @return true if grid is loaded correctly in expected time else false
	 */
	public boolean waitForGridToLoad(WebElement activeGridTableRow, int timeoutInSeconds) {
		
		boolean result = false;
	
		result = driverManager.getWebDriverWait(timeoutInSeconds)
				.until(
                ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(activeGridTableRow, "Loading items...")));
		
		if(result)
			return true;
		else {
			logManager.logError("Grid table is not loaded, taking longger time as expected.");
			return false;
		}			
	}

    /**
     * Method is used to check expected text is visible or not
     * @param element
     * @param text_to_be_visible
     * @param timeoutInSeconds
     * @return true if text visible else false
     */
    public boolean waitForVisibilityOfElementText(WebElement element, String text_to_be_visible, int timeoutInSeconds) {
        return driverManager.getWebDriverWait(timeoutInSeconds)
                .until(ExpectedConditions.textToBePresentInElement(element, text_to_be_visible));
    }
    // This method is used to right click on an element
    public void rightClickElement(WebElement element, String elementName) {

        try {
            Actions action = driverManager.getActions();
            action.contextClick(element).build().perform();
            logManager.logInformation("right click on element: " + elementName, true, false);

        } catch (Exception e) {
            logManager.logError("Exception while hovering on element: " + elementName);

            logManager.addScreenshot(driverManager, "Failed_hoverElement");

            Assert.fail("Failed to hover on the element: " + elementName + " : " + e.getMessage());
        }
    }
  
   
    public void dragNdrop(WebElement element, String elementName,WebElement element1, String element1Name) {

        try {
            Actions action = driverManager.getActions();
        //  action.dragAndDrop(element, element1);
          action.clickAndHold(element).moveToElement(element1).release(element1).build().perform();
          
            logManager.logInformation("Drag and Drop  element: " + elementName, true, false);
        
        } catch (Exception e) {
            logManager.logError("Exception while Drag and Drop element: " + elementName);

            logManager.addScreenshot(driverManager, "Failed to Drag and Drop");
           
            Assert.fail("Failed to Drag and Drop element: " + elementName + " : " + e.getMessage());
        }
    }

}
