package Listener;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions"},
        tags = "@test",
       // monochrome = false,
        //dryRun = false,
        plugin = {"pretty","html:target/cucumber-reports/html-report.html",
                "json:target/cucumber-reports/json-report.json"}
)

public class TestRunner {
}
