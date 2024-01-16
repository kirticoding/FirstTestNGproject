package org.seleniumExample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebTable {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	//*[@id="customers"]
	////*[@id="customers"]/tbody/tr[4]/td[1]
	////*[@id="customers"]
	@Test(priority = 1)
	public void testWebTables() {
		String beforeXPath = "//*[@id='customers']/tbody/tr[";
		String afterXPath = "]/td[1]";
		List<WebElement> tablerows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		int rownos = tablerows.size();
		for (int i=2; i<= rownos; i++) {
			String actualXpath = beforeXPath+i+afterXPath;
			WebElement rowElem = driver.findElement(By.xpath(actualXpath));
			System.out.println(rowElem.getText());
			

		}
		
		
	}
	
}
