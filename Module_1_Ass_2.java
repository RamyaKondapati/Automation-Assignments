package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_1_Ass_2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/radio.html");
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
		WebElement radiobtn = driver.findElement(By.id("vfb-7-1"));
		WebElement radiobtn2 = driver.findElement(By.id("vfb-7-2"));
		radiobtn.click();
		boolean status = radiobtn.isDisplayed();
		System.out.println("Radiobtn options Displayed :: " + status);

		Thread.sleep(2000);
		System.out.println(radiobtn.isSelected());
		if (radiobtn.isSelected()) {
			System.out.println("Radiobtn option1Selected :: " + radiobtn.getText());
		} else {
			System.out.println("Radiobtn not Selected");
		}
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
		checkbox.click();
		System.out.println(checkbox.getText());
		if (checkbox.isEnabled()) {
			System.out.println("checkbox selected :: ");
		} else {
			System.out.println("checkbox not Selected");
		}

		driver.findElement(By.xpath("//input[@id='vfb-6-1']")).click();
		Thread.sleep(2000);
		System.out.println(checkbox.getAccessibleName());
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		dropdown.selectByVisibleText("KUWAIT");
		Thread.sleep(2000);
	WebElement dd = dropdown.getFirstSelectedOption();
		System.out.println(dd.getText());

//driver.close();
driver.quit();

	}

}
