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
        glue ={"org/nagarro/stepDefinations/web"},
        tags = "@E2EJquery",
        dryRun = false, monochrome = true


)

public class TestRunner_WEB {
}
