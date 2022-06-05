package StepDefinations;

import java.util.Iterator;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.Flatsonrent;
import Utility.Screeshot;
import io.cucumber.java.en.*;

public class FlatOnRentTC {
	static Logger logger = LoggerFactory.getLogger(FlatOnRentTC.class);
	public WebDriver driver;
	public Flatsonrent f;
	@Given("navigate to nobroker.in Url")
	public void navigate_to_nobroker_in_url() {
		String URL="https://nobroker.in";
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@When("click on Flat On Rent")
	public void click_on_flat_on_rent() {
	   f=new Flatsonrent(this.driver);
	   f.Flatsonrent().click();
	   logger.info("Clicked on Flats on Rent ");	
	}

	@Then("click on flats in kharadi")
	public void click_on_flats_in_kharadi() {
	    f.ForInKharadi().click();
	    logger.info("Clicked on Flats on Rent in Kharadi, Pune ");
	}

	@Then("verify the page title")
	public void verify_the_page_title() throws Exception {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parent1=I1.next();
		String child=I1.next();
		driver.switchTo().window(child);
		if(driver.getTitle().contains("Kharadi")) {
			Assert.assertTrue(true);
			logger.info("Successfully Navigated to Flats on rent in kharadi,Pune Page");
		}else {
			Assert.assertTrue(false);
			logger.info("Wrong Page");
		}
		 String screenshotPath = Screeshot.getScreenshot(driver,"FlatOnRent");
		driver.quit();
		logger.info("Driver Closed" );	
	}
}
