	package pageObjectModelPackage;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.List;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;

	import org.apache.poi.ss.usermodel.CellBase;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	public class Homepage_ITechno {
		WebDriver driver;
		@FindBy(tagName="h5")
		private List<WebElement> headers;
		
		@FindBy(xpath="//*[@id=\"navigation\"]/ul/li[4]/ul/li[6]/a")
		private WebElement vDoctor;
		
		@FindBy(linkText="Technologies")
		private WebElement technologies;
		
		@FindBy(xpath="//div[@class='all_heading']/following::div[@class='row justify-content-center']")
		private List<WebElement> allTechnologies;
		//section[@class='section bg_light']/following::div[@class='row justify-content-center']
		
		@FindBy(xpath="//div[text()='Get a Quote']")
		private WebElement getQuote;
		
		public Homepage_ITechno(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		public List<WebElement> getAllHeaders() {
		
			System.out.println(headers.size());
			for(WebElement header:headers) {
				System.out.println("Header Text :: "+ header.getText());
			}
			
		return headers;
		}
		
		public void mousehover_work() {
		WebElement work_tab = driver.findElement(By.xpath("(//div[@id='navigation']/child::ul/child::li/child::a)[5]"));
		Actions action = new Actions(driver);	
		action.moveToElement(work_tab).build().perform();
		
	WebElement products_link = driver.findElement(By.linkText("Products"));
	action.moveToElement(products_link).click().build().perform();
		}
		
		public void vDoctor_link() throws InterruptedException {
			WebElement solutions_tab = driver.findElement(By.xpath("(//div[@id='navigation']/child::ul/child::li/child::a)[4]"));
			Actions action = new Actions(driver);	
			action.moveToElement(solutions_tab).build().perform();
			Thread.sleep(2000);
			vDoctor.click();
			Thread.sleep(2000);
		}
		
		public void technologies_link() throws InterruptedException {
			WebElement work_tab = driver.findElement(By.xpath("(//div[@id='navigation']/child::ul/child::li/child::a)[5]"));
			Actions action = new Actions(driver);	
			action.moveToElement(work_tab).build().perform();
			Thread.sleep(2000);
			technologies.click();
			Thread.sleep(3000);
		}
		
		public List<WebElement> retrieve_allTechnologies() {
			System.out.println(allTechnologies.size());
			System.out.println("All Technologies :: ");
			for(WebElement techologies:allTechnologies) {
				System.out.println(techologies.getText());
			}
			return allTechnologies;
		}

		public void getQuote_link() {
			getQuote.click();
		}
		
		public void dataFromExcel(String filepath ) {
			try {
			FileInputStream fileExcel = new FileInputStream(new File(filepath));
			XSSFWorkbook wb = new XSSFWorkbook(fileExcel);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			
			for(int i=1;i<sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
				String name = row.getCell(0).getStringCellValue();
				String email= row.getCell(1).getStringCellValue();
				String phone = row.getCell(2).getStringCellValue();
				String interest1 = row.getCell(3).getStringCellValue();
				String budget1 = row.getCell(3).getStringCellValue();
				String requirement1 = row.getCell(3).getStringCellValue();
//				= row.getCell(3).getStringCellValue();
//				 = row.getCell(4).getStringCellValue();
//				 = row.getCell(5).getStringCellValue();
				String aboutProject= row.getCell(6).getStringCellValue();
			
			
			
			
//			String name = sheet.getRow(1).getCell(0).getStringCellValue();
//			String email = sheet.getRow(1).getCell(1).getStringCellValue();
//			String phone = sheet.getRow(1).getCell(2).getStringCellValue();
//			String aboutProject = sheet.getRow(1).getCell(6).getStringCellValue();
			
			
			WebElement firstname = driver.findElement(By.xpath("//input[@id='FIRSTNAME']"));
			firstname.sendKeys(name);
			System.out.println("firstname : "+name);
			WebElement email_tb = driver.findElement(By.xpath("//input[@id='EMAIL']"));
			email_tb.sendKeys(email);
			System.out.println("email : "+email);
			WebElement mobile = driver.findElement(By.xpath("//input[@id='PHONE']"));
			mobile.sendKeys(phone);
			System.out.println("phone : "+phone);
			Thread.sleep(2000);
	      WebElement interest = driver.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[1]"));
	      interest.click();
	      Thread.sleep(2000);
	      Select select = new Select(interest);
	     select.selectByIndex(1);
//	     String interest1 = row.getCell(3).getStringCellValue();
	      
	      
	      WebElement budget = driver.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[2]"));
	      budget.click();
	      Thread.sleep(2000);
	      Select selectbudget = new Select(budget);
	      selectbudget.selectByIndex(1);
	      
	      WebElement requirement = driver.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[3]"));
	      requirement.click();
	      Thread.sleep(2000);
	      Select req = new Select(requirement);
	      req.selectByIndex(1);
	      
//	      WebElement project = driver.findElement(By.xpath("//textarea[@name='MESSAGE']"));
//	      project.sendKeys(aboutProject);
	       
	   WebElement submit = driver.findElement(By.xpath("//div[@class='sib-form-block']/child::button"));
	   submit.click();
	   Thread.sleep(2000);
	   
	   
	   
	   //create a new cell in the row at index 6
	 XSSFCell  interest12 = sheet.getRow(1).createCell(7);
	   
	   //check if confirmation message is displayed
	   if (interest.isSelected()) {
	       // if the message is displayed , write PASS in the excel sheet
		   interest12.setCellValue(interest.isSelected());
	   } else {
	       //if the message is not displayed , write FAIL in the excel sheet
		   interest12.setCellValue(aboutProject);
		   }
	   
	   
	   
	   // Write the data back in the Excel file
	   FileOutputStream outputStream = new FileOutputStream("E:\\\\Start\\\\AssignmentWork\\\\Excel_Read_File\\\\getAQuoteForm.xlsx");
	   wb.write(outputStream);

	   
			}
	//   fileExcel.close();
//		wb.close();
		

			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
	}

	
	


