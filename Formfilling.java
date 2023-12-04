package PracticeSelenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Formfilling {

	WebDriver driver;

	@Test(groups = { "smoke" })
	public void forms() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/");

		driver.findElement(By.xpath("//h5[text()='Forms']")).click();
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
	}

	@Test(groups = { "regression" })
	public void formFilling() {
		try {

//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			Thread.sleep(5000);
			System.out.println("zooming");

			Robot robot = new Robot();
			driver.get("https://demoqa.com/");

			Thread.sleep(5000);
			System.out.println("About to zoom out");
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			driver.findElement(By.xpath("//h5[text()='Forms']")).click();
			driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
			// this.driver=driver;
			driver.findElement(By.id("firstName")).sendKeys("Ramya");
			driver.findElement(By.id("lastName")).sendKeys("Kondapati");
			driver.findElement(By.id("userEmail")).sendKeys("ramyak@gmail.com");
			driver.findElement(By.xpath("//label[text()='Female']")).click();
			driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("9000933214");
			// driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).clear();
			driver.findElement(By.xpath("//div[@class='react-datepicker-wrapper']")).click();
			WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
			Select select = new Select(month);
			select.selectByVisibleText("June");
			WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
			Select select_year = new Select(year);
			select_year.selectByVisibleText("2000");
			driver.findElement(By.xpath("(//div[text()='5'])[1]")).click();
			WebElement subjects = driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]"));

			Thread.sleep(2000);
			subjects.sendKeys("Chemistry");
			Thread.sleep(2000);
			subjects.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			subjects.sendKeys(Keys.ENTER);
			subjects.sendKeys("Phys");
			Thread.sleep(2000);
			subjects.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			subjects.sendKeys(Keys.ENTER);

			driver.findElement(By.xpath("//label[text()='Music']")).click();
			driver.findElement(By.xpath("//label[text()='Sports']")).click();

			WebElement choosefile = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
			choosefile.sendKeys("C:\\Users\\ramya\\Pictures\\Screenshots\\TestNg.png");

			driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Ashok nagar colony,road no.6");

			WebElement stateSelect = driver
					.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]"));
			stateSelect.click();
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);
			WebElement citySelect = driver.findElement(By.xpath("//div[@id='city']"));
			citySelect.click();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);

			WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
			submit.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Close']")).click();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
