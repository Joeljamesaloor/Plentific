package runner;

import appium.AppiumServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-html-reports/report.html",
                "json:target/cucumber-reports/cucumber.json"
        }

)
public class TestRunner {
    @BeforeClass
    public static void setup() {
        AppiumServer.startServer();
    }

    @AfterClass
    public static void teardown() {

         AppiumServer.stopServer();
    }
}
