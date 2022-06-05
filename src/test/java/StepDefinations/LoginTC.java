package StepDefinations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.LoginPage;
import Utility.Screeshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTC {
	static Logger logger = LoggerFactory.getLogger(LoginTC.class);
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("navigate to {string}")
	public void navigate_to(String URL) {
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Driver Initialized");
		driver.get(URL);
		logger.info("Navigated to"+URL);
	}

	@Given("click on login")
	public void click_on_login() throws InterruptedException {
	 lp=new LoginPage(this.driver);
		lp.Login().click();
		logger.info("CLicked on login" );	
		Thread.sleep(3000);
	}

	@When("Enter mobile no {string}")
	public void enter_mobile_no(String mono) throws InterruptedException {
	
	   lp.Mobileno().sendKeys(mono);
	   logger.info("Entered on Mobile Number");	
	   Thread.sleep(3000);
	}

	@When("click on i have password")
	public void click_on_i_have_password() {
	    lp.UsePassword().click();
	    logger.info("Clicked on I have Password");	
	}

	@When("Enter password as {string}")
	public void enter_password_as(String password) {
	   lp.Password().sendKeys(password);
	   logger.info("Enetred the password");	
	}

	@Then("click on continue")
	public void click_on_continue() {
	    lp.Continue().click();
	    logger.info("Clicked on Continue");	
	    logger.info("Login Sucessfull");	
	}

	@Then("close the driver")
	public void close_the_driver() throws Exception {
		String screenshotPath = Screeshot.getScreenshot(driver,"Login");
	    driver.close();
	    logger.info("Driver Closed" );	
	}
	

}
