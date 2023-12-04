package PracticeSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_2_Ass_2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.edgedriver().setup();
//		EdgeOptions options = new EdgeOptions();
//		driver = new EdgeDriver(options);
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		//Alerts
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("cusid")).sendKeys("123456");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		//Frames
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("/html/body/a/img")).click();
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		//Windows Handling
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Thread.sleep(7000);
		String mainWindow = driver.getWindowHandle();
		Set<String> newWindow = driver.getWindowHandles();
		for(String handle:newWindow) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(7000);
		driver.findElement(By.name("emailid")).sendKeys("ramyakondapati@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());
		
	}

}
