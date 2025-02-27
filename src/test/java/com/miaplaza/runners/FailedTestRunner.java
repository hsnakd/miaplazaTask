package com.miaplaza.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "rerun:target/rerun.txt",
        },
        features = "@target/rerun.txt",
        glue = "com/miaplaza/step_definitions"

)
public class FailedTestRunner {
}
