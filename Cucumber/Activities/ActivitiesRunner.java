package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags="@activity2",
        plugin = {"html: test-reports","json: test-reports/json-report.json"},
        monochrome = true
)

public class ActivitiesRunner {
}
