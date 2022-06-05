package StepDefinations;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.OwnerplanPage;
import Utility.Screeshot;
import io.cucumber.java.en.*;

public class OwnerPlanTC {
	static Logger logger = LoggerFactory.getLogger(OwnerPlanTC.class);
	public WebDriver driver;

	public OwnerplanPage op;

	@Given("Go to URL")
	public void go_to_url() {
		String URL = "https://nobroker.in";
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@Then("click on Menu")
	public void click_on_menu() {
		op = new OwnerplanPage(driver);
		op.Menu().click();
		logger.info("Menu");	
	}

	@Then("click on Owner Plan")
	public void click_on_owner_plan() {
		op.OwnerPlan().click();
		logger.info("Clicked on Owner plan");	
	}

	@When("verify the page owner plan")
	public void verify_the_page_owner_plan() throws Exception {
		if (driver.getTitle().contains("Owner Plans")) {
			Assert.assertTrue(true);
			logger.info("Owner Plans Page verified");	
		} else {
			Assert.assertTrue(false);
			logger.info("Wrong Page");	
		}
		String screenshotPath = Screeshot.getScreenshot(driver,"Owner Plan");

		driver.quit();
		logger.info("Driver Closed" );	
	}
}
