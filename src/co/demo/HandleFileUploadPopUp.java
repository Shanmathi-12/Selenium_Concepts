package co.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		Thread.sleep(1000);
		//99% --> for these file upload cases, type = "file"
		driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\LENOVO\\Downloads\\hello.docx");
	}

}
