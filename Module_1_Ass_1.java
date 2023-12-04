package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Module_1_Ass_1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
					
//	    WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		EdgeOptions options = new EdgeOptions();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(options);
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
	    String amazonTitle = driver.getTitle();
	    String expAmazonTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	    if(expAmazonTitle.equals(amazonTitle)) {
	    	System.out.println("amazonTitle pass :: "+amazonTitle);
	    }else {
	    	System.out.println("amazonTitle Fail :: "+amazonTitle);
	    }
	    
	    driver.navigate().to("https://www.facebook.com/");
	    String facebook = driver.getCurrentUrl();
	    String fbExpectedUrl = "https://www.facebook.com/";
		if(facebook.equals(fbExpectedUrl)) {
			System.out.println("Facebook Url Pass :: "+facebook);
		}else {
			System.out.println("Facebook Url Fail");
		}
		    String fbtitle = driver.getTitle();
		    String expectedFbTitle = "Facebook – log in or sign up";
		    if(fbtitle.equals(expectedFbTitle)) {
		    	System.out.println("FaceBook Title Testcase is Pass :: "+fbtitle);
		    }else {
		    	System.out.println("FaceBook Title Testcase is Fail");
		    }
		    Thread.sleep(3000);
		    Assert.assertEquals(fbtitle, expectedFbTitle);
		   
	    

		    driver.navigate().back();
		    String url = driver.getCurrentUrl();
			String expectedUrl = "https://www.amazon.in/";
		    if(expectedUrl.equals(url)){
		    	System.out.println("Amazon Homepage Test case is PASS :: "+url);	
		    }else {
		    	System.out.println("Amazon Homepage url Test case is FAILED");	
		    }
		    
	  System.out.println("Closing...");
	    driver.close();
	    
	    
	}

}
