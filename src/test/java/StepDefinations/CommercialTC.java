package StepDefinations;

import java.util.Iterator;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.CommercialPage;
import Utility.Screeshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommercialTC{
	Logger logger = LoggerFactory.getLogger(CommercialTC.class);
	public WebDriver driver;
    public CommercialPage c;
    @Given("navigate to Url {string}")
    public void navigate_to_url(String URL) {
    	System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
    	
    }
	@When("click on Commercial")
	public void click_on_commercial() throws InterruptedException {
	 c=new CommercialPage(this.driver);
	Thread.sleep(3000);
	c.Commercial().click();
	 logger.info("Clicked On Commercial");
	}

	@Then("click on office Space in pune")
	public void click_on_office_space_in_pune() {
	  c.office().click();
	  logger.info("Clicked On Office Space in Pune");
	}

	@Then("verify the page")
	public void verify_the_page() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parent1=I1.next();
		String child=I1.next();
		driver.switchTo().window(child);
		if(driver.getTitle().contains("Office Space")) {
			Assert.assertTrue(true);
			 logger.info("Successfully navigated to Office Space Page");
		}else {
			logger.info("Wrong Page" );	
			Assert.assertTrue(false);
			
						}
	}

	@Then("close the browser")
	public void close_the_browser() throws Exception {
		 String screenshotPath = Screeshot.getScreenshot(driver,"CommercialTC");
	   driver.quit();
	   logger.info("Driver Closed" );	
	}

}
