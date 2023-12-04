package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelPackage.Loginpage;

public class Module_3_Ass_1 {

	WebDriver driver;
	Loginpage login;

	@BeforeMethod
	public void openBrowser() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		login = new Loginpage(driver);
		driver.get("https://demo.guru99.com/test/login.html");

	}

	@Test
	public void login() throws InterruptedException {

		Thread.sleep(8000);
		// Loginpage login = new Loginpage(driver);
		login.emailid("ramya123@gmail.com");
		login.password("ramya12587");
		login.submit();

	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		
		try {
			//driver.close();
			//driver.quit();
			 if (this.driver != null) {
				    this.driver.close();
				
				  }
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
