package org.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
	WebDriver driver;
	
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
	}
	By searchbox = By.xpath("//textarea[@name='q']");
	By searchBtn = By.xpath("//input[@value='Google Search'][1]");
	
	public void search(String searchinput) {
		driver.findElement(searchbox).sendKeys(searchinput);
		driver.findElement(searchBtn).submit();
	}
}
