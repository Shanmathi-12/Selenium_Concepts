package co.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
		//driver.switchTo().frame("theheaderhtml"); -- selected using id / name
		//driver.findElement(By.xpath("//a[text()='Index']")).click();
		//driver.switchTo().frame(0); -- 1st frame (selected using index)
		WebElement frame_element = driver.findElement(By.xpath("//iframe[@id='thedynamichtml']")); //-- frame selected using web element
		driver.switchTo().frame(frame_element);
		System.out.println(driver.findElement(By.cssSelector("ul>li:nth-of-type(4)")).getText());
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Index']")).click();
	}

}
