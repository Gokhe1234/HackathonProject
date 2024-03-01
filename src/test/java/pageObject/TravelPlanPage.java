package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TravelPlanPage extends BasePage {

	public TravelPlanPage(WebDriver driver) {
		super(driver);
		
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public static List<String> prices=new ArrayList<String>();
	public static List<String> name=new ArrayList<String>();
	public static List<String> company=new ArrayList<String>();
	
	@FindBy(xpath="//*[@id=\"studentTrip\"]")
	WebElement studentPlan;
	
	@FindBy(xpath="//*[@id=\"Traveller_1\"]")
	WebElement traveller1;
	
	@FindBy(xpath="//*[@id=\"Traveller_2\"]")
	WebElement traveller2;
	
	@FindBy(xpath="//*[@id=\"feet\"]")
	WebElement tripDuration;
	
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/aside/section[1]/details/summary/p")
	WebElement sortBy;
	
	@FindBy(xpath="//label[contains(text(),'Premium low to high')]")
	WebElement lowToHigh;
	
	@FindBy(xpath="//div[@class='quotesCard__quotesListWrap']/div/div/div/p[1]")
	List<WebElement> companyName;
	
	@FindBy(xpath="//div[@class='quotesCard__quotesListWrap']/div/div/div/p[2]")
	List<WebElement> packageName;
	
	@FindBy(xpath="//div[@class='quotesCard__quotesListWrap']/div/div[3]/p/span")
	List<WebElement> price;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/article/h1/a")
	 WebElement logoClick;
	
	public void getStudentPlan() throws InterruptedException {
		
		js.executeScript("arguments[0].click();", studentPlan);
		Thread.sleep(2000);
	}
	public void getTraveller1() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", traveller1);

	}
	public void getTraveller2() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", traveller2);

		
	}
	
	public void tripDurationTime() {
		Select se=new Select(tripDuration);
		se.selectByVisibleText("30 Days");
	
	}
	public void applyButton() {
		js.executeScript("arguments[0].click();", apply);
		
	}
	
	
	public void getSortBy() {
	    sortBy.click();
	}
	
	public void lowHigh() {
	    lowToHigh.click();
	 }
	
	public void logoClick() {
    	logoClick.click();
	}
	
	
	public void getData() throws IOException {
		 
		 
		 for(int i=0;i<3;i++) {
			 company.add(companyName.get(i).getText());
			 name.add(packageName.get(i).getText());
			 prices.add(price.get(i).getText());
		 }
		 System.out.println("Company Name      Package Name      Price");
		 for(int j=0;j<3;j++){
		 System.out.println(company.get(j)+"---"+name.get(j)+"---"+prices.get(j));
		 }
		 
		 
	}
	

}
