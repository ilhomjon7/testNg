package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment {
WebDriver driver;

@BeforeTest
public void openBrowser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://facebook.com");
}

@Test
public void theTest() {
	Select drpDownMonth = new Select(driver.findElement(By.id("month")));
	Select drpDownDay = new Select(driver.findElement(By.id("day")));
	Select drpDownYear = new Select(driver.findElement(By.id("year")));
	drpDownMonth.selectByVisibleText("Nov");
	drpDownDay.selectByVisibleText("22");
	drpDownYear.selectByVisibleText("1920");
}
//adding a comment in line number 32 yooo

   
   
	}

