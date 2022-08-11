package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/FeatureFile/Test1.feature" , glue="StepDef", dryRun=false, monochrome=true, plugin="pretty" , publish=true)


public class Test_Runner {

	
}
