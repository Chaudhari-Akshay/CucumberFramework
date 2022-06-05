package StepDefinations;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.PlayVideo;
import Utility.Screeshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlayvideoTC {
	static Logger logger = LoggerFactory.getLogger(PlayvideoTC.class);
	public WebDriver driver;
	public PlayVideo pv;
	
	@Given("go to https:\\/\\/nobroker.in")
	public void go_to_https_nobroker_in() {
		String URL="https://nobroker.in";
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@When("scroll down towords video")
	public void scroll_down_towords_video() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		logger.info("Scrolled down towords Video");	
		
	}

	@Then("play the video")
	public void play_the_video() {
	   pv=new PlayVideo(driver);
	   driver.switchTo().frame(0);
	   pv.PlayVideo().click();
	   logger.info("Played the Video");	
	}

	@Then("wait for {int} sec close the browser")
	public void wait_for_sec_close_the_browser(Integer int1) throws Exception {
	    Thread.sleep(5000);
	    logger.info("Waited for 5 Seconds" );	
		String screenshotPath = Screeshot.getScreenshot(driver,"PlayVideo");

	    driver.close();
	    logger.info("Driver Closed" );	
	}
}
