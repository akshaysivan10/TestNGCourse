package com.obsqura.TestNGCourse;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FindElements extends Base {
	
	@Test
	public void listOfElements() {
		
		String input = "Radio Buttons Demo";
		List<WebElement> menu = driver.findElements(By.xpath("//ul[contains(@class,'list-group-flush')]//a"));
		for(WebElement category: menu) {
			String menuText = category.getText();
			if(menuText.equals(input)) {
				category.click();
				break;
			}
		}
	}
	
	@Test
	public void verifyTheHeaderAndFindTheNoOfColumnsInTheTable() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/table-pagination.php");
		
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Name");
		expectedList.add("Position");
		expectedList.add("Office");
		expectedList.add("Age");
		expectedList.add("Start date");
		expectedList.add("Salary");
		int expectedNoOfColumns = expectedList.size();
		
		List<WebElement> tableHeaderList = driver.findElements(By.xpath("//th[contains(@class,'th-sm')]"));
		List<String> actualList = new ArrayList<String>();
		for(WebElement tableHeader: tableHeaderList) {
			String tableHeaderText = tableHeader.getText();
			actualList.add(tableHeaderText);
		}
		boolean headerList = actualList.equals(expectedList);
		assertEquals(expectedList, actualList, "The actual list is not matching with the expected list");
	
		//Find the no of columns in the table
		
		int noOfColumns = tableHeaderList.size();
		System.out.println(noOfColumns);
		assertEquals(expectedNoOfColumns, noOfColumns, "The expected no of coloumns does not match with the actual no");
	}
	
	@Test
	public void verifyWhetherAshtonCoxIsAvailable() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/table-pagination.php");
		String expectedValue = "Ashton Cox";
		List<WebElement> tableList = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']//td[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(tableList));
		for(WebElement table: tableList) {
		String tableListText = table.getText();
		if(tableListText.equals(expectedValue)) {
			assertEquals(expectedValue, tableListText, expectedValue + " is not available");
			break;
		}
		
	   }
	}
}
