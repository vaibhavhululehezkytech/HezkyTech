package tests.authenticationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Outlook {

	private WebDriver driver;

	@Test(dataProvider = "loginData")
	public void simulateLogin(String userEmail, String userPassword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
		// ="http://hezky-uat.s3-website.ap-south-1.amazonaws.com/#/dashboard";
		String loginUrl = "https://outlook.office.com/mail/inbox/";
		driver.get(loginUrl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vaibhav@sovtechnologies.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Survik@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='topSearchInput']")).sendKeys("alert@hezkytech.com" + Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='alert@hezkytech.com'])[1]")).click();
		Thread.sleep(3000);

		WebElement otpMessageElement = driver.findElement(By.xpath("(//h2[text()='Hello vaibhav']//following::h4)[2]"));
		String otpMessage = otpMessageElement.getText();

		Thread.sleep(3000);
		String otp = otpMessage.replaceAll("[^0-9]", "");
		if (otp.isEmpty()) {
			System.out.println("No OTP found.");
		} else {
			System.out.println("Extracted OTP: " + otp);
		}

	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] { { "vaibhav@sovtechnologies.com", "Survik@123" },

		};
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
