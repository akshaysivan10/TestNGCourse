package com.obsqura.TestNGCourse;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectClass extends Base {
	
	@Test
	public void selectClass() {
		
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		select.selectByValue("Green");
		select.selectByVisibleText("Yellow");
		List<WebElement> options = select.getOptions();
	}
	
	@Test
	public void selectValueFromLanguageDropDown() {
		
		driver.navigate().to("https://www.selenium.dev/");
		String expectedValue = "Português (Brasileiro)";
		driver.findElement(By.xpath("//div[@class='dropdown']//child::a[@data-bs-toggle=\"dropdown\"]")).click();
		List<WebElement> languagesList = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu')]//child::a[@class='dropdown-item']"));
		for(WebElement languages: languagesList) {
			String languagesText = languages.getText();
			if(languagesText.equals(expectedValue)) {
				languages.click();
				break;
			}
	    }
   }
}
