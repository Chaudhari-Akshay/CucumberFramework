package StepDefinations;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.SignupPage;
import Utility.Screeshot;
import io.cucumber.java.en.*;

public class SignUpTC {
	static Logger logger = LoggerFactory.getLogger(SignUpTC.class);
	public WebDriver driver;
	public SignupPage sp;
	@Given("navigate to https:\\/\\/nobroker.in website")
	public void navigate_to_https_nobroker_in_website() {
		String URL="https://nobroker.in";
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

@Given("click on signup")
public void click_on_signup() {
    sp=new SignupPage(driver);
    sp.SignUp().click();
    logger.info("Clicked on Sign in ");	
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}
	@When("Enter mobile no")
	public void enter_mobile_no() {
		if(sp.Mobileno().isDisplayed()) {
	   sp.Mobileno().sendKeys("9172926596");
	   logger.info("Enetred Mobile Number" );	
		}else {
			
			logger.info("User have already account on nobroker.in" );	
		}
	}


@When("Enter name and email")
public void enter_name_and_email() {
	if(sp.EnterName().isDisplayed()) {
   sp.EnterName().sendKeys("Akshay");
   logger.info("Enterd the Name");
   sp.EnterEmail().sendKeys("akshay@gmail.com");
		   logger.info("Enterd the Email");
	}
   }


	@Then("click on continue button")
	public void click_on_continue_button() {
		if(sp.EnterName().isDisplayed()) {
	    sp.Signupbtn().click();
	    logger.info("Clicked on Sign in Button");
		}
	}

	@Then("close the webdriver")
	public void close_the_webdriver() throws Exception {
		String screenshotPath = Screeshot.getScreenshot(driver,"SignUp");

	    driver.close();
	    logger.info("Closed the driver");
	}

}
