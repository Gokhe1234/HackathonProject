package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HealthInsurancePage extends BasePage{
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	public static List<String> allHealthList=new ArrayList<String>();

	public HealthInsurancePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")
	WebElement healthInsurance;
	
	@FindBy(xpath="//*[@id=\"step1ContinueBtn\"]")
	WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"Self\"]")
	WebElement age;
	
	@FindBy(xpath="//*[@id=\"step2ContinueBtn\"]")
	WebElement continueBtn2;
	
	@FindBy(xpath="//li[text()='Pune']")
	WebElement citySelect;
	
	@FindBy(xpath="//*[@id=\"fullName\"]")
	WebElement fullName;
	
	@FindBy(xpath="//*[@id=\"mobile\"]")
	WebElement mobileNumber;
	
	@FindBy(xpath="//*[@id=\"step4ContinueBtn\"]")
	WebElement continueBtn3;
	
	@FindBy(xpath="//label[text()='None of these']")
	WebElement medicalCondition;
	
	@FindBy(xpath="//label[text()='Yes']")
	WebElement provideInsurance;
	
	@FindBy(xpath="//label[text()='Rs 3 lakh - Rs 5 lakh']")
	WebElement officeInsurance;
	
	@FindBy(xpath="//*[@id=\"viewPlansBtn\"]")
	WebElement viewBtn;
	
	
	@FindBy(xpath="//span[@class='quotes_more_plans more ']")
	List<WebElement> allButton;
	
	
	@FindBy(className="quotes_rvmp_card__content__plan_header__name")
	List<WebElement> allHealthInSuMenu;
	
	
	
	
	public void getHealthInsurance() {
		healthInsurance.click();
	}
	
	public void getContinueBtn() {
		continueBtn.click();
	}
	
	public void getAge() {
		age.click();
		Select ageSelect=new Select(age);
		ageSelect.selectByVisibleText("22 yr");
	}
	
	public void getContinueBtn2() {
		continueBtn2.click();
	}
	
	public void GetCitySelect() {
		
		js.executeScript("arguments[0].click();", citySelect);
			
	}
	public void getFullName(String name) {
		fullName.sendKeys(name);
	}
	
	public void getMobileNumber(String mobilNo) {
		mobileNumber.sendKeys(mobilNo);
	}
  
	
	public void continueBt3() {
		continueBtn3.click();
	}
	
	public void getMedical() {
		
		js.executeScript("arguments[0].click();", medicalCondition);
		
	}
	
	public void getInsurance() {
		
		js.executeScript("arguments[0].click();", provideInsurance);
		
	}
	
	public void getOfficeInsurance() {
		officeInsurance.click();
	}

	public void getViewBtn() {
		viewBtn.click();
	}
	
	
	public void allHealthInSu() throws InterruptedException, Exception {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		for(int j=0; j<allButton.size(); j++) {
			jse.executeScript("arguments[0].scrollIntoView()",allButton.get(j));
			jse.executeScript("arguments[0].click();",allButton.get(j));
			Thread.sleep(1000);
		}

		
		System.out.println("Number of package Available: "+allHealthInSuMenu.size());
		
		for(int i=0; i<allHealthInSuMenu.size(); i++) {
			allHealthList.add(allHealthInSuMenu.get(i).getText());
			
			
		}
		System.out.println("-------------Health Insurance List-------------- ");
		for(int k=0; k<allHealthInSuMenu.size(); k++) {
			
			
			System.out.println(allHealthList.get(k));
		}
		
		
		
		
		
	}
	
	

}
