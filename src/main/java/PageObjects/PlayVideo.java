package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayVideo {

	WebDriver driver;
		
		public PlayVideo(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//button[@class=\'ytp-large-play-button ytp-button\']")
		WebElement play;
	
	
		public WebElement PlayVideo(){
			return play;
		}
}
