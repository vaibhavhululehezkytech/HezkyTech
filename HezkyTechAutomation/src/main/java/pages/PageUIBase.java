package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.webdrivers.DriverManager;
import java.lang.reflect.Field;
import java.util.List;

public abstract class PageUIBase implements PageObjectInterface {

    /**
     * All page objects will initialize their elements using Selenium PageFactory
     *
     * @param driverManager The DriverManager instance
     */
    public void initElements(DriverManager driverManager) {
        PageFactory.initElements(driverManager.getDriver(), this.getClass());
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given text field.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "TextField", ex: legalFirstNameTextField.
     *
     * @param field The text field we wish to retrieve
     */
    public WebElement getTextField(String field) {
        return getElement(field.concat("TextField"));
    }
    public WebElement getTextArea(String field) {
    	return getElement(field.concat("TextArea"));
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given image(logo).
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Image", ex: castleBranchLogoImage.
     *
     * @param field The Image we wish to retrieve
     */
    public WebElement getImage(String field) {
    	return getElement(field.concat("Image"));
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given text.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Text", ex: pageHeaderSignIntitleText.
     *
     * @param field The Text we wish to retrieve
     */
    public WebElement getText(String field) {
    	return getElement(field.concat("Text"));
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given Link.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Link", ex: announcementsPopupClickHereLink.
     *
     * @param field The Link we wish to retrieve
     */
    public WebElement getLink(String field) {
    	return getElement(field.concat("Link"));
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given drop down.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Dropdown", ex: stateDropdown.
     *
     * @param field The drop down we wish to retrieve
     */
    public WebElement getDropDown(String field) {
        return getElement(field.concat("Dropdown"));
    }

    /**
     * This method uses the established naming convention and reflection to retrieve the given button.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Button", ex: studentNextButton.
     *
     * @param field The button we wish to retrieve
     */
    public WebElement getButton(String field) {
        return getElement(field.concat("Button"));
    }
    
    /**
     * This method uses the established naming convention and reflection to retrieve the given Checkbox.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "CheckBox", ex: primaryAddressCheckbox.
     *
     * @param field The Check Box we wish to retrieve
     */
    public WebElement getCheckBox(String field) {
        return getElement(field.concat("CheckBox"));
    }
    
    /**
     * This method uses the established naming convention and reflection to retrieve the given Option.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Option", ex: myBridgesMenuOption.
     *
     * @param field The Option(drop down/Menu option) we wish to retrieve
     */
    public WebElement getOption(String field)
    {
        return getElement(field.concat("Option"));
    }
    
    /**
     * This method uses the established naming convention and reflection to retrieve the given date picker.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "DatePicker", ex: rotationStartDatePicker.
     *
     * @param field The Date Picker we wish to retrieve
     */
    public WebElement getDatePicker(String field)
    {
        return getElement(field.concat("DatePicker"));
    }
    
    /**
     * This method uses the established naming convention and reflection to retrieve the given list.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "List", ex: columnHeaderList.
     *
     * @param field The list we wish to retrieve
     */
    public List<WebElement> getList(String field)
    {
        return getElements(field.concat("List"));
    }
    
    /**
     * This method uses the established naming convention and reflection to retrieve the given data.
     *
     * A class attribute must be defined as private or public / static and be of type WebElement. The class attribute
     * must be named using camelCase and have a suffix of "Data", ex: educationExperienceUnorderedListData.
     *
     * @param field The Data we wish to retrieve
     */
    public WebElement getData(String field)
    {
        return getElement(field.concat("Data"));
    }
    
    

    /**
     * This method encapsulates common code used to retrieve a WebElement from a PageObject class.
     *
     * @param elementName The class attribute name of the element we wish to retrieve
     * @return The WebElement found by the given elementName
     */
    private WebElement getElement(String elementName) {

        WebElement element = null;

        try {
            Field uiField = this.getClass().getDeclaredField(elementName);            
            uiField.setAccessible(true);
            element = (WebElement) uiField.get(null);

        } catch (NoSuchFieldException e) {

            // This is not a failing assertion, this exception is the result of incorrect class property declaration
            Assert.fail("Class attribute not defined on class, attribute is ".concat(elementName), e);

        } catch (IllegalAccessException e) {

            // This is not a failing assertion, this exception is the result of incorrect class property declaration
            Assert.fail("Class attribute should be declared private or public, attribute is ".concat(elementName), e);
        }

        return element;
    }
    
    /**
     * This method encapsulates common code used to retrieve a List<WebElement> from a PageObject class.
     *
     * @param elementName The class attribute name of the element we wish to retrieve
     * @return The List<WebElement> found by the given elementName
     */
    @SuppressWarnings("unchecked")
    private List<WebElement> getElements(String elementName) {

        List<WebElement> element = null;
        
        try
        {
            Field uiField = this.getClass().getDeclaredField(elementName);
            uiField.setAccessible(true);
            element = (List<WebElement>) uiField.get(null);

        } catch (NoSuchFieldException e) {

            // This is not a failing assertion, this exception is the result of incorrect class property declaration
            Assert.fail("Class attribute not defined on class, attribute is ".concat(elementName), e);

        } catch (IllegalAccessException e) {

            // This is not a failing assertion, this exception is the result of incorrect class property declaration
            Assert.fail("Class attribute should be declared private or public, attribute is ".concat(elementName), e);
        }

        return element;
    }
}
