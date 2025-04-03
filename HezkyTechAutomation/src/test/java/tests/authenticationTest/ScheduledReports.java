package tests.authenticationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScheduledReports {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);

		String loginUrl = "https://hezkytech.com/#/login";
		driver.get(loginUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement emailField = driver.findElement(By.id("email")); // Adjust the locator
		emailField.clear();
		emailField.sendKeys("vaibhav.hulule@hezkytech.com");

		driver.manage().window().maximize();
		WebElement passwordField = driver.findElement(By.id("password")); // Adjust the locator
		passwordField.clear();
		passwordField.sendKeys("Hezky@123");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		
		driver.close();

	}

}
