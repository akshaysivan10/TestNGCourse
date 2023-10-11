package com.obsqura.TestNGCourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alerts extends Base{

	@Test
	public void alertsSample() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickMe = driver.findElement(By.xpath("(//button[text()='Click me!'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickMe));
		clickMe.click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		WebElement clickMe2 = driver.findElement(By.xpath("//button[contains(@class,'btn-warning')]"));
		clickMe2.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		WebElement promptBox =driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		promptBox.click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(promptBox));
		driver.switchTo().alert().sendKeys("Akshay");
		driver.switchTo().alert().accept();
	}
}
