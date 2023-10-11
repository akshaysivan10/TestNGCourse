package com.obsqura.TestNGCourse;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowHandling extends Base {
	
	@Test
	public void windowHandling() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/window-popup.php");
		WebElement likeUsOnFacebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/obsqurazone/']"));
		likeUsOnFacebook.click();
		String idOfMainWindow = driver.getWindowHandle();
		Set<String> idsOfAllOpenedWindows = driver.getWindowHandles();
		Iterator<String> i1 = idsOfAllOpenedWindows.iterator();		
		
        while(i1.hasNext()) {
        	String childWindow = i1.next();
        	if(!idOfMainWindow.equalsIgnoreCase(childWindow)) {
        		driver.switchTo().window(childWindow);
        		WebElement login = driver.findElement(By.xpath("//div[@class='x1c436fg']//child::div[@role='button']"));
        		login.click();
        	}
        }
        
		
	}

}