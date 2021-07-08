package co.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//button[text()=\"Click me!\"]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		Thread.sleep(2000);
		alert.accept();
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click me!']")).click();
		//driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Thread.sleep(3000);
		alert.dismiss();
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(2000);
		alert.sendKeys("Alex");
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(2000);
		driver.navigate().to("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();
		Robot robot = new Robot();
		robot.mouseMove(950, 110);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
			driver.quit();
	}
}
