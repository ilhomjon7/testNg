package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleValidation {

	WebDriver driver;
	
@BeforeTest
public void openBrawser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://facebook.com");
	
}

@Test(priority = 0)
public void verifyTitle() {
	String expectedTitle = "Facebook - Log In or Sign Up";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	
}

@Test(priority = 1)
public void verifyTest1() {
	String expectedText = "Connect with friends and the  world around you on Facebook.";
	String actualText = driver.findElement(By.cssSelector("#content > div > div > div > div > div._7d._6_._76 > h2")).getText();
	Assert.assertEquals(actualText, expectedText);
	
}

@Test(priority = 2)
public void verifyTest2() {
	String expectedText = "Sign Up";
	String actualText = driver.findElement(By.cssSelector("#content > div > div > div > div > div._6_._74 > h2")).getText();
	Assert.assertEquals(actualText, expectedText);
	

}
@Test(priority = 3)
public void verifyRadioButton() {
	boolean radioButtonStatus = driver.findElement(By.id("u_0_c")).isSelected();
Assert.assertFalse(radioButtonStatus);
}

@AfterTest
public void closeBrawese() throws InterruptedException {
	Thread.sleep(5000);
	driver.close();
}

}
