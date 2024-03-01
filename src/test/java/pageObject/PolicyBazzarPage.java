package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicyBazzarPage extends BasePage{
	
	public PolicyBazzarPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
	WebElement travelInsuClick;

	
	public void travelInsu() {
		travelInsuClick.click();
	}
	

}
