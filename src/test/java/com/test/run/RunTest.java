package com.test.run;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
format = {"pretty"},
 features = {
		 "src/test/resources/Feature/test1.feature"
 }
, glue = {"com.web.test.common.steps","com.web.test.jgcrm.steps"},
   dryRun = false
)
public class RunTest {

}
