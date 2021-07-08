package co.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitInSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.cssSelector("#email"));
		WebElement password = driver.findElement(By.cssSelector("#pass"));
		sendKeys(driver,username,10,"abcd@gmail.com");
		sendKeys(driver,password,20,"1234abcd");
		WebElement link = driver.findElement(By.linkText("Forgotten password?"));
		clickButton(driver,link,15);
		driver.navigate().back();
		WebElement new_acct = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		clickButton(driver,new_acct,10);
		WebElement day = driver.findElement(By.id("day"));
//		 Select select = new Select(day);
//		    select.selectByVisibleText("24");
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		onSelect(driver,day,30,"25"); //static method direct calling
		waitInSelenium.onSelect(driver,month,10,"May"); //static method calling with Class name.
		onSelect(driver,year,25,"2004");
	    }
	    public static void onSelect(WebDriver driver, WebElement element, int timeout, String input) {
	    	//explicit wait
	    	new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
		    Select select = new Select(element);
		    select.selectByVisibleText(input);
	    }
		public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value)
		{
			new WebDriverWait(driver1,timeout).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		}
		public static void clickButton(WebDriver driver1, WebElement element, int timeout)
		{
			new WebDriverWait(driver1,timeout).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
}
