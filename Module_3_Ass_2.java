package PracticeSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelPackage.Loginpage;
import java.io.File;

public class Module_3_Ass_2 {
	
	WebDriver driver;
	@BeforeMethod
	public void start() {
	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.guru99.com/test/login.html");
		
	}
@AfterMethod
	public void end() {
		driver.close();
	}
	
	@Test(dataProvider = "login")
	public void loginGuru99(String email,String pass) {
		
		Loginpage logingpage = new Loginpage(driver);
		logingpage.emailid(email);
		logingpage.password(pass);
		logingpage.submit();
	}
	
	@DataProvider(name = "login")
	public Object[][] email_password() throws IOException {
		FileInputStream excel_read = new FileInputStream(new File("E:\\Start\\AssignmentWork\\Excel_Read_File\\dataprovider.xlsx")); 
		XSSFWorkbook workbook = new XSSFWorkbook(excel_read);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows_count = sheet.getLastRowNum();
		Object[][] excel_data_file = new Object[rows_count][2];
		for(int i=0;i<rows_count;i++) {
			XSSFRow rows = sheet.getRow(i+1);
			excel_data_file[i][0] = rows.getCell(0).getStringCellValue();
			excel_data_file[i][1]= rows.getCell(1).getStringCellValue();
		}
		excel_read.close();
		workbook.close();
		
		return excel_data_file;
		
	}
}
