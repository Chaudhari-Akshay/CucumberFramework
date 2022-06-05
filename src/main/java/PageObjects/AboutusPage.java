package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutusPage {
WebDriver driver;
	
	public AboutusPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\'nb__3N2G9 nb__2WC_s\']")
	WebElement aboutus;
	
	public WebElement Aboutus(){
		return aboutus;
	}
	@FindBy(xpath="//div[@class=\'w-3/4 py-1p px-2p\']")
	WebElement text;
	
	public WebElement Gettext(){
		return text;
	}
	
}
