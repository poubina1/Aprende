package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		        features ="src/test/java/features/tests.feature",
		        glue = "steps",
		        plugin = {},
		        monochrome = true
                )

public class testrunner {
   
}
