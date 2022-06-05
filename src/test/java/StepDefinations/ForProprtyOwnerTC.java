package StepDefinations;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.ForPropertyowner;
import Utility.Screeshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForProprtyOwnerTC {
	static Logger logger = LoggerFactory.getLogger(ForProprtyOwnerTC.class);
	public WebDriver driver;
	public ForPropertyowner fpo;
	@Given("go to homepage")
	public void go_to_homepage() {
		
			String URL="https://nobroker.in";
			System.setProperty("webdriver.chrome.driver",
					".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Driver Initialized");
			driver.get(URL);
			logger.info("Navigated to"+URL);
	}

	@Given("click on for propery Owner")
	public void click_on_for_propery_owner() throws InterruptedException {
	   fpo=new ForPropertyowner(driver);
	   fpo.PropertyOwner().click();
		logger.info("Clicked on for prperty Owner ");	
	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	   Thread.sleep(3000);
	}

	@When("Enter the name")
	public void enter_the_name() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parent1=I1.next();
		String child=I1.next();
		driver.switchTo().window(child);
		fpo.Entername().sendKeys("Akshay");
		logger.info("Name Entered");	
	}

	@When("Enter the Emailaddress")
	public void enter_the_emailaddress() {
		fpo.Enteremail().sendKeys("akshay@gmail.com");
		logger.info("Email Entered");
	}

	@When("Enter Phone no")
	public void enter_phone_no() {
		fpo.Enterphone().sendKeys("9172926596");
		logger.info("Phone no Entered");
	}

	@Then("select the city")
	public void select_the_city() throws InterruptedException {
		
	    fpo.Entercity().click();
	    logger.info("Clicked on City");
	    //Thread.sleep(3000);
	   // fpo.Entercity().click();
	   // Actions a=new Actions(driver);
	   // a.moveToElement(fpo.selectPune()).click().build().perform();
	    
	}

	@Then("click on submit button")
	public void click_on_submit_button() throws Exception {
	   fpo.Button().click();
	   logger.info("Clicked on submit Button");
	   String screenshotPath = Screeshot.getScreenshot(driver,"ForPropertyOwner");
	   driver.quit();
		logger.info("Driver Closed" );	
	}
}
