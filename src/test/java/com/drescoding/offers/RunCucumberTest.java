package com.drescoding.offers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
    features = {"src/test/resources"},
    glue = {"com.drescoding.offers.steps"})
public class RunCucumberTest {
}

