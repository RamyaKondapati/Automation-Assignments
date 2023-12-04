package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPage {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
						
//		    WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			
			EdgeOptions options = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			
//	    	WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		    WebDriver driver = new FirefoxDriver();
			
//			WebDriverManager.safaridriver().setup();
//			driver = new SafariDriver();
//			System.setProperty(
//	                "webdriver.safari.driver",
//	                "D:\\selenium-safari-driver-2.29.1.jar\\selenium-safari-driver-2.29.1.exe");
//	            WebDriver driver = new SafariDriver();
			
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
			
//			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
			
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
		    
//			driver.findElement(By.linkText("Facebook")).click();
//			String facebook = driver.getCurrentUrl();
//			//System.out.println(facebook);
//			String fbExpectedUrl = "https://www.facebook.com/AmazonIN";
//			if(facebook.equals(fbExpectedUrl)) {
//				System.out.println("Facebook Url Pass :: "+facebook);
//			}else {
//				System.out.println("Facebook Url Fail");
//			}
//		    driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
//		    String fbtitle = driver.getTitle();
//		  //  System.out.println(fbtitle);
//		    String expectedFbTitle = "Amazon India | Facebook";
//		    if(fbtitle.equals(expectedFbTitle)) {
//		    	System.out.println("FaceBook Title Testcase is Pass :: "+fbtitle);
//		    }else {
//		    	System.out.println("FaceBook Title Testcase is Fail");
//		    }
//		    Thread.sleep(3000);
//		    driver.findElement(By.linkText("Reels")).click();
//		    String reelstitle = driver.getTitle();
//		    System.out.println(reelstitle);
//		    
//		    driver.navigate().back();
//		    String amazonTitle = driver.getTitle();
//		  //  System.out.println(amazonTitle);
//		    String expAmazonTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		    if(expAmazonTitle.equals(amazonTitle)) {
//		    	System.out.println("amazonTitle pass :: "+amazonTitle);
//		    }else {
//		    	System.out.println("amazonTitle Fail :: "+amazonTitle);
//		    }

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

	
	

