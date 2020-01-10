package automation_practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {
	WebDriver driver;
@BeforeTest
public void openBrowser(){
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
	
}
@Test(priority=2)
public void loginWithoutPassword() {
	driver.get("http://www.automationpractice.com");
	driver.findElement(By.xpath("//a[@class='login']")).click();
	driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
	String actualText = driver.findElement(By.xpath("//p[text() = 'There is 1 error']")).getText();
	String expectedText = "There is 1 error";
	Assert.assertEquals(actualText, expectedText);
	String actualMessage = driver.findElement(By.xpath("//li[text() = 'Password is required.']")).getText();
	String expectedMessage = "Password is required.";
	Assert.assertEquals(actualMessage, expectedMessage);
}
@Test(priority=1)
public void loginWithInvalidPassword() {
	driver.get("http://www.automationpractice.com");
	driver.findElement(By.xpath("//a[@class='login']")).click();
	driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
	driver.findElement(By.id("passwd")).sendKeys("myinvalidpwd");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
	String actualError = driver.findElement(By.xpath("//p[text() = 'There is 1 error']")).getText();
	String expectedError = "There is 1 errorr";
	SoftAssert assertion = new SoftAssert();
	assertion.assertEquals(actualError, expectedError);
	assertion.assertAll();
	String actualMessage = driver.findElement(By.xpath("//li[text() = 'Authentication failed.']")).getText();
	String expectedMessage = "Authentication failed.";
	Assert.assertEquals(actualMessage, expectedMessage);
	
}

@Test(priority=0)
public void validUserAndPwd() {
	driver.get("http://www.automationpractice.com");
	driver.findElement(By.xpath("//a[@class='login']")).click();
	driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
	driver.findElement(By.id("passwd")).sendKeys("abc1234");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
	driver.findElement(By.xpath("//h1[@class = 'page-heading']")).isDisplayed();
	driver.findElement(By.xpath("//p[@class = 'info-account']")).isDisplayed();
	driver.findElement(By.xpath("//span[text() = 'My personal information']")).isDisplayed();
	driver.findElement(By.xpath("//a[@class='logout']")).click();
	
}






@AfterTest
public void closeBrowser() {
	driver.close();

	
}



	
	

}
