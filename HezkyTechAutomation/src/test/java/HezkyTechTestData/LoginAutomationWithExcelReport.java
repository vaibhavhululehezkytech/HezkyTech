package HezkyTechTestData;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginAutomationWithExcelReport {

    // Workbook and sheet for writing the Excel report
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("Login Results");
    private static int rowNum = 0;

    // Function to simulate login for a user
    public static void simulateLogin(WebDriver driver, String userEmail, String userPassword) {
        String loginStatus;
        try {
            // URL of the login page (replace with actual login page URL)
            String loginUrl = "http://example.com/login";
            driver.get(loginUrl);

            // Wait for page to load
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Find the email input field and enter the email
            WebElement emailField = driver.findElement(By.id("email")); // Adjust the locator
            emailField.clear();
            emailField.sendKeys(userEmail);

            // Find the password input field and enter the password
            WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator
            passwordField.clear();
            passwordField.sendKeys(userPassword);

            // Submit the form (login)
            passwordField.submit();

            // Wait for login to process
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            // Check if login was successful by looking at the current URL or dashboard presence
            if (driver.getCurrentUrl().contains("dashboard")) { // Adjust the condition based on your app
                loginStatus = "Login successful";
            } else {
                loginStatus = "Login failed";
            }
        } catch (Exception e) {
            loginStatus = "Error: " + e.getMessage();
        }
        logResult(userEmail, loginStatus);
    }

    // Function to log the result into Excel
    public static void logResult(String userEmail, String loginStatus) {
        Row row = sheet.createRow(rowNum++);
        Cell emailCell = row.createCell(0);
        Cell statusCell = row.createCell(1);
        
        emailCell.setCellValue(userEmail);
        statusCell.setCellValue(loginStatus);
    }

    // Function to save the Excel file
    public static void saveExcelReport(String filePath) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public static void main(String[] args) {
        // Set the path to the ChromeDriver (ensure ChromeDriver is installed and its path is set here)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Create header row in Excel sheet
        Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Email");
        header.createCell(1).setCellValue("Login Status");

        // Loop to simulate login for 200 users
        for (int userIn = 1; userIn <= 200; userIn++) {
            String userEmail = "HezkyUser" + userIn + "@mailinator.com";
            String userPassword = "Password123"; // Assuming the same password for all users

            // Simulate login for the current user
            simulateLogin(driver, userEmail, userPassword);
        }

        // Close the browser after testing
        driver.quit();

        // Save the Excel report
        try {
            saveExcelReport("LoginReport.xlsx");  // Replace with your desired file path
        } catch (IOException e) {
            System.out.println("Error saving Excel report: " + e.getMessage());
        }

        System.out.println("Login testing completed and report saved.");
    }
}
