package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForPropertyowner {
	WebDriver driver;

	public ForPropertyowner(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id=\'headerHouseOwner\']")
	WebElement forpo;

	public WebElement PropertyOwner() {
		return forpo;
	}

	@FindBy(xpath = "//input[@id=\'userName\']")
	WebElement uname;

	public WebElement Entername() {
		return uname;
	}

	@FindBy(xpath = "//input[@id=\'userEmail\']")
	WebElement email;

	public WebElement Enteremail() {
		return email;
	}

	@FindBy(xpath = "//input[@id=\'userPhone\']")
	WebElement phone;

	public WebElement Enterphone() {
		return phone;
	}

	@FindBy(xpath = "//div[@class=\'css-151xaom-placeholder nb-select__placeholder\']")
	WebElement city;

	public WebElement Entercity() {
		return city;
	}

	@FindBy(xpath = "//button[@class=\'btn btn-primary btn-lg btn-block\']")
	WebElement btn;

	public WebElement Button() {
		return btn;
	}
	@FindBy(xpath = "//div[@class=\'css-dvua67-singleValue nb-select__single-value\']")
	WebElement pune;

	public WebElement selectPune() {
		return pune;
	}
	
	

}
