package org.nagarro.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        plugin = {
                "pretty",
                "html:build/reports/CucumberSpecificReport/Cucumbertestreport.html"
                ,"json:build/reports/CucumberSpecificReport/CucumberJson/cucumber.json"
        },
        features = {"src/main/resources/features/web"},
        glue ={"org/nagarro/stepDefinations/api"},
        tags = "@E2EAPISuite",
        dryRun = false, monochrome = true


)
public class TestRunner_API {
}
