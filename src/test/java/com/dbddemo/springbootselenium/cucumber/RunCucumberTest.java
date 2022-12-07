package com.dbddemo.springbootselenium.cucumber;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import io.cucumber.junit.platform.engine.Constants;
import io.cucumber.testng.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/java/com/dbddemo/springbootselenium/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.dbddemo.springbootselenium.cucumber")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@negative")
@CucumberOptions(
        features = "src/test/java/com/dbddemo/springbootselenium/cucumber/features",
        glue= {"stepDefinitions"},
        plugin = { "pretty", "html:./target/cucumber-reports" },
        monochrome = true
)
public class RunCucumberTest {
}