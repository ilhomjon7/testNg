package demo;

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
		driver.get("https://facebook.com");
		
		
	}
	
	@Test	
	public void titleVerification() {
			String expectedTitle = "Facebook - Log In or Sign Up";
			String actualTitle= driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
		
	}
	
	

	
	}

