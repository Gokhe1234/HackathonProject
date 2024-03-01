package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//featureFiles/AtravelInsurance.feature",
		                   ".//featureFiles/carInsurance.feature",
		                   ".//featureFiles/healthInsurance.feature"},
                glue ="stepDefinitions",
plugin= {"pretty","html:reports//cucumberReport.html"}
		)
public class TestRun {
	
	

}
