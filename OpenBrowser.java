package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://www.facebook.com/");
	  String fbtitle = driver.getTitle();
	  System.out.println(fbtitle);
	  String fburl = driver.getCurrentUrl();
	  System.out.println(fburl);
	  driver.findElement(By.id("email")).sendKeys("ramya.battula@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("ramya48965712");
	  driver.findElement(By.name("login")).click();
	  driver.quit();

	}

}
