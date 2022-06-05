package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class=\'nb__19hcF\'])[1]")
	
	WebElement signup;
	
	
	//WebElement mono=driver.findElement(By.xpath("//input[@id=\'signUp-phoneNumber\']"));
	@FindBy(xpath="//input[@id=\'signUp-phoneNumber\']")

	WebElement mono;
	
	@FindBy(xpath="//input[@id=\'login-signup-form__name-input\']")
	
	WebElement name;
	@FindBy(xpath="//input[@id=\'login-signup-form__email-input\']")
	
	WebElement email;
	@FindBy(xpath="//button[@id=\"signUpSubmit\"']")
	
	WebElement btn;
	
	
	public WebElement SignUp(){
		return signup;
	}
	public WebElement Mobileno(){
		return mono;
	}
	public WebElement EnterName(){
		return name;
	}
	public WebElement EnterEmail(){
		return email;
	}
	public WebElement Signupbtn(){
		return btn;
	}
}
