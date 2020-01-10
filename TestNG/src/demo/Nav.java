package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nav {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.navigate().to("http://automationpractice.com/index.php");
	//driver.get("http://automationpractice.com/index.php");
driver.findElement(By.xpath("(//a[@title = 'T-shirts'])[2]")).click();
Thread.sleep(2000);
driver.navigate().back();
driver.navigate().forward();
Thread.sleep(3000);
driver.close();
}
}
