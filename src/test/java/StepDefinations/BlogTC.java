package StepDefinations;

import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.BlogPage;
import Utility.Screeshot;
import io.cucumber.java.en.*;

public class BlogTC {
	Logger logger = LoggerFactory.getLogger(BlogTC.class);
public WebDriver driver;
public BlogPage b;

	@Given("Go to nobroker website")
	public void go_to_nobroker_website() {
		String URL = "https://nobroker.in";
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@Then("click on Menu on homepage")
	public void click_on_menu_on_homepage() {
	    b=new BlogPage(driver);
	    b.Menu().click();
	    logger.info("Clicked on Menu");
	}

	@Then("click on Blog")
	public void click_on_blog() {
	   b.Blog().click();
	   logger.info("Clicked on Blogs");
	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@When("verify the page Blog is NoBroker Times")
	public void verify_the_page_blog_is_no_broker_times() throws Exception {
		if (driver.getTitle().contains("The NoBroker Times")) {
			Assert.assertTrue(true);
			 logger.info("Sccessfully navigated to The NoBroker Times");
		} else {
			 logger.info("Wrong Page");
			Assert.assertTrue(false);
			
		}
		 String screenshotPath = Screeshot.getScreenshot(driver,"BlogTC");
		driver.quit();
		 logger.info("Driver Closed");
	}
	}



