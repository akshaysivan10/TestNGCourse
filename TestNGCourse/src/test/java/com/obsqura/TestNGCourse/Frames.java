package com.obsqura.TestNGCourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frames extends Base {

	@Test
	public void handlingFrames() {
		
		driver.navigate().to("https://demo.guru99.com/test/guru99home/");
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		driver.switchTo().frame(iFrame);
		//driver.switchTo().frame("a077aa5e");
		WebElement jMeterElement = driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
		jMeterElement.click();
	}
}
