package web.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web/features",
        glue = {"web.steps"},
        tags = "@e2e",
        plugin = {
                "pretty",
                "html:build/reports/cucumber-report.html",
                "json:build/reports/cucumber.json"
        },
        monochrome = true,
        publish = true
)
public class E2ETestRunner {
}