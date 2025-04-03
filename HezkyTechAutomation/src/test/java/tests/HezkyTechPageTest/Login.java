package tests.HezkyTechPageTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Login {

	private WebDriver driver;

	@Test
	public void simulateLogin() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vaibh\\eclipse-workspace\\ABC\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Vaibhav Personal\\SELENIUM\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);

//		driver.get("http://hezky-uat.s3-website.ap-south-1.amazonaws.com/#/dashboard");
//		driver.findElement(By.xpath("//input[@placeholder='Customer ID']")).sendKeys("51");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("vaibhav@sovtechnologies.com");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Hezky@123");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
		
		driver.get("http://128.199.29.37:9009/#/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("walid.ansari@hezkytech.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Hk$3gk7N");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit']//span)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[contains(text(),' Certificate Management ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-target='#add_certificate']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
		Thread.sleep(2000);
		
		WebElement externalSensor= driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		
//		File file =new File("D:\\Tested File-PlannedStartEnd.xlsx");
		File file =new File("C:\\Users\\vaibh\\OneDrive\\Desktop\\Upload\\uploadcertificate.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheetAt(0);
		Thread.sleep(2000);
		String cellValue= sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(cellValue);
		externalSensor.sendKeys(cellValue);
		Thread.sleep(10000);
		
	
		
	
		
	}
		
	}