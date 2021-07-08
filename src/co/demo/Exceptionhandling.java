package co.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptionhandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		/*No such Element Exception
		try {
		driver.findElement(By.id("fake")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not found");
			System.out.println("Hello");
			throw(e);
		}
		System.out.println("World!!");
		*/
		/*No Alert Present Exception
		try {
			driver.switchTo().alert().dismiss();
		}
		catch(NoAlertPresentException e) {
			System.out.println("No Alert Window Found");
			e.printStackTrace();
		}*/
		/*No Such Frame Exception
		try {
			driver.switchTo().window("Fail");
		}
		catch(NoSuchWindowException e)
		{
			e.printStackTrace();
		}*/
		//No Such Frame Exception
		try {
			driver.switchTo().frame("fail");
		}
		catch(NoSuchFrameException e)
		{
			System.out.println("No Frame Found");
		}
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("India");
		
	}

}
