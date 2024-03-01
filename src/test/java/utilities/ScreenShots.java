package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	
	public static String screenShots(WebDriver driver,String filename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2304085\\eclipse-workspace\\TravelInsurancePlanForStudent3\\screenshots\\"+filename+".png");
		FileUtils.copyFile(src,trg);
		return trg.getAbsolutePath();
	}

}
