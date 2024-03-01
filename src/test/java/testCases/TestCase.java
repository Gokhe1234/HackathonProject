package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CarInsurancePage;
import pageObject.HealthInsurancePage;
import pageObject.PolicyBazzarPage;
import pageObject.TravelInsurancePage;
import pageObject.TravelPlanPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.ScreenShots;

public class TestCase extends BaseClass {
	
	
public static String path;

    @Test(priority=1)
    public void validatTravelInsunce() throws IOException {
    	logger.info("**** starting validatTravelInsuncePage  *****");
    	PolicyBazzarPage pbp = new PolicyBazzarPage(driver);
    	path=ScreenShots.screenShots(driver, "Policy Bazzar Page");
 		pbp.travelInsu();
 		logger.info("**** Ending validatTravelInsuncePage  *****");
    }

	@Test(priority=2)
	public void travelDetails() throws Exception 
	{
		
		logger.info("**** Starting TravelDetails  *****");
		
		logger.info("Opening of Travel Insurance Page ");
		TravelInsurancePage tip = new TravelInsurancePage(driver);
		tip.destination();
        logger.info("Entering customer details.. ");
        tip.getNextButton();
        tip.getSubmeetbutton();
		logger.info("clicked on continue..");
		tip.getSearchClick();
		tip.getNextbutton2();
	  	path=ScreenShots.screenShots(driver, "Travel Detail");
		logger.info("**** ending TravelDetails  *****");
	}
	
	@Test(priority=3)
	public void studentDataVerify() throws Exception {
		logger.info("**** Starting Student Data Verify  *****");
		TravelInsurancePage tip = new TravelInsurancePage(driver);
		tip.studentSelect();
		logger.info("Select Student...");
		tip.getSelectAgeOption1();
		String age="22 years";
		String actualAge=tip.allAgeOptions1.getText();
		Assert.assertEquals(age, actualAge);
		tip.getAgeOptions1();
		tip.getSelectAgeOption2();
		tip.getAgeOption2();
		tip.getnextButton3();
		logger.info("clicked on continue..");
		tip.getMedicalCondition();
		logger.info("Medical Condition..");
		tip.getNextButton4();
		tip.MobileNo(ExcelUtility.readExcel(0));
		tip.viewPlan();
		path=ScreenShots.screenShots(driver, "View Plans");

		logger.info("**** Ending Student Data Verify  *****");
		
	}
	@Test(priority=4)
	public void dataSort() throws Exception {
		logger.info("**** starting Data Sort  *****");
		TravelPlanPage tp=new TravelPlanPage(driver);
		tp.getStudentPlan();
		logger.info("Entering Student details.. ");
		tp.getTraveller1();
		tp.getTraveller2();
		tp.tripDurationTime();
		tp.applyButton();
		logger.info("clicked on continue..");
		tp.getSortBy();
		tp.lowHigh();
		path=ScreenShots.screenShots(driver, "Sorted Student plans");
		logger.info("**** Ending Data Sort  *****");
		
	}
	@Test(priority=5)	
	public void StudentPlanDetails() throws IOException {
		logger.info("**** starting Student Plan Detail  *****");
		TravelPlanPage tp=new TravelPlanPage(driver);
		tp.getData();
		path=ScreenShots.screenShots(driver, "All data");
		logger.info("All student first 3 plan..");
		tp.logoClick();
		logger.info("**** Ending Student Plan Detail *****");
	}
		
	@Test(priority=6)
	public void CarInsurenceDetails() throws Exception {
		
		logger.info("**** starting Car Insurance Details  *****");
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.carInsurance();
		logger.info("Open of Car Insurance Page ");
		cip.buyCar();
		cip.getSearchRto();
		cip.selectCityOption();
		cip.selectCarOption();
		path=ScreenShots.screenShots(driver, "Car  Options");
		cip.carModelOption();
		cip.fuelTypeOption();
		cip.carVariantOption();
		cip.carVariantMode();
		logger.info("Filled all car Datail ");
		logger.info("**** Ending Car Insurence Details  *****");
		
	}
		
	@Test(priority=7)	
	public void errorMessageValidate() throws Exception {
		logger.info("**** starting Error Message Validate  *****");
		CarInsurancePage cip=new CarInsurancePage(driver);
        cip.getName(ExcelUtility.readExcel(1));
		cip.getEmail(ExcelUtility.readExcel(2));
		cip.getMobilNo("9806771209");
		Assert.assertEquals(cip.errorMessage.getText(), "Please enter a valid e-mail ID.");
		cip.getErrorMessage();
        path=ScreenShots.screenShots(driver, "Error Message");
		
		logger.info("Capture Message.. ");
		logger.info("**** Ending Error Message Validate  *****");
		
	}
	
	@Test(priority=8)
	public void correctDatailValidation() throws Exception {
		logger.info("**** starting Correct Detail Validation  *****");
		CarInsurancePage cip=new CarInsurancePage(driver);
		cip.clearEmail();
		cip.correctEmail(ExcelUtility.readExcel(3));
		path=ScreenShots.screenShots(driver, "positive test cases");
		cip.logoClickBack();
		logger.info("**** Ending Correct Datail Validation  *****");
	}

	@Test(priority=9)
	public void HealthInsurancePlan() throws Exception {
		logger.info("**** starting Health Insurance Plan  *****");
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.getHealthInsurance();
		hip.getContinueBtn();
		hip.getAge();
		hip.getContinueBtn2();
		hip.GetCitySelect();
		hip.getFullName(ExcelUtility.readExcel(4));
		hip.getMobileNumber(ExcelUtility.readExcel(5));
		path=ScreenShots.screenShots(driver, "Health Insurance Page");
		hip.continueBt3();
		hip.getMedical();
		hip.getInsurance();
		hip.getOfficeInsurance();
		hip.getViewBtn();
		logger.info("**** Ending Health Insurance Plan  *****");
	}
	
	@Test(priority=10)
	public void allHealthInsurance() throws InterruptedException, Exception
	
	{
		logger.info("**** starting All Health Insurance  *****");
		HealthInsurancePage hip=new HealthInsurancePage(driver);
		hip.allHealthInSu();
		path=ScreenShots.screenShots(driver, "Health Insurance package");
		logger.info("**** Ending All Health Insurance  *****");
		
		ExcelUtility.excel();
	}
			

}
