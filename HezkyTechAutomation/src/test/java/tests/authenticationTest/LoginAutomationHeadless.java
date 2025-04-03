package tests.authenticationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginAutomationHeadless {

    // Thread-safe counters to track successful and failed logins
    private static AtomicInteger successCount = new AtomicInteger(0);
    private static AtomicInteger failureCount = new AtomicInteger(0);

    // Function to simulate login for a user
    public static void simulateLogin(String userEmail, String userPassword) {
        WebDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");

            // Enable headless mode
            options.addArguments("--headless"); // Runs Chrome in headless mode
            options.addArguments("--disable-gpu"); // Applicable to Windows environments
            options.addArguments("--window-size=1920,1080"); // Set window size if needed
            
            driver = new ChromeDriver(options);

            String loginUrl = "http://hezky-uat.s3-website.ap-south-1.amazonaws.com/#/login";
            driver.get(loginUrl);
//            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Find and interact with the email and password fields
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.clear();
            emailField.sendKeys(userEmail);

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(userPassword);

            Thread.sleep(2000);

            // Submit the form
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            Thread.sleep(2000);
//            driver.findElement(By.xpath("//a[text()=' Assets ']")).click();
            Thread.sleep(5000);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            // Check if login was successful
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Login successful for: " + userEmail);
                successCount.incrementAndGet(); // Increment success counter
            } else {
                System.out.println("Login failed for: " + userEmail);
                failureCount.incrementAndGet(); // Increment failure counter
            }
        } catch (Exception e) {
            System.out.println("Error during login for: " + userEmail + " - " + e.getMessage());
            failureCount.incrementAndGet(); // Treat exception as failure
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        // Loop to create tasks for login simulation
        for (int userIn = 1; userIn <= 50; userIn++) {
            final String userEmail = "hezkyuser" + userIn + "@mailinator.com";
            final String userPassword = "Hezky@123"; // Same password for all users

            executorService.submit(() -> simulateLogin(userEmail, userPassword));
        }

        // Shutdown the executor service and wait for tasks to finish
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }

            // Log results
            System.out.println("Total logins attempted: " + (successCount.get() + failureCount.get()));
            System.out.println("Successful logins: " + successCount.get());
            System.out.println("Failed logins: " + failureCount.get());

            // Write the report to a CSV file
            writeReportToFile(successCount.get(), failureCount.get());

        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    // Method to write report to a CSV file
    public static void writeReportToFile(int successCount, int failureCount) {
        String reportFilePath = "login_report_AWS-050_UserHeadless.csv";
        try (FileWriter writer = new FileWriter(reportFilePath)) {
            writer.append("Total Logins,Successful Logins,Failed Logins\n");
            writer.append(String.valueOf(successCount + failureCount)).append(",");
            writer.append(String.valueOf(successCount)).append(",");
            writer.append(String.valueOf(failureCount)).append("\n");

            System.out.println("Report written to " + reportFilePath);
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
