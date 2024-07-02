package testRun;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {".\\Features"},
        features = {"@target/rerun.txt"},

        glue = {"stepsDefinitions", "hooks"},
        plugin = {
                "pretty", "html:reports/myreports.html",
                "rerun:target/rerun.txt"
        },
        monochrome = true,

//        tags = "@master and @sanity"
        tags = "@master"
//        tags = "@sanity"

        )

public class Runner {

}
