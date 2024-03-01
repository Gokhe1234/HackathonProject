package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CarInsurancePage;
import pageObject.HealthInsurancePage;
import pageObject.PolicyBazzarPage;
import pageObject.TravelInsurancePage;
import pageObject.TravelPlanPage;
import utilities.ExcelUtility;

public class TravelInsurance {
	public static WebDriver driver;
	
	@Given("user is on the policy bazzer application")
	public void user_is_on_the_policy_bazzer_application() {
	   ChromeOptions option = new ChromeOptions();
	   option.addArguments("--disable-blink-features=AutomationControlled");
	   option.addArguments("--disable-notifications");
	   driver = new ChromeDriver(option);
	   driver.get("https://www.policybazaar.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user clicking travel insurance plan")
	public void user_clicking_travel_insurance_plan() {
		PolicyBazzarPage pbp = new PolicyBazzarPage(driver);
		pbp.travelInsu();
	}

	@Then("user should need to enter all details")
	public void user_should_need_to_enter_all_details() throws Exception {
		TravelInsurancePage tip = new TravelInsurancePage(driver);
		tip.destination();
		tip.getNextButton();
	    tip.getSubmeetbutton();
	    tip.getSearchClick();
		tip.getNextbutton2();
		tip.studentSelect();
		tip.getSelectAgeOption1();
		tip.getAgeOptions1();
		tip.getSelectAgeOption2();
		tip.getAgeOption2();
		tip.getnextButton3();
		tip.getMedicalCondition();
		tip.getNextButton4();
		tip.MobileNo(ExcelUtility.readExcel(0));
		tip.viewPlan();
		TravelPlanPage tp=new TravelPlanPage(driver);
		tp.getStudentPlan();
		tp.getTraveller1();
		tp.getTraveller2();
		tp.tripDurationTime();
		tp.applyButton();
		tp.getSortBy();
		tp.lowHigh();
		tp.getData();
		tp.logoClick();
		
	}
	
	
	@Given("user clicking car insurance plan")
	public void user_clicking_car_insurance_plan() {
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.carInsurance();	   
	}

	
	@When("user should need to enter all car details")
	public void user_should_need_to_enter_all_car_details() throws Exception {
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.buyCar();
		cip.getSearchRto();
		cip.selectCityOption();
		cip.selectCarOption();
		cip.carModelOption();
		cip.fuelTypeOption();
		cip.carVariantOption();
		cip.carVariantMode();
		cip.getName(ExcelUtility.readExcel(1));
		cip.getEmail(ExcelUtility.readExcel(2));
		cip.getMobilNo("9806771209");
		cip.getErrorMessage();

	}

	@Then("user need to find car quote")
	public void user_need_to_find_car_quote() throws Exception {
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.clearEmail();
		cip.correctEmail(ExcelUtility.readExcel(3));

	    
	}
	@Given("user is on the policy bazzer home home page")
	public void user_is_on_the_policy_bazzer_home_home_page() {
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.logoClickBack();
	}

	@When("user clicking health insurance plan")
	public void user_clicking_health_insurance_plan() {
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.getHealthInsurance();
	    
	}

	@When("user should need to enter all health details")
	public void user_should_need_to_enter_all_health_details() throws Exception {
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.getHealthInsurance();
		hip.getContinueBtn();
		hip.getAge();
		hip.getContinueBtn2();
		hip.GetCitySelect();
		hip.getFullName(ExcelUtility.readExcel(4));
		hip.getMobileNumber(ExcelUtility.readExcel(5));
		hip.continueBt3();
		hip.getMedical();
		hip.getInsurance();
		hip.getOfficeInsurance();
		hip.getViewBtn();
	}

	@When("user need to get all health plan")
	public void user_need_to_get_all_health_plan() throws InterruptedException, Exception {
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.allHealthInSu();
		ExcelUtility.excel();
		
	}

	@Then("user need to close the browser")
	public void user_need_to_close_the_browser() throws IOException {
		
		driver.quit();
	    
	}


	
	
	


}
