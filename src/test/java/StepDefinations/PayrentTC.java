package StepDefinations;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.Payrent;
import Utility.Screeshot;
import io.cucumber.java.en.*;

public class PayrentTC {
	static Logger logger = LoggerFactory.getLogger(PayrentTC.class);
public WebDriver driver;
public Payrent p;
	@Given("Go to Website")
	public void go_to_website() {
		String URL = "https://nobroker.in";
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@Given("click on Pay Rent")
	public void click_on_pay_rent() {
	    p=new Payrent(driver);
	    p.PayRent().click();
	    logger.info("Clicked on Payrent");	
	}

	@When("Enter your name")
	public void enter_your_name() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parent1=I1.next();
		String child=I1.next();
		driver.switchTo().window(child);
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    p.Name().sendKeys("Akshay ");
	    logger.info("Name Entered" );	
	    
	}

	@When("Enter your mobile no")
	public void enter_your_mobile_no() {
	    p.Mobileno().sendKeys("9172926596");
	    logger.info("Phone Number Entered");	
	}
	@Then("click on getstarted")
	public void click_on_getstarted() throws Exception {
	  p.Getstarted().click();
	  logger.info("Clicked on getstarted");
		String screenshotPath = Screeshot.getScreenshot(driver,"PayrentTC");

	  driver.quit();
	  logger.info("Driver Closed");	
	}
}
