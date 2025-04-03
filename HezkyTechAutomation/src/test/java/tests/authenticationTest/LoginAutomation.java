package tests.authenticationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LoginAutomation {

	public static void simulateLogin(String userCustomerID ,String userEmail, String userPassword) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(options);

			String loginUrl = "https://dev.hezkytech.com/#/login";
			driver.get(loginUrl);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			WebElement customerIDFiled = driver.findElement(By.id("customer_id"));
			customerIDFiled.clear();
			customerIDFiled.sendKeys(userCustomerID);
			WebElement emailField = driver.findElement(By.id("email")); // Adjust the locator
			emailField.clear();
			emailField.sendKeys(userEmail);

			WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator
			passwordField.clear();
			passwordField.sendKeys(userPassword);

			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(30000);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println(driver.getCurrentUrl());

			if (driver.getCurrentUrl().contains("dashboard")) {
				System.out.println("Login successful for: " + userEmail);
			} else {
				System.out.println("Login failed for: " + userEmail);
			}
		} catch (Exception e) {
			System.out.println("Error during login for: " + userEmail + " - " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(100);

		for (int userIn = 1; userIn <= 100; userIn++) {
			final String userCustomerID = "05";
			final String userEmail = "hezkyuser" + userIn + "@mailinator.com";
			final String userPassword = "Hezky@123"; 

			executorService.submit(() -> simulateLogin(userCustomerID,userEmail, userPassword));
		}

		executorService.shutdown();
		try {
			if (!executorService.awaitTermination(60, TimeUnit.MINUTES)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
		}
	}
}
