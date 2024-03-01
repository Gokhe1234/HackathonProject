package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.TestCase;

public class ExtentReportManager implements ITestListener{
	//UI of the report
	public ExtentSparkReporter sparkReporter;
	//populate common info on the report
	public ExtentReports extent;
	//creating test case entries in the report and update status of the test methods
	public ExtentTest test;
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/TestNgReport.html");
		sparkReporter.config().setDocumentTitle("Travel Insurance Plan for Students Automation Report");
		sparkReporter.config().setReportName("Travel Insurance Plan for Students Automation Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QEA");
		extent.setSystemInfo("Tester Name","Sumit Gokhe");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("Browser Name","Chrome Browser");
		
	}
	public void onTestSuccess(ITestResult result) {
		String path;
		path=TestCase.path;
		test=extent.createTest(result.getName())
				.addScreenCaptureFromPath(path, result.getName());
				
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is: "+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());	
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}