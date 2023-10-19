package com.obsqura.TestNGCourse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion extends Base{
	
	@Test
	public void verifyTheYourMessageTextOfSingleInputField() {

		String input = "Hello";
		String expectedMessage = "Your Message : " + input;
		WebElement singleInputTextField = driver.findElement(By.id("single-input-field"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("single-input-field")));
		singleInputTextField.sendKeys(input);
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessageButton.click();
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageText = yourMessage.getText();
		
		assertEquals(expectedMessage, yourMessageText, "Expected Message " + expectedMessage + " is not available");
	}
	
	@Test
	public void assertIsSelected() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleCheckBoxClick = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		singleCheckBoxClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(singleCheckBoxClick));
		boolean isCheckBoxSelected = singleCheckBoxClick.isSelected();
		assertTrue(isCheckBoxSelected, "Single checkbox is not selected");
	}
	
	@Test
	public void assertFalseSample() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleCheckBoxClick = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gridCheck']")));
		boolean isSingleCheckboxSelectedBeforeClick = singleCheckBoxClick.isSelected();
		assertFalse(isSingleCheckboxSelectedBeforeClick, "Single checkbox is selected before click");
	}
	
	@Test
	public void verifyWhetherShowMessageButtonIsAlignedBelowSingleInputField() {
		
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		int yaxisOfShowMessageButton = showMessageButton.getLocation().getY();
		WebElement singleInputTextField = driver.findElement(By.id("single-input-field"));
		int yaxisOfSingleInputField = singleInputTextField.getLocation().getY();
		boolean isShowMessageButtonAlignedBelowSingleInputField = yaxisOfSingleInputField<yaxisOfShowMessageButton;
		assertTrue(isShowMessageButtonAlignedBelowSingleInputField, "Show message button is not aligned below single input field");
	}
	
	@Test
	public void verifyTheTextOfGetTotalButton() {
		
		String expectedMessage = "Get Total";
		WebElement getTotalButton = driver.findElement(By.id("button-two"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("button-two")));
		String getTotalButtonText = getTotalButton.getText();
		assertEquals(expectedMessage, getTotalButtonText, "Expected message " + expectedMessage + " is not available");
	}
	
	@Test
	public void verifyTheTextOfShowMessageButtonIsNotShowMessageButtons() {
		
		String expectedValue = "Show Message Buttons";
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElement(showMessageButton, "Show Message"));
		String showMessageButtonText =  showMessageButton.getText();
		boolean showMessageButtonValue = showMessageButtonText.equals(expectedValue);
		assertFalse(showMessageButtonValue,"The text of Show message button is " + expectedValue );
	}
	
	@Test
	public void verifyTheTextOfShowMessageButtonIsNotEqualToShowMessageButtons() {
		
		String expectedValue = "Show Messages Buttons";
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonText =  showMessageButton.getText();
		boolean showMessageButtonValue = showMessageButtonText.equals(expectedValue);
		assertNotEquals(expectedValue, showMessageButtonValue, "The text of Show message button is " + expectedValue );
	}
	
	@Test
	public void assertNullSample() {
		
		String verifyAssertNull = null;
		assertNull(verifyAssertNull, "The value is not null");
	}
	
	@Test
	public void assertNotNullSample() {
		
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonText =  showMessageButton.getText();
		assertNull(showMessageButtonText, "The value of show message button text is null");
	}
	
	@Test
	public void softAssertSample() {
		
		String expectedValue = "Show Messages 123";
		String color = "rgba(255, 255, 255, 1)";
		SoftAssert softAssert = new SoftAssert();
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonText =  showMessageButton.getText();
		String showMessageButtonFontColor = showMessageButton.getCssValue("color");
		boolean showMessageButtonValue = showMessageButtonText.equals(expectedValue);
		softAssert.assertEquals(expectedValue, showMessageButtonValue,"The text of Show message button is not available");
		softAssert.assertEquals(color, showMessageButtonFontColor, "The colour " + color + "is not available");
		softAssert.assertAll();
	}

}
