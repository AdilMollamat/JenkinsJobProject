package com.framework.wellstest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JenkinsTest {

	public static WebDriver driver;
	
	@BeforeTest
	public static void setUp() {
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--start-maximized");
	    chromeOptions.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public static void testSce1() {
		driver.get("https://jqueryUI.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Demos")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(driver.findElement(By.xpath("//h1[text()='jQuery UI Demos']")));
	}
	
	@Test
	public static void testSce2() {
		driver.get("https://jqueryUI.com");
		driver.findElement(By.linkText("Draggable")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(driver.findElement(By.xpath("//h1[text()='Draggable']")));
	}
	
	@Test
	public static void testSce3() {
		driver.get("https://jqueryUI.com");
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2500).build().perform();
		action.scrollToElement(driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Position']"))).build().perform();
//		action.moveToElement(driver.findElement(By.xpath("//div[@id='content']//a[text()='Position']"))).build().perform();
		action.click(driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Position']"))).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(driver.getTitle(), "Position | jQuery UI");
	}
	
	@Test
	public static void testSce4() {
		driver.get("https://jqueryUI.com");
		
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Menu']"))).build().perform();
		action.click(driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Menu']"))).build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(driver.getTitle());
	}
	
	@AfterTest
	public static void closeDown() {
		driver.close();
		driver.quit();
	}
	
}
