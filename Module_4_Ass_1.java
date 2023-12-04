package PracticeSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_4_Ass_1 {
	
	static WebDriver driver;
	
	public static void main(String[]args){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.iedriver().setup();
//		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		try {
			
			FileInputStream file = new FileInputStream(new File("E:\\Start\\AssignmentWork\\Excel_Read_File\\dataprovider.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i=1; i<=sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
			    String username = row.getCell(0).getStringCellValue();
				String pass = row.getCell(1).getStringCellValue();
				
				driver.get("http://demo.guru99.com/V4/");
			    WebElement userid = driver.findElement(By.xpath("//input[@name='uid']"));
				WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
				userid.sendKeys(username);
				password.sendKeys(pass);
				WebElement loginbtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));
				loginbtn.click();
				driver.switchTo().alert().accept();
				
			}
			file.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
