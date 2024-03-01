package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelInsurancePage extends BasePage {

	public TravelInsurancePage(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//label[contains (text(),'Enter your destination')]")
	WebElement destinationEnter;
	
	@FindBy(xpath="//*[@id=\"search-country\"]/ul/li[3]")
	WebElement nextButton;
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	WebElement submeetbutton;
	
	@FindBy(xpath="(//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")
	WebElement searchClick;
	
	@FindBy(xpath="(//*[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]")
	WebElement month1;
	
	@FindBy(xpath="(//span[@class='MuiIconButton-label'])[4]")
	WebElement nextMonth;
	
	@FindBy(xpath="//*[@class='MuiPickersDateRangeDay-root']")
	List<WebElement> datepicker1;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement nextbutton2;
	
	@FindBy(xpath="//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/label")
	WebElement selectStudent;
	
	@FindBy(xpath="(//*[@id=\"divarrow_undefined\"])[1]")
	WebElement selectAgeOption1;
	
	@FindBy(xpath="//label[text()='22 years']")
	public WebElement allAgeOptions1;
	
	@FindBy(xpath="//div[text()='Select age of traveller 2']")
	WebElement selectAgeOption2;
	
	@FindBy(xpath="//label[text()='21 years']")
	WebElement allAgeOptions2;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement nextButton3;
	
	@FindBy(xpath="//*[@id=\"ped_no\"]")
	WebElement medicalCondition;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement nextButton4;
	
	@FindBy(xpath="//*[@id=\"mobileNumber\"]")
	WebElement enterMobileNo;
	
	@FindBy(xpath="//button[contains(text(),'View plans')]")
	WebElement viewPlanButton;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/article/h1/a")
	 WebElement logoClick;
	
	
	
	
	public void destination() {
		destinationEnter.click();
	}
	
	public void getNextButton() {
		nextButton.click();
	}
	
	public void getSubmeetbutton() {
		js.executeScript("arguments[0].click();", submeetbutton);
		//submeetbutton.click();
	}
	
	public void getSearchClick() {
		searchClick.click();
		String startdate="21";
		String month_year="April 2024";
		
		while(true) {
			String month=month1.getText();
			if(month.equals(month_year)) {
				break;
			}
			else {
				nextMonth.click();
			}
			
			
			for(WebElement element:datepicker1) {
				String date=element.getText();
				if(date.equals(startdate)) {
					element.click();
					break;
				}
	
			}
		}
		
		String enddate="10";
		String month_year1="May 2024";
		
		
		while(true) {
			String month=month1.getText();
			if(month.equals(month_year1)) {
				break;
			}
			else {
				nextMonth.click();
			}
			
			
			
			for(WebElement element:datepicker1) {
				String date=element.getText();
				if(date.equals(enddate)) {
					element.click();
					break;
				}
				
				
			}
		}
	}
	

	
	public void getNextbutton2() {
		nextbutton2.click();
	}
	
	public void studentSelect() {
		selectStudent.click();
	}
	public void getSelectAgeOption1() {
		selectAgeOption1.click();
	}
	
    public void getAgeOptions1() {
    	allAgeOptions1.click();
	
	}
    
    public void getSelectAgeOption2() {
    	selectAgeOption2.click();
    	
	}
    
    public void getAgeOption2() {
    	allAgeOptions2.click();
	
    	
	}
    public void getnextButton3() {
    	nextButton3.click();
	}
    public void getMedicalCondition() {
    	medicalCondition.click();
	}
    
    public void getNextButton4() {
    	
    	js.executeScript("arguments[0].click();", nextButton4);
    	
	}
    
    public void MobileNo(String Mobile) {
    	enterMobileNo.sendKeys(Mobile);
	}
    public void viewPlan() {
    	viewPlanButton.click();
	}
    
    public void logoClick() {
    	logoClick.click();
	}
    
   
	

}
