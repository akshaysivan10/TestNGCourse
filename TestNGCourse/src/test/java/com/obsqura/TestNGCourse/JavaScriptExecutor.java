package com.obsqura.TestNGCourse;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends Base {

	@Test
	public void javaScriptExecutorSample() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement singleInputTextField = driver.findElement(By.id("single-input-field"));
		executor.executeScript("arguments[0].value='Akshay';", singleInputTextField);
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		executor.executeScript("arguments[0].click();", showMessageButton);
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageText = yourMessage.getText();
	}
	
	@Test
	public void scroll() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,100)", "");
	}
}
