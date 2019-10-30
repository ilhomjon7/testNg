package demo;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinkedValidation {
	WebDriver driver;
	
	@BeforeTest 
	@Parameters("browser")
	
	
	public void openBrowser(String browser) {
	if(browser.equals("Chrome")) {
		driver = new ChromeDriver();
		}
	else if (browser.equals("Edge")) {
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.linkedin.com");
	}
	@Test (priority =0)
	public void  verifyTitle() {
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
	 Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test (priority =1)
	public void verifyText() {
		String expectedText = "Be great at what you do";
		String actualText = driver.findElement(By.cssSelector("#regForm > h2")).getText();
		Assert.assertEquals(actualText, expectedText);
}
	
	@Test (priority =2)
	public void verifySingInButtonVisibility() {
		boolean singvisibale = driver.findElement(By.id("login-submit")).isDisplayed();
		Assert.assertTrue(singvisibale);
	}
	
	@Test (priority =3)
	public void verifySingInButtonAnable() {
		boolean singbuttonAnable = driver.findElement(By.id("login-submit")).isEnabled();
		Assert.assertFalse(singbuttonAnable);
	}
	
	@Test (priority =4)
	public void verifySeachButton() {
		boolean searchAnable = driver.findElement(By.name("search")).isEnabled();
	Assert.assertFalse(searchAnable);
	
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	
	

}
