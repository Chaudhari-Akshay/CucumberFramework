package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payrent {
	WebDriver driver;
	
	public Payrent(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id=\'payRentHomeTile\']")
	WebElement payr;


	public WebElement PayRent(){
		return payr;
	}
	
			@FindBy(xpath="//input[@id=\'tenant_name\']")
	WebElement name;


	public WebElement Name(){
		return name;
	}
	
			@FindBy(xpath="//input[@id=\'tenant_phone\']")
		WebElement mono;

			
		public WebElement Mobileno(){
			return mono;
		}
		
		@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
		WebElement btn;

			
		public WebElement Getstarted(){
			return btn;
		}
		

				@FindBy(xpath="//input[@type=\'checkbox\']")
				WebElement checkbox;

					
				public WebElement checkbox(){
					return checkbox;
				}
}
