package PracticeSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_2_Ass_3 {

	static WebDriver driver;
	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement dragme = driver.findElement(By.id("draggable"));
		
//		Actions actions = new Actions(driver);
//		actions.dragAndDropBy(dragme, 150, 100).build().perform();
		
		//Using JavascriptExecutor
		((JavascriptExecutor) driver).executeScript("arguments[0].style.transform='translate(200px, 100px)';", dragme);

		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			String snap = driver.getTitle();
			System.out.println(snap);
			FileUtils.copyFile(screenshot,new File("E:\\Start\\AssignmentWork\\ScreenshotsFolder\\picture2.png"));
			//FileUtils.copyFile(screenshot,new File("E:\\Start\\AssignmentWork\\ScreenshotsFolder\\"+snap+".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

		System.out.println("Screenshot for Draggable");
	}

}
