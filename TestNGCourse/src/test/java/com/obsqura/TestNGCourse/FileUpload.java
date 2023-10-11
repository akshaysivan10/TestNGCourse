package com.obsqura.TestNGCourse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload extends Base{
	
	@Test
	public void fileUpload() {
		
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
		chooseFile.sendKeys("C:\\Users\\asus\\Desktop\\Obsqura Training\\Automation Testing\\Test.docx");
	}
	
	@Test
	public void fileUploadUsingRobotClass() throws AWTException {
		
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.id("pickfiles")).click();
		Robot robot = new Robot();
		StringSelection filepath=new StringSelection("C:\\Users\\asus\\Downloads\\cssSelector.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  //wait for the file to get uploaded
		  robot.delay(2000);
	}

}
