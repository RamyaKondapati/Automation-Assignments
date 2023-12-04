package pageObjectModelPackage;

import java.io.FileInputStream;
import java.util.List;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage_Itechnotion {
	WebDriver driver;
	@FindBy(tagName = "h5")
	private List<WebElement> headers;

	@FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[4]/ul/li[6]/a")
	private WebElement vDoctor;

	@FindBy(linkText = "Technologies")
	private WebElement technologies;

	@FindBy(xpath = "//div[@class='all_heading']/following::div[@class='row justify-content-center']")
	private List<WebElement> allTechnologies;

	@FindBy(xpath = "//div[text()='Get a Quote']")
	private WebElement getQuote;

	public Homepage_Itechnotion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllHeaders() {

		System.out.println(headers.size());
		for (WebElement header : headers) {
			System.out.println("Header Text :: " + header.getText());
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
		WebElement solutions_tab = driver
				.findElement(By.xpath("(//div[@id='navigation']/child::ul/child::li/child::a)[4]"));
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
		for (WebElement techologies : allTechnologies) {
			System.out.println(techologies.getText());
		}
		return allTechnologies;
	}

	public void getQuote_link() {
		getQuote.click();
	}

	public void dataFromExcel(String filepath) {
		try {
			FileInputStream fileExcel = new FileInputStream(new File(filepath));
			XSSFWorkbook wb = new XSSFWorkbook(fileExcel);
			XSSFSheet sheet = wb.getSheetAt(1);

			String name = sheet.getRow(1).getCell(0).getStringCellValue();
			String email = sheet.getRow(1).getCell(1).getStringCellValue();
			String phone = String.valueOf((long) sheet.getRow(1).getCell(2).getNumericCellValue());
			String interest = sheet.getRow(1).getCell(3).getStringCellValue();
			String budget = sheet.getRow(1).getCell(4).getStringCellValue();
			String requirement = sheet.getRow(1).getCell(5).getStringCellValue();
			String aboutProject = sheet.getRow(1).getCell(6).getStringCellValue();

			WebElement firstname = driver.findElement(By.xpath("//input[@id='FIRSTNAME']"));
			firstname.sendKeys(name);
			System.out.println("firstname : " + name);
			WebElement email_tb = driver.findElement(By.xpath("//input[@id='EMAIL']"));
			email_tb.sendKeys(email);
			System.out.println("email : " + email);
			WebElement mobile = driver.findElement(By.xpath("//input[@id='PHONE']"));
			mobile.sendKeys(phone);
			System.out.println("phone : " + phone);
			Thread.sleep(2000);
			WebElement interestvalue = driver
					.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[1]"));
			interestvalue.click();
			Thread.sleep(2000);
			Select select = new Select(interestvalue);
			select.selectByVisibleText(interest);
			System.out.println("interest : " + interest);

			WebElement budgetvalue = driver
					.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[2]"));
			budgetvalue.click();
			Thread.sleep(2000);
			Select selectbudget = new Select(budgetvalue);
			selectbudget.selectByVisibleText(budget);
			System.out.println("budget : " + budget);
			
			
			System.out.println("budjet :: ");

			WebElement requirementvalue = driver
					.findElement(By.xpath("(//form[@id='sib-form']/child::div/following::select[@class='input'])[3]"));
			requirementvalue.click();
			Thread.sleep(2000);
			Select req = new Select(requirementvalue);
			req.selectByVisibleText(requirement);
			System.out.println("requirement : " + requirement);

			
			WebElement project = driver.findElement(By.xpath("//textarea[@name='MESSAGE']"));
			project.sendKeys(aboutProject);
			System.out.println("About project : " + aboutProject);

			WebElement submit = driver.findElement(By.xpath("//div[@class='sib-form-block']/child::button"));
			submit.click();
			Thread.sleep(6000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
driver.close();
	}
	

}
