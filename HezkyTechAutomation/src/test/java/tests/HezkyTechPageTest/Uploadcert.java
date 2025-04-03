
package tests.HezkyTechPageTest;
import tests.HezkyTechPageTest.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Uploadcert {

    private WebDriver driver;
    private  ExcelReader excelReader;

    @Test
    public void simulateLogin() throws InterruptedException {
        // 1. Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        excelReader= new ExcelReader();
        // 2. Navigate to the login page
        driver.get("http://128.199.29.37:9009/#/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // 3. Perform login
        driver.findElement(By.xpath("//input[@placeholder='Email ID']"))
              .sendKeys("walid.ansari@hezkytech.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
              .sendKeys("Hk$3gk7N");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit']//span)[1]")).click();
        Thread.sleep(2000);

        // 4. Navigate to Certificate Management
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[contains(text(),' Certificate Management ')]"))
              .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-target='#add_certificate']")).click();
        Thread.sleep(2000);
        // 5. Read All Rows from Excel
        String filePath = "C:\\Users\\vaibh\\OneDrive\\Desktop\\Upload\\uploadcertificate.xlsx";
        List<String[]> allCertificateData = ExcelReader.getAllCertificateData(filePath);

        // 6. Iterate through each row of data
        for (String[] certificateData : allCertificateData) {
            // For clarity, let's assign each column to a variable
            String externalSensorValue = certificateData[0];
            String calibrationDateValue = certificateData[1];
            String expiryDateValue = certificateData[2];
            String certificateFilePath = certificateData[3];

            // 7. Open the "Add Certificate" modal for each iteration
            

            // External Sensor
            WebElement externalSensorInput = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
            externalSensorInput.clear();
            externalSensorInput.sendKeys(externalSensorValue);
            Thread.sleep(1000);

            // Calibration Date
            WebElement calibrationDateInput = driver.findElement(By.xpath("//input[@formcontrolname='calibration_date']"));
            calibrationDateInput.clear();
            calibrationDateInput.sendKeys(calibrationDateValue);
            Thread.sleep(1000);

            // Expiry Date
            WebElement expiryDateInput = driver.findElement(By.xpath("//input[@formcontrolname='expiry_date']"));
            expiryDateInput.clear();
            expiryDateInput.sendKeys(expiryDateValue);
            Thread.sleep(1000);

            // Upload Certificate
            WebElement uploadCertificateButton = driver.findElement(By.xpath("//input[@type='file']"));
            uploadCertificateButton.sendKeys(certificateFilePath);
            Thread.sleep(2000);

            // 8. Click Submit
            driver.findElement(By.xpath("//button[text()='Submit']")).click();
            Thread.sleep(3000);

            // Optionally, you could add a validation step here to confirm success
        }

        // 9. Cleanup
        driver.quit();
    }
}
