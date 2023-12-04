package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelPackage.Homepage_Itechnotion;

public class Module_4_Ass_2 {

	WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
	
	Homepage_Itechnotion homepage = new Homepage_Itechnotion(driver);
	homepage.getAllHeaders();
	homepage.mousehover_work();
	Thread.sleep(2000);
	homepage.vDoctor_link();
	homepage.technologies_link();
	homepage.retrieve_allTechnologies();
	homepage.getQuote_link();
	Thread.sleep(3000);
	homepage.dataFromExcel("E:\\Start\\AssignmentWork\\Excel_Read_File\\dataprovider.xlsx");

	System.out.println("Done");
	
	}
}
