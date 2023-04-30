package com.framework.wellstest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser extends AppLibrary {

//	public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://jqueryUI.com");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Demos")).click();
		Thread.sleep(5000);
		Assert.assertNotNull(driver.findElement(By.xpath("//h1[text()='jQuery UI Demos']")));
//		driver.findElement(By.xpath("//span[contains(text(), 'Flights')]")).click();
		
//		
//		// click on from textbox
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[contains(@data-ui-sr, 'location_input_from')]")).click();
//		driver.findElement(By.xpath("//input[@placeholder= 'Airport or city']")).sendKeys("Dallas");
//		driver.findElement(By.xpath("//input[contains(@name, 'CITY')][1]")).click();
//		
//		// click on to textbox
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[contains(@data-ui-sr, 'location_input_to')]")).click();
//		driver.findElement(By.xpath("//input[@placeholder= 'Airport or city']")).sendKeys("New York");
//		driver.findElement(By.xpath("//input[contains(@name, 'CITY')][1]")).click();
//		
//		// click on search button
//		driver.findElement(By.xpath("//span[text() = 'Search']")).click();
		
//		Thread.sleep(5000);
		
//		driver.close();
		driver.quit();
	}
	
	@BeforeTest
	public static void setUp() throws InterruptedException {
//		ChromeOptions chromeOptions = new ChromeOptions();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
		AppLibrary.startBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://jqueryUI.com");
		Thread.sleep(5000);
	}
	@AfterTest
	public static void quitTest() {
		driver.quit();
	}
	
	@Test
	public static void navigateDemos() throws InterruptedException {
		
		driver.findElement(By.linkText("Demos")).click();
		Thread.sleep(5000);
		Assert.assertNotNull(driver.findElement(By.xpath("//h1[text()='jQuery UI Demos']")));
	}
	@Test(dependsOnMethods = "navigateDemos")
	public static void navigateDrag() throws InterruptedException {
		driver.findElement(By.linkText("Draggable")).click();
		Thread.sleep(5000);
		Assert.assertNotNull(driver.findElement(By.xpath("//h1[text()='Draggable']")));
	}
}
