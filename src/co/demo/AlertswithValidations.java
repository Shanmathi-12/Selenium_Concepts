package co.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AlertswithValidations {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		Thread.sleep(2000);
		System.out.println(alertMessage);
		alert.accept();
		String text = driver.findElement(By.cssSelector("p#result")).getText();
		System.out.println(text);
		Assert.assertEquals("You successfuly clicked an alert",text);	
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert1 = driver.switchTo().alert();
	    String alertmessage1 = alert1.getText();
	    System.out.println(alertmessage1);
	    Thread.sleep(2000);
	    alert1.dismiss();
	    String result1 = driver.findElement(By.cssSelector("p#result")).getText();
		System.out.println(result1);
		Assert.assertEquals("You clicked: Cancel",result1);
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert2 = driver.switchTo().alert();
	    String alertmessage2 = alert2.getText();
	    System.out.println(alertmessage2);
	    Thread.sleep(2000);
	    alert1.accept();
	    String result2 = driver.findElement(By.cssSelector("p#result")).getText();
		System.out.println(result2);
		Assert.assertEquals("You clicked: Ok",result2);
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		String alertMessage3 = driver.switchTo().alert().getText();
		System.out.println(alertMessage3);
		driver.switchTo().alert().sendKeys("Ganesa");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String result3 = driver.findElement(By.cssSelector("p#result")).getText();
		System.out.println(result3);
		Assert.assertEquals("You entered: Ganesa",result3);
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		String alertMessage4 = driver.switchTo().alert().getText();
		System.out.println(alertMessage4);
		driver.switchTo().alert().sendKeys("Ganesa");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		String result4 = driver.findElement(By.cssSelector("p#result")).getText();
		System.out.println(result4);
		Assert.assertEquals("You entered: null",result4);
		
	    driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	    String result5 = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
	    System.out.println(result5);
	    Assert.assertEquals("Congratulations! You must have the proper credentials.", result5);
	}
}
