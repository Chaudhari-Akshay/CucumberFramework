package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerplanPage {
	WebDriver driver;
	
	public OwnerplanPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id=\'main-menu\']")
	WebElement menu;
	
	public WebElement Menu(){
		return menu;
	}
	
	@FindBy(xpath="(//a[@class='nb__3Tx_U nb__2jlgw'])[6]")
	WebElement op;
	
	public WebElement OwnerPlan(){
		return op;
	}
	
}
