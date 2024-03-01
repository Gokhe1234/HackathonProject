package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurancePage extends BasePage{
	public static String CarPlans;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public CarInsurancePage(WebDriver driver) {
		super(driver);
		
	}
	 
	
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")
	WebElement carInsuranceClick;
	
	@FindBy(linkText="Buying a new car? Click here")
	WebElement buyingCar;
	
	@FindBy(xpath="//*[@id=\"searchInput\"]/div/input")
	WebElement searchRto;
	
	@FindBy(xpath="//span[text()='MH35-GONDIA(Maharashtra)']")
	WebElement selectCity;
	
	@FindBy(xpath="//span[@class='tata']")
	WebElement selectCar;
	
	@FindBy(xpath="//b[text()='NEXON']")
	WebElement carModel;
	
	@FindBy(xpath="//b[text()='Petrol']")
	WebElement fuelType;
	
	@FindBy(xpath="//li[text()='Automatic']")
	WebElement carVariant;
	
	@FindBy(xpath="//b[text()='Creative Plus 1.2 Revotron Petrol 6AMT (1199 cc)']")
	WebElement carVariantModel;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"mobileNo\"]")
	WebElement mobilNo;
	
	@FindBy(xpath="//div[@class='msg-error show']")
	public WebElement errorMessage;
	

	@FindBy(xpath="//a[@class='pb-logo']")
	WebElement logoClick2;
	
	
	
	public void carInsurance() {
		carInsuranceClick.click();
	}
	
	public void buyCar() {
		buyingCar.click();
	}
	
	public void getSearchRto() {
		searchRto.click();
	}
	
	public void selectCityOption() {
		selectCity.click();
	}
	
	public void selectCarOption() {
		selectCar.click();
	}
	public void carModelOption() {
		carModel.click();
	}
	
	public void fuelTypeOption() {
		fuelType.click();
	}
	public void carVariantOption() {
		carVariant.click();
	}
	
	public void carVariantMode() {
		carVariantModel.click();
	}
	public void getName(String name1) {
		name.sendKeys(name1);
	}
	public void getEmail(String mail) {
		email.sendKeys(mail);
	}
	public void getMobilNo(String mobil) {
		mobilNo.sendKeys(mobil);
	}
	
	public void getErrorMessage() {
		System.out.println("---Capture the error message--- ");
		System.out.println( errorMessage.getText());
	}
	
	public void clearEmail() throws InterruptedException {
		Thread.sleep(2000);
		email.clear();
	}
	public void correctEmail(String mail1) {
		email.sendKeys(mail1);
	}
	
	public void logoClickBack() {
		logoClick2.click();
	}


}
