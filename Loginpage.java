package pageObjectModelPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailId_tb;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password_tb;
	
	@FindBy(name = "SubmitLogin")
	private WebElement submit_btn;

	private WebDriver driver;
	
	public Loginpage(WebDriver driver){
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void emailid(String email) {
		emailId_tb.sendKeys(email);
	}
	
	public void password(String pass) {
		password_tb.sendKeys(pass);
	}
	
	public void submit() {
		submit_btn.click();
	}
	
}
