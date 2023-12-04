package PracticeSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_2_Ass_1 {

	static WebDriver driver;

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();

		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebElement webtable = driver.findElement(By.xpath("//table[@class='dataTable']"));

		System.out.println("All Company names : ");

		List<WebElement> allrows = webtable.findElements(By.tagName("tr"));
		for (int rnum = 1; rnum < allrows.size(); rnum++) {
			WebElement row = allrows.get(rnum);
			List<WebElement> column = row.findElements(By.tagName("td"));

			String company = column.get(0).getText();
			System.out.println(company);

		}

		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.id("email")).sendKeys("ramyajanu@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("ramya123");
		driver.findElement(By.name("SubmitLogin")).click();
		System.out.println(driver.getCurrentUrl());
		
		
		
		
	}
}
