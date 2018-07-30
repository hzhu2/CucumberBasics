package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/* using junit version
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, glue = "Steps")
public class TestRunner {
}*/

@CucumberOptions(features = {"src/test/java/features"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests{

}