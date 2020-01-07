package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		//driver.get("https://facebook.com");
		driver.get("https://admin97672.wixsite.com/mysite");
		
	}
	
	@Test	
	public void titleVerification() {
		//driver.findElement(By.name("search")).sendKeys("aad");
			String x = driver.findElement(By.xpath("//span[text()='WHY RUSLAN CARS']")).getText();
		//driver.findElement(By.cssSelector("#SearchBox1846-inputwithoptions > div > div > button.buttonnext4131183088--root.Focusable2375082276--root.SearchBox61359390--button > span")).click();	
		String b = "Why no m";
		if (x==b) {
			System.out.println("passed");
			}
			else {
			
			System.out.println("faild");
			}
	}
	//span[@class = 'buttonnext4131183088--content']
//	@AfterTest
//	public void closeBrowser() throws InterruptedException{
//		Thread.sleep(6000);
//		driver.close();
//		
//	}
	
	

	
	}

