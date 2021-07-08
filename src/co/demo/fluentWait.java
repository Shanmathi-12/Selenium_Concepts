package co.demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class fluentWait{

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(2,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement content = fluentWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.xpath("//h4[text()='Hello World!']"));				
			}
				});
		System.out.println(content.getText());
	}

}
