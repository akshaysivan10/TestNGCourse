package com.obsqura.TestNGCourse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Eclipse\\AutomationTesting\\src\\main\\java\\com\\obsqura\\AutomationTesting\\Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverClose() {
		//driver.close();
		driver.quit();
	}

}

