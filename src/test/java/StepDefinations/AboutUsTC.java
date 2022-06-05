package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.AboutusPage;
import Utility.Screeshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUsTC {
	Logger logger = LoggerFactory.getLogger(AboutUsTC.class);
	
	public WebDriver driver;
	public AboutusPage au;
	@Given("navigate to Url https:\\/\\/nobroker.in")
	public void navigate_to_url_https_nobroker_in() {
		String URL="https://nobroker.in";
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);

	}

	@When("click on About us")
	public void click_on_about_us() {
		au=new AboutusPage(this.driver);
	    au.Aboutus().click();
	    logger.info("Clicked on About Us");
	}

	@Then("get details")
	public void get_details() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  au.Gettext().getText();
	  logger.info("Deatils about "+ au.Gettext().getText());
	 
	  String screenshotPath = Screeshot.getScreenshot(driver,"Aboutus");
	//  System.out.println(au.Gettext().getText());
	  driver.close();
	  logger.info("Closed the Browser");
	}
}
