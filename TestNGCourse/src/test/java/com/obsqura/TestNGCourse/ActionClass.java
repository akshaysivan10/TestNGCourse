package com.obsqura.TestNGCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass extends Base {

	@Test
	public void actionClass() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/drag-drop.php");
		WebElement draggablen1 = driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		WebElement droppableBox = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(draggablen1).click().perform();
		actions.doubleClick(draggablen1).perform();
		actions.contextClick().perform(); //right click
		actions.clickAndHold().perform();
		actions.dragAndDrop(draggablen1, droppableBox);
	}
}
