package registrationForm.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "pretty",
                //json report
                "json:target/cucumber.json",
                //html report
                "html:target/default-html-reports.html",
        },
        features = "src/test/resources/features",
        glue = "registrationForm/stepDefinitions",
        dryRun = false,
        tags = "@validData"

)
public class CukesRunner {
}