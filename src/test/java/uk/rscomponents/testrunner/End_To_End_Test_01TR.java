package uk.rscomponents.testrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "./src/test/resources/features/End_To_End_Test_01.feature",
        glue = {"uk.rscomponents.stepdefinitions"},
        dryRun = false

//        tags = {"@Scenario_01"}
//        ,tags = {"@Scenario_02"}
//        ,tags = {"@Scenario_03"}
        ,tags = {"@Scenario_04"}
)

public class End_To_End_Test_01TR {
}
