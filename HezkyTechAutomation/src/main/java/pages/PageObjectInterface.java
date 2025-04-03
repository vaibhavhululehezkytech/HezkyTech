package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.webdrivers.DriverManager;

/**
 * A basic interface for all page objects.
 *
 * The intent of this interface is to abstract common patterns found within all
 * PageObjects.
 */
public interface PageObjectInterface {

    /**
     * All page objects will initialize their elements using Selenium PageFactory
     *
     * @param driverManager The DriverManager instance
     */
    void initElements(DriverManager driverManager);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given text field.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "TextField", ex: legalFirstNameTextField.
     *
     * @param field The text field we wish to retrieve
     * @return It will return text field webelement
     */
    WebElement getTextField(String field);
    WebElement getTextArea(String Area);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given drop down.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Dropdown", ex: stateDropdown.
     *
     * @param field The drop down we wish to retrieve
     * @return It will return drop down webelement
     */
    WebElement getDropDown(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given button.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Button", ex: studentNextButton.
     *
     * @param field The button we wish to retrieve
     * @return It will return web element of type Button
     */
    WebElement getButton(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given image.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Image", ex: castleBranchLogoImage.
     *
     * @param field The Image we wish to retrieve
     * @return It will return web element of type Image
     */
    WebElement getImage(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given text.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Text", ex: pageHeaderSignIntitleText.
     *
     * @param field The Text we wish to retrieve
     * @return It will return text
     */
    WebElement getText(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given Link.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Link", ex: announcementsPopupClickHereLink.
     *
     * @param field The Link we wish to retrieve
     * @return It will return web element of type Link
     */
    WebElement getLink(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given Checkbox.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "CheckBox", ex: primaryAddressCheckbox.
     *
     * @param field The Check Box we wish to retrieve
     * @return It will return web element of type check box
     */
    WebElement getCheckBox(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given list.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "List", ex: columnHeaderList.
     *
     * @param field The list we wish to retrieve
     * @return It will return list of Web Elements
     */
    List<WebElement> getList(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given Option.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Option", ex: myBridgesMenuOption.
     *
     * @param field The Option(drop down/Menu option) we wish to retrieve
     * @return It will return drop down/Menu Options
     */
    WebElement getOption(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given date picker.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "DatePicker", ex: rotationStartDatePicker.
     *
     * @param field The Date Picker we wish to retrieve
     * @return It will return web element of type Date Picker
     */
    WebElement getDatePicker(String field);

    /**
     * This method uses the established naming convention and reflection to retrieve
     * the given data.
     *
     * A class attribute must be defined as public / static and be of type
     * WebElement. The class attribute must be named using camelCase and have a
     * suffix of "Data", ex: educationExperienceUnorderedListData.
     *
     * @param field The Data we wish to retrieve
     * @return It will return data of page we wish to retrieve
     */
    WebElement getData(String field);
    

}
