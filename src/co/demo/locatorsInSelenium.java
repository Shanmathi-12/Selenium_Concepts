package co.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorsInSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		/*for id
		driver.get("https://accounts.google.com/");
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("shanmathirs@gmail.com"); */
		/*for name
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click(); */
		/* for linktext
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.linkText("Forgot username?")).click(); */
		/* for css selector
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.cssSelector("#login-username")).sendKeys("edureka@yahoo.com");
		driver.findElement(By.cssSelector("#login-signin")).click();*/
		/* for partial linktext 
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.partialLinkText("Forgot")).click(); */
		//for css-selector
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("edureka@yahoo.com");
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
	}

}
