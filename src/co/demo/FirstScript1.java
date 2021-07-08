package co.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
public class FirstScript1 {

	public static void main(String[] args) throws InterruptedException {
		//we should set up the respective driver property
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		//below line launches the chrome browser
		WebDriver driver = new ChromeDriver(); //dynamic polymorphism
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/"); //to provide URL
		Thread.sleep(1000);
		//validation 
		String Title = driver.getTitle();
		if(Title.equals("Google")) {
			System.out.println("correct title");
		}
		else
		{
			System.out.println("in-correct title");
		}
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oppo a31");
		Thread.sleep(1000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Vivo")).click();
	}

}
